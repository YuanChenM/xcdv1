package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170209Param;

/**
 * Created by xuhongyang on 2017/2/7.
 * 进货单产品接口参数校验
 */
public class IPL20170209Validator extends BaseValidator<RsRequest<IPL20170209Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170209Param> entity) {
        IPL20170209Param param = entity.getParam();
            if (param.getPlId() != null && param.getPlId().toString() != "") {
                this.validatorRequired("产品名称 ", param.getPdName());
                this.validatorRequired("品牌所有人", param.getBrandOwner());
                this.validatorRequired("产品等级需求 ", param.getPdNeedGrade());
                this.validatorRequired("生产商 ", param.getManufacturer());
                this.validatorRequired("小包装特征 ", param.getSmallPackFeature());
                this.validatorRequired("小包装件数 ", param.getSmallPackNumber());
                this.validatorRequired("净重 ", param.getNetweight());
                this.validatorRequired("毛重 ", param.getGrossweight());
                this.validatorRequired("销售时间 ", param.getSaleTime());
                this.validatorRequired("价盘期 ", param.getPricePeriod());
                this.validatorRequired("对应价盘通道 ", param.getPriceChannel());
                this.validatorRequired("单价 ", param.getUnitPrice());
                this.validatorRequired("销售量 ", param.getSalesVolume());
            }else{
                this.validatorRequired("进货单ID ", param.getPlId());
                this.validatorRequired("产品名称 ", param.getPdName());
                this.validatorRequired("品牌所有人", param.getBrandOwner());
                this.validatorRequired("产品等级需求 ", param.getPdNeedGrade());
                this.validatorRequired("生产商 ", param.getManufacturer());
                this.validatorRequired("小包装特征 ", param.getSmallPackFeature());
                this.validatorRequired("小包装件数 ", param.getSmallPackNumber());
                this.validatorRequired("净重 ", param.getNetweight());
                this.validatorRequired("毛重 ", param.getGrossweight());
                this.validatorRequired("销售时间 ", param.getSaleTime());
                this.validatorRequired("价盘期 ", param.getPricePeriod());
                this.validatorRequired("对应价盘通道 ", param.getPriceChannel());
                this.validatorRequired("单价 ", param.getUnitPrice());
                this.validatorRequired("销售量 ", param.getSalesVolume());
            }
        }
}
