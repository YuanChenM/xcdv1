package com.msk.so.validator;

import java.util.List;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.entity.SoOrderDetail;
import com.msk.so.bean.ISO251402RsParam;

/**
 * 
 * ISO251402Validator.
 *
 * @author pxg
 */
public class ISO251402Validator extends BaseValidator<RsRequest<ISO251402RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO251402RsParam> request) {
        ISO251402RsParam distriButionOrder = request.getParam();
        if (null != distriButionOrder) {
            this.validatorRequired("购物需求订单ID", distriButionOrder.getProCode());
            this.validatorRequired("订单区域编码", distriButionOrder.getDistrictCode());
            this.validatorRequired("买家ID",distriButionOrder.getBuyersId());
            this.validatorRequired("买家编码", distriButionOrder.getBuyersCode());
            this.validatorRequired("买家名称", distriButionOrder.getBuyersName());
            this.validatorRequired("卖家编码", distriButionOrder.getSellerCode());
            this.validatorRequired("卖家名称", distriButionOrder.getSellerName());
            this.validatorRequired("订单总金额", distriButionOrder.getOrderAmount());
            this.validatorRequired("订单类型", distriButionOrder.getOrderType());
            this.validatorRequired("付款类型", distriButionOrder.getPaymentType());
            this.validatorRequired("收货人名称", distriButionOrder.getReceiverInfo().getReceiverName());
            this.validatorRequired("收货人电话", distriButionOrder.getReceiverInfo().getReceiverTel());
            this.validatorRequired("收货地址省份", distriButionOrder.getReceiverInfo().getReceiverProvince());
            this.validatorRequired("收货地址市", distriButionOrder.getReceiverInfo().getReceiverCity());
            this.validatorRequired("收货地址区", distriButionOrder.getReceiverInfo().getReceiverDistrict());
            this.validatorRequired("收货人详细地址", distriButionOrder.getReceiverInfo().getReceiverAddr());
            List<SoOrderDetail> list = distriButionOrder.getProducts();
            for (int i = 0; i < list.size(); i++) {
                SoOrderDetail soOrderDetail = list.get(i);
                this.validatorRequired("产品编码", soOrderDetail.getPdCode());
                this.validatorRequired("产品名称", soOrderDetail.getPdName());
                this.validatorRequired("订单价格", soOrderDetail.getPdPrice());
                this.validatorRequired("订单等级", soOrderDetail.getOrderDetailLevel());
                this.validatorRequired("订单数量", soOrderDetail.getOrderQty());
            }
        }
    }
}
