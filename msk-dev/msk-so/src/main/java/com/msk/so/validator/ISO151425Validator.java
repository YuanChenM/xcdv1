package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151425RsParam;

/**
 * ISO151425Validator.
 *
 * @author sjj
 */
public class ISO151425Validator extends BaseValidator<RsRequest<ISO151425RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151425RsParam> request) {
        ISO151425RsParam param = request.getParam();
        this.validatorRequired("业务参数", param);
        if (null != param) {
            this.validatorRequired("订单ID", param.getOrderId());
        }
    }
}
