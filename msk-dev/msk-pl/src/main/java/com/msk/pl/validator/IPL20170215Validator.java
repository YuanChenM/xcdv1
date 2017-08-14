package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170215Param;

/**
 * Created by gyh on 2017/2/7.
 */
public class IPL20170215Validator extends BaseValidator<RsRequest<IPL20170215Param>> {


    @Override
    public void validatorData(RsRequest<IPL20170215Param> entity) {
        IPL20170215Param param = entity.getParam();
        if (null != param) {
            this.validatorRequired("合伙人ID", param.getPartnerId());
            this.validatorRequired("激励费用", param.getIncentiveFee());
            this.validatorRequired("生效时间", param.getEffectiveTime());
            this.validatorRequired("合伙人名称", param.getCrtId());
        }

    }
}
