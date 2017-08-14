package com.msk.pd.validator;

        import com.msk.core.base.BaseValidator;
        import com.msk.core.bean.RsRequest;
        import com.msk.core.consts.NumberConst.IntDef;
        import com.msk.core.utils.StringUtil;
        import com.msk.pd.bean.IPD141105RsParam;

/**
 * IPD141105Validator 校验
 *
 * @author xhy
 */
public class IPD141105Validator extends BaseValidator<RsRequest<IPD141105RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141105RsParam> entity) {
        IPD141105RsParam param = entity.getParam();
        if (null != param) {
            this.validatorMax(StringUtil.toBigDecimal(param.getCodeLevel()), StringUtil.toBigDecimal(IntDef.INT_THREE), "产品等级", true);
            this.validatorMaxLength(param.getClassesCode(), IntDef.INT_TWO, "产品类别编码", false);
        }
    }
}
