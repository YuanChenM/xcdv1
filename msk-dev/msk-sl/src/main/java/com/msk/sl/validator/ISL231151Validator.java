package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlPdBrand;

/**
 * Created by cx on 2016/2/22.
 */
public class ISL231151Validator extends BaseValidator<RsRequest<SlPdBrand>> {

    @Override
    public void validatorData(RsRequest<SlPdBrand> entity) {
        SlPdBrand slPdBrand = entity.getParam();
        if (null != slPdBrand) {
            this.validatorRequired("卖家编码",slPdBrand.getSlCode());
            this.validatorRequired("品牌所属企业ID",slPdBrand.getBrandEpId());
            this.validatorRequired("品牌ID",slPdBrand.getBrandId());
            this.validatorRequired("品牌名称",slPdBrand.getBrandName());
            this.validatorRequired("品牌类型",slPdBrand.getBrandType());
            this.validatorRequired("创建者ID",slPdBrand.getUpdId());
        }
    }
}



