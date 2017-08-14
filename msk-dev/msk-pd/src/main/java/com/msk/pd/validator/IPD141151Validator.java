package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pd.bean.IPD141151Param;

/**
 * Created by ren_qiang on 2016/11/7.
 */
public class IPD141151Validator extends BaseValidator<RsRequest<IPD141151Param>> {

    @Override
    public void validatorData(RsRequest<IPD141151Param> entity) {
        IPD141151Param param = entity.getParam();
        if(null != param){
            this.validatorRequired("物流区编码", param.getLgcsCode());
        }
    }
}
