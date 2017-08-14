package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdClassestree;
import com.msk.core.entity.PdNormsStd;
import com.msk.core.entity.PdStandard;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.PD141103Param;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 六级类别操作
 * PD14112405Logic
 *
 * @author xhy
 */
@Service
public class PD14112405Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;

    /**
     * c
     * SQL Map 中SQL ID定义
     *
     * @author xhy
     */
    interface SqlId {
        /* 产品净重新增*/
        static final String SQL_ID_FIND_STD_CODE = "findStandIdByClassestreeCode";//根据classestreeCode查询standId是否存在
        static final String SQL_ID_FIND_NORMS_MAXID = "findNormsMaxId";
        static final String SQL_ID_SAVE_TREE = "saveTree";
        static final String SQL_ID_FIND_TREE_EXIST = "findClassesTreeExist";

        //删除操作
        static final String SQL_ID_REMOVE_PD_NORMS = "removePdNorms";

        //修改编码查询操作
        static final String SQL_ID_FIND_LIST_EXIST_NORMS = "findListExistNorms";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 五级类别保存操作 产品净重新增
     *
     * @param bean
     * @return
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int saveClassesTree(PD141103Param bean, BaseParam param) {

        //如果当前传递过来的id为空,为自动增长,不为空为指定增长
        param.setFilter("classesCode", bean.getClassestreeCode1());
        param.setFilter("machiningCode", bean.getClassestreeCode2());
        param.setFilter("breedCode", bean.getClassestreeCode3());
        param.setFilter("weightCode", bean.getClassestreeCode5());
        //根据传递参数判断数据是否已存在
        if (StringUtils.isNotBlank(bean.getNormsCode())) {
            param.setFilter("normsCode", bean.getNormsCode());
            int exists = this.getCount(SqlId.SQL_ID_FIND_LIST_EXIST_NORMS, param);
            if(exists>NumberConst.IntDef.INT_ZERO)  return NumberConst.IntDef.INT_TWO;
        } else {
            param.setFilter("normsOut", bean.getNormsOut());
            int exists = this.getCount(SqlId.SQL_ID_FIND_LIST_EXIST_NORMS, param);
            if (exists > NumberConst.IntDef.INT_ZERO) return NumberConst.IntDef.INT_TWO; //传递来的包装名称查询到数据已经存在
        }
        //二次查询过滤名称

        String classestreeCode = bean.getClassestreeCode1() + bean.getClassestreeCode2() + bean.getClassestreeCode3() + bean.getClassestreeCode4() + bean.getClassestreeCode5();
        param.setFilter("classestreeCode", classestreeCode);
        PdStandard standard = super.findOne(SqlId.SQL_ID_FIND_STD_CODE, param);
        if (standard == null || standard.getStandardId().toString() == "")
            throw new BusinessException("数据异常,请联系管理员!(standardId没有找到!)");

        //获取最大包装最大id
        param.setFilter("standardId", standard.getStandardId().toString());
        //根据id查询是否存在

        param.setFilter("featureCode", bean.getClassestreeCode4());
        int exists = this.getCount(SqlId.SQL_ID_FIND_LIST_EXIST_NORMS, param);
        if (exists > NumberConst.IntDef.INT_ZERO) return NumberConst.IntDef.INT_TWO; //传递来的包装名称查询到数据已经存在


        PdNormsStd normsStd = super.findOne(SqlId.SQL_ID_FIND_NORMS_MAXID, param);
        Integer normsMaxCode = Integer.parseInt(normsStd.getNormsCode());
        if(StringUtils.isNotBlank(bean.getNormsCode())){
            normsMaxCode=Integer.valueOf(bean.getNormsCode());
        }
        if (normsMaxCode > NumberConst.IntDef.INT_NINETYNINE) {
            throw new BusinessException("产品包装已达到最大限度，请联系管理员！");
        }
        normsStd.setNormsCode(String.format("%02d", normsMaxCode));
        normsStd.setNormsOut(bean.getNormsOut());
        normsStd.setStandardId(standard.getStandardId());
        normsStd.setClassestreeCode(classestreeCode + normsStd.getNormsCode());
        normsStd.setUpdId(param.getUpdId());
        normsStd.setCrtId(param.getCrtId());


        //保存数据到tree表中 tree表中是否存在该条数据
        param.setFilter("classestreeCode", classestreeCode + normsStd.getNormsCode());
        int existTree = super.getCount(SqlId.SQL_ID_FIND_TREE_EXIST, param);
        if (existTree > NumberConst.IntDef.INT_ZERO) throw new BusinessException("产品分类已经存在，请联系管理员！");

          /*获取产品分类目录中最大id*/
        Long maxIdTree = commonLogic.maxId("PD_CLASSESTREE", "CLASSESTREE_ID");
        if (maxIdTree > NumberConst.IntDef.INT_NINE_NINE_NINE_FOR_SQL_IN_LIMIT)
            new BusinessException("产品分类目录已达到最大类别，请联系管理员！");
        PdClassestree treeBean = new PdClassestree();
        treeBean.setClassestreeId(maxIdTree);
        treeBean.setClassestreeCode(classestreeCode + normsStd.getNormsCode());
        treeBean.setLevelCode(normsStd.getNormsCode());
        treeBean.setLevelName(bean.getNormsOut());
        treeBean.setParentCode(classestreeCode);
        treeBean.setParentName(bean.getClassestreeName5());
        treeBean.setTreeLevel(NumberConst.IntDef.INT_SIX);
        treeBean.setUpdId(param.getUpdId());
        treeBean.setCrtId(param.getCrtId());

        super.save(normsStd);
        return super.save(SqlId.SQL_ID_SAVE_TREE, treeBean);
    }


    /**
     * 六级类别删除操作 同时删除3张表中数据
     *
     * @param bean
     * @return
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int removeNorms(PD141103Param bean) {
        BaseParam param = new BaseParam();
        param.setFilter("classestreeCode", bean.getClassestreeCode1() +
                bean.getClassestreeCode2() +
                bean.getClassestreeCode3() +
                bean.getClassestreeCode4() +
                bean.getClassestreeCode5() +
                bean.getClassestreeCode6());
        //删除操作 norms表中数据
        int removePdNorms = super.remove(SqlId.SQL_ID_REMOVE_PD_NORMS, param);//删除产品分类表中数据
        if (removePdNorms <= NumberConst.IntDef.INT_ZERO) return removePdNorms;
        int removeOk = super.remove(param);//删除classestree表中数据
        return removeOk;
    }
}
