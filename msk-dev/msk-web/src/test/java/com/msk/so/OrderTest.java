/*
package com.msk.so;

import com.msk.BaseTest;
import com.msk.common.consts.OrderConst;
import com.msk.so.bean.order.BaseOrderDetailParam;
import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.order.BaseOrder;
import com.msk.so.order.OrderBuilder;
import com.msk.so.order.OrderFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * *OrderTest
 * *@author jiang_nan
 * *@version 1.0
 **//*

public class OrderTest extends BaseTest{
    @Autowired
    private OrderFactory orderFactory;
    //@Test
    public void testCreateOrder(){
        orderFactory.createOrder(OrderConst.OrderType.DISTRIBUTION_ORDER);
    }
    @Test
    public void testDistributionOrder(){
        BaseOrder<BaseOrderParam> order = this.orderFactory.createOrder(OrderConst.OrderType.DISTRIBUTION_ORDER);
        BaseOrderParam orderParam = new BaseOrderParam();
        orderParam.setDistrictCode("01");
        orderParam.setBuyersId("01");
        orderParam.setBuyersCode("01");
        orderParam.setBuyersName("01");
        orderParam.setBuyersType("1");
        orderParam.setSellerCode("01");
        orderParam.setSellerName("01");
        orderParam.setNeedInvoice("1");
        orderParam.setOrderAmount(new BigDecimal(2000));
        orderParam.setOrderType(OrderConst.OrderType.DISTRIBUTION_ORDER);
        orderParam.setPaymentType(OrderConst.PaymentType.PAYING_ONLINE);

        List<BaseOrderDetailParam> orderDetailParamList = new ArrayList<BaseOrderDetailParam>();
        BaseOrderDetailParam orderDetailParam = new BaseOrderDetailParam();
        orderDetailParam.setPdCode("010101010101");
        orderDetailParam.setPdName("鸡肉");
        orderDetailParam.setPdPrice(new BigDecimal(100));
        orderDetailParam.setPriceCycle(1);
        orderDetailParam.setAgreeJoint("1");
        orderParam.setProducts(orderDetailParamList);
        order.doOperate(orderParam);
    }
}
*/
