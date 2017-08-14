package com.msk.so.validator;

import com.msk.core.base.BaseValidator;
import com.msk.core.bean.RsRequest;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.ISO251413OrderShipInfoRsParam;
import com.msk.so.bean.ISO251413OrderShipProductRsParam;
import com.msk.so.bean.ISO251413RsParam;
import com.msk.so.bean.order.OrderDeliverParam;
import com.msk.so.bean.order.OrderShipInfo;
import com.msk.so.bean.order.OrderShipProductInfo;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单发货操作入参  验证
 */

public class ISO151415partDeliverValidator extends BaseValidator<RsRequest<OrderDeliverParam>> {

    @Override
    public void validatorData(RsRequest<OrderDeliverParam> request) {
        OrderDeliverParam param = request.getParam();
   /*     Integer ver = param.getVer();
        this.validatorRequired("ver", ver);
        Long shipId = param.getShipId();
        this.validatorRequired("shipId", shipId);*/
        List<OrderShipInfo> shipList = param.getShipList();
        if (CollectionUtils.isEmpty(shipList) || shipList.size() == 0) {
            this.validatorRequired("shipList", null);
        } else {
            int shipIndex = 1;
            for (OrderShipInfo shipInfo : shipList) {
                String deliverCode = shipInfo.getDeliverCode();
                this.validatorRequired("第" + shipIndex + "个配送单中的配送编码：deliverCode", deliverCode);  //delivercode
             /*   List<OrderShipProductInfo> productList = shipInfo.getProductList();
                this.checkShipProductInfo(shipIndex, productList);*/
                shipIndex++;
            }
        }
    }


    /**
     * 验证配送单产品
     *
     * @param shipIndex
     * @param productList
     */
    private void checkShipProductInfo(int shipIndex, List<OrderShipProductInfo> productList) {
        if (CollectionUtils.isEmpty(productList) || productList.size() == 0) {
            this.validatorRequired("productList", null);
        } else {
            int productIndex = 1;
            for (OrderShipProductInfo shipProductInfo : productList) {
                Long shipDetailId = shipProductInfo.getShipDetailId();
                this.validatorRequired("第" + shipIndex + "个配送单中第" + productIndex + "个产品中：shipDetailId", shipDetailId);
                String skuCode = shipProductInfo.getSkuCode();
                this.validatorBetween(new BigDecimal(skuCode == null ? 0 : skuCode.length()), new BigDecimal(50), new BigDecimal(12), "第" + shipIndex + "个配送单中第" + productIndex + "个产品中：skuCode", true);
                BigDecimal sendQty = shipProductInfo.getSendQty();
                this.validatorRequired("第" + shipIndex + "个配送单中第" + productIndex + "个产品中：sendQty", sendQty);
                if(sendQty!=null){
                    if(DecimalUtil.isLess(sendQty,new BigDecimal(0))){
                      throw  new BusinessException("第" + shipIndex + "个配送单中第" + productIndex + "个产品中：sendQty"+sendQty +"  不能小于0");
                    }
                }
                productIndex++;
            }
        }
    }

}
