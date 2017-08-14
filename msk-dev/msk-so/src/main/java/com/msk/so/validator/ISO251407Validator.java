package com.msk.so.validator;

import com.msk.common.consts.StatusConst;
import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO251407RsParam;

/**
 * ISO251407Validator.
 *
 * @author pxg
 */
public class ISO251407Validator extends BaseValidator<RsRequest<ISO251407RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO251407RsParam> request) {
        ISO251407RsParam param = request.getParam();
        if (null != param) {
            if (StringUtil.isNullOrEmpty(param.getOrderCode())) {
                this.validatorRequired("订单ID", param.getOrderId());
            }else if(NumberConst.IntDef.INT_ZERO > param.getOrderId()){
                this.validatorRequired("订单编码", param.getOrderCode());
            }
            if (false) {
                this.validatorRequired("支付时间", param.getPaidTime());
                this.validatorRequired("支付金额", param.getPaidAmount());
                this.validatorRequired("支付方式", param.getPaymentType());
                this.validatorRequired("支付流水号", param.getPaidSeq());
                this.validatorRequired("订单版本号", param.getVer());
            }
            this.validatorRequired("操作类型", param.getOrderStatus());
            if (StatusConst.OrderStatusDef.ALL_RECEIPT == param.getOrderStatus()) {
                this.validatorRequired("收货人", param.getReceiver());
                this.validatorRequired("收货时间", param.getReceiveTime());
                this.validatorRequired("配送顺序", param.getDeliverySeq());
            }
        }
    }
}
