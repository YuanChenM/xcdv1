package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170406Param;
import com.msk.pl.bean.IPL20170407Param;

/**
 * Created by xuhongyang on 2017/2/3.
 * 外勤用户验证接口参数校验
 */
public class IPL20170407Validator extends BaseValidator<RsRequest<IPL20170407Param>> {

    @Override
    public void validatorData(RsRequest<IPL20170407Param> entity) {
        IPL20170407Param param = entity.getParam();
        if (null != param) {
            this.validatorRequired("买手编码 ", param.getBsCode());
            this.validatorRequired("价盘期id", param.getPpId());
            this.validatorRequired("申报单任务id", param.getTaskId());

            if (param.getDetailList() != null) {
                for (IPL20170407Param ipl20170407Param : param.getDetailList()) {
                    this.validatorRequired("产品编码 ", ipl20170407Param.getPdCode());
                    this.validatorRequired("产品名称 ", ipl20170407Param.getPdName());
                    this.validatorRequired("产品编码 ", ipl20170407Param.getPdCode());
                }
            } else {
                this.validatorRequired("产品详细列表 ", null);
            }
        }
    }
}
