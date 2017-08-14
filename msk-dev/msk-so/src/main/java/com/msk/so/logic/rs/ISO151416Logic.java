package com.msk.so.logic.rs;

import com.msk.common.consts.OrderConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerBasicInfo;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * *ISO151416Logic
 * *@author jiang_nan
 * *@version 1.0
 */
@Service
public class ISO151416Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 得到返回的订单明细信息
     *
     * @param orderSearchParam
     * @return
     */
    @Transactional(readOnly = true)
    public List<BaseOrderSearchResult> getOrderInfo(BaseOrderSearchParam orderSearchParam) {
        List<OrderDetailSearchParam> orderList = orderSearchParam.getOrders();
        List<OrderDetailSearchParam> orders = null;
        if (!CollectionUtils.isEmpty(orderList)) {
            orders = dealOrderDetailInfo(orderList);
        }
        orderSearchParam.setOrders(orders);

        List<BaseOrderSearchResult> results = this.findList(SqlId.SQL_ID_GET_ORDER_INFO, orderSearchParam);

        if (!CollectionUtils.isEmpty(results)) {
            for (BaseOrderSearchResult result : results) {
                BaseParam param = new BaseParam();
                param.getFilterMap().put("orderId", result.getOrderId());
                // 设置 paidTime  ,paidAmount   zhangqiang  #bug554
                BaseOrderSearchResult orderPay = this.getPayByOrderId(param);
                BaseReceiverInfo receiveInfo = this.getBaseReceiverInfo(param);
                BaseDeliveryReq deliveryReq = this.getBaseDeliveryReq(param);
                if(orderPay!=null){
                    result.setPaidTime(orderPay.getPaidTime());
                    result.setPaidAmount(orderPay.getPaidAmount());
                }
                if (receiveInfo != null) {
                    receiveInfo.setFilterMap(null);
                }
                if (deliveryReq != null) {
                    deliveryReq.setFilterMap(null);
                }
                result.setReceiveInfo(receiveInfo);
                result.setDeliveryReq(deliveryReq);
                List<SoOrderDetail> orderDetails = getOrderDetailsInfo(param);
                result.setOrderDetail(orderDetails);
            }
        }
        return results;
    }


    /**
     * 编辑传参orders中的id和code
     *
     * @param orderList
     * @return
     */
    @Transactional
    public List<OrderDetailSearchParam> dealOrderDetailInfo(List<OrderDetailSearchParam> orderList) {
        List<OrderDetailSearchParam> orders = new ArrayList<OrderDetailSearchParam>();
        for (OrderDetailSearchParam order : orderList) {
            if (!StringUtil.isEmpty(order.getOrderId())) {
                if (StringUtil.isEmpty(order.getOrderCode())) {
                    BaseParam newParam = new BaseParam();
                    newParam.getFilterMap().put("orderId", order.getOrderId());
                    order.setOrderCode((String) this.findObject(SqlId.SQL_ID_GET_ORDER_CODE_BY_ORDER_ID, newParam));
                }
                orders.add(order);
            }
            if (!StringUtil.isEmpty(order.getOrderCode())) {
                if (StringUtil.isEmpty(order.getOrderId())) {
                    BaseParam newParam = new BaseParam();
                    newParam.getFilterMap().put("orderCode", order.getOrderCode());
                    order.setOrderId((String) this.findObject(SqlId.SQL_ID_GET_ORDER_ID_BY_ORDER_CODE, newParam));
                }
                orders.add(order);
            }
            order.setFilterMap(null);
        }

        return orders;
    }


    /**
     * 获取订单支付金额（多次支付金额的累加），支付时间（最后一次支付时间）
     *
     * @param param
     * @return
     */
    public BaseOrderSearchResult getPayByOrderId(BaseParam param) {
        return (BaseOrderSearchResult) this.findObject(SqlId.SQL_ID_GET_PAY_BY_ORDER_ID, param);
    }


    /**
     * 得到收获信息
     *
     * @param param
     * @return
     */
    @Transactional
    public BaseReceiverInfo getBaseReceiverInfo(BaseParam param) {
        return (BaseReceiverInfo) this.findObject(SqlId.SQL_ID_GET_BASE_RECEIVER_INFO, param);
    }

    /**
     * 得到配送要求信息
     *
     * @param param
     * @return
     */
    @Transactional
    public BaseDeliveryReq getBaseDeliveryReq(BaseParam param) {
        return (BaseDeliveryReq) this.findObject(SqlId.SQL_ID_GET_BASE_DELIVERY_REQ, param);
    }

    /**
     * 得到订单明细信息
     *
     * @param param
     * @return
     */
    @Transactional
    public List<SoOrderDetail> getOrderDetailsInfo(BaseParam param) {
        return this.findList(SqlId.SQL_ID_GET_ORDER_DETAILS_INFO, param);
    }

    /**
     * 得到买家订单信息
     *
     * @param param
     * @return
     */
    @Transactional
    public List<BaseOrderSearchResult> getByOrders(OrderListSearchParam param, ListOrderSearchResult pageResult) {
        String buyersId = param.getBuyersId();
        String buyersCode = param.getBuyersCode();
        String orderSource = param.getOrderSource();
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou Start.
        String orderStatus = param.getOrderStatus();
        if (!StringUtil.isEmpty(orderStatus)) {
            String[] orderStatusArry = param.getOrderStatus().split(",");
            param.setStatusArry(orderStatusArry);
        }
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou end.
        if (StringUtil.isEmpty(buyersId) && StringUtil.isEmpty(buyersCode)) {
            throw new BusinessException("获得买家订单明细时候,没有买家Code或者买家Id或者订单来源无法获得数据");
        }
        //当系统平台是微商城的时候，从买家基本信息表中查询买家ID和买家CODE
        if (orderSource.equals(String.valueOf(NumberConst.IntDef.INT_THREE))) {
            if (StringUtil.isEmpty(buyersCode)) {
                throw new BusinessException("请输入买家编码");
            }
            param.setTel(param.getBuyersCode());
            int count = super.getCount(SqlId.SQL_ID_GET_BY_BASIC_COUNT, param);
            if (NumberConst.IntDef.INT_ZERO == count) {
                throw new BusinessException("该手机号的买家不存在");
            }
            ByBuyerBasicInfo buyerBasicInfo = super.findOne(SqlId.SQL_ID_GET_BY_BASIC_INFO, param);
            if (!StringUtil.isEmpty(buyerBasicInfo.getBuyerId()) && !StringUtil.isEmpty(buyerBasicInfo.getBuyerCode())) {
                param.setBuyersId(buyerBasicInfo.getBuyerId());
                param.setBuyersCode(buyerBasicInfo.getBuyerCode());
            }
            // 需要同时显示微商城和PC端的订单，目前只显示了微商城
            // 剔除orderSource检索条件
            param.setOrderSource(null);
        }
        List<BaseOrderSearchResult> results = new ArrayList<>();
        //查询时候有改买家的订单
        int count = super.getCount(SqlId.SQL_ID_GET_BY_ORDER_COUNT, param);
        pageResult.setTotalCount(count);
        pageResult.setPageNo(param.getPageNo());
        pageResult.setTotalPage(pageResult.getTotalCount(), param.getPageCount());
        if (pageResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            //查询该买家订单信息
            results = this.findList(SqlId.SQL_ID_GET_BY_ORDER_INFO, param);
        }
        BaseParam param1 = new BaseParam();
        for (BaseOrderSearchResult result : results) {
            param1.setFilterObject("orderId", result.getOrderId());
            //查询该买家的订单明细信息
            List<SoOrderDetail> orderDetails = getOrderDetailsInfo(param1);
            result.setOrderDetail(orderDetails);
        }
        return results;
    }

    @Transactional
    public ByBuyerBasicInfo getBasicBuyerInfo(OrderListSearchParam param) {
        ByBuyerBasicInfo buyerBasicInfo = super.findOne(SqlId.SQL_ID_GET_BY_BASIC_INFO, param);
        if (null != buyerBasicInfo) {
            if (StringUtil.isEmpty(buyerBasicInfo.getBuyerId()) && StringUtil.isEmpty(buyerBasicInfo.getBuyerCode()) && StringUtil.isEmpty(buyerBasicInfo.getBuyerName()) && StringUtil.isEmpty(buyerBasicInfo.getSuperiorType())) {
                throw new BusinessException("请核对买家基本信息!");
            }
            return buyerBasicInfo;
        } else {
            throw new BusinessException("没有该手机号的买家基本信息");
        }
    }

    /**
     * 得到卖家订单信息
     *
     * @param param
     * @return
     */
    @Transactional
    public List<BaseOrderSearchResult> getSlOrders(OrderListSearchParam param, ListOrderSearchResult pageResult) {
        String slCode = param.getSellerCode();
        String orderSource = param.getOrderSource();
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou Start.
        String orderStatus = param.getOrderStatus();
        if (!StringUtil.isEmpty(orderStatus)) {
            String[] orderStatusArry = param.getOrderStatus().split(",");
            param.setStatusArry(orderStatusArry);
        }
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou end.
        if (StringUtil.isEmpty(slCode) || StringUtil.isEmpty(orderSource)) {
            throw new BusinessException("获得卖家订单列表信息时候,没有卖家Code或者订单来源无法获得数据");
        }
        List<BaseOrderSearchResult> results = new ArrayList<>();
        //查询是否有改卖家的订单
        int count = super.getCount(SqlId.SQL_ID_GET_SL_ORDER_COUNT, param);
        pageResult.setTotalCount(count);
        pageResult.setPageNo(param.getPageNo());
        pageResult.setTotalPage(pageResult.getTotalCount(), param.getPageCount());
        if (pageResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            //查询该卖家的订单信息
            results = this.findList(SqlId.SQL_ID_GET_SL_ORDER_INFO, param);
        }
        BaseParam param1 = new BaseParam();
        for (BaseOrderSearchResult result : results) {
            param1.setFilterObject("orderId", result.getOrderId());
            //查询该卖家的订单明细信息
            List<SoOrderDetail> orderDetails = getOrderDetailsInfo(param1);
            result.setOrderDetail(orderDetails);
        }
        return results;
    }


    /**
     * 得到买手销售订单信息
     *
     * @param param
     * @return
     */
    @Transactional
    public List<BaseOrderSearchResult> getBbsOrders(OrderListSearchParam param, ListOrderSearchResult pageResult) {
        String slCode = param.getSellerCode();
        String orderSource = param.getOrderSource();
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou Start.
        String orderStatus = param.getOrderStatus();
        if (!StringUtil.isEmpty(orderStatus)) {
            String[] orderStatusArry = param.getOrderStatus().split(",");
            param.setStatusArry(orderStatusArry);
        }
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou end.
        if (StringUtil.isEmpty(slCode) || StringUtil.isEmpty(orderSource)) {
            throw new BusinessException("获得买手销售订单列表信息时候,没有卖家Code或者订单来源无法获得数据");
        }
        //根据订单来源判断买手销售订单和第三方买手销售订单
        switch (orderSource) {
            case "1":
                param.setOrderType(String.valueOf(OrderConst.OrderType.BUYER_SALE_ORDER));
                break;
            case "2":
                param.setOrderType(String.valueOf(OrderConst.OrderType.THIRD_BUYER_SALE_ORDER));
                break;
            default:
                break;
        }
        List<BaseOrderSearchResult> results = new ArrayList<>();
        //查询是否有改买手的销售订单
        int count = super.getCount(SqlId.SQL_ID_GET_BBS_ORDER_COUNT, param);
        pageResult.setTotalCount(count);
        pageResult.setPageNo(param.getPageNo());
        pageResult.setTotalPage(pageResult.getTotalCount(), param.getPageCount());
        if (pageResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            //查询该买手的销售订单信息
            results = this.findList(SqlId.SQL_ID_GET_BBS_ORDER_INFO, param);
        }
        BaseParam param1 = new BaseParam();
        for (BaseOrderSearchResult result : results) {
            param1.setFilterObject("orderId", result.getOrderId());
            //查询该买手的销售订单明细信息
            List<SoOrderDetail> orderDetails = getOrderDetailsInfo(param1);
            result.setOrderDetail(orderDetails);
        }
        return results;
    }

    /**
     * 得到买手囤货订单信息
     *
     * @param param
     * @return
     */
    @Transactional
    public List<BaseOrderSearchResult> getBbsgOrders(OrderListSearchParam param, ListOrderSearchResult pageResult) {
        String buyerId = param.getBuyersId();
        String buyerCode = param.getBuyersCode();
        String orderSource = param.getOrderSource();
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou Start.
        String orderStatus = param.getOrderStatus();
        if (!StringUtil.isEmpty(orderStatus)) {
            String[] orderStatusArry = param.getOrderStatus().split(",");
            param.setStatusArry(orderStatusArry);
        }
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou end.
        if (StringUtil.isEmpty(buyerId) || StringUtil.isEmpty(buyerCode) || StringUtil.isEmpty(orderSource)) {
            throw new BusinessException("获得买手囤货订单列表信息时候,没有买家ID或者买家Code或者订单来源无法获得数据");
        }
        //根据订单来源判断买手囤货订单，第三方买手囤货订单
        switch (orderSource) {
            case "1":
                param.setOrderType(String.valueOf(OrderConst.OrderType.BUYER_STOCKPILING_ORDER));
                break;
            case "2":
                param.setOrderType(String.valueOf(OrderConst.OrderType.THIRD_BUYER_ORDER));
                break;
            default:
                break;
        }
        List<BaseOrderSearchResult> results = new ArrayList<>();
        //查询是否有该买手的囤货订单
        int count = super.getCount(SqlId.SQL_ID_GET_BBSG_ORDER_COUNT, param);
        pageResult.setTotalCount(count);
        pageResult.setPageNo(param.getPageNo());
        pageResult.setTotalPage(pageResult.getTotalCount(), param.getPageCount());
        if (pageResult.getTotalCount() != NumberConst.IntDef.INT_ZERO) {
            //查询该买手的囤货订单信息
            results = this.findList(SqlId.SQL_ID_GET_BBSG_ORDER_INFO, param);
        }
        BaseParam param1 = new BaseParam();
        for (BaseOrderSearchResult result : results) {
            param1.setFilterObject("orderId", result.getOrderId());
            //查询该买手的囤货订单明细信息
            List<SoOrderDetail> orderDetails = getOrderDetailsInfo(param1);
            result.setOrderDetail(orderDetails);
        }
        return results;
    }


    interface SqlId {
        String SQL_ID_GET_ORDER_INFO = "getOrderInfo";
        String SQL_ID_GET_PAY_BY_ORDER_ID = "getPayByOrderId";
        String SQL_ID_GET_BASE_DELIVERY_REQ = "getBaseDeliveryReq";
        String SQL_ID_GET_BASE_RECEIVER_INFO = "getBaseReceiverInfo";
        String SQL_ID_GET_ORDER_DETAILS_INFO = "getOrderDetailsInfo";
        String SQL_ID_GET_ORDER_CODE_BY_ORDER_ID = "getOrderCodeByOrderId";
        String SQL_ID_GET_ORDER_ID_BY_ORDER_CODE = "getOrderIdByOrderCode";
        String SQL_ID_GET_BY_ORDER_COUNT = "getByOrderCount";
        String SQL_ID_GET_SL_ORDER_COUNT = "getSlOrderCount";
        String SQL_ID_GET_BBS_ORDER_COUNT = "getBbsOrderCount";
        String SQL_ID_GET_BBSG_ORDER_COUNT = "getBbsgOrderCount";
        String SQL_ID_GET_BBSG_ORDER_INFO = "getBbsgOrderInfo";
        String SQL_ID_GET_BBS_ORDER_INFO = "getBbsOrderInfo";
        String SQL_ID_GET_SL_ORDER_INFO = "getSlOrderInfo";
        String SQL_ID_GET_BY_ORDER_INFO = "getByOrderInfo";
        String SQL_ID_GET_BY_BASIC_INFO = "getByBasicInfo";
        String SQL_ID_GET_BY_BASIC_COUNT = "getByBasicCount";
    }
}
