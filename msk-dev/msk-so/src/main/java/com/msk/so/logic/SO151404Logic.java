package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;

/**
 * OM141102 Logic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class SO151404Logic extends BaseLogic {

    //更新SO_ORDER表里的订单总金额
    @Transactional
    public Long modifyOrderAmount(SoOrderDetail orderDetail){
        Long id = null;
        super.modify(orderDetail);
        BaseParam param1 = new BaseParam();
        param1.setUpdId(orderDetail.getUpdId());
        param1.setUpdTime(orderDetail.getUpdTime());
        param1.setFilterObject("orderId",orderDetail.getOrderId());
        SoOrderRelation relation = haveRelation(param1);
        BigDecimal allPrice = BigDecimal.ZERO;
        SoOrder mainOrder = new SoOrder();
        if(null != relation){
            param1.setFilterObject("orderId",relation.getMainOrderId());
            //查询主订单金额
            mainOrder = super.findOne(SqlId.SQL_ID_GET_MAIN_ORDER_AMOUNT,param1);
            param1.setFilterObject("childId",relation.getChildOrderId());
            //查询子订单金额
            SoOrder childAmount = super.findOne(SqlId.SQL_ID_GET_CHILD_ORDER_AMOUNT,param1);
            param1.setFilterObject("childAmount",childAmount.getOrderAmount());
            //更新子订单金额
            super.modify(SqlId.SQL_ID_MODIFY_SO_CHILD_ORDER_AMOUNT,param1);
            allPrice = mainOrder.getOrderAmount().add(childAmount.getOrderAmount());
            id = relation.getMainOrderId();
        }else {
            //查询主订单金额
             mainOrder = super.findOne(SqlId.SQL_ID_GET_MAIN_ORDER_AMOUNT,param1);
             allPrice = mainOrder.getOrderAmount();
            id = orderDetail.getOrderId();
        }
        param1.setFilterObject("orderAmount",allPrice);
        //更新主订单金额
        int count = super.modify(SqlId.SQL_ID_MODIFY_SO_ORDER_AMOUNT,param1);
        if(count == NumberConst.IntDef.INT_ZERO){
            throw new BusinessException("更新失败");
        }
     return id;
    }

    //查询是否有子订单
    public SoOrderRelation haveRelation(BaseParam param){
        int count = super.getCount(SqlId.SQL_ID_GET_ORDER_RELATION,param);
        SoOrderRelation childOrder = new SoOrderRelation();
        if(count > NumberConst.IntDef.INT_ZERO){
            childOrder = super.findOne(SqlId.SQL_ID_GET_CHILD_ORDER,param);
            return childOrder;
        }
        return null;
    }
    interface SqlId{
        String SQL_ID_MODIFY_SO_ORDER_AMOUNT = "modifyOrderAmount";
        String SQL_ID_MODIFY_SO_CHILD_ORDER_AMOUNT = "modifyChildOrderAmount";
        String SQL_ID_GET_MAIN_ORDER_AMOUNT = "getMainOrderAmount";
        String SQL_ID_GET_CHILD_ORDER_AMOUNT = "getChildOrderAmount";
        String SQL_ID_GET_ORDER_RELATION = "getOrderRelation";
        String SQL_ID_GET_CHILD_ORDER = "getChildOrder";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
