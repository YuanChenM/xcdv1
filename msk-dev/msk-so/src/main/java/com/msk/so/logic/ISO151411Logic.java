package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.ISO151411RsParam;
import com.msk.so.bean.ISO151411RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * *ISO151411Logic
 * @author sunjiaju
 * @version 1.0
 **/
public class ISO151411Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 支付结果查询
     * @param param
     */
    @Transactional(readOnly = true)
    public ISO151411RsResult searchPaymentResult(ISO151411RsParam param){
        ISO151411RsResult result =  new ISO151411RsResult();
        result.setOrderId(param.getOrderId());
        result.setPaymentOrderCode(param.getPaymentOrderCode());
        Integer paymentCount = super.getCount(SqlId.SQL_ID_GET_PAYMENT_COUNT, param);
        if (paymentCount> NumberConst.IntDef.INT_ZERO){
            result.setPaymentResult(NumberConst.IntDef.INT_ONE);
        } else {
            result.setPaymentResult(NumberConst.IntDef.INT_ZERO);
        }
        return result;
    }

    interface SqlId {
        String SQL_ID_GET_PAYMENT_COUNT = "getPaymentCount";
    }
}
