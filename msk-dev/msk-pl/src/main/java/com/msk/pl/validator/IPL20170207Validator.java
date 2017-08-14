package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170207Param;

/**
 * Created by xuhongyang on 2017/2/7.
 *  上传图片参数校验
 *
 */
public class IPL20170207Validator extends BaseValidator<RsRequest<IPL20170207Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170207Param> entity) {
        IPL20170207Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("手机号码 ", param.getPhoneNumber());
           this.validatorRequired("买手编码 ", param.getBsCode());
       }

    }
}
