package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.so.bean.HouseAccountBean;
import com.msk.so.bean.ISO151406RsParam;
import org.apache.commons.collections.CollectionUtils;

/**
 * ISO151406Validator.
 *
 * @author sjj
 */
public class ISO151406Validator extends BaseValidator<RsRequest<ISO151406RsParam>> {
    @Override
    public void validatorData(RsRequest<ISO151406RsParam> request) {
        ISO151406RsParam param = request.getParam();
        if (null != param) {
            if (CollectionUtils.isNotEmpty(param.getHouseAccountList())) {
                for (HouseAccountBean bean : param.getHouseAccountList()) {
                    this.validatorRequired("管家ID", bean.getHouseCode());
                    this.validatorRequired("销售月份", bean.getSaleMonth());
                }
            } else {
                this.validatorRequired("参数列表", null);
            }
        }
    }
}
