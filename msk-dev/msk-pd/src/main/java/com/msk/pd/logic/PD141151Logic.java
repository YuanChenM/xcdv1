package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.PD141124showNameBean;
import com.msk.pd.bean.PD141151Param;
import com.msk.pd.bean.PD141151ParentBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2016/3/1.
 */
@Service
public class PD141151Logic extends BaseLogic {




    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    interface SqlId {
        static final String SQL_ID_FIND_LIST_PD_MCT_STD = "findMctStdItemList";
        static final String SQL_ID_FIND_LIST_PD_MCT_LEVEL2_STD = "findMctStdItemLevel2List";
        static final String SQL_ID_FIND_LIST_PD_MCT_LEVEL2_STD_SHOW = "findStdItemLevel2ListShow";
        static final String SQL_ID_FIND_ONE_SFT_BEAN = "findOneSftStd";
        static final String SQL_ID_FIND_List_SFT_NUMBER = "findListSize";
        static final String SQL_ID_FIND_BREED_NAME_FEANAME = "findName";


        static final String SQL_ID_MODIFY_STD_FLG = "modifyFlg";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询一级类别 没有
     *
     * @param param
     * @return List
     */
    public List<PD141151ParentBean> findListPdMctItemStd(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_LIST_PD_MCT_STD, param);
    }

    /**
     * 查询二级类目
     * @param param
     * @return
     */
    public List<PD141151Param> findListStdSft(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_LIST_PD_MCT_LEVEL2_STD,param);
    }



    /**
     * 实例化页面二级类目显示   存在
     * @param param
     * @return
     */

    public List<PD141151Param> findListLevel2(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_LIST_PD_MCT_LEVEL2_STD_SHOW,param);
    }

    /**
     * 查询单个stfstd对象 存在
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public PD141151Param findOneSftStd(BaseParam param) {
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
     * 数据保存修改 xhy
     * @param bean
     * @param param
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void saveAndEdit(PD141151Param bean, BaseParam param) {
        if (StringUtils.isNotBlank(bean.getStandardId().toString())) {
            param.setFilter("standardId", bean.getStandardId().toString());
            int exit = super.getCount(SqlId.SQL_ID_FIND_List_SFT_NUMBER,param);
            if (exit <= NumberConst.IntDef.INT_ZERO) {
                //新增操作
                if (bean.getSftItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < bean.getSftItemIdArray().length; i++) {
                        PD141151Param pd = new PD141151Param();
                        pd.setSftOkVal(bean.getSftOkValArray()[i]);
                        pd.setSftNgVal(bean.getSftNgValArray()[i]);
                        pd.setSftStdItemId(bean.getSftItemIdArray()[i]);
                        pd.setStandardId(bean.getStandardId());
                        pd.setUpdId(param.getUpdId());
                        pd.setCrtId(param.getCrtId());
                        super.save(pd);
                    }
                }
               /* param.setFilter("flg", String.valueOf(NumberConst.IntDef.INT_ONE));
                int exist =    super.modify(SqlId.SQL_ID_MODIFY_STD_FLG,param);
                if(exist<= NumberConst.IntDef.INT_ZERO)throw new BusinessException("更新产品通用质量标准标识异常,请联系管理员!");*/
            } else {
                //修改操作
                if (bean.getSftItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < bean.getSftItemIdArray().length; i++) {
                        PD141151Param pd = new PD141151Param();
                        pd.setSftOkVal(bean.getSftOkValArray()[i]);
                        pd.setSftNgVal(bean.getSftNgValArray()[i]);
                        pd.setSftStdItemId(bean.getSftItemIdArray()[i]);
                        pd.setStandardId(bean.getStandardId());
                        pd.setUpdId(param.getUpdId());
                        super.modify(pd);
                    }
                }
            }

        }
    }
}
