package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170214RsParam;

/**
 * Created by gyh on 2017/2/8.
 */
public class IPL20170214Validator extends BaseValidator<RsRequest<IPL20170214RsParam>> {


    @Override
    public void validatorData(RsRequest<IPL20170214RsParam> entity) {
        IPL20170214RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("合伙人ID", param.getPartnerId());
        }

    }
}
