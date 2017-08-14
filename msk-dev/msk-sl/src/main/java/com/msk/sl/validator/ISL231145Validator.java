package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SlEcTeam;

/**
 * Created by cx on 2016/2/19.
 */
public class ISL231145Validator extends BaseValidator<RsRequest<SlEcTeam>> {

    @Override
    public void validatorData(RsRequest<SlEcTeam> entity) {
        SlEcTeam slEcTeam = entity.getParam();
        if (null != slEcTeam) {
            this.validatorRequired("卖家编码",slEcTeam.getSlCode());
        }
    }
}
