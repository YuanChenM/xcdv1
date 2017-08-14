package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151428RsParam;

/**
 * Created by wang_shuai on 2016/6/24.
 */
public class ISO151428Validator extends BaseValidator<RsRequest<ISO151428RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151428RsParam> request) {
        ISO151428RsParam iso151428RsParam=request.getParam();
        this.validatorRequired("参数不能为空",iso151428RsParam);
        if(iso151428RsParam != null){
            this.validatorRequired("商品编码", iso151428RsParam.getPdCode());

        }
    }
}
