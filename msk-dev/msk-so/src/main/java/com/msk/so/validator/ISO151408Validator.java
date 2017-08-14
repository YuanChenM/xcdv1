package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.ISO151408RsParam;
import com.msk.so.bean.ISO151408RsProductListParam;
import com.msk.so.bean.ISO151408RsShipListParam;
import org.apache.commons.collections.CollectionUtils;

/**
 * 
 * ISO151408Validator.
 *
 * @author sjj
 */
public class ISO151408Validator extends BaseValidator<RsRequest<ISO151408RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO151408RsParam> request) {
        ISO151408RsParam iSO151408RsParam = request.getParam();
        if (null != iSO151408RsParam) {
            this.validatorRequired("订单ID", iSO151408RsParam.getOrderId());
            this.validatorRequired("退货模式", iSO151408RsParam.getReturnMode());
            this.validatorRequired("申请人名称", iSO151408RsParam.getApplyMan());
            this.validatorRequired("申请时间", iSO151408RsParam.getApplyTime());
            this.validatorRequired("退货原因ID", iSO151408RsParam.getReturnReasonID());
            this.validatorRequired("退货原因名称", iSO151408RsParam.getReturnReasonName());
            this.validatorRequired("买家ID", iSO151408RsParam.getBuyerId());
            this.validatorRequired("买家编码", iSO151408RsParam.getBuyerCode());
            this.validatorRequired("是否已付款", iSO151408RsParam.getIsPaid());
        }
        if (iSO151408RsParam.getReturnMode() != NumberConst.IntDef.INT_ONE){
            if (CollectionUtils.isNotEmpty(iSO151408RsParam.getShipList())) {
                for (int i = 1; i < iSO151408RsParam.getShipList().size()+1; i++) {
                    ISO151408RsShipListParam param = iSO151408RsParam.getShipList().get(i-1);
                    this.validatorRequired(i, "发货单号ID", param.getShipId());
                    if (CollectionUtils.isNotEmpty(param.getProductList())) {
                        for (int j = 1; j < param.getProductList().size()+1; j++) {
                            ISO151408RsProductListParam proParam = param.getProductList().get(j-1);
                            this.validatorRequired(j, "发货明细ID", proParam.getShipDetailId());
                            this.validatorRequired(j, "供应商编码", proParam.getSupplierCode());
                            this.validatorRequired(j, "产品编码", proParam.getPdCode());
                            this.validatorRequired(j, "SKU编码", proParam.getSkuCode());
                            this.validatorRequired(j, "退货数量", proParam.getReturnQty());
                        }
                    } else {
                        this.validatorRequired("产品信息列表", null);
                    }
                }
            } else{
                this.validatorRequired("发货明细列表", null);
            }
        }
    }
}
