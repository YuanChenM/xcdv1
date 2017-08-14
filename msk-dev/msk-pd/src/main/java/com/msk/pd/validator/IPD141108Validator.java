package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pd.bean.IPD141108RsParam;

/**
 * 
 * IPD141108 Validator 校验
 * 
 * @author xhy
 */
public class IPD141108Validator extends BaseValidator<RsRequest<IPD141108RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141108RsParam> entity) {
        IPD141108RsParam param = entity.getParam();
        if (null != param) {
        }
    }
}
