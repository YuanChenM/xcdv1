package com.msk.by.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchStdMct;
import com.msk.core.entity.ByResearchStdOrg;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 买家产品加工技术标准调研用Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121213Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121213Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    public interface SqlId {
        static final String SQLID_GET_PD_MCT_STD = "getPdMctStd";
        static final String SQLID_COUNT_BY_RESEARCH_MCT= "countResearchMct";
        static final String SQLID_GET_PD_MCT = "getPdMct";
        static final String SQLID_GET_BY_RESEARCH_MCT = "getResearchMct";
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
     * 产品加工技术标准查询
     * 
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByResearchStdMct> findBuyerMctList(BaseParam param) {
        logger.debug("产品加工技术标准查询");

        // 查询产品加工技术标准id
        ByResearchStdMct byResearchStdMct = super.findOne(SqlId.SQLID_GET_PD_MCT_STD, param);
        long standardId = byResearchStdMct.getStandardId();
        param.getFilterMap().put("standardId", standardId);

        // 查询买家产品加工技术标准是否有数据
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_MCT, param);
        if (count > NumberConst.IntDef.INT_ZERO){
            // 查询买家产品加工技术标准
            return super.findList(SqlId.SQLID_GET_BY_RESEARCH_MCT, param);
        }else {
            // 查询产品的加工技术标准
            return super.findList(SqlId.SQLID_GET_PD_MCT, param);
        }
    }


    /**
     * 产品加工技术标准更新
     *
     * @param byResearchStdMct byResearchStdMct
     * @return
     */
    @Transactional
    public int updateBuyerMct(ByResearchStdMct byResearchStdMct) {
        logger.debug("产品加工技术标准更新");

        byResearchStdMct.setUpdTime(DateTimeUtil.getCustomerDate());
        byResearchStdMct.setDelFlg(SystemConst.DelFlg.ENABLE);
        byResearchStdMct.setVer(NumberConst.IntDef.INT_ONE);
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyerId", byResearchStdMct.getBuyerId());
        param.getFilterMap().put("standardId", byResearchStdMct.getStandardId());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_MCT, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            super.save(byResearchStdMct);
        }
        return super.modify(byResearchStdMct);
    }
}
