package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.ISO151427RsParam;

/**
 * Created by wang_shuai on 2016/6/23.
 */
public class ISO151427Validator extends BaseValidator<RsRequest<ISO151427RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151427RsParam> request) {
        ISO151427RsParam iso151427RsParam=request.getParam();
        this.validatorRequired("参数不能为空",iso151427RsParam);
        if(iso151427RsParam != null){
            this.validatorRequired("结算详情状态", iso151427RsParam.getSettlementStatus());
            this.validatorRequired("配送单", iso151427RsParam.getDeliverList());
            this.validatorRequired("退货单", iso151427RsParam.getReturnList());

        }
    }
}
