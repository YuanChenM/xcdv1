package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrder;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * ISO151803Logic.
 *
 * @author zhang_qiang1
 */
@Service
public class ISO151803Logic extends BaseLogic {


    /**
     *
     * @param param
     * @return
     */
    public ISO151803RsResult  findOrderInfo(ISO151803RsParam param){
        param.setReturnDays(NumberConst.IntDef.INT_THREE);
        ISO151803RsResult result= super.findOne(SqlId.SQL_ID_FIND_ORDER,param);
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        List<ISO151803Ship> shipList=  super.findList(SqlId.SQL_ID_FIND_SHIP,param);
        if(result!=null){
            result.setShipList(shipList);
            for(ISO151803Ship ship :shipList){
                param.setShipId(ship.getShipId());
                List<ISO151803Product>productList= super.findList(SqlId.SQL_ID_FIND_ORDER_DETAIL,param);
                ship.setProductList(productList);
            }
        }
        return  result;
    }


    interface SqlId {
        String SQL_ID_FIND_ORDER = "findOrder";// 查询主订单
        String SQL_ID_FIND_SHIP = "findShip";// 查询发货明细
        String SQL_ID_FIND_ORDER_DETAIL = "findOrderDetail";// 查询供货明细


    }


    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


}
