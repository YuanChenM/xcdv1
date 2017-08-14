package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.pd.logic.ProductLogic;
import com.msk.so.bean.*;
import com.msk.so.bean.SO151402Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chen_xin
 * @version 创建时间：2015年12月25日 下午2:05:49
 */
@Service
public class SO151402Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private ProductLogic productLogic;

    /**
     * SqlId. 方法名
     *
     * @author xhy
     */
    interface SqlId {
        String SQL_ID_FIND_ORDER_DETAIL_INFO = "findOrderDetailInfo";
        String SQL_ID_FIND_ORDER_DETAIL_AVAILABILITY_INFO = "findSoOrderDetailAvailability";
        String SQL_ID_QUERY_ORDER_BUYERS = "queryOrderBuyers";
        String SQL_ID_QUERY_BASE_ORDER = "queryBaseOrder";
        String SQL_ID_QUERY_ORDER_DELIVERY = "queryOrderDelivery";
        String SQL_ID_FIND_CHILD_ORDER = "findChildOrder";
        String SQL_ID_MODIFY_ORDER_INFO = "modifyOrderInfo";
        String SQL_ID_MODIFY_ORDER_DETAIL_INFO = "modifyOrderDetailInfo";
        String SQL_ID_MODIFY_ORDER_STATUS = "modifyOrderStatus";
        String SQL_ID_MODIFY_ORDER_DETAIL_STATUS = "modifyOrderDetailStatus";
        String SQL_ID_QUERY_ORDER_RELATION = "queryOrderRelation";
        String SQL_ID_REMOVE_AVAILABILITY_STATUS = "removeAvailabilityStatus";
        String SQL_ID_REMOVE_AVAILABILITY = "removeAvailability";
        String SQL_ID_REMOVE_DETAIL_STATUS = "removeDetailStatus";
        String SQL_ID_REMOVE_DETAIL = "removeDetail";
        String SQL_ID_REMOVE_DELIVER_DETAIL = "removeDeliverDetail";
        String SQL_ID_REMOVE_DELIVER = "removeDeliver";
        String SQL_ID_REMOVE_RECEIVE_DEMAND = "removeReceiveDemand";
        String SQL_ID_REMOVE_ORDER_RELATION = "removeOrderRelation";
        String SQL_ID_REMOVE_ORDER_STATUS = "removeOrderStatus";
        String SQL_ID_REMOVE_ORDER = "removeOrder";
        String SQL_ID_QUERY_RECEIVE_TIME = "queryReceiveTime";
        String SQL_ID_QUERY_NET_WEIGHT_OUT = "findNetWeightOut";
        String SQL_ID_QUERY_PD_GRADE = "findPdGrade";
        String SQL_ID_FIND_ORDER_DELEVER="findOrderDeliver";
        String SQL_ID_GET_CHILD_COUNT="getChildCount";
    }

    /**
     * 根据订单ID获得分销订单明细
     *
     * @return result
     * @author chen_xin
     * update gyh
     * updateTime 2016.1.4
     */
    public List<SO151402Bean> queryResult() {
        List<SO151402Bean> soOrderDetails = new ArrayList<SO151402Bean>();
        SO151402Bean so251108Bean1 = new SO151402Bean();
        so251108Bean1.setOrderId(1L);
        so251108Bean1.setOrderCode("001");
        so251108Bean1.setOrderDetailId(1L);
        so251108Bean1.setOrderDetailType(1);
        so251108Bean1.setOrderDetailLevel(1);
        so251108Bean1.setClassesCode("01");
        so251108Bean1.setClassesName("鸡产品");
        so251108Bean1.setBreedCode("03");
        so251108Bean1.setBreedName("单冻琵琶腿");
        so251108Bean1.setFeatureCode("01");
        so251108Bean1.setFeatureName("80-100g");
        so251108Bean1.setNormsCode("001");
        so251108Bean1.setNormsName("0.3公斤*3包");
        so251108Bean1.setPdCode("0103011001");
        so251108Bean1.setPdName("鸡肉类三黄土鸡");
        so251108Bean1.setUnit("1.05kg*10");
        so251108Bean1.setPackingVolume(new BigDecimal("0.09"));
        so251108Bean1.setWeight(new BigDecimal("90"));
        so251108Bean1.setVolume(new BigDecimal("9"));
        so251108Bean1.setAgreeJoint("0");
        so251108Bean1.setIsJoint("0");
        so251108Bean1.setBuyersConfirmShipments(1);
        so251108Bean1.setPdPrice(new BigDecimal("10"));
        so251108Bean1.setPdPriceAll(new BigDecimal("2000.00"));
        so251108Bean1.setPriceCycle("2");
        so251108Bean1.setOrderQty(new BigDecimal("200"));
        so251108Bean1.setSendQty(new BigDecimal("200"));
        so251108Bean1.setReceiveQty(new BigDecimal("200"));
        so251108Bean1.setCancelQty(new BigDecimal("0"));
        so251108Bean1.setReturnQty(new BigDecimal("0"));
        so251108Bean1.setSendTime(DateTimeUtil.parseDate("2016-01-01", "yyyy-MM-dd"));
        so251108Bean1.setReceivedTime(DateTimeUtil.parseDate("2016-01-05", "yyyy-MM-dd"));
        so251108Bean1.setDetailStatusName("全部收货");
        so251108Bean1.setDetailStatus(1);
        so251108Bean1.setCancelReason("");
        List<SoOrderDetailAvailability> soOrderDetailAvailabilities1 = new ArrayList<SoOrderDetailAvailability>();
        SoOrderDetailAvailability soOrderDetailAvailability1 = new SoOrderDetailAvailability();
        soOrderDetailAvailability1.setOrderId(1l);
        soOrderDetailAvailability1.setOrderCode("001");
        soOrderDetailAvailability1.setOrderDetailId(1l);
        soOrderDetailAvailability1.setSupplierCode("101010001");
        soOrderDetailAvailability1.setSupplierName("上海浦东新区公司");
        soOrderDetailAvailability1.setClassesCode("01");
        soOrderDetailAvailability1.setClassesName("鸡产品");
        soOrderDetailAvailability1.setBreedCode("03");
        soOrderDetailAvailability1.setBreedName("单冻琵琶腿");
        soOrderDetailAvailability1.setFeatureCode("01");
        soOrderDetailAvailability1.setFeatureName("80-100g");
        soOrderDetailAvailability1.setNormsCode("001");
        soOrderDetailAvailability1.setNormsName("80-100g");
        soOrderDetailAvailability1.setPdCode("0103011001");
        soOrderDetailAvailability1.setPdName("鸡肉类三黄土鸡");
        // soOrderDetailAvailability1.setPdLevel("312-xx-345");
        soOrderDetailAvailability1.setUnit("闵行区供货商");
        soOrderDetailAvailability1.setReturnQty(new BigDecimal("150"));
        soOrderDetailAvailability1.setSendQty(new BigDecimal("150"));
        soOrderDetailAvailability1.setReceiveQty(new BigDecimal("150"));
        soOrderDetailAvailability1.setCancelQty(new BigDecimal("0"));
        soOrderDetailAvailability1.setReturnQty(new BigDecimal("0"));
        soOrderDetailAvailabilities1.add(soOrderDetailAvailability1);

        SoOrderDetailAvailability soOrderDetailAvailability11 = new SoOrderDetailAvailability();
        soOrderDetailAvailability11.setOrderId(1l);
        soOrderDetailAvailability11.setOrderCode("001");
        soOrderDetailAvailability11.setOrderDetailId(1l);
        soOrderDetailAvailability11.setSupplierCode("101020003");
        soOrderDetailAvailability11.setSupplierName("上海市黄浦区公司");
        soOrderDetailAvailability11.setClassesCode("01");
        soOrderDetailAvailability11.setClassesName("鸡产品");
        soOrderDetailAvailability11.setBreedCode("03");
        soOrderDetailAvailability11.setBreedName("单冻琵琶腿");
        soOrderDetailAvailability11.setFeatureCode("01");
        soOrderDetailAvailability11.setFeatureName("80-100g");
        soOrderDetailAvailability11.setNormsCode("001");
        soOrderDetailAvailability11.setNormsName("80-100g");
        soOrderDetailAvailability11.setPdCode("0103011001");
        soOrderDetailAvailability11.setPdName("鸡肉类三黄土鸡");
        // soOrderDetailAvailability11.setPdLevel("312-xx-345");
        soOrderDetailAvailability11.setUnit("闵行区供货商");
        soOrderDetailAvailability11.setReturnQty(new BigDecimal("50"));
        soOrderDetailAvailability11.setSendQty(new BigDecimal("50"));
        soOrderDetailAvailability11.setReceiveQty(new BigDecimal("40"));
        soOrderDetailAvailability11.setCancelQty(new BigDecimal("0"));
        soOrderDetailAvailability11.setReturnQty(new BigDecimal("10"));
        soOrderDetailAvailabilities1.add(soOrderDetailAvailability11);
        so251108Bean1.setSoOrderDetailAvailabilities(soOrderDetailAvailabilities1);
        soOrderDetails.add(so251108Bean1);

        SO151402Bean so251108Bean2 = new SO151402Bean();
        so251108Bean2.setOrderId(1L);
        so251108Bean2.setOrderCode("001");
        so251108Bean2.setOrderDetailId(1L);
        so251108Bean2.setOrderDetailType(1);
        so251108Bean2.setOrderDetailLevel(1);
        so251108Bean2.setClassesCode("01");
        so251108Bean2.setClassesName("鸡产品");
        so251108Bean2.setBreedCode("03");
        so251108Bean2.setBreedName("单冻琵琶腿");
        so251108Bean2.setFeatureCode("01");
        so251108Bean2.setFeatureName("80-100g");
        so251108Bean2.setNormsCode("001");
        so251108Bean2.setNormsName("0.3公斤*3包");
        so251108Bean2.setPdCode("0301011001");
        so251108Bean2.setPdName("牛羊肉类牛腱肉");
        so251108Bean2.setUnit("1.05kg*10");
        so251108Bean2.setPackingVolume(new BigDecimal("0.09"));
        so251108Bean2.setWeight(new BigDecimal("90"));
        so251108Bean2.setVolume(new BigDecimal("9"));
        so251108Bean2.setAgreeJoint("0");
        so251108Bean2.setIsJoint("0");
        so251108Bean2.setBuyersConfirmShipments(1);
        so251108Bean2.setPdPrice(new BigDecimal("40"));
        so251108Bean2.setPdPriceAll(new BigDecimal("4000.00"));
        so251108Bean2.setPriceCycle("2");
        so251108Bean2.setOrderQty(new BigDecimal("100"));
        so251108Bean2.setSendQty(new BigDecimal("100"));
        so251108Bean2.setReceiveQty(new BigDecimal("100"));
        so251108Bean2.setCancelQty(new BigDecimal("100"));
        so251108Bean2.setReturnQty(new BigDecimal("100"));
        so251108Bean2.setSendTime(DateTimeUtil.parseDate("2016-01-01", "yyyy-MM-dd"));
        so251108Bean2.setReceivedTime(DateTimeUtil.parseDate("2016-01-05", "yyyy-MM-dd"));
        so251108Bean2.setDetailStatus(1);
        so251108Bean2.setDetailStatusName("全部收货");
        so251108Bean2.setCancelReason("");

        List<SoOrderDetailAvailability> soOrderDetailAvailabilities2 = new ArrayList<SoOrderDetailAvailability>();
        SoOrderDetailAvailability soOrderDetailAvailability2 = new SoOrderDetailAvailability();
        soOrderDetailAvailability2.setOrderId(1l);
        soOrderDetailAvailability2.setOrderCode("001");
        soOrderDetailAvailability2.setOrderDetailId(1l);
        soOrderDetailAvailability2.setSupplierCode("201090002");
        soOrderDetailAvailability2.setSupplierName("南京市六合区公司");
        soOrderDetailAvailability2.setClassesCode("01");
        soOrderDetailAvailability2.setClassesName("鸡产品");
        soOrderDetailAvailability2.setBreedCode("03");
        soOrderDetailAvailability2.setBreedName("单冻琵琶腿");
        soOrderDetailAvailability2.setFeatureCode("01");
        soOrderDetailAvailability2.setFeatureName("80-100g");
        soOrderDetailAvailability2.setNormsCode("001");
        soOrderDetailAvailability2.setNormsName("80-100g");
        soOrderDetailAvailability2.setPdCode("0301011001");
        soOrderDetailAvailability2.setPdName("牛羊肉类牛腱肉");
        //soOrderDetailAvailability2.setPdLevel("312-xx-345");
        soOrderDetailAvailability2.setUnit("闵行区供货商");
        soOrderDetailAvailability2.setReturnQty(new BigDecimal("100"));
        soOrderDetailAvailability2.setSendQty(new BigDecimal("100"));
        soOrderDetailAvailability2.setReceiveQty(new BigDecimal("100"));
        soOrderDetailAvailability2.setCancelQty(new BigDecimal("0"));
        soOrderDetailAvailability2.setReturnQty(new BigDecimal("0"));
        soOrderDetailAvailabilities2.add(soOrderDetailAvailability2);
        so251108Bean2.setSoOrderDetailAvailabilities(soOrderDetailAvailabilities2);
        soOrderDetails.add(so251108Bean2);

        return soOrderDetails;
    }

    /**
     *
     * @param orderId
     * @return
     */
    public List<ISO151402SoDeliver> findOrderDeliver(String orderId){
        BaseParam baseParam=new BasePageParam();
        baseParam.getFilterMap().put("orderId",orderId);
        List<ISO151402SoDeliver>list= super.findList(SqlId.SQL_ID_FIND_ORDER_DELEVER, baseParam);
        return  list;
    }

    /**
     * 订购商品明细页面
     *
     * @param orderId sql查询的id值
     * @return PageResult
     * @author xhy
     * update gyh
     * updateTime 2016.1.6
     */
    public List<SO151402Bean> findOrderDetailInfo(String orderId) {
        BaseParam param = new BaseParam();
        param.setFilter("orderId", orderId);
        List<SO151402Bean> so251108Beans = super.findList(SqlId.SQL_ID_FIND_ORDER_DETAIL_INFO, param);
        for (SO151402Bean so251108Bean : so251108Beans) {
            param.setFilter("classesCode", so251108Bean.getClassesCode());
            param.setFilter("breedCode", so251108Bean.getBreedCode());
            param.setFilter("featureCode", so251108Bean.getFeatureCode());
            param.setFilter("normsCode", so251108Bean.getNormsCode());
            param.setFilter("pdCode",so251108Bean.getPdCode());
            if(null != so251108Bean.getPackingVolume() && null != so251108Bean.getVolume()){
                so251108Bean.setPackingVolume(so251108Bean.getPackingVolume());
                // add by wang_jianzhou for bug#3784 at 2016/11/24 start.
                so251108Bean.setVolume(so251108Bean.getOrderQty().multiply(so251108Bean.getPackingVolume()));
                // add by wang_jianzhou for bug#3784 at 2016/11/24 end.
            }
            List<PdNormsStd> pdNormsStds = productLogic.findPdNormsStd(param);
            if (!CollectionUtils.isEmpty(pdNormsStds)) {
                so251108Bean.setNormsOut(pdNormsStds.get(0).getNormsOut());
            }
            PdNormsStd netWeightOut = super.findOne(SqlId.SQL_ID_QUERY_NET_WEIGHT_OUT,param);
            if(null != netWeightOut && null != netWeightOut.getNetweightOut()){
                so251108Bean.setNetWeightOut(netWeightOut.getNetweightOut());
                // add by wang_jianzhou for bug#3784 at 2016/11/24 start.
                so251108Bean.setWeight(so251108Bean.getOrderQty().multiply(netWeightOut.getNetweightOut()));
                // add by wang_jianzhou for bug#3784 at 2016/11/24 end.
            }
            PdGrade pdGrade = super.findOne(SqlId.SQL_ID_QUERY_PD_GRADE,param);
            so251108Bean.setPdLevel(pdGrade.getGradeName());
            if(null!=so251108Bean.getPdPrice()&& null!=so251108Bean.getOrderQty()){
                so251108Bean.setPdPriceAll(so251108Bean.getPdPrice().multiply(so251108Bean.getOrderQty()));
            }else{
                so251108Bean.setPdPriceAll(new BigDecimal(0));
            }

            param.setFilter("orderDetailId", StringUtil.toString(so251108Bean.getOrderDetailId()));
            List<SoOrderDetailAvailability> soOrderDetailAvailabilities = super.findList(
                    SqlId.SQL_ID_FIND_ORDER_DETAIL_AVAILABILITY_INFO, param);
            so251108Bean.setSoOrderDetailAvailabilities(soOrderDetailAvailabilities);
        }
        return so251108Beans;
    }
    /**
     * 根据订单ID获得订单基本信息
     *
     * @return xinxi
     * update gyh
     * updateTime 2016-1-4
     */
    public BaseOrder getBaseOrder() {
        // 设置假数据,订单基本信息
        BaseOrder baseOrder = new BaseOrder();
        baseOrder.setRequireOrderCode("001-10111010110101-12");
        baseOrder.setConfirmOrderCode("002-10111010110101-12");
        baseOrder.setDeliveryOrderCode("003-10111010110101-12");
        baseOrder.setDistrictCode("001-××××-1");
        baseOrder.setDistrictName("上海");
        baseOrder.setOrderSourceName("神农客平台");
        baseOrder.setOrderTypeName("分销");
        baseOrder.setOrderStatusName("全部收货");
        baseOrder.setPaymentName("在线支付");
        baseOrder.setNeedInvoiceName("是");
        baseOrder.setSplitDeliveryFlg("1");
        //baseOrder.setSplitDeliveryFlg("11");
        baseOrder.setReturnFlgName("否");
        baseOrder.setSellers("李某某");
        baseOrder.setOrderTaker("米某某");
        baseOrder.setOrderDate("2016-01-01 17:10:09");
        baseOrder.setRemark("无");
        return baseOrder;
    }
    /**
     * 根据订单ID获得订单买家信息
     *
     * @return 订单买家信息
     * update gyh
     * updateTime 2016-1-4
     */
    public OrderReceiveDemandBean getOrderBuyers() {
        OrderReceiveDemandBean orderBuyers = new OrderReceiveDemandBean();
        orderBuyers.setBuyersCode("10111010110101");// 买家编号
        orderBuyers.setBuyersName("李四");// 卖家名称
        orderBuyers.setReceiverName("李四"); // 收货人姓名
        orderBuyers.setBuyersType("分销买家");
        orderBuyers.setReceiverTel("15233345566");// 收货人电话
        orderBuyers.setReceiverQq("719443023");
        orderBuyers.setReceiverWeixin("719443023");
        orderBuyers.setReceiverProvince("上海");
        orderBuyers.setReceiverCity("上海市");
        orderBuyers.setReceiverDistrict("闵行区");
        orderBuyers.setReceiverAddr("浦江镇万源路1209弄36号");
        return orderBuyers;

    }

    /**
     * 根据订单ID获得订单配送信息
     *
     * @return 订单配送信息
     * update gyh
     * updateTime 2016-1-4
     */
    public OrderDeliveryBean getOrderDelivery() {

        OrderDeliveryBean orderDelivery = new OrderDeliveryBean();// 封装假数据 订单配送信息
        //TODO v2版本表删除
        /*orderDelivery.setReceiveTime("7:00 ~ 9:00");
        orderDelivery.setReceiveEarliest("6:00");
        orderDelivery.setReceiveLast("10:00");
        orderDelivery.setSendWarehouseCode("780203209128");
        orderDelivery.setSendWarehouseName("浦江镇仓库");
        orderDelivery.setDeliveryTypeName("汽车配送");
        orderDelivery.setForecastSendDate("2016-01-02");
        orderDelivery.setForecastReceiveDate("2016-01-02");
        orderDelivery.setSendDateDate("2016-01-02");
        orderDelivery.setReceiveDateDate("2016-01-02");
        orderDelivery.setReceiveWaitTime("8分钟");
        orderDelivery.setAdvanceNoticeTime("30分钟");
        orderDelivery.setVicFlg("要");
        orderDelivery.setUnloadReq("无");
        orderDelivery.setPackingReq("无");
        orderDelivery.setParkingDistance("500");
        orderDelivery.setOtherDeliveryReq("无");
        orderDelivery.setThisDeliveryReq("无");*/

        return orderDelivery;
    }

    /**
     * 根据订单id查询买家信息数据
     *
     * @param param param
     * @return 信息
     * @author chen_xin
     */
    @Transactional(readOnly = true)
    public OrderReceiveDemandBean queryOrderBuyersByOrderId(BaseParam param) {
        return super.findOne(SqlId.SQL_ID_QUERY_ORDER_BUYERS, param);
    }

    /**
     * 根据订单id查询订单基本信息
     *
     * @param param param
     * @return BaseOrder
     * @author chen_xin
     * update gyh
     * update 2016.1.5
     */
    @Transactional(readOnly = true)
    public BaseOrder queryBaseOrderByOrderId(BaseParam param) {
        BaseOrder baseOrderBean = super.findOne(SqlId.SQL_ID_QUERY_BASE_ORDER, param);
        return baseOrderBean;
    }

    /**
     * 根据订单id查询物流配送信息
     *
     * @param param param
     * @return SoOrderDelivery
     * @author chen_xin
     */
    @Transactional(readOnly = true)
    public OrderDeliveryBean queryOrderDeliveryByOrderId(BaseParam param) {
        OrderDeliveryBean OrderDelivery = super.findOne(SqlId.SQL_ID_QUERY_ORDER_DELIVERY, param);
        return OrderDelivery;

    }

    /**
     * 根据订单id查询子订单基本信息
     *
     * @param orderId
     * @return BaseOrder
     *
     */
    @Transactional(readOnly = true)
    public List<SO151402Bean> findChildOrder(String orderId) {
        BaseParam param = new BaseParam();
        param.setFilter("orderId", orderId);
        List<SO151402Bean> SO151402BeanList=super.findList(SqlId.SQL_ID_FIND_CHILD_ORDER, param);
        return SO151402BeanList;
    }

    /**
     * 根据订单id 更改订单的支付状态
     * @param orderId
     */
    @Transactional
    public void modifyOrderPayment(String orderId, String updId){
        BaseParam param = new BaseParam();
        param.setUpdId(updId);
        param.getFilterMap().put("orderId",orderId);
        modifyOrderInfo(param);
        modifyOrderDetailInfo(param);
    }

    /**
     * 根据订单id更改订单状态为待分销
     * @param param
     */
    @Transactional
    public void modifyOrderInfo(BaseParam param){
        param.getFilterMap().put("orderStatus", StatusConst.OrderStatusDef.WAIT_DISTRIBUTION);
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_INFO, param);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_STATUS,param);
    }

    /**
     * 根据订单id更改订单明细状态为待分销
     * @param param
     */
    @Transactional
    public void modifyOrderDetailInfo(BaseParam param){
        param.getFilterMap().put("orderDetailStatus", StatusConst.OrderDetailStatusDef.WAIT_DISTRIBUTION);
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_INFO,param);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_DETAIL_STATUS,param);
    }

    /**
     * 根据订单id 删除订单信息
     * @param orderId
     */
    @Transactional
    public void deleteOrder(String orderId){
        BaseParam param = new BaseParam();
        param.getFilterMap().put("orderId",orderId);
        // 查询出关联订单id
        SoOrderRelation orderBean = super.findOne(SqlId.SQL_ID_QUERY_ORDER_RELATION, param);
        if (orderBean != null) {
            param.getFilterMap().put("orderId1", orderBean.getMainOrderId());
            param.getFilterMap().put("orderId2", orderBean.getChildOrderId());
        } else {
            param.getFilterMap().put("orderId1", orderId);
        }

        super.remove(SqlId.SQL_ID_REMOVE_AVAILABILITY_STATUS, param);
        super.remove(SqlId.SQL_ID_REMOVE_AVAILABILITY, param);
        super.remove(SqlId.SQL_ID_REMOVE_DETAIL_STATUS, param);
        super.remove(SqlId.SQL_ID_REMOVE_DETAIL, param);
        super.remove(SqlId.SQL_ID_REMOVE_DELIVER_DETAIL, param);
        super.remove(SqlId.SQL_ID_REMOVE_DELIVER, param);
        super.remove(SqlId.SQL_ID_REMOVE_RECEIVE_DEMAND, param);
        super.remove(SqlId.SQL_ID_REMOVE_ORDER_RELATION, param);
        super.remove(SqlId.SQL_ID_REMOVE_ORDER_STATUS, param);
        super.remove(SqlId.SQL_ID_REMOVE_ORDER, param);
    }

    /**
     * 习惯正常收货时间段取得
     *
     * @param param param
     * @return OrderDelivery
     */
    @Transactional(readOnly = true)
    public List<OrderDeliveryBean> queryReceiveTime(BaseParam param) {
        List<OrderDeliveryBean> OrderDelivery= super.findList(SqlId.SQL_ID_QUERY_RECEIVE_TIME, param);
        return OrderDelivery;

    }


    @Transactional
    public int getChild(BaseParam param){
        int count = super.getCount(SqlId.SQL_ID_GET_CHILD_COUNT,param);
        return count;
    }
}
