package com.msk.by.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchStdSft;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 买家产品品种安全标准调研用Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121217Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121217Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    public interface SqlId {
        static final String SQLID_GET_PD_SFT_STD = "getPdSftStd";
        static final String SQLID_COUNT_BY_RESEARCH_SFT= "countResearchSft";
        static final String SQLID_GET_BY_RESEARCH_SFT = "getResearchSft";
        static final String SQLID_GET_PD_SFT = "getPdSft";
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
     * 买家产品品种安全标准调研查询
     * 
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByResearchStdSft> findBuyerSftList(BaseParam param) {
        logger.debug("买家产品品种安全标准调研查询");

        // 查询产品品种安全标准id
        ByResearchStdSft byResearchStdSft = super.findOne(SqlId.SQLID_GET_PD_SFT_STD, param);
        long standardId = byResearchStdSft.getStandardId();
        param.getFilterMap().put("standardId", standardId);

        // 买家产品品种安全标准是否有数据
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_SFT, param);
        if (count > NumberConst.IntDef.INT_ZERO){
            // 查询产品品种安全标准
            return super.findList(SqlId.SQLID_GET_BY_RESEARCH_SFT, param);
        }else {
            // 查询产品品种安全标准
            return super.findList(SqlId.SQLID_GET_PD_SFT, param);
        }
    }

    /**
     * 买家产品品种安全标准更新
     *
     * @param byResearchStdSft byResearchStdSft
     * @return
     */
    @Transactional
    public int updateBuyerSft(ByResearchStdSft byResearchStdSft) {
        logger.debug("买家产品品种安全标准更新");

        byResearchStdSft.setUpdTime(DateTimeUtil.getCustomerDate());
        byResearchStdSft.setDelFlg(SystemConst.DelFlg.ENABLE);
        byResearchStdSft.setVer(NumberConst.IntDef.INT_ONE);
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyerId", byResearchStdSft.getBuyerId());
        param.getFilterMap().put("standardId", byResearchStdSft.getStandardId());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_SFT, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            super.save(byResearchStdSft);
        }
        return super.modify(byResearchStdSft);
    }
}
