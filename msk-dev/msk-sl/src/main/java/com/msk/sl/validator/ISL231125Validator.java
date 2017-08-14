package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231125RsParam;

/**
 * Created by cx on 2016/2/17.
 */
public class ISL231125Validator extends BaseValidator<RsRequest<ISL231125RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231125RsParam> entity) {
        ISL231125RsParam iSL231125RsParam = entity.getParam();
        if (null != iSL231125RsParam) {
//            this.validatorRequired("企业ID",iSL231125RsParam.getEpId());
//            this.validatorRequired("企业名称",iSL231125RsParam.getEpName());
        }
    }

}
