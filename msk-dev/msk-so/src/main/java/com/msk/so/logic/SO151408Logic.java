package com.msk.so.logic;

import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.entity.SoOrderReceiveDemand;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.SO15140801Bean;
import com.msk.so.bean.SO151408Param;
import org.apache.commons.collections.map.HashedMap;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * SO151408Logic
 *
 * @author
 * @version 1.0
 **/
@Service
public class SO151408Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SO151408Logic.class);
    @Autowired
    private OrderLogic orderLogic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private SO15140801Logic so15140801Logic;

    interface SqlId {
        String SQL_ID_SAVE_ORDER_DETAIL = "saveOrderDetail";
    }

    @Transactional
    @Override
    public int save(BaseParam param) {
        logger.debug("订单插入页面插入操作");
        Date customerDate = DateTimeUtil.getCustomerDate();
        SO151408Param SO151408Param = (SO151408Param) param;

        //插入订单主表
        SoOrder order = SO151408Param.getOrder();
        Long orderId = commonLogic.maxId("so_order", "ORDER_ID");
        String orderCode = orderLogic.getOrderCode(order.getOrderType(), order.getBuyersCode(), null);
        order.setOrderTime(customerDate);
        order.setCrtTime(customerDate);
        order.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
        order.setOrderId(orderId);
        order.setOrderCode(orderCode);
        order.setOrderViceCode(orderLogic.getOrderCode(customerDate));
        order.setRequireOrderCode(orderCode);
        if (order.getOrderAmount() == null) {
            order.setOrderAmount(BigDecimal.ZERO);
        }
        order.setBuyersId(String.valueOf(NumberConst.IntDef.INT_ZERO));

        //订单状态
        order.setOrderStatus(this.getOrderStatus(order.getPaymentType(), order.getOrderType()));
        this.orderLogic.saveOrder(order);

        //插入买家收货要求表
        Long receiveDemandId = commonLogic.maxId("so_order_receive_demand", "ID");
        SoOrderReceiveDemand soOrderReceiveDemand = SO151408Param.getOrderReceiveDemand();
        soOrderReceiveDemand.setOrderId(order.getOrderId());
        soOrderReceiveDemand.setOrderCode(order.getOrderCode());
        soOrderReceiveDemand.setId(receiveDemandId);
        soOrderReceiveDemand.setCrtTime(customerDate);
        this.orderLogic.saveOrderReceiveDemand(soOrderReceiveDemand);

        //插入订单详细表
        List<SO15140801Bean> orderDetailList = SO151408Param.getOrderDetailList();
        if (!CollectionUtils.isEmpty(orderDetailList)) {
            for (int i = 0; i < orderDetailList.size(); i++) {
                SO15140801Bean soOrderDetail = orderDetailList.get(i);
                soOrderDetail.setOrderId(order.getOrderId());
                soOrderDetail.setOrderCode(order.getOrderCode());
                soOrderDetail.setOrderDetailType(NumberConst.IntDef.INT_ONE);
                if (order.getOrderSource() == OrderConst.OrderSource.SNK) {
                    soOrderDetail.setDetailStatus(StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION);
                } else {
                    soOrderDetail.setDetailStatus(StatusConst.OrderDetailStatusDef.CONFIRM);
                }
                soOrderDetail.setCrtTime(customerDate);
                Long orderDetailId = commonLogic.maxId("so_order_detail", "ORDER_DETAIL_ID");
                soOrderDetail.setOrderDetailId(orderDetailId);
                orderLogic.save(SqlId.SQL_ID_SAVE_ORDER_DETAIL, soOrderDetail);

                //第三方订单时需要插入订单供货明细表
                Integer orderType = order.getOrderType();
                if (orderType != OrderConst.OrderType.DISTRIBUTION_ORDER && orderType != OrderConst.OrderType.BUYER_STOCKPILING_ORDER
                        && orderType != OrderConst.OrderType.BUYER_SALE_ORDER) {
                    SoOrderDetailAvailability availability = this.getAvailability(order, soOrderDetail, customerDate);
                    so15140801Logic.save(availability);
                }

            }
        }

        return NumberConst.IntDef.INT_ONE;
    }

    /**
     * 获取订单状态
     *
     * @param paymentType
     * @param orderType
     * @return
     */
    private Integer getOrderStatus(Integer paymentType, Integer orderType) {
        Integer orderStatus = null;
        if (OrderConst.PaymentType.PAYING_ONLINE == paymentType) {
            //线上付款
            switch (orderType) {
                case OrderConst.OrderType.DISTRIBUTION_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.OBLIGATION;
                    break;
                case OrderConst.OrderType.THIRD_PARTY_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.OBLIGATION;
                    break;
                case OrderConst.OrderType.BIG_PROMOTION_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.OBLIGATION;
                    break;
                case OrderConst.OrderType.BUYER_STOCKPILING_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.OBLIGATION;
                    break;
                case OrderConst.OrderType.BUYER_SALE_ORDER:
                    //orderStatus = StatusConst.OrderStatusDef.CONFIRM;
                    //买手销售订单创建状态为待付款
                    orderStatus = StatusConst.OrderStatusDef.OBLIGATION;
                    break;
                case OrderConst.OrderType.THIRD_BUYER_SALE_ORDER:
                    //orderStatus = StatusConst.OrderStatusDef.CONFIRM;
                    //第三方买手销售订单创建状态为待付款
                    orderStatus = StatusConst.OrderStatusDef.OBLIGATION;
                    break;
                case OrderConst.OrderType.THIRD_BUYER_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.OBLIGATION;
                    break;
                default:
                    break;
            }
        } else {
            //线下付款
            switch (orderType) {
                case OrderConst.OrderType.DISTRIBUTION_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.WAIT_DISTRIBUTION;
                    break;
                case OrderConst.OrderType.THIRD_PARTY_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.CONFIRM;
                    break;
                case OrderConst.OrderType.BIG_PROMOTION_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.WAIT_DISTRIBUTION;
                    break;
                case OrderConst.OrderType.BUYER_STOCKPILING_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.WAIT_DISTRIBUTION;
                    break;
                case OrderConst.OrderType.BUYER_SALE_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.CONFIRM;
                    break;
                case OrderConst.OrderType.THIRD_BUYER_SALE_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.CONFIRM;
                    break;
                case OrderConst.OrderType.THIRD_BUYER_ORDER:
                    orderStatus = StatusConst.OrderStatusDef.CONFIRM;
                    break;
                default:
                    break;
            }
        }


        return orderStatus;
    }

    /**
     * 插入订单供货明细表
     *
     * @param order
     * @param soOrderDetail
     * @param customerDate
     * @return
     */
    private SoOrderDetailAvailability getAvailability(SoOrder order, SO15140801Bean soOrderDetail, Date customerDate) {
        Long availabilityId = commonLogic.maxId("so_order_detail_availability", "ORDER_DETAIL_AVAILABILITY_ID");
        SoOrderDetailAvailability availability = new SoOrderDetailAvailability();
        availability.setOrderId(order.getOrderId());
        availability.setOrderCode(order.getOrderCode());
        availability.setOrderDetailId(soOrderDetail.getOrderDetailId());
        availability.setOrderDetailAvailabilityId(availabilityId);
        availability.setSupplierCode(soOrderDetail.getSupplierCode());
        availability.setSupplierName(soOrderDetail.getSupplierName());
        availability.setClassesCode(soOrderDetail.getClassesCode());
        availability.setClassesName(soOrderDetail.getClassesName());
        availability.setBreedCode(soOrderDetail.getBreedCode());
        availability.setBreedName(soOrderDetail.getBreedName());
        availability.setFeatureCode(soOrderDetail.getFeatureCode());
        availability.setFeatureName(soOrderDetail.getFeatureName());
        //availability.setNormsCode(soOrderDetail.getNormsCode());
        //availability.setNormsName(soOrderDetail.getNormsName());
        availability.setPdCode(soOrderDetail.getPdCode());
        availability.setPdName(soOrderDetail.getPdName());
        availability.setPdLevel(soOrderDetail.getPdLevel());
        availability.setPdGradeCode(soOrderDetail.getPdGradeCode());
        availability.setPdGradeName(soOrderDetail.getPdGradeName());
        availability.setUnit(soOrderDetail.getUnit());
        availability.setSuppQty(soOrderDetail.getOrderQty());
        availability.setDelFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
        availability.setVer(NumberConst.IntDef.INT_ONE);
        availability.setCrtTime(customerDate);
        availability.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
        if (null != soOrderDetail.getPackingVolume()) {
            availability.setPackingVolume(soOrderDetail.getPackingVolume());
        }
        if (null != soOrderDetail.getNormsName()) {
            availability.setNormsName(soOrderDetail.getNormsName());
        }
        if (null != soOrderDetail.getWeight()) {
            availability.setWeight(soOrderDetail.getWeight());
        }
        if (null != soOrderDetail.getVolume()) {
            availability.setVolume(soOrderDetail.getVolume());
        }
        return availability;
    }

    @Transactional(readOnly = true)
    public JSONObject findBuyersJson(String buyersCode) {

        return null;
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
