package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.IPD141104RsParam;
import com.msk.pd.bean.IPD141105RsParam;

/**
 * IPD141104Validator 校验
 *
 * @author xhy
 */
public class IPD141104Validator extends BaseValidator<RsRequest<IPD141104RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141104RsParam> entity) {
        IPD141104RsParam param = entity.getParam();
        if (null != param) {
            this.validatorMaxLength(param.getClassesCode(), IntDef.INT_TWO, "产品类别编码", true);
        }
    }
}
