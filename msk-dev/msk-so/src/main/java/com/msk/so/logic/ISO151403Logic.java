package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151403RsParam;
import com.msk.so.bean.OrderDeliveryBean;
import com.msk.so.bean.SellerListResult;
import com.msk.so.bean.order.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * *ISO151403Logic
 * *@author sunjiaju
 * *@version 1.0
 **/
public class ISO151403Logic extends BaseLogic{
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询订单卖家详细信息
     * @param param
     */
    @Transactional(readOnly = true)
    public List<SellerListResult> findSellers(ISO151403RsParam param){
        return super.findList(SqlId.SQL_ID_FIND_SELLER_LIST, param);
    }

    interface SqlId{
        String SQL_ID_FIND_SELLER_LIST = "findSellerList";
    }
}
