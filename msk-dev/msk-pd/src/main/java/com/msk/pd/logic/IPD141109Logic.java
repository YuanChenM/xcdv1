package com.msk.pd.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.entity.PdStandard;
import com.msk.core.exception.BusinessException;
import com.msk.pd.bean.IPD141109RsParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xhy
 * @version 创建时间：2016年1月13日 下午15:42:29
 *          产品标准包装档案卡添加操作
 */
@Service
public class IPD141109Logic extends BaseLogic {

    @Autowired
    private CommonLogic commonLogic;

    /**
     * SQL Map 中SQL ID定义
     *
     * @author xhy
     */
    interface SqlId {
        static final String SQL_ID_FIND_PD_STANDARD = "findPdStandard"; // 查询商品数据id
        static final String SQL_ID_SAVE_PD_NEW_NORMS = "savePdNormsStd"; // 保存包装参数
    }

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * @param param PdNormsStd
     * @return String 保存的包装编码
     * @author xhy
     */
    @Transactional(readOnly = false,
            propagation = Propagation.REQUIRED,
            rollbackFor = Exception.class)
    public String saveNorms(IPD141109RsParam param) {
        //防止客户端传递主键值.
        param.setNormsCode(null);
        PdStandard pd = this.findPdStanId(param);
        // 判断当前对象是否存在,存在获取产品标准id
        if (pd != null) {
            param.setStandardId(pd.getStandardId());
            // 保存产品包装对象
            Long maxId = this.commonLogic.maxId("PD_NORMS_STD", "NORMS_CODE");
            String maxs = "";
            //数值小于十
            if (maxId < IntDef.INT_TEN) {
                maxs = "00" + maxId.toString();
            } else if (maxId < IntDef.INT_HUNDRED) {
                maxs = "0" + maxId.toString();
            } else if (maxId > IntDef.INT_NINE_NINE_NINE_FOR_SQL_IN_LIMIT) {
                throw new BusinessException("数据条数超过最大限制,请联系管理员!");
            }
            param.setNormsCode(maxs);
            int save = super.save(SqlId.SQL_ID_SAVE_PD_NEW_NORMS, param);
            if (save == IntDef.INT_ONE) {
                return param.getNormsCode();
            }
        }
        return null;
    }

    /**
     * 封装工具类
     *
     * @param param IPD141109RsParam
     * @return PdStandard
     * @author xhy
     */
    @Transactional(readOnly = true)
    private PdStandard findPdStanId(IPD141109RsParam param) {
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("classesCode", param.getClassesCode());
        baseParam.setFilter("breedCode", param.getBreedCode());
        baseParam.setFilter("featureCode", param.getFeatureCode());
        baseParam.setFilter("gradeCode", param.getGradeCode());
        PdStandard pd = super.findOne(SqlId.SQL_ID_FIND_PD_STANDARD, baseParam);
        return pd;
    }

}