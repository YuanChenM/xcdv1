package com.msk.by.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchStdMct;
import com.msk.core.entity.ByResearchStdTnc;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 买家产品加工质量标准调研用Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121214Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121214Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    public interface SqlId {
        static final String SQLID_GET_PD_TNC_STD = "getPdTncStd";
        static final String SQLID_COUNT_BY_RESEARCH_TNC= "countResearchTnc";
        static final String SQLID_GET_PD_TNC = "getPdTnc";
        static final String SQLID_GET_BY_RESEARCH_TNC = "getResearchTnc";
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
     * 买家产品加工质量标准查询
     * 
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByResearchStdTnc> findBuyerTncList(BaseParam param) {
        logger.debug("买家产品加工质量标准查询");

        // 查询产品加工质量标准id
        ByResearchStdTnc byResearchStdTnc = super.findOne(SqlId.SQLID_GET_PD_TNC_STD, param);
        long standardId = byResearchStdTnc.getStandardId();
        param.getFilterMap().put("standardId", standardId);

        // 查询买家产品加工质量标准是否有数据
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_TNC, param);
        if (count > NumberConst.IntDef.INT_ZERO){
            // 查询买家产品加工质量标准
            return super.findList(SqlId.SQLID_GET_BY_RESEARCH_TNC, param);
        }else {
            // 查询产品的加工质量标准
            return super.findList(SqlId.SQLID_GET_PD_TNC, param);
        }
    }

    /**
     * 产品加工质量标准更新
     *
     * @param byResearchStdTnc byResearchStdTnc
     * @return
     */
    @Transactional
    public int updateBuyerTnc(ByResearchStdTnc byResearchStdTnc) {
        logger.debug("产品加工质量标准更新");

        byResearchStdTnc.setUpdTime(DateTimeUtil.getCustomerDate());
        byResearchStdTnc.setDelFlg(SystemConst.DelFlg.ENABLE);
        byResearchStdTnc.setVer(NumberConst.IntDef.INT_ONE);
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyerId", byResearchStdTnc.getBuyerId());
        param.getFilterMap().put("standardId", byResearchStdTnc.getStandardId());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_TNC, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            super.save(byResearchStdTnc);
        }
        return super.modify(byResearchStdTnc);
    }
}
