package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pd.bean.IPD141123RsParam;
import com.msk.pd.bean.IPD141124RsParam;

/**
 * Created by FjM on 2016/3/14.
 */
public class IPD141123Validator extends BaseValidator<RsRequest<IPD141123RsParam>> {
    @Override
    public void validatorData(RsRequest<IPD141123RsParam> entity) {
        IPD141123RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("类别编码", param.getClassesCode());
            this.validatorRequired("二级分类编码", param.getMachiningCode());
            this.validatorRequired("品种编码",param.getBreedCode());
        }
    }
}
