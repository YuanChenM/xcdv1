package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151421RsParam;

/**
 * ISO151421Validator.
 *
 * @author sjj
 */
public class ISO151421Validator extends BaseValidator<RsRequest<ISO151421RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151421RsParam> request) {
        ISO151421RsParam param = request.getParam();
        this.validatorRequired("业务参数", param);
        if (null != param) {
            this.validatorRequired("投诉用户ID", param.getUserId());
            this.validatorRequired("投诉处理状态", param.getComplainStatus());
        }
    }
}
