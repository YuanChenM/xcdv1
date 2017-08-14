package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151433RsParam;

/**
 * ISO151433Validator.
 *
 * @author sunjiaju
 */
public class ISO151433Validator extends BaseValidator<RsRequest<ISO151433RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151433RsParam> request) {
        ISO151433RsParam iSO151433RsParam = request.getParam();
        if (null!=iSO151433RsParam) {
            this.validatorRequired("发货单ID",iSO151433RsParam.getShipId());
            this.validatorRequired("取消时间",iSO151433RsParam.getCancelTime());
        }
    }
}
