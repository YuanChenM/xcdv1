package com.msk.pl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pl.bean.PLInfo;

/**
 * Created by gyh on 2017/2/8.
 */
public class IPL20170218Validator extends BaseValidator<RsRequest<PLInfo>> {


    @Override
    public void validatorData(RsRequest<PLInfo> entity) {
        PLInfo param = entity.getParam();
        if (null != param) {
            this.validatorRequired("进货单ID", param.getPlId());
            this.validatorRequired("进货单状态", param.getStatus());
        }

    }
}
