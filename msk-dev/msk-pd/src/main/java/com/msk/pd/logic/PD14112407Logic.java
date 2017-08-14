package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.consts.NumberConst;
import com.msk.pd.bean.PD141103Param;
import com.msk.core.bean.BaseParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 六级类别操作
 * PD14112407Logic
 *
 * @author yangchunyan
 */
@Service
public class PD14112407Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;
    /** Add: Bug #2429 : 新产品系统无法新增产品二级分类三级分类等数据   20160905   BY  杨春艳  Start */
    @Autowired
    private PD141124Logic pd141124Logic;
    /** Add: Bug #2429 : 新产品系统无法新增产品二级分类三级分类等数据   20160905   BY  杨春艳  eND */
    @Autowired
    private PD14112401Logic pd14112401Logic;
    @Autowired
    private PD14112402Logic pd14112402Logic;
    @Autowired
    private PD14112403Logic pd14112403Logic;
    @Autowired
    private PD14112404Logic pd14112404Logic;
    @Autowired
    private PD14112405Logic pd14112405Logic;

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 保存产品品种信息  breed
     *
     * @param bean  参数
     * @return 页面
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int saveBreed(PD141103Param bean,BaseParam param) {
        //添加操作 同时添加machining表数据
        int saveClassesTree = NumberConst.IntDef.INT_ZERO;
        if (StringUtils.isBlank(bean.getClassestreeCode2())) {
            pd14112401Logic.saveClassesTree(bean,param);
            saveClassesTree = this.pd14112402Logic.saveClassesTree(bean, param);
        }else{
            saveClassesTree = this.pd14112402Logic.saveClassesTree(bean,param);
        }
        return saveClassesTree;
    }

    /**
     * 保存产品特征信息  feature
     *
     * @param bean  参数
     * @return 页面
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int saveFeature(PD141103Param bean,BaseParam param) {
        //添加操作 同时添加machining表数据
        int saveClassesTree = NumberConst.IntDef.INT_ZERO;
        String machiningCode = bean.getClassestreeCode2();
        String breedCode = bean.getClassestreeCode3();
        if (StringUtils.isBlank(bean.getClassestreeCode2()) && StringUtils.isNoneEmpty(bean.getClassestreeName2())) {
            this.pd14112401Logic.saveClassesTree(bean,param);
        }
        if (StringUtils.isBlank(machiningCode) || StringUtils.isBlank(breedCode) || StringUtils.isBlank(bean.getClassestreeCode3()) && StringUtils.isNoneEmpty(bean.getClassestreeName3())) {
            pd14112402Logic.saveClassesTree(bean,param);
            saveClassesTree = this.pd14112403Logic.saveClassesTree(bean,param);
        }else{
            saveClassesTree = this.pd14112403Logic.saveClassesTree(bean,param);
        }
        return saveClassesTree;
    }

    /**
     * 保存产品净重信息  weight
     *
     * @param bean  参数
     * @return 页面
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int saveWeight(PD141103Param bean,BaseParam param) {
        //添加操作 同时添加machining表数据
        int saveClassesTree = NumberConst.IntDef.INT_ZERO;
        String machiningCode = bean.getClassestreeCode2();
        String breedCode = bean.getClassestreeCode3();
        String featureCode = bean.getClassestreeCode4();
        if (StringUtils.isBlank(bean.getClassestreeCode2()) && StringUtils.isNoneEmpty(bean.getClassestreeName2())) {
            this.pd14112401Logic.saveClassesTree(bean,param);
        }
        if (StringUtils.isBlank(machiningCode) || StringUtils.isBlank(breedCode) || StringUtils.isBlank(bean.getClassestreeCode3()) && StringUtils.isNoneEmpty(bean.getClassestreeName3())) {
            pd14112402Logic.saveClassesTree(bean,param);
        }
        if(StringUtils.isBlank(machiningCode) || StringUtils.isBlank(breedCode) || StringUtils.isBlank(featureCode) || StringUtils.isBlank(bean.getClassestreeCode4()) && StringUtils.isNoneEmpty(bean.getClassestreeName4())) {
            pd14112403Logic.saveClassesTree(bean,param);
            saveClassesTree = this.pd14112404Logic.saveClassesTree(bean,param);
        }
        else{
            saveClassesTree = this.pd14112404Logic.saveClassesTree(bean,param);
        }
        return saveClassesTree;
    }

    /**
     * 保存产品包装信息  norms
     *
     * @param bean  参数
     * @return 页面
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public int saveNorms(PD141103Param bean,BaseParam param) {
        //添加操作 同时添加machining表数据
        int saveClassesTree = NumberConst.IntDef.INT_ZERO;
        String machiningCode = bean.getClassestreeCode2();
        String breedCode = bean.getClassestreeCode3();
        String featureCode = bean.getClassestreeCode4();
        String weightCode = bean.getClassestreeCode5();
        if (StringUtils.isBlank(bean.getClassestreeCode2()) && StringUtils.isNoneEmpty(bean.getClassestreeName2())) {
            this.pd14112401Logic.saveClassesTree(bean,param);
        }
        if (StringUtils.isBlank(machiningCode) || (StringUtils.isBlank(breedCode) && StringUtils.isNoneEmpty(bean.getClassestreeName3()))) {
            pd14112402Logic.saveClassesTree(bean,param);
        }
        if(StringUtils.isBlank(machiningCode) || StringUtils.isBlank(breedCode) || StringUtils.isBlank(bean.getClassestreeCode4()) && StringUtils.isNoneEmpty(bean.getClassestreeName4())) {
            pd14112403Logic.saveClassesTree(bean,param);
        }
        if(StringUtils.isBlank(machiningCode) || StringUtils.isBlank(breedCode) || StringUtils.isBlank(featureCode) || StringUtils.isBlank(weightCode) && StringUtils.isNoneEmpty(bean.getClassestreeName5())) {
            pd14112404Logic.saveClassesTree(bean,param);
            saveClassesTree = this.pd14112405Logic.saveClassesTree(bean,param);
        }
        else{
            saveClassesTree = this.pd14112405Logic.saveClassesTree(bean,param);
        }
        return saveClassesTree;
    }
}
