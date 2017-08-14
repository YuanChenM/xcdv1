package com.msk.by.logic;

import java.util.List;

import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchStdOrg;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.ByBuyerRecAddr;
import com.msk.core.entity.PdStandard;

/**
 * 买家产品原种种源标准调研用Logic.
 *
 * @author yuan_chen
 */
@Service
public class IBY121212Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121212Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author yuan_chen
     */
    public interface SqlId {
        static final String SQLID_GET_PD_ORG = "getPdOrg";
        static final String SQLID_GET_PD_ORG_STD = "getPdOrgStd";
        static final String SQLID_COUNT_BY_RESEARCH_ORG = "countResearchOrg";
        static final String SQLID_GET_BY_RESEARCH_ORG = "getResearchOrg";
    }

    /**
     * (non-Javadoc)
     *
     * @see BaseLogic#setBaseDao(BaseDao)
     */
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 产品原种种源标准查询
     * 
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByResearchStdOrg> findBuyerOrgList(BaseParam param) {
        logger.debug("产品原种种源标准查询");

        ByResearchStdOrg byResearchStdOrg = super.findOne(SqlId.SQLID_GET_PD_ORG_STD, param);
        long standardId = byResearchStdOrg.getStandardId();
        param.getFilterMap().put("standardId", standardId);
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_ORG, param);
        if (count > NumberConst.IntDef.INT_ZERO){
            return super.findList(SqlId.SQLID_GET_BY_RESEARCH_ORG, param);
        }else {
            return super.findList(SqlId.SQLID_GET_PD_ORG, param);
        }
    }

    /**
     * 产品原种种源标准更新
     *
     * @param byResearchStdOrg byResearchStdOrg
     * @return
     */
    @Transactional
    public int updateBuyerOrg(ByResearchStdOrg byResearchStdOrg) {
        logger.debug("产品原种种源标准更新");

        byResearchStdOrg.setUpdTime(DateTimeUtil.getCustomerDate());
        byResearchStdOrg.setDelFlg(SystemConst.DelFlg.ENABLE);
        byResearchStdOrg.setVer(NumberConst.IntDef.INT_ONE);
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyerId", byResearchStdOrg.getBuyerId());
        param.getFilterMap().put("standardId", byResearchStdOrg.getStandardId());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_ORG, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            super.save(byResearchStdOrg);
        }
        return super.modify(byResearchStdOrg);
    }
}
