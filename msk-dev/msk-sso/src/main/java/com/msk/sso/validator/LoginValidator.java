package com.msk.sso.validator;

import com.msk.core.base.BaseValidator;
import com.msk.sso.bean.SsoParam;

/**
 * 登录表单校验类.
 */
public class LoginValidator extends BaseValidator<SsoParam> {
    @Override
    public void validatorData(SsoParam param) {
        if (null != param) {
            this.validatorRequired("登录用户名", param.getLoginId());
            this.validatorRequired("登录密码", param.getLoginPwd());
        }
    }
}