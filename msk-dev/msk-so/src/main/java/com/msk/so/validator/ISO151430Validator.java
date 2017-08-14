package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151430RsParam;

/**
 * ISO151423Validator.
 *
 * @author zhang_qiang1
 */
public class ISO151430Validator extends BaseValidator<RsRequest<ISO151430RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151430RsParam> request) {
             ISO151430RsParam iso151430RsParam=request.getParam();
            this.validatorRequired("参数不能为空",iso151430RsParam);
            if(iso151430RsParam==null){
            this.validatorRequired("卖家编码", iso151430RsParam.getSlCode());
            this.validatorRequired("物流区编码", iso151430RsParam.getLgcsCode());
           }
    }
}
