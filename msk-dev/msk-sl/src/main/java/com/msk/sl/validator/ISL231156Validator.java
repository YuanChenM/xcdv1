package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231155RsParam;

/**
 * Created by cx on 2016/2/23.
 */
public class ISL231156Validator extends BaseValidator<RsRequest<ISL231155RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231155RsParam> entity) {
        ISL231155RsParam iSL231155RsParam = entity.getParam();
        if (null != iSL231155RsParam) {
            this.validatorRequired("企业ID",iSL231155RsParam.getEpId());
        }
    }
}





