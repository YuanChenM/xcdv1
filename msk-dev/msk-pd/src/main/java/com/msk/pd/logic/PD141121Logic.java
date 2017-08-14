package com.msk.pd.logic;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.MdLogisticsArea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;

import java.util.List;

/**
 * PD141121Logic
 *
 * @author yuan_chen
 */

@Service
public class PD141121Logic extends BaseLogic {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(PD141121Logic.class);

    interface SqlId {
        String SQL_ID_CHECKED = "findListChecked";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    public List<MdLogisticsArea> findListChecked(String lgcsAreaCode){
        BasePageParam param=new BasePageParam();
        param.getFilterMap().put("lgcsAreaCode", lgcsAreaCode);
        List<MdLogisticsArea> li = super.findList(SqlId.SQL_ID_CHECKED,param);
        return li;
    }
}
