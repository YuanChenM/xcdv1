package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170202Param;

/**
 * Created by xuhongyang on 2017/2/3.
 * 根据月份查询任务列表
 */
public class IPL20170202Validator extends BaseValidator<RsRequest<IPL20170202Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170202Param> entity) {
        IPL20170202Param param = entity.getParam();
        if (null != param) {
            this.validatorRequired("买手编码 ", param.getBsCode());
            this.validatorRequired("当前月份", param.getNowMonth());
        }

    }
}
