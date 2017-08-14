package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.SlEnterprise;
import com.msk.sl.bean.SlEpAgentAuthBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SL24110301001Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        String SQL_ID_SAVE_AGENT_DATA = "saveAgentData";
        String SQL_ID_SAVE_OEM_DATA = "saveOemData";
    }

    //查询企业数据
    public PageResult<SlEnterprise> queryData(BasePageParam param) {
        return super.findPage(param, SlEnterprise.class);
    }
}