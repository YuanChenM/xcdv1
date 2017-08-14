package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pd.bean.IPD141122RsParam;
import com.msk.pd.bean.IPD141124RsParam;

/**
 * Created by air on 2016/3/10.
 */
public class IPD141124Validator extends BaseValidator<RsRequest<IPD141124RsParam>>{
    @Override
    public void validatorData(RsRequest<IPD141124RsParam> entity) {
        IPD141124RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("类别编码", param.getClassesCode());
            this.validatorRequired("二级分类编码", param.getMachiningCode());
            this.validatorRequired("品种编码",param.getBreedCode());
        }
    }
}
