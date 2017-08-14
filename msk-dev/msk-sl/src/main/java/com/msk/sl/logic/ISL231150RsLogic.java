package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlEpBrand;
import com.msk.core.entity.SlPdBrand;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL231153RsParam;
import com.msk.sl.bean.ISL231153RsResult;
import com.msk.sl.bean.ISlPdBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cx on 2016/2/19.
 */
@Service
public class ISL231150RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 增加卖家产品品牌接口
     * @param islPdBrand
     * @return
     */
    public int saveSLPdBrand(ISlPdBrand islPdBrand){
        return super.save(islPdBrand);
    }

    /**
     * 查询是否存在SlEpBrand
     * @param baseParam
     * @return
     */
    public SlEpBrand findSlEpBrandYesOrON(BaseParam baseParam){
        return super.findOne(baseParam);
    }

    /**
     * 修改卖家产品品牌接口
     * @param slPdBrand
     * @return
     */
    public int updateSlPdBrand(SlPdBrand slPdBrand){
        return super.modify(slPdBrand);
    }

    /**
     * 删除卖家产品品牌接口
     * @param slPdBrand
     * @return
     */
    public int removeSLPdBrandc(SlPdBrand slPdBrand){
        return super.remove(slPdBrand);
    }


    /**
     * 查询卖家产品品牌
     * @param param
     * @return
     */
    public ISL231153RsResult findSLPdBrandcAllList(RsRequest<ISL231153RsParam> param){
        BaseParam baseParam = new  BaseParam();
        baseParam.setFilter("slCode", StringUtil.toSafeString(param.getParam().getSlCode()));
        baseParam.setFilter("brandEpId",StringUtil.toSafeString(param.getParam().getBrandEpId()));
        baseParam.setFilter("brandId",StringUtil.toSafeString(param.getParam().getBrandId()));
        List<SlPdBrand> list = new ArrayList<SlPdBrand>();
        ISL231153RsResult iSL231153RsResult = new ISL231153RsResult();
        list = super.findList(baseParam);
        iSL231153RsResult.setSlPdBrandList(list);
        return iSL231153RsResult;
    }
}
