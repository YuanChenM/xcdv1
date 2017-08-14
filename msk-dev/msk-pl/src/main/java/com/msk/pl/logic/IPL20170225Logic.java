package com.msk.pl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.pl.bean.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@Service
public class IPL20170225Logic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        static final String SQL_ID_FIND_PL_INFO_ID = "findPlInfoId";//查询合伙人配送站ID
    }


    /**
     *
     * @param param
     * @return
     * 外勤登陆用户查询
     */
    @Transactional(readOnly = true)
    public IPL20170225Result findReDay(IPL20170225Param param) {
        PLInfo plInfoIdTerPar =  super.findOne(SqlId.SQL_ID_FIND_PL_INFO_ID, param);
        if(plInfoIdTerPar!=null && StringUtils.isNotBlank(plInfoIdTerPar.getTerminalId().toString())&&StringUtils.isNotBlank(plInfoIdTerPar.getPartnerId().toString())){
            param.setFilter("terminalId", plInfoIdTerPar.getTerminalId().toString());
            param.setFilter("partnerId", plInfoIdTerPar.getPartnerId().toString());
            return super.findOne(param);

        }
         return null;
    }
}
