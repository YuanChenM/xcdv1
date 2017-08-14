package com.msk.batch.so.logic;

import com.msk.batch.so.bean.*;
import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.SlPdArtno;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoSalesRanking;
import com.msk.core.exception.BusinessException;
import com.msk.core.file.WmsFtpUtils;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.Order;
import com.msk.so.bean.ModifyStatusParam;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.OrderStatusLogic;
import com.msk.so.logic.StockLogic;
import com.msk.so.orderstatus.OrderStatusContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.msk.core.file.xml.XmlWrite;
import com.msk.core.file.FileUtils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.File;

/**
 * *BSO152403Logic
 * *@author xu_wei
 * *@version 1.0
 */
@Service
public class BSO152403Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152403Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yuan_chen
     */
    interface SqlId {
        static final String SQLID_FIND_ORDER_LIST = "findOrderList";
        static final String SQLID_FIND_ORDER_DETAIL = "findOrderDetailList";
        static final String SQLID_UPDATE_DETAIL_ORDER_STATUS = "updateDetailOrderStatus";
        static final String SQLID_UPDATE_ORDER_DETAIL_AVAILABILITY_STATUS = "updateOrderDetailAvailabilityStatus";
        static final String SQL_ID_SAVE_SHIP_INFO = "saveShipInfo";
        static final String SQL_ID_GET_MAX_ORDER_SHIP_CODE = "getMaxOrderShipCode";
        static final String SQL_ID_MODIFY_SUPP_SHIP_ID = "modifySuppShipId";
        static final String SQL_ID_MODIFY_SUPP_SKU = "modifySuppSku";
        static final String SQL_ID_FIND_CHILD_ORDER_ID = "findChildOrderId";
        static final String SQL_ID_GET_SHIP_COUNT_BY_ORDER_ID = "getShipCountByOrderId";
    }

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderStatusLogic orderStatusLogic;

    @Autowired
    private OrderLogic orderLogic;

    /**
     * (non-Javadoc)
     *
     * @see com.msk.core.base.BaseLogic#setBaseDao(com.msk.core.base.BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 根据订单信息进行分单操作
     *
     * @param bso152403Param param
     */
    @Transactional
    public void findOrderList(BSO152403Param bso152403Param) {
        logger.debug("WMS生成配送单开始");
        //** CONFIRM:已确认 */
        bso152403Param.setOrderStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
        //买手囤货订单
        bso152403Param.setOrderType1(OrderConst.OrderType.BUYER_STOCKPILING_ORDER);
        //第三方买手囤货订单
        bso152403Param.setOrderType2(OrderConst.OrderType.THIRD_BUYER_ORDER);
        bso152403Param.setNowDate(DateTimeUtil.getCustomerDate());

        List<BSO152403Result> results = super.findList(SqlId.SQLID_FIND_ORDER_LIST, bso152403Param);

        if (!CollectionUtils.isEmpty(results)) {
            for (BSO152403Result result : results) {
                // Modify for bug#1583 at 2016/07/29 by wang_jianzhou Start.
                bso152403Param.setOrderId(result.getOrderId());
                if(continueShip(result)){
                    try {
                        createXml(result);
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                        continue;
                    }
                }
                // Modify for bug#1583 at 2016/07/29 by wang_jianzhou end.
            }
        }
    }

    /**
     * 更新订单状态
     *
     * @param bso152403Result bso152403Result
     */
    @Transactional
    private void updateOrderStatus(BSO152403Result bso152403Result) {
        logger.debug("更新订单状态");
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setOrderId(bso152403Result.getOrderId());
        modifyStatusParam.setUpdId("admin");
        orderStatusLogic.modifyOrderStatusByOrderId(modifyStatusParam);
    }

    /**
     * 生成xml并且更新状态为待发货
     *
     * @param bso152403Result bso152403Result
     */
    @Transactional
    private void createXml(BSO152403Result bso152403Result) {
        BSO152403ReceiverInfo receiver = new BSO152403ReceiverInfo();
        receiver.setReceiverName(bso152403Result.getReceiverName());
        receiver.setReceiverTel(bso152403Result.getReceiverTel());
        receiver.setReceiverWeixin(bso152403Result.getReceiverWeixin());
        receiver.setReceiverQq(bso152403Result.getReceiverQq());
        receiver.setReceiverMail(bso152403Result.getReceiverMail());
        receiver.setReceiverProvince(bso152403Result.getReceiverProvince());
        receiver.setReceiverCity(bso152403Result.getReceiverCity());
        receiver.setReceiverDistrict(bso152403Result.getReceiverDistrict());
        receiver.setReceiverAddr(bso152403Result.getReceiverAddr());
        receiver.setReceiverAddr2(bso152403Result.getReceiverAddr2());
        receiver.setReceiverAddrKey(bso152403Result.getReceiverAddrKey());
        if (bso152403Result.getReceiverDeType() == null) {
            receiver.setReceiverDeType("");
        } else {
            receiver.setReceiverDeType(bso152403Result.getReceiverDeType());
        }

        bso152403Result.setReceiver(receiver);

        BSO152403Param bso152403Param = new BSO152403Param();
        bso152403Param.setOrderId(bso152403Result.getOrderId());
        bso152403Param.setOrderStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
        bso152403Param.setNowDate(DateTimeUtil.getCustomerDate());
        List<BSO152403DetailResult> productDetailList = super.findList(SqlId.SQLID_FIND_ORDER_DETAIL, bso152403Param);

        if (CollectionUtils.isEmpty(productDetailList)) {
            throw new BusinessException("没有对应的产品信息，请检查！！！");
        }

        saveShipInfo(bso152403Result);

        getDetail(bso152403Result, productDetailList);

        List<BSO152403Result> xmlList = new ArrayList<BSO152403Result>();
        bso152403Result.setCrtId(null);
        bso152403Result.setCrtTime(null);
        bso152403Result.setUpdId(null);
        bso152403Result.setUpdTime(null);
        if(null != bso152403Result.getPayAmount() && bso152403Result.getPayAmount().compareTo(BigDecimal.ZERO) > NumberConst.IntDef.INT_ZERO){
            bso152403Result.setPaymentType(NumberConst.IntDef.INT_THREE);
        }
        xmlList.add(bso152403Result);
        BSO152403XMLTemplate xmlTemplate = new BSO152403XMLTemplate();
        xmlTemplate.setData(xmlList);

        XmlWrite<BSO152403Result> xmlWrite = new XmlWrite<BSO152403Result>(xmlTemplate);
        InputStream inputStream = xmlWrite.createListTemplateXml(BSO152403XMLTemplate.class);
        boolean result = WmsFtpUtils.uploadXml("/", "SO" + bso152403Result.getOrderCode() + ".xml", inputStream);
        if (logger.isDebugEnabled()) {
            if (result) {
                logger.debug(bso152403Result.getOrderCode() + ".xml" + "文件上传成功");
            } else {
                logger.debug(bso152403Result.getOrderCode() + ".xml" + "文件上传失败");
            }
        }
    }

    /**
     * 插入发货单主表数据并且更新供货明细表的发货单号
     *
     * @param bso152403Result
     */
    @Transactional
    public void saveShipInfo(BSO152403Result bso152403Result) {
        bso152403Result.setNowDate(DateTimeUtil.getCustomerDate());
        bso152403Result.setShipId(commonLogic.maxId("so_order_ship", "SHIP_ID"));
        bso152403Result.setShipCode(getShipCode(bso152403Result));
        bso152403Result.setShipStatus(StatusConst.OrderShipStatusDef.WAIT_SEND);
        bso152403Result.setCrtTime(DateTimeUtil.getCustomerDate());
        bso152403Result.setCrtId("admin");
        bso152403Result.setOrderStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
        bso152403Result.setChildOrderId(getChildOrderId(bso152403Result));

        this.save(SqlId.SQL_ID_SAVE_SHIP_INFO, bso152403Result);
        this.modify(SqlId.SQL_ID_MODIFY_SUPP_SHIP_ID, bso152403Result);
    }

    /**
     * 得到发货单的货号
     *
     * @param bso152403Result
     * @return
     */
    @Transactional
    public String getShipCode(BSO152403Result bso152403Result) {

        BaseParam param = new BaseParam();
        param.setFilter("orderId", bso152403Result.getOrderId().toString());
        String maxShipCode = (String) super.findObject(SqlId.SQL_ID_GET_MAX_ORDER_SHIP_CODE, param);

        Integer shipCount = StringUtil.isEmpty(maxShipCode) ?
                NumberConst.IntDef.INT_ONE :
                Integer.valueOf(maxShipCode.split(StringConst.MIDDLE_LINE)[maxShipCode.split(StringConst.MIDDLE_LINE).length - 1]) + NumberConst.IntDef.INT_ONE;

        return bso152403Result.getOrderCode() + StringConst.MIDDLE_LINE + shipCount;
    }

    /**
     * 如发货单含子订单数据，获取子订单id
     *
     * @param bso152403Result
     * @return
     */
    @Transactional
    public Long getChildOrderId(BSO152403Result bso152403Result) {
        SoOrder child = super.findOne(SqlId.SQL_ID_FIND_CHILD_ORDER_ID, bso152403Result);
        if (child != null) {
            return child.getOrderId();
        } else {
            return null;
        }
    }

    /**
     * 更新订单明细状态
     *
     * @param bso152403Result
     * @return
     */
    @Transactional
    private int updateDetailOrderStatus(BSO152403Result bso152403Result) {
        logger.debug("更新明细订单状态");
        bso152403Result.setOrderStatus(StatusConst.OrderDetailStatusDef.WAIT_SEND);
        bso152403Result.setUpdTime(DateTimeUtil.getCustomerDate());
        bso152403Result.setUpdId("admin");
        return super.modify(SqlId.SQLID_UPDATE_DETAIL_ORDER_STATUS, bso152403Result);
    }

    /**
     * 更新订单明细供应商状态
     *
     * @param bso152403Result
     * @return
     */
    @Transactional
    private int updateOrderDetailAvailabilityStatus(BSO152403Result bso152403Result) {
        logger.debug("更新明细订单状态");
        bso152403Result.setOrderStatus(StatusConst.OrderDetailAvailabilityStatusDef.WAIT_SEND);
        bso152403Result.setUpdTime(DateTimeUtil.getCustomerDate());
        bso152403Result.setUpdId("admin");

        return super.modify(SqlId.SQLID_UPDATE_ORDER_DETAIL_AVAILABILITY_STATUS, bso152403Result);
    }

    /**
     * 查询明细定单并更新明细状态和供应商明细状态
     */
    @Transactional
    private void getDetail(BSO152403Result bso152403Result, List<BSO152403DetailResult> productDetailList) {
        for (BSO152403DetailResult productDetail : productDetailList) {
            productDetail.setDistrictCode(bso152403Result.getDistrictCode());
            productDetail.setSellerCode(bso152403Result.getSellerCode());
            productDetail.setOrderSource(bso152403Result.getOrderSource().toString());
            productDetail.setUnit("CASE");
            productDetail.setSku(getSkuCode(productDetail, bso152403Result));
            this.modify(SqlId.SQL_ID_MODIFY_SUPP_SKU, productDetail);
        }
        bso152403Result.setProductDetailList(productDetailList);

        //要求到货日期
        bso152403Result.setStrForecastReceiveTime(
                DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                        bso152403Result.getForecastReceiveTime()));
        // 计划发货日期
        bso152403Result.setStrForecastSendTime(
                DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                        bso152403Result.getForecastSendTime()));
        //生成配送单编码
        bso152403Result.setDeliveryOrderCode(orderLogic.getDeliveryCode());
        // 所有订单详细信息处理成果,更新订单状态为待发货

        updateDetailOrderStatus(bso152403Result);
        updateOrderDetailAvailabilityStatus(bso152403Result);
        updateOrderStatus(bso152403Result);
        bso152403Result.setVer(bso152403Result.getVer() + NumberConst.IntDef.INT_ONE);
    }

    /**
     * 得到货号
     *
     * @param productDetail
     * @param bso152403Result
     * @return
     */
    public String getSkuCode(BSO152403DetailResult productDetail, BSO152403Result bso152403Result) {
        //TODO
        //平台类型： 1：神农客 2：美侍客
        String salesPlatform = null;
        String slCode = null;
        if (bso152403Result.getOrderSource() == NumberConst.IntDef.INT_TWO) {
            salesPlatform = "2";
            //卖家编码
            slCode = bso152403Result.getSellerCode();
        } else {

            salesPlatform = "1";
            //供应商编码
            slCode = productDetail.getSupplierCode();
        }
        SlPdArtno slpdartno = orderLogic.getSlPdArtNo(slCode, productDetail.getPdCode(), salesPlatform);

        if (slpdartno == null
                || StringUtil.isEmpty(slpdartno.getSlCodeDis())
                || StringUtil.isEmpty(slpdartno.getSlPdArtno())) {
            // Modify for bug#1583 at 2016/07/29 by wang_jianzhou Start.
            return "";
            // Modify for bug#1583 at 2016/07/29 by wang_jianzhou end.
        }

        return slpdartno.getSlCodeDis() + slpdartno.getSlPdArtno();
    }


    /**
     * 判断订单是否继续发货
     *
     * @param result
     * @return
     */
    @Transactional
    private boolean continueShip(BSO152403Result result){
        BSO152403Param bso152403Param = new BSO152403Param();
        bso152403Param.setOrderId(result.getOrderId());
        int shipCount = super.getCount(SqlId.SQL_ID_GET_SHIP_COUNT_BY_ORDER_ID,bso152403Param);
        if(shipCount > NumberConst.IntDef.INT_ZERO){
            //是否继续发货
            if(null != result.getShipSubsequent() && result.getShipSubsequent() == NumberConst.IntDef.INT_ONE){
                return true;
            }else {
                return false;
            }
        }else {
            return true;
        }
    }
}
