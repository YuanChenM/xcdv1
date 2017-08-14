package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.BookKeepingParam;

/**
 * Created by zhang_xi on 2016/3/2.
 */
public class ISO153101Validator extends BaseValidator<RsRequest<BookKeepingParam>> {
    //TODO
    @Override
    public void validatorData(RsRequest<BookKeepingParam> request) {
        BookKeepingParam rsParam = request.getParam();
        if(null!=rsParam){
            this.validatorRequired("业务主体编码", rsParam.getPayeeCode());
            this.validatorRequired("业务主体角色", rsParam.getPayeeRole());
            this.validatorRequired("业务副体编码", rsParam.getPayerCode());
            this.validatorRequired("业务副体角色", rsParam.getPayerRole());
            this.validatorRequired("是否结算", rsParam.getIsPayed());
            this.validatorRequired("支付金额", rsParam.getPayAmount());
        }
    }


}
