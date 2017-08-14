package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170404Param;
import com.msk.pl.bean.IPL20170405Param;

/**
 * Created by xuhongyang on 2017/2/3.
 *  外勤用户验证接口参数校验
 *
 */
public class IPL20170405Validator extends BaseValidator<RsRequest<IPL20170405Param>> {

    @Override
    public void validatorData(RsRequest<IPL20170405Param> entity) {
        IPL20170405Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("买手编码 ", param.getBsCode());
           this.validatorRequired("价盘期id", param.getPpId());
       }
    }
}
