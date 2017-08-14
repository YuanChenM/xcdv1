package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.IPD141144RsParam;
import com.msk.pd.bean.IPD141145RsParam;

/**
 * IPD141145Validator 校验
 *
 * @author gyh
 */
public class IPD141145Validator extends BaseValidator<RsRequest<IPD141145RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141145RsParam> entity) {
        IPD141145RsParam param = entity.getParam();
        this.validatorRequired("参数", param);
        if (null != param) {
            this.validatorRequired("卖家Id", param.getSellerCode());
        }
    }
}
