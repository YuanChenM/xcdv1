package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231126RsParam;

/**
 * Created by cx on 2016/2/17.
 */
public class ISL231126Validator extends BaseValidator<RsRequest<ISL231126RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231126RsParam> entity) {
        ISL231126RsParam iSL231126RsParam = entity.getParam();
        if (null != iSL231126RsParam) {
           /* this.validatorRequired("证照ID",iSL231126RsParam.certId);
            this.validatorRequired("证照名称",iSL231126RsParam.certName);*/
        }
    }
}
