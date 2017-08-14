package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151404RsParam;

/**
 * ISO151403Validator.
 *
 * @author sjj
 */
public class ISO151404Validator extends BaseValidator<RsRequest<ISO151404RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151404RsParam> request) {
        ISO151404RsParam param = request.getParam();
        if(null != param){
            this.validatorRequired("退货单号", param.getBackNo());
            this.validatorRequired("订单号", param.getTransCode());
        }
    }
}
