package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.sl.bean.SL241129Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PD141154Logic
 * @author pxg
 */
@Service
public class SL241129Logic extends BaseLogic {

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
    public PageResult<SL241129Bean> queryProvider(BasePageParam pageParam){
        return super.findPage(pageParam, SL241129Bean.class);
    }
}
