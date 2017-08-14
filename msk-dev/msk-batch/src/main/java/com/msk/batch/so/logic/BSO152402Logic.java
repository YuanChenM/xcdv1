package com.msk.batch.so.logic;

import java.math.BigDecimal;
import java.util.*;

import com.msk.batch.so.bean.*;
import com.msk.common.consts.OrderConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.mail.MailHandle;
import com.msk.sl.bean.SlProductBean;
import com.msk.sl.logic.SlProductLogic;
import com.msk.so.Order;
import com.msk.so.logic.OrderLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.so.bean.BaseOrderBean;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.bean.StockParam;
import com.msk.so.logic.StockLogic;
import com.msk.so.orderstatus.OrderStatusContext;
import org.springframework.util.CollectionUtils;

/**
 * BSO152402Logic
 *
 * @author yuan_chen
 * @version 1.0
 */
@Service
public class BSO152402Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(BSO152402Logic.class);
    @Autowired
    private CommonLogic commonLogic;
    /**
     * 注入Order共通类
     */
    @Autowired
    private Order orderComm;
    /**
     * 注入库存Logic
     */
    @Autowired
    private StockLogic stockLogic;
    /**
     * 注入BSO152401Logic
     */
    @Autowired
    private BSO152401Logic bso152401logic;
    /**
     * 注入OrderStatusContext
     */
    @Autowired
    private OrderStatusContext orderStatusContext;

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private SlProductLogic slProductLogic;

    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 根据订单信息进行分单操作
     *
     * @param bso152402Param param
     */
    @Transactional
    public SoOrder distributionOrder(BSO152402Param bso152402Param) {
        logger.debug("分单处理开始");

        //分销失败或者成功标志
        boolean falseOrSuccFlag = true;

        BaseOrderBean orderBean = null;

        // 取得全部订单信息
        orderBean = orderComm.getOrderInfoById(bso152402Param);
        // 设置订单主表信息
        SoOrder soOrder = orderBean.getSoOrder();
        // 这是卖家编码
        String slCode = soOrder.getSellerCode();
        //生成确认编码
        String confirmCode = orderLogic.getConfirmCode();
        soOrder.setConfirmOrderCode(confirmCode);
        super.modify(SqlId.SQL_ID_MODIFY_SO_ORDER_CONFIRM_CODE,soOrder);
        // 设置区域编码并取得其前两位物流区编码
        String districtCode = orderBean.getSoOrder().getDistrictCode();
        String logcCode = districtCode.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_TWO);
        bso152402Param.setFilter("lgcsCode", logcCode);

        for (SoOrderDetail orderDetail : orderBean.getSoOrderDetails()) {
            if (StatusConst.OrderDetailStatusDef.CANCEL == orderDetail.getDetailStatus()) {
                //如果该明细为取消状态,则不进行分单
                continue;
            }
            String orderLevel = String.valueOf(orderDetail.getOrderDetailLevel());
            String pdCode = orderDetail.getPdCode();
            bso152402Param.setFilter("orderLevel", orderLevel);
            bso152402Param.setFilter("pdCode", pdCode);

            // 取得同一物流区,同一订单等级,同一产品的排行
            List<SoSalesRanking> salesRankingList = bso152401logic.getSalesRanking(bso152402Param);
            //取得同一物流区，同一产品最大排行
            SoSalesRanking maxRankings = this.getMaxRanking(bso152402Param);
            Integer maxRanking = maxRankings.getSalesRanking();
            //从库存表里去明细表里的产品数据
            List<SoStockSp> spList = super.findList(SqlId.SQL_ID_FIND_SP_FOR_SALES_RANKING,bso152402Param);
            if(salesRankingList.size() == 0){
                //当产品有库存没有排行是用库存表里的数据
                salesRankingList = this.setNewRanking(spList,pdCode,logcCode,maxRanking,falseOrSuccFlag);
                //当明细表里数据在库存表里不存在时，分销失败
                if(salesRankingList.size() == 0){
                    falseOrSuccFlag = false;
                }
            }

            int rankingSize = salesRankingList.size();

            if (rankingSize > NumberConst.IntDef.INT_ZERO) {
                // 取得排行中的第一个供应商的分销信息
                SoSalesRanking ranking = salesRankingList.get(NumberConst.IntDef.INT_ZERO);
                // 当前轮次取得
                int wheel = ranking.getWheelFrequency();

                // 该供应商库存充足,直接分单结束,继续下个订单详细
                // 若库存不足,则进行处理
                if (!checkStockAndUpdate(slCode, orderDetail, ranking)) {

                    // 该轮次是否有单一供应商库存充足,可以单独供货
                    boolean isSingle = false;
                    // 该供应商库存不足,查找该排行中的当前轮次是否有卖家符合条件
                    for (SoSalesRanking ranking1 : salesRankingList) {
                        // 轮次符合,并且未找到单一供货的供应商的时候
                        if (ranking1.getWheelFrequency() == wheel) {
                            // 检查库存,若充足则更新,并更新单一供货flag,然后结束循环
                            if (checkStockAndUpdate(slCode, orderDetail, ranking1)) {
                                isSingle = true;
                                break;
                            }
                        } else {
                            // 若轮次不符合则直接跳出循环
                            break;
                        }
                    }

                    // 若可以单一供货则继续下一个订单详细
                    // 如果不能单一供货,则进行拼货
                    if (!isSingle) {
                        // 需要分单数量,初始值为订单数量
                        BigDecimal distributionQty = orderDetail.getOrderQty();
                        // 开始拼货并获得剩余数量
                        distributionQty = this.updateList(slCode, orderDetail, distributionQty, salesRankingList);
                        // 判断剩余数量
                        if (!DecimalUtil.isZero(distributionQty)) {
                            // 若剩余数量不为0,则重新取得排行并继续拼货
                            List<SoSalesRanking> salesRankingList2 = bso152401logic.getSalesRanking(bso152402Param);
                            distributionQty = this.updateList(slCode, orderDetail, distributionQty, salesRankingList2);
                            if (!DecimalUtil.isZero(distributionQty)) {
                                // 若剩余数量依然不为0
                                falseOrSuccFlag = false;
                            }
                        }
                    }
                }
            } /*else {
                throw new BusinessException("未取得物流区编码为" + logcCode + ",订单等级编码为"
                        + orderLevel + ",产品编码" + pdCode + "的销售排行!");
            }*/
        }

        if(falseOrSuccFlag){
            // 所有订单详细信息处理成果,更新订单状态(已确认)
            this.updateOrderStatus(soOrder);
            if(checkForPendingAuditStatus(soOrder)){
                modifyOrderPendingAudit(soOrder);
                modifyOrderDetailPendingAudit(soOrder);
                modifyOrderDetailAvailabilityPendingAudit(soOrder);
            }else {
                soOrder = null;
            }
        }else {
            //分销失败时更新
            // Modify by wang_jianzhou for bug#3815 at 2016/11/30 Start.
            throw new BusinessException("分销失败");
            // Modify by wang_jianzhou for bug#3815 at 2016/11/30 end.
        }
        return soOrder;
    }
    //取得最大排行
    private SoSalesRanking getMaxRanking(BSO152402Param param){
        SoSalesRanking maxRankings = super.findOne(SqlId.SQL_ID_FIND_MAX_SALES_RANKING,param);
        return maxRankings;
    }

    //根据库存表里数据设置新排行
    private List<SoSalesRanking> setNewRanking(List<SoStockSp> spList,String pdCode,String lgcsCode,Integer maxRanking,boolean falseOrSuccFlag){
        List<SoSalesRanking> salesRankingList = new ArrayList<>();
        if(spList.size()>0){
            for(int b = 0; b<spList.size(); b++){
                SoSalesRanking newSalesRanking = new SoSalesRanking();
                newSalesRanking.setLgcsCode(lgcsCode);
                newSalesRanking.setOrderLevel(NumberConst.IntDef.INT_ZERO);
                newSalesRanking.setPdCode(pdCode);
                newSalesRanking.setSuppCode(spList.get(b).getSupplierCode());
                newSalesRanking.setSuppName(spList.get(b).getSupplierName());
                newSalesRanking.setPriceCycle(null);
                newSalesRanking.setSalesAmount(null);
                newSalesRanking.setSalesRanking(maxRanking + NumberConst.IntDef.INT_ONE);
                newSalesRanking.setDistQua(null);
                newSalesRanking.setWheelFrequency(NumberConst.IntDef.INT_ZERO);
                salesRankingList.add(newSalesRanking);
            }
        }
        return salesRankingList;
    }



    /**
     * check单一供应商库存,若充足则更新后返回,若不足则直接返回
     *
     * @param slCode      卖家编码
     * @param orderDetail 订单详细信息
     * @param ranking     供应商排行信息
     * @return true:库存充足,false:库存不足
     */
    @Transactional
    private boolean checkStockAndUpdate(String slCode, SoOrderDetail orderDetail, SoSalesRanking ranking) {
        logger.debug("check单一供应商库存,若充足则更新后返回,若不足则直接返回");
        //todo
        // 设置共通传入参数
        StockParam stockParam = getStockParam(slCode, ranking);
        // 需要更新数量(比如:订单数量)
        stockParam.setStockNum(orderDetail.getOrderQty());

        // 调用共通,检查卖家库存是否充足
        boolean isStocked = stockLogic.checkSuppStockQty(stockParam);
        if (isStocked) {
            // 库存充足,直接更新,返回true
            this.updateDistribution(stockParam, orderDetail);
            this.updateSalesRanking(ranking);
            return true;
        } else {
            // 库存不足,不更新,返回false
            //库存不足时则有库存为0的情况，做断货处理
            if(stockLogic.shortSupplyProduct(stockParam))
            {
                //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou Start.
               /* //根据【卖家ID、卖家产品ID】查询sl_product
                SlProductBean slProductBean = slProductLogic.findProduct(slCode,orderDetail.getPdCode());
                if (null != slProductBean)
                {
                    slProductBean.setStatus("8");//设为断货处理  CodeMasterConst.slProductStatus.DH
                    slProductBean.setHisId(commonLogic.maxId("sl_product_status_his", "HIS_ID"));
                    //将查询结果插入sl_product_status_his,状态=8
                    slProductLogic.saveProductStatusHis(slProductBean);
                }*/
                //根据【卖家ID、卖家产品ID】查询sl_product
                List<SlProductBean> slProductBeans = slProductLogic.findProduct(slCode,orderDetail.getPdCode());
                if(!CollectionUtils.isEmpty(slProductBeans)){
                    for (SlProductBean slProductBean : slProductBeans){
                        //将查询结果插入sl_product_status_his,状态=8
                        slProductBean.setStatus("8");//设为断货处理
                        slProductBean.setHisId(commonLogic.maxId("sl_product_status_his", "HIS_ID"));
                        slProductLogic.saveProductStatusHis(slProductBean);
                    }
                    //Modify for bug#1189 at 2016/07/13 by wanng_jianzhou end.
                }
                logger.info("产品" + orderDetail.getPdName() + "断货");
            }
            return false;
        }
        //return false;
    }

    @Transactional
    private BigDecimal updateList(String slCode, SoOrderDetail orderDetail, BigDecimal distributionQty,
                                  List<SoSalesRanking> rankings) {
        logger.debug("插入多个供应商供货信息,并更新其库存和排行");

        // 累计库存,初始值为0
        BigDecimal stockQty;

        for (SoSalesRanking ranking : rankings) {
            // 取得该供应商库存
            // 设置共通传入参数
            StockParam stockParam = getStockParam(slCode, ranking);
            stockQty = this.getStockQty(stockParam);

            // 判断累计库存数量和订单数量大小
            if (DecimalUtil.isGreater(stockQty, distributionQty)) {
                // 若大于则获得剩余分销数量
                stockParam.setStockNum(distributionQty);
                // 更新剩余数量
                distributionQty = BigDecimal.ZERO;
            } else {
                // 若小于则获得全部库存数量
                stockParam.setStockNum(stockQty);
                // 更新剩余数量
                distributionQty = DecimalUtil.subtract(distributionQty, stockQty);
            }
            // 更新分销结果
            this.updateDistribution(stockParam, orderDetail);
            // 更新排行
            this.updateSalesRanking(ranking);
            // 判断剩余数量
            if (DecimalUtil.isZero(distributionQty)) {
                // 若剩余数量为0,则拼货结束
                break;
            }
        }
        return distributionQty;
    }

    /**
     * 根据供应商排行信息取得其库存数量
     *
     * @param stockParam StockParam
     * @return 库存数量
     */
    @Transactional
    private BigDecimal getStockQty(StockParam stockParam) {
        logger.debug("根据供应商排行信息取得其库存数量");
        return stockLogic.getSuppStockQty(stockParam);
    }

    /**
     * 根据供应商信息取得其库存param
     *
     * @param slCode  卖家编码
     * @param ranking 供应商排行信息
     * @return 库存param
     */
    private StockParam getStockParam(String slCode, SoSalesRanking ranking) {
        logger.debug("根据供应商信息取得其库存param");
        // 设置共通传入参数
        StockParam stockParam = new StockParam();
        // 物流区编号(char(2))
        stockParam.setLgcsCode(ranking.getLgcsCode());
        // 产品编码
        stockParam.setPdCode(ranking.getPdCode());
        // 卖家编码
        stockParam.setSlCode(slCode);
        // 供应商编码
        stockParam.setSupplierCode(ranking.getSuppCode());
        stockParam.setSupplierName(ranking.getSuppName());
        return stockParam;
    }

    /**
     * 更新分单结果
     *
     * @param stockParam  StockParam
     * @param orderDetail SoOrderDetail
     */
    @Transactional
    private void updateDistribution(StockParam stockParam, SoOrderDetail orderDetail) {
        logger.debug("更新分单结果");
        // 新增供货信息
        this.addOrderDetailAvailability(stockParam, orderDetail);
        //todo
        // 更新库存(冻结库存)
        //stockLogic.frozenStockSupp(stockParam);
    }

    /**
     * 新增供货信息
     *
     * @param stockParam  StockParam
     * @param orderDetail SoOrderDetail
     */
    @Transactional
    private void addOrderDetailAvailability(StockParam stockParam, SoOrderDetail orderDetail) {
        logger.debug("在订单供货信息表中新增一条纪录");
        SoOrderDetailAvailability availability = orderComm.getAvailabilityEntity(orderDetail);
        availability.setSupplierCode(stockParam.getSupplierCode());
        availability.setSupplierName(stockParam.getSupplierName());
        availability.setSuppQty(stockParam.getStockNum());
        Long orderDetailAvailabilityId = commonLogic.maxId("so_order_detail_availability","ORDER_DETAIL_AVAILABILITY_ID");
        availability.setOrderDetailAvailabilityId(orderDetailAvailabilityId);
//        availability.setOrderAvailabilityId();
        availability.setStatus(StatusConst.OrderDetailAvailabilityStatusDef.CONFIRM);
        List<SoOrderDetailAvailability> orderDetailAvailabilityList = new ArrayList<SoOrderDetailAvailability>();
        orderDetailAvailabilityList.add(availability);
        this.orderLogic.saveOrderDetailAvailability(orderDetailAvailabilityList);
        //orderComm.insertAvailability(availability);
    }

    /**
     * 更新销售排行
     *
     * @param ranking SoSalesRanking
     */
    @Transactional
    private void updateSalesRanking(SoSalesRanking ranking) {
        logger.debug("更新销售排行的轮次");
        ranking.setWheelFrequency(ranking.getWheelFrequency() + NumberConst.IntDef.INT_ONE);
        bso152401logic.updateOne(ranking);
    }

    /**
     * 更新订单状态
     *
     * @param soOrder SoOrder
     */
    @Transactional
    private void updateOrderStatus(SoOrder soOrder) {
        logger.debug("更新订单状态");
        OrderStatusParam orderStatusParam = new OrderStatusParam();
        orderStatusParam.setOrderId(soOrder.getOrderId());
        orderStatusParam.setOrderCode(soOrder.getOrderCode());
        orderStatusParam.setOldStatus(soOrder.getOrderStatus());
        orderStatusParam.setNewStatus(StatusConst.OrderStatusDef.CONFIRM);
        orderStatusParam.setUpdTime(DateTimeUtil.getCustomerDate());
        orderStatusParam.setUpdId("batchBSO152402");

        orderStatusContext.handle(orderStatusParam);
    }

    /**
     * 更新订单状态为分销失败
     *
     * @param soOrder SoOrder
     */
    // Modify by wang_jianzhou for bug#3815 at 2016/11/30 Start.
    @Transactional
    public void updateOrderStatusToFalse(SoOrder soOrder) {
        logger.debug("更新订单状态为分销失败");
        OrderStatusParam orderStatusParam = new OrderStatusParam();
        orderStatusParam.setOrderId(soOrder.getOrderId());
        orderStatusParam.setOrderCode(soOrder.getOrderCode());
        orderStatusParam.setOldStatus(soOrder.getOrderStatus());
        orderStatusParam.setNewStatus(StatusConst.OrderStatusDef.DISTRIBUTION_FAIL);
        orderStatusParam.setUpdTime(DateTimeUtil.getCustomerDate());
        orderStatusParam.setUpdId("admin");
        //只需要更新订单状态为分销失败
        this.modify(orderStatusParam);
    }
    // Modify by wang_jianzhou for bug#3815 at 2016/11/30 end.

    public void sendMail(List<SoOrder> orders){

        if(!CollectionUtils.isEmpty(orders)){
            mailPost(orders);
        }
    }


    /**
     * 检查是否需要更新订单相关状态为待审核
     * @param order
     * @return
     */
    @Transactional
    private boolean checkForPendingAuditStatus(SoOrder order){
        //买手囤货不需要修改状态和发邮件
        if(OrderConst.OrderType.BUYER_STOCKPILING_ORDER == order.getOrderType()){
            return false;
        }
        String buyersId = "";
        Date crtTime = null;
        crtTime = order.getCrtTime();
        buyersId = order.getBuyersId();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilterObject("orderId",order.getOrderId());
        List<SoOrderDetail> details = new ArrayList<>();
        //判断子订单是否为待审核，如果子订单为待审核，则后续不需要继续判断，整条订单为待确认
        SoOrderRelation soOrderRelation = super.findOne(SqlId.SQL_ID_BATCH_FIND_RELATION_BY_ID, baseParam);
        if(null != soOrderRelation){
            BaseParam subOrderParam = new BaseParam();
            subOrderParam.setFilterObject("childOrderId",soOrderRelation.getChildOrderId());
            subOrderParam.setFilterObject("status",StatusConst.OrderStatusDef.PENDING_AUDIT);
            baseParam.setFilterObject("childOrderId",soOrderRelation.getChildOrderId());
            //查询子订单是否为待审核
            int subOrderPendingAudit = super.getCount(SqlId.SQL_ID_FIND_SUB_ORDER_BY_CHILD_ID,subOrderParam);
            //如果子订单为待审核，则全部为待审核
            if(subOrderPendingAudit > 0){
                logger.debug("买家ID为 " + order.getOrderId() + " 的订单的买手销售订单为待审核");
                return true;
            }
        }

        //判断买家ID
        int buyerCount = super.getCount(SqlId.SQL_ID_COUNT_ORDERS_BY_BUYER_ID,order);
        if(buyerCount == NumberConst.IntDef.INT_ZERO){
            logger.debug("订单ID为" + buyersId + " 的买家是第一次下单");
            return true;
        }
        //查询订单明细信息
        List<SoOrderDetail> soOrderDetail = super.findList(SqlId.SQL_ID_FIND_ORDER_DETAILS,baseParam);
        details.addAll(soOrderDetail);
        //判断产品是否第一次下单
        for(SoOrderDetail pdCodeSoOrderDetail : details){
            BaseParam detailBaseParam = new BaseParam();
            detailBaseParam.setFilterObject("pdCode",pdCodeSoOrderDetail.getPdCode());
            detailBaseParam.setFilterObject("buyersId",buyersId);
            detailBaseParam.setFilterObject("crtTime",crtTime);
            detailBaseParam.setFilterObject("status",StatusConst.OrderStatusDef.PENDING_AUDIT);
            detailBaseParam.setFilterObject("failStatus",StatusConst.OrderStatusDef.CANCEL);
            int detailCount = super.getCount(SqlId.SQL_ID_GET_CONFIRMED_COUNT,detailBaseParam);
            //只要明细中有一条产品没有审核过，则整条订单为待审核
            if(detailCount == NumberConst.IntDef.INT_ZERO){
                SoOrder soOrder = new SoOrder();
                soOrder.setOrderId(pdCodeSoOrderDetail.getOrderId());
                soOrder.setOrderCode(pdCodeSoOrderDetail.getOrderCode());
                logger.debug("买家ID为 " + buyersId + "，产品编码为 " + pdCodeSoOrderDetail.getPdCode()
                + " 的买家产品满足首单");
                return true;
            }
        }

        //判断下单产品数量是否超过packageQtyStr
        Object packageQtyStr =  super.findObject(SqlId.SQL_ID_FIND_PACKAGE_QTY,null);
        if(null != packageQtyStr){
            logger.debug("PackageQty为" + String.valueOf(packageQtyStr));
            BigDecimal packageQty = new BigDecimal((String)packageQtyStr);
            for(SoOrderDetail pdQtySoOrderDetail : details){
                BigDecimal orderQty = BigDecimal.ZERO;
                for(SoOrderDetail pd : details){
                    if(pd.getPdCode().equals(pdQtySoOrderDetail.getPdCode())){
                        orderQty = orderQty.add(pd.getOrderQty());
                    }
                    if(orderQty.compareTo(packageQty) > 0){
                        logger.debug("产品编码为 " + pd.getPdCode() + " 的下单数量满足首单");
                        SoOrder soOrder = new SoOrder();
                        soOrder.setOrderId(pdQtySoOrderDetail.getOrderId());
                        soOrder.setOrderCode(pdQtySoOrderDetail.getOrderCode());
                        return true;
                    }
                }
            }
        }else {
            logger.debug("请设置PackageQty");
        }
        return false;
    }

    /**
     * 更新订单状态为待审核
     * @param order
     */
    @Transactional
    private void modifyOrderPendingAudit(SoOrder order){
            BaseParam baseParam = new BaseParam();
            Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
            baseParam.setFilterObject("orderId",order.getOrderId());
            baseParam.setFilterObject("status",StatusConst.OrderStatusDef.PENDING_AUDIT);
            baseParam.setFilterObject("updTime",customerDate);
            baseParam.setFilterObject("updId","batchBSO152402");
            super.modify(SqlId.SQL_ID_BATCH_MODIFY_ORDER_PENDING_AUDIT,baseParam);
    }

    /**
     * 更新订单明细状态为待审核
     * @param order
     */
    @Transactional
    private void modifyOrderDetailPendingAudit(SoOrder order){
            BaseParam baseParam = new BaseParam();
            Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
            baseParam.setFilterObject("orderId",order.getOrderId());
            baseParam.setFilterObject("status",StatusConst.OrderDetailStatusDef.PENDING_AUDIT);
            baseParam.setFilterObject("updTime",customerDate);
            baseParam.setFilterObject("updId","batchBSO152402");
            super.modify(SqlId.SQL_ID_BATCH_MODIFY_ORDER_DETAIL_PENDING_AUDIT,baseParam);
    }

    /**
     * 更新供货明细状态为待审核
     * @param order
     */
    @Transactional
    private void modifyOrderDetailAvailabilityPendingAudit(SoOrder order){
            BaseParam baseParam = new BaseParam();
            Date customerDate = DateTimeUtil.parseDate(DateTimeUtil.formatDate("yyyy-MM-dd HH:mm:ss",DateTimeUtil.getCustomerDate()),"yyyy-MM-dd HH:mm:ss");
            baseParam.setFilterObject("orderId",order.getOrderId());
            baseParam.setFilterObject("status",StatusConst.OrderDetailAvailabilityStatusDef.PENDING_AUDIT);
            baseParam.setFilterObject("updTime",customerDate);
            baseParam.setFilterObject("updId","batchBSO152402");
            super.modify(SqlId.SQL_ID_BATCH_MODIFY_ORDER_DETAIL_AVAILABILITY_PENDING_AUDIT,baseParam);
    }


    /**
     * 调接口发邮件
     * @param orders
     */
    private void mailPost(List<SoOrder> orders){
        MailSendRsParam param = setContent();
        String title = "买家订单审核通知";
        StringBuffer context = new StringBuffer();
        context.append("<p>此信为系统自动发送的买家订单审核通知，请不要回复 <br>");
        context.append("------------------------------------------------------------- <br>");
        for(SoOrder soOrder : orders){
            context.append("<p>订单ID：" + soOrder.getOrderId() + "</p>");
            context.append("<p>订单编码：" + soOrder.getOrderCode() + "</p>");
        }
        context.append("</p>");
        if(null != param){
            try {
                logger.debug("邮件发送开始");
                for(String mailTo : param.getMailTo()){
                    logger.debug("收件人:" + mailTo);
                }
                for(SoOrder order : orders){
                    logger.debug("订单ID:" + order.getOrderId());
                    logger.debug("订单编码:" + order.getOrderCode());
                }
                MailHandle.sendHtmlEmail(title,context.toString(),param.getMailTo());
                logger.debug("邮件发送成功");
            }catch (Exception e){
                logger.error("邮件发送失败",e);
            }
        }
    }

    /**
     * 设置邮件内容
     * @param
     * @return
     */
    @Transactional
    private MailSendRsParam setContent(){
        MailSendRsParam param = new MailSendRsParam();

        List<BatchSoConstantBean> soConstantBeens = super.findList(SqlId.SQL_ID_GET_EMAIL_ADDRESS,null);
        if(CollectionUtils.isEmpty(soConstantBeens)){
            logger.debug("没有收件人，请配置收件人邮箱");
            return null;
        }
        List<String> mailToAddresses = new ArrayList<String>();
        for(BatchSoConstantBean soConstantBean : soConstantBeens){
            mailToAddresses.add(soConstantBean.getEmailAddress());
        }
        String [] arr = mailToAddresses.toArray(new String[0]);
        param.setMailTo(arr);
        for(String mailTo : arr){
            logger.debug("将发送给:" + mailTo);
        }
        return param;
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yuan_chen
     */
    interface SqlId {
        static final String SQLID_TEST_INSERT = "testInsert";
        static final String SQL_ID_MODIFY_SO_ORDER_CONFIRM_CODE ="modifyConfirmCode";
        static final String SQL_ID_MODIFY_SO_ORDER_DISTRIBUTION_FAIL ="modifyDistributionFail";
        static final String SQL_ID_MODIFY_SO_ORDER_DETAIL_DISTRIBUTION_FAIL ="modifyDetailDistributionFail";
        static final String SQL_ID_FIND_MAX_SALES_RANKING = "findMaxSalesRanking";
        static final String SQL_ID_FIND_SP_FOR_SALES_RANKING = "findSpForSalesRanking";
        static final String SQL_ID_FIND_PACKAGE_QTY = "findPackageQty";
        static final String SQL_ID_COUNT_ORDERS_BY_BUYER_ID = "countOrdersByBuyerId";
        static final String SQL_ID_COUNT_PRODUCT_BY_PRODUCT_CODE = "countProductByProductCode";
        static final String SQL_ID_FIND_ORDER_DETAILS = "findOrderDetails";
        static final String SQL_ID_BATCH_MODIFY_ORDER_PENDING_AUDIT = "batchModifyOrderPendingAudit";
        static final String SQL_ID_BATCH_MODIFY_ORDER_DETAIL_PENDING_AUDIT = "batchModifyOrderDetailPendingAudit";
        static final String SQL_ID_BATCH_MODIFY_ORDER_DETAIL_AVAILABILITY_PENDING_AUDIT = "batchModifyOrderDetailAvailabilityPendingAudit";
        static final String SQL_ID_GET_EMAIL_ADDRESS = "batchGetEmailAddress";
        static final String SQL_ID_GET_CONFIRMED_COUNT = "getConfirmedCount";
        static final String SQL_ID_BATCH_FIND_RELATION_BY_ID = "batchFindRelationById";
        static final String SQL_ID_FIND_SUB_ORDER_BY_CHILD_ID = "findSubOrderByChildId";
    }
}
