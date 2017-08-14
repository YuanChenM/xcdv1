package com.msk.so.logic;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.utils.RsClientUtil;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.so.bean.*;
import com.msk.so.bean.order.OrderDetailAndSuppInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 收货
 * Created by zhang_qiang1 on 2016/11/7.
 */
@Service
public class ISO251413partReceiptLogic extends BaseLogic {

    @Autowired
    private OrderLogic orderLogic;


    @Autowired
    private RsClientUtil rsClientUtil;
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251413partReceiptLogic.class);


    /**
     * 部分收货
     *
     * @param param
     */
    @Transactional
    public void doPartReceipt(ISO251413RsParam param) {
        SoOrderShip soOrderShip = super.findOne(SqlId.SQL_ID_GET_ORDER_SHIP_INFO_RECEIPT, param);
        if (soOrderShip == null) {
            throw new BusinessException("该发货单状态不对！");
        }
        soOrderShip.setCrtId(param.getUpdId());
        param.setOrderCode(soOrderShip.getOrderCode());
        this.dealReceiptListInfo(param);  //部分收货具体处理流程
    }


    /**
     * 根据调用收货接口中的配送单信息处理
     *
     * @param param
     */
    @Transactional
    public void dealReceiptListInfo(ISO251413RsParam param) {
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        // 资金池接口参数
        List<SoCpSelCharging> cpParam = new ArrayList<>();
        for (ISO251413OrderShipInfoRsParam orderShipInfo : shipList) {
            List<ISO251413OrderShipProductRsParam> productList = orderShipInfo.getProductList();
            if (CollectionUtils.isEmpty(productList)) {
                throw new BusinessException("产品数据不能为空");
            }
            for (ISO251413OrderShipProductRsParam newList : productList) {
                BigDecimal receiveQty = newList.getReceiveQty();
                if (receiveQty != null && DecimalUtil.isGreater(receiveQty, new BigDecimal(0))) {
                    newList.setUpdId(param.getUpdId());
                    newList.setCrtTime(DateTimeUtil.parseDate(orderShipInfo.getActualReceiveDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
                    newList.setUpdTime(DateTimeUtil.getCustomerDate());
                }
            }
            this.getReceiptListAndModifyOrderInfo(productList, param); //得到配送明细数据并且更新订单相关的明细数据
            //更新实际到货时间
            SoDeliver soDeliver = new SoDeliver();
            soDeliver.setDeliverCode(orderShipInfo.getDeliverCode());
            soDeliver.setActualReceiveDate(DateTimeUtil.parseDate(orderShipInfo.getActualReceiveDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
            soDeliver.setOrderId(param.getOrderId());
            soDeliver.setShipId(param.getShipId());
            soDeliver.setUpdId(param.getUpdId());
            soDeliver.setUpdTime(DateTimeUtil.getCustomerDate());
            int deliverCount = super.getCount(SqlId.SQL_ID_GET_RECEIPT_DELIVER_COUNT, soDeliver);
            if (deliverCount > 0) {
                boolean isUpdateSoDeliverFlag = false;
                for (ISO251413OrderShipProductRsParam newList : productList) {
                    BigDecimal receiveQty = newList.getReceiveQty();//收货数量大于0
                    if (receiveQty != null && DecimalUtil.isGreater(receiveQty, new BigDecimal(0))) {
                        isUpdateSoDeliverFlag = true;
                        SoDeliverDetail detail = new SoDeliverDetail();
                        detail.setReceiveQty(newList.getReceiveQty());
                        detail.setOrderDetailAvailabilityId(newList.getShipDetailId());
                        detail.setUpdTime(DateTimeUtil.getCustomerDate());
                        detail.setUpdId(param.getUpdId());
                        this.modify(SqlId.SQL_ID_MODIFY_DELIVER_DETAIL_INFO, detail);
                    }
                }
                if (isUpdateSoDeliverFlag) {//  因为 三合一   有的配送单中可能 全部拒收  那么 收货数量为null 或0  如果不加该判断  会修改 配送表数据
                    this.modify(SqlId.SQL_ID_MODIFY_DELIVER_ACTUAL_TIME, soDeliver);
                }
            } else {
                throw new BusinessException("该配送单编码找不到相关配送单信息，请确认！");
            }
            // 设置资金池接口参数
            for (ISO251413OrderShipProductRsParam orderShipProductInfo : productList) {
                BigDecimal receiveQty = orderShipProductInfo.getReceiveQty();//收货数量大于0
                if (receiveQty != null && DecimalUtil.isGreater(receiveQty, new BigDecimal(0))) {
                    cpParam.add(this.getSoCpSelCharging(param, orderShipInfo, orderShipProductInfo));
                }
            }
        }
        // 调用资金池接口
        if (!CollectionUtils.isEmpty(cpParam)) {
            ISO153103Param iso153103Param = new ISO153103Param();
            iso153103Param.setSoCpSelChargingList(cpParam);
            RsRequest<ISO153103Param> request = new RsRequest<ISO153103Param>();
            request.setAuth("MSK00001");
            request.setSiteCode("101");
            request.setLoginId(param.getUpdId());
            request.setParam(iso153103Param);
            String url = ConfigManager.getCpSellerChargingUrl();
            RsResponse<BaseCpResult> response = rsClientUtil.postRsService(url, request, BaseCpResult.class);
        }
    }

    /**
     * 设置资金池接口参数
     *
     * @param param
     * @param orderShipProductInfo
     * @return
     */
    public SoCpSelCharging getSoCpSelCharging(ISO251413RsParam param, ISO251413OrderShipInfoRsParam orderShipInfo, ISO251413OrderShipProductRsParam orderShipProductInfo) {
        SoOrder soOrder = this.findOne(SqlId.SQL_ID_FIND_SO_ORDER, param);
        orderShipProductInfo.setDeliverCode(orderShipInfo.getDeliverCode());
        ISO151415Bean iso151415Bean = this.findOne(SqlId.SQL_ID_FIND_AVA_DETAIL, orderShipProductInfo);
        SoCpSelCharging soCpSelCharging = new SoCpSelCharging();
        soCpSelCharging.setOrderId(soOrder.getOrderId());
        soCpSelCharging.setTransCode(soOrder.getOrderCode());
        soCpSelCharging.setTransType(NumberConst.IntDef.INT_ZERO);
        // 供货明细所属为子订单，传递买手层级信息；供货明细所属为主订单，传递卖家（供应商）层级信息
        if (!iso151415Bean.getOrderId().equals(soOrder.getOrderId())) {
            soCpSelCharging.setBusinessMainId(soOrder.getSellerCode());
            soCpSelCharging.setBusinessMainName(soOrder.getSellerName());
            soCpSelCharging.setBusinessMainRole(Integer.valueOf(CapitalPoolConst.RoleType.ROLE_BUYERE));
        } else {
            soCpSelCharging.setBusinessMainId(iso151415Bean.getBusinessMainId());
            soCpSelCharging.setBusinessMainName(iso151415Bean.getBusinessMainName());
            soCpSelCharging.setBusinessMainRole(Integer.valueOf(CapitalPoolConst.RoleType.ROLE_SELLER));
        }

        // 收款方角色
        if (soOrder.getOrderType() == OrderConst.OrderType.THIRD_PARTY_ORDER
                || soOrder.getOrderType() == OrderConst.OrderType.DISTRIBUTION_ORDER) {
            soCpSelCharging.setBusinessAssistantRole(Integer.valueOf(CapitalPoolConst.RoleType.ROLE_BIDDER));
        } else {
            soCpSelCharging.setBusinessAssistantRole(Integer.valueOf(CapitalPoolConst.RoleType.ROLE_BUYERE));
        }
        soCpSelCharging.setBusinessAssistantId(soOrder.getBuyersId());
        soCpSelCharging.setBusinessAssistantCode(soOrder.getBuyersCode());
        soCpSelCharging.setBusinessAssistantName(soOrder.getBuyersName());
        soCpSelCharging.setDeliveryCode(orderShipInfo.getDeliverCode());
        soCpSelCharging.setDeliveryTime(DateTimeUtil.parseDate(orderShipInfo.getActualReceiveDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
        soCpSelCharging.setShippingAmount(iso151415Bean.getShippingAmount());
        soCpSelCharging.setPaidAmount(iso151415Bean.getPaidAmount());
        return soCpSelCharging;
    }




    /**
     * 根据参数信息得到明细数据和供货明细数据并且更新
     */
    @Transactional
    public void getReceiptListAndModifyOrderInfo(List<ISO251413OrderShipProductRsParam> productList, ISO251413RsParam param) {
        for (ISO251413OrderShipProductRsParam product : productList) {
            BigDecimal receiveQty = product.getReceiveQty();
            if (receiveQty != null && DecimalUtil.isGreater(receiveQty, new BigDecimal(0))) {
                product.setShipId(param.getShipId());
                product.setPdCode(this.getPdCodeBySkuCode(product.getSkuCode()));
                OrderDetailAndSuppInfo detailAndSuppInfo = this.findOne(SqlId.SQL_ID_GET_SUPPLY_INFO_FOR_RECEIPT, product);
                if (null == detailAndSuppInfo) {
                    throw new BusinessException("收货单号和明细信息对不上");
                }
                this.modifyReceiptDetailAndSupInfo(product, detailAndSuppInfo); //更新明细和供货明细数据
            }
        }
    }

    /**
     * 根据货号得到产品编码
     *
     * @param skuCode
     * @return
     */
    public String getPdCodeBySkuCode(String skuCode) {
        /** slCodeDis(1-7) */
        String slCodeDis = skuCode.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_SEVEN);
        /** slPdArtno(8-12) */
        String slPdArtno = skuCode.substring(NumberConst.IntDef.INT_SEVEN, NumberConst.IntDef.INT_TWELVE);

        return orderLogic.getPdCode(slPdArtno, slCodeDis);
    }


    /**
     * 更新明细和供货明细
     */
    @Transactional
    public void modifyReceiptDetailAndSupInfo(ISO251413OrderShipProductRsParam orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {
        this.modifyReceiptSuppDetailInfo(orderShipProductInfo, detailAndSuppInfo);  //更新订单供货明细数据
        this.modifyReceiptDetailInfo(orderShipProductInfo, detailAndSuppInfo);  //更新订单明细数据
    }


    /**
     * 更新明细
     */
    @Transactional
    public void modifyReceiptDetailInfo(ISO251413OrderShipProductRsParam orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (!checkReceiptOrderDetailStatus(detailAndSuppInfo)) {
            throw new BusinessException("明细状态不为可收货状态");
        }

        //发货数量
        BigDecimal sendQty = detailAndSuppInfo.getDetailSendQty();
        //传入的收货数量
        BigDecimal receiveQty = orderShipProductInfo.getReceiveQty();
        //订单明细订单数量
        BigDecimal orderQty = detailAndSuppInfo.getOrderQty();
        //订单明细已收货数量
        BigDecimal detailReceiveQty = detailAndSuppInfo.getDetailReceiveQty();
        //订单明细取消数量
        BigDecimal detailCancelQty = detailAndSuppInfo.getDetailCancelQty();
        //订单明细拒收数量
        BigDecimal detailRejectionQty = detailAndSuppInfo.getDetailRejectionQty();
        //总收货数量
        BigDecimal allReceiveQty = receiveQty.add(detailReceiveQty);
        //实际总数量
        BigDecimal actualQty = allReceiveQty.add(detailCancelQty).add(detailRejectionQty);
        //订单明细可收货数量
        BigDecimal canReceiveQty = DecimalUtil.subtract(orderQty, detailReceiveQty);

        if (receiveQty.compareTo(canReceiveQty) > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("收货数量大于可收货数量");
        }
        orderShipProductInfo.setOrderDetailId(detailAndSuppInfo.getOrderDetailId());
        super.modify(SqlId.SQL_ID_MODIFY_DETAIL_RECEIPT_STATUS_AND_QTY, orderShipProductInfo);
    }

    /**
     * 检查细当前状态
     *
     * @OrderDetailAndSuppInfo detailAndSuppInfo
     */
    @Transactional
    public boolean checkReceiptOrderDetailStatus(OrderDetailAndSuppInfo detailAndSuppInfo) {
        BigDecimal canReceiveQty = DecimalUtil.subtract(DecimalUtil.subtract(detailAndSuppInfo.getDetailSendQty(), detailAndSuppInfo.getDetailReceiveQty()), detailAndSuppInfo.getDetailRejectionQty());
        if (!DecimalUtil.isGreater(canReceiveQty, BigDecimal.ZERO)) {
            return false;
        }
        return true;
    }


    /**
     * 检查供货明细当前状态
     *
     * @OrderDetailAndSuppInfo detailAndSuppInfo
     */
    @Transactional
    public boolean checkSuppReceiptStatus(OrderDetailAndSuppInfo detailAndSuppInfo) {
        BigDecimal canReceiveQty = DecimalUtil.subtract(DecimalUtil.subtract(detailAndSuppInfo.getSuppSendQty(), detailAndSuppInfo.getSuppReceiveQty()), detailAndSuppInfo.getSuppRejectionQty());
        if (!DecimalUtil.isGreater(canReceiveQty, BigDecimal.ZERO)) {
            return false;
        }
        return true;
    }

    /**
     * 更新供货明细
     */
    @Transactional
    public void modifyReceiptSuppDetailInfo(ISO251413OrderShipProductRsParam product, OrderDetailAndSuppInfo detailAndSuppInfo) {

        if (!checkSuppReceiptStatus(detailAndSuppInfo)) {
            throw new BusinessException("订单供货明细状态不为可收货状态");
        }
        //传入的收货数量
        BigDecimal receiveQty = product.getReceiveQty();
        //已收货数量
        BigDecimal suppReceiveQty = detailAndSuppInfo.getSuppReceiveQty();
        //供货数量
        BigDecimal suppQty = detailAndSuppInfo.getSuppOrderQty();
        //取消数量
        BigDecimal suppCancelQty = detailAndSuppInfo.getSuppCancelQty();
        //退货数量
        BigDecimal suppReturnQty = detailAndSuppInfo.getSuppReturnQty();
        //拒收数量
        BigDecimal suppRejectionQty = detailAndSuppInfo.getSuppRejectionQty();
        //总收货数量
        BigDecimal allReceiveQty = suppReceiveQty.add(receiveQty);
        //取消数量+拒收数量
        BigDecimal allOtherQty = suppCancelQty.add(suppRejectionQty);
        //实际总数量
        BigDecimal allActualQty = allReceiveQty.add(allOtherQty);
        //可收货数量
        BigDecimal canReceiveQty = DecimalUtil.subtract(suppQty, suppReceiveQty);

        if (receiveQty.compareTo(canReceiveQty) > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("本次收货数量大于供货明细可收货数量");
        }
        this.modify(SqlId.SQL_ID_MODIFY_AVA_DETAIL_RECEIPT_STATUS_AND_QTY, product);
    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_MODIFY_DETAIL_RECEIPT_STATUS_AND_QTY = "modifyDetailReceiptStatusAndQty";
        String SQL_ID_MODIFY_AVA_DETAIL_RECEIPT_STATUS_AND_QTY = "modifyAvaDetailReceiptStatusAndQty";
        String SQL_ID_GET_SUPPLY_INFO_FOR_RECEIPT = "getSupplyInfoForReceipt";
        String SQL_ID_MODIFY_DELIVER_ACTUAL_TIME = "modifyDeliverActualTime";
        String SQL_ID_MODIFY_DELIVER_DETAIL_INFO = "modifyDeliverDetailInfo";
        String SQL_ID_GET_RECEIPT_DELIVER_COUNT = "getReceiptDeliverCount";
        String SQL_ID_FIND_SO_ORDER = "findSoOrder";
        String SQL_ID_FIND_AVA_DETAIL = "findAvaDetail";
        String SQL_ID_GET_ORDER_SHIP_INFO_RECEIPT = "getOrderShipInfoReceipt";
    }
}
