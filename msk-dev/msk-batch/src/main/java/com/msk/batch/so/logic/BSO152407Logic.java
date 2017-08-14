package com.msk.batch.so.logic;

import com.msk.batch.so.bean.*;
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
import com.msk.core.exception.BusinessException;
import com.msk.core.file.WmsFtpUtils;
import com.msk.core.file.xml.XmlWrite;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ModifyStatusParam;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.OrderStatusLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * *BSO152407Logic
 * *@author xu_wei
 * *@version 1.0
 */
@Service
public class BSO152407Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152407Logic.class);

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
     * @param bso152407Param param
     */
    @Transactional
    public void findOrderList(BSO152407Param bso152407Param) {
        logger.debug("WMS生成配送单开始");
        //** CONFIRM:已确认 */
        bso152407Param.setOrderStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
        //买手囤货订单
        bso152407Param.setOrderType1(OrderConst.OrderType.BUYER_STOCKPILING_ORDER);
        //第三方买手囤货订单
        bso152407Param.setOrderType2(OrderConst.OrderType.THIRD_BUYER_ORDER);
        bso152407Param.setNowDate(DateTimeUtil.getCustomerDate());

        List<BSO152407Result> results = super.findList(SqlId.SQLID_FIND_ORDER_LIST, bso152407Param);

        if (!CollectionUtils.isEmpty(results)) {
            for (BSO152407Result result : results) {
                // Modify for bug#1583 at 2016/07/29 by wang_jianzhou Start.
                bso152407Param.setOrderId(result.getOrderId());
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
     * @param bso152407Result bso152407Result
     */
    @Transactional
    private void updateOrderStatus(BSO152407Result bso152407Result) {
        logger.debug("更新订单状态");
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setOrderId(bso152407Result.getOrderId());
        modifyStatusParam.setUpdId("admin");
        orderStatusLogic.modifyOrderStatusByOrderId(modifyStatusParam);
    }

    /**
     * 生成xml并且更新状态为待发货
     *
     * @param bso152407Result bso152407Result
     */
    @Transactional
    private void createXml(BSO152407Result bso152407Result) {
        BSO152407Param bso152407Param = new BSO152407Param();
        bso152407Param.setOrderId(bso152407Result.getOrderId());
        bso152407Param.setOrderStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
        bso152407Param.setNowDate(DateTimeUtil.getCustomerDate());
        List<BSO152407DetailResult> productDetailList = super.findList(SqlId.SQLID_FIND_ORDER_DETAIL, bso152407Param);

        if (CollectionUtils.isEmpty(productDetailList)) {
            throw new BusinessException("没有对应的产品信息，请检查！！！");
        }

        saveShipInfo(bso152407Result);

        getDetail(bso152407Result, productDetailList);
    }

    /**
     * 插入发货单主表数据并且更新供货明细表的发货单号
     *
     * @param bso152407Result
     */
    @Transactional
    public void saveShipInfo(BSO152407Result bso152407Result) {
        bso152407Result.setNowDate(DateTimeUtil.getCustomerDate());
        bso152407Result.setShipId(commonLogic.maxId("so_order_ship", "SHIP_ID"));
        bso152407Result.setShipCode(getShipCode(bso152407Result));
        bso152407Result.setShipStatus(StatusConst.OrderShipStatusDef.WAIT_WH);
        bso152407Result.setCrtTime(DateTimeUtil.getCustomerDate());
        bso152407Result.setCrtId("admin");
        bso152407Result.setOrderStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
        bso152407Result.setChildOrderId(getChildOrderId(bso152407Result));

        this.save(SqlId.SQL_ID_SAVE_SHIP_INFO, bso152407Result);
        this.modify(SqlId.SQL_ID_MODIFY_SUPP_SHIP_ID, bso152407Result);
    }

    /**
     * 得到发货单的货号
     *
     * @param bso152407Result
     * @return
     */
    @Transactional
    public String getShipCode(BSO152407Result bso152407Result) {

        BaseParam param = new BaseParam();
        param.setFilter("orderId", bso152407Result.getOrderId().toString());
        String maxShipCode = (String) super.findObject(SqlId.SQL_ID_GET_MAX_ORDER_SHIP_CODE, param);

        Integer shipCount = StringUtil.isEmpty(maxShipCode) ?
                NumberConst.IntDef.INT_ONE :
                Integer.valueOf(maxShipCode.split(StringConst.MIDDLE_LINE)[maxShipCode.split(StringConst.MIDDLE_LINE).length - 1]) + NumberConst.IntDef.INT_ONE;

        return bso152407Result.getOrderCode() + StringConst.MIDDLE_LINE + shipCount;
    }

    /**
     * 如发货单含子订单数据，获取子订单id
     *
     * @param bso152407Result
     * @return
     */
    @Transactional
    public Long getChildOrderId(BSO152407Result bso152407Result) {
        SoOrder child = super.findOne(SqlId.SQL_ID_FIND_CHILD_ORDER_ID, bso152407Result);
        if (child != null) {
            return child.getOrderId();
        } else {
            return null;
        }
    }

    /**
     * 更新订单明细状态
     *
     * @param bso152407Result
     * @return
     */
    @Transactional
    private int updateDetailOrderStatus(BSO152407Result bso152407Result) {
        logger.debug("更新明细订单状态");
        bso152407Result.setOrderStatus(StatusConst.OrderDetailStatusDef.WAIT_SEND);
        bso152407Result.setUpdTime(DateTimeUtil.getCustomerDate());
        bso152407Result.setUpdId("admin");
        return super.modify(SqlId.SQLID_UPDATE_DETAIL_ORDER_STATUS, bso152407Result);
    }

    /**
     * 更新订单明细供应商状态
     *
     * @param bso152407Result
     * @return
     */
    @Transactional
    private int updateOrderDetailAvailabilityStatus(BSO152407Result bso152407Result) {
        logger.debug("更新明细订单状态");
        bso152407Result.setOrderStatus(StatusConst.OrderDetailAvailabilityStatusDef.WAIT_SEND);
        bso152407Result.setUpdTime(DateTimeUtil.getCustomerDate());
        bso152407Result.setUpdId("admin");

        return super.modify(SqlId.SQLID_UPDATE_ORDER_DETAIL_AVAILABILITY_STATUS, bso152407Result);
    }

    /**
     * 查询明细定单并更新明细状态和供应商明细状态
     */
    @Transactional
    private void getDetail(BSO152407Result bso152407Result, List<BSO152407DetailResult> productDetailList) {
        for (BSO152407DetailResult productDetail : productDetailList) {
            productDetail.setDistrictCode(bso152407Result.getDistrictCode());
            productDetail.setSellerCode(bso152407Result.getSellerCode());
            productDetail.setOrderSource(bso152407Result.getOrderSource().toString());
            productDetail.setUnit("CASE");
            productDetail.setSku(getSkuCode(productDetail, bso152407Result));
            this.modify(SqlId.SQL_ID_MODIFY_SUPP_SKU, productDetail);
        }
        bso152407Result.setProductDetailList(productDetailList);

        //要求到货日期
        bso152407Result.setStrForecastReceiveTime(
                DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                        bso152407Result.getForecastReceiveTime()));
        // 计划发货日期
        bso152407Result.setStrForecastSendTime(
                DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                        bso152407Result.getForecastSendTime()));
        //生成配送单编码
        bso152407Result.setDeliveryOrderCode(orderLogic.getDeliveryCode());
        // 所有订单详细信息处理成果,更新订单状态为待发货

        updateDetailOrderStatus(bso152407Result);
        updateOrderDetailAvailabilityStatus(bso152407Result);
        updateOrderStatus(bso152407Result);
        bso152407Result.setVer(bso152407Result.getVer() + NumberConst.IntDef.INT_ONE);
    }

    /**
     * 得到货号
     *
     * @param productDetail
     * @param bso152407Result
     * @return
     */
    public String getSkuCode(BSO152407DetailResult productDetail, BSO152407Result bso152407Result) {
        //TODO
        //平台类型： 1：神农客 2：美侍客
        String salesPlatform = null;
        String slCode = null;
        if (bso152407Result.getOrderSource() == NumberConst.IntDef.INT_TWO) {
            salesPlatform = "2";
            //卖家编码
            slCode = bso152407Result.getSellerCode();
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
    private boolean continueShip(BSO152407Result result){
        BSO152407Param bso152407Param = new BSO152407Param();
        bso152407Param.setOrderId(result.getOrderId());
        int shipCount = super.getCount(SqlId.SQL_ID_GET_SHIP_COUNT_BY_ORDER_ID,bso152407Param);
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
