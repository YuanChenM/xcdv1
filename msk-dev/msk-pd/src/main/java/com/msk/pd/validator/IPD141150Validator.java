package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pd.bean.IPD141150Param;

/**
 * Created by ren_qiang on 2016/11/7.
 */
public class IPD141150Validator extends BaseValidator<RsRequest<IPD141150Param>> {

    @Override
    public void validatorData(RsRequest<IPD141150Param> entity) {
        IPD141150Param param = entity.getParam();
        if(null != param){
            this.validatorRequired("产品编码", param.getPdCode());
        }
    }
}
