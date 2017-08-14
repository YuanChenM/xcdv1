package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.utils.StringUtil;
import com.msk.sl.bean.*;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by gyh on 2016/2/29.
 */
public class ISL231109Validator extends BaseValidator<RsRequest<ISL231109RsParam>> {

    @Override
    public void validatorData(RsRequest<ISL231109RsParam> entity) {
        ISL231109RsParam isl231109RsParam = entity.getParam();
        if (null != isl231109RsParam) {
            this.validatorRequired("卖家编码", isl231109RsParam.getSlCode());
        }
    }
}
