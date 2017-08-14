package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151426OrderRsResult;
import com.msk.so.bean.ISO151426PruductRsResult;
import com.msk.so.bean.ISO151426RsParam;
import com.msk.so.bean.ISO151426RsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu_tao2 on 2016/4/19.
 */
@Service
public class ISO151426Logic extends BaseLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151426Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Transactional
    public ISO151426RsResult findPageResult(ISO151426RsParam param)
    {
        if(StringUtil.isEmpty(param.getHousekeepingId()))
        {
            throw new BusinessException("参数不正确");
        }

        ISO151426RsResult result = new ISO151426RsResult();
        List<ISO151426OrderRsResult> resultList = new ArrayList<>();

        if(param.getPageCount() != NumberConst.IntDef.INT_ZERO && param.getPageNo() != NumberConst.IntDef.INT_ZERO)
        {
            param.setPaging(true);
        }
        else
        {
            param.setPaging(false);
        }

        resultList = this.findPageList(param,result);

        if(!CollectionUtils.isEmpty(resultList))
        {
            for(ISO151426OrderRsResult orderInfo : resultList)
            {
                BaseParam baseParam = new BaseParam();
                baseParam.getFilterMap().put("orderId",orderInfo.getOrderId());
                List<ISO151426PruductRsResult> products = this.findList(SqlId.SQL_ID_GET_DETAIL_INFO_BY_ID,baseParam);
                orderInfo.setProducts(products);
            }
        }

        result.setOrders(resultList);

        return result;
    }

    interface SqlId{
        String SQL_ID_GET_DETAIL_INFO_BY_ID = "getDetailInfoById";
    }
}
