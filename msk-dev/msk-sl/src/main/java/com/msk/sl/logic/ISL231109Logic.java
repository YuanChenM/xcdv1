package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.core.utils.StringUtil;
import com.msk.pd.logic.ProductLogic;
import com.msk.sl.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gyh on 2016/2/29.
 */
@Service
public class ISL231109Logic extends BaseLogic {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ISL231109Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private Sl241116Logic sl241116Logic;
    @Autowired
    private ProductLogic productLogic;
    @Autowired
    private SL241106Logic sL241106Logic;

    /**
     * 查询卖家产品标准信息
     *
     * @param param 参数
     * @return 结果
     */
    public List<ISL231109RsProduct> findSlProductInfo(ISL231109RsParam param) {
        BasePageParam basePageParam = new BasePageParam();
        basePageParam.setPaging(false);
        basePageParam.setFilter("slCode", param.getSlCode());
        basePageParam.setFilter("prodEpId", StringUtil.toSafeString(param.getProdEpId()));
        basePageParam.setFilter("brandEpId", StringUtil.toSafeString(param.getBrandEpId()));
        basePageParam.setFilter("brandId", StringUtil.toSafeString(param.getBrandId()));
        basePageParam.setFilter("pdClassesCode", param.getPdClassesCode());
        basePageParam.setFilter("machiningCode", param.getMachiningCode());
        basePageParam.setFilter("pdBreedCode", param.getPdBreedCode());
        basePageParam.setFilter("pdFeatureCode", param.getPdFeatureCode());
        basePageParam.setFilter("weightCode", param.getWeightCode());
        List<SL241116Bean> sl241116Beans = sl241116Logic.findPageList(basePageParam, SL241116Bean.class);
        List<ISL231109RsProduct> results = new ArrayList<ISL231109RsProduct>();
        if (!CollectionUtils.isEmpty(sl241116Beans) && sl241116Beans.size() > 0) {
            BaseParam baseParam = new BaseParam();
            for (SL241116Bean bean : sl241116Beans) {
                ISL231109RsProduct result = new ISL231109RsProduct();
                result.setPdStatus(bean.getStatus());
                result.setSlCode(bean.getSlCode());
                result.setSlPdId(bean.getSlPdId());
                result.setProdEpId(bean.getProdEpId());
                result.setProdEpName(bean.getProdEpName());
                result.setBrandEpId(bean.getBrandEpId());
                result.setBrandEpName(bean.getBrandEpName());
                result.setBrandId(bean.getBrandId());
                result.setBrandName(bean.getBrandName());
                basePageParam.setFilter("classesCode", bean.getPdClassesCode());
                basePageParam.setFilter("machiningCode", bean.getMachiningCode());
                basePageParam.setFilter("breedCode", bean.getPdBreedCode());
                basePageParam.setFilter("featureCode", bean.getPdFeatureCode());
                basePageParam.setFilter("weightCode", bean.getWeightCode());
                //获取类别中文名
                result.setPdClassesCode(bean.getPdClassesCode());
                result.setPdClassesName(bean.getPdClassesName());
//                List<PdClasses> pdClasses=productLogic.findPdClasses(basePageParam);
//                if(!CollectionUtils.isEmpty(pdClasses)&&pdClasses.size()>0){
//                    result.setPdClassesName(pdClasses.get(0).getClassesName());
//                }
                result.setMachiningCode(bean.getMachiningCode());
                result.setMachiningName(bean.getMachiningName());
                //获取二级分类中文名
//                List<PdMachining> pdMachinings=productLogic.findPdMachining(basePageParam);
//                if(!CollectionUtils.isEmpty(pdMachinings)&&pdMachinings.size()>0){
//                    result.setMachiningName(pdMachinings.get(0).getMachiningName());
//                }
                result.setPdBreedCode(bean.getPdBreedCode());
                result.setPdBreedName(bean.getPdBreedName());
                //获取品种中文名
//                List<PdBreed> pdBreeds=productLogic.findPdBreed(basePageParam);
//                if(!CollectionUtils.isEmpty(pdBreeds)&&pdBreeds.size()>0){
//                    result.setPdBreedName(pdBreeds.get(0).getBreedName());
//                }
                result.setPdFeatureCode(bean.getPdFeatureCode());
                result.setPdFeatureName(bean.getPdFeatureName());
                //获取品种中文名
//                List<PdFeature> pdFeatures=productLogic.findPdFeature(basePageParam);
//                if(!CollectionUtils.isEmpty(pdFeatures)&&pdFeatures.size()>0){
//                    result.setPdFeatureName(pdFeatures.get(0).getFeatureName());
//                }
                result.setWeightCode(bean.getWeightCode());
                result.setWeightName(bean.getWeightName());
                //获取净重中文名
//                List<PdWeight> pdWeights=productLogic.findPdWeight(basePageParam);
//                if(!CollectionUtils.isEmpty(pdWeights)&&pdWeights.size()>0){
//                    result.setWeightName(pdWeights.get(0).getWeightName());
//                    result.setWeightVal(pdWeights.get(0).getWeightVal());
//                }
                result.setDistFlg(bean.getDistFlg());
                result.setDistmskFlg(bean.getDistmskFlg());
                result.setSlQltStd(bean.getSlQltStd());
                result.setSlQltGradeCode(bean.getSlQltGradeCode());
                result.setQltNgReason(bean.getQltNgReason());
                result.setQltAuditStatus(bean.getQltAuditStatus());
                result.setQltAuditor(bean.getQltAuditor());
                result.setQltAuditDate(bean.getQltAuditDate());
                result.setQltMonitorResult(bean.getQltMonitorResult());
                result.setQltMonitorAuditor(bean.getQltMonitorAuditor());
                result.setQltMonitorDate(bean.getQltMonitorDate());
                result.setSlTncStd(bean.getSlTncStd());
                result.setSlTncGradeCode(bean.getSlTncGradeCode());
                result.setTncNgReason(bean.getTncNgReason());
                result.setTncAuditStatus(bean.getTncAuditStatus());
                result.setTncAuditor(bean.getTncAuditor());
                result.setTncAuditDate(bean.getTncAuditDate());
                result.setTncMonitorResult(bean.getTncMonitorResult());
                result.setTncMonitorAuditor(bean.getTncMonitorAuditor());
                result.setTncMonitorDate(bean.getTncMonitorDate());
                result.setVer(bean.getVer());
                baseParam.setFilter("slCode", bean.getSlCode());
                baseParam.setFilter("slPdId", StringUtil.toSafeString(bean.getSlPdId()));
                param.setFilter("classesCode", bean.getPdClassesCode());
                param.setFilter("machiningCode", bean.getMachiningCode());
                param.setFilter("breedCode", bean.getPdBreedCode());
                param.setFilter("featureCode", bean.getPdFeatureCode());
                result.setSlPdTncStdList(this.getTncStd(baseParam));
                result.setSlPdMctStdList(this.getMctStd(baseParam));
                result.setSlPdPkgList(sL241106Logic.findSlPdPkgInfo(baseParam));
                baseParam.getFilterMap().put("stdFlg", 1);
                result.setSlPdOrgStdList(this.getOrgStdInfo(baseParam));
                baseParam.getFilterMap().put("stdFlg", 2);
                result.setSlPdFedStdList(this.getFedStdInfo(baseParam));
                baseParam.getFilterMap().put("stdFlg", 3);
                result.setSlPdGnqStdList(this.getGnqStdInfo(baseParam));
                baseParam.getFilterMap().put("stdFlg", 4);
                result.setSlPdTspStdList(this.getTspStdInfo(baseParam));
                baseParam.getFilterMap().put("stdFlg", 5);
                result.setSlPdSftStdList(this.getSftStdInfo(baseParam));
                results.add(result);
            }
        }
        return results;
    }

    /**
     * 取得产品加工质量标准数据
     *
     * @param param param
     * @return 产品加工质量标准
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241117Bean> getTncStd(BaseParam param) {
        logger.debug("取得卖家产品加工质量标准数据");
        param.setFilter("levelId", "1");
        List<SL241117Bean> sl241117Beans = super.findList(SqlId.SQL_ID_GET_TNC_STD_INFO, param);
        //加工质量标准为1层
        //for (SL241117Bean bean : sl241117Beans) {
        //    if ("0".equals(bean.getIsCatalog())) {
        //        param.setFilter("parentId", bean.getTncStdItemId());
        //        param.setFilter("levelId", "2");
        //        List<SL241117Bean> beans = super.findList(SqlId.SQL_ID_GET_TNC_STD_INFO, param);
        //        bean.setPdTncStds(beans);
        //    }
        //}
        return sl241117Beans;
    }

    /**
     * 取得加工技术标准详细页面数据
     *
     * @param param param
     * @return 加工技术标准数据
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241118Bean> getMctStd(BaseParam param) {
        logger.debug("取得产品加工技术标准数据");
        param.setFilter("levelId", "1");
        List<SL241118Bean> sl241118Beans = super.findList(SqlId.SQL_ID_GET_MCT_STD_INFO, param);
        //加工技术标准为1层
        //for (SL241118Bean bean : sl241118Beans) {
        //    if ("0".equals(bean.getIsCatalog())) {
        //        param.setFilter("parentId",bean.getMctStdItemId());
        //        param.setFilter("levelId", "2");
        //        List<SL241118Bean> beanList = super.findList(SqlId.SQL_ID_GET_MCT_STD_INFO, param);
        //        bean.setPdMctStds(beanList);
        //    }
        //}
        return sl241118Beans;
    }

    /**
     * 取得卖家产品原种种源标准数据
     *
     * @param param param
     * @return 卖家产品原种种源标准
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241122Bean> getOrgStdInfo(BaseParam param) {
        logger.debug("取得卖家产品原种种源标准数据");
        param.setFilter("levelId", "1");
        List<SL241122Bean> sl241122Beans = super.findList(SqlId.SQL_ID_GET_ORG_STD_INFO, param);
        //原种种源标准数据为1层
        //for (SL241122Bean bean : sl241122Beans) {
        //    if ("0".equals(bean.getIsCatalog())) {
        //        param.setFilter("levelId", "2");
        //        List<SL241122Bean> beanList = super.findList(SqlId.SQL_ID_GET_ORG_STD_INFO, param);
        //        bean.setPdOrgStds(beanList);
        //    }
        //}
        return sl241122Beans;
    }

    /**
     * 取得卖家产品饲养标准数据
     *
     * @param param param
     * @return 卖家产品饲养标准
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241123Bean> getFedStdInfo(BaseParam param) {
        logger.debug("取得卖家产品饲养标准数据");
        param.setFilter("levelId", "1");
        List<SL241123Bean> sl241123Beans = super.findList(SqlId.SQL_ID_GET_FED_STD_INFO, param);
        //饲养标准为1层
        //for (SL241123Bean bean : sl241123Beans) {
        //    if ("0".equals(bean.getIsCatalog())) {
        //        param.setFilter("levelId", "2");
        //        List<SL241123Bean> beanList = super.findList(SqlId.SQL_ID_GET_FED_STD_INFO, param);
        //        bean.setPdFedStds(beanList);
        //    }
        //}
        return sl241123Beans;
    }

    /**
     * 取得卖家产品通用质量标准数据
     *
     * @param param param
     * @return 卖家产品通用质量标准
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241124Bean> getGnqStdInfo(BaseParam param) {
        logger.debug("取得卖家产品通用质量标准数据");
        param.setFilter("levelId", "1");
        List<SL241124Bean> sl241124Beans = super.findList(SqlId.SQL_ID_GET_GNQ_STD_INFO, param);
        for (SL241124Bean bean : sl241124Beans) {
            if ("0".equals(bean.getIsCatalog())) {
                param.setFilter("parentId", bean.getGnqStdItemId());
                param.setFilter("levelId", "2");
                List<SL241124Bean> beanList = super.findList(SqlId.SQL_ID_GET_GNQ_STD_INFO, param);
                bean.setPdGnqStds(beanList);
            }
        }
        param.getFilterMap().remove("parentId");
        return sl241124Beans;
    }

    /**
     * 取得卖家产品储存运输标准数据
     *
     * @param param param
     * @return 卖家产品储存运输标准
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241125Bean> getTspStdInfo(BaseParam param) {
        logger.debug("取得卖家产品储存运输标准数据");
        param.setFilter("levelId", "1");
        List<SL241125Bean> sl241125Beans = super.findList(SqlId.SQL_ID_GET_TSP_STD_INFO, param);
        for (SL241125Bean bean : sl241125Beans) {
            if ("0".equals(bean.getIsCatalog())) {
                param.setFilter("parentId", bean.getTspStdItemId());
                param.setFilter("levelId", "2");
                List<SL241125Bean> beanList = super.findList(SqlId.SQL_ID_GET_TSP_STD_INFO, param);
                bean.setPdTspStds(beanList);
            }
        }
        param.getFilterMap().remove("parentId");
        return sl241125Beans;
    }

    /**
     * 取得卖家产品安全标准数据
     *
     * @param param param
     * @return 卖家产品安全标准
     * @author gyh
     */
    @Transactional(readOnly = true)
    public List<SL241126Bean> getSftStdInfo(BaseParam param) {
        logger.debug("取得卖家产品安全标准数据");
        param.setFilter("levelId", "1");
        List<SL241126Bean> sl241126Beans = super.findList(SqlId.SQL_ID_GET_SFT_STD_INFO, param);
        for (SL241126Bean bean : sl241126Beans) {
            if ("0".equals(bean.getIsCatalog())) {
                param.setFilter("parentId", bean.getSftStdItemId());
                param.setFilter("levelId", "2");
                List<SL241126Bean> beanList = super.findList(SqlId.SQL_ID_GET_SFT_STD_INFO, param);
                bean.setPdSftStds(beanList);
            }
        }
        param.getFilterMap().remove("parentId");
        return sl241126Beans;
    }

    /**
     * SQL Map 中SQL ID定义
     *
     * @author gyh
     */
    interface SqlId {
        static final String SQL_ID_GET_MCT_STD_INFO = "getMctStdInfo";
        static final String SQL_ID_GET_TNC_STD_INFO = "getTncStdInfo";
        static final String SQL_ID_GET_ORG_STD_INFO = "getOrgStdInfo";
        static final String SQL_ID_GET_FED_STD_INFO = "getFedStdInfo";
        static final String SQL_ID_GET_GNQ_STD_INFO = "getGnqStdInfo";
        static final String SQL_ID_GET_TSP_STD_INFO = "getTspStdInfo";
        static final String SQL_ID_GET_SFT_STD_INFO = "getSftStdInfo";
    }
}
