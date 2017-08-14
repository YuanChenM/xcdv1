package com.msk.so.logic;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151423OrdersRsResult;
import com.msk.so.bean.ISO151423RsParam;
import com.msk.so.bean.ISO151423RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu_tao2 on 2016/4/18.
 */
@Service
public class ISO151423Logic extends BaseLogic{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151423Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Transactional
    public ISO151423RsResult getResultInfo(ISO151423RsParam param,String type)
    {
        ISO151423RsResult result = new ISO151423RsResult();

        if(StringUtil.isEmpty(param.getSellers()))
        {
            throw new BusinessException("参数不正确");
        }

        List<ISO151423OrdersRsResult> results = new ArrayList<ISO151423OrdersRsResult>();
        if("seller".equals(type))
        {
            results = this.findList(SqlId.SQL_ID_GET_ORDER_INFO_BY_SL_ID, param);
        }

        if("housekeeping".equals(type))
        {
            results= this.findList(SqlId.SQL_ID_GET_ORDER_INFO_BY_HOUSE_ID,param);
        }

        if("buyer".equals(type))
        {
            results= this.findList(SqlId.SQL_ID_GET_ORDER_INFO_BY_BUYER_ID,param);
        }
        result = dealResult(result, results);

        return result;
    }

    public ISO151423RsResult dealResult(ISO151423RsResult result,List<ISO151423OrdersRsResult> results)
    {
        if(CollectionUtils.isEmpty(results))
        {
            return result;
        }

        String obligation =  "";
        Integer obSum = NumberConst.IntDef.INT_ZERO;
        String waitSend = "";
        Integer waitSum = NumberConst.IntDef.INT_ZERO;
        String allSend = "";
        Integer sendSum = NumberConst.IntDef.INT_ZERO;

        List<ISO151423OrdersRsResult> resultList = new ArrayList<ISO151423OrdersRsResult>();

        for(ISO151423OrdersRsResult rsResult : results)
        {
            if(rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.OBLIGATION  || rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.NEW)
            {
                obligation = NumberConst.IntDef.INT_ONE + ",";
                obSum = rsResult.getStatusQty() + obSum;
            }

            if(rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.PAYMENT|| rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.WAIT_DISTRIBUTION
                    || rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.CONFIRM || rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.WAIT_SEND
                    || rsResult.getOrderStatusNum() ==StatusConst.OrderStatusDef.DISTRIBUTION_FAIL || rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.PENDING_AUDIT
                    || rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.HAVE_AUDITED || rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.IN_DISTRIBUTION)
            {
                waitSend = NumberConst.IntDef.INT_TWO + ",";
                waitSum = waitSum + rsResult.getStatusQty();
            }

            if(rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.ALL_SHIPMENT  || rsResult.getOrderStatusNum() == StatusConst.OrderStatusDef.PARTIAL_RECEIPT)
            {
                allSend = NumberConst.IntDef.INT_THREE + ",";
                sendSum = rsResult.getStatusQty() + sendSum;
            }
        }

        modifyResultInfo(obligation,obSum,resultList);
        modifyResultInfo(waitSend,waitSum,resultList);
        modifyResultInfo(allSend,sendSum,resultList);
        result.setOrders(resultList);
        return result;
    }

    public void modifyResultInfo(String statusStr,Integer sum,List<ISO151423OrdersRsResult> resultList)
    {
        if(!StringUtil.isEmpty(statusStr))
        {
            ISO151423OrdersRsResult newResult = new ISO151423OrdersRsResult();
            statusStr = statusStr.substring(NumberConst.IntDef.INT_ZERO,statusStr.length()-1);
            newResult.setOrderStatus(statusStr);
            newResult.setStatusQty(sum);
            resultList.add(newResult);
        }
    }

    interface SqlId{
        String SQL_ID_GET_ORDER_INFO_BY_HOUSE_ID = "getOrderInfoByHouseId";
        String SQL_ID_GET_ORDER_INFO_BY_SL_ID = "getOrderInfoBySlId";
        String SQL_ID_GET_ORDER_INFO_BY_BUYER_ID = "getOrderInfoByBuyerId";
    }

}
