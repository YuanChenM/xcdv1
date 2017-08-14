package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst.IntDef;
import com.msk.pd.bean.IPD141121RsParam;
import com.msk.pd.bean.IPD141147RsParam;

/**
 * IPD141121Validator 校验
 *
 * @author pxg
 */
public class IPD141147Validator extends BaseValidator<RsRequest<IPD141147RsParam>> {

    @Override
    public void validatorData(RsRequest<IPD141147RsParam> entity) {
        IPD141147RsParam param = entity.getParam();
        if (null != param) {
            this.validatorRequired("产品一级分类编码",param.getClassesCode());
            this.validatorRequired("产品二级分类编码",param.getMachiningCode());
            this.validatorRequired("产品品种编码",param.getBreedCode());
            this.validatorRequired("产品特征编码",param.getFeatureCode());
            this.validatorRequired("产品净重编码",param.getWeightCode());
            this.validatorRequired("等级编码",param.getGradeCode());
        }
    }
}
