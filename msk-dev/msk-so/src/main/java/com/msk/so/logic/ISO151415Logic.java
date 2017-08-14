package com.msk.so.logic;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.common.utils.RsClientUtil;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.*;
import com.msk.so.bean.order.*;
import com.msk.so.bean.rs.ISO151415RsProductResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by wang_jianzhou on 2016/3/8.
 */
@Service
public class ISO151415Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151415Logic.class);

    @Autowired
    private OrderLogic orderLogic;
    @Autowired
    private OrderDetailAvailabilityLogic orderDetailAvailabilityLogic;
    @Autowired
    private RsClientUtil rsClientUtil;
    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private DeliverLogic deliverLogic;

    @Autowired
    private OrderStatusLogic orderStatusLogic;

    public void modifyOrderDetail(Long orderId, Integer status, String updId, Date date) {
        BaseParam param = new BaseParam();
        Map<String, Object> map = param.getFilterMap();
        map.put("orderId", orderId);
        map.put("status", status);
        map.put("updId", updId);
        map.put("date", date);
        super.modify(SqlId.SQL_ID_MODIFY_SO_ORDER_DETAIL_STATUS, param);
    }

    public void modifyAllReceipt(BaseOrderStatusParam param) {
        this.modify(SqlId.SQL_ID_MODIFY_SO_ORDER_ALL_RECEIPT, param);
    }

    public Integer findDetail(BaseOrderStatusParam param) {
        return super.getCount(SqlId.SQL_ID_MODIFY_SO_ORDER_FIND_DETAIL, param);
    }

    public List findRelationId(BaseOrderStatusParam param) {
        long id = param.getOrderId();
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", id);
        return super.findList(map, SqlId.SQL_ID_MODIFY_SO_ORDER_FIND_RELATION_ID);
    }

    public Integer findRelation(BaseOrderStatusParam param) {
        return super.getCount(SqlId.SQL_ID_MODIFY_SO_ORDER_FIND_RELATION, param);
    }

    @Transactional
    public SoOrderRelation findOrderRelation(BaseParam param) {
        SoOrderRelation soOrderRelation = super.findOne(SqlId.SQL_FIND_ORDER_RELATION_BY_MAIN_ORDER_ID, param);
        if (null == soOrderRelation) {
            return null;
        }
        return soOrderRelation;

    }

    @Transactional
    public SoOrder findChildOrderInfo(BaseParam param) {
        SoOrder order = super.findOne(SqlId.SQL_FIND_ORDER_INFO_BY_CHILD_ORDER_ID, param);
        if (null == order) {
            return null;
        }
        return order;
    }

    @Transactional
    public List<SoOrderDetail> findChildDetails(BaseParam param) {
        List<SoOrderDetail> details = super.findList(SqlId.SQL_FIND_ORDER_DETAILS_BY_CHILD_ORDER_ID, param);
        if (null == details) {
            return null;
        }
        return details;
    }

    @Transactional
    public int findBuyerCount(BaseParam param) {

        return super.getCount(SqlId.SQL_GET_BUYER_COUNT_BY_BUYER_ID, param);
    }

    @Transactional
    public int findProductNum(BaseParam param) {

        return super.getCount(SqlId.SQL_GET_CONFIRMED_COUNT, param);
    }

    @Transactional
    public BigDecimal findPackageQty() {
        Object packageQtyStr = super.findObject(SqlId.SQL_FIND_PACACKAGE_QTY, null);
        if (null == packageQtyStr) {
            logger.debug("请设置PackageQty");
            return null;
        }
        BigDecimal qty = new BigDecimal((String) packageQtyStr);
        return qty;
    }

    @Transactional
    public void modifyOrderPendingAudit(Long orderId) {
        BaseParam baseParam = new BaseParam();
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss", DateTimeUtil.getCustomerDate()), "yyyy-MM-dd HH:mm:ss");
        baseParam.setFilterObject("status", StatusConst.OrderStatusDef.PENDING_AUDIT);
        baseParam.setFilterObject("updTime", customerDate);
        baseParam.setFilterObject("orderId", orderId);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_PENDING_AUDIT, baseParam);
    }

    @Transactional
    public void modifySubOrderDetailPendingAudit(Long orderId) {
        BaseParam baseParam = new BaseParam();
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss", DateTimeUtil.getCustomerDate()), "yyyy-MM-dd HH:mm:ss");
        baseParam.setFilterObject("status", StatusConst.OrderDetailStatusDef.PENDING_AUDIT);
        baseParam.setFilterObject("updTime", customerDate);
        baseParam.setFilterObject("orderId", orderId);
        super.modify(SqlId.SQL_ID_MODIFY_SUB_ORDER_DETAIL_PENDING_AUDIT, baseParam);
    }

    @Transactional
    public void modifySubOrderDetailAvailabilityPendingAudit(Long orderId) {
        BaseParam baseParam = new BaseParam();
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss", DateTimeUtil.getCustomerDate()), "yyyy-MM-dd HH:mm:ss");
        baseParam.setFilterObject("status", StatusConst.OrderDetailAvailabilityStatusDef.PENDING_AUDIT);
        baseParam.setFilterObject("updTime", customerDate);
        baseParam.setFilterObject("orderId", orderId);
        super.modify(SqlId.SQL_ID_MODIFY_SUB_ORDER_DETAIL_AVAILABILITY_PENDING_AUDIT, baseParam);
    }


    /**
     * 获取供应商的供货QTY、收货QTY
     */
    public List<ISO151415RsProductResult> findOrderDetailAvailability(BaseOrderDetailParam param, List list) {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", param.getOrderId());
        map.put("suppCode", param.getSupplierCode());
        map.put("pdCode", param.getPdCode());
        map.put("qty", param.getOrderQty());
        map.put("list", list);
        return this.findList(map, SqlId.SQL_ID_FIND_SO_ORDER_DETAIL_AVAILABILITY);
    }

    /**
     * 获取产品的供货QTY、收货QTY
     */
    public List<ISO151415RsProductResult> findOrderDetail(BaseOrderDetailParam param, List orderIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", orderIds);
        map.put("pdCode", param.getPdCode());
        map.put("qty", param.getOrderQty());
        return this.findList(map, SqlId.SQL_ID_FIND_SO_ORDER_DETAIL);
    }

    @Transactional
    public List<SoConstantBean> findEmailTo() {
        List<SoConstantBean> soConstantBeans = super.findList(SqlId.SQL_ID_GET_EMAIL_ADDRESS, null);
        if (CollectionUtils.isEmpty(soConstantBeans)) {
            return null;
        }
        return soConstantBeans;
    }

    /**
     * 获取供应商总供货QTY、总收货QTY
     */
    public ISO151415RsProductResult findOrderDetailSumAvailability(BaseOrderDetailParam param) {
        Map<String, Object> map = new HashMap<>();
        map.put("orderId", param.getOrderId());
        map.put("qty", param.getOrderQty());
        return this.findOne(SqlId.SQL_ID_FIND_SO_ORDER_DETAIL_SUM_AVAILABILITY, map);
    }

    public List<BaseOrderDetailParam> findDetails(List orderIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", orderIds);
        return this.findList(map, SqlId.SQL_ID_FIND_SO_ORDER_DETAILS);
    }

    public List<BaseOrderDetailParam> findDetailAvailabilitys(List orderIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("list", orderIds);
        return this.findList(map, SqlId.SQL_ID_FIND_SO_ORDER_DETAIL_AVAILABILITYS);
    }


    /**
     * 修改供应商的部分收货状态（status：部分收货 —— 11；全部收货 —— 13）
     *
     * @param param
     */
    public void modifyOrderDetailAvailabilityApartReceiveStatus(BaseOrderDetailParam param) {
        this.modify(SqlId.SQL_ID_MODIFY_SO_ORDER_DETAIL_AVAILABILITY_APART_RECEIVE_STATUS, param);
    }

    /**
     * 修改产品的部分收货状态（status：部分收货 —— 11；全部收货 —— 13）
     *
     * @param param
     */
    public void modifyOrderDetailApartReceiveStatus(BaseOrderDetailParam param) {
        this.modify(SqlId.SQL_ID_MODIFY_SO_ORDER_DETAIL_APART_RECEIVE_STATUS, param);
    }

    /**
     * 修改订单收货状态（status：部分收货 —— 11；全部收货 —— 13）
     *
     * @param param
     */
    public void modifyOrderApartReceiveStatus(BaseOrderDetailParam param) {
        this.modify(SqlId.SQL_ID_MODIFY_SO_ORDER_APART_RECEIVE_STATUS, param);
    }

    /**
     * 处理部分发货流程
     *
     * @return BaseOrderStatusResult
     * @OrderDeliverParam param
     */
    @Transactional
    public BaseOrderStatusResult modifyPartDeliver(OrderDeliverParam param) {

        //检查数据版本是否正确(现在支持部分发货，会存在版本更新不及时的情况所以这边不好做校验)
        //super.versionValidator("SO_ORDER",new String[]{"ORDER_ID"},new Object[]{param.getOrderId()},param.getVer());
        if (StringUtil.isEmpty(param.getWhCode()) || StringUtil.isEmpty(param.getWhName())) {
            throw new BusinessException("请传入实际发货仓库信息！");
        }

        List<OrderShipInfo> shipList = param.getShipList();

        if (CollectionUtils.isEmpty(shipList)) {
            throw new BusinessException("配送单信息不能为空");
        }
        SoOrderShip soOrderShip = super.findOne(SqlId.SQL_ID_GET_ORDER_SHIP_INFO, param);
        if (null == soOrderShip) {
            throw new BusinessException("没有对应的发货单信息");
        }
        // 设置发货单实际仓库
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SHIP_INFO, param);

        soOrderShip.setCrtId(param.getUpdId());

        param.setOrderCode(soOrderShip.getOrderCode());
        param.setOrderId(soOrderShip.getOrderId());

        //部分发货具体处理流程
        dealShipListInfo(param, soOrderShip);

        //更新订单状态
        modifyOrderStatus(param);

        //更新发货单状态
        modifyOrderShipStatus(param);

        return getOrderResultInfo(param);
    }

    /**
     * 处理部分收货流程
     *
     * @return BaseOrderStatusResult
     * @OrderReceiptParam param
     */
    @Transactional
    public BaseOrderStatusResult modifyPartReceipt(OrderReceiptParam param) {
        // 本次收货金额
        BigDecimal shipAmount = this.checkParamAndUpdateOrder(param);
        SoOrderShip soOrderShip = super.findOne(SqlId.SQL_ID_GET_ORDER_SHIP_INFO_RECEIPT, param);
        if (DecimalUtil.isGreater(shipAmount, BigDecimal.ZERO)) {// 非首次
            soOrderShip.setCrtId(param.getUpdId());
            param.setOrderCode(soOrderShip.getOrderCode());
            //部分收货具体处理流程
            dealReceiptListInfo(param);
            param.setFilterObject("shipStatus", StatusConst.OrderShipStatusDef.ALL_RECEIPT);
        } else {
            param.setFilterObject("shipStatus", StatusConst.OrderShipStatusDef.ALL_RETURN);
        }
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_SHIP, param);

        //更新订单状态、金额
        param.setOrderId(soOrderShip.getOrderId());
        modifyOrderReceiptStatus(param, shipAmount);

        return getReceiptOrderResultInfo(param);
    }

    /**
     * 根据调用收货接口中的配送单信息处理
     *
     * @param param
     */
    @Transactional
    public void dealReceiptListInfo(OrderReceiptParam param) {
        List<OrderShipInfo> shipList = param.getShipList();
        // 资金池接口参数
        List<SoCpSelCharging> cpParam = new ArrayList<>();
        for (OrderShipInfo orderShipInfo : shipList) {
            List<OrderShipProductInfo> productList = orderShipInfo.getProductList();
            if (CollectionUtils.isEmpty(productList)) {
                throw new BusinessException("产品数据不能为空");
            }
            for (OrderShipProductInfo newList : productList) {
                newList.setUpdId(param.getUpdId());
                newList.setCrtTime(DateTimeUtil.parseDate(orderShipInfo.getActualReceiveDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
                newList.setUpdTime(DateTimeUtil.getCustomerDate());
            }
            //得到配送明细数据并且更新订单相关的明细数据
            getReceiptListAndModifyOrderInfo(productList, param);
            //更新实际到货时间
            SoDeliver soDeliver = new SoDeliver();
            soDeliver.setDeliverCode(orderShipInfo.getDeliverCode());
            soDeliver.setActualReceiveDate(DateTimeUtil.parseDate(orderShipInfo.getActualReceiveDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
            //soDeliver.setOrderId(param.getOrderId());
            soDeliver.setShipId(param.getShipId());
            soDeliver.setUpdId(param.getUpdId());
            soDeliver.setUpdTime(DateTimeUtil.getCustomerDate());
            int deliverCount = super.getCount(SqlId.SQL_ID_GET_RECEIPT_DELIVER_COUNT, soDeliver);
            if (deliverCount > 0) {
                super.modify(SqlId.SQL_ID_MODIFY_DELIVER_ACTUAL_TIME, soDeliver);
                for (OrderShipProductInfo newList : productList) {
                    SoDeliverDetail detail = new SoDeliverDetail();
                    detail.setReceiveQty(newList.getReceiveQty());
                    detail.setOrderDetailAvailabilityId(newList.getShipDetailId());
                    detail.setUpdTime(DateTimeUtil.getCustomerDate());
                    detail.setUpdId(param.getUpdId());
                    super.modify(SqlId.SQL_ID_MODIFY_DELIVER_DETAIL_INFO, detail);
                }
            } else {
                throw new BusinessException("该配送单编码找不到相关配送单信息，请确认！");
            }
            // 设置资金池接口参数
            for (OrderShipProductInfo orderShipProductInfo : productList) {
                cpParam.add(this.getSoCpSelCharging(param, orderShipInfo, orderShipProductInfo));
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
    public SoCpSelCharging getSoCpSelCharging(OrderReceiptParam param, OrderShipInfo orderShipInfo, OrderShipProductInfo orderShipProductInfo) {
        SoOrder soOrder = super.findOne(SqlId.SQL_ID_FIND_SO_ORDER, param);
        orderShipProductInfo.setDeliverCode(orderShipInfo.getDeliverCode());
        ISO151415Bean iso151415Bean = super.findOne(SqlId.SQL_ID_FIND_AVA_DETAIL, orderShipProductInfo);
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
    public void getReceiptListAndModifyOrderInfo(List<OrderShipProductInfo> productList, OrderReceiptParam param) {
        for (OrderShipProductInfo orderShipProductInfo : productList) {
            orderShipProductInfo.setShipId(param.getShipId());
            //orderShipProductInfo.setOrderId(param.getOrderId());
            orderShipProductInfo.setPdCode(getPdCodeBySkuCode(orderShipProductInfo.getSkuCode()));
            OrderDetailAndSuppInfo detailAndSuppInfo = this.findOne(SqlId.SQL_ID_GET_SUPPLY_INFO_FOR_RECEIPT, orderShipProductInfo);
            if (null == detailAndSuppInfo) {
                throw new BusinessException("收货单号和明细信息对不上");
            }
            //更新明细和供货明细数据
            modifyReceiptDetailAndSupInfo(orderShipProductInfo, detailAndSuppInfo);
        }

    }

    /**
     * 更新明细和供货明细
     */
    @Transactional
    public void modifyReceiptDetailAndSupInfo(OrderShipProductInfo orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (!checkOrderReceiptStatus(detailAndSuppInfo)) {
            throw new BusinessException("订单状态不为可收货状态");
        }
        //更新订单供货明细数据
        modifyReceiptSuppDetailInfo(orderShipProductInfo, detailAndSuppInfo);
        //更新订单明细数据
        modifyReceiptDetailInfo(orderShipProductInfo, detailAndSuppInfo);
    }

    /**
     * 更新供货明细
     */
    @Transactional
    public void modifyReceiptSuppDetailInfo(OrderShipProductInfo orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {

        if (!checkSuppReceiptStatus(detailAndSuppInfo)) {
            throw new BusinessException("订单供货明细状态不为可收货状态");
        }
        //传入的收货数量
        BigDecimal receiveQty = orderShipProductInfo.getReceiveQty();
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
        orderShipProductInfo.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.ALL_RECEIPT);

        super.modify(SqlId.SQL_ID_MODIFY_AVA_DETAIL_RECEIPT_STATUS_AND_QTY, orderShipProductInfo);
    }

    /**
     * 更新明细
     */
    @Transactional
    public void modifyReceiptDetailInfo(OrderShipProductInfo orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {
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
        orderShipProductInfo.setStatus(StatusConst.OrderDetailStatusDef.ALL_RECEIPT);
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
     * 更新订单状态、金额
     *
     * @OrderReceiptParam param
     */
    @Transactional
    public void modifyOrderReceiptStatus(OrderReceiptParam param, BigDecimal shipAmount) {
        // 查询订单关联表
        SoOrderRelation sor = super.findOne(SqlId.SQL_ID_FIND_RELATION, param);
        if (sor != null) {
            // 修改子订单
            param.setFilterObject("childOrderId", sor.getChildOrderId());
            Integer leftQty = super.getCount(SqlId.SQL_ID_GET_CHILD_LEFT_COUNT, param);
            Integer thisReceiveQty = super.getCount(SqlId.SQL_ID_GET_CHILD_RECEIVE_COUNT, param);
            if (leftQty > NumberConst.IntDef.INT_ZERO) {
                if (thisReceiveQty > NumberConst.IntDef.INT_ZERO) {
                    param.setFilterObject("orderStatus", StatusConst.OrderStatusDef.PARTIAL_RECEIPT);
                }
            } else {
                param.setFilterObject("orderStatus", StatusConst.OrderStatusDef.ALL_RECEIPT);
            }
            super.modify(SqlId.SQL_ID_MODIFY_CHILD_ORDER, param);
        }
        // 修改主订单
        Integer leftQty = super.getCount(SqlId.SQL_ID_GET_LEFT_COUNT, param);
        if (leftQty > NumberConst.IntDef.INT_ZERO) {
            if (DecimalUtil.isGreater(shipAmount, BigDecimal.ZERO)) {
                param.setFilterObject("orderStatus", StatusConst.OrderStatusDef.PARTIAL_RECEIPT);
            }
        } else {
            param.setFilterObject("orderStatus", StatusConst.OrderStatusDef.ALL_RECEIPT);
        }
        super.modify(SqlId.SQL_ID_MODIFY_ORDER, param);

    }

    /**
     * 得到最终的返回结果
     *
     * @return
     * @OrderReceiptParam param
     */
    @Transactional
    public BaseOrderStatusResult getReceiptOrderResultInfo(OrderReceiptParam param) {
        BaseOrderStatusResult receiptResult = super.findOne(SqlId.SQL_ID_GET_ORDER_RESULT_INFO, param);
        BaseOrderStatusResult result = new BaseOrderStatusResult();
        result.setOrderId(receiptResult.getOrderId());
        result.setShipId(param.getShipId());
        result.setOrderStatus(receiptResult.getOrderStatus());
        result.setVer(receiptResult.getVer());
        result.setPaymentType(receiptResult.getPaymentType());
        return result;
    }

    /**
     * 检查订单当前状态
     *
     * @OrderDetailAndSuppInfo detailAndSuppInfo
     */
    @Transactional
    public boolean checkOrderReceiptStatus(OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (detailAndSuppInfo.getOrderStatus() != StatusConst.OrderStatusDef.PARTIAL_SHIPMENT
                && detailAndSuppInfo.getOrderStatus() != StatusConst.OrderStatusDef.ALL_SHIPMENT
                && detailAndSuppInfo.getOrderStatus() != StatusConst.OrderStatusDef.PARTIAL_RECEIPT) {
            return false;
        }
        return true;
    }

    /**
     * 得到最终的返回结果
     *
     * @param param
     * @return
     */
    @Transactional
    public BaseOrderStatusResult getOrderResultInfo(OrderDeliverParam param) {
        BaseOrderStatusResult result = super.findOne(SqlId.SQL_ID_GET_ORDER_RESULT_INFO, param);
        result.setShipId(param.getShipId());
        return result;
    }

    /**
     * 更新订单状态操作
     *
     * @param param
     */
    @Transactional
    public void modifyOrderShipStatus(OrderDeliverParam param) {
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setShipId(param.getShipId());
        modifyStatusParam.setUpdId(param.getUpdId());
        orderStatusLogic.modifyShipStatus(modifyStatusParam);
    }

    /**
     * 更新订单状态操作
     *
     * @param param
     */
    @Transactional
    public void modifyOrderStatus(OrderDeliverParam param) {
        ModifyStatusParam modifyStatusParam = new ModifyStatusParam();
        modifyStatusParam.setOrderId(param.getOrderId());
        modifyStatusParam.setUpdId(param.getUpdId());
        orderStatusLogic.modifyOrderStatusByOrderId(modifyStatusParam);
    }

    /**
     * 根据调用发货接口中的配送单信息处理
     *
     * @param param
     */
    @Transactional
    public void dealShipListInfo(OrderDeliverParam param, SoOrderShip soOrderShip) {
        List<OrderShipInfo> shipList = param.getShipList();

        for (OrderShipInfo orderShipInfo : shipList) {
            List<OrderShipProductInfo> productList = orderShipInfo.getProductList();
            if (CollectionUtils.isEmpty(productList)) {
                throw new BusinessException("产品数据不能为空");
            }
            param.setFilterObject("deliverCode", orderShipInfo.getDeliverCode());
            param.setFilterObject("shipId", param.getShipId());
            //#bug 3795   分批发货功能-发货通知单接收接口里无法接收多个相同的deliverCode    修改成 同一个ship  只能有不同的 deliverCode    但一个 deliverCode  可以有多个shipId
            Integer soDeliverCount = super.getCount(SqlId.SQL_ID_GET_DELIVER_COUNT, param);
            if (soDeliverCount > NumberConst.IntDef.INT_ZERO) {
                throw new BusinessException("同一发货单中配送单编码重复！！");
            }

            //得到配送数据
            SoDeliver soDeliver = dealSoDeliver(orderShipInfo, soOrderShip);
            soDeliver.setDeliverId(commonLogic.maxId("so_deliver", "DELIVER_ID"));
            //得到配送明细数据并且更新订单相关的明细数据
            List<SoDeliverDetail> deliverDetailList = getDeliverListAndModifyOrderInfo(productList, param, soDeliver);

            this.deliverLogic.saveDeliver(soDeliver, deliverDetailList);
        }
    }

    /**
     * 返回配送明细信息和更新发货数量和状态
     *
     * @param productList
     * @param param
     * @param soDeliver
     * @return
     */
    @Transactional
    public List<SoDeliverDetail> getDeliverListAndModifyOrderInfo(List<OrderShipProductInfo> productList, OrderDeliverParam param, SoDeliver soDeliver) {
        List<SoDeliverDetail> deliverDetailList = new ArrayList<SoDeliverDetail>();

        for (OrderShipProductInfo orderShipProductInfo : productList) {
            orderShipProductInfo.setShipId(param.getShipId());
            orderShipProductInfo.setOrderId(param.getOrderId());
            orderShipProductInfo.setOrderCode(param.getOrderCode());
            orderShipProductInfo.setUpdId(param.getUpdId());
            orderShipProductInfo.setUpdTime(DateTimeUtil.getCustomerDate());
            orderShipProductInfo.setPdCode(getPdCodeBySkuCode(orderShipProductInfo.getSkuCode()));

            OrderDetailAndSuppInfo detailAndSuppInfo = this.findOne(SqlId.SQL_ID_GET_SUPPLY_INFO, orderShipProductInfo);
            if (null == detailAndSuppInfo) {
                throw new BusinessException("发货单号和明细信息对不上");
            }

            orderShipProductInfo.setPdName(detailAndSuppInfo.getPdName());
            orderShipProductInfo.setOrderDetailId(detailAndSuppInfo.getOrderDetailId());
            //更新明细和供货明细数据
            modifyDetailAndSupInfo(orderShipProductInfo, detailAndSuppInfo);

            SoDeliverDetail soDeliverDetail = dealSoDeliverDetail(soDeliver, detailAndSuppInfo, orderShipProductInfo);

            deliverDetailList.add(soDeliverDetail);
        }

        return deliverDetailList;
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
     * 处理配送数据
     *
     * @param soDeliver
     * @param detailAndSuppInfo
     * @param orderShipProductInfo
     * @return
     */
    @Transactional
    public SoDeliverDetail dealSoDeliverDetail(SoDeliver soDeliver, OrderDetailAndSuppInfo detailAndSuppInfo, OrderShipProductInfo orderShipProductInfo) {
        SoDeliverDetail soDeliverDetail = new SoDeliverDetail();

        soDeliverDetail.setDeliverId(soDeliver.getDeliverId());
        soDeliverDetail.setDeliverCode(soDeliver.getDeliverCode());
        soDeliverDetail.setOrderId(orderShipProductInfo.getOrderId());
        soDeliverDetail.setOrderCode(orderShipProductInfo.getOrderCode());
        soDeliverDetail.setOrderDetailId(detailAndSuppInfo.getOrderDetailId());
        soDeliverDetail.setOrderDetailAvailabilityId(detailAndSuppInfo.getDetailAvailabilityId());
        soDeliverDetail.setSupplierCode(detailAndSuppInfo.getSupplierCode());
        soDeliverDetail.setPdCode(detailAndSuppInfo.getPdCode());
        soDeliverDetail.setPdName(detailAndSuppInfo.getPdName());
        soDeliverDetail.setDeliverQty(orderShipProductInfo.getSendQty());
        soDeliverDetail.setCrtTime(DateTimeUtil.getCustomerDate());
        soDeliverDetail.setCrtId(orderShipProductInfo.getUpdId());

        return soDeliverDetail;
    }

    /**
     * 根据发货明细数据更新订单明细表和订单供货明细表中数据
     *
     * @param orderShipProductInfo
     */
    @Transactional
    public void modifyDetailAndSupInfo(OrderShipProductInfo orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (checkOrderStatus(detailAndSuppInfo)) {
            throw new BusinessException("订单状态不为可发货状态");
        }

        //更新订单明细数据
        modifyDetailInfo(orderShipProductInfo, detailAndSuppInfo);
        //更新订单供货明细数据
        modifySuppInfo(orderShipProductInfo, detailAndSuppInfo);
    }

    /**
     * 发货时判断订单状态是否可以发货
     *
     * @param detailAndSuppInfo
     * @return
     */
    @Transactional
    public boolean checkOrderStatus(OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (detailAndSuppInfo.getOrderStatus() != StatusConst.OrderStatusDef.WAIT_SEND
                && detailAndSuppInfo.getOrderStatus() != StatusConst.OrderStatusDef.PARTIAL_SHIPMENT
                && detailAndSuppInfo.getOrderStatus() != StatusConst.OrderStatusDef.PARTIAL_RECEIPT) {
            return true;
        }
        return false;
    }

    /**
     * 1.根据已经查到的明细数据和发货要求里面的数量进行判断是否满足要求
     * 2.进行更新订单明细表
     *
     * @param orderShipProductInfo
     * @param detailAndSuppInfo
     */
    @Transactional
    public void modifyDetailInfo(OrderShipProductInfo orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {

        if (checkOrderDetailStatus(detailAndSuppInfo)) {
            throw new BusinessException("订单明细状态不为可发货状态");
        }

        //发货数量
        BigDecimal sendQty = orderShipProductInfo.getSendQty();
        //明细表中可发货数量
        BigDecimal detailQty = detailAndSuppInfo.getDetailQty();

        if (sendQty.compareTo(detailQty) > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("发货数量大于明细可发货数量");
        }

        //设置明细状态为全部发货还是部分发货
        if (detailAndSuppInfo.getDetailStatus() != StatusConst.OrderDetailStatusDef.PARTIAL_RECEIPT) {
            if (sendQty.compareTo(detailQty) == NumberConst.IntDef.INT_ZERO) {
                orderShipProductInfo.setStatus(StatusConst.OrderDetailStatusDef.ALL_SHIPMENT);
            } else {
                orderShipProductInfo.setStatus(StatusConst.OrderDetailStatusDef.PARTIAL_SHIPMENT);
            }
        } else {
            orderShipProductInfo.setStatus(detailAndSuppInfo.getDetailStatus());
        }

        super.modify(SqlId.SQL_ID_MODIFY_DETAIL_STATUS_AND_QTY, orderShipProductInfo);
    }

    /**
     * 发货时判断订单明细状态是否可以发货
     *
     * @param detailAndSuppInfo
     * @return boolean
     */
    @Transactional
    public boolean checkOrderDetailStatus(OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (detailAndSuppInfo.getDetailStatus() != StatusConst.OrderDetailStatusDef.WAIT_SEND
                && detailAndSuppInfo.getDetailStatus() != StatusConst.OrderDetailStatusDef.PARTIAL_SHIPMENT
                && detailAndSuppInfo.getDetailStatus() != StatusConst.OrderDetailStatusDef.PARTIAL_RECEIPT) {
            return true;
        }
        return false;
    }

    /**
     * 发货时判断订单发货明细状态是否可以发货
     *
     * @param detailAndSuppInfo
     * @return
     */
    @Transactional
    public boolean checkOrderSuppStatus(OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (detailAndSuppInfo.getSuppStatus() != StatusConst.OrderDetailAvailabilityStatusDef.WAIT_SEND
                && detailAndSuppInfo.getSuppStatus() != StatusConst.OrderDetailAvailabilityStatusDef.PARTIAL_SHIPMENT
                && detailAndSuppInfo.getSuppStatus() != StatusConst.OrderDetailAvailabilityStatusDef.PARTIAL_RECEIPT) {
            return true;
        }
        return false;
    }

    /**
     * 1.根据已经查到的供货明细数据和发货要求里面的数量进行判断是否满足要求
     * 2.进行更新供货明细表
     *
     * @param orderShipProductInfo
     * @param detailAndSuppInfo
     */
    @Transactional
    public void modifySuppInfo(OrderShipProductInfo orderShipProductInfo, OrderDetailAndSuppInfo detailAndSuppInfo) {
        if (checkOrderSuppStatus(detailAndSuppInfo)) {
            throw new BusinessException("供货明细状态不为可发货状态");
        }

        //发货数量
        BigDecimal sendQty = orderShipProductInfo.getSendQty();
        //供货明细表中可发货数量
        BigDecimal suppQty = detailAndSuppInfo.getSuppQty();

        if (sendQty.compareTo(suppQty) > NumberConst.IntDef.INT_ZERO) {
            throw new BusinessException("发货数量大于供货数量");
        }

        //设置供货明细状态为全部发货还是部分发货
        if (detailAndSuppInfo.getSuppStatus() != StatusConst.OrderDetailAvailabilityStatusDef.PARTIAL_RECEIPT) {
            if (sendQty.compareTo(suppQty) == NumberConst.IntDef.INT_ZERO) {
                orderShipProductInfo.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.ALL_SHIPMENT);
            } else {
                orderShipProductInfo.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.PARTIAL_SHIPMENT);
            }
        } else {
            orderShipProductInfo.setStatus(detailAndSuppInfo.getSuppStatus());
        }


        super.modify(SqlId.SQL_ID_MODIFY_SUPP_STATUS_AND_QTY, orderShipProductInfo);
    }

    /**
     * 根据调用发货接口信息处理配送信息
     *
     * @param orderShipInfo
     * @return
     */
    @Transactional
    public SoDeliver dealSoDeliver(OrderShipInfo orderShipInfo, SoOrderShip soOrderShip) {
        SoDeliver soDeliver = new SoDeliver();
        soDeliver.setDeliverId(commonLogic.maxId("so_deliver", "DELIVER_ID"));
        soDeliver.setOrderId(soOrderShip.getOrderId());
        soDeliver.setOrderCode(soOrderShip.getOrderCode());
        soDeliver.setShipId(soOrderShip.getShipId());
        soDeliver.setShipCode(soOrderShip.getShipCode());
        soDeliver.setCrtId(soOrderShip.getCrtId());
        soDeliver.setCrtTime(DateTimeUtil.getCustomerDate());

        if (null == orderShipInfo) {
            return soDeliver;
        }

        if (!StringUtil.isEmpty(orderShipInfo.getDeliverCode())) {
            soDeliver.setDeliverCode(orderShipInfo.getDeliverCode());
        }

        if (!StringUtil.isEmpty(orderShipInfo.getDeliverPerson())) {
            soDeliver.setDeliverPerson(orderShipInfo.getDeliverPerson());
        }

        if (!StringUtil.isEmpty(orderShipInfo.getPersonMobile())) {
            soDeliver.setPersonMobile(orderShipInfo.getPersonMobile());
        }
        if (!StringUtil.isEmpty(orderShipInfo.getDeliverDate())) {
            soDeliver.setDeliverDate(DateTimeUtil.parseDate(orderShipInfo.getDeliverDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
        }

        if (null != orderShipInfo.getDeliverMode()) {
            soDeliver.setDeliverMode(orderShipInfo.getDeliverMode());
        }

        if (!StringUtil.isEmpty(orderShipInfo.getExpectReceiveDate())) {
            soDeliver.setExpectReceiveDate(DateTimeUtil.parseDate(orderShipInfo.getExpectReceiveDate(), DateTimeUtil.FORMAT_DATE_YYYYMMDDHHMMSS));
        }

        if (!StringUtil.isEmpty(orderShipInfo.getRemarks())) {
            soDeliver.setRemarks(orderShipInfo.getRemarks());
        }

        return soDeliver;
    }

    /**
     * 1、check传入参数，
     * 2、第一次收货时更新价格，根据订单收款金额判断是否取消剩余
     *
     * @param param
     * @return 本次收货金额
     */
    @Transactional
    public BigDecimal checkParamAndUpdateOrder(OrderReceiptParam param) {
        SoOrderShip soOrderShip = super.findOne(SqlId.SQL_ID_GET_ORDER_SHIP_INFO_RECEIPT, param);
        if (null == soOrderShip) {
            throw new BusinessException("该发货单ID找不到合适的发货单信息或者该发货单已进行过收货操作");
        }
        param.setOrderId(soOrderShip.getOrderId());

        List<OrderShipInfo> shipList = param.getShipList();
        if (CollectionUtils.isEmpty(shipList)) {
            throw new BusinessException("收货单信息不能为空");
        }
        List<PaymentInfo> paymentList = param.getPaymentList();

        // 本次收货货物金额
        BigDecimal shipAmount = null;
        for (OrderShipInfo ship : shipList) {
            for (OrderShipProductInfo product : ship.getProductList()) {
                if (product.getReceivePrice() == null || product.getReceiveQty() == null) {
                    throw new BusinessException("收货数量或收货价格不能为空");
                }
                shipAmount = DecimalUtil.add(shipAmount, DecimalUtil.multiply(product.getReceivePrice(), product.getReceiveQty()));
            }
        }

        // 第一次收货时计算更新单价、订单金额等                               全部收货，全部退货
        Integer shipCount = super.getCount(SqlId.SQL_ID_GET_SHIP_COUNT, param);
        if (shipCount == NumberConst.IntDef.INT_ZERO) {
            // 本次付款金额
            BigDecimal payAmount = null;
            if (!CollectionUtils.isEmpty(paymentList)) {
                for (PaymentInfo payment : paymentList) {
                    if (payment == null) {
                        throw new BusinessException("付款信息为空！");
                    }
                    payAmount = DecimalUtil.add(payAmount, payment.getPaymentMoney());
                }
            } else {
                throw new BusinessException("第一次收货时需添加付款信息");
            }
            if (DecimalUtil.isLess(payAmount, shipAmount)) {
                throw new BusinessException("支付金额小于本次收货货物金额");
            } else {
                if (!CollectionUtils.isEmpty(paymentList)) {
                    for (PaymentInfo payment : paymentList) {
                        SoPayment soPayment = new SoPayment();
                        soPayment.setPaymentId(commonLogic.maxId("SO_PAYMENT", "PAYMENT_ID"));
                        soPayment.setOrderId(soOrderShip.getOrderId());
                        soPayment.setOrderCode(soOrderShip.getOrderCode());
                        soPayment.setPayMode(payment.getPaymentMode());
                        soPayment.setPayAmount(payment.getPaymentMoney());
                        soPayment.setPayOrderCode(payment.getPaymentCode());
                        soPayment.setPayTime(DateTimeUtil.getCustomerDate());
                        soPayment.setCrtId(param.getUpdId());
                        soPayment.setCrtTime(DateTimeUtil.getCustomerDate());
                        super.save(soPayment);
                    }
                }
            }

            // 根据价盘表更新明细表价格
            super.modify(SqlId.SQL_ID_MODIFY_PRICE_BY_ORDER_ID, param);
            // 根据收货信息更新明细表价格
            for (OrderShipInfo ship : shipList) {
                for (OrderShipProductInfo product : ship.getProductList()) {
                    product.setUpdId(param.getUpdId());
                    product.setUpdTime(DateTimeUtil.getCustomerDate());
                    super.modify(SqlId.SQL_ID_MODIFY_PRICE_BY_SHIP_DETAIL_ID, product);
                }
            }

            // 计算剩余订单金额
            BigDecimal otherAmount = (BigDecimal) super.findObject(SqlId.SQL_ID_FIND_OTHER_AMOUNT, param);
            // 订单总金额
            BigDecimal orderAmount = DecimalUtil.add(otherAmount, shipAmount);
            // 付款金额小于订单金额或为0，且剩余订单金额大于0时，取消订单剩余部分
            if ((DecimalUtil.isLess(payAmount, orderAmount) || DecimalUtil.isEquals(payAmount, BigDecimal.ZERO)) && DecimalUtil.isGreater(otherAmount, BigDecimal.ZERO)) {
                // 取消订单剩余部分
                super.modify(SqlId.SQL_ID_CANCEL_AVA_DETAIL, param);
                super.modify(SqlId.SQL_ID_CANCEL_ORDER_DETAIL, param);
                param.setFilterObject("subsequent", NumberConst.IntDef.INT_ZERO);
            } else {
                if (DecimalUtil.isGreater(otherAmount, BigDecimal.ZERO)) {
                    param.setFilterObject("subsequent", NumberConst.IntDef.INT_ONE);
                } else {
                    param.setFilterObject("subsequent", NumberConst.IntDef.INT_ZERO);
                }
            }
            super.modify(SqlId.SQL_ID_MODIFY_ORDER_SUBSEQUENT, param);
        }
        return shipAmount;
    }

    /**
     * 保存支付记录
     *
     * @param param
     */
    public void saveSoPayment(BaseOrderStatusParam param, SoOrder soOrder) {
        param.setOrderCode(soOrder.getOrderCode());
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        param.setPaymentId(commonLogic.maxId("SO_PAYMENT", "PAYMENT_ID"));
        super.save(SqlId.SQL_ID_SAVE_PAYMENT, param);
    }


    /**
     * 根据OrderId查询ShipId（整单取消时调用）
     *
     * @param orderId 订单ID
     */
    @Transactional
    public List<SoOrderShip> getShipIdsByOrderId(Long orderId) {
        BaseParam param = new BaseParam();
        param.setFilterObject("orderId", orderId);
        List<SoOrderShip> soOrderShips = super.findList(SqlId.SQL_GET_SHIP_ID_BY_ORDER_ID, param);
        return soOrderShips;
    }

    interface SqlId {
        String SQL_ID_MODIFY_SO_ORDER_ALL_RECEIPT = "modifyAllReceipt";
        String SQL_ID_MODIFY_SO_ORDER_FIND_DETAIL = "findDetail";
        String SQL_ID_MODIFY_SO_ORDER_FIND_RELATION_ID = "findRelationId";
        String SQL_ID_MODIFY_SO_ORDER_FIND_RELATION = "findRelation";
        String SQL_ID_FIND_SO_ORDER_DETAIL_AVAILABILITY = "findOrderDetailAvailability";
        String SQL_ID_FIND_SO_ORDER_DETAIL_SUM_AVAILABILITY = "findOrderDetailSumAvailability";
        String SQL_ID_FIND_SO_ORDER_DETAILS = "findDetails";
        String SQL_ID_FIND_SO_ORDER_DETAIL_AVAILABILITYS = "findDetailAvailabilitys";
        String SQL_ID_FIND_SO_ORDER_DETAIL = "findOrderDetail";
        String SQL_ID_MODIFY_SO_ORDER_DETAIL_AVAILABILITY_APART_RECEIVE_STATUS = "modifyOrderDetailAvailabilityApartReceiveStatus";
        String SQL_ID_MODIFY_SO_ORDER_DETAIL_APART_RECEIVE_STATUS = "modifyOrderDetailApartReceiveStatus";
        String SQL_ID_MODIFY_SO_ORDER_APART_RECEIVE_STATUS = "modifyOrderApartReceiveStatus";
        String SQL_ID_MODIFY_SO_ORDER_DETAIL_STATUS = "modifyOrderDetailStatus";
        String SQL_ID_GET_SUPPLY_INFO = "getSupplyInfo";
        String SQL_ID_MODIFY_DETAIL_STATUS_AND_QTY = "modifyDetailStatusAndQty";
        String SQL_ID_MODIFY_SUPP_STATUS_AND_QTY = "modifySuppStatusAndQty";
        String SQL_ID_GET_ORDER_SHIP_INFO = "getOrderShipInfo";
        String SQL_ID_GET_ORDER_RESULT_INFO = "getOrderResultInfo";
        String SQL_ID_MODIFY_DETAIL_RECEIPT_STATUS_AND_QTY = "modifyDetailReceiptStatusAndQty";
        String SQL_ID_MODIFY_AVA_DETAIL_RECEIPT_STATUS_AND_QTY = "modifyAvaDetailReceiptStatusAndQty";
        String SQL_ID_GET_SUPPLY_INFO_FOR_RECEIPT = "getSupplyInfoForReceipt";
        String SQL_ID_MODIFY_DELIVER_ACTUAL_TIME = "modifyDeliverActualTime";
        String SQL_ID_MODIFY_DELIVER_DETAIL_INFO = "modifyDeliverDetailInfo";
        String SQL_ID_GET_RECEIPT_DELIVER_COUNT = "getReceiptDeliverCount";
        String SQL_ID_GET_DELIVER_COUNT = "getDeliverCount";
        String SQL_ID_SAVE_PAYMENT = "savePayment";
        String SQL_ID_FIND_SO_ORDER = "findSoOrder";
        String SQL_ID_FIND_AVA_DETAIL = "findAvaDetail";

        String SQL_ID_GET_ORDER_SHIP_INFO_RECEIPT = "getOrderShipInfoReceipt";
        String SQL_ID_GET_SHIP_COUNT = "getShipCount";
        String SQL_ID_MODIFY_PRICE_BY_ORDER_ID = "modifyPriceByOrderId";
        String SQL_ID_MODIFY_PRICE_BY_SHIP_DETAIL_ID = "modifyPriceByShipDetailId";
        String SQL_ID_FIND_OTHER_AMOUNT = "findOtherAmount";
        String SQL_ID_CANCEL_AVA_DETAIL = "cancelOtherAvaDetail";
        String SQL_ID_CANCEL_ORDER_DETAIL = "cancelOtherOrderDetail";
        String SQL_ID_MODIFY_ORDER_SUBSEQUENT = "modifyOrderSubsequent";
        String SQL_ID_MODIFY_ORDER_SHIP = "modifyOrderShip";
        String SQL_ID_FIND_RELATION = "findOrderRelation";
        String SQL_ID_GET_CHILD_LEFT_COUNT = "getChildLeftCount";
        String SQL_ID_GET_CHILD_RECEIVE_COUNT = "getChildReceiveCount";
        String SQL_ID_GET_LEFT_COUNT = "getLeftCount";
        String SQL_ID_MODIFY_CHILD_ORDER = "modifyChildOrder";
        String SQL_ID_MODIFY_ORDER = "modifyOrder";
        String SQL_GET_SHIP_ID_BY_ORDER_ID = "getShipIdsByOrderId";

        String SQL_FIND_ORDER_RELATION_BY_MAIN_ORDER_ID = "findOrderRelationByMainOrderId";
        String SQL_FIND_ORDER_INFO_BY_CHILD_ORDER_ID = "findOrderInfoByChildOrderId";
        String SQL_FIND_ORDER_DETAILS_BY_CHILD_ORDER_ID = "findOrderDetailsByChildId";
        String SQL_GET_BUYER_COUNT_BY_BUYER_ID = "getBuyerCountByBuyerId";
        String SQL_GET_CONFIRMED_COUNT = "getConfirmedCount";
        String SQL_FIND_PACACKAGE_QTY = "findPackageQty";
        String SQL_ID_MODIFY_ORDER_PENDING_AUDIT = "modifyOrderPendingAudit";
        String SQL_ID_MODIFY_SUB_ORDER_DETAIL_PENDING_AUDIT = "modifySubOrderDetailPendingAudit";
        String SQL_ID_MODIFY_SUB_ORDER_DETAIL_AVAILABILITY_PENDING_AUDIT = "modifySubOrderDetailAvailabilityPendingAudit";
        String SQL_ID_GET_EMAIL_ADDRESS = "getEmailAddress";
        String SQL_ID_MODIFY_ORDER_SHIP_INFO = "modifyOrderShipInfo";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
