package com.msk.so.logic.order.buyer;

import com.msk.bs.logic.BuyerShopLogic;
import com.msk.core.entity.SoStockSl;
import com.msk.so.bean.BaseStockBean;
import com.msk.so.bean.StockParam;
import com.msk.so.bean.order.BaseOrderDetailParam;
import com.msk.so.bean.order.BaseOrderParam;
import com.msk.so.logic.StockLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 买手销售订单
 * *@author jiang_nan
 * *@version 1.0
 **/
public abstract class BaseBuyerSaleOrder {
    protected int supplyPlatform;
    protected String lgcsCode;
    //测试情况
    private static boolean isDebug = false;
    @Autowired
    private StockLogic stockLogic;
    @Autowired
    private BuyerShopLogic buyerLogic;
    /**
     * 根据买家编号判断是否有买手信息
     * @param buyersId 买家ID
     * @return 是否有买手
     */
    public boolean haveBuyer(String buyersId){
        if(isDebug){
            return true;
        }
        return !CollectionUtils.isEmpty(this.findBuyerIdList(buyersId));
    }

    /**
     * 获得买手编号列表
     * @param buyersId 买家编号
     * @return 买手编号列表
     */
    public List<String> findBuyerIdList(String buyersId){
        if(isDebug){
            List<String> buyersIdList = new ArrayList<>();
            buyersIdList.add("01");
            buyersIdList.add("02");
            buyersIdList.add("03");
            return buyersIdList;
        }
        return buyerLogic.findSellerByBuyersId(buyersId);
    }
    /**
     * 获得买手所有产品的总库存
     * @param buyersId 买家编号
     * @return 买手总库存
     */
    public List<SoStockSl> findBuyerStock(List<String> buyersId){
        if(isDebug){
            List<SoStockSl> stockList = new ArrayList<>();
            SoStockSl stockBean = new SoStockSl();
            stockBean.setSlCode("01");
            stockBean.setPdCode("010101010101");
            stockBean.setStockQty(new BigDecimal(200));
            stockList.add(stockBean);
            return stockList;
        }
        List<SoStockSl> stockList = new ArrayList<>();
        StockParam param = new StockParam();
        param.setLgcsCode(this.lgcsCode);
        param.setSupplyPlatform(this.supplyPlatform);
        for (String sellerCode : buyersId){
            param.setSlCode(sellerCode);
            List<SoStockSl> stockBeenList = stockLogic.findSellerStock(param);
            stockList.addAll(stockBeenList);
        }
        return stockList;
    }

    /**
     * 获得买手供应级别的库存信息
     * @param buyersId 买家编号
     * @return 买手供应商级别库存
     */
    public List<BaseStockBean> findBuyerSupplierStock(String buyersId){
        if(isDebug){
            List<BaseStockBean> stockList = new ArrayList<>();
            BaseStockBean stockBean = new BaseStockBean();
            stockBean.setSellerCode("01");
            stockBean.setSupplierCode("01");
            stockBean.setProductCode("010101010101");
            stockBean.setStockQty(new BigDecimal(100));
            stockList.add(stockBean);
            BaseStockBean stockBean1 = new BaseStockBean();
            stockBean1.setSellerCode("01");
            stockBean1.setSupplierCode("01");
            stockBean1.setProductCode("010101010101");
            stockBean1.setStockQty(new BigDecimal(100));
            stockList.add(stockBean1);
            return stockList;
        }
        StockParam param = new StockParam();
        param.setLgcsCode(this.lgcsCode);
        param.setSupplyPlatform(this.supplyPlatform);
        param.setSlCode(buyersId);
        return this.stockLogic.findSellerSupplierStock(param);
    }

    /**
     * 进行
     * @param param
     * @return
     */
    public abstract  Map<String,BaseOrderParam> createOrder(BaseOrderParam param);
    public BaseOrderParam createSellerOrder(String sellerCode,Map<String,BaseOrderParam> orderListMap){
        //获得订单Map中是否已经包含了该卖家的订单
        BaseOrderParam order = orderListMap.get(sellerCode);
        if(null==order){
            order = new BaseOrderParam();
            order.setSellerCode(sellerCode);
            orderListMap.put(sellerCode,order);
        }
        return order;
    }
    public BaseOrderDetailParam createSellerOrderDetail(BaseOrderDetailParam orderDetail, BaseOrderParam order){
        List<BaseOrderDetailParam> orderDetailList = order.getProducts();
        if(CollectionUtils.isEmpty(orderDetailList)){
            orderDetailList = new ArrayList<>();
            order.setProducts(orderDetailList);
        }
        BaseOrderDetailParam cloneOrderDetail = orderDetail.cloneOrderDetail();
        orderDetailList.add(cloneOrderDetail);
        return cloneOrderDetail;
    }
}
