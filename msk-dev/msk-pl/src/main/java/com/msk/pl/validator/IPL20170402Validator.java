package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170402Param;

/**
 * Created by zhao_chen on 2017/2/3.
 *  外勤用户验证接口参数校验
 *
 */
public class IPL20170402Validator extends BaseValidator<RsRequest<IPL20170402Param>> {

    @Override
    public void validatorData(RsRequest<IPL20170402Param> entity) {
        IPL20170402Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("买手编码 ", param.getBsCode());
           this.validatorRequired("申报年月", param.getDeclareYM());
       }
    }
}
