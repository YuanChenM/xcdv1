package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.PageResult;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.*;
import com.msk.core.utils.DateTimeUtil;
import com.msk.pd.bean.PD144104Bean;
import com.msk.pd.bean.PD144104Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 新增楼层产品
 * Created by ren_qiang on 2016/10/28.
 */
public class PD144105Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * sqlName
     */
    interface SqlId {
        static final String SQL_ID_FIND_ONE_CLASS = "findClassesCode"; //获取一级分类
        static final String SQL_ID_FIND_TWO_CLASS = "findMachingCode"; //获取二级分类
        static final String SQL_ID_FIND_BREED = "findBreed"; //获取品种
        static final String SQL_ID_FIND_FEATURE = "findFeature"; //获取产品特征
        static final String SQL_ID_FIND_WEIGHT = "findWeight"; //获取产品净重
        static final String SQL_ID_FIND_GRADE = "findGrade"; //获取产品净重
        static final String SQL_ID_SAVE_FLOOR_DETAIL = "saveFloorDetail";//保存楼层产品信息

    }

    @Transactional(readOnly = true)
    public PageResult<PD144104Bean> queryPdInfo(PD144104Param param){

        PageResult<PD144104Bean> pageResult = new PageResult<PD144104Bean>();
        pageResult = this.findPage(param,PD144104Bean.class);
        if(pageResult != null && !CollectionUtils.isEmpty(pageResult.getData())){
            return pageResult;
        }
        else {
            pageResult.setRecordsTotal(NumberConst.IntDef.INT_ZERO);
            pageResult.setData(new ArrayList<PD144104Bean>());
        }
        return pageResult;
    }

    /**
     * 获取第一级分类
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdClassestree> queryOneClassify(){
        BaseParam param=new BaseParam();
        param.setFilter("treeLevel","1");
        List<PdClassestree> list=new ArrayList<>();
        list=super.findList(SqlId.SQL_ID_FIND_ONE_CLASS,param);
        return list;
    }
    /**
     * 获取第二级分类
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdMachining> queryTwoClassify(String classesCode){
        BaseParam param=new BaseParam();
        param.setFilter("classesCode",classesCode);
        List<PdMachining> list=new ArrayList<PdMachining>();
        list=super.findList(SqlId.SQL_ID_FIND_TWO_CLASS,param);
        return list;
    }

    /**
     * 获取品种
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdBreed> queryBreed(String classesCode,String machiningCode){
        BaseParam param=new BaseParam();
        param.setFilter("classesCode",classesCode);
        param.setFilter("machiningCode",machiningCode);
        List<PdBreed> list=new ArrayList<PdBreed>();
        list=super.findList(SqlId.SQL_ID_FIND_BREED,param);
        return list;
    }
    /**
     * 获取产品特征
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdFeature> queryFeature(String classesCode,String machiningCode,String breedCode){
        BaseParam param=new BaseParam();
        param.setFilter("classesCode",classesCode);
        param.setFilter("machiningCode",machiningCode);
        param.setFilter("breedCode",breedCode);
        List<PdFeature> list=new ArrayList<PdFeature>();
        list=super.findList(SqlId.SQL_ID_FIND_FEATURE,param);
        return list;
    }

    /**
     * 获取产品净重
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdWeight> queryWeight(String classesCode,String machiningCode,String breedCode,String featureCode){
        BaseParam param=new BaseParam();
        param.setFilter("classesCode",classesCode);
        param.setFilter("machiningCode",machiningCode);
        param.setFilter("breedCode",breedCode);
        param.setFilter("featureCode",featureCode);
        List<PdWeight> list=new ArrayList<PdWeight>();
        list=super.findList(SqlId.SQL_ID_FIND_WEIGHT,param);
        return list;
    } /**
     * 获取等级
     * @return
     */
    @Transactional(readOnly = true)
    public List<PdGrade> queryGrade(){
        BaseParam param=new BaseParam();
        List<PdGrade> list=new ArrayList<PdGrade>();
        list=super.findList(SqlId.SQL_ID_FIND_GRADE,param);
        return list;
    }


    @Transactional
    public int batchSave(Collection<PdAppFloorDetail> beans,PD144104Param param){
        int count = NumberConst.IntDef.INT_ZERO;
        if(org.apache.commons.collections.CollectionUtils.isNotEmpty(beans)){
            for(PdAppFloorDetail bean : beans){
                Date nowDate = DateTimeUtil.getCustomerDate();
                bean.setId(commonLogic.maxId("PD_APP_FLOOR_DETAIL","ID"));
                bean.setCrtId(param.getCrtId());
                bean.setCrtTime(nowDate);
                bean.setUpdId(param.getUpdId());
                bean.setUpdTime(nowDate);
                bean.setActId(param.getActId());
                bean.setActTime(nowDate);
                super.save(SqlId.SQL_ID_SAVE_FLOOR_DETAIL,bean);
                count++;
            }
        }
        return count;
    }
}
