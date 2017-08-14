package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151434RsParam;

/**
 * ISO151421Validator.
 *
 * @author jiang_tengfei
 */
public class ISO151434Validator extends BaseValidator<RsRequest<ISO151434RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151434RsParam> request) {
        ISO151434RsParam iSO151434RsParam = request.getParam();
        if(null!=iSO151434RsParam){
            this.validatorRequired("系统编码", iSO151434RsParam.getOrderSource());
            this.validatorRequired("本月时间",iSO151434RsParam.getThisMonth());
        }
    }
}
