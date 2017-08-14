package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151420RsParam;

/**
 * ISO151420Validator.
 *
 * @author sjj
 */
public class ISO151420Validator extends BaseValidator<RsRequest<ISO151420RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151420RsParam> request) {
        ISO151420RsParam param = request.getParam();
        this.validatorRequired("业务参数", param);
        if (null != param) {
            this.validatorRequired("用户ID", param.getUserId());
            this.validatorRequired("投诉时间", param.getComplainDate());
            this.validatorRequired("订单ID", param.getOrderId());
            this.validatorRequired("投诉理由Code", param.getComplainReasonCode());
            this.validatorRequired("投诉描述", param.getComplainDescription());
        }
    }
}
