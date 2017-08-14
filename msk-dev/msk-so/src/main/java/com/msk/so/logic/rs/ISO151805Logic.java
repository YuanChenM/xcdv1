package com.msk.so.logic.rs;

import com.alibaba.fastjson.TypeReference;
import com.msk.common.logic.CommonLogic;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.consts.StringConst;
import com.msk.core.entity.SlPdArtno;
import com.msk.core.entity.SoOrderDetailPrice;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DecimalUtil;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.utils.RestClientUtil;
import com.msk.so.bean.*;
import com.msk.so.logic.OrderLogic;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liutao on 2016/10/18.
 */
@Service
public class ISO151805Logic extends BaseLogic {
    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }

    @Autowired
    private CommonLogic commonLogic;

    @Autowired
    private OrderLogic orderLogic;

    /**
     * 订单明细及价盘通道查询接口查询
     * @param request
     * @return
     */
    @Transactional
    public ISO151805RsBeanResult searchOrderDetailPrice(RsRequest<ISO151805RsParam> request){
        ISO151805RsParam param = request.getParam();
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        ISO151805RsResult result = new ISO151805RsResult();
        List<ISO151805RsOrderListResult> orderList = super.findList(SqlId.SQL_ID_GET_ORDER_INFO_BY_SHIP_ID,param);
        if(CollectionUtils.isEmpty(orderList)){
            throw new BusinessException("发货单没有对应的订单信息");
        }
        for (ISO151805RsOrderListResult orderResult : orderList){
            BaseParam orderParam = new BaseParam();
            orderParam.setFilter("orderId", String.valueOf(orderResult.getOrderId()));
            List<ISO151805RsOrderDetailsResult> orderDetails = super.findList(SqlId.SQL_ID_GET_ORDER_DETAIL_INFO_BY_ORDER_ID,orderParam);
            List<ISO151805RsOrderDetailsResult> orderDetailList = super.findList(SqlId.SQL_ID_GET_ORDER_DETAIL_LIST_BY_ORDER_ID,orderParam);
            if(CollectionUtils.isEmpty(orderDetails)){
                throw new BusinessException("订单号为:" + orderResult.getOrderId() + ",订单明细不能为空");
            }
            //查询价盘信息
            ISO151805RsPriceResult priceResult = getPriceInfoByPdCodes(orderDetailList);
            for (ISO151805RsOrderDetailsResult orderDetail : orderDetails){
                getSkuCode(orderDetail);
                List<ISO151805RsOrderPricesResult> priceList = getPriceList(orderDetail,priceResult);
                saveOrderDetailPrice(priceList,orderDetail,request,orderResult);
                orderDetail.setPriceList(priceList);
            }
            dealExcessDetail(orderDetails);
            orderResult.setOrderDetail(orderDetails);
        }
        result.setOrderList(orderList);
        //处理并返回新的结果集
        //Modify by wang_jianzhou for bug#3818 at 2016/12/06 Start.
        ISO151805RsBeanResult newResult = dealNewResult(result);
        return newResult;
        //Modify by wang_jianzhou for bug#3818 at 2016/12/06 end.
    }

    /**
     * 新增或者保存价盘信息
     * @param priceList
     * @param orderDetail
     * @param request
     * @param orderResult
     */
    @Transactional
    public void saveOrderDetailPrice(List<ISO151805RsOrderPricesResult> priceList,ISO151805RsOrderDetailsResult orderDetail,RsRequest<ISO151805RsParam> request,ISO151805RsOrderListResult orderResult){
        for (ISO151805RsOrderPricesResult pricesResult : priceList){
            SoOrderDetailPrice soOrderDetailPrice = new SoOrderDetailPrice();
            soOrderDetailPrice.setPriceSn(commonLogic.maxId("so_order_detail_price","PRICE_SN"));
            soOrderDetailPrice.setSiteCode(request.getSiteCode());
            soOrderDetailPrice.setLoginAuth(request.getAuth());
            soOrderDetailPrice.setLoginId(request.getLoginId());
            soOrderDetailPrice.setQueryTime(request.getParam().getCrtTime());
            soOrderDetailPrice.setShipId(orderResult.getShipId());
            soOrderDetailPrice.setOrderId(orderResult.getOrderId());
            soOrderDetailPrice.setPaymentId(NumberConst.IntDef.INT_ONE);
            soOrderDetailPrice.setOrderDetailId(orderDetail.getDetailId());
            soOrderDetailPrice.setProDate(DateTimeUtil.parseDate(orderDetail.getProDate(),DateTimeUtil.FORMAT_DATE_YYYYMMDD));
            soOrderDetailPrice.setPdCode(orderDetail.getPdCode());
            soOrderDetailPrice.setSkuCode(orderDetail.getSkuCode());
            soOrderDetailPrice.setOrderLevel(pricesResult.getOrderLevel());
            soOrderDetailPrice.setLevelStart(pricesResult.getLevelStart());
            soOrderDetailPrice.setLevelEnd(pricesResult.getLevelEnd());
            soOrderDetailPrice.setLevelPrice(pricesResult.getLevelPrice());
            soOrderDetailPrice.setOrderQty(orderDetail.getOrderQty());

            int count = super.getCount(SqlId.SQL_ID_GET_ORDER_DETAIL_PRICE_COUNT,soOrderDetailPrice);
            if(count > 0){
                super.modify(soOrderDetailPrice);
            }else {
                super.save(soOrderDetailPrice);
            }
        }
    }

    /**
     * 去除不需要返回的参数
     * @param orderDetails
     */
    @Transactional
    public void dealExcessDetail(List<ISO151805RsOrderDetailsResult> orderDetails){
        for (ISO151805RsOrderDetailsResult detailResult : orderDetails){
            detailResult.setDistrictCode(null);
            detailResult.setPriceCycle(null);
            detailResult.setOrderId(null);
        }
    }

    /**
     * 得到返回的价盘信息
     * @param orderDetail
     * @param priceResult
     * @return
     */
    @Transactional
    public List<ISO151805RsOrderPricesResult> getPriceList(ISO151805RsOrderDetailsResult orderDetail,ISO151805RsPriceResult priceResult){
        List<ISO151805RsOrderPricesResult> priceList = new ArrayList<>();
        List<ISO151805RsPriceProductResult> products = priceResult.getProductList();
        ISO151805RsPriceResult detailPriceResult = getPriceInfoByPdCode(orderDetail);
        for (ISO151805RsPriceProductResult product : products){
            if(checkProduct(orderDetail,product)){
                ISO151805RsOrderPricesResult price = dealOrderPriceResult(product);
                priceList.add(price);
            }
        }
        List<ISO151805RsOrderPricesResult> oldPriceList = new ArrayList<>();
        oldPriceList = getOrderPriceInfo(detailPriceResult);

        BigDecimal orderQty = orderDetail.getOrderQty();
        BigDecimal oldPrice = null;
        BigDecimal nowPrice = null;
        for (ISO151805RsOrderPricesResult orderPrice : oldPriceList){
            if (orderQty.intValue() <= orderPrice.getLevelEnd() && orderQty.intValue() >= orderPrice.getLevelStart()){
                oldPrice = orderPrice.getLevelPrice();
            }
        }
        for (ISO151805RsOrderPricesResult orderPrice : priceList){
            if (orderQty.intValue() <= orderPrice.getLevelEnd() && orderQty.intValue() >= orderPrice.getLevelStart()){
                nowPrice = orderPrice.getLevelPrice();
            }
        }
        if (DecimalUtil.isGreater(nowPrice, oldPrice)){
            return oldPriceList;
        }else {
            return priceList;
        }
    }

    /**
     * 判断这个订单在所在价盘周期的区间
     * @param detailPriceResult
     * @param orderDetail
     * @return
     */
    @Transactional
    public BigDecimal getOrderPrice(ISO151805RsPriceResult detailPriceResult,ISO151805RsOrderDetailsResult orderDetail){
        List<ISO151805RsPriceProductResult> productList = detailPriceResult.getProductList();
        for (ISO151805RsPriceProductResult priceProductResult : productList){
            if(orderDetail.getOrderQty().intValue() >= priceProductResult.getStartQty()
                    && orderDetail.getOrderQty().intValue() <= priceProductResult.getEndQty()){
                return priceProductResult.getPdBoxPrice();
            }
        }
        return BigDecimal.ZERO;
    }

    /**
     * 判断这个产品的价盘
     * @param orderDetail
     * @param product
     * @return
     */
    @Transactional
    public boolean checkProduct(ISO151805RsOrderDetailsResult orderDetail,ISO151805RsPriceProductResult product){
        return orderDetail.getPdCode().equals(product.getPdCode())
                && !product.getOrderLevel().equals(String.valueOf(NumberConst.IntDef.INT_ZERO));
    }

    /**
     * 遍历价盘返回值
     * @param product
     * @return
     */
    @Transactional
    public ISO151805RsOrderPricesResult dealOrderPriceResult(ISO151805RsPriceProductResult product){
        ISO151805RsOrderPricesResult price = new ISO151805RsOrderPricesResult();
        if(product.getOrderLevel().equals("1")){
            price.setLevelEnd(999999);
        }else {
            price.setLevelEnd(product.getEndQty());
        }
        price.setLevelStart(product.getStartQty());
        price.setOrderLevel(Integer.valueOf(product.getOrderLevel()));
        price.setLevelPrice(product.getPdBoxPrice());
        return price;
    }

    /**
     * 得到当前有效价盘周期结果
     * @param detailPriceResult
     * @return
     */
    @Transactional
    public List<ISO151805RsOrderPricesResult> getOrderPriceInfo(ISO151805RsPriceResult detailPriceResult){
        List<ISO151805RsPriceProductResult> productList = detailPriceResult.getProductList();
        List<ISO151805RsOrderPricesResult> priceList = new ArrayList<>();
        for (ISO151805RsPriceProductResult priceProductResult : productList){
            ISO151805RsOrderPricesResult orderPricesResult = dealOrderPriceResult(priceProductResult);
            priceList.add(orderPricesResult);
        }
        return priceList;
    }

    /**
     * 根据产品编码得到价盘信息
     * 单个产品
     * @param orderDetail
     * @return
     */
    @Transactional
    public ISO151805RsPriceResult getPriceInfoByPdCode(ISO151805RsOrderDetailsResult orderDetail){
        ISO151805RsPriceParam priceParam = new ISO151805RsPriceParam();
        List<ISO151805RsPriceProductParam> productList = new ArrayList<>();
        ISO151805RsPriceProductParam productParam = new ISO151805RsPriceProductParam();
        productParam.setPdCode(orderDetail.getPdCode());
        productParam.setLogiAreaCode(orderDetail.getDistrictCode());
        productList.add(productParam);
        priceParam.setPricePeriod(orderDetail.getPriceCycle());
        priceParam.setProductList(productList);
        ISO151805RsPriceResult result = getPriceRestClientResult(priceParam);
        return result;
    }

    /**
     * 根据产品编码得到价盘信息
     * 多个产品
     * @param orderDetails
     * @return
     */
    @Transactional
    public ISO151805RsPriceResult getPriceInfoByPdCodes(List<ISO151805RsOrderDetailsResult> orderDetails){
        ISO151805RsPriceParam priceParam = new ISO151805RsPriceParam();
        List<ISO151805RsPriceProductParam> productList = new ArrayList<>();
        for (ISO151805RsOrderDetailsResult detailResult : orderDetails){
            ISO151805RsPriceProductParam productParam = new ISO151805RsPriceProductParam();
            productParam.setPdCode(detailResult.getPdCode());
            productParam.setLogiAreaCode(detailResult.getDistrictCode());
            productList.add(productParam);
        }
        priceParam.setProductList(productList);
        ISO151805RsPriceResult result = getPriceRestClientResult(priceParam);
        return result;
    }

    /**
     * 调用价盘接口
     * @param priceParam
     * @return
     */
    @Transactional
    public ISO151805RsPriceResult getPriceRestClientResult(ISO151805RsPriceParam priceParam){
        RsRequest<ISO151805RsPriceParam> request = new RsRequest<ISO151805RsPriceParam>();
        request.setParam(priceParam);
        String url =  ConfigManager.getPriceWayListUrl();
        RsResponse<ISO151805RsPriceResult> response =
                RestClientUtil.post(url, request, new TypeReference<RsResponse<ISO151805RsPriceResult>>() {
                });
        if (null == response || response.getStatus().equals("F")){
            throw new BusinessException("查询价盘结果失败");
        }
        if(null == response.getResult() || CollectionUtils.isEmpty(response.getResult().getProductList())){
            throw new BusinessException("查询价盘结果为空");
        }
        return response.getResult();
    }

    /**
     * 得到sku
     * @param orderDetail
     */
    @Transactional
    public void getSkuCode(ISO151805RsOrderDetailsResult orderDetail) {
        //平台类型： 1：神农客 2：美侍客
        String skuCode = StringConst.EMPTY;
        BaseParam param = new BaseParam();
        param.setFilter("orderDetailId",String.valueOf(orderDetail.getDetailId()));
        List<ISO151805SkuCodeResult> skuCodeResults = super.findList(SqlId.SQL_ID_GET_SKU_CODE_INFO_BY_DETAIL_ID,param);
        if(!CollectionUtils.isEmpty(skuCodeResults)){
            String salesPlatform = null;
            ISO151805SkuCodeResult skuCodeResult = skuCodeResults.get(NumberConst.IntDef.INT_ZERO);
            if (skuCodeResult.getOrderSource() == NumberConst.IntDef.INT_TWO) {
                salesPlatform = "2";
            } else {
                salesPlatform = "1";
            }
            SlPdArtno slpdartno = orderLogic.getSlPdArtNo(skuCodeResult.getSupplierCode(), skuCodeResult.getPdCode(), salesPlatform);
            if (!(slpdartno == null
                    || StringUtil.isEmpty(slpdartno.getSlCodeDis())
                    || StringUtil.isEmpty(slpdartno.getSlPdArtno()))) {
                skuCode = slpdartno.getSlCodeDis() + slpdartno.getSlPdArtno();
            }
        }
        orderDetail.setSkuCode(skuCode);
    }

    //Add by wang_jianzhou for bug#3818 at 2016/12/06 Start.
    /**
     * 处理返回结果去掉多余字段
     * @param rsResult 初始结果集
     */
    public ISO151805RsBeanResult dealNewResult(ISO151805RsResult rsResult){

        ISO151805RsBeanResult newResult = new ISO151805RsBeanResult();
        if(null != rsResult){
            List<ISO151805RsOrderListBeanResult> newOrderList = new ArrayList<ISO151805RsOrderListBeanResult>();
            List<ISO151805RsOrderListResult> orderList = rsResult.getOrderList();
            for(ISO151805RsOrderListResult orderResult : orderList){
                if(null != orderResult){
                List<ISO151805RsOrderDetailsBeanResult> newDetails = new ArrayList<ISO151805RsOrderDetailsBeanResult>();
                for(ISO151805RsOrderDetailsResult orderDetail : orderResult.getOrderDetail()){
                    ISO151805RsOrderDetailsBeanResult newOrderDetail = new ISO151805RsOrderDetailsBeanResult();
                    if(null != orderDetail){
                        newOrderDetail.setDetailId(orderDetail.getDetailId());
                        newOrderDetail.setProDate(orderDetail.getProDate());
                        newOrderDetail.setPdCode(orderDetail.getPdCode());
                        newOrderDetail.setPdName(orderDetail.getPdName());
                        newOrderDetail.setSkuCode(orderDetail.getSkuCode());
                        newOrderDetail.setOrderQty(orderDetail.getOrderQty());

                    List<ISO151805RsOrderPricesBeanResult> newPriceList = new ArrayList<ISO151805RsOrderPricesBeanResult>();
                        for(ISO151805RsOrderPricesResult pricesResult : orderDetail.getPriceList()){
                            ISO151805RsOrderPricesBeanResult rsOrderPricesBeanResult = new ISO151805RsOrderPricesBeanResult();
                            if(null != pricesResult){
                                rsOrderPricesBeanResult.setOrderLevel(pricesResult.getOrderLevel());
                                rsOrderPricesBeanResult.setLevelStart(pricesResult.getLevelStart());
                                rsOrderPricesBeanResult.setLevelEnd(pricesResult.getLevelEnd());
                                rsOrderPricesBeanResult.setLevelPrice(pricesResult.getLevelPrice());
                                newPriceList.add(rsOrderPricesBeanResult);
                            }
                            newOrderDetail.setPriceList(newPriceList);
                        }
                    }
                    newDetails.add(newOrderDetail);
                }
                ISO151805RsOrderListBeanResult newOrderResult = new ISO151805RsOrderListBeanResult();
                newOrderResult.setOrderDetail(newDetails);
                newOrderResult.setOrderId(orderResult.getOrderId());
                newOrderResult.setPaymentRule(orderResult.getPaymentRule());
                newOrderResult.setShipId(orderResult.getShipId());
                newOrderList.add(newOrderResult);
            }
            newResult.setOrderList(newOrderList);
            }
        }
        return newResult;
    }
    //Add by wang_jianzhou for bug#3818 at 2016/12/06 end.
    interface SqlId{
        static String SQL_ID_GET_ORDER_INFO_BY_SHIP_ID = "getOrderInfoByShipId";
        static String SQL_ID_GET_ORDER_DETAIL_INFO_BY_ORDER_ID = "getOrderDetailInfoByOrderId";
        static String SQL_ID_GET_ORDER_DETAIL_LIST_BY_ORDER_ID = "getOrderDetailListByOrderId";
        static String SQL_ID_GET_ORDER_DETAIL_PRICE_COUNT = "getOrderDetailPriceCount";
        static String SQL_ID_GET_SKU_CODE_INFO_BY_DETAIL_ID = "getSkuCodeInfoByDetailId";
    }
}
