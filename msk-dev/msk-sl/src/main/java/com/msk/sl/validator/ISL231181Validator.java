package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231128RsParam;
import com.msk.sl.bean.ISL231181RsParam;
import com.msk.sl.bean.SL24110302_1Bean;

import java.util.List;

/**
 * Created by rwf on 2016/2/22.
 */
public class ISL231181Validator extends BaseValidator<RsRequest<ISL231181RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231181RsParam> entity) {
        ISL231181RsParam isl231181RsParam = entity.getParam();
        this.validatorRequired("卖家账号",isl231181RsParam.getSlAccount());
    }
}
