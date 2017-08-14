package com.msk.so.logic.order.buyer;

import com.msk.common.logic.CommonLogic;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.entity.SoStockSl;
import com.msk.core.utils.StringUtil;
import com.msk.so.bean.BaseStockBean;
import com.msk.so.bean.order.BaseOrderDetailParam;
import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.logic.order.ThirdPartyCommon;
import com.msk.so.logic.order.buyer.BaseBuyerSaleOrder;
import com.msk.so.utils.BuyerStockHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * *ThirdPartyBuyersOrder
 * *@author jiang_nan
 * *@version 1.0
 **/
public class ThirdPartyBuyersOrder extends BaseBuyerSaleOrder {
    @Autowired
    private CommonLogic commonLogic;
    @Override
    @Transactional
    public  Map<String,BaseOrderParam> createOrder(BaseOrderParam param) {
        List<BaseOrderDetailParam> productList = param.getProducts();
        List<String> buyerIdArray = this.findBuyerIdList(param.getBuyersId());
        //获得买手所有的总库存
        super.lgcsCode = param.getDistrictCode();
        if(param.getOrderSource() == NumberConst.IntDef.INT_TWO){
            super.supplyPlatform = NumberConst.IntDef.INT_TWO;
        }else {
            super.supplyPlatform = NumberConst.IntDef.INT_ONE;
        }
        List<SoStockSl> sellerStockList = this.findBuyerStock(buyerIdArray);
        //定义买手订单对应情况
        Map<String,BaseOrderParam> orderListMap = new HashMap<>();
        for(BaseOrderDetailParam orderDetailParam : productList){
            String productCode = orderDetailParam.getPdCode();
            //订单数量
            BigDecimal orderQty = orderDetailParam.getOrderQty();
            //产品单价
            BigDecimal orderPrice = orderDetailParam.getOrderPrice();
            //订单总金额
            BigDecimal orderAmount = new BigDecimal(0);
            orderAmount = orderAmount.add(orderPrice.multiply(orderQty));

            String sellerId = BuyerStockHandle.getProductBuyerId(productCode,orderQty,sellerStockList);
            //获得订单Map中是否已经包含了该卖家的订单
            BaseOrderParam order = this.createSellerOrder(sellerId,orderListMap);
            //订单总金额
            order.setOrderAmount(orderAmount);

            BaseOrderDetailParam orderDetail = this.createSellerOrderDetail(orderDetailParam,order);
            if(!StringUtil.isEmpty(sellerId)){
                //卖家对应的供应商库存
                List<BaseStockBean> sellerSupplierStock = this.findBuyerSupplierStock(sellerId);
                List<SoOrderDetailAvailability> orderDetailAvailabilityList = BuyerStockHandle.splitOrderDetail(orderQty,productCode,sellerSupplierStock);
                orderDetail.setOrderDetailAvailabilityList(orderDetailAvailabilityList);
            }else{
                ThirdPartyCommon thirdPartyCommon = new ThirdPartyCommon(commonLogic);
                List<BaseOrderDetailParam> orderDetailParamList = new ArrayList<>();
                orderDetailParamList.add(orderDetail);
                List<SoOrderDetailAvailability> orderDetailAvailabilityList = thirdPartyCommon.createOrderDetailAvailability(orderDetailParamList);
                orderDetail.setOrderDetailAvailabilityList(orderDetailAvailabilityList);
            }
        }
        return orderListMap;
    }

}
