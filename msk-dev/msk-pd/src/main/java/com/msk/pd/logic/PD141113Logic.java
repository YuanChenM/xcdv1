package com.msk.pd.logic;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.PdStandard;
/**
 * 
 * PD141113Logic.
 * @author jiang_nan
 */

@Service
public class PD141113Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * @author gyh
     */
    interface SqlId {
        String SQL_ID_DELETE_BY_INFO = "getPdStandard";
    }
    /**
     * 
     * 根据产品标准id获取产品标准记录
     * @param baseParam baseParam
     * @return 产品标准记录
     * @author gyh
     */
    public PdStandard getPdStandard(BaseParam baseParam){
        return super.findOne(SqlId.SQL_ID_DELETE_BY_INFO, baseParam);
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

}
