package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231141RsParam;

/**
 * Created by cx on 2016/2/18.
 */
public class ISL231141Validator extends BaseValidator<RsRequest<ISL231141RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231141RsParam> entity) {
        ISL231141RsParam iSL231141RsParam = entity.getParam();
        if (null != iSL231141RsParam) {
            this.validatorRequired("企业id",iSL231141RsParam.getEpId());
        }
    }
}
