package com.msk.sl.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.sl.bean.ISL231101RsParam;
import com.msk.sl.bean.ISL231118RsParam;

/**
 * Created by gyh on 2016/1/14.
 */
public class ISL231118Validator extends BaseValidator<RsRequest<ISL231118RsParam>>{
    @Override
    public void validatorData(RsRequest<ISL231118RsParam> entity) {
        ISL231118RsParam isl231118RsParam=entity.getParam();
        this.validatorRequired("接口参数",isl231118RsParam);
        this.validatorRequired("卖家编码",isl231118RsParam.getSlCode());
    }
}
