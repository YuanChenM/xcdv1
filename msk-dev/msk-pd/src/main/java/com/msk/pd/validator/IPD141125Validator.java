package com.msk.pd.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.pd.bean.IPD141125RsParam;

/**
 * Created by air on 2016/3/11.
 */
public class IPD141125Validator extends BaseValidator<RsRequest<IPD141125RsParam>> {
@Override
public void validatorData(RsRequest<IPD141125RsParam> entity) {
        IPD141125RsParam param = entity.getParam();
        if (null != param) {
        this.validatorRequired("类别编码", param.getClassesCode());
        this.validatorRequired("二级分类编码", param.getMachiningCode());
        this.validatorRequired("品种编码",param.getBreedCode());
        }
        }
        }
