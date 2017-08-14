package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231149RsParam;

/**
 * Created by cx on 2016/2/22.
 */
public class ISL231149Validator extends BaseValidator<RsRequest<ISL231149RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231149RsParam> entity) {
        ISL231149RsParam iSL231149RsParam = entity.getParam();
        /*if (null != iSL231149RsParam) {
            this.validatorRequired("企业ID",iSL231149RsParam.getEpId());
        }*/
    }
}
