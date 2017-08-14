package com.msk.so.logic;


import java.util.Date;
import java.util.List;

import com.msk.common.consts.StatusConst;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrderRelation;
import com.msk.core.entity.SoOrderShip;
import com.msk.core.exception.BusinessException;
import com.msk.so.bean.ModifyStatusBean;
import com.msk.so.bean.ModifyStatusParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderStatus;
import com.msk.core.utils.DateTimeUtil;
import com.msk.so.bean.BaseOrderParam;
import com.msk.so.bean.OrderStatusParam;

/**
 * OrderStatus
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class OrderStatusLogic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(OrderStatusLogic.class);
    @Autowired
    private CommonLogic commonLogic;
    interface SqlId {
        String SQLID_GET_ORDERS = "getOrdersByStatus";
        String SQLID_UPDATE_ORDER_DETAIL_STATUS = "modifyOrderDetailStatus";
        String SQLID_UPDATE_ORDER_AVAILIBILITY_STATUS = "modifyOrderAvailabilityStatus";
        String SQLID_UPDATE_ORDER_STATUS = "modifyOrderStatus";
        String SQL_ID_FIND_RELATION = "findRelation";
        String SQL_ID_FIND_COUNT = "findCount";
        String SQL_ID_UPDATE_ORDER_STATUS_BY_DETAIL_STATUS = "modifyOrderStatusByDetailStatus";
        String SQL_ID_FIND_ORDER_SHIP = "findOrderShip";
        String SQL_ID_FIND_SHIP_COUNT = "findShipCount";
        String SQL_ID_UPDATE_SHIP_STATUS = "modifyShipStatus";
        // Modify for bug#1506 at 2016/07/29 by wang_jianzhou Start.
        String SQLID_UPDATE_CHILD_ORDER_STATUS = "modifyChildOrderStatus";
        String SQLID_UPDATE_CHILD_ORDER_DETAIL_STATUS = "modifyOrderChildDetailStatus";
        String SQLID_UPDATE_CHILD_ORDER_AVAILIBILITY_STATUS = "modifyChildOrderAvailabilityStatus";
        String SQLID_GET_CHILD_ORDERS = "getChildOrdersById";
        // Modify for bug#1506 at 2016/07/29 by wang_jianzhou end.
    }

    @Transactional
    public void modifyOrderCancel(BaseOrderParam orderParam){
        String tabelName = "SO_ORDER";
        String [] orderId= new String[1];
        orderId[0] = "ORDER_ID";
        Integer ver = orderParam.getVer();
        Object [] orderKey =new Object[1];
        orderKey [0] = orderParam.getOrderId();

        super.versionValidator(tabelName, orderId, orderKey, ver);
        Date customerDate = DateTimeUtil.getCustomerDate();
        orderParam.setUpdTime(customerDate);
        //订单状态：99 取消
        orderParam.setFilterObject("orderStatus", StatusConst.OrderStatusDef.CANCEL);
        int count = super.modify(SqlId.SQLID_UPDATE_ORDER_STATUS,orderParam);
        if(count== NumberConst.IntDef.INT_ZERO){
            throw new BusinessException("订单取消失败,没有找到对应的信息");
        }
        //订单明细状态：8 取消
        orderParam.setFilterObject("detailStatus", StatusConst.OrderDetailStatusDef.CANCEL);
        super.modify(SqlId.SQLID_UPDATE_ORDER_DETAIL_STATUS,orderParam);
        //订单明细供应商状态：99 取消
        orderParam.setFilterObject("status", StatusConst.OrderDetailAvailabilityStatusDef.CANCEL);
        // Modify for bug#1506 at 2016/07/26 by wang_jianzhou Start.
        super.modify(SqlId.SQLID_UPDATE_ORDER_AVAILIBILITY_STATUS,orderParam);
        //是否有子订单
        SoOrderRelation relation = super.findOne(SqlId.SQLID_GET_CHILD_ORDERS,orderParam);
        if(null!= relation && null != relation.getChildOrderId()){
            orderParam.setFilterObject("childId",relation.getChildOrderId());
            super.modify(SqlId.SQLID_UPDATE_CHILD_ORDER_STATUS,orderParam);
            super.modify(SqlId.SQLID_UPDATE_CHILD_ORDER_DETAIL_STATUS,orderParam);
            super.modify(SqlId.SQLID_UPDATE_CHILD_ORDER_AVAILIBILITY_STATUS,orderParam);
        }
        // Modify for bug#1506 at 2016/07/26 by wang_jianzhou end.
        logger.info("订单全部取消操作");
    }

    @Transactional
    public void modifyOrderStatus(OrderStatusParam orderStatusParam){
        Date customerDate = DateTimeUtil.getCustomerDate();
        orderStatusParam.setUpdTime(customerDate);
        super.modify(orderStatusParam);
        SoOrderStatus orderStatus = new SoOrderStatus();
        orderStatus.setOrderStatus(orderStatusParam.getNewStatus());
        orderStatus.setOrderId(orderStatusParam.getOrderId());
        orderStatus.setOrderCode(orderStatusParam.getOrderCode());
        Long id = commonLogic.maxId("SO_ORDER_STATUS","ID");
        orderStatus.setId(id);
        orderStatus.setCrtId(orderStatusParam.getCrtId());
        orderStatus.setCrtTime(customerDate);
        super.save(orderStatus);
    }
    @Transactional(readOnly = true)
    public List<SoOrder> getOrdersByStatus(BaseParam param){
        param.setFilterObject("failStatus",StatusConst.OrderStatusDef.DISTRIBUTION_FAIL);
        return super.findList(SqlId.SQLID_GET_ORDERS, param);
    }
    /**
     * 修改订单状态
     *
     */
    @Transactional
    public void modifyOrderStatusByOrderId(ModifyStatusParam param){
        // 查询订单关联表
        SoOrderRelation sor = super.findOne(SqlId.SQL_ID_FIND_RELATION, param);
        if (sor == null){
            this.modifyOrderStatusByDetailStatus(param);
        }else {
            // 修改子订单
            param.setOrderId(sor.getChildOrderId());
            this.modifyOrderStatusByDetailStatus(param);
            // 修改主订单
            param.setOrderId(sor.getMainOrderId());
            param.setChildId(sor.getChildOrderId());
            this.modifyOrderStatusByDetailStatus(param);
        }
    }

    /**
     * 根据明细状态修改订单状态
     *
     */
    @Transactional
    public void modifyOrderStatusByDetailStatus(ModifyStatusParam param){
        ModifyStatusBean countBean = super.findOne(SqlId.SQL_ID_FIND_COUNT, param);
        Integer orderStatus = null;
        // 设置订单状态
        if (countBean != null){
            if (countBean.getAllCount() == countBean.getCancelCount()){
                // 所属明细状态全为【已取消】，设为【已取消】
                orderStatus = StatusConst.OrderStatusDef.CANCEL;
            } else if(countBean.getAllCount() == countBean.getCancelCount() + countBean.getAllReceiptCount()){
                // 所属明细状态除去【已取消】，全为【全部收货】，设为【全部收货】
                orderStatus = StatusConst.OrderStatusDef.ALL_RECEIPT;
            } else if (countBean.getAllReceiptCount() > 0 || countBean.getPartialReceiptCount() > 0 ){
                // 所属明细状态存在【全部收货】或【部分收货】，设为【部分收货】
                orderStatus = StatusConst.OrderStatusDef.PARTIAL_RECEIPT;
            } else if(countBean.getAllCount() == countBean.getCancelCount() + countBean.getAllShipmentCount()){
                // 所属明细状态除去【已取消】，全为【全部发货】，设为【全部发货】
                orderStatus = StatusConst.OrderStatusDef.ALL_SHIPMENT;
            } else if (countBean.getAllShipmentCount() > 0 || countBean.getPartialShipmentCount() > 0 ){
                // 所属明细状态存在【全部发货】或【部分发货】，设为【部分发货】
                orderStatus = StatusConst.OrderStatusDef.PARTIAL_SHIPMENT;
            } else if (countBean.getWaitDisCount() > 0){
                // 所属明细状态存在【待分销】，设为【待分销】
                orderStatus = StatusConst.OrderStatusDef.WAIT_DISTRIBUTION;
            } else if (countBean.getWaitSendCount() > 0){
                // 所属明细状态存在【待发货】，设为【待发货】
                orderStatus = StatusConst.OrderStatusDef.WAIT_SEND;
            } else{
                // 以上情况外，设为【已确认】
                orderStatus = StatusConst.OrderStatusDef.CONFIRM;
            }
        }
        param.setOrderStatus(orderStatus);
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        super.modify(SqlId.SQL_ID_UPDATE_ORDER_STATUS_BY_DETAIL_STATUS, param);
    }

     /**
     * 修改发货单状态
     *
     */
    @Transactional
    public void modifyShipStatus(ModifyStatusParam param){
        // 查询订单关联表
        SoOrderShip sos = super.findOne(SqlId.SQL_ID_FIND_ORDER_SHIP, param);
        if (sos != null){
            if (sos.getShipStatus() == StatusConst.OrderShipStatusDef.ALL_RETURN
                    || sos.getShipStatus() == StatusConst.OrderShipStatusDef.ALL_LATE_RECEIPT){
                // 发货单状态为【全部迟收】或【全部退货】，不修改状态
                return;
            }
        }
            ModifyStatusBean countBean = super.findOne(SqlId.SQL_ID_FIND_SHIP_COUNT, param);
            Integer shipStatus = null;
            // 设置订单状态
            if (countBean != null){
                if (countBean.getAllCount() == countBean.getCancelCount()){
                    // 所属供货明细状态全为【已取消】，设为【已取消】
                    shipStatus = StatusConst.OrderShipStatusDef.CANCELED;
                } else if(countBean.getAllCount() == countBean.getCancelCount() + countBean.getAllReceiptCount()){
                    // 所属供货明细状态除去【已取消】，全为【全部收货】，设为【全部收货】
                    shipStatus = StatusConst.OrderShipStatusDef.ALL_RECEIPT;
                } else if (countBean.getAllReceiptCount() > 0 || countBean.getPartialReceiptCount() > 0 ){
                    // 所属供货明细状态存在【全部收货】或【部分收货】，设为【部分收货】
                    shipStatus = StatusConst.OrderShipStatusDef.PARTIAL_RECEIPT;
                } else if(countBean.getAllCount() == countBean.getCancelCount() + countBean.getAllShipmentCount()){
                    // 所属供货明细状态除去【已取消】，全为【全部发货】，设为【全部发货】
                    shipStatus = StatusConst.OrderShipStatusDef.ALL_SHIPMENT;
                } else if (countBean.getAllShipmentCount() > 0 || countBean.getPartialShipmentCount() > 0 ){
                    // 所属明细状态存在【全部发货】或【部分发货】，设为【部分发货】
                    shipStatus = StatusConst.OrderShipStatusDef.PARTIAL_SHIPMENT;
                } else{
                    // 以上情况外，设为【待发货】
                    shipStatus = StatusConst.OrderShipStatusDef.WAIT_SEND;
                }
            }
            param.setShipStatus(shipStatus);
            param.setUpdTime(DateTimeUtil.getCustomerDate());
            super.modify(SqlId.SQL_ID_UPDATE_SHIP_STATUS, param);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
}
