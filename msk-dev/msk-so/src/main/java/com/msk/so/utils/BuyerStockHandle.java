package com.msk.so.utils;

import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrderDetailAvailability;
import com.msk.core.entity.SoStockSl;
import com.msk.core.utils.DecimalUtil;
import com.msk.so.bean.BaseStockBean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * *BuyerStockHandle
 * *@author jiang_nan
 * *@version 1.0
 **/
public class BuyerStockHandle {
    /**
     * 获得订单中产品对应的买手ID
     * @param productCode 产品编号
     * @param orderQty 订单数量
     * @param stockList 买手对应的库存信息
     * @return 买手编号
     */
    public static String getProductBuyerId(String productCode, BigDecimal orderQty, List<SoStockSl> stockList){
        for(SoStockSl stock : stockList){
            if(stock.getPdCode().equals(productCode)){
                if(stock.getStockQty().compareTo(orderQty)>= NumberConst.IntDef.INT_ZERO){
                    return stock.getSlCode();
                }
            }
        }
        return null;
    }
    public static List<SoOrderDetailAvailability> splitOrderDetail(BigDecimal orderQty,String productCode,List<BaseStockBean> stockList){
        List<SoOrderDetailAvailability> orderDetailAvailabilityParamList = new ArrayList<>();
        for (BaseStockBean stock : stockList){
            if(stock.getProductCode().equals(productCode)){
                if(orderQty.compareTo(BigDecimal.ZERO)> NumberConst.IntDef.INT_ZERO){
                    BigDecimal stockQty = stock.getStockQty();
                    SoOrderDetailAvailability orderDetailAvailabilityParam = new SoOrderDetailAvailability();
                    //供应商Code
                    orderDetailAvailabilityParam.setSupplierCode(stock.getSupplierCode());
                    orderDetailAvailabilityParam.setSupplierName(stock.getSupplierName());
                    //产品Code
                    orderDetailAvailabilityParam.setPdCode(stock.getProductCode());
                    //判断库存是否足
                    if(orderQty.compareTo(stockQty)> NumberConst.IntDef.INT_ZERO){
                        orderDetailAvailabilityParam.setSuppQty(stockQty);
                        orderQty = DecimalUtil.subtract(orderQty,stockQty);
                    }else{
                        orderDetailAvailabilityParam.setSuppQty(orderQty);
                        orderQty = BigDecimal.ZERO;
                    }
                    orderDetailAvailabilityParamList.add(orderDetailAvailabilityParam);
                }else{
                    break;
                }
            }
        }
        return orderDetailAvailabilityParamList;
    }
}
