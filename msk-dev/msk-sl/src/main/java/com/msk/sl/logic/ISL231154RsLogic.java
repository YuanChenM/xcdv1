package com.msk.sl.logic;

import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlEpBrand;
import com.msk.core.entity.SlEpBrandHonor;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL231155RsParam;
import com.msk.sl.bean.ISL231157RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cx on 2016/2/23.
 */
@Service
public class ISL231154RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    /**
     * 查询传过来的epId ,brandId 是否存在sl_ep_brand中
     *
     * @param baseParam
     * @return
     */
    public SlEpBrand findSlEpBrand(BaseParam baseParam) {
        return super.findOne(baseParam);
    }

    /**
     * 增加企业产品品牌荣誉
     *
     * @param slEpBrandHonor
     * @return
     */
    public int saveSLEpBrandHonor(SlEpBrandHonor slEpBrandHonor) {
        return super.save(slEpBrandHonor);
    }

    /**
     * 修改企业产品品牌荣誉
     *
     * @param slEpBrandHonor
     * @return
     */
    public int updateSlEpBrandHonor(SlEpBrandHonor slEpBrandHonor) {
        return super.modify(slEpBrandHonor);
    }

    /**
     * 删除企业产品品牌荣誉
     * @param param
     * @return
     */
    public int removeSLEpBrandHonor(RsRequest<ISL231155RsParam> param) {
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("epId", StringUtil.toSafeString(param.getParam().getEpId()));
        baseParam.setFilter("brandId", StringUtil.toSafeString(param.getParam().getBrandId()));
        baseParam.setFilter("honorId", StringUtil.toSafeString(param.getParam().getHonorId()));
        return super.remove(baseParam);
    }

    /**
     * 查询企业产品品牌荣誉
     * @param param
     * @return
     */
    public ISL231157RsResult findSLEpBrandHonorAllList(RsRequest<ISL231155RsParam> param){
        ISL231157RsResult iSL231157RsResult = new ISL231157RsResult();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("epId",StringUtil.toSafeString(param.getParam().getEpId()));
        baseParam.setFilter("brandId",StringUtil.toSafeString(param.getParam().getBrandId()));
        baseParam.setFilter("honorId",StringUtil.toSafeString(param.getParam().getHonorId()));
        List<SlEpBrandHonor> list = new ArrayList<SlEpBrandHonor>();
        list = super.findList(baseParam);
        iSL231157RsResult.setSlEpBrandHonorList(list);
        return iSL231157RsResult;
    }
}
