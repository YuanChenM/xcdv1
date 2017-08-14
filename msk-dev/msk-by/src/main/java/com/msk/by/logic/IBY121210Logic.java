package com.msk.by.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * IBY121210Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121210Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121210Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_ling
     */
    interface SqlId {
        // 判断产品品种是否存在
        static  String SQL_JUDGE_RESEARCH_CATEGORY = "judgeResearchCategory";
        // 判断产品品种是否已经被调研
        static  String SQL_JUDGE_RESEARCH = "judgeResearch";
        //插入产品品种
        static String SQL_INSERT_RESEARCH_CATEGORY = "insertResearchCategory";
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
     * 买家产品品种类型是否存在
     *
     * @param byResearchCategory
     * @return
     * @author zhou_ling
     */

    public boolean researchCategoryJudge(ByResearchCategory byResearchCategory){
        BaseParam inParam = new BaseParam();
        String classTreeCode = byResearchCategory.getClassesCode() + byResearchCategory.getMachiningCode();
        inParam.setFilter("classestreeCode", classTreeCode);
        inParam.setFilter("salesName", byResearchCategory.getSaleName());
        inParam.setFilter("scientificName", byResearchCategory.getScientificName());
        inParam.setFilter("localName",byResearchCategory.getPopularName());
        inParam.setFilter("delFlg","0");
        PdClassestreeMat pdClassestreeMat = super.findOne(SqlId.SQL_JUDGE_RESEARCH_CATEGORY,inParam);
        boolean judeFlag = true;
        if(null == pdClassestreeMat){
            judeFlag = false;
        }
        return judeFlag;
    }

    /**
     * 买家产品品种类型是否被调研
     *
     * @param byResearchCategory
     * @return
     * @author zhou_ling
     */

    public boolean researchJudge(ByResearchCategory byResearchCategory){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("buyerId", byResearchCategory.getBuyerId());
        inParam.setFilter("classesCode", byResearchCategory.getClassesCode());
        inParam.setFilter("machiningCode", byResearchCategory.getMachiningCode());
        inParam.setFilter("saleName", byResearchCategory.getSaleName());
        inParam.setFilter("scientificName", byResearchCategory.getScientificName());
        inParam.setFilter("popularName",byResearchCategory.getPopularName());
        inParam.setFilter("delFlg","0");
        ByResearchCategory result = new ByResearchCategory();
        result = super.findOne(SqlId.SQL_JUDGE_RESEARCH,inParam);
        boolean judeFlag = true;
        if(null == result){
            judeFlag = false;
        }
        return judeFlag;
    }

    /**
     * 买家产品品类调研表插入
     * @param insertParam
     * @return
     * @author zhou_ling
     */
    @Transactional
    public void researchCategorySave(ByResearchCategory insertParam){
        Long id = commonLogic.maxId("by_research_category","CATEGORY_ID");
        insertParam.setCategoryId(id);
        insertParam.setCrtId(insertParam.getUpdId());
        insertParam.setCrtTime(DateTimeUtil.getCustomerDate());
        insertParam.setUpdTime(DateTimeUtil.getCustomerDate());
        insertParam.setActId(insertParam.getUpdId());
        insertParam.setActTime(DateTimeUtil.getCustomerDate());
        insertParam.setUpdTime(DateTimeUtil.getCustomerDate());
        super.save(SqlId.SQL_INSERT_RESEARCH_CATEGORY,insertParam);
    }

}
