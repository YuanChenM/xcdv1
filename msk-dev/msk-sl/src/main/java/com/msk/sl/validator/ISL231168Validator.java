package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231168RsParam;

/**
 * Created by cx on 2016/2/24.
 */
public class ISL231168Validator extends BaseValidator<RsRequest<ISL231168RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231168RsParam> entity) {
        ISL231168RsParam iSL231168RsParam = entity.getParam();
        if (null != iSL231168RsParam) {
            this.validatorRequired("卖家编码", iSL231168RsParam.getSlCode());
        }
    }
}


