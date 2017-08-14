package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170205Param;

/**
 * Created by xuhongyang on 2017/2/7.
 * 进货单查询接口参数校验
 */
public class IPL20170205Validator extends BaseValidator<RsRequest<IPL20170205Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170205Param> entity) {
        IPL20170205Param param = entity.getParam();
        if (null != param) {
            this.validatorRequired("进货单ID ", param.getPlId());
        }

    }
}
