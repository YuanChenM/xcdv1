package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO151417RsParam;
import com.msk.so.bean.ISO151417RsProductParam;
import org.apache.commons.collections.CollectionUtils;

/**
 * Created by liutao on 2016/10/11.
 */
public class ISO151417Validator extends BaseValidator<RsRequest<ISO151417RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151417RsParam> request) {
        ISO151417RsParam param = request.getParam();
        this.validatorRequired("业务参数", param);
        if(null != param){
            this.validatorRequired("用户ID", param.getUserId());
            this.validatorRequired("评价时间", param.getEvaluateDate());
            this.validatorRequired("订单ID", param.getOrderId());
            if(!CollectionUtils.isEmpty(param.getProducts())){
                for (int i = 1 ; i < param.getProducts().size() + 1 ; i++){
                    ISO151417RsProductParam productParam = param.getProducts().get(i-1);
                    this.validatorRequired(i, "产品编码", productParam.getPdCode());
                    this.validatorRequired(i, "评价描述", productParam.getEvaluateDesc());
                    this.validatorRequired(i, "评分", productParam.getScore());
                }
            }else {
                this.validatorRequired("产品列表", null);
            }
        }


    }
}
