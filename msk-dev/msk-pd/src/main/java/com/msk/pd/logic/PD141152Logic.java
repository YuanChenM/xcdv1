package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.pd.bean.PD141124showNameBean;
import com.msk.pd.bean.PD141151Param;
import com.msk.pd.bean.PD141152Param;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fjm on 2016/3/3.
 */
@Service
public class PD141152Logic extends BaseLogic{


    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    interface SqlId {
        static final String SQL_ID_FIND_LIST_PD_MCT_LEVEL2_STD_SHOW = "findStdItemLevel2ListShow";
        static final  String SQL_ID_FIND_ONE_SFT_BEAN = "findOneSftStd";
        static final  String SQL_ID_FIND_List_SFT_NUMBER = "findListSize";
        static final String SQL_ID_FIND_BREED_NAME_FEANAME = "findName";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }


    /**
     * 查询单个stfstd对象 存在
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public PD141152Param findOneSftStd(BaseParam param) {
        return super.findOne(SqlId.SQL_ID_FIND_ONE_SFT_BEAN,param);
    }


    /**
     * 使用标准id查询数据是否为空
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public int getCountNum(BaseParam param) {
        return super.getCount(SqlId.SQL_ID_FIND_List_SFT_NUMBER,param);
    }

    /**
     * 实例化页面二级类目显示   存在
     * @param param
     * @return
     */

    public List<PD141152Param> findListLevel2(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_LIST_PD_MCT_LEVEL2_STD_SHOW,param);
    }

    /**
     * 获取产品品种数据
     *
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<PD141124showNameBean> findBreedNameAndFea(BaseParam param) {
        return this.findList(SqlId.SQL_ID_FIND_BREED_NAME_FEANAME, param);
    }

    /**
     * 保存修改数据 xhy
     * @param bean
     * @param param
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void saveAndEdit(PD141152Param bean, BaseParam param) {
        if (StringUtils.isNotBlank(bean.getStandardId().toString())) {
            param.setFilter("standardId", bean.getStandardId().toString());
            int exit = super.getCount(SqlId.SQL_ID_FIND_List_SFT_NUMBER, param);
            if (exit <= NumberConst.IntDef.INT_ZERO) {
                //新增操作
                if (bean.getTspItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < bean.getTspItemIdArray().length; i++) {
                        PD141152Param pd = new PD141152Param();
                        pd.setTspOkVal(bean.getTspOkValArray()[i]);
                        pd.setTspNgVal(bean.getTspNgValArray()[i]);
                        pd.setTspStdItemId(bean.getTspItemIdArray()[i]);
                        pd.setStandardId(bean.getStandardId());
                        pd.setUpdId(param.getUpdId());
                        pd.setCrtId(param.getCrtId());
                        super.save(pd);
                    }
                }
            } else {
                //修改操作
                if (bean.getTspItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < bean.getTspItemIdArray().length; i++) {
                        PD141152Param pd = new PD141152Param();
                        pd.setTspOkVal(bean.getTspOkValArray()[i]);
                        pd.setTspNgVal(bean.getTspNgValArray()[i]);
                        pd.setTspStdItemId(bean.getTspItemIdArray()[i]);
                        pd.setStandardId(bean.getStandardId());
                        pd.setUpdId(param.getUpdId());
                        super.modify(pd);
                    }
                }
            }

        }
    }
}
