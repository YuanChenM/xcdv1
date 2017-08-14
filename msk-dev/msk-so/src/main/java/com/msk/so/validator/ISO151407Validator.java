package com.msk.so.validator;


import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151407RsParam;

/**
 * 
 * ISO151407Validator.
 *
 * @author sun_jiaju
 */
public class ISO151407Validator extends BaseValidator<RsRequest<ISO151407RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO151407RsParam> request) {
        ISO151407RsParam param = request.getParam();
        this.validatorRequired("业务参数", param);
        if(null!=param){
            this.validatorRequired("买家ID", param.getBuyerId());
        }
    }


}
