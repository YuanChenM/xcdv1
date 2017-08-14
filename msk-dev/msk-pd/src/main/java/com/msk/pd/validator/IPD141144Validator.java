package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.IPD141144RsParam;

/**
 * IPD141139Validator 校验
 *
 * @author xhy
 */
public class IPD141144Validator extends BaseValidator<RsRequest<IPD141144RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141144RsParam> entity) {
        IPD141144RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("卖家编码", param.getSellerCode());
            this.validatorBetween(StringUtil.toBigDecimal(param.getPlatformType()), StringUtil.toBigDecimal(IntDef.INT_TWO), StringUtil.toBigDecimal(IntDef.INT_ONE), "电商类型", true);
            this.validatorMaxLength(StringUtil.toSafeString(param.getDistrictCode()), IntDef.INT_TWO, "物流区域编码", true);
            this.validatorBetween(StringUtil.toBigDecimal(param.getSellerType()), StringUtil.toBigDecimal(IntDef.INT_TWO), StringUtil.toBigDecimal(IntDef.INT_ONE), "卖家类型", true);
            /*this.validatorMaxLength(param.getPdCode(), IntDef.INT_TEN, "产品编码", false);*/
           /* this.validatorMaxLength(param.getUserMobile(), IntDef.INT_ELEVEN, "买家手机号码", false);*/
        }
    }
}
