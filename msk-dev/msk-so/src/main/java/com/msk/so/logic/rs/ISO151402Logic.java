package com.msk.so.logic.rs;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DecimalUtil;
import com.msk.so.bean.OrderDeliveryBean;
import com.msk.so.bean.order.*;
import com.msk.so.logic.SO151402Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * *ISO151402Logic
 * *@author sunjiaju
 * *@version 1.0
 **/
public class ISO151402Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private SO151402Logic so151402Logic;
    /**
     * 查询订单详细信息
     * @param param
     */
    @Transactional(readOnly = true)
    public OrderPrintBean findOrderBasic(OrderPrintParam param){
        if (param.getOrderId() != 0 || param.getOrderId() != null){
            OrderPrintBean basicInfo = super.findOne(SqlId.SQL_ID_GET_ORDER_INFO,param);
            if (null != basicInfo) {
                OrderPrintReceiveBean receiveBean = super.findOne(SqlId.SQL_ID_GET_RECEIVE_INFO, param);
                if (receiveBean != null) {
                    basicInfo.setReceiveInfo(receiveBean);
                }
                OrderPrintDeliveryReqBean deliveryBean = super.findOne(SqlId.SQL_ID_GET_DELIVERY_INFO, param);
                if (deliveryBean != null){
                    // 设置习惯正常收货时间段
                    StringBuilder receiveTimeResult = new StringBuilder();
                    String[] receiveTimeArray = deliveryBean.getReceiveTime().split(StringConst.COMMA);
                    param.setFilterObject("receiveTime", receiveTimeArray);
                    List<OrderDeliveryBean> orderDeliveryBeanList =  this.so151402Logic.queryReceiveTime(param);
                    for (OrderDeliveryBean orderDeliveryBean : orderDeliveryBeanList) {
                        receiveTimeResult.append(orderDeliveryBean.getReceiveTime()).append(StringConst.BLANK);
                    }
                    deliveryBean.setReceiveTime(receiveTimeResult.toString());
                    basicInfo.setDeliveryReq(deliveryBean);
                }
                List<OrderPrintAvailabilityBean> detailInfo = super.findList(SqlId.SQL_ID_GET_AVAILABILITY_INFO, param);
                for (OrderPrintAvailabilityBean info : detailInfo){
                    info.setSuppQty(DecimalUtil.round(info.getSuppQty(), NumberConst.IntDef.INT_ZERO));
                    info.setSendQty(DecimalUtil.round(info.getSendQty(), NumberConst.IntDef.INT_ZERO));
                    info.setReceiveQty(DecimalUtil.round(info.getReceiveQty(), NumberConst.IntDef.INT_ZERO));
                    info.setCancelQty(DecimalUtil.round(info.getCancelQty(), NumberConst.IntDef.INT_ZERO));
                    info.setReturnQty(DecimalUtil.round(info.getReturnQty(), NumberConst.IntDef.INT_ZERO));
                    info.setRejectionQty(DecimalUtil.round(info.getRejectionQty(), NumberConst.IntDef.INT_ZERO));
                    info.setAmount(info.getPdPrice().multiply(info.getSuppQty()));
                }
                basicInfo.setDetailInfo(detailInfo);
                return basicInfo;
            } else {
                throw new BusinessException("没有该订单Id的订单信息");
            }
        }else {
            throw new BusinessException("请输入订单Id");
        }
    }

    interface SqlId{
        String SQL_ID_GET_ORDER_INFO = "getOrderInfo";
        String SQL_ID_GET_RECEIVE_INFO = "getReceiveInfo";
        String SQL_ID_GET_DELIVERY_INFO = "getDeliveryInfo";
        String SQL_ID_GET_AVAILABILITY_INFO = "getAvailabilityInfo";
    }
}
