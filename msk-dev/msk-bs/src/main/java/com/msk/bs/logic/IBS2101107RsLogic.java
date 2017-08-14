package com.msk.bs.logic;

import com.msk.bs.bean.IBS2101103RsParam;
import com.msk.bs.bean.IBS2101107Bean;
import com.msk.bs.bean.IBS2101107RsParam;
import com.msk.bs.bean.IBS2101107RsResult;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsPageParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.BaseEntity;
import com.msk.core.entity.ByBuyerPdCla;
import com.msk.core.entity.ByBuyerSalestarget;
import com.msk.core.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/3/18.
 */
@Service
public class IBS2101107RsLogic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private BS2101103Logic bS2101103Logic;

    /**
     * 查询买手冻品管家的买家信息
     *
     * @param param
     * @return
     */
    public IBS2101107RsResult findSlExclusive(RsRequest<IBS2101107RsParam> param) {
        IBS2101107RsParam iBS2101107RsParam = param.getParam();
        IBS2101107RsResult iBS2101107RsResult = new IBS2101107RsResult();
        BaseParam params = new BaseParam();
        params.setFilter("slCode", StringUtil.toSafeString(iBS2101107RsParam.getSlCode()));
        params.setFilter("buyerId", StringUtil.toSafeString(iBS2101107RsParam.getBuyerId()));
        List<IBS2101107Bean> slBsBuyerList = super.findList(params);
        for (IBS2101107Bean slBsBuyer : slBsBuyerList) {
            slBsBuyer.setBuyerFlag(param.getParam().getBuyerFlag());
        }
        iBS2101107RsResult.setSlBuyerList(slBsBuyerList);
        return iBS2101107RsResult;
    }


    @Override
    public <T extends BaseEntity> List<T> findPageList(RsPageParam param, RsPageResult pageResult) {
        IBS2101107RsParam iBS2101107RsParam = (IBS2101107RsParam) param;
        if (param.getPageCount() == 0 || param.getPageNo() == 0) {
            param.setPaging(false);
        } else {
            param.setPaging(true);
        }
        param.setFilter("slCode", iBS2101107RsParam.getSlCode());
        param.setFilter("buyerId", iBS2101107RsParam.getBuyerId());
        param.setFilter("buyerFlag", iBS2101107RsParam.getBuyerFlag());
        param.setFilter("lgcsAreaCode", iBS2101107RsParam.getProvinceCode());
        param.setFilter("cityCode", iBS2101107RsParam.getCityCode());
        param.setFilter("districtCode", iBS2101107RsParam.getDistrictCode());
        param.setFilter("buyerAddr", iBS2101107RsParam.getBuyerAddr());
        param.setFilter("buyerName", iBS2101107RsParam.getBuyerName());
        param.setFilter("salesTargetType", iBS2101107RsParam.getSalesTargetType());
        param.setFilter("classCode", iBS2101107RsParam.getClassCode());
        param.setFilter("houseCode", iBS2101107RsParam.getHouseCode());
        param.setFilter("applyStatus", iBS2101107RsParam.getApplyStatus());
        param.setFilter("busiTel", iBS2101107RsParam.getBusiTel());
        param.setFilter("employeeName", iBS2101107RsParam.getEmployeeName());
        param.setFilter("buyerShop", iBS2101107RsParam.getBuyerShop());
        param.setFilter("buyerCode", iBS2101107RsParam.getBuyerCode());
        param.setFilter("buyerType", iBS2101107RsParam.getBuyerType());
        param.setFilter("marketId", iBS2101107RsParam.getMarketId());
        List<IBS2101107Bean> beans = bS2101103Logic.findPageList(param, pageResult);
        for (IBS2101107Bean bean : beans) {
            param.setFilter("buyerId", bean.getBuyerId());
            //查询买家产品销售对象表
            List<ByBuyerSalestarget> byBuyerSalestargets = bS2101103Logic.findByBuyerSalestarget(param);
            bean.setByBuyerSalestargetList(byBuyerSalestargets);
            //查询买家经营产品类别表
            List<ByBuyerPdCla> byBuyerPdClas = bS2101103Logic.findByBuyerPdCla(param);
            bean.setByBuyerPdClaList(byBuyerPdClas);
        }
        return (List<T>) beans;
    }

}


