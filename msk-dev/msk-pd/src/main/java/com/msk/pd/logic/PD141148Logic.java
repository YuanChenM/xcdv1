package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdMctStd;
import com.msk.core.entity.PdMctStdDiscussProvider;
import com.msk.core.entity.PdMctStdItem;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.PD141124showNameBean;
import com.msk.pd.bean.PD141148Bean;
import com.msk.pd.bean.PD141148MctProBean;
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
public class PD141148Logic extends BaseLogic {




    /**
     * SQL Map 中SQL ID定义
     *
     * @author pxg
     */
    interface SqlId {
        static final String SQL_ID_FIND_LIST_PD_MCT_STD = "findMctStdItemList";
        static final String SQL_ID_FIND_LIST_PD_MCT_PRO = "findMctProList";
        static final String SQL_ID_FIND_BREED_NAME_FEANAME = "findName";
        static final String SQL_ID_MODIFY_STD_MCT_FLG = "modifyStdMctFlg";
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询所有加工技术标准
     *
     * @param param
     * @return List
     */
    @Transactional(readOnly = true)
    public List<PdMctStdItem> findListPdMctItemStd(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_LIST_PD_MCT_STD, param);
    }

    /**
     * 查询所有产品质量技术
     * @param param
     * @return
     */
    @Transactional(readOnly = true)
    public List<PD141148MctProBean> findListMctPro(BaseParam param) {
        return super.findList(SqlId.SQL_ID_FIND_LIST_PD_MCT_PRO,param);
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
     * 保存修改数据
      * @param bean xhy
     * @param param
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void saveAndEdit(PD141148Bean bean, BaseParam param) {
        if (StringUtils.isNotBlank(bean.getStandardId().toString())) {
            param.setFilter("standardId", bean.getStandardId().toString());
            List<PD141148Bean> list = super.findList(param);
            if (list.size() <= NumberConst.IntDef.INT_ZERO) {
                //新增操作
                if (bean.getMctStdItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < bean.getMctStdItemIdArray().length; i++) {
                        PdMctStd pd = new PdMctStd();
                        pd.setMctOkVal(bean.getMctOkValArray()[i]);
                        pd.setMctNgVal(bean.getMctNgValArray()[i]);
                        pd.setMctStdItemId(bean.getMctStdItemIdArray()[i]);
                        pd.setStandardId(bean.getStandardId());
                        pd.setCrtId(param.getCrtId());
                        pd.setUpdId(param.getUpdId());
                       super.save(pd);
                    }
                }
              /*  //新增结束改变standard表中的产品标准饲养标识
                param.setFilter("flg", String.valueOf(NumberConst.IntDef.INT_ONE));
                int upStd =super.modify(SqlId.SQL_ID_MODIFY_STD_MCT_FLG, param);
                if(upStd<= NumberConst.IntDef.INT_ZERO)throw new BusinessException("更新产品加工技术标准标识异常,请联系管理员!");*/
            } else {
                //修改操作
                if (bean.getMctStdItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = NumberConst.IntDef.INT_ZERO; i < bean.getMctStdItemIdArray().length; i++) {
                        PdMctStd pd = new PdMctStd();
                        pd.setMctOkVal(bean.getMctOkValArray()[i]);
                        pd.setMctNgVal(bean.getMctNgValArray()[i]);
                        pd.setMctStdItemId(bean.getMctStdItemIdArray()[i]);
                        pd.setStandardId(bean.getStandardId());
                        pd.setUpdId(param.getUpdId());
                        super.modify(pd);
                    }
                }
            }

        }
    }
}
