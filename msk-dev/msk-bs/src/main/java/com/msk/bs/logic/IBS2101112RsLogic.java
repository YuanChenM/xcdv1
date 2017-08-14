package com.msk.bs.logic;

import com.msk.bs.bean.IBS2101112Bean;
import com.msk.bs.bean.IBS2101112RsParam;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsPageParam;
import com.msk.core.bean.RsPageResult;
import com.msk.core.entity.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
@Service
public class IBS2101112RsLogic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private BS2101112Logic bS2101112Logic;

    @Override
    public <T extends BaseEntity> List<T> findPageList(RsPageParam param, RsPageResult pageResult) {
        IBS2101112RsParam iBS2101112RsParam = (IBS2101112RsParam) param;
        if (param.getPageCount() == 0 || param.getPageNo() == 0) {
            param.setPaging(false);
        } else {
            param.setPaging(true);
        }
        param.setFilter("slCode", iBS2101112RsParam.getSlCode());
        param.setFilter("buyerId", iBS2101112RsParam.getBuyerId());
        param.setFilter("buyerFlag", iBS2101112RsParam.getBuyerFlag());
        param.setFilter("provinceCode", iBS2101112RsParam.getProvinceCode());
        param.setFilter("cityCode", iBS2101112RsParam.getCityCode());
        param.setFilter("districtCode", iBS2101112RsParam.getDistrictCode());
        param.setFilter("buyerAddr", iBS2101112RsParam.getBuyerAddr());
        param.setFilter("salesTargetType", iBS2101112RsParam.getSalesTargetType());
        param.setFilter("classCode", iBS2101112RsParam.getClassCode());
        param.setFilter("classCode", iBS2101112RsParam.getClassCode());
        param.setFilter("houseCode", iBS2101112RsParam.getHouseCode());
        param.setFilter("applyStatus", iBS2101112RsParam.getApplyStatus());
        param.setFilter("searchDataFlag", iBS2101112RsParam.getSearchDataFlag());
        Date startDate = iBS2101112RsParam.getStartDate();
        Date endDate = iBS2101112RsParam.getEndDate();
        if((startDate != null)&&(endDate != null)){
            param.setFilter("startDate", startDate.toString());
            param.setFilter("endDate",  endDate.toString());
        }
        List<IBS2101112Bean> beans = bS2101112Logic.findPageList(param, pageResult);
        return (List<T>) beans;
    }
}


