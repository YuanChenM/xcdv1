package com.msk.so.validator;

import java.util.List;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.consts.NumberConst;
import com.msk.so.bean.ISO251401RsParam;
import com.msk.so.bean.ISO251401RsProduct;
import org.springframework.util.CollectionUtils;

/**
 * 
 * ISO251401Validator.校验
 * 
 * @author gyh
 */
public class ISO251401Validator extends BaseValidator<RsRequest<ISO251401RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO251401RsParam> request) {
        ISO251401RsParam iso251401RsParam = request.getParam();
        this.validatorRequired("业务参数", iso251401RsParam);
        if (iso251401RsParam != null) {
            List<ISO251401RsProduct> products = iso251401RsParam.getProducts();
            this.validatorMaxLength(iso251401RsParam.getDistrictCode(), NumberConst.IntDef.INT_SIX, "订单区域编码", true);
            this.validatorRequired("买家编码", iso251401RsParam.getBuyersCode());
            this.validatorRequired("买家名称", iso251401RsParam.getBuyersName());
            this.validatorRequired("卖家编码", iso251401RsParam.getSellerCode());
            this.validatorRequired("卖家名称", iso251401RsParam.getSellerName());
            this.validatorRequired("产品列表", products);
            int rowNum = 0;
            if(!CollectionUtils.isEmpty(products)){
                for (ISO251401RsProduct iso251401RsProduct : products) {
                    rowNum++;
                    this.validatorRequired(rowNum, "产品编码", iso251401RsProduct.getPdCode());
                    this.validatorRequired(rowNum, "产品名称", iso251401RsProduct.getPdName());
                }
            }

        }
    }

}
