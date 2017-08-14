package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151411RsParam;

/**
 * ISO151411Validator.
 *
 * @author sjj
 */
public class ISO151411Validator extends BaseValidator<RsRequest<ISO151411RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151411RsParam> request) {
        ISO151411RsParam param = request.getParam();
        this.validatorRequired("业务参数", param);
        if(null != param){
            this.validatorRequired("订单ID", param.getOrderId());
            this.validatorRequired("支付交易流水号", param.getPaymentOrderCode());
        }
    }
}
