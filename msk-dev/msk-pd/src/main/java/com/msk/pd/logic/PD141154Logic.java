package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.pd.bean.PdTcProviderPackageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PD141154Logic
 * @author pxg
 */
@Service
public class PD141154Logic extends BaseLogic {

    /**
     * SQL Map 中SQL ID定义
     * @author pxg
     */
    interface SqlId {
        String SQL_ID_FIND_SAVE_ON_LINE = "findSaveOnLine";
    }

    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 查询正式上线记录是否存在
     * @param pageParam pageParam
     * @return
     */
    public PageResult<PdTcProviderPackageParam> queryProvider(BasePageParam pageParam){
        return super.findPage(pageParam, PdTcProviderPackageParam.class);
    }
}
