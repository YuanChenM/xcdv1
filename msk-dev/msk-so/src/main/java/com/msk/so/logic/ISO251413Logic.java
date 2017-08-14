package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 三合一 收货接口
 * Created by zhang_qiang1 on 2016/11/7.
 */
@Service
public class ISO251413Logic extends BaseLogic {

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private ISO251413partReceiptLogic partReceiptLogic;// 部分收货

    @Autowired
    private ISO251413receiveRejectLogic receiveRejectLogic;// 部分拒收

    @Autowired
    private ISO251413receiveLaterLogic receiveLaterLogic;// 部分 迟收


    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251413Logic.class);

    /**
     * 收货方法
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = false)
    public ISO251413RsResult receiveShip(ISO251413RsParam param) throws Exception {
        ISO251413RsResult result = new ISO251413RsResult();
        SoOrderShip soOrderShip = super.findOne(SqlId.SQL_ID_GET_ORDER_SHIP_INFO_RECEIPT, param);
        if (soOrderShip == null) {
            throw new BusinessException("该发货单有问题!请检查发货单是否存在或发货单状态是否正确！");
        }
        result.setShipId(param.getShipId());
        SoOrder order = this.getOrderByShipId(param);
        param.setOrderId(order.getOrderId());
        param.setOrderCode(order.getOrderCode());
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        if (checkShipQty(param)) { //发货单 对应的供货明细收货货数量+拒收数量+迟收数量=数据库中的   发货数量
            Integer paymentType = order.getPaymentType();
            if (paymentType != null && (paymentType.intValue() == 2) && isFirstShip(param)) {// 线下 第一次支付
                BigDecimal actualPayMoney = this.getActualPayMoney(param);// 实付款
                Map<String, BigDecimal> map = this.getShipMoneyMap(param);
                BigDecimal receiveMoney = map.get("receiveMoney");
                BigDecimal delayMoney = map.get("delayMoney");
                BigDecimal returnMoney = map.get("returnMoney");
                BigDecimal shipMoney = receiveMoney.add(delayMoney); // 该发货单 金额
                this.checkOrderDetailPrice(param);//  check订单对应的明细 是否从order_detail_price 获取价格
                this.updateOrderDetailPriceByReceiveInfo(param); // 根据收货信息更新明细表价格指定的对应价格
                BigDecimal otherOrderAmount = (BigDecimal) this.findObject(SqlId.SQL_ID_GET_ORDER_OTHER_AMOUNT, param);  // 计算修改过后 剩余订单金额
                BigDecimal orderAmount = otherOrderAmount.add(shipMoney); // 现在订单金额
                if (DecimalUtil.isEquals(shipMoney, new BigDecimal(0))) {  //  发货单为金额为0
                    if (DecimalUtil.isEquals(actualPayMoney, new BigDecimal(0))||DecimalUtil.isLess(actualPayMoney,otherOrderAmount)) {//  发货单金额且 实际付款金额都是0
                        this.receiveRejectLogic.doReceiverReject(param);// 拒收
                        super.modify(SqlId.SQL_ID_CANCEL_AVA_DETAIL, param); // 取消没有生成的发货单的订单明细和供货明细
                        super.modify(SqlId.SQL_ID_CANCEL_ORDER_DETAIL, param); // 取消之后的
                    } else if (DecimalUtil.isEquals(actualPayMoney, otherOrderAmount) || DecimalUtil.isGreater(actualPayMoney, otherOrderAmount)) {// 发货单金额为0 但是付款的钱是 余款的钱
                        this.receiveRejectLogic.doReceiverReject(param);// 拒收
                        param.setFilterObject("subsequent", NumberConst.IntDef.INT_ONE);
                        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUBSEQUENT, param); // 再配送  修改订单
                    }
                } else if (DecimalUtil.isLess(actualPayMoney, shipMoney)) {// 实付的钱小于该发货单的钱
                    throw new BusinessException("支付金额小于本次收货金额+迟收金额");
                } else if (DecimalUtil.isLess(actualPayMoney, orderAmount) && (DecimalUtil.isGreater(actualPayMoney, shipMoney) || DecimalUtil.isEquals(actualPayMoney, shipMoney))) {// 实付大于等于本次的钱
                    if (DecimalUtil.isGreater(receiveMoney, new BigDecimal(0))) {// 收货操作
                        this.partReceiptLogic.doPartReceipt(param);
                        param.setFilterObject("subsequent", NumberConst.IntDef.INT_ZERO);// 如果没有迟收  就直接 不能再次发货
                        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUBSEQUENT, param);
                    }
                    if (DecimalUtil.isGreater(returnMoney, new BigDecimal(0))) {// 退货操作
                        this.receiveRejectLogic.doReceiverReject(param);
                    }
                    super.modify(SqlId.SQL_ID_CANCEL_AVA_DETAIL, param); // 取消没有生成的发货单的订单明细和供货明细
                    super.modify(SqlId.SQL_ID_CANCEL_ORDER_DETAIL, param);
                    if (DecimalUtil.isGreater(delayMoney, new BigDecimal(0))) {//迟收再配送
                        this.receiveLaterLogic.doReceiverLater(param);
                        param.setFilterObject("subsequent", NumberConst.IntDef.INT_ONE);
                        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUBSEQUENT, param); // 再配送  订单状态
                    }
                } else if (DecimalUtil.isEquals(actualPayMoney, orderAmount) || DecimalUtil.isGreater(actualPayMoney, orderAmount)) {// 实付的金额大于等于订单总额
                    if (DecimalUtil.isGreater(receiveMoney, new BigDecimal(0))) {// 收货操作
                        this.partReceiptLogic.doPartReceipt(param);
                    }
                    if (DecimalUtil.isGreater(returnMoney, new BigDecimal(0))) {// 退货操作
                        this.receiveRejectLogic.doReceiverReject(param);
                    }
                    if (DecimalUtil.isGreater(delayMoney, new BigDecimal(0))) {//迟收再配送
                        this.receiveLaterLogic.doReceiverLater(param);
                    }
                    param.setFilterObject("subsequent", NumberConst.IntDef.INT_ONE);
                    super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUBSEQUENT, param); // 再配送  订单状态
                }
                // 更新  订单金额
                BaseParam baseParam = new BaseParam();
                Map<String, Object> filterMap = baseParam.getFilterMap();
                filterMap.put("shipId", param.getShipId());
                SoOrderRelation relation = this.findOne(SqlId.SQL_ID_FIND_RELATION, param);
                if (relation != null) {// 有主子订单
                    // 更新子订单金额
                    Long childOrderId = relation.getChildOrderId();
                    filterMap.put("childOrderId", childOrderId);
                    this.modify(SqlId.SQL_ID_MODIFY_CHILD_ORDER_AMOUNT, baseParam);
                    // 更新主订单金额
                    Long orderId = param.getOrderId();
                    filterMap.put("orderId", orderId);
                    this.modify(SqlId.SQL_ID_MODIFY_MAIN_ORDER_AMOUNT, baseParam);
                } else {
                    // 更新 单个订单金额
                    Long orderId = param.getOrderId();
                    filterMap.put("orderId", orderId);
                    this.modify(SqlId.SQL_ID_MODIFY_MAIN_ORDER_AMOUNT, baseParam);
                }
            } else {// 如果不是 线下 第一次 （线下 2++，或是线上）
                Map<String, BigDecimal> map = this.getQtyByShip(param);
                BigDecimal sumReceiveQty = map.get("sumReceiveQty");  // 收货
                BigDecimal sumReturnQty = map.get("sumReturnQty"); // 退货
                BigDecimal sumDelayQty = map.get("sumDelayQty");// 迟收数量
                if (DecimalUtil.isGreater(sumReceiveQty, new BigDecimal(0))) {// 收货操作
                    this.partReceiptLogic.doPartReceipt(param);
                }
                if (DecimalUtil.isGreater(sumReturnQty, new BigDecimal(0))) {// 退货操作
                    this.receiveRejectLogic.doReceiverReject(param);
                }
                if (DecimalUtil.isGreater(sumDelayQty, new BigDecimal(0))) {//迟收再配送
                    this.receiveLaterLogic.doReceiverLater(param);
                }
                if (paymentType != null && (paymentType == 1)) {// 线上已经付款
                    if (isFirstShip(param)) {// 如果是线上已付款
                        param.setFilterObject("subsequent", NumberConst.IntDef.INT_ONE);
                        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUBSEQUENT, param); // 再配送  订单状态
                    }
                }
            }
            this.updateStatus(param); // 更新 供货明细 ，发货单，订单明细，订单
            SoOrder dbOrder = this.getOrderByShipId(param);
            result.setOrderId(dbOrder.getOrderId());
            result.setOrderStatus(dbOrder.getOrderStatus());
            result.setPaymentType(dbOrder.getPaymentType());
            result.setVer(dbOrder.getVer());
        }
        return result;
    }


    /**
     * 根据收货信息更新本次价格
     *
     * @param param
     */
    private void updateOrderDetailPriceByReceiveInfo(ISO251413RsParam param) {
        Map<String, BigDecimal> map = new HashMap<>();
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        for (ISO251413OrderShipInfoRsParam ship : shipList) {
            for (ISO251413OrderShipProductRsParam product : ship.getProductList()) {
                product.setOrderId(param.getOrderId());
                String skuCode = product.getSkuCode().trim();
                if (map.containsKey(skuCode)) {// 已经存在的订单产品
                    BigDecimal beforePrice = map.get(skuCode); // 第一个的 相同的sku 的价格
                    BigDecimal receivePrice = product.getReceivePrice();   // 第二个 相同sku 的价格
                    if (!DecimalUtil.isEquals(beforePrice, receivePrice)) {
                        throw new BusinessException("同一订单相同的sku ：" + skuCode + "  价格不同！");
                    }
                    break;
                } else {
                    map.put(product.getSkuCode(), product.getReceivePrice());
                    product.setUpdId(param.getUpdId());
                    product.setPdCode(this.getPdCodeBySkuCode(skuCode));
                    product.setUpdTime(DateTimeUtil.getCustomerDate());
                    SoOrderRelation relation = (SoOrderRelation) this.findObject(SqlId.SQL_ID_FIND_RELATION, param);
                    if (relation != null) {
                        Long childOrderId = relation.getChildOrderId();
                        product.getFilterMap().put("childOrderId", childOrderId);
                    }
                    super.modify(SqlId.SQL_ID_MODIFY_PRICE_BY_ORDER_ID_AND_SKU, product);
                }

            }
        }
    }


    /**
     * 第一次收货时  应该收货的钱
     * 收货的
     *
     * @param param
     * @return
     */
    private Map<String, BigDecimal> getShipMoneyMap(ISO251413RsParam param) {
        Map<String, BigDecimal> map = new HashMap<>();
        BigDecimal receiveMoney = null;    // 收货的钱
        BigDecimal delayMoney = null;   // 拒收的钱
        BigDecimal returnMoney = null;   // 迟收的钱
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        for (ISO251413OrderShipInfoRsParam ship : shipList) {
            List<ISO251413OrderShipProductRsParam> productList = ship.getProductList();
            for (ISO251413OrderShipProductRsParam product : productList) {
                BigDecimal returnQty = product.getReturnQty();
                BigDecimal receiveQty = product.getReceiveQty();
                BigDecimal delayQty = product.getDelayQty();
                BigDecimal price = product.getReceivePrice();
                if (price == null) {
                    throw new BusinessException("收货单价不能为空");
                }
                if (returnQty == null && receiveQty == null && delayQty == null) {
                    throw new BusinessException("退货数量，拒收数量，收货数量不能同时为空");
                }
                receiveMoney = DecimalUtil.add(receiveMoney, DecimalUtil.multiply(price, receiveQty));// 收货的钱
                returnMoney = DecimalUtil.add(returnMoney, DecimalUtil.multiply(price, returnQty));// 拒收的钱
                delayMoney = DecimalUtil.add(delayMoney, DecimalUtil.multiply(price, delayQty)); // 迟收的钱
            }
        }
        map.put("receiveMoney", receiveMoney);
        map.put("delayMoney", delayMoney);
        map.put("returnMoney", returnMoney);
        return map;
    }


    /**
     * 是否是第一次收货
     *
     * @param param
     * @return
     */
    private boolean isFirstShip(ISO251413RsParam param) {
        boolean flag = false;
        Integer shipCount = super.getCount(SqlId.SQL_ID_GET_SHIP_COUNT, param);
        if (shipCount.intValue() == 0) {
            flag = true;
        }
        return flag;
    }


    /**
     * 计算实际付款
     *
     * @param param
     * @return
     */
    private BigDecimal getActualPayMoney(ISO251413RsParam param) {
        List<ISO251413PaymentRsParam> paymentList = param.getPaymentList();
        if (CollectionUtils.isEmpty(paymentList)) {
            throw new BusinessException("线下第一次发货需要 传入支付信息");
        }
        BigDecimal actualPayMoney = null;
        for (ISO251413PaymentRsParam pay : paymentList) {
            if (pay == null) {
                throw new BusinessException("支付信息为空！");
            }
            String paymentCode = pay.getPaymentCode();
            if (StringUtil.isEmpty(paymentCode)) {
                throw new BusinessException("支付凭证号为空 ");
            }
            Integer paymentMode = pay.getPaymentMode();
            if (paymentMode == null) {
                throw new BusinessException("付款方式为空 ");
            }
            BigDecimal paymentMoney = pay.getPaymentMoney();
            if (paymentMoney == null || DecimalUtil.isLess(paymentMoney, new BigDecimal(0))) {
                throw new BusinessException("付款金额不能为空或为负数 ");
            }

            SoPayment soPayment = new SoPayment();
            soPayment.setPaymentId(commonLogic.maxId("SO_PAYMENT", "PAYMENT_ID"));
            soPayment.setOrderId(param.getOrderId());
            soPayment.setOrderCode(param.getOrderCode());
            soPayment.setPayMode(paymentMode);
            soPayment.setPayAmount(paymentMoney);
            soPayment.setPayOrderCode(paymentCode);
            soPayment.setPayTime(DateTimeUtil.getCustomerDate());
            soPayment.setCrtId(param.getUpdId());
            soPayment.setCrtTime(DateTimeUtil.getCustomerDate());
            super.save(soPayment);
            actualPayMoney = DecimalUtil.add(actualPayMoney, pay.getPaymentMoney());
        }
        return actualPayMoney;
    }


    /**
     * 校验发货单数量
     *
     * @return
     */
    private boolean checkShipQty(ISO251413RsParam param) {
        boolean flag = false;
        Map<String, BigDecimal> map = this.getQtyByShip(param);
        List<SoOrderDetailAvailability> availabilityList = this.findOrderDetailAvailabilityList(param);
        if (CollectionUtils.isEmpty(availabilityList)) {
            throw new BusinessException("该发货单没有对应的供货明细");
        }
        for (SoOrderDetailAvailability availability : availabilityList) {
            BigDecimal sendQty = availability.getSendQty();
            BigDecimal mapQty = map.get(availability.getOrderDetailAvailabilityId().toString());
            if (mapQty == null) {
                throw new BusinessException("该发货单中找不到对应的供货明细！");
            }
            if (!DecimalUtil.isEquals(sendQty, mapQty)) {
                throw new BusinessException("该发货单中收货数量,拒收数量，迟收数量总和不等于数据库中的对应的供货明细的发货数量，shipDetailId:" + availability.getOrderDetailAvailabilityId());
            }
            flag = true;
        }
        return flag;
    }


    /**
     * @param param
     * @return
     */
    public Map<String, BigDecimal> getQtyByShip(ISO251413RsParam param) {
        HashMap<String, BigDecimal> map = new HashMap<>();
        BigDecimal sumDelayQty = null;
        BigDecimal sumReceiveQty = null;
        BigDecimal sumReturnQty = null;
        List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
        for (ISO251413OrderShipInfoRsParam ship : shipList) {// 合并相同的shipDetailId
            List<ISO251413OrderShipProductRsParam> productList = ship.getProductList();
            for (ISO251413OrderShipProductRsParam product : productList) {
                if (DecimalUtil.isLess(product.getDelayQty(), new BigDecimal(0))) {
                    throw new BusinessException(" 产品中的迟收数量不能为负数");
                }
                if (DecimalUtil.isLess(product.getReceiveQty(), new BigDecimal(0))) {
                    throw new BusinessException(" 产品中的收货数量不能为负数");
                }
                if (DecimalUtil.isLess(product.getReturnQty(), new BigDecimal(0))) {
                    throw new BusinessException(" 产品中的退货数量不能为负数");
                }
                sumDelayQty = DecimalUtil.add(sumDelayQty, product.getDelayQty());// 累加 迟收数量
                sumReceiveQty = DecimalUtil.add(sumReceiveQty, product.getReceiveQty());// 累加 收货量
                sumReturnQty = DecimalUtil.add(sumReturnQty, product.getReturnQty());// 累加 拒收数量
                BigDecimal qty = DecimalUtil.add(DecimalUtil.add(product.getDelayQty(), product.getReceiveQty()), product.getReturnQty());
                BigDecimal mapQty = map.get(product.getShipDetailId().toString());
                if (mapQty != null) {// 已经存储过
                    map.put(product.getShipDetailId().toString(), DecimalUtil.add(mapQty, qty));//  供货明细 id: 总量
                } else {
                    map.put(product.getShipDetailId().toString(), qty);
                }
            }
        }
        map.put("sumDelayQty", sumDelayQty);
        map.put("sumReceiveQty", sumReceiveQty);
        map.put("sumReturnQty", sumReturnQty);
        return map;
    }


    /**
     * @param param
     */
    private void updateStatus(ISO251413RsParam param) {
        List<SoOrderDetailAvailability> avaList = this.findList(SqlId.SQL_ID_FIND_AVA_LIST, param);     // 供货明细
        BaseParam baseParam = new BaseParam();
        Map<String, Object> filterMap = baseParam.getFilterMap();
        filterMap.put("updId", param.getUpdId());
        filterMap.put("updTime", DateTimeUtil.getCustomerDate());
        for (SoOrderDetailAvailability ava : avaList) {  /** ALL_RECEIPT:全部收货 */ /** ALL_RETURN:全部退货 */  /** CANCEL:取消 */
            BigDecimal sendQty = ava.getSendQty();// 发货数量
            BigDecimal returnQty = ava.getReturnQty();// 退货数量
            BigDecimal rejectionQty = ava.getRejectionQty();// 全部拒收
            BigDecimal receiveQty = ava.getReceiveQty();// 收货数量
            BigDecimal cancelQty = ava.getCancelQty();
            filterMap.put("avaId", ava.getOrderDetailAvailabilityId());
            if (DecimalUtil.isEquals(sendQty, rejectionQty) || DecimalUtil.isEquals(sendQty, returnQty)) {//全部退货
                filterMap.put("avaStatus", StatusConst.OrderDetailAvailabilityStatusDef.ALL_RETURN);
            } else if (DecimalUtil.isEquals(sendQty, cancelQty)) {
                filterMap.put("avaStatus", StatusConst.OrderDetailAvailabilityStatusDef.CANCEL);
            } else {
                filterMap.put("avaStatus", StatusConst.OrderDetailAvailabilityStatusDef.ALL_RECEIPT);
            }
            this.modify(SqlId.SQL_ID_UPDATE_AVA_STATUS, baseParam);             // 修改供货明细状态
        }


        ISO251413OrderShipInfoRsParam shipInfoRsParam = (ISO251413OrderShipInfoRsParam) this.findObject(SqlId.SQL_ID_FIND_SHIP_QTY, param);      // 发货单 /** PARTIAL_RECEIPT:部分收货 */ALL_RECEIPT:全部收货ALL_LATE_RECEIPT:全部迟收 已取消
        filterMap.put("shipId", param.getShipId());
        if (shipInfoRsParam == null) {//全部迟收
            filterMap.put("shipStatus", StatusConst.OrderShipStatusDef.ALL_LATE_RECEIPT);// 全部迟收
        } else {
            BigDecimal shipSendQty = shipInfoRsParam.getSendQty();// 发货数量
            BigDecimal shipReturnQty = shipInfoRsParam.getReturnQty();// 退货数量
            BigDecimal shipRejectionQty = shipInfoRsParam.getRejectionQty();// 拒收
            BigDecimal shipReceiveQty = shipInfoRsParam.getReceiveQty();// 收货数量
            BigDecimal shipCancelQty = shipInfoRsParam.getCancelQty();// 取消数量
            if (DecimalUtil.isEquals(shipSendQty, DecimalUtil.add(shipRejectionQty, shipCancelQty))) {// 全部退货
                filterMap.put("shipStatus", StatusConst.OrderShipStatusDef.ALL_RETURN);
            } else {// 全部收货
                filterMap.put("shipStatus", StatusConst.OrderShipStatusDef.ALL_RECEIPT);
            }
        }
        this.modify(SqlId.SQL_ID_UPDATE_SHIP_STATUS, baseParam);
        List<SoOrderDetail> orderDetailList = this.findList(SqlId.SQL_ID_FIND_ORDER_DETAIL_LIST, param);  // 订单明细   /** PARTIAL_RECEIPT:部分收货 */ /** ALL_RECEIPT:全部收货 */ /** CANCEL:取消 */
        for (SoOrderDetail detail : orderDetailList) {
            filterMap.put("detailId", detail.getOrderDetailId());
            filterMap.put("detailStatus", StatusConst.OrderDetailStatusDef.ALL_RECEIPT);
            this.modify(SqlId.SQL_ID_UPDATE_DETAIL_STATUS, baseParam);
        }


        //--------------------------------------------------------修改订单状态
        // 查询订单关联表

        SoOrderRelation relation = this.findOne(SqlId.SQL_ID_FIND_RELATION, param);
        if (relation != null) {// 有主子订单
            // 子订单
            Long childOrderId = relation.getChildOrderId();// 子订单id
            filterMap.put("orderId", childOrderId);
            this.updateOrderStatus(param, baseParam, false);
            // 主订单
            filterMap.put("orderId", param.getOrderId());
            this.updateOrderStatus(param, baseParam, true);

        } else {// 单个订单
            filterMap.put("orderId", param.getOrderId());
            this.updateOrderStatus(param, baseParam, false);
        }

    }


    /**
     * 修改订单状态
     *
     * @param param
     * @param baseParam
     * @param isMainOrder
     */
    private void updateOrderStatus(ISO251413RsParam param, BaseParam baseParam, boolean isMainOrder) {
        Map<String, Object> filterMap = baseParam.getFilterMap();
        SoOrderDetail orderQtyBean = null;
        if (isMainOrder) {
            orderQtyBean = (SoOrderDetail) this.findObject(SqlId.SQL_ID_FIND_MAIN_ORDER_QTY, baseParam);//  订单数量
        } else {
            orderQtyBean = (SoOrderDetail) this.findObject(SqlId.SQL_ID_FIND_ORDER_QTY, baseParam);//  订单数量
        }
        BigDecimal sendQty = orderQtyBean.getSendQty();// 发货数量
        BigDecimal cancelQty = orderQtyBean.getCancelQty();
        BigDecimal receiveQty = orderQtyBean.getReceiveQty();// 收货数量
        BigDecimal rejectionQty = orderQtyBean.getRejectionQty();// 拒收数量
        BigDecimal suppQty = orderQtyBean.getOrderQty();// 供货数量
        BigDecimal resultQty = DecimalUtil.add(cancelQty, rejectionQty).add(receiveQty);// 取消数量+拒收数量+收货数量
        if (DecimalUtil.isEquals(sendQty, new BigDecimal(0))) {// 发货数量为0
            if (this.IsOrderWaitSendStatus(param, isMainOrder)) {// 待发货
                filterMap.put("orderStatus", StatusConst.OrderStatusDef.WAIT_SEND);// 待发货
            } else {
                filterMap.put("orderStatus", StatusConst.OrderStatusDef.CONFIRM);// 已确认
            }
        } else if (DecimalUtil.isEquals(suppQty, resultQty)) {// 供货数量= 取消数量+拒收数量+收货数量
            filterMap.put("orderStatus", StatusConst.OrderStatusDef.ALL_RECEIPT);// 全部收货
        } else if (DecimalUtil.isGreater(receiveQty, new BigDecimal(0))) {//收货数量>0
            filterMap.put("orderStatus", StatusConst.OrderStatusDef.PARTIAL_RECEIPT);// 部分收货
        } else if (DecimalUtil.isEquals(suppQty, DecimalUtil.add(sendQty, cancelQty))) {// 供货数量=发货数量+取消数量
            filterMap.put("orderStatus", StatusConst.OrderStatusDef.ALL_SHIPMENT);//全部发货
        } else {
            filterMap.put("orderStatus", StatusConst.OrderStatusDef.PARTIAL_SHIPMENT);// 部分发货
        }
        super.modify(SqlId.SQL_ID_MODIFY_ORDER, baseParam);
    }

    /**
     * 根据shipId  获取对应的订单
     *
     * @param param
     * @return
     */
    private SoOrder getOrderByShipId(ISO251413RsParam param) {
        SoOrder order = (SoOrder) this.findObject(SqlId.SQL_ID_FIND_ONE_ORDER, param);
        if (order == null) {
            throw new BusinessException("该发货单找不到对应的订单！");
        }
        return order;
    }


    /**
     * 检查订单状态是否是 待发货
     *
     * @param param
     * @return
     */
    private boolean IsOrderWaitSendStatus(ISO251413RsParam param, boolean isMainOrder) {
        Integer count;
        if (isMainOrder) {
            count = (Integer) this.findObject(SqlId.SQL_ID_FIND_CHECK_MAIN_ORDER_WAIT_SEND, param);
        } else {
            count = (Integer) this.findObject(SqlId.SQL_ID_FIND_CHECK_ORDER_WAIT_SEND, param);
        }
        if (count == 0) {
            return false;
        }
        return true;
    }


    /**
     * 根据shipId 校验 供货明细数量
     *
     * @return
     */
    private List<SoOrderDetailAvailability> findOrderDetailAvailabilityList(ISO251413RsParam param) {
        List<SoOrderDetailAvailability> availabilityList = this.findList(SqlId.SQL_ID_FIND_AVAILABILITY_LIST, param);
        return availabilityList;
    }


    /**
     * 检查 订单明细对应的价格
     *
     * @param param
     */
    public void checkOrderDetailPrice(ISO251413RsParam param) {
        List<SoOrderDetail> soOrderDetailList = this.findList(SqlId.SQL_ID_FIND_CHECK_ORDER_DETAIL_PRICE, param);
        boolean updateOrderDetailFlag = true;
        if (!CollectionUtils.isEmpty(soOrderDetailList)) {
            for (SoOrderDetail orderDetail : soOrderDetailList) {
                Long orderDetailId = orderDetail.getOrderDetailId();// 订单明细id
                BigDecimal pdPrice = orderDetail.getPdPrice();// 价盘产品价格
                BigDecimal pdPriceOld = orderDetail.getPdPriceOld();//下单价格
                if (pdPrice == null) {
                    updateOrderDetailFlag = false;
                    break;
                }
                if(DecimalUtil.isEquals(pdPrice,new BigDecimal(0))){
                    throw new BusinessException("同步的价格为0，订单明细id"+orderDetailId);
                }
            }
            if (updateOrderDetailFlag) {
                logger.info(" 根据价盘表更新明细表价格");
                this.modify(SqlId.SQL_ID_MODIFY_PRICE_BY_ORDER_ID, param);  // 根据价盘表更新明细表价格
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


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    interface SqlId {
        String SQL_ID_FIND_ONE_ORDER = "findOneOrder";
        String SQL_ID_FIND_AVAILABILITY_LIST = "findOrderDetailAvailabilityList";
        String SQL_ID_GET_ORDER_OTHER_AMOUNT = "findOtherAmount";
        String SQL_ID_MODIFY_PRICE_BY_ORDER_ID = "modifyPriceByOrderId";// 价盘明细更新价格
        String SQL_ID_MODIFY_PRICE_BY_ORDER_ID_AND_SKU = "modifyPriceByOrderIdAndSku";// 收货信息更新价格
        String SQL_ID_CANCEL_AVA_DETAIL = "cancelOtherAvaDetail";
        String SQL_ID_CANCEL_ORDER_DETAIL = "cancelOtherOrderDetail";
        String SQL_ID_MODIFY_ORDER_SUBSEQUENT = "modifyOrderSubsequent";
        String SQL_ID_GET_SHIP_COUNT = "getShipCount";
        String SQL_ID_FIND_AVA_LIST = "findAVAList";
        String SQL_ID_UPDATE_AVA_STATUS = "updateAvaStatus";
        String SQL_ID_FIND_SHIP_QTY = "findShipQty";
        String SQL_ID_UPDATE_SHIP_STATUS = "updateShipStatus";
        String SQL_ID_FIND_ORDER_DETAIL_LIST = "findOrderDetailList";
        String SQL_ID_UPDATE_DETAIL_STATUS = "updateDetailStatus";
        String SQL_ID_FIND_RELATION = "findOrderRelation";
        String SQL_ID_MODIFY_CHILD_ORDER_AMOUNT = "modifyChildOrderAmount";
        String SQL_ID_MODIFY_MAIN_ORDER_AMOUNT = "modifyMainOrderAmount";
        String SQL_ID_MODIFY_ORDER = "modifyOrder";
        String SQL_ID_GET_ORDER_SHIP_INFO_RECEIPT = "getOrderShipInfoReceipt";
        String SQL_ID_FIND_ORDER_QTY = "findOrderQty";
        String SQL_ID_FIND_MAIN_ORDER_QTY = "findMainOrderQty";
        String SQL_ID_FIND_CHECK_MAIN_ORDER_WAIT_SEND = "checkMainOrderWaitSend";
        String SQL_ID_FIND_CHECK_ORDER_WAIT_SEND = "checkOrderWaitSend";
        String SQL_ID_FIND_CHECK_ORDER_DETAIL_PRICE = "checkOrderDetailPrice";

    }
}
