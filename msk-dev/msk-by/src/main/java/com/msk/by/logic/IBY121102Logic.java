package com.msk.by.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.*;
import com.msk.pd.logic.ProductLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * IBY121102Logic.
 *
 * @author zhou_yajun
 */
@Service
public class IBY121102Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBY121102Logic.class);

    /**
     * SQL Map 中SQL ID定义
     *
     * @author zhou_yajun
     */
    interface SqlId {
        //获取产品类别
        static String SQL_FIND_PD_CLASSES = "findPdClasses";
    }

    @Autowired
    private ProductLogic productLogic;
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
     * 获取产品类别
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdClasses> pdClass(PdClasses param){
        BaseParam inParam = new BaseParam();
        List<PdClasses> pdClassesList = productLogic.findPdClasses(inParam);
        return pdClassesList;
    }
    /**
     * 获取产品二级分类信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdMachining> pdMachining(PdMachining param){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("classesCode",param.getClassesCode());
        List<PdMachining> pdMachiningList = productLogic.findPdMachining(inParam);
        return pdMachiningList;
    }
    /**
     * 获取产品品种信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdBreed> pdBreed(PdBreed param){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("classesCode",param.getClassesCode());
        inParam.setFilter("machiningCode",param.getMachiningCode());
        List<PdBreed> pdBreedList = productLogic.findPdBreed(inParam);
        return pdBreedList;
    }
    /**
     * 获取产品特征信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdFeature> pdFeature(PdFeature param){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("classesCode",param.getClassesCode());
        inParam.setFilter("machiningCode",param.getMachiningCode());
        inParam.setFilter("breedCode",param.getBreedCode());
        List<PdFeature> pdFeatureList = productLogic.findPdFeature(inParam);
        return pdFeatureList;
    }
    /**
     * 获取产品规格信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdNormsStd> pdNormsStd(PdWeight param){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("classesCode",param.getClassesCode());
        inParam.setFilter("machiningCode",param.getMachiningCode());
        inParam.setFilter("breedCode",param.getBreedCode());
        inParam.setFilter("featureCode",param.getFeatureCode());
        inParam.setFilter("weightCode",param.getWeightCode());
        List<PdNormsStd> pdNormsStdList = productLogic.findPdNormsStd(inParam);
        return pdNormsStdList;
    }
    /**
     * 获取产品净重信息
     *
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdWeight> pdWeight(PdWeight param){
        BaseParam inParam = new BaseParam();
        inParam.setFilter("classesCode",param.getClassesCode());
        inParam.setFilter("machiningCode",param.getMachiningCode());
        inParam.setFilter("breedCode",param.getBreedCode());
        inParam.setFilter("featureCode",param.getFeatureCode());
        List<PdWeight> pdWeightList = productLogic.findPdWeight(inParam);
        return pdWeightList;
    }
}
