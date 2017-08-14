package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170204Param;

/**
 * Created by xuhongyang on 2017/2/3.
 * 图片上传接口
 */
public class IPL20170204Validator extends BaseValidator<RsRequest<IPL20170204Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170204Param> entity) {
        IPL20170204Param param = entity.getParam();
        if (null != param) {
            this.validatorRequired("买手名称", param.getBsName());
        }
    }
}
