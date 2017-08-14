package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170406Param;

/**
 * Created by xuhongyang on 2017/2/3.
 * 外勤用户验证接口参数校验
 */
public class IPL20170406Validator extends BaseValidator<RsRequest<IPL20170406Param>> {

    @Override
    public void validatorData(RsRequest<IPL20170406Param> entity) {
        IPL20170406Param param = entity.getParam();
        if (null != param) {
            this.validatorRequired("买手编码 ", param.getBsCode());
            this.validatorRequired("价盘期id", param.getPpId());
            if (param.getPdCodeList() != null) {
                for (IPL20170406Param ipl20170406Param : param.getPdCodeList()) {
                    this.validatorRequired("产品编码 ", ipl20170406Param.getPdCode());
                }
            } else {
                this.validatorRequired("产品编码列表 ", null);
            }
        }
    }
}
