package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.SL24110306Bean;

/**
 * Created by cx on 2016/2/18.
 */
public class ISL231140Validator extends BaseValidator<RsRequest<SL24110306Bean>> {

    @Override
    public void validatorData(RsRequest<SL24110306Bean> entity) {
        SL24110306Bean sL24110306Bean = entity.getParam();
        if (null != sL24110306Bean) {
            this.validatorRequired("企业id",sL24110306Bean.getEpId());
        }
    }
}
