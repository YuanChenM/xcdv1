package com.msk.so.logic;

import com.msk.common.consts.CapitalPoolConst;
import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.consts.OrderConst;
import com.msk.common.logic.CommonLogic;
import com.msk.common.utils.RsClientUtil;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import com.msk.so.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 订单模块共通Logic.
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class OrderLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderLogic.class);
    private int index = 1;

    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private BookKeepingLogic bookKeepingLogic;

    @Autowired
    private ProductLogic productLogic;

    @Autowired
    private RsClientUtil rsClientUtil;
    /**
     * SqlId
     */
    interface SqlId{
        String SQL_ID_GET_ORDER_INFO = "getOrderInfo";
        String SQL_ID_GET_ORDER_DETAIL_LIST = "getOrderDetailList";
        String SQL_ID_MODIFY_ORDER_STATUS = "modifyOrderStatus";
        String SQL_ID_GET_BUYER_ORDER_COUNT = "getBuyerOrderCount";
        String SQL_ID_SAVE_BUYER_ORDER = "saveBuyerOrder";
        String SQL_ID_MODIFY_BUYER_INDEX_COUNT = "modifyBuyerIndexCount";
        String SQL_ID_SAVE_ORDER = "saveOrder";
        String SQL_ID_SAVE_ORDER_DETAIL = "saveOrderDetail";
        String SQL_ID_SAVE_ORDER_DETAIL_AVAILABILITY = "saveOrderDetailAvailability";
        String SQL_ID_SAVE_ORDER_RECEIVE_DEMAND = "saveOrderReceiveDemand";
        String SQL_ID_SAVE_ORDER_RELATION = "saveOrderRelation";
        String SQL_ID_GET_CHILD_ORDER_DETAIL_INFO = "getChildOrderDetailInfo";
        String SQL_ID_GET_ORDER_DETAIL_INFO = "getOrderDetailInfo";
        String SQL_ID_GET_ALL_ORDER_INFO_LIST = "getAllOrderInfoList";
        String SQL_ID_GET_HOUSE_CODE_BY_BSID = "getHouseCodeByBsId";
        String SQL_ID_GET_SL_PD_ART_NO = "getSlPdArtNo";
        String SQL_ID_GET_PD_CODE = "getPdCode";
        String SQL_ID_UPDATE_SL_BS_BUYER_INFO = "updateSlBsBuyerInfo";
        }

    /**
     * 订单创建插入待付款单
     * @param order 订单信息
     * @param <T> 订单类型
     */
    @Transactional
    public <T extends SoOrder> void saveWaitPaymentOrder(T order){
        BookKeepingParam param = new BookKeepingParam();
        param.setIsPayed(CommCodeMasterConst.YESNO.YES);
        param.setPayCode(StringConst.EMPTY);
        param.setSearchCode(order.getOrderCode());
        param.setPayAmount(order.getOrderAmount());
        param.setPayeeCode(order.getSellerCode());
        param.setPayerCode(order.getBuyersId());
        Integer orderSource = order.getOrderSource();
        if(orderSource == NumberConst.IntDef.INT_ONE){
           param.setPlateFormType(Integer.valueOf(CapitalPoolConst.PlateFormType.SNK));
        }else {
            param.setPlateFormType(Integer.valueOf(CapitalPoolConst.PlateFormType.MSK));
        }

        //分销订单,买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.DISTRIBUTION_ORDER
                ||order.getOrderType() == OrderConst.OrderType.BUYER_STOCKPILING_ORDER){
            param.setPayeeRole(CapitalPoolConst.RoleType.ROLE_PLATFORM);
        }
        //第三方订单,第三方买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.THIRD_PARTY_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayeeRole(CapitalPoolConst.RoleType.ROLE_SELLER);
        }
        //买手销售订单,第三方买手销售订单,第三方买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.BUYER_SALE_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_SALE_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayeeRole(CapitalPoolConst.RoleType.ROLE_BUYERE);
        }
        //分销订单
        if(order.getOrderType() == OrderConst.OrderType.DISTRIBUTION_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_PARTY_ORDER
                ||order.getOrderType() == OrderConst.OrderType.BUYER_SALE_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_SALE_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayerRole(CapitalPoolConst.RoleType.ROLE_BIDDER);
        }
        //买手销售订单,第三方买手销售订单
        if(order.getOrderType() == OrderConst.OrderType.BUYER_SALE_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_SALE_ORDER){
            param.setPayerRole(CapitalPoolConst.RoleType.ROLE_SELLER);
        }
        //买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.BUYER_STOCKPILING_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayerRole(CapitalPoolConst.RoleType.ROLE_BUYERE);
        }
        param.setClearingForm(String.valueOf(order.getPaymentType()));
        param.setSearchType(CapitalPoolConst.SearchType.ORDER);
        param.setAmountType(CapitalPoolConst.AmountType.ORDER_CONFIRM);
        RsRequest<BookKeepingParam> request = new RsRequest<BookKeepingParam>();
        request.setParam(param);
        this.bookKeepingLogic.updateOrSaveAmountRecord(request);
    }
    @Transactional
    public <T extends SoOrder> void savePaymentOrder(T order){
        BookKeepingParam param = new BookKeepingParam();
        param.setIsPayed(CommCodeMasterConst.YESNO.NO);
        param.setPayCode(order.getOrderCode());
        param.setPayAmount(order.getOrderAmount());
        param.setPayeeCode(order.getSellerCode());
        param.setPayerCode(order.getBuyersId());
        param.setSearchCode(order.getOrderCode());
        Integer orderSource = order.getOrderSource();
        if(orderSource == NumberConst.IntDef.INT_ONE){
            param.setPlateFormType(Integer.valueOf(CapitalPoolConst.PlateFormType.SNK));
        }else {
            param.setPlateFormType(Integer.valueOf(CapitalPoolConst.PlateFormType.MSK));
        }
        //param.setPayeeRole(String.valueOf(order.getBuyersType()));
        //param.setPayerRole(StringConst.EMPTY);
        //分销订单,买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.DISTRIBUTION_ORDER
                ||order.getOrderType() == OrderConst.OrderType.BUYER_STOCKPILING_ORDER){
            param.setPayeeRole(CapitalPoolConst.RoleType.ROLE_PLATFORM);
        }
        //第三方订单,第三方买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.THIRD_PARTY_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayeeRole(CapitalPoolConst.RoleType.ROLE_SELLER);
        }
        //买手销售订单,第三方买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.BUYER_SALE_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayeeRole(CapitalPoolConst.RoleType.ROLE_BUYERE);
        }
        //分销订单
        if(order.getOrderType() == OrderConst.OrderType.DISTRIBUTION_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_PARTY_ORDER
                ||order.getOrderType() == OrderConst.OrderType.BUYER_SALE_ORDER
                ||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayerRole(CapitalPoolConst.RoleType.ROLE_BIDDER);
        }
        //买手囤货订单
        if(order.getOrderType() == OrderConst.OrderType.BUYER_STOCKPILING_ORDER||order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER){
            param.setPayerRole(CapitalPoolConst.RoleType.ROLE_BUYERE);
        }
        param.setClearingForm(String.valueOf(order.getPaymentType()));
        param.setSearchType(CapitalPoolConst.SearchType.ORDER);
        param.setAmountType(CapitalPoolConst.AmountType.ORDER_CONFIRM);
        RsRequest<BookKeepingParam> request = new RsRequest<BookKeepingParam>();
        request.setParam(param);
        this.bookKeepingLogic.updateOrSaveAmountRecord(request);
    }

    @Transactional
    public <T extends SoOrder> void cancelPaymentOrder(T order){
        BookKeepingParam param = new BookKeepingParam();
        param.setIsPayed(CommCodeMasterConst.YESNO.NO);
        //支付流水号
        param.setPayCode(order.getOrderCode());
        //订单总金额
        param.setPayAmount(order.getOrderAmount());
        //收款方
        param.setPayeeCode(order.getBuyersId());
        //付款方
        param.setPayerCode(order.getSellerCode());
        //订单编码
        param.setSearchCode(order.getOrderCode());
        //收款方
        param.setPayeeRole(CapitalPoolConst.RoleType.ROLE_BIDDER);
        //付款方
        param.setPayerRole(CapitalPoolConst.RoleType.ROLE_PLATFORM);
        //结算方式
        param.setClearingForm(String.valueOf(order.getPaymentType()));
        param.setSearchType(CapitalPoolConst.SearchType.ORDER);
        param.setAmountType(CapitalPoolConst.AmountType.ORDER_CONFIRM);
        //平台类型：神农客
        param.setPlateFormType(Integer.valueOf(CapitalPoolConst.PlateFormType.SNK));

        RsRequest<BookKeepingParam> request = new RsRequest<BookKeepingParam>();
        request.setParam(param);
        this.bookKeepingLogic.updateOrSaveAmountRecord(request);
    }

    /**
     * 根据卖家编号获得意愿订单编码（意愿订单表）
     *
     * @param buyersNo 买家编号
     * @return 需求订单编号
     */
    public String getProCode(String buyersNo) {
        logger.debug("获得需求订单编号");
        //当前时间
        Date currentDate = DateTimeUtil.getCustomerDate();
        SimpleDateFormat formatStyle = new SimpleDateFormat("yyMMddHHmmssSSS");
        String shoppingCode = formatStyle.format(currentDate);
        String randomStr = "";
        //两位随机数
        int random = (int)(Math.random()*NumberConst.IntDef.INT_HUNDRED);
        if(random < NumberConst.IntDef.INT_TEN){
            randomStr = "0" + String.valueOf(random);
        }else {
            randomStr = String.valueOf(random);
        }
        return shoppingCode + randomStr;
    }

    /**
     * 分销订单在分销时候创建，第三方订单在创建时候创建
     *
     * @param
     * @return 确认订单编号
     */
    public String getConfirmCode() {
        logger.debug("获得确认订单编号");
        //当前时间
        Date currentTime = DateTimeUtil.getCustomerDate();
        SimpleDateFormat formatStyle = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String confirmCode = formatStyle.format(currentTime);

        return confirmCode;
    }


    /**
     * 获得需求订单编号
     * 获得需求订单编号（对应订单表）
     *
     * @param currentDate currentDate
     * @param buyersNo buyersNo
     * @return 需求订单编号
     */
    public String getAuxiliaryCode(Date currentDate, String buyersNo) {
        logger.debug("获得需求订单编号");
        SimpleDateFormat formatStyle = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String requireCode = formatStyle.format(currentDate);
        return requireCode+buyersNo;
    }

    /**
     * 获得配送订单编号
     *
     * @return 配送订单编号
     */
    public String getDeliveryCode() {
        logger.debug("获得配送订单编号");
        //当前时间
        Date currentDate = DateTimeUtil.getCustomerDate();
        SimpleDateFormat formatStyle = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String deliveryCode = formatStyle.format(currentDate);
        return deliveryCode;
    }

    /**
     * 更新订单的发货数量,根据订单编码,供应商编码,发货数量,产品编号定位数据.<br/>
     * 本次更新以下数据:<br/>
     * 1:订单明细表中发货数量和发货时间,更新条件为订单编号和产品编码,
     * 更新的值为DB中的发货数量 = DB中的发货数量+发货数量,发货时间为当前系统时间<br/>
     * 2:更新供应商配送表中的发货数量和发货时间,更新条件为订单编码,产品编码以及供应商编码
     * 更新的值为DB中的发货数量 = DB中的发货数量+发货数量,发货时间为当前系统时间
     * <br/>
     * @param orderCode 订单编码
     * @param supplierCode 供应商编码
     * @param sendQty 发货数量
     * @param pdNo 产品编码
     */
    @Transactional
    public void modifyOrderSendQty(String orderCode, String supplierCode, BigDecimal sendQty,String pdNo){

    }

    /**
     * 更新订单的收货数量,根据订单编码,供应商编码,收货数量,产品编号定位数据.<br/>
     * 本次更新以下数据:<br/>
     * 1:订单明细表中发货数量和收货时间,更新条件为订单编号和产品编码,
     * 更新的值为DB中的收货数量 = DB中的收货数量+收货数量,收货时间为当前系统时间<br/>
     * 2:更新供应商配送表中的发货数量和收货时间,更新条件为订单编码,产品编码以及供应商编码
     * 更新的值为DB中的收货数量 = DB中的收货数量+收货数量,收货时间为当前系统时间
     * <br/>
     * @param orderCode 订单编码
     * @param supplierCode 供应商编码
     * @param receiveQty 发货数量
     * @param pdNo 产品编码
     */
    @Transactional
    public void modifyOrderReceiveQty(String orderCode, String supplierCode, BigDecimal receiveQty,String pdNo){

    }
    /**
     * 更新订单的部分取消数量,根据订单编码,供应商编码,取消数量,产品编号定位数据.<br/>
     * 本次更新以下数据:<br/>
     * 1:订单明细表中发货数量和收货时间,更新条件为订单编号和产品编码,
     * 更新的值为DB中的取消数量 = DB中的收货数量+取消数量<br/>
     * 2:更新供应商配送表中的发货数量和收货时间,更新条件为订单编码,产品编码以及供应商编码
     * 更新的值为DB中的取消数量 = DB中的收货数量+取消数量
     * <br/>
     * @param orderCode 订单编码
     * @param supplierCode 供应商编码
     * @param cancelQty 发货数量
     * @param pdNo 产品编码
     */
    @Transactional
    public void modifyOrderCancelQty(String orderCode, String supplierCode, BigDecimal cancelQty,String pdNo){

    }
    /**
     * 更新订单的全部取消数量,根据订单编码,供应商编码,取消数量,产品编号定位数据.<br/>
     * 本次更新以下数据:<br/>
     * 1:订单明细表中发货数量和收货时间,更新条件为订单编号和产品编码,
     * 更新的值为DB中的取消数量 = 订单数量<br/>
     * 2:更新供应商配送表中的发货数量和收货时间,更新条件为订单编码,产品编码以及供应商编码
     * 更新的值为DB中的取消数量 = 订单数量
     * <br/>
     * @param orderCode 订单编码
     */
    @Transactional
    public void modifyOrderCancelQty(String orderCode){

    }

    /**
     * 更新订单状态
     * @param orderId 订单编号
     * @param status 状态
     * @param updId 更新者
     * @param updDate 更新时间
     */
    @Transactional
    public void modifyOrderStatus(Long orderId,Integer status,String updId,Date updDate){
        BaseParam param = new BaseParam();
        Map<String,Object> filterMap = param.getFilterMap();
        filterMap.put("orderId",orderId);
        filterMap.put("status",status);
        filterMap.put("updId",updId);
        filterMap.put("updDate",updDate);
        super.modify(SqlId.SQL_ID_MODIFY_ORDER_STATUS,param);
    }
    /**
     * 根据买家编号获得买家购物次数
     * 根据订单类型，买家编号，买家下单次数生成单据主码
     * @param orderType 订单类型
     * @param buyerCode 买家编码
     * @return 单据主码
     */
    @Transactional
    public String getOrderCode(int orderType,String buyerCode, String crtId){
        long buyerOrderCount = this.purchaseTimes(buyerCode, crtId);
        String orderMainCode = getOrderType(orderType) + "-" + buyerCode + "-" +String.valueOf(buyerOrderCount);
        return orderMainCode;
    }

    /**
     * 获得买家购买次数.
     * @param buyersCode buyersCode
     * @return buyerCount
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private long purchaseTimes(String buyersCode, String crtId){
        long buyerCount = 0;
        BaseParam param = new BaseParam();
        param.setCrtId(crtId);
        param.setUpdId(crtId);
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        Map<String,Object> filterMap = param.getFilterMap();
        filterMap.put("buyersCode",buyersCode);
        SoOrderBuyerSeq orderBuyerIndex = super.findOne(SqlId.SQL_ID_GET_BUYER_ORDER_COUNT, param);
        if(null == orderBuyerIndex){
            filterMap.put("Id", commonLogic.maxId("SO_ORDER_BUYER_SEQ", "ID"));
            super.save(SqlId.SQL_ID_SAVE_BUYER_ORDER, param);
        }else{
            super.modify(SqlId.SQL_ID_MODIFY_BUYER_INDEX_COUNT,param);
        }
        orderBuyerIndex = super.findOne(SqlId.SQL_ID_GET_BUYER_ORDER_COUNT, param);
        buyerCount = orderBuyerIndex.getBuyCount();
        return buyerCount;
    }
    /**
     * 获得订单类型编码
     *
     * @param type type
     * @return orderType orderType
     */
    private String getOrderType(int type){
        String orderType = "";
        if(type == NumberConst.IntDef.INT_ONE){
            orderType = "001";
        }else if(type == NumberConst.IntDef.INT_TWO){
            orderType = "002";
        }else if(type == NumberConst.IntDef.INT_THREE){
            orderType = "003";
        }
        if(type == NumberConst.IntDef.INT_FOUR){
            orderType = "004";
        }else if(type == NumberConst.IntDef.INT_FIVE){
            orderType = "005";
        }else if(type == NumberConst.IntDef.INT_SIX){
            orderType = "006";
        }else if(type == NumberConst.IntDef.INT_SEVEN){
            orderType = "007";
        }
        return orderType;
    }
    /**
     * 根据订单时间生成单据辅码
     * @param orderTime 时间
     * @return 单据辅码
     */
    public String getOrderCode(Date orderTime){
        String yyMMdd = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YYYYMMDD, orderTime);
        //标准时间单元编码
        Calendar getOrderTime = Calendar.getInstance();
        getOrderTime.setTime(orderTime);
        int orderHour = getOrderTime.get(getOrderTime.HOUR_OF_DAY);
        int orderMin = getOrderTime.get(getOrderTime.MINUTE);
        if(orderMin > NumberConst.IntDef.INT_THIRTY){
            orderHour = orderHour * NumberConst.IntDef.INT_TWO + NumberConst.IntDef.INT_TWO;
        }else {
            orderHour = orderHour * NumberConst.IntDef.INT_TWO + NumberConst.IntDef.INT_ONE;
        }
        String standardTimeCode = yyMMdd.substring(NumberConst.IntDef.INT_TWO,NumberConst.IntDef.INT_EIGHT) + String.valueOf(orderHour);
        return standardTimeCode;
    }
    /**
     * 生成退货单订单辅码
     * @return 退货单辅码
     */
    @SuppressWarnings("static-access")
    public String getReturnOrderCode(Long returnId){
        String yyMMdd = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_YYYYMMDD, DateTimeUtil.getCustomerDate());
        //标准时间单元编码
        Calendar getOrderTime = Calendar.getInstance();
        int orderHour = getOrderTime.get(getOrderTime.HOUR_OF_DAY);
        int orderMin = getOrderTime.get(getOrderTime.MINUTE);
        if(orderMin > NumberConst.IntDef.INT_THIRTY){
            orderHour = orderHour * NumberConst.IntDef.INT_TWO + NumberConst.IntDef.INT_TWO;
        }else {
            orderHour = orderHour * NumberConst.IntDef.INT_TWO + NumberConst.IntDef.INT_ONE;
        }
        String returnOrderCode = yyMMdd.substring(NumberConst.IntDef.INT_TWO,NumberConst.IntDef.INT_EIGHT) + String.valueOf(orderHour)+ "_" + returnId;
        return returnOrderCode;
    }
    /**
     * 取得订单基本信息以及详细信息
     * @param param param
     * @return BaseOrderBean
     */
    @Transactional(readOnly = true)
    public BaseOrderBean getOrderInfoById(BaseParam param) {
        logger.info("取得订单基本信息以及详细信息");

        BaseOrderBean bean = new BaseOrderBean();
        SoOrder soOrder = super.findOne(SqlId.SQL_ID_GET_ORDER_INFO, param);
        List<SoOrderDetail> soOrderDetails;
        if (soOrder != null){
            soOrderDetails = super.findList(SqlId.SQL_ID_GET_ORDER_DETAIL_LIST,param);
            if(soOrderDetails ==null || soOrderDetails.size() == NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("订单[" + soOrder.getOrderCode() + "]没有明细数据!");
            }
            bean.setSoOrder(soOrder);
            bean.setSoOrderDetails(soOrderDetails);
        }
        return bean;
    }


    /**
     * 取得主订单和子订单基本信息以及详细信息
     * @param param param
     * @return BaseOrderBean
     */
    @Transactional(readOnly = true)
    public BaseOrderBean getOrderDetailInfoById(BaseParam param) {
        logger.info("取得主订单和子订单基本信息以及详细信息");

        BaseOrderBean bean = new BaseOrderBean();
        SoOrder soOrder = super.findOne(SqlId.SQL_ID_GET_ORDER_INFO, param);

        List<SoOrderDetail> soOrderDetails;

        List<SoOrderDetail> soOrderChildDetails;

        if (soOrder != null){
            soOrderDetails = super.findList(SqlId.SQL_ID_GET_ORDER_DETAIL_LIST,param);

            soOrderChildDetails = super.findList(SqlId.SQL_ID_GET_CHILD_ORDER_DETAIL_INFO,param);

            soOrderDetails = getAllOrderDetailList(soOrderDetails,soOrderChildDetails);

            if(soOrderDetails ==null || soOrderDetails.size() == NumberConst.IntDef.INT_ZERO){
                throw new BusinessException("订单[" + soOrder.getOrderCode() + "]没有明细数据!");
            }
            bean.setSoOrder(soOrder);
            bean.setSoOrderDetails(soOrderDetails);
        }
        return bean;
    }

    public List<SoOrderDetail> getAllOrderDetailList(List<SoOrderDetail> soOrderDetails,List<SoOrderDetail> soOrderChildDetails)
    {
        if(CollectionUtils.isEmpty(soOrderChildDetails))
        {
            return soOrderDetails;
        }

        for(SoOrderDetail orderChildDetail : soOrderChildDetails)
        {
            soOrderDetails.add(orderChildDetail);
        }
        return soOrderDetails;
    }

    /**
     * 订单插入
     * @param order 订单信息
     */
    @Transactional
    public void saveOrder(SoOrder order){
        if(null != order){
            this.save(SqlId.SQL_ID_SAVE_ORDER,order);
            this.saveWaitPaymentOrder(order);
        }else{
            throw new BusinessException("没有订单数据");
        }
    }

    /**
     * 订单插入
     * @param order 订单信息
     */
    @Transactional
    public void saveOrder(SoOrder order, String mainSellerCode){
        if(null != order){
            dealHouseInfo(order);
            this.save(SqlId.SQL_ID_SAVE_ORDER, order);
            //买手销售订单
            if(OrderConst.OrderType.BUYER_SALE_ORDER ==order.getOrderType() ||
                    //第三方买手销售订单
                    OrderConst.OrderType.THIRD_BUYER_SALE_ORDER ==order.getOrderType()){
                //查询子订单信息
                BaseOrderParam baseOrderParam = new BaseOrderParam();
                baseOrderParam.setOrderId(order.getOrderId());
                SoOrder soOrder = super.findOne(SqlId.SQL_ID_GET_ORDER_INFO, baseOrderParam);
                if(null != soOrder){
                    //子订单总金额
                    BigDecimal orderAmount = soOrder.getOrderAmount();
                    //子订单买家ID
                    String buyersId = soOrder.getBuyersId();
                    //子订单买家编码
                    String buyersCode = soOrder.getBuyersCode();
                    //子订单订单编码
                    String orderCode = soOrder.getOrderCode();
                    //订单来源
                    Integer orderSource = soOrder.getOrderSource();
                    //订单创建插入待付款单
                    SoOrder soOrderparam = new SoOrder();
                    //订单编码
                    soOrderparam.setOrderCode(orderCode);
                    //订单类型
                    soOrderparam.setOrderType(order.getOrderType());
                    //订单总金额
                    soOrderparam.setOrderAmount(orderAmount);
                    //主订单卖家编码
                    soOrderparam.setSellerCode(mainSellerCode);
                    //买家ID
                    soOrderparam.setBuyersId(buyersId);
                    //买家编码
                    soOrderparam.setBuyersCode(buyersCode);
                    //订单来源
                    soOrderparam.setOrderSource(orderSource);
                    //订单创建插入待付款单
                    this.saveWaitPaymentOrder(soOrderparam);
                }
            } else {
                this.saveWaitPaymentOrder(order);
            }
        }else{
            throw new BusinessException("没有订单数据");
        }
    }

    /**
     * 设置冻品管家信息
     * @param orderInfo
     */
    public void dealHouseInfo(SoOrder orderInfo)
    {
        Integer orderType = orderInfo.getOrderType();
        String bsId = orderInfo.getBuyersId();

        BaseParam param = new BaseParam();
        param.getFilterMap().put("bsId",bsId);
        String houseCode = (String)this.findObject(SqlId.SQL_ID_GET_HOUSE_CODE_BY_BSID,param);
        orderInfo.setSellers(houseCode);
        if(orderType == OrderConst.OrderType.THIRD_BUYER_SALE_ORDER || orderType == OrderConst.OrderType.BUYER_SALE_ORDER)
        {
            if(!StringUtil.isEmpty(houseCode)){
                //更新sl_bs_buyer中的END_TIME（当前日期+60天）和开始时间为订单的创建时间
                this.modify(SqlId.SQL_ID_UPDATE_SL_BS_BUYER_INFO,orderInfo);
            }
        }
    }

    /**
     * 订单详细表插入
     * @param orderDetailList
     */
    @Transactional
    public <T extends SoOrderDetail> void saveOrderDetail(List<T> orderDetailList){
        if(!CollectionUtils.isEmpty(orderDetailList)){
            for(int i = NumberConst.IntDef.INT_ZERO;i < orderDetailList.size();i++){
                SoOrderDetail orderDetail = orderDetailList.get(i);
                Long orderDetailId = commonLogic.maxId("so_order_detail","ORDER_DETAIL_ID");
                orderDetail.setOrderDetailId(orderDetailId);
                this.save(SqlId.SQL_ID_SAVE_ORDER_DETAIL,orderDetail);
            }
        }else{
            throw new BusinessException("没有订单明细数据");
        }
    }
    /**
     * 订单详细供应商表插入
     * @param orderDetailAvailabilityList
     */
    @Transactional
    public void saveOrderDetailAvailability(List<SoOrderDetailAvailability> orderDetailAvailabilityList){
        if(!CollectionUtils.isEmpty(orderDetailAvailabilityList)){
            for(int i = NumberConst.IntDef.INT_ZERO;i < orderDetailAvailabilityList.size();i++){
                SoOrderDetailAvailability orderDetailAvailability = orderDetailAvailabilityList.get(i);
                Long orderDetailAvailabilityId = commonLogic.maxId("so_order_detail_availability","ORDER_DETAIL_AVAILABILITY_ID");
                orderDetailAvailability.setOrderDetailAvailabilityId(orderDetailAvailabilityId);
                this.save(SqlId.SQL_ID_SAVE_ORDER_DETAIL_AVAILABILITY,orderDetailAvailability);
            }
        }else{
            throw new BusinessException("没有订单明细供应商数据");
        }
    }
    /**
     * 订单收货要求信息插入
     * @param orderReceiveDemand
     */
    @Transactional
    public void saveOrderReceiveDemand(SoOrderReceiveDemand orderReceiveDemand){
        if(null != orderReceiveDemand){
            this.save(SqlId.SQL_ID_SAVE_ORDER_RECEIVE_DEMAND,orderReceiveDemand);
        }else{
            throw new BusinessException("没有订单收货要求信息数据");
        }
    }

    /**
     * 设置订单关联表
     * @param orderRelation 订单关联表
     */
    @Transactional
    public void saveOrderRelation(SoOrderRelation orderRelation){
        if(null != orderRelation){
            this.save(SqlId.SQL_ID_SAVE_ORDER_RELATION,orderRelation);
        }else{
            throw new BusinessException("没有订单收货要求信息数据");
        }
    }

    @Transactional
    public SoOrderDetail getOrderDetailInfo(BaseParam filterParam)
    {
        return super.findOne(SqlId.SQL_ID_GET_ORDER_DETAIL_INFO,filterParam);
    }

    public List<SoOrder> getAllOrderInfo(BaseParam param)
    {
        return super.findList(SqlId.SQL_ID_GET_ALL_ORDER_INFO_LIST,param);
    }

    public SlPdArtno getSlPdArtNo(String slCode,String pdCode,String salesPlatform)
    {
        SlPdArtno slPdArtno = new SlPdArtno();

        ProductBean productBean = this.productLogic.getProductInfo(pdCode);

        BaseParam params=new BaseParam();
        params.setFilter("slCode", slCode);
        params.setFilter("classesCode", productBean.getPdBreed().getClassesCode());
        params.setFilter("machiningCode", productBean.getPdMachining().getMachiningCode());
        params.setFilter("breedCode", productBean.getPdBreed().getBreedCode());
        params.setFilter("featureCode", productBean.getPdFeature().getFeatureCode());
        params.setFilter("weightCode", productBean.getPdWeight().getWeightCode());
        params.setFilter("gradeCode", productBean.getPdGrade().getGradeCode());
        params.setFilter("salesPlatform", salesPlatform);

        slPdArtno = this.findOne(SqlId.SQL_ID_GET_SL_PD_ART_NO, params);

        return slPdArtno;
    }

    public String getPdCode(String slPdArtno, String slCodeDis)
    {
        String pdCode = null;
        BaseParam params=new BaseParam();
        params.setFilter("slPdArtno", slPdArtno);
        params.setFilter("slCodeDis", slCodeDis);

        SlPdArtno slpdartno = this.findOne(SqlId.SQL_ID_GET_PD_CODE,params);

        if(slpdartno != null
                && !StringUtil.isEmpty(slpdartno.getClassesCode())
                && !StringUtil.isEmpty(slpdartno.getMachiningCode())
                && !StringUtil.isEmpty(slpdartno.getBreedCode())
                && !StringUtil.isEmpty(slpdartno.getFeatureCode())
                && !StringUtil.isEmpty(slpdartno.getWeightCode())
                && !StringUtil.isEmpty(slpdartno.getGradeCode())){
            pdCode = slpdartno.getClassesCode() + slpdartno.getMachiningCode()+ slpdartno.getBreedCode()
                    + slpdartno.getFeatureCode() + slpdartno.getWeightCode() + slpdartno.getGradeCode();
        }
        return pdCode;
    }

    /**
     * 调用记录交易明细接口
     * @param
     * @return
     */
    public void saveCpTransaction(SoOrder order){
        String url = ConfigManager.getCpTransactionUrl();
        RsRequest<CpTransactionParam> request = new RsRequest<CpTransactionParam>();
        request.setAuth("MSK00001");
        request.setSiteCode("101");
        request.setLoginId(order.getCrtId());
        CpTransactionParam param = new CpTransactionParam();
        param.setInsertFlg(String.valueOf(NumberConst.IntDef.INT_ONE));
        param.setTransCode(order.getOrderCode());
        param.setOrderId(order.getOrderId());
        param.setTransType(Integer.valueOf(NumberConst.IntDef.INT_ZERO));
        param.setOperateDate(DateTimeUtil.getCustomerDate());
        // 平台类型
        if (order.getOrderSource() != NumberConst.IntDef.INT_TWO) {
            param.setBusinessMainId("0000000");
            param.setBusinessMainName("神农客");
            param.setSupplyPlatform(NumberConst.IntDef.INT_ONE);
        } else {
            param.setBusinessMainId("AAAAAAA");
            param.setBusinessMainName("美侍客");
            param.setSupplyPlatform(NumberConst.IntDef.INT_TWO);
        }
        // 交易标志 0：正常 1：交易关闭
        param.setTransFlg(String.valueOf(NumberConst.IntDef.INT_ZERO));
        // 收款方角色都为平台
        param.setBusinessMainRole(Integer.valueOf(CapitalPoolConst.RoleType.ROLE_PLATFORM));
        // 分销订单,第三方订单
        if (order.getOrderType() == OrderConst.OrderType.DISTRIBUTION_ORDER
                || order.getOrderType() == OrderConst.OrderType.THIRD_PARTY_ORDER) {
            param.setBusinessAssistantRole(Integer.valueOf(CapitalPoolConst.RoleType.ROLE_BIDDER));
        }
        // 买手囤货订单,第三方买手囤货订单
        if (order.getOrderType() == OrderConst.OrderType.BUYER_STOCKPILING_ORDER
                || order.getOrderType() == OrderConst.OrderType.THIRD_BUYER_ORDER) {
            param.setBusinessAssistantRole(Integer.valueOf(CapitalPoolConst.RoleType.ROLE_BUYERE));
        }
        param.setBusinessAssistantId(order.getBuyersId());
        param.setBusinessAssistantCode(order.getBuyersCode());
        param.setBusinessAssistantName(order.getBuyersName());
        // 订单金额
        param.setOrderAmount(order.getOrderAmount());
        // 交易发生日期
        param.setTranTime(order.getOrderTime());
        // 支付类型 1:在线支付,2:线下支付
        param.setPaymentType(order.getPaymentType());
        request.setParam(param);
        RsResponse<BaseCpResult> response = rsClientUtil.postRsService(url, request, BaseCpResult.class);
    }

    /**
     * 获取买家编码(环标码)
     * @param param
     * @return 买家编码(环标码)
     */
    public String getBuyersCode(BuyersRsParam param){
        String url = ConfigManager.getBuyerCodeUrl();
        RsRequest<BuyersRsParam> request = new RsRequest<BuyersRsParam>();
        request.setAuth("MSK00001");
        request.setSiteCode("101");
        request.setLoginId(param.getCrtId());
        request.setParam(param);
        RsResponse<BuyersRsBean> response = rsClientUtil.postRsService(url, request, BuyersRsBean.class);
        if (response != null && response.getResult()!= null && SystemConst.RsStatus.SUCCESS.equals(response.getStatus())){
            return response.getResult().getBuyerCode();
        } else {
            return null;
        }
    }

    /**
     * 获取买家编码(环标码)
     * @param buyersCode
     * @return 买家编码(环标码)
     */
    public String getBuyersId(String buyersCode){
        String url = ConfigManager.getBuyerIdUrl();
        RsRequest<BuyersRsParam> request = new RsRequest<BuyersRsParam>();
        BuyersRsParam param = new BuyersRsParam();
        param.setBuyerCode(buyersCode);
        request.setAuth("MSK00001");
        request.setSiteCode("101");
        request.setLoginId("MSK001");
        request.setParam(param);
        RsResponse<BuyersRsBean> response = rsClientUtil.postRsService(url, request, BuyersRsBean.class);
        if (response != null && response.getResult()!= null && SystemConst.RsStatus.SUCCESS.equals(response.getStatus())){
            return response.getResult().getBuyerId();
        } else {
            return null;
        }
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
