package com.msk.by.validator;

import com.msk.by.bean.IBY121103RsParam;
import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;

/**
 * IBY121103Validator.
 *
 * @author yang_yang
 */
public class IBY121103Validator extends BaseValidator<RsRequest<IBY121103RsParam>> {
    @Override
    public void validatorData(RsRequest<IBY121103RsParam> request) {
        IBY121103RsParam iby121103RsParam = request.getParam();
        if(null != iby121103RsParam){
            this.validatorRequired("物流区编码", iby121103RsParam.getLgcsCode());
        }else{
            this.validatorRequired("请求参数", request.getParam());
        }
    }
}
