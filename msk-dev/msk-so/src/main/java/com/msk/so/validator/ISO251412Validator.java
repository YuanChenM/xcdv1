package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO251412RsParam;

/**
 * 
 * ISO251410Validator.
 *
 * @author pxg
 */
public class ISO251412Validator extends BaseValidator<RsRequest<ISO251412RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO251412RsParam> request) {
        ISO251412RsParam param = request.getParam();
        if (null != param) {
            this.validatorRequired("订单ID", param.getOrderId());
            this.validatorRequired("订单版本号", param.getVer());
            this.validatorRequired("操作类型", param.getOperateType());
        }
    }
}
