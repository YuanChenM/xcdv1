package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151429RsParam;

/**
 * Created by wang_shuai on 2016/6/24.
 */
public class ISO151429Validator extends BaseValidator<RsRequest<ISO151429RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151429RsParam> request) {
        ISO151429RsParam iso151429RsParam=request.getParam();
        this.validatorRequired("参数不能为空",iso151429RsParam);
        if(iso151429RsParam != null){
            this.validatorRequired("管家编码", iso151429RsParam.getHouseCodeDis());
            this.validatorRequired("物流区编码", iso151429RsParam.getLgcsCode());

        }
    }
}
