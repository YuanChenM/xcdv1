package com.msk.so.logic.order;

import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.mail.MailHandle;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.CodeMasterConst;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import com.msk.so.bean.*;
import com.msk.so.bean.order.*;
import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.bean.rs.MailSendRsParam;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.StockLogic;
import com.msk.so.logic.order.level.IOrderDetailLevel;
import com.msk.so.logic.rs.ISO151414Logic;
import com.msk.so.orderstatus.OrderStatusContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import com.msk.sl.logic.SlProductLogic;
import com.msk.sl.bean.SlProductBean;

import java.math.BigDecimal;
import java.util.*;

/**
 * BaseOrderLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
public abstract class BaseOrder<T extends BaseOrderParam> extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BaseOrder.class);
    /**
     * Order Logic,数据插入数据库使用
     */
    @Autowired
    private OrderLogic orderLogic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private IOrderDetailLevel orderLevel;
    @Autowired
    private OrderStatusContext orderStatusContext;
    @Autowired
    private ProductLogic productLogic;
    @Autowired
    private StockLogic stockLogic;
    @Autowired
    private SlProductLogic slProductLogic;

    @Autowired
    private ISO151414Logic iso151414Logic;

    /**
     * 订单基本信息插入
     *
     * @param entity WebService或者Web页面添加数据对应的Entity
     * @return BaseOrderResult 订单结果
     */
    @Transactional
    public BaseOrderResult doOperate(T entity) {
        BaseOrderResult result = new BaseOrderResult();
        //设置Version值
//        result.setVer(NumberConst.IntDef.INT_ONE);
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
        BaseOrderParam orderInfo = this.createOrder(entity, customerDate);
        //订单ID
        long orderId = orderInfo.getOrderId();
        String orderCode = orderInfo.getOrderCode();
        int status = orderInfo.getOrderStatus();
        result.setOrderId(orderId);
        result.setOrderCode(orderCode);
        result.setOrderTime(customerDate);
        result.setOrderStatus(status);
        this.before(orderInfo);

        SoOrderReceiveDemand orderReceiveDemand = this.createOrderReceiveDemand(orderInfo, entity);
        if (orderReceiveDemand == null) {
            throw new BusinessException("没有订单要求信息数据,无法下单");
        }

        //获得订单明细信息
        List<BaseOrderDetailParam> orderDetailList = this.createOrderDetailList(orderInfo, entity);

        this.orderLogic.saveOrder(orderInfo, orderInfo.getSellerCode());
        //设置订单历史记录
        this.setOrderStatusRecord(orderId, orderCode, status, status, customerDate, orderInfo.getCrtId());
        this.orderLogic.saveOrderReceiveDemand(orderReceiveDemand);
        this.orderLogic.saveOrderDetail(orderDetailList);
        List<SoOrderDetailAvailability> orderDetailAvailability = this.createOrderDetailAvailability(orderDetailList);
        if (!CollectionUtils.isEmpty(orderDetailAvailability)) {
            this.orderLogic.saveOrderDetailAvailability(orderDetailAvailability);
        }
        this.after(orderInfo);
        BaseParam param = new BaseParam();
        param.setFilter("orderId", StringUtil.toSafeString(orderId));
        SoOrder order = this.orderLogic.findOne(param);
        result.setVer(order.getVer());
        this.orderLogic.saveCpTransaction(order);

        if (order.getOrderType().equals(OrderConst.OrderType.BUYER_STOCKPILING_ORDER)) {
            BaseParam baseParam = new BaseParam();
            baseParam.setFilter("orderId",order.getOrderId().toString());
            modifyOrderInfo(baseParam);
            modifyOrderDetailInfo(baseParam);
            result.setOrderStatus(StatusConst.OrderStatusDef.WAIT_DISTRIBUTION);
        }

        return result;
    }

    /**
     * 更新订单信息
     *
     * @param baseParam
     */
    @Transactional
    public void modifyOrderInfo(BaseParam baseParam) {
        baseParam.getFilterMap().put("orderStatus", StatusConst.OrderStatusDef.WAIT_DISTRIBUTION);
        orderLogic.modify(SqlId.SQL_ID_MODIFY_ORDER_INFO, baseParam);
        orderLogic.modify(SqlId.SQL_ID_MODIFY_ORDER_STATUS,baseParam);
    }

    /**
     * 更新订单明细信息
     *
     * @param baseParam
     */
    @Transactional
    public void modifyOrderDetailInfo(BaseParam baseParam) {
        baseParam.getFilterMap().put("orderDetailStatus", StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION);
        orderLogic.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_INFO,baseParam);
        orderLogic.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_STATUS,baseParam);
    }

    /**
     * 业务数据插入之前的处理,包括前期的Check操作
     *
     * @param entity Base Order Info
     */
    protected void before(SoOrder entity) {
        logger.debug("业务数据插入之前的处理,包括前期的Check操作");
    }

    /**
     * 业务数据插入之后的处理
     *
     * @param entity Base Order Info
     */
    protected void after(SoOrder entity) {
        logger.debug("业务数据插入之后的处理");
    }

    /**
     * 创建订单基础数据
     *
     * @param entity WebService或者Web页面添加数据对应的Entity
     * @return 订单数据
     */
    protected BaseOrderParam createOrder(T entity, Date customerDate) {
        BaseOrderParam order = entity;
        // 订单ID
        long orderId = this.createOrderId();
        order.setOrderId(orderId);
        if (order.getOrderType() != OrderConst.OrderType.BUYER_STOCKPILING_ORDER && order.getOrderType() != OrderConst.OrderType.THIRD_BUYER_ORDER) {
            // 获取买家编码(环标码)
            order.setBuyersCode(this.getBuyersCode(order));
        }
        // 订单编码
        String orderCode = orderLogic.getOrderCode(order.getOrderType(), order.getBuyersCode(), order.getCrtId());
        //需求订单编码
        String requireOrderCode = orderLogic.getAuxiliaryCode(customerDate, order.getBuyersCode());
        String splitDeliveryFlg = String.valueOf(NumberConst.IntDef.INT_ZERO);
        String returnFlg = String.valueOf(NumberConst.IntDef.INT_ZERO);
        order.setReturnFlg(returnFlg);
        order.setOrderCode(orderCode);
        // 订单辅码
        order.setOrderViceCode(this.getAuxiliaryCode(customerDate));
        // 订单类型
        int orderType = order.getOrderType();
        // 订单分类
        int paymentType = order.getPaymentType();
        //生成需求订单编码
        order.setRequireOrderCode(requireOrderCode);
        //第三方订单创建时生成订单确认编码
        if (orderType == NumberConst.IntDef.INT_TWO || orderType == NumberConst.IntDef.INT_SEVEN) {
            String orderConfirmCode = orderLogic.getConfirmCode();
            order.setConfirmOrderCode(orderConfirmCode);
        }
        //订单状态
        int status = this.getOrderStatus(orderType, paymentType);
        order.setOrderStatus(status);
        order.setCrtTime(customerDate);
        order.setOrderTime(customerDate);
        if (order.getOrderSource() != OrderConst.OrderSource.APP) {
            order.setOrderTaker(null);
            order.setOrderTakerType(null);
        }
        return order;
    }

    /**
     * 设置订单状态历史记录
     *
     * @param orderId      订单ID
     * @param orderCode    订单Code
     * @param newStatus    新状态
     * @param oldStatus    旧状态
     * @param customerDate 时间
     */
    protected void setOrderStatusRecord(long orderId, String orderCode, int newStatus, int oldStatus, Date customerDate, String crtId) {
        //调用共通设置订单状态
        OrderStatusParam orderStatusParam = new OrderStatusParam();
        orderStatusParam.setOrderId(orderId);
        orderStatusParam.setOrderCode(orderCode);
        orderStatusParam.setOldStatus(oldStatus);
        orderStatusParam.setNewStatus(newStatus);
        orderStatusParam.setCrtTime(customerDate);
        orderStatusParam.setCrtId(crtId);
        this.orderStatusContext.handle(orderStatusParam);
    }

    /**
     * 创建订单明细信息
     *
     * @param order  订单信息
     * @param entity 传入参数
     * @return 订单明细信息
     */
    @Transactional
    protected List<BaseOrderDetailParam> createOrderDetailList(BaseOrderParam order, BaseOrderParam entity) {
        List<BaseOrderDetailParam> orderDetailList = entity.getProducts();
        List<BaseOrderDetailParam> newOrderDetailList = new ArrayList<>();
        long orderId = order.getOrderId();
        String orderCode = order.getOrderCode();
        Date customerDate = order.getCrtTime();
        int orderType = order.getOrderType();
        String sellerCode = order.getSellerCode();
        Integer siteCode = order.getOrderSource();
        for (BaseOrderDetailParam orderDetail : orderDetailList) {
            //产品关联信息
            String productCode = orderDetail.getPdCode();
            String pdName = orderDetail.getPdName();
            //供货商编码
            String supplyCode = orderDetail.getSupplierCode();
            StockParam param = new StockParam();
            param.setSlCode(sellerCode);
            param.setSupplierCode(supplyCode);
            param.setPdCode(productCode);
            param.setSupplyPlatform(siteCode);
            PdNormsStd pdNormsStd = this.slProductLogic.findOne(SqlId.SQL_ID_FIND_PRODUCT_INFO, param);
            if (null != pdNormsStd) {
                BigDecimal qty = orderDetail.getOrderQty();
                orderDetail.setNormsName(pdNormsStd.getNormsOut());
                BigDecimal normsVolume = pdNormsStd.getNormsVolume().setScale(2).divide(BigDecimal.valueOf(1000000));
                orderDetail.setPackingVolume(normsVolume);
                orderDetail.setWeight((pdNormsStd.getNetweightOut().multiply(qty)).setScale(2, BigDecimal.ROUND_HALF_UP));
                orderDetail.setVolume((normsVolume.multiply(qty)).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
            //断货判断
            if (stockLogic.shortSupplyProduct(param)) {
                //根据【卖家ID、卖家产品ID】查询sl_product
                //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou Start.
                List<SlProductBean> slProductBeans = slProductLogic.findProduct(sellerCode, productCode);
                if (!CollectionUtils.isEmpty(slProductBeans)) {
                    for (SlProductBean slProductBean : slProductBeans) {
                        //将查询结果插入sl_product_status_his,状态=8
                        slProductBean.setStatus(CodeMasterConst.slProductStatus.DH);//设为断货处理
                        slProductBean.setHisId(commonLogic.maxId("sl_product_status_his", "HIS_ID"));
                        slProductLogic.saveProductStatusHis(slProductBean);
                    }
                    //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou end.
                }
                logger.info("产品" + pdName + "断货");
                //continue;
            }
            orderDetail.setOrderId(orderId);
            //订单Code
            orderDetail.setOrderCode(orderCode);
            orderDetail.setCrtId(order.getCrtId());
            //create time
            orderDetail.setCrtTime(customerDate);
            //设置订单明细等级,共通处理
            orderDetail.setOrderDetailLevel(this.getOrderDetailLevel(orderDetail));
            //设置订单状态
            int orderDetailStatus = this.getOrderDetailStatus(orderType);
            orderDetail.setDetailStatus(orderDetailStatus);

            BigDecimal orderPrice = orderDetail.getOrderPrice();
            orderDetail.setPdPrice(orderPrice);
            this.setProduct(productCode, orderDetail);
            newOrderDetailList.add(orderDetail);
        }
        return newOrderDetailList;
    }


    /**
     * 创建订单要求信息表
     *
     * @param order  订单基本信息
     * @param entity 参数
     * @return 订单要求信息
     */
    protected SoOrderReceiveDemand createOrderReceiveDemand(SoOrder order, T entity) {
        SoOrderReceiveDemand orderReceiveDemand = new SoOrderReceiveDemand();
        orderReceiveDemand.setOrderId(order.getOrderId());
        orderReceiveDemand.setOrderCode(order.getOrderCode());
        orderReceiveDemand.setId(this.createOrderReceiveDemandId());
        orderReceiveDemand.setCrtId(order.getCrtId());
        orderReceiveDemand.setCrtTime(order.getCrtTime());
        orderReceiveDemand.setVicFlg("1");
        BaseReceiverInfo receiverInfo = entity.getReceiverInfo();
        if (receiverInfo == null) {
            throw new BusinessException("创建订单时候,收货信息不能为空");
        }
        this.createOrderReceiverInfo(entity.getReceiverInfo(), orderReceiveDemand);
        this.createDeliveryReq(entity.getDeliveryReq(), orderReceiveDemand);
        return orderReceiveDemand;
    }

    /**
     * 创建订单明细供货信息表
     *
     * @param orderDetailParamList 订单信息
     * @return 订单明细供货信息表
     */
    protected List<SoOrderDetailAvailability> createOrderDetailAvailability(List<BaseOrderDetailParam> orderDetailParamList) {
        return null;
    }

    protected void createInvoice(BaseInvoiceReq invoiceReq) {

    }

    /**
     * 创建订单要求表主键ID
     *
     * @return 订单要求表主键ID
     */
    private Long createOrderReceiveDemandId() {
        return this.commonLogic.maxId("SO_ORDER_RECEIVE_DEMAND", "ID");
    }

    /**
     * 创建订单配送要求信息
     *
     * @param deliveryReq        订单配送要求信息
     * @param orderReceiveDemand 订单配送要求
     */
    protected void createDeliveryReq(BaseDeliveryReq deliveryReq, SoOrderReceiveDemand orderReceiveDemand) {
        //配送要求信息不是必输信息。
        if (null == deliveryReq) {
            return;
        }
        orderReceiveDemand.setVicFlg(String.valueOf(deliveryReq.getVicFlg()));
        orderReceiveDemand.setUnloadReq(deliveryReq.getUnloadReq());
        orderReceiveDemand.setPackingReq(deliveryReq.getPackingReq());
        orderReceiveDemand.setParkingDistance(deliveryReq.getParkingDistance());
        orderReceiveDemand.setOtherDeliveryReq(deliveryReq.getOtherDeliveryReq());
        orderReceiveDemand.setThisDeliveryReq(deliveryReq.getThisDeliveryReq());

    }

    /**
     * 创建订单收货信息
     *
     * @param receiverInfo       订单收货信息
     * @param orderReceiveDemand 订单配送要求
     */
    protected void createOrderReceiverInfo(BaseReceiverInfo receiverInfo, SoOrderReceiveDemand orderReceiveDemand) {
        orderReceiveDemand.setReceiverName(receiverInfo.getReceiverName());
        orderReceiveDemand.setReceiverQq(receiverInfo.getReceiverQQ());
        orderReceiveDemand.setReceiverWeixin(receiverInfo.getReceiverWeixin());
        orderReceiveDemand.setReceiverTel(receiverInfo.getReceiverTel());
        orderReceiveDemand.setReceiverProvince(receiverInfo.getReceiverProvince());
        orderReceiveDemand.setReceiverCity(receiverInfo.getReceiverCity());
        orderReceiveDemand.setReceiverDistrict(receiverInfo.getReceiverDistrict());
        orderReceiveDemand.setReceiverAddr(receiverInfo.getReceiverAddr());
        orderReceiveDemand.setReceiveTime(receiverInfo.getReceiveTime());
        orderReceiveDemand.setReceiveEarliest(receiverInfo.getReceiveEarliest());
        orderReceiveDemand.setReceiveLast(receiverInfo.getReceiveLast());
        orderReceiveDemand.setRemark(receiverInfo.getRemark());
        orderReceiveDemand.setRemark2(receiverInfo.getRemark2());
        orderReceiveDemand.setRemark3(receiverInfo.getRemark3());
        orderReceiveDemand.setRemark4(receiverInfo.getRemark4());
        if (!StringUtil.isEmpty(receiverInfo.getReceiverAddr2())) {
            orderReceiveDemand.setReceiverAddr2(receiverInfo.getReceiverAddr2());
        }
        if (!StringUtil.isEmpty(receiverInfo.getReceiverAddrKey())) {
            orderReceiveDemand.setReceiverAddrKey(receiverInfo.getReceiverAddrKey());
        }
    }

    /**
     * 订单明细等级
     *
     * @param orderDetail 订单明细信息
     * @return 订单明细等级
     */
    private int getOrderDetailLevel(SoOrderDetail orderDetail) {
        return this.orderLevel.orderDetailLevel(orderDetail);
    }

    /**
     * 创建订单ID
     *
     * @return 订单ID
     */
    private long createOrderId() {
        return commonLogic.maxId("SO_ORDER", "ORDER_ID");
    }


    /**
     * 获得订单辅码信息
     *
     * @param customerDate 当前时间
     * @return 订单辅码
     */
    private String getAuxiliaryCode(Date customerDate) {
        return this.orderLogic.getOrderCode(customerDate);
    }

    /**
     * 获得订单创建时候,订单状态
     *
     * @param orderType   订单类型
     * @param paymentType 付款方式
     * @return 订单状态
     */
    private int getOrderStatus(int orderType, int paymentType) {
        // 任何订单类型,如果付款方式为线上支付的时候,订单状态都属于待付款
        if (paymentType == OrderConst.PaymentType.PAYING_ONLINE) {
            return StatusConst.OrderStatusDef.OBLIGATION;
        }
        // 订单类型为分销订单,买手囤货订单的时候,创建订单时候订单状态为待分销
        if (orderType == OrderConst.OrderType.DISTRIBUTION_ORDER
                || orderType == OrderConst.OrderType.BUYER_STOCKPILING_ORDER) {
            return StatusConst.OrderStatusDef.WAIT_DISTRIBUTION;
        }
        // 第三方订单创建的时候,因为已经处理了供应商供货情况,所以订单状态为确认.
        if (orderType == OrderConst.OrderType.THIRD_PARTY_ORDER
                // 第三方买手囤货订单创建的时候,因为已经处理了供应商供货情况,所以订单状态为确认.
                || orderType == OrderConst.OrderType.THIRD_BUYER_ORDER) {
            return StatusConst.OrderStatusDef.CONFIRM;
        }
        // 如果订单类型为买手销售订单,则需要判断该买手库存情况
        if (orderType == OrderConst.OrderType.BUYER_SALE_ORDER) {
            // TODO 实现库存数量分配
        }
        throw new BusinessException("无法定义订单状态");
    }

    /**
     * 获得订单明细状态
     *
     * @param orderType 订单类型
     * @return 订单明细状态
     */
    private int getOrderDetailStatus(int orderType) {
        // 订单类型为分销订单,买手囤货订单的时候,创建订单时候订单明细状态为待分销
        if (orderType == OrderConst.OrderType.DISTRIBUTION_ORDER
                || orderType == OrderConst.OrderType.BUYER_STOCKPILING_ORDER) {
            return StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION;
        }
        // 第三方订单创建的时候,因为已经处理了供应商供货情况,所以订单明细状态为待发货.
        if (orderType == OrderConst.OrderType.THIRD_PARTY_ORDER
                || orderType == OrderConst.OrderType.THIRD_BUYER_ORDER
                || orderType == OrderConst.OrderType.THIRD_BUYER_SALE_ORDER
                || orderType == OrderConst.OrderType.BUYER_SALE_ORDER) {
            return StatusConst.OrderDetailStatusDef.CONFIRM;
        }
        throw new BusinessException("无法定义订单明细状态");
    }

    @Transactional
    protected BaseOrderResult saveBuyersSaleOrder(T entity, Map<String, BaseOrderParam> orderListMap) {
        BaseOrderResult result = new BaseOrderResult();
        //设置Version值
        result.setVer(NumberConst.IntDef.INT_ONE);
        //创建主订单
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
        BaseOrderParam orderInfo = this.createOrder(entity, customerDate);
        SoOrderRelation orderRelation = new SoOrderRelation();

        long orderId = orderInfo.getOrderId();
        String orderCode = orderInfo.getOrderCode();
        String loginId = entity.getCrtId();
        orderRelation.setMainOrderCode(orderCode);
        orderRelation.setMainOrderId(orderId);
        orderInfo.setCrtId(loginId);
        orderInfo.setActId(loginId);
        orderInfo.setUpdId(loginId);
        orderInfo.setActTime(customerDate);
        orderInfo.setCrtTime(customerDate);
        orderInfo.setUpdTime(customerDate);

        //主订单买家信息
        String mainSellerCode = orderInfo.getSellerCode();

        this.orderLogic.saveOrder(orderInfo, mainSellerCode);

        //设置Version值
        result.setOrderId(orderId);
        //设置订单状态值
        result.setOrderStatus(orderInfo.getOrderStatus());
        //设置订单编码值
        result.setOrderCode(orderCode);
        //设置订单创建时间值
        result.setOrderTime(customerDate);

        //创建订单配送需求
        SoOrderReceiveDemand orderReceiveDemand = this.createOrderReceiveDemand(orderInfo, entity);
        if (orderReceiveDemand == null) {
            throw new BusinessException("没有订单要求信息数据,无法下单");
        }
        this.orderLogic.saveOrderReceiveDemand(orderReceiveDemand);

        //获得主订单明细信息      买手库存不足时
        BaseOrderParam mainOrder = orderListMap.get(null);
        List<BaseOrderDetailParam> orderDetailList = null;
        List<BaseOrderDetailParam> mainAndSubOrderDetails = new ArrayList<>();
        if (null != mainOrder) {
            orderDetailList = mainOrder.getProducts();
            if (!CollectionUtils.isEmpty(orderDetailList)) {
                orderDetailList = this.createOrderDetailList(orderInfo, mainOrder);
                mainAndSubOrderDetails.addAll(orderDetailList);
                this.orderLogic.saveOrderDetail(orderDetailList);
                for (BaseOrderDetailParam orderDetailParam : orderDetailList) {
                    List<SoOrderDetailAvailability> orderDetailAvailabilitieList = orderDetailParam.getOrderDetailAvailabilityList();
                    StockParam param = new StockParam();
                    BigDecimal qty = orderDetailParam.getOrderQty();
                    param.setPdCode(orderDetailParam.getPdCode());
                    PdNormsStd pdNormsStd = this.slProductLogic.findOne(SqlId.SQL_ID_FIND_PRODUCT_INFO, param);
                    if (!CollectionUtils.isEmpty(orderDetailAvailabilitieList)) {
                        for (SoOrderDetailAvailability orderDetailAvailability : orderDetailAvailabilitieList) {
                            orderDetailAvailability.setOrderId(orderId);
                            orderDetailAvailability.setOrderCode(orderCode);
                            orderDetailAvailability.setOrderDetailId(orderDetailParam.getOrderDetailId());
                            orderDetailAvailability.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
                            if (null != pdNormsStd) {
                                BigDecimal packVolume = pdNormsStd.getNormsVolume().divide(BigDecimal.valueOf(1000000));
                                orderDetailAvailability.setVolume((packVolume.multiply(qty)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                orderDetailAvailability.setWeight((pdNormsStd.getNetweightOut().multiply(qty)).setScale(2, BigDecimal.ROUND_HALF_UP));
                                orderDetailAvailability.setNormsName(pdNormsStd.getNormsOut());
                                orderDetailAvailability.setPackingVolume(packVolume);
                            }
                        }
                        this.orderLogic.saveOrderDetailAvailability(orderDetailAvailabilitieList);
                    }
                }
            }
        }
        for (Map.Entry<String, BaseOrderParam> entry : orderListMap.entrySet()) {
            String sellerCode = entry.getKey();
            BaseOrderParam subOrder = entry.getValue();
            if (!StringUtil.isEmpty(sellerCode)) {
                orderInfo.setSellerName(subOrder.getSellerName());
                orderInfo.setSellerCode(sellerCode);
                long subOrderId = this.createOrderId();
                orderInfo.setOrderId(subOrderId);
                int orderSource = orderInfo.getOrderSource();
                if (orderSource == OrderConst.OrderSource.SNK) {
                    orderInfo.setOrderType(OrderConst.OrderType.BUYER_SALE_ORDER);
                } else if (orderSource == OrderConst.OrderSource.MSK) {
                    orderInfo.setOrderType(OrderConst.OrderType.THIRD_BUYER_SALE_ORDER);
                } else if (orderSource == OrderConst.OrderSource.WSC) {
                    orderInfo.setOrderType(OrderConst.OrderType.BUYER_SALE_ORDER);
                } else if (orderSource == OrderConst.OrderSource.APP) {
                    orderInfo.setOrderType(OrderConst.OrderType.BUYER_SALE_ORDER);
                } else if (orderSource == OrderConst.OrderSource.NEW_WSC) {// 订单源头为新微商城
                    orderInfo.setOrderType(OrderConst.OrderType.BUYER_SALE_ORDER);
                } else if (orderSource == OrderConst.OrderSource.BUYER_APP) {
                    orderInfo.setOrderType(OrderConst.OrderType.BUYER_SALE_ORDER);
                }
                String subOrderCode = orderLogic.getOrderCode(orderInfo.getOrderType(), orderInfo.getBuyersCode(), orderInfo.getCrtId());
                orderInfo.setOrderCode(subOrderCode);
                //买手销售订单的状态都为已确认
                orderInfo.setOrderStatus(StatusConst.OrderStatusDef.CONFIRM);
                //插入订单
                orderRelation.setChildOrderCode(subOrderCode);
                orderRelation.setChildOrderId(subOrderId);
                orderRelation.setCrtId(orderRelation.getCrtId());
                orderRelation.setCrtTime(orderRelation.getCrtTime());
                //子订单总金额
                BigDecimal orderAmount = new BigDecimal(0);
                //子订单产品信息
                List<BaseOrderDetailParam> products = subOrder.getProducts();
                for (BaseOrderDetailParam orderDetailParam : products) {
                    BigDecimal orderPrice = orderDetailParam.getOrderPrice();
                    BigDecimal orderQty = orderDetailParam.getOrderQty();
                    orderAmount = orderAmount.add(orderPrice.multiply(orderQty));
                }
                orderInfo.setOrderAmount(orderAmount);

                this.orderLogic.saveOrder(orderInfo, mainSellerCode);
                this.orderLogic.saveOrderRelation(orderRelation);

                //插入订单配送要求
                orderReceiveDemand.setOrderId(subOrderId);
                orderReceiveDemand.setOrderCode(subOrderCode);
                //ID重新生成

                orderReceiveDemand.setId(this.createOrderReceiveDemandId());
                this.orderLogic.saveOrderReceiveDemand(orderReceiveDemand);
                //插入明细
                orderDetailList = this.createOrderDetailList(orderInfo, subOrder);
                mainAndSubOrderDetails.addAll(orderDetailList);
                this.orderLogic.saveOrderDetail(orderDetailList);
                for (BaseOrderDetailParam orderDetail : orderDetailList) {
                    List<SoOrderDetailAvailability> orderDetailAvailabilityList = orderDetail.getOrderDetailAvailabilityList();
                    StockParam param = new StockParam();
                    BigDecimal qty = orderDetail.getOrderQty();
                    param.setPdCode(orderDetail.getPdCode());
                    PdNormsStd pdNormsStd = this.slProductLogic.findOne(SqlId.SQL_ID_FIND_PRODUCT_INFO, param);
                    for (SoOrderDetailAvailability orderDetailAvailability : orderDetailAvailabilityList) {
                        BigDecimal packingVolume = pdNormsStd.getNormsVolume().divide(BigDecimal.valueOf(1000000));
                        orderDetailAvailability.setOrderId(orderInfo.getOrderId());
                        orderDetailAvailability.setOrderCode(orderInfo.getOrderCode());
                        orderDetailAvailability.setOrderDetailId(orderDetail.getOrderDetailId());
                        orderDetailAvailability.setVer(NumberConst.IntDef.INT_ONE);
                        orderDetailAvailability.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
                        orderDetailAvailability.setVolume((packingVolume.multiply(qty)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        orderDetailAvailability.setWeight((pdNormsStd.getNetweightOut().multiply(qty)).setScale(2, BigDecimal.ROUND_HALF_UP));
                        orderDetailAvailability.setNormsName(pdNormsStd.getNormsOut());
                        orderDetailAvailability.setPackingVolume(packingVolume);
                    }
                    this.orderLogic.saveOrderDetailAvailability(orderDetailAvailabilityList);
                }
                //线上付款，判断首单
                if(checkForPendingAuditStatus(orderInfo,products)){
                    modifySubOrderPendingAudit(orderInfo);
                    modifySubOrderDetailPendingAudit(orderInfo);
                    modifySubOrderDetailAvailabilityPendingAudit(orderInfo);
                }
            }
        }
        BaseParam param = new BaseParam();
        param.setFilterObject("orderId", result.getOrderId());
        //当主订单明细为空，并且不满足首单条件，付款方式为线下付款的时候
        if (null == mainOrder && orderInfo.getPaymentType() == OrderConst.PaymentType.CASH_ON_DELIVERY
                && !checkForPendingAuditStatus(orderInfo, orderDetailList)) {
            //主定单没有明细信息的时候，付款方式为货到付款时，订单状态为已确认
            String updId = orderInfo.getUpdId();
            Integer orderStatus = StatusConst.OrderStatusDef.CONFIRM;
            this.orderLogic.modifyOrderStatus(orderId, orderStatus, updId, customerDate);
            //设置主订单状态值
            result.setOrderStatus(StatusConst.OrderStatusDef.CONFIRM);
        }
        //只有全部走买手时，并且为线下付款，满足首单要求的才发送邮件
        if (null == mainOrder && checkForPendingAuditStatus(orderInfo, orderDetailList)
                && orderInfo.getPaymentType() == OrderConst.PaymentType.CASH_ON_DELIVERY) {
            modifySubOrderPendingAudit(orderInfo);
            modifySubOrderDetailPendingAudit(orderInfo);
            modifySubOrderDetailAvailabilityPendingAudit(orderInfo);
            orderInfo = modifyMainOrderPendingAudit(orderInfo);
            sendMail(orderInfo);
        } else {
            //部分走平台的时候，判断订单下所有产品
            //mainAndSubOrderDetails:主子订单明细都包含，并且都判断
            if (checkForPendingAuditStatus(orderInfo, mainAndSubOrderDetails)
                    && orderInfo.getPaymentType() == OrderConst.PaymentType.CASH_ON_DELIVERY) {
                BaseOrderParam subOrderInfo = new BaseOrderParam();
                BaseParam baseParam = new BaseParam();
                baseParam.setFilterObject("orderId", orderInfo.getOrderId());
                SoOrderRelation soOrderRelation = orderLogic.findOne(SqlId.SQL_ID_FIND_RELATION_BY_ID, baseParam);
                if (null != soOrderRelation) {
                    subOrderInfo.setOrderId(soOrderRelation.getChildOrderId());
                    modifySubOrderPendingAudit(subOrderInfo);
                    modifySubOrderDetailPendingAudit(subOrderInfo);
                    modifySubOrderDetailAvailabilityPendingAudit(subOrderInfo);
                }
            }
        }
        SoOrder order = this.orderLogic.findOne(param);
        this.orderLogic.saveCpTransaction(order);
        return result;
    }

    /**
     * 设置产品相关数据
     *
     * @param productCode 产品Code
     * @param param       订单明细信息
     */
    private void setProduct(String productCode, BaseOrderDetailParam param) {
        ProductBean product = this.productLogic.getProductInfo(productCode);
        PdClasses productClasses = product.getPdClasses();
        if (null != productClasses) {
            param.setClassesCode(productClasses.getClassesCode());
            param.setClassesName(productClasses.getClassesName());
        }
        PdBreed productBreed = product.getPdBreed();
        if (null != productBreed) {
            param.setBreedCode(productBreed.getBreedCode());
            param.setBreedName(productBreed.getBreedName());
        }
        PdFeature productFeature = product.getPdFeature();
        if (null != productFeature) {
            param.setFeatureCode(productFeature.getFeatureCode());
            param.setFeatureName(productFeature.getFeatureName());
        }
        PdGrade productGrade = product.getPdGrade();
        if (null != productGrade) {
            param.setPdGradeCode(productGrade.getGradeCode());
            param.setPdGradeName(productGrade.getGradeName());
        }
        PdNormsStd productNormsStd = product.getPdNormsStd();
        if (null != productNormsStd) {
            param.setNormsCode(productNormsStd.getNormsCode());
        }

    }

    /**
     * 获取买家编码(环标码)
     *
     * @param param
     * @return 买家编码(环标码)
     */
    private String getBuyersCode(BaseOrderParam param) {
        BuyersRsParam buyersRsParam = new BuyersRsParam();
        buyersRsParam.setBuyerId(param.getBuyersId());
        buyersRsParam.setProvinceName(param.getReceiverInfo().getReceiverProvince());
        buyersRsParam.setCityName(param.getReceiverInfo().getReceiverCity());
        buyersRsParam.setDistrictName(param.getReceiverInfo().getReceiverDistrict());
        buyersRsParam.setDeliveryAddr(param.getReceiverInfo().getReceiverAddr());
        buyersRsParam.setCrtId(param.getCrtId());
        String buyersCode = this.orderLogic.getBuyersCode(buyersRsParam);
        if (StringUtil.isEmpty(buyersCode)) {
            throw new BusinessException("根据买家ID无法查询(环标码)买家编码！");
        }
        return buyersCode;
    }

    @Transactional
    private boolean checkForPendingAuditStatus(BaseOrderParam orderInfo, List<BaseOrderDetailParam> orderDetailList) {
        BaseParam param = new BaseParam();
        param.setFilterObject("buyersId", orderInfo.getBuyersId());
        param.setFilterObject("crtTime", orderInfo.getCrtTime());
        int buyersNum = orderLogic.getCount(SqlId.SQL_ID_COUNT_ORDERS_BY_BUYER_ID, param);
        //判断买家是否第一次下单
        if (buyersNum == NumberConst.IntDef.INT_ZERO) {
            logger.debug("买家ID为 " + orderInfo.getBuyersId() + " 的买家是第一次下单");
            return true;
        }
        //判断产品是否第一次下单
        if (!CollectionUtils.isEmpty(orderDetailList)) {
            for (BaseOrderDetailParam detailParam : orderDetailList) {
                BaseParam productParam = new BaseParam();
                productParam.setFilterObject("buyersId", orderInfo.getBuyersId());
                productParam.setFilterObject("pdCode", detailParam.getPdCode());
                productParam.setFilterObject("crtTime", orderInfo.getCrtTime());
                productParam.setFilterObject("status", StatusConst.OrderStatusDef.PENDING_AUDIT);
                productParam.setFilterObject("failStatus", StatusConst.OrderStatusDef.CANCEL);
                int productNum = orderLogic.getCount(SqlId.SQL_ID_GET_CONFIRMED_COUNT, productParam);
                if (productNum == 0) {
                    logger.debug("买家ID为 " + orderInfo.getBuyersId() + " ,产品编码为"
                    + detailParam.getPdCode() + " 的买家产品满足首单");
                    return true;
                }
            }
        }
        //判断下单产品数量
        Object packageQtyStr = orderLogic.findObject(SqlId.SQL_ID_FIND_PACKAGE_QTY, null);
        if (null != packageQtyStr && !CollectionUtils.isEmpty(orderDetailList)) {
            logger.debug("PackageQty为 " + String.valueOf(packageQtyStr));
            BigDecimal packageQty = new BigDecimal((String) packageQtyStr);
            for (BaseOrderDetailParam detailParam : orderDetailList) {
                BigDecimal orderQty = BigDecimal.ZERO;
                for(BaseOrderDetailParam pd : orderDetailList){
                    if(pd.getPdCode().equals(detailParam.getPdCode())){
                        orderQty = orderQty.add(pd.getOrderQty());
                    }
                    if (orderQty.compareTo(packageQty) > 0) {
                        logger.debug("产品编码为 " + detailParam.getPdCode() + " 的下单数量满足首单");
                        return true;
                    }
                }
            }
        } else {
            logger.debug("请设置PackageQty");
        }
        return false;
    }

    /**
     * 更新子订单状态为待审核
     *
     * @param orderInfo
     */
    @Transactional
    private void modifySubOrderPendingAudit(BaseOrderParam orderInfo) {
        BaseParam baseParam = new BaseParam();
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
        baseParam.setFilterObject("orderStatus", StatusConst.OrderStatusDef.PENDING_AUDIT);
        baseParam.setFilterObject("updTime", customerDate);
        baseParam.setFilterObject("orderId", orderInfo.getOrderId());
        orderLogic.modify(SqlId.SQL_ID_MODIFY_ORDER_PENDING_AUDIT, baseParam);
    }

    /**
     * 更新子订单明细状态为待审核
     *
     * @param orderInfo
     */
    @Transactional
    private void modifySubOrderDetailPendingAudit(BaseOrderParam orderInfo) {
        BaseParam baseParam = new BaseParam();
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
        baseParam.setFilterObject("detailStatus", StatusConst.OrderDetailStatusDef.PENDING_AUDIT);
        baseParam.setFilterObject("updTime", customerDate);
        baseParam.setFilterObject("orderId", orderInfo.getOrderId());
        orderLogic.modify(SqlId.SQL_ID_MODIFY_SUB_ORDER_DETAIL_PENDING_AUDIT, baseParam);
    }

    /**
     * 更新子订单供货明细状态为待审核
     *
     * @param orderInfo
     */
    @Transactional
    private void modifySubOrderDetailAvailabilityPendingAudit(BaseOrderParam orderInfo) {
        SoOrderDetailAvailability availability = new SoOrderDetailAvailability();
        Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
        availability.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.PENDING_AUDIT);
        availability.setUpdTime(customerDate);
        availability.setOrderId(orderInfo.getOrderId());
        orderLogic.modify(SqlId.SQL_ID_MODIFY_SUB_ORDER_DETAIL_AVAILABILITY_PENDING_AUDIT, availability);
    }

    @Transactional
    private BaseOrderParam modifyMainOrderPendingAudit(BaseOrderParam orderInfo) {
        //子订单状态
        Long childOrderId = orderInfo.getOrderId();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilterObject("childOrderId", childOrderId);
        //查询主订单ID
        SoOrderRelation soOrderRelation = orderLogic.findOne(SqlId.SQL_ID_FIND_MAIN_ORDER_ID_BY_CHILD_ORDER_ID, baseParam);
        orderInfo.setOrderStatus(StatusConst.OrderStatusDef.PENDING_AUDIT);
        orderInfo.setUpdTime(DateTimeUtil.getCustomerDate());
        orderInfo.setOrderId(soOrderRelation.getMainOrderId());
        orderInfo.setOrderCode(soOrderRelation.getMainOrderCode());
        //更新主订单状态为待审核
        baseParam.setFilterObject("orderStatus", StatusConst.OrderStatusDef.PENDING_AUDIT);
        baseParam.setFilterObject("updTime", DateTimeUtil.getCustomerDate());
        baseParam.setFilterObject("orderId", orderInfo.getOrderId());
        orderLogic.modify(SqlId.SQL_ID_MODIFY_ORDER_PENDING_AUDIT, baseParam);
        return orderInfo;
    }

    /**
     * 发送邮件
     */
    @Transactional
    private void sendMail(BaseOrderParam orderInfo) {
        MailSendRsParam param = setContent();
        String title = "买家订单审核通知";
        StringBuffer context = new StringBuffer();
        context.append("<p>此信为系统自动发送的买家订单审核通知，请不要回复 <br>");
        context.append("------------------------------------------------------------- <br>");
        context.append("<p>订单ID：" + orderInfo.getOrderId() + "</p>");
        context.append("<p>订单编码：" + orderInfo.getOrderCode() + "</p></p>");
        if (null != param) {
            try {
                logger.debug("邮件发送开始");
                for (String mailTo : param.getMailTo()) {
                    logger.debug("收件人:" + mailTo);
                }
                logger.debug("订单ID:" + orderInfo.getOrderId());
                logger.debug("订单编码:" + orderInfo.getOrderCode());
                MailHandle.sendHtmlEmail(title, context.toString(), param.getMailTo());
                logger.debug("邮件发送成功");
            } catch (Exception e) {
                logger.error("邮件发送失败", e);
            }
        }
    }

    @Transactional
    private MailSendRsParam setContent() {
        MailSendRsParam param = new MailSendRsParam();
        List<SoConstantBean> soConstantBeens = iso151414Logic.findList(SqlId.SQL_ID_GET_EMAIL_ADDRESS, new BaseParam());
        if (CollectionUtils.isEmpty(soConstantBeens)) {
            logger.debug("没有收件人，请配置收件人邮箱");
            return null;
        }
        List<String> mailToAddresses = new ArrayList<String>();
        for (SoConstantBean soConstantBean : soConstantBeens) {
            mailToAddresses.add(soConstantBean.getEmailAddress());
        }
        String[] arr = mailToAddresses.toArray(new String[0]);
        param.setMailTo(arr);
        for (String mailTo : arr) {
            logger.debug("将发送给:" + mailTo);
        }
        return param;
    }

    interface SqlId {
        String SQL_ID_FIND_PRODUCT_INFO = "findProductInfo";
        String SQL_ID_COUNT_ORDERS_BY_BUYER_ID = "countOrdersByBuyerId";
        String SQL_ID_COUNT_PRODUCT_BY_PRODUCT_CODE = "countProductByProductCode";
        String SQL_ID_FIND_PACKAGE_QTY = "findPackageQty";
        String SQL_ID_MODIFY_ORDER_PENDING_AUDIT = "modifyOrderPendingAudit";
        String SQL_ID_MODIFY_SUB_ORDER_DETAIL_PENDING_AUDIT = "modifySubOrderDetailPendingAudit";
        String SQL_ID_MODIFY_SUB_ORDER_DETAIL_AVAILABILITY_PENDING_AUDIT = "modifySubOrderDetailAvailabilityPendingAudit";
        String SQL_ID_GET_EMAIL_ADDRESS = "getEmailAddress";
        String SQL_ID_FIND_MAIN_ORDER_ID_BY_CHILD_ORDER_ID = "findMainOrderIdByChildOrderId";
        String SQL_ID_GET_CONFIRMED_COUNT = "orderCreateGetConfirmedCount";
        String SQL_ID_FIND_RELATION_BY_ID = "findRelationById";
        String SQL_ID_MODIFY_ORDER_INFO = "modifyOrderInfoByOrderId";
        String SQL_ID_MODIFY_ORDER_STATUS = "modifyOrderStatusByOrderId";
        String SQL_ID_MODIFY_ORDER_DETAIL_INFO = "modifyOrderDetailInfoByOrderId";
        String SQL_ID_MODIFY_ORDER_DETAIL_STATUS = "modifyOrderDetailStatusByOrderId";
    }

}
