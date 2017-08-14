package com.msk.pd.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.PdOrgStdItem;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.PD141124showNameBean;
import com.msk.pd.bean.PD141147Bean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 产品原种饲养标准指标logic
 *
 * @author  zhou_ling
 */
@Service
public class PD141147Logic extends BaseLogic {




    /**
     * SQL Map 中SQL ID定义
     * @author zhou_ling
     */
    interface SqlId {
        static final String SQL_ID_FIND_FIND_PD_FED_STD = "findFedStdList";
        static final String SQL_ID_FIND_BREED_NAME_FEANAME = "findName";
        static final String SQL_ID_MODIFY_STD_FLG = "modifyStdFlg";
    }
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询所有orgstdTime
     * @param param
     * @return
     */
    public List<PD141147Bean> findListPdFedStd(BaseParam param) {
      return   this.findList(SqlId.SQL_ID_FIND_FIND_PD_FED_STD,param);
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
     * @param bean
     * @param param
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public void saveAndEdit(PD141147Bean bean, BaseParam param) {
        if (StringUtils.isNotBlank(bean.getStandardId().toString())) {
            // 判断产品标准是否存在
            param.setFilter("standardId", bean.getStandardId().toString());
            List<PD141147Bean> list = super.findList(param);
            if (list.size() <= NumberConst.IntDef.INT_ZERO) {
                //新增操作
                if (bean.getFedStdItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = 0; i < bean.getFedStdItemIdArray().length; i++) {
                        PD141147Bean saveBean = new PD141147Bean();
                        saveBean.setFedBadVal(bean.getFedBadValArray()[i]);
                        saveBean.setFedGoodVal(bean.getFedGoodValArray()[i]);
                        saveBean.setFedNormalVal(bean.getFedNormalValArray()[i]);
                        saveBean.setFedStdItemId(bean.getFedStdItemIdArray()[i]);
                        saveBean.setStandardId(bean.getStandardId());
                        saveBean.setCrtId(param.getCrtId());
                        saveBean.setUpdId(param.getUpdId());
                        super.save(saveBean);
                    }
                }

                 /* //新增结束改变standard表中的产品标准饲养标识
                param.setFilter("flg", String.valueOf(NumberConst.IntDef.INT_ONE));
                int upStd  = super.modify(SqlId.SQL_ID_MODIFY_STD_FLG,param);
                if(upStd<= NumberConst.IntDef.INT_ZERO)throw new BusinessException("更新产品种源标准标识异常,请联系管理员!");*/
            } else {
                //修改操作
                if (bean.getFedStdItemIdArray().length > NumberConst.IntDef.INT_ZERO) {
                    for (int i = 0; i < bean.getFedStdItemIdArray().length; i++) {
                        PD141147Bean saveBean = new PD141147Bean();
                        saveBean.setFedBadVal(bean.getFedBadValArray()[i]);
                        saveBean.setFedGoodVal(bean.getFedGoodValArray()[i]);
                        saveBean.setFedNormalVal(bean.getFedNormalValArray()[i]);
                        saveBean.setFedStdItemId(bean.getFedStdItemIdArray()[i]);
                        saveBean.setStandardId(bean.getStandardId());
                        saveBean.setUpdId(param.getUpdId());
                        super.modify(saveBean);
                    }
                }
            }

        }
    }
}
