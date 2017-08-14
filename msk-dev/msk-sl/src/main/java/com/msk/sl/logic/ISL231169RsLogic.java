package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.entity.SlProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cx on 2016/2/24.
 */
@Service
public class ISL231169RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        static final String SQL_ID_REMOVE_SL_PD_PKG = "removeSlPdPkg";

        static final String SQL_ID_REMOVE_SL_PD_MCT_STD_NEW = "removeSLPdMctStdNew";

        static final String SQL_ID_REMOVE_PD_TNC_STD_OTHER = "removePdTncStdOther";

        static final String SQL_ID_REMOVE_SL_PD_TNC_STD_NEW = "removeSLPdTncStdNew";
    }


    /**
     * 增加卖家产品接口
     * @param slProduct
     * @return
     */
    public int savaSLProduct(SlProduct slProduct) {
        return super.save(slProduct);
    }

    /**
     * 修改卖家产品接口
     * @param slProduct
     * @return
     */
    public int updateSlProduct(SlProduct slProduct){
        return super.modify(slProduct);
    }

    /**
     *删除卖家产品
     * @param baseParam
     * @return
     */
    public int removeSLProduct(BaseParam baseParam){
       /* BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slCode", StringUtil.toSafeString(slProduct.getSlCode()));
        baseParam.setFilter("slPdId", StringUtil.toSafeString(slProduct.getSlPdId()));
        baseParam.setFilter("prodEpId", StringUtil.toSafeString(slProduct.getProdEpId()));
        baseParam.setFilter("brandEpId", StringUtil.toSafeString(slProduct.getBrandEpId()));
        baseParam.setFilter("brandId", StringUtil.toSafeString(slProduct.getBrandId()));
        baseParam.setFilter("pdClassesCode", StringUtil.toSafeString(slProduct.getPdClassesCode()));
        baseParam.setFilter("pdBreedCode", StringUtil.toSafeString(slProduct.getPdBreedCode()));
        baseParam.setFilter("pdFeatureCode", StringUtil.toSafeString(slProduct.getPdFeatureCode()));*/
        return super.remove(baseParam);
    }
    /**
     *删除卖家产品包装规格
     * @param baseParam
     * @return
     */
    public int removeSlPdPkg(BaseParam baseParam){
        return super.remove(SqlId.SQL_ID_REMOVE_SL_PD_PKG,baseParam);
    }

    /**
     *删除卖家产品加工技术标准
     * @param baseParam
     * @return
     */
    public int removeSLPdMctStdNew(BaseParam baseParam){
        return super.remove(SqlId.SQL_ID_REMOVE_SL_PD_MCT_STD_NEW,baseParam);
    }

    /**
     *删除卖家产品其他标准
     * @param baseParam
     * @return
     */
    public int removeSLPdTncStdOther(BaseParam baseParam){
        return super.remove(SqlId.SQL_ID_REMOVE_PD_TNC_STD_OTHER,baseParam);
    }

    /**
     *删除卖家产品加工质量标准
     * @param baseParam
     * @return
     */
    public int removeSLPdTncStdNew(BaseParam baseParam){
        return super.remove(SqlId.SQL_ID_REMOVE_SL_PD_TNC_STD_NEW,baseParam);
    }
}







