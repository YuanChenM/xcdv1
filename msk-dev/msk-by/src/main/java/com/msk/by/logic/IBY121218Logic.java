package com.msk.by.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchStdSft;
import com.msk.core.entity.ByResearchStdTsp;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 买家产品品种储存运输标准调研用Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121218Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121218Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    public interface SqlId {
        static final String SQLID_GET_PD_TSP_STD = "getPdTspStd";
        static final String SQLID_COUNT_BY_RESEARCH_TSP= "countResearchTsp";
        static final String SQLID_GET_BY_RESEARCH_TSP = "getResearchTsp";
        static final String SQLID_GET_PD_TSP= "getPdTsp";
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
     * 买家产品品种储存运输标准调研查询
     * 
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByResearchStdTsp> findBuyerTspList(BaseParam param) {
        logger.debug("买家产品品种储存运输标准调研查询");

        // 查询产品品种安全标准id
        ByResearchStdTsp byResearchStdTsp = super.findOne(SqlId.SQLID_GET_PD_TSP_STD, param);
        long standardId = byResearchStdTsp.getStandardId();
        param.getFilterMap().put("standardId", standardId);

        // 买家产品品种储存运输标准是否有数据
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_TSP, param);
        if (count > NumberConst.IntDef.INT_ZERO){
            // 查询产品品种储存运输标准
            return super.findList(SqlId.SQLID_GET_BY_RESEARCH_TSP, param);
        }else {
            // 查询产品品种储存运输标准
            return super.findList(SqlId.SQLID_GET_PD_TSP, param);
        }
    }

    /**
     * 买家产品品种储存运输标准更新
     *
     * @param byResearchStdTsp byResearchStdTsp
     * @return
     */
    @Transactional
    public int updateBuyerTsp(ByResearchStdTsp byResearchStdTsp) {
        logger.debug("买家产品品种储存运输标准更新");

        byResearchStdTsp.setUpdTime(DateTimeUtil.getCustomerDate());
        byResearchStdTsp.setDelFlg(SystemConst.DelFlg.ENABLE);
        byResearchStdTsp.setVer(NumberConst.IntDef.INT_ONE);
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyerId", byResearchStdTsp.getBuyerId());
        param.getFilterMap().put("standardId", byResearchStdTsp.getStandardId());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_TSP, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            super.save(byResearchStdTsp);
        }
        return super.modify(byResearchStdTsp);
    }
}
