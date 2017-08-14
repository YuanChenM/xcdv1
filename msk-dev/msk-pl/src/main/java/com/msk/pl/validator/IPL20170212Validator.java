package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170212Param;

/**
 * Created by xuhongyang on 2017/2/14.
 *
 *
 */
public class IPL20170212Validator extends BaseValidator<RsRequest<IPL20170212Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170212Param> entity) {
        IPL20170212Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("月份 ", param.getNowMonth());
           this.validatorRequired("买手编码 ", param.getBsCode());
       }

    }
}
