package com.msk.by.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchStdGnq;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 买家产品品种通用质量标准调研用Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121216Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121216Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    public interface SqlId {
        static final String SQLID_GET_PD_GNQ_STD = "getPdGnqStd";
        static final String SQLID_COUNT_BY_RESEARCH_GNQ= "countResearchGnq";
        static final String SQLID_GET_BY_RESEARCH_GNQ = "getResearchGnq";
        static final String SQLID_GET_PD_GNQ = "getPdGnq";
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
     * 买家产品品种通用质量标准查询
     * 
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByResearchStdGnq> findBuyerGnqList(BaseParam param) {
        logger.debug("买家产品品种通用质量标准查询");

        // 查询产品加工质量标准id
        ByResearchStdGnq byResearchStdGnq = super.findOne(SqlId.SQLID_GET_PD_GNQ_STD, param);
        long standardId = byResearchStdGnq.getStandardId();
        param.getFilterMap().put("standardId", standardId);

        // 买家产品品种通用质量标准是否有数据
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_GNQ, param);
        if (count > NumberConst.IntDef.INT_ZERO){
            // 查询买家产品品种通用质量标准
            return super.findList(SqlId.SQLID_GET_BY_RESEARCH_GNQ, param);
        }else {
            // 查询产品品种通用质量标准
            return super.findList(SqlId.SQLID_GET_PD_GNQ, param);
        }
    }

    /**
     * 买家产品饲养标准更新
     *
     * @param byResearchStdGnq byResearchStdGnq
     * @return
     */
    @Transactional
    public int updateBuyerGnq(ByResearchStdGnq byResearchStdGnq) {
        logger.debug("买家产品饲养标准更新");

        byResearchStdGnq.setUpdTime(DateTimeUtil.getCustomerDate());
        byResearchStdGnq.setDelFlg(SystemConst.DelFlg.ENABLE);
        byResearchStdGnq.setVer(NumberConst.IntDef.INT_ONE);
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyerId", byResearchStdGnq.getBuyerId());
        param.getFilterMap().put("standardId", byResearchStdGnq.getStandardId());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_GNQ, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            super.save(byResearchStdGnq);
        }
        return super.modify(byResearchStdGnq);
    }
}
