package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.core.utils.StringUtil;
import com.msk.pd.bean.IPD141105RsParam;
import com.msk.pd.bean.IPD141127RsParam;

/**
 * IPD141127Validator 校验
 *
 * @author xhy
 */
public class IPD141127Validator extends BaseValidator<RsRequest<IPD141127RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141127RsParam> entity) {
        IPD141127RsParam param = entity.getParam();
        if (null != param) {
            this.validatorMaxLength(param.getClassesCode(), IntDef.INT_TWO, "产品类别编码", true);
            this.validatorMaxLength(param.getMachiningCode(), IntDef.INT_ONE, "加工类型编码", true);
            this.validatorMaxLength(param.getBreedCode(), IntDef.INT_TWO, "产品品种编码", true);
            this.validatorMaxLength(param.getFeatureCode(), IntDef.INT_TWO, "产品特征编码", false);
        }
    }
}
