package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pd.bean.IPD142001RsParam;

/**
 * IPD142001Validator 校验
 *
 * @author xhy
 */
public class IPD142001Validator extends BaseValidator<RsRequest<IPD142001RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD142001RsParam> entity) {
        IPD142001RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("内容类型", param.getConstantType());
        }
    }
}
