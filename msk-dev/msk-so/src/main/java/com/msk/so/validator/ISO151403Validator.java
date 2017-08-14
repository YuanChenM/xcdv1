package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151403RsParam;
import com.msk.so.bean.ISO151421RsParam;

/**
 * ISO151403Validator.
 *
 * @author sjj
 */
public class ISO151403Validator extends BaseValidator<RsRequest<ISO151403RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151403RsParam> request) {
        ISO151403RsParam param = request.getParam();
        if(null != param){
            this.validatorRequired("订单号", param.getTransCode());
        }
    }
}
