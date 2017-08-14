package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO251409RsParam;

/**
 * 
 * ISO251409Validator.
 * @author pxg
 */
public class ISO251409Validator extends BaseValidator<RsRequest<ISO251409RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO251409RsParam> request) {
        ISO251409RsParam iSO251409RsParam = request.getParam();
        // #59 add by sjj 20160718 start
        if (null != iSO251409RsParam) {
            // this.validatorBetween(StringUtil.toBigDecimal(iSO251409RsParam.getBuyersId()),StringUtil.toBigDecimal(NumberConst.IntDef.INT_TWENTY), StringUtil.toBigDecimal(NumberConst.IntDef.INT_ONE), "买家ID",true);
        if (iSO251409RsParam.getReturnList().size() > 0) {
            for (int i = 0; i < iSO251409RsParam.getReturnList().size(); i++) {
                if (StringUtil.isNullOrEmpty(iSO251409RsParam.getReturnList().get(i).getReturnCode())) {
                    this.validatorRequired("退货单ID", iSO251409RsParam.getReturnList().get(i).getReturnId());
                } else {
                    this.validatorRequired("退货单编码", iSO251409RsParam.getReturnList().get(i).getReturnCode());
                }
            }
        }
    }
    // #59 add by sjj 20160718 end
    }
}
