package com.msk.by.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchStdNor;
import com.msk.core.entity.ByResearchStdNor;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 买家产品品种包装标准调研用Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121219Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121219Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_Ling
     */
    public interface SqlId {
        static final String SQLID_COUNT_BY_RESEARCH_NOR= "countResearchNor";
        static final String SQLID_GET_BY_RESEARCH_NOR = "getResearchNor";
        static final String SQLID_GET_PD_NOR = "getPdNor";
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
     * 买家产品品种包装标准调研查询
     * 
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<ByResearchStdNor> findBuyerNorList(BaseParam param) {
        logger.debug("买家产品品种包装标准调研查询");
        // 买家产品品种包装标准是否有数据
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_NOR, param);
        if (count > NumberConst.IntDef.INT_ZERO){
            // 查询产品品种包装标准
            return super.findList(SqlId.SQLID_GET_BY_RESEARCH_NOR, param);
        }else {
            // 查询产品品种包装标准
            return super.findList(SqlId.SQLID_GET_PD_NOR, param);
        }
    }

    /**
     * 买家产品品种包装标准更新
     *
     * @param byResearchStdNor byResearchStdNor
     * @return
     */
    @Transactional
    public int updateBuyerNor(ByResearchStdNor byResearchStdNor) {
        logger.debug("买家产品品种包装标准更新");
        Long id = commonLogic.maxId("by_research_std_nor","ID");
        byResearchStdNor.setId(id);
        byResearchStdNor.setUpdTime(DateTimeUtil.getCustomerDate());
        byResearchStdNor.setDelFlg(SystemConst.DelFlg.ENABLE);
        byResearchStdNor.setVer(NumberConst.IntDef.INT_ONE);
        BaseParam param = new BaseParam();
        param.getFilterMap().put("buyerId", byResearchStdNor.getBuyerId());
        param.getFilterMap().put("standardId", byResearchStdNor.getStandardId());
        param.getFilterMap().put("normsCode", byResearchStdNor.getNormsCode());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_RESEARCH_NOR, param);
        if (count == NumberConst.IntDef.INT_ZERO){
            super.save(byResearchStdNor);
        }
        return super.modify(byResearchStdNor);
    }
}
