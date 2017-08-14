package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.pd.bean.IPD141139RsParam;

/**
 * IPD141139Validator 校验
 *
 * @author xhy
 */
public class IPD141139Validator extends BaseValidator<RsRequest<IPD141139RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141139RsParam> entity) {
        IPD141139RsParam param = entity.getParam();
        if (null != param) {
            this.validatorMaxLength(param.getClassesCode(), IntDef.INT_TWO, "产品类别编码", true);
            this.validatorMaxLength(param.getMachiningCode(), IntDef.INT_ONE, "加工类型编码", true);
            this.validatorMaxLength(param.getBreedCode(), IntDef.INT_TWO, "产品品种类型编码", true);
            this.validatorMaxLength(param.getFeatureCode(), IntDef.INT_TWO, "产品特征类型编码", true);
            this.validatorMaxLength(param.getWeightCode(), IntDef.INT_TWO, "产品净重类型编码", true);
        }
    }
}
