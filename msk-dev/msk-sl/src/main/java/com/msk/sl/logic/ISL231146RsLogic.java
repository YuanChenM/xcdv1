package com.msk.sl.logic;

import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.entity.SlEpBrand;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.ISL231149RsParam;
import com.msk.sl.bean.ISL231149RsResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cx on 2016/2/19.
 */
@Service
public class ISL231146RsLogic extends BaseLogic {

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    interface SqlId {
        static final String SQL_ID_FIND_SL_EPBRANDC_ALL = "findSLEpBrandcAll";
        static final String SQL_ID_FIND_SL_EP_BRAND = "findSlEpBrand";
    }

    /**
     * 增加企业产品品牌
     *
     * @param slEpBrand
     * @return
     */
    public int saveSLEpBrandc(SlEpBrand slEpBrand) {
        return super.save(slEpBrand);
    }

    /**
     * 更新企业产品品牌
     *
     * @param slEpBrand
     * @return
     */
    public int updateSlEpBrand(SlEpBrand slEpBrand) {
        return super.modify(slEpBrand);
    }

    public List<SlEpBrand> findSLEpBrandcYesOrOn(BaseParam baseParam) {
        return super.findList(baseParam);
    }

    /**
     * 删除企业产品品牌
     *
     * @param slEpBrand
     * @return
     */
    public int removeSLEpBrandc(SlEpBrand slEpBrand) {
        return super.remove(slEpBrand);
    }

    /**
     * 查询企业产品品牌
     *
     * @param param
     * @return
     */
    public ISL231149RsResult findSLEpBrandcAllList(RsRequest<ISL231149RsParam> param) {
        BaseParam baseParam = new BaseParam();
        ISL231149RsResult iSL231149RsResult = new ISL231149RsResult();
        baseParam.setFilter("epId", StringUtil.toSafeString(param.getParam().getEpId()));
        baseParam.setFilter("brandId", StringUtil.toSafeString(param.getParam().getBrandId()));
        List<SlEpBrand> list=this.findAll(StringUtil.toSafeString(param.getParam().getEpId()), StringUtil.toSafeString(param.getParam().getBrandId()));
        if(!CollectionUtils.isEmpty(list) && list.size()>0){
            for(int i = 0; i < list.size(); i++){
                SlEpBrand slEpBrand = list.get(i);
                if(null!=param.getParam().getEpId()){
                    slEpBrand.setEpId(Long.parseLong(param.getParam().getEpId()));
                }
                String brandId = param.getParam().getBrandId();
                if (null == brandId || "".equals(brandId)) {
                    slEpBrand.setBrandId(slEpBrand.getBrandId());
                }else {
                    if(null!=param.getParam().getEpId()){
                        slEpBrand.setEpId(Long.parseLong(param.getParam().getBrandId()));
                    }
                }
            }
            iSL231149RsResult.setSlEpBrandList(list);
        }
        return iSL231149RsResult;
    }

    /**
     * 查询SlEpBrand是否存在
     * @param baseParam
     * @return
     */
    public int findSlEpBrand(BaseParam baseParam){
        return super.getCount(SqlId.SQL_ID_FIND_SL_EP_BRAND,baseParam);
    }


    //查询企业id
    public SlEnterprise findEpId(BaseParam baseParam){
        return super.findOne(baseParam);
    }


    //查询企业SlEpBrand
    public List<SlEpBrand> findAll(String epId,String brandId){
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("epId", epId);
        baseParam.setFilter("brandId",brandId);
        List<SlEpBrand> list = super.findList(SqlId.SQL_ID_FIND_SL_EPBRANDC_ALL,baseParam);
        return list;
    }
}
