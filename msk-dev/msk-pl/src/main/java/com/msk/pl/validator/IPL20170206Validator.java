package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170206Param;

/**
 * Created by xuhongyang on 2017/2/7.
 *  上传图片参数校验
 *
 */
public class IPL20170206Validator extends BaseValidator<RsRequest<IPL20170206Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170206Param> entity) {
        IPL20170206Param param = entity.getParam();
       if (null != param) {
          this.validatorRequired("产品名称 ", param.getPdName());
       }

    }
}
