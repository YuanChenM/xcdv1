package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170203Param;

/**
 * Created by xuhongyang on 2017/2/3.
 * 进货单删除接口参数校验
 *
 */
public class IPL20170203Validator extends BaseValidator<RsRequest<IPL20170203Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170203Param> entity) {
        IPL20170203Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("进货单ID ", param.getPlId());
       }

    }
}
