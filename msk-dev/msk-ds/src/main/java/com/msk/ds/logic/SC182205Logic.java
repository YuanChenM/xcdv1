package com.msk.ds.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.ds.bean.SC182205Bean;
import com.msk.ds.bean.SC182205Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * SC182203Logic.
 *
 * @author yi_qixiang
 * @version 1.0
 **/
@Service
public class SC182205Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(SC182205Logic.class);
    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    private interface SqlId {
        String SQL_ID_FIND_MONTH = "findMonth";
        String SQL_GET_CLASSES = "getClasses";  // 实际
        String SQL_GET_BREED = "getBreed";  // 实际
        String SQL_GET_MACHINING = "getMachining";  // 实际
        String SQL_GET_FEATURE = "getFeature";  // 实际
        String SQL_GET_WEIGHT = "getWeight";  // 实际
        String SQL_GET_GRADE = "getGrade";  // 实际
        String SQL_GET_DS_PRODUCT_LOT = "getDsProductLot";  // 实际

    }
    /**
     * 根据供应商Code获得月度
     * @param supCode 供应商编码
     * @return 月度信息
     */
    @Transactional
    public List<String> findMonth(String supCode){
        BaseParam param = new BaseParam();
        param.setFilter("supCode",supCode);
        return super.getBaseDao().getSqlSession().selectList(SqlId.SQL_ID_FIND_MONTH);
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }



    /**
     * 根据条形主码查找打印明细记录
     *
     * @return suppName
     */
    @Transactional
    public SC182205Bean getDsProductLot(SC182205Param sc182205Param) {
//
//        BaseParam baseParam = new BaseParam();
//        baseParam.getFilterMap().put("slAccount", sc182203Param.getSlAccount());
        List<SC182205Bean> dsProductLotList = new ArrayList<SC182205Bean>();
        dsProductLotList = this.findList(SqlId.SQL_GET_DS_PRODUCT_LOT, sc182205Param);
        if(dsProductLotList.size()>0){
            return dsProductLotList.get(0);
        }else{
            return null;
        }

    }


    /**
     * 根据产品类别代码查找类别名称
     *
     * @return suppName
     */
    @Transactional
    public String getClassesName(String classesCode) {

        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setClassesCode(classesCode);
        List<SC182205Bean> classesList = new ArrayList<SC182205Bean>();
        classesList = this.findList(SqlId.SQL_GET_CLASSES, sc182205Param);
        if(classesList.size()>0){
            return (classesList.get(0)).getClassesName();
        }else{
            return null;
        }
    }


    /**
     * 根据产品品种类别代码查找品种名称
     *
     * @return suppName
     */
    @Transactional
    public String getBreedName(String breedCode) {

        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setBreedCode(breedCode);
        List<SC182205Bean> breedList = new ArrayList<SC182205Bean>();
        breedList = this.findList(SqlId.SQL_GET_BREED, sc182205Param);
        if(breedList.size()>0){
            return (breedList.get(0)).getBreedName();
        }else{
            return null;
        }
    }

    /**
     * 根据产品配料代码查找配料名称
     *
     * @return suppName
     */
    @Transactional
    public String getMachiningName(String machiningCode) {

        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setMachiningCode(machiningCode);
        List<SC182205Bean> machiningList = new ArrayList<SC182205Bean>();
        machiningList = this.findList(SqlId.SQL_GET_MACHINING, sc182205Param);
        if(machiningList.size()>0){
            return (machiningList.get(0)).getMachiningName();
        }else{
            return null;
        }
    }


    /**
     * 根据产品配料代码查找配料名称
     *
     * @return suppName
     */
    @Transactional
    public String getFeatureName(String featureCode) {

        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setFeatureCode(featureCode);
        List<SC182205Bean> featureList = new ArrayList<SC182205Bean>();
        featureList = this.findList(SqlId.SQL_GET_FEATURE, sc182205Param);
        if(featureList.size()>0){
            return (featureList.get(0)).getFeatureName();
        }else{
            return null;
        }
    }


    /**
     * 根据产品净重代码找净重名称
     *
     * @return suppName
     */
    @Transactional
    public String getWeightName(String weightCode) {

        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setWeightCode(weightCode);
        List<SC182205Bean> weightList = new ArrayList<SC182205Bean>();
        weightList = this.findList(SqlId.SQL_GET_WEIGHT, sc182205Param);
        if(weightList.size()>0){
            return (weightList.get(0)).getWeightName();
        }else{
            return null;
        }
    }


    /**
     * 根据产品净重代码找净重名称
     *
     * @return suppName
     */
    @Transactional
    public String getGradeName(String gradeCode) {

        SC182205Param sc182205Param = new SC182205Param();
        sc182205Param.setGradeCode(gradeCode);
        List<SC182205Bean> gradeList = new ArrayList<SC182205Bean>();
        gradeList = this.findList(SqlId.SQL_GET_GRADE, sc182205Param);
        if(gradeList.size()>0){
            return (gradeList.get(0)).getGradeName();
        }else{
            return null;
        }
    }



    /**
     * 保存标签数据表
     *
     * @return result
     */
    @Transactional
    public void saveProductPrintNum(SC182205Param param) {

            if(super.save(param)!= NumberConst.IntDef.INT_ONE){
                throw new BusinessException("保存失败，请和管理员联系");
            }

    }

}
