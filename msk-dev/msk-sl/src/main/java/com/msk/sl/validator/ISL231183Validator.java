package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231183RsParam;

/**
 * Created by gyh on 2016/3/18.
 */
public class ISL231183Validator extends BaseValidator<RsRequest<ISL231183RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231183RsParam> entity) {
        ISL231183RsParam param=entity.getParam();
        this.validatorRequired("接口参数",param);
        this.validatorRequired("卖家账号",param.getSlAccount());
        this.validatorRequired("旧密码",param.getOldAccountPsd());
        this.validatorRequired("新密码",param.getNewAccountPsd());
    }
}
