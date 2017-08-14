package com.msk.so.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151405RsParam;
import com.msk.so.bean.PdCodeBean;
import com.msk.so.bean.PdSalesResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * *ISO151405Logic
 * *@author sunjiaju
 * *@version 1.0
 **/
public class ISO151405Logic extends BaseLogic{
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
    public List<PdSalesResult> getPdList(ISO151405RsParam param){
        if (CollectionUtils.isEmpty(param.getPdCodeList())){
            throw new BusinessException("请传递产品编码列表！");
        }
        if ((param.getFuzzyValueLimit() == null && param.getIsReturnFuzzy() != null)
                || (param.getFuzzyValueLimit() != null && param.getIsReturnFuzzy() == null)){
            throw new BusinessException("请同时传递模糊值格式、模糊值对比界限值！");
        }
        List<PdSalesResult> results = new ArrayList<>();
        for(PdCodeBean bean : param.getPdCodeList()){
            if (StringUtil.isEmpty(bean.getPdCode())){
                throw new BusinessException("产品编码没有传值！");
            }
            PdSalesResult result = super.findOne(SqlId.SQL_ID_FIND_PD_LIST, bean);
            if (result != null){
                results.add(result);
            }
        }
        if (param.getIsReturnFuzzy()!= null && param.getIsReturnFuzzy() == NumberConst.IntDef.INT_ZERO){
                for(PdSalesResult result : results){
                    if (result.getSalesVolumnLong() > param.getFuzzyValueLimit()){
                        // Modify for Bug#2609 at 2016/09/21 by sun_jiaju Start
                        result.setSalesVolumn(">" + result.getSalesVolumnLong()/10000 + '万');
                        // Modify for Bug#2609 at 2016/09/21 by sun_jiaju End
                    }else{
                        result.setSalesVolumn(result.getSalesVolumnLong().toString());
                    }
                    result.setSalesVolumnLong(null);
                }
        } else{
            for(PdSalesResult result : results){
                result.setSalesVolumn(result.getSalesVolumnLong().toString());
                result.setSalesVolumnLong(null);
            }
        }
        return results;
    }

    interface SqlId {
        String SQL_ID_FIND_PD_LIST = "findPdList";
    }
}
