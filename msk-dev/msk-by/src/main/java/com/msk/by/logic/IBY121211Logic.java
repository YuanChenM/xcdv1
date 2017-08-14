package com.msk.by.logic;

import com.msk.by.bean.IBY121211RsParam;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.SystemConst;
import com.msk.core.entity.ByResearchCatDetail;
import com.msk.core.entity.ByResearchCategory;
import com.msk.core.entity.PdBreed;
import com.msk.core.entity.PdClassestreeMat;
import com.msk.core.utils.DateTimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * IBY121211Logic.
 *
 * @author zhou_ling
 */
@Service
public class IBY121211Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121211Logic.class);

    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_ling
     */
    interface SqlId {

        // 买家产品品类和需求调研明细查询
        static  String SQLID_GET_BY_CAT_DETAIL = "getByCatDetail";
        //查询买家产品品类和需求调研明细是否有数据
        static final String SQLID_COUNT_BY_CAT_DETAIL= "countByCatDetail";
        //插入买家产品品类和需求调研
        static final String SQLID_INSERT_BY_RESEARCH_CATEGORY= "insertByResearchCategory";
        //查询买家产品品类和需求调研是否有数据
        static final String SQLID_COUNT_BY_RESEARCH_CATEGORY= "countByResearchCategory";
        // 查询产品pd_classestree_mat
        static  String SQLID_GET_PD_CLASSESTREE_MAT = "getPdClassesMat";
        // 查询产品pd_breed
        static  String SQLID_GET_PD_BREED = "getPdBreed";
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
     * 买家产品品类和需求调研明细查询
     *
     * @param baseParam baseParam
     * @return
     * @author zhou_ling
     */

    public List<ByResearchCatDetail> findBuyerCatDetailList(BaseParam baseParam){

        return super.findList(SqlId.SQLID_GET_BY_CAT_DETAIL, baseParam);
    }


    /**
     * 买家产品品类和需求调研明细更新
     *
     * @param param param
     * @return
     */
    @Transactional
    public int updateBuyerCatDetail(IBY121211RsParam param) {
        logger.debug("买家产品品类和需求调研明细更新");
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        param.setDelFlg(SystemConst.DelFlg.ENABLE);
        param.setVer(NumberConst.IntDef.INT_ONE);

        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("detailId", param.getDetailId());
        baseParam.getFilterMap().put("buyerId", param.getBuyerId());
        baseParam.getFilterMap().put("classesCode", param.getClassesCode());
        baseParam.getFilterMap().put("machiningCode", param.getMachiningCode());
        baseParam.getFilterMap().put("breedCode", param.getBreedCode());
        baseParam.getFilterMap().put("saleName", param.getSaleName());
        int count = super.getCount(SqlId.SQLID_COUNT_BY_CAT_DETAIL, baseParam);
        ByResearchCategory byResearchCategory = super.findOne(SqlId.SQLID_COUNT_BY_RESEARCH_CATEGORY, baseParam);
        int updateCount = 0;
        if(byResearchCategory == null){
            // 插入买家产品品类和需求调研表
            Long categoryId = commonLogic.maxId("by_research_category", "CATEGORY_ID");
            param.setCategoryId(categoryId);
            baseParam.getFilterMap().put("classesTreeCode",param.getClassesCode() + param.getMachiningCode());
            // 查询产品pd_classestree_mat表
            PdClassestreeMat pdClassestreeMat = super.findOne(SqlId.SQLID_GET_PD_CLASSESTREE_MAT, baseParam);
            // 查询产品pd_breed表
            PdBreed pdBreed = super.findOne(SqlId.SQLID_GET_PD_BREED, baseParam);
            if(pdClassestreeMat != null){
                param.setScientificName(pdClassestreeMat.getScientificName());
                param.setSaleName(pdClassestreeMat.getSalesName());
                param.setPopularName(pdClassestreeMat.getLocalName());
            } else {
                if (pdBreed != null) {
                    param.setSaleName(pdBreed.getBreedName());
                }
            }
            // 插入家产品品类和需求调研表
            super.save(SqlId.SQLID_INSERT_BY_RESEARCH_CATEGORY, param);
            // 插入买家产品品类和需求调研详细表
            Long detailId = commonLogic.maxId("By_Research_Cat_Detail", "DETAIL_ID");
            param.setDetailId(detailId);
            updateCount = super.save(param);
        } else {
            param.setCategoryId(byResearchCategory.getCategoryId());
            if (count == NumberConst.IntDef.INT_ZERO){
                // 插入买家产品品类和需求调研明细表
                Long detailId = commonLogic.maxId("By_Research_Cat_Detail", "DETAIL_ID");
                param.setDetailId(detailId);
                updateCount = super.save(param);
            } else {
                // 更新买家产品品类和需求调研明细表
                updateCount = super.modify(param);
            }
        }
        return updateCount;
    }
}
