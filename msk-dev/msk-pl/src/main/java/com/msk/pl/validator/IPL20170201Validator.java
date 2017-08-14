package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170201Param;

/**
 * Created by xuhongyang on 2017/2/3.
 *  外勤用户验证接口参数校验
 *
 */
public class IPL20170201Validator extends BaseValidator<RsRequest<IPL20170201Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170201Param> entity) {
        IPL20170201Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("用户外勤365实名 ", param.getUserName());
           this.validatorRequired("用户外勤365账号", param.getWqAccount());
       }

    }
}
