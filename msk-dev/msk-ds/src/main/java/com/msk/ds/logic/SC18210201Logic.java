package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.pd.bean.ProductBean;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * SC18210201Logic
 *
 * @author yang_yang
 * @version 1.0
 **/
@Service
public class SC18210201Logic extends ProductLogic {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC18210201Logic.class);

    @Autowired
    private ProductLogic productLogic;

    /**
     * 拆分产品编码
     *
     * @param pdCode pdCode
     * @return 产品信息
     * @author gyh
     */
    @Override
    public ProductBean getProductInfo(String pdCode) {
        logger.debug("产品代码拆分");
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
        param.setFilter("gradeCode", gradeCode);
        ProductBean productBean = new ProductBean();
        List<PdClasses> pdClasses = productLogic.findPdClasses(param);
        List<PdMachining> pdMachinings = productLogic.findPdMachining(param);
        List<PdBreed> pdBreeds = productLogic.findPdBreed(param);
        List<PdFeature> pdFeatures = productLogic.findPdFeature(param);
        List<PdWeight> pdWeights = productLogic.findPdWeight(param);
        List<PdGrade> pdGrades = productLogic.findPdGrade(param);
        List<PdNormsStd> pdNormsStds = productLogic.findPdNormsStd(param);

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
        if (!CollectionUtils.isEmpty(pdNormsStds) && pdNormsStds.size() > 0) {
            productBean.setPdNormsStd(pdNormsStds.get(0));
        }
        return productBean;
    }

}
