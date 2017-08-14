package com.msk.so;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.msk.core.consts.NumberConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.msk.so.logic.OrderLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.SoOrder;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.BaseOrderBean;
import com.msk.so.bean.BaseOrderParam;
import com.msk.so.bean.OrderQtyParam;
import com.msk.so.bean.OrderStatusParam;
import com.msk.so.enums.OrderType;
import com.msk.so.enums.QtyType;
import com.msk.so.logic.OrderDetailAvailabilityLogic;
import com.msk.so.logic.OrderStatusLogic;

/**
 * Order
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Component
public class Order {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(Order.class);

    @Autowired
    private OrderLogic orderLogic;

    @Autowired
    private OrderStatusLogic orderStatusLogic;

    @Autowired
    private OrderDetailAvailabilityLogic availabilityLogic;

    /**
     * 更新订单数量,根据QtyType去处理不同的数量<br/>
     * OrderQty.QtyType.SEND_QTY : 发货时候更新
     * OrderQty.QtyType.RECEIVE_QTY : 收货时候更新数量
     * OrderQty.QtyType.CANCEL_QTY : 部分取消更新数量
     * OrderQty.QtyType.CANCEL_ALL_QTY : 全部取消数量
     * @param qtyType Qty Type
     * @param orderQty Order Qty
     */
    public void modifyQty(QtyType qtyType, OrderQtyParam orderQty) {
        logger.info("更新订单数量");
        String orderCode = orderQty.getOrderCode();
        String supplierCode = orderQty.getSupplierCode();
        String pdCode = orderQty.getPdCode();
        BigDecimal qty = orderQty.getQty();
        if (QtyType.SEND_QTY == qtyType) {// 发货更新数量
            logger.info("更新发货数量");
            this.orderLogic.modifyOrderSendQty(orderCode, supplierCode, qty, pdCode);
        } else if (QtyType.RECEIVE_QTY == qtyType) {// 收货更新数量
            this.orderLogic.modifyOrderReceiveQty(orderCode, supplierCode, qty, pdCode);
        } else if (QtyType.CANCEL_QTY == qtyType) {// 部分取消更新数量
            this.orderLogic.modifyOrderCancelQty(orderCode, supplierCode, qty, pdCode);
        } else if (QtyType.CANCEL_ALL_QTY == qtyType) {// 全部取消更新
            this.orderLogic.modifyOrderCancelQty(orderCode);
        }
    }

    /**
     * 订单全部取消.<br/>
     * orderId不能为空<br/>
     * orderCode不能为空<br/>
     * updId不能为空<br/>
     * updDate不能为空<br/>
     * @param baseOrderBean 订单信息.
     */
    public void orderCancelAll(BaseOrderParam baseOrderBean){
        Long orderId = baseOrderBean.getOrderId();
        if(null==orderId || orderId == 0L){
            throw new BusinessException("Order ID 不容许为Null");
        }
        String orderCode = baseOrderBean.getOrderCode();
        if(StringUtil.isEmpty(orderCode)){
            throw new BusinessException("Order Code 不容许为Null");
        }
        String updId = baseOrderBean.getUpdId();
        if(StringUtil.isEmpty(updId)){
            throw new BusinessException("Update ID 不容许为Null");
        }
        Date updDate = baseOrderBean.getUpdTime();
        if(updDate==null){
            throw new BusinessException("Update Date 不容许为Null");
        }
        this.orderStatusLogic.modifyOrderCancel(baseOrderBean);
    }

    public void modifyStatus(OrderStatusParam orderStatus) {

    }

    /**
     * 根据不同的订单类型创建订单编码
     * 
     * @param orderType 订单类型
     * @return 订单编码
     */
    public String createOrderCode(OrderType orderType) {
        return null;
    }

    public void saveOrder(BaseEntity entity) {
        if (entity instanceof SoOrder) {

        }

    }
    public BaseOrderBean getOrder(Long orderId){
        return null;
    }
    public BaseOrderBean getOrder(String orderCode){
        return null;
    }

    /**
     * 根据订单状态取得订单列表
     * @param param param
     * @return
     */
    public List<SoOrder> getOrdersByStatus(BaseParam param){
        return orderStatusLogic.getOrdersByStatus(param);
    }

    /**
     * 根据订单ID取得订单基本信息和订单详细信息列表
     * @param param param
     * @return BaseOrderBean
     */
    public BaseOrderBean getOrderInfoById(BaseParam param){
        return orderLogic.getOrderInfoById(param);
    }


    /**
     * 根据订单详细信息取得订单明细供货信息
     * @param orderDetail SoOrderDetail
     * @return SoOrderDetailAvailability
     */
    public SoOrderDetailAvailability getAvailabilityEntity(SoOrderDetail orderDetail){
        return availabilityLogic.getEntity(orderDetail);
    }


    /**
     * 插入订单明细供货信息
     * @param soOrderDetailAvailability
     * @return 操作结果
     */
    public int insertAvailability(SoOrderDetailAvailability soOrderDetailAvailability){
        logger.info("插入订单明细供货信息");
        List<SoOrderDetailAvailability> orderDetailAvailabilityList = new ArrayList<SoOrderDetailAvailability>();
        orderDetailAvailabilityList.add(soOrderDetailAvailability);
        this.orderLogic.saveOrderDetailAvailability(orderDetailAvailabilityList);
        return NumberConst.IntDef.INT_ONE;
    }
}
