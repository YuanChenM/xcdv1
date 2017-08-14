package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO251413OrderShipInfoRsParam;
import com.msk.so.bean.ISO251413OrderShipProductRsParam;
import com.msk.so.bean.ISO251413RsParam;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 三合一 订单收货接口输入参数 验证
 */

public class ISO251413Validator extends BaseValidator<RsRequest<ISO251413RsParam>> {

    @Override
    public void validatorData(RsRequest<ISO251413RsParam> request) {
        ISO251413RsParam param = request.getParam();
        if (null != param) {
            Long shipId = param.getShipId();
            this.validatorRequired("发货单ID不能为空", shipId);
            Integer isPaid = param.getIsPaid();
            this.validatorRequired("是否已付款", isPaid);
            List<ISO251413OrderShipInfoRsParam> shipList = param.getShipList();
            this.validatorRequired("shiList", shipList);
            if (shipList != null && shipList.size() > 0) {
                int rowNum = 1;
                for (ISO251413OrderShipInfoRsParam shipInfo : shipList) {
                    String deliverCode = shipInfo.getDeliverCode();
                    this.validatorMaxLength(deliverCode, 50, "ShipList 中第" + rowNum + "个ship中,WMS配送单号", true);

                    String actualReceiveDate = shipInfo.getActualReceiveDate();//  时间格式待定
                    this.validatorRequired("实际收货时间（YYYY-MM-DD ）", actualReceiveDate);
                    if (!StringUtil.isEmpty(actualReceiveDate)) {
                        Date adjustTime = DateTimeUtil.parseDate(actualReceiveDate, "yyyy-MM-dd");
                        if (adjustTime == null) {
                            throw new BusinessException("实际收货时间 格式为：YYYY-MM-DD");
                        }
                    }
                    List<ISO251413OrderShipProductRsParam> productList = shipInfo.getProductList();
                    this.validatorRequired("productList 不能为空", productList);
                    if (productList != null && productList.size() > 0) {
                        int index = 1;
                        for (ISO251413OrderShipProductRsParam product : productList) {
                            Long shipDetailId = product.getShipDetailId();
                            this.validatorRequired("ShipList 中第" + rowNum + "个ship中" + " 第" + index + "个 product 中的发货明细ID", shipDetailId);

                            String skuCode = product.getSkuCode();
                            this.validatorBetween(new BigDecimal(skuCode == null ? 0 : skuCode.length()), new BigDecimal(50), new BigDecimal(12), "ShipList 中第" + rowNum + "个ship中" + " 第" + index + "个 product 中的skuCode", true);

                            BigDecimal   receivePrice=product.getReceivePrice();
                            this.validatorRequired("ShipList 中第" + rowNum + "个ship中" + " 第" + index + "个 product 中的收货产品对应的单价", receivePrice);
                            index++;
                        }
                    }
                    rowNum++;
                }
            }
        }
    }
}
