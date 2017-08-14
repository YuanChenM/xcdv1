package com.msk.bs.validator;

import com.msk.bs.bean.IBS2101109RsParam;
import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;

/**
 * Created by cx on 2016/2/29.
 */
public class IBS2101109Validator extends BaseValidator<RsRequest<IBS2101109RsParam>> {

    @Override
    public void validatorData(RsRequest<IBS2101109RsParam>  entity) {
        IBS2101109RsParam iBS2101109RsParam = entity.getParam();
        this.validatorRequired("卖家账号",iBS2101109RsParam.getHouseAccount());
        this.validatorRequired("旧密码",iBS2101109RsParam.getNewAccountPsd());
        this.validatorRequired("新密码",iBS2101109RsParam.getOldAccountPsd());
    }
}






