package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170412Param;

/**
 * Created by xuhongyang on 2017/5/4.
 * 外勤用户验证接口参数校验
 */
public class IPL20170412Validator extends BaseValidator<RsRequest<IPL20170412Param>> {

    @Override
    public void validatorData(RsRequest<IPL20170412Param> entity) {
        IPL20170412Param param = entity.getParam();
        if (null != param) {
            this.validatorRequired("合伙人ID ", param.getPartnerId());
            this.validatorRequired("进货单创建时间", param.getCrtDate());
        }
    }
}
