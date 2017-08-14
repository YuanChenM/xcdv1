package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlEpBrandHonor;

/**
 * Created by cx on 2016/2/23.
 */
public class ISL231155Validator extends BaseValidator<RsRequest<SlEpBrandHonor>> {

    @Override
    public void validatorData(RsRequest<SlEpBrandHonor> entity) {
        SlEpBrandHonor slEpBrandHonor = entity.getParam();
        if (null != slEpBrandHonor) {
            this.validatorRequired("企业ID",slEpBrandHonor.getEpId());
            this.validatorRequired("品牌ID",slEpBrandHonor.getBrandId());
            this.validatorRequired("品牌ID",slEpBrandHonor.getHonorId());
            this.validatorRequired("荣誉描述",slEpBrandHonor.getHonorDes());
            this.validatorRequired("证书编号",slEpBrandHonor.getHonorNo());
            this.validatorRequired("发证日期",slEpBrandHonor.getCertDate());
            this.validatorRequired("创建者ID",slEpBrandHonor.getUpdId());
        }
    }
}





