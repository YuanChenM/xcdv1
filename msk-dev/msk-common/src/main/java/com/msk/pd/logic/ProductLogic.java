package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.bean.SlCodeNatureBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ProductLogic
 *
 * @author jiang_nan
 * @version 1.0
 **/
@Service
public class ProductLogic extends BaseLogic {
    /**
     * SqlId.
     *
     * @author gyh
     */
    interface SqlId {
        String SQL_ID_FIND_PD_CLASSES = "findPdClasses";
        String SQL_ID_FIND_PD_MACHINING = "findPdMachining";
        String SQL_ID_FIND_PD_MACHINING_BY_INCODE = "findPdMachiningByInCode";
        String SQL_ID_FIND_PD_BREED = "findPdBreed";
        String SQL_ID_FIND_PD_FEATURE = "findPdFeature";
        String SQL_ID_FIND_PD_WEIGHT = "findPdWeight";
        String SQL_ID_FIND_PD_NORMSSTD = "findPdNormsStd";
        String SQL_ID_FIND_PD_GRADE = "findGrade";
        String SQL_ID_FIND_PD_COUNTRY = "findPdCountry";
        String SQL_ID_FIND_PD_STANDARD = "findPdStandard";
    }

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ProductLogic.class);

    /**
     * 拆分产品编码
     *
     * @param pdCode pdCode
     * @return 产品信息
     * @author gyh
     */
    public ProductBean getProductInfo(String pdCode) {
        logger.debug("产品代码拆分 {}", pdCode);
        /** 产品类别Code(1-2) */
        String classesCode = pdCode.substring(NumberConst.IntDef.INT_ZERO, NumberConst.IntDef.INT_TWO);
        /** 产品二级分类Code(2-3) */
        String machiningCode = pdCode.substring(NumberConst.IntDef.INT_TWO, NumberConst.IntDef.INT_THREE);
        /** 产品品种Code(3-5) */
        String breedCode = pdCode.substring(NumberConst.IntDef.INT_THREE, NumberConst.IntDef.INT_FIVE);
        /** 产品特征Code(5-7) */
        String featureCode = pdCode.substring(NumberConst.IntDef.INT_FIVE, NumberConst.IntDef.INT_SEVEN);
        /** 产品净重Code(7-9) */
        String weightCode = pdCode.substring(NumberConst.IntDef.INT_SEVEN, NumberConst.IntDef.INT_NINE);
        /** 产品等级Code(9-10) */
        String gradeCode = pdCode.substring(NumberConst.IntDef.INT_NINE, NumberConst.IntDef.INT_TEN);
        BaseParam param = new BaseParam();
        param.setFilter("classesCode", classesCode);
        param.setFilter("machiningCode", machiningCode);
        param.setFilter("breedCode", breedCode);
        param.setFilter("featureCode", featureCode);
        param.setFilter("weightCode", weightCode);
//        param.setFilter("countryCode", countryCode);
        param.setFilter("gradeCode", gradeCode);
        ProductBean productBean = new ProductBean();
        List<PdClasses> pdClasses = this.findPdClasses(param);
        List<PdMachining> pdMachinings = this.findPdMachining(param);
        List<PdBreed> pdBreeds = this.findPdBreed(param);
        List<PdFeature> pdFeatures = this.findPdFeature(param);
        List<PdWeight> pdWeights = this.findPdWeight(param);
//        List<PdCountry> pdCountries = this.findPdCountry(param);
        List<PdGrade> pdGrades = this.findPdGrade(param);
        if (!CollectionUtils.isEmpty(pdClasses) && pdClasses.size() > 0) {
            productBean.setPdClasses(pdClasses.get(0));
        }
        if (!CollectionUtils.isEmpty(pdMachinings) && pdMachinings.size() > 0) {
            productBean.setPdMachining(pdMachinings.get(0));
        }
        if (!CollectionUtils.isEmpty(pdBreeds) && pdBreeds.size() > 0) {
            productBean.setPdBreed(pdBreeds.get(0));
        }
        if (!CollectionUtils.isEmpty(pdFeatures) && pdFeatures.size() > 0) {
            productBean.setPdFeature(pdFeatures.get(0));
        }
        if (!CollectionUtils.isEmpty(pdWeights) && pdWeights.size() > 0) {
            productBean.setPdWeight(pdWeights.get(0));
        }
        if (!CollectionUtils.isEmpty(pdGrades) && pdGrades.size() > 0) {
            productBean.setPdGrade(pdGrades.get(0));
        }
//        if (!CollectionUtils.isEmpty(pdCountries) && pdCountries.size() > 0) {
//            productBean.setPdCountry(pdCountries.get(0));
//        }
        return productBean;
    }

    /**
     * 查询产品类别信息
     *
     * @param param 参数：类别编码
     * @return 类别
     * @author gyh
     */
    public List<PdClasses> findPdClasses(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_CLASSES, param);
    }

    /**
     * 查询产品二级分类信息
     *
     * @param param 参数：类别编码，二级分类编码
     * @return 产品二级分类
     * @author gyh
     */
    public List<PdMachining> findPdMachining(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_MACHINING, param);
    }

    /**
     * 查询产品二级分类信息
     * @param param
     * @return
     */
    public List<PdMachining> findPdMacByInCode(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_MACHINING_BY_INCODE, param);
    }

    /**
     * 查询产品品种信息
     *
     * @param param 参数
     * @return 品种
     * @author gyh
     */
    public List<PdBreed> findPdBreed(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_BREED, param);
    }

    /**
     * 查询产品净重信息
     *
     * @param param 参数
     * @return 净重
     * @author gyh
     */
    public List<PdWeight> findPdWeight(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_WEIGHT, param);
    }

    /**
     * 查询产品特征信息
     *
     * @param param 参数
     * @return 特征
     * @author gyh
     */
    public List<PdFeature> findPdFeature(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_FEATURE, param);
    }

    /**
     * 查询产品规格信息
     *
     * @param param 参数
     * @return 规格
     * @author gyh
     */
    public List<PdNormsStd> findPdNormsStd(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_NORMSSTD, param);
    }

    /**
     * 查询产品标准信息
     *
     * @param param 参数
     * @return 标准
     * @author gyh
     */
    public List<PdStandard> findPdStandard(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_STANDARD, param);
    }

    /**
     * 查询产品等级信息
     *
     * @param param 参数
     * @return 类别
     * @author gyh
     */
    public List<PdGrade> findPdGrade(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_GRADE, param);
    }

    /**
     * 查询产品国籍信息
     *
     * @param param 参数
     * @return 国籍
     * @author gyh
     */
    public List<PdCountry> findPdCountry(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_PD_COUNTRY, param);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 组装卖家属性码
     *
     * @return 属性码
     * @author gyh
     */

    public String getSlCodeNature(SlCodeNatureBean slCodeNatureBean) {
        String slCodeDis = slCodeNatureBean.getSlCodeDis();
        String slCodeNature = "";
        //自产型与代理型：主分类+品牌类型+卖家地区码+卖家地区顺序码+生产商地区码++生产商地区顺序码+生产商品牌码
        if(!StringUtil.isNullOrEmpty(slCodeNatureBean.getSlCodeDis())&&!StringUtil.isNullOrEmpty(slCodeNatureBean.getSlCodeManufacture())){
            if ("1".equals(slCodeNatureBean.getSlMainClass()) || "2".equals(slCodeNatureBean.getSlMainClass())) {
                slCodeNature = slCodeNatureBean.getSlMainClass() + slCodeNatureBean.getBrandClass() + slCodeDis.substring(1) + slCodeNatureBean.getSlCodeManufacture() + slCodeNatureBean.getBrandId();
            } else if ("3".equals(slCodeNatureBean.getSlMainClass())) {
                //OEM型：主分类+品牌类型+卖家地区码+卖家地区顺序码+生产商品牌码+生产商地区码+生产商地区顺序码
                slCodeNature = slCodeNatureBean.getSlMainClass() + slCodeNatureBean.getBrandClass() + slCodeDis.substring(1) + slCodeNatureBean.getBrandId()+ slCodeNatureBean.getSlCodeManufacture();
            }
        }
        return slCodeNature;
    }
}
