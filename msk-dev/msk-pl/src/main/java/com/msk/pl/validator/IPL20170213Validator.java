package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170213RsParam;

/**
 * Created by gyh on 2017/2/6.
 */
public class IPL20170213Validator extends BaseValidator<RsRequest<IPL20170213RsParam>> {


    @Override
    public void validatorData(RsRequest<IPL20170213RsParam> entity) {
        IPL20170213RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("合伙人ID", param.getPartnerId());
            this.validatorRequired("填报数量", param.getStatementNumber());
            this.validatorRequired("补报天数", param.getRepayDay());
            this.validatorRequired("生效时间", param.getEffectiveTime());
            this.validatorRequired("合伙人名称", param.getCrtId());
        }

    }
}
