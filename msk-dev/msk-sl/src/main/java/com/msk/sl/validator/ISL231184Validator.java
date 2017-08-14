package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlEcTeam;
import com.msk.sl.bean.ISL231184RsParam;

/**
 * Created by gyh on 2016/3/24.
 */
public class ISL231184Validator extends BaseValidator<RsRequest<ISL231184RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231184RsParam> entity) {
        ISL231184RsParam param = entity.getParam();
        this.validatorRequired("业务参数", param);
        this.validatorRequired("营业执照_注册号", param.getLicNo());
    }
}
