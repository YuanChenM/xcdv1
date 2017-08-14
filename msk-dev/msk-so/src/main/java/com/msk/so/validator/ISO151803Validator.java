package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151803RsParam;
import com.msk.so.bean.ISO251412RsParam;

/**
 *
 */
public class ISO151803Validator extends BaseValidator<RsRequest<ISO151803RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO151803RsParam> request) {
        ISO151803RsParam param = request.getParam();
        if (null != param) {
            this.validatorRequired("买家ID", param.getBuyerId());
            this.validatorRequired("订单id", param.getOrderId());
        }
    }
}
