package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231201RsParam;

/**
 * ISL231201Validator.
 *
 * @author gyh
 */
public class ISL231201Validator extends BaseValidator<RsRequest<ISL231201RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231201RsParam> request) {
        ISL231201RsParam param = request.getParam();
        if (null != param) {
            this.validatorRequired("查询类别", param.getChapClass());
        }
    }
}
