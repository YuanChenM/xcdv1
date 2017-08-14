package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.IPL20170217RsParam;

/**
 * Created by gyh on 2017/2/8.
 */
public class IPL20170217Validator extends BaseValidator<RsRequest<IPL20170217RsParam>> {


    @Override
    public void validatorData(RsRequest<IPL20170217RsParam> entity) {
        IPL20170217RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("合伙人ID", param.getPartnerId());
            this.validatorRequired("查询类型", param.getSelectRule());
            this.validatorRequired("填报日期", param.getCrtDate());
        }

    }
}
