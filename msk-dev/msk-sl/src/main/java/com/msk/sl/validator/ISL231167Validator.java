package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231167RsParam;

/**
 * Created by cx on 2016/2/24.
 */
public class ISL231167Validator extends BaseValidator<RsRequest<ISL231167RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231167RsParam> entity) {
        ISL231167RsParam iSL231167RsParam = entity.getParam();
        if (null != iSL231167RsParam) {
            this.validatorRequired("卖家编码", iSL231167RsParam.getSlCode());
        }
    }
}


