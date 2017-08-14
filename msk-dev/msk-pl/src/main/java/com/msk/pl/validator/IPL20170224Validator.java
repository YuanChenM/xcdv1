package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170224Param;

/**
 * Created by xuhongyang on 2017/2/3.
 *  根据任务ID查询对应进货单参数校验
 *
 */
public class IPL20170224Validator extends BaseValidator<RsRequest<IPL20170224Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170224Param> entity) {
        IPL20170224Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("买手编码 ", param.getBsCode());
           this.validatorRequired("当前选中时间 ", param.getReportDate());
       }
    }
}
