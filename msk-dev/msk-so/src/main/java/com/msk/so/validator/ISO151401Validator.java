package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151401RsParam;

/**
 * ISO151401Validator 校验
 *
 * @author sjj
 */
public class ISO151401Validator extends BaseValidator<RsRequest<ISO151401RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO151401RsParam> request) {
        ISO151401RsParam param = request.getParam();
        if (null != param) {
            this.validatorRequired("卖家编码", param.getSellerCode());
            this.validatorBetween(StringUtil.toBigDecimal(param.getPlatformType()), StringUtil.toBigDecimal(IntDef.INT_TWO), StringUtil.toBigDecimal(IntDef.INT_ONE), "电商类型", true);
            this.validatorMaxLength(StringUtil.toSafeString(param.getDistrictCode()), IntDef.INT_TWO, "物流区域编码", true);
            this.validatorBetween(StringUtil.toBigDecimal(param.getSellerType()), StringUtil.toBigDecimal(IntDef.INT_TWO), StringUtil.toBigDecimal(IntDef.INT_ONE), "卖家类型", true);
        }
    }
}
