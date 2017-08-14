package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170411Param;

/**
 * Created by xuhongyang on 2017/2/3.
 *  外勤用户验证接口参数校验
 *
 */
public class IPL20170411Validator extends BaseValidator<RsRequest<IPL20170411Param>> {

    @Override
    public void validatorData(RsRequest<IPL20170411Param> entity) {
        IPL20170411Param param = entity.getParam();
       if (null != param) {
           this.validatorRequired("合伙人ID ", param.getPartnerId());
           this.validatorRequired("查询方式", param.getSelectRule());
           this.validatorRequired("申报单创建时间", param.getCrtDate());
       }
    }
}
