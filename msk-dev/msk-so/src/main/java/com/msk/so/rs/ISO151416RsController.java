package com.msk.so.rs;

import com.msk.common.consts.OrderConst;
import com.msk.common.consts.StatusConst;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.SoOrderDetail;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.utils.DbUtils;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151416RsParam;
import com.msk.so.bean.ISO151416RsResult;
import com.msk.so.bean.SellerProductListResult;
import com.msk.so.bean.SellerProductResult;
import com.msk.so.bean.order.*;
import com.msk.so.logic.OrderLogic;
import com.msk.so.logic.rs.ISO1514161Logic;
import com.msk.so.logic.rs.ISO151416Logic;
import com.msk.so.logic.order.search.BaseSearchOrder;
import com.msk.so.logic.order.search.BuyerOrderSearch;
import com.msk.so.logic.order.search.BuyersOrderSearch;
import com.msk.so.logic.order.search.SellerOrderSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单查询接口
 * *@author jiang_nan
 * *@version 1.0
 **/
@RestController
public class ISO151416RsController extends BaseRsController {
    private static Map<String, BaseSearchOrder> SEARCH_TYPE_MAP = new HashMap<String, BaseSearchOrder>();
    @Autowired
    private SellerOrderSearch sellerOrderSearch;
    @Autowired
    private BuyerOrderSearch buyerOrderSearch;
    @Autowired
    private BuyersOrderSearch buyersOrderSearch;
    @Autowired
    private ISO151416Logic ISO151416Logic;
    @Autowired
    private ISO1514161Logic iso1514161Logic;
    @Autowired
    private OrderLogic orderLogic;
    /**
     * 初始化Search Map 数据
     *
     * @param binder WebDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        if (org.springframework.util.CollectionUtils.isEmpty(SEARCH_TYPE_MAP)) {
            //买家
            SEARCH_TYPE_MAP.put(BaseSearchOrder.SearchType.SEARCH_TYPE_BY, buyersOrderSearch);
            //卖家
            SEARCH_TYPE_MAP.put(BaseSearchOrder.SearchType.SEARCH_TYPE_SL, sellerOrderSearch);
            //买手销售
            SEARCH_TYPE_MAP.put(BaseSearchOrder.SearchType.SEARCH_TYPE_BSS, buyerOrderSearch);
            //买手囤货
            SEARCH_TYPE_MAP.put(BaseSearchOrder.SearchType.SEARCH_TYPE_BSSG, buyerOrderSearch);
        }
        super.initBinder(binder);
    }

    /**
     * 查询订单明细信息
     *
     * @param type    买家类型
     * @param request 请求参数
     * @return 订单明细参数
     */
    @RequestMapping(value = "/api/v1/so/sdo/{type}/detail", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ViewOrderSearchResult> detail(@PathVariable("type") String type, @RequestBody RsRequest<BaseOrderSearchParam> request) {
        BaseSearchOrder searchOrder = SEARCH_TYPE_MAP.get(type);
        BaseOrderSearchParam param = request.getParam();
        param.setSearchType(type);
        param.setSiteCode(request.getSiteCode());
        ViewOrderSearchResult result = searchOrder.search(param);
        RsResponse<ViewOrderSearchResult> response = new RsResponse<ViewOrderSearchResult>();
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询订单详细信息成功！");
        response.setResult(result);
        return response;
    }

    /**
     * 订单列表数据接口
     *
     * @param type    查询数据类型：
     * @param request 请求参数
     * @return 订单明细参数
     */
    /*@RequestMapping(value = "/api/v2/so/sdo/{type}/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ListOrderSearchResult> list(@PathVariable("type") String type, @RequestBody RsRequest<OrderListSearchParam> request) {
        OrderListSearchParam param = request.getParam();
        param.setSearchType(type);
        BaseSearchOrder searchOrder = SEARCH_TYPE_MAP.get(type);
        RsResponse<ListOrderSearchResult> response = new RsResponse<ListOrderSearchResult>();
        ListOrderSearchResult result = searchOrder.search(param);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询明细信息成功！");
        response.setResult(result);
        return response;
    }*/

    /**
     * 买家订单列表数据接口
     *
     * @param request 请求参数
     * @return 订单明细参数
     */
    @RequestMapping(value = "/api/v1/so/sdo/by/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ListOrderSearchResult> byList(@RequestBody RsRequest<OrderListSearchParam> request) {
        OrderListSearchParam param = request.getParam();
        String siteCode = request.getSiteCode();
        switch (siteCode){
            case "101":
                param.setOrderSource(String.valueOf(NumberConst.IntDef.INT_ONE));
                break;
            case "102":
                param.setOrderSource(String.valueOf(NumberConst.IntDef.INT_TWO));
                break;
            case "110":
                param.setOrderSource(String.valueOf(NumberConst.IntDef.INT_THREE));
                break;
            case "112":
                param.setOrderSource(String.valueOf(NumberConst.IntDef.INT_FIVE));
                break;
            //买家APP
            case "201":
                param.setOrderSource(String.valueOf(NumberConst.IntDef.INT_SIX));
                break;
            default:
                break;
        }
        RsResponse<ListOrderSearchResult> response = new RsResponse<ListOrderSearchResult>();
        ListOrderSearchResult result = new ListOrderSearchResult();
        List<BaseOrderSearchResult> orderInfo = ISO151416Logic.getByOrders(param,result);
        result.setOrders(orderInfo);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询信息成功！");
        response.setResult(result);
        return response;
    }

    /**
     * 卖家订单列表数据接口
     *
     * @param request 请求参数
     * @return 订单明细参数
     */
    @RequestMapping(value = "/api/v1/so/sdo/sl/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ListOrderSearchResult> slList(@RequestBody RsRequest<OrderListSearchParam> request) {
        OrderListSearchParam param = request.getParam();
        RsResponse<ListOrderSearchResult> response = new RsResponse<ListOrderSearchResult>();
        ListOrderSearchResult result = new ListOrderSearchResult();
        List<BaseOrderSearchResult> orderInfo = ISO151416Logic.getSlOrders(param,result);
        result.setOrders(orderInfo);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询明细信息成功！");
        response.setResult(result);
        return response;
    }

    /**
     * 买手销售订单列表数据接口
     *
     * @param request 请求参数
     * @return 订单明细参数
     */
    @RequestMapping(value = "/api/v1/so/sdo/bss/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ListOrderSearchResult> bbsList(@RequestBody RsRequest<OrderListSearchParam> request) {
        OrderListSearchParam param = request.getParam();
        RsResponse<ListOrderSearchResult> response = new RsResponse<ListOrderSearchResult>();
        ListOrderSearchResult result = new ListOrderSearchResult();
        List<BaseOrderSearchResult> orderInfo = ISO151416Logic.getBbsOrders(param,result);
        result.setOrders(orderInfo);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询明细信息成功！");
        response.setResult(result);
        return response;
    }

    /**
     * 买手囤货订单列表数据接口
     *
     * @param request 请求参数
     * @return 订单明细参数
     */
    @RequestMapping(value = "/api/v1/so/sdo/bssg/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ListOrderSearchResult> bbsgList(@RequestBody RsRequest<OrderListSearchParam> request) {
        OrderListSearchParam param = request.getParam();
        RsResponse<ListOrderSearchResult> response = new RsResponse<ListOrderSearchResult>();
        ListOrderSearchResult result = new ListOrderSearchResult();
        List<BaseOrderSearchResult> orderInfo = ISO151416Logic.getBbsgOrders(param,result);
        result.setOrders(orderInfo);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询明细信息成功！");
        response.setResult(result);
        return response;
    }

    /**
     * 查询订单明细信息
     * @param request 查询参数
     * @return ViewOrderSearchResult
     */
    @RequestMapping(value = "/api/v1/so/sdo/detail", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ViewOrderSearchResult> detail(@RequestBody RsRequest<BaseOrderSearchParam> request) {
        BaseOrderSearchParam orderSearchParam = request.getParam();
        // 只传买家编码的场合，利用买家编码查询买家id
        if (StringUtil.isEmpty(orderSearchParam.getBuyersId()) && !StringUtil.isEmpty(orderSearchParam.getBuyersCode())){
            String buyersId = this.orderLogic.getBuyersId(orderSearchParam.getBuyersCode());
            if(StringUtil.isEmpty(buyersId)){
                throw new BusinessException("根据买家CODE无法查询到买家ID！");
            }else {
                orderSearchParam.setBuyersId(buyersId);
            }
        }
        List<BaseOrderSearchResult> orderInfo = ISO151416Logic.getOrderInfo(orderSearchParam);
        ViewOrderSearchResult result = new ViewOrderSearchResult();
        result.setOrders(orderInfo);
        RsResponse<ViewOrderSearchResult> response = new RsResponse<ViewOrderSearchResult>();
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询明细信息成功！");
        response.setResult(result);
        return response;
    }




    /**
     * 查询订单列表数据
     * @param request 请求参数
     * @return ListOrderSearchResult
     */
    @RequestMapping(value = "/api/v1/so/sdo/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ListOrderSearchResult> list(@RequestBody RsRequest<OrderListSearchParam> request) {
        OrderListSearchParam searchParam = request.getParam();
        String orderTimeFrom = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                searchParam.getOrderTimeFrom());
        String orderTimeTo = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD,
                searchParam.getOrderTimeTo());
        //Modify for bug#1207 at 2016/07/13 by wang_jianzhou Start.
        String orderStatus = searchParam.getOrderStatus();
        if(!StringUtil.isEmpty(orderStatus)){
            String [] orderStatusArry = searchParam.getOrderStatus().split(",");
            searchParam.setStatusArry(orderStatusArry);
        }
        searchParam.getFilterMap().put("orderTimeFrom", orderTimeFrom);
        searchParam.getFilterMap().put("orderTimeTo", orderTimeTo);
        // 只传买家编码的场合，利用买家编码查询买家id
        if (StringUtil.isEmpty(searchParam.getBuyersId()) && !StringUtil.isEmpty(searchParam.getBuyersCode())){
            String buyersId = this.orderLogic.getBuyersId(searchParam.getBuyersCode());
            if(StringUtil.isEmpty(buyersId)){
                throw new BusinessException("根据买家CODE无法查询到买家ID！");
            }else {
                searchParam.setBuyersId(buyersId);
            }
        }
        ListOrderSearchResult result = new ListOrderSearchResult();
        List<BaseOrderSearchResult> orderInfo = ISO151416Logic.findPageList(searchParam,result);
        for(BaseOrderSearchResult order : orderInfo){
            searchParam.setFilterObject("orderId",order.getOrderId());
            List<SoOrderDetail> orderDetails = ISO151416Logic.getOrderDetailsInfo(searchParam);
            //Modify for bug#1207 at 2016/07/13 by wang_jianzhou end.
            order.setOrderDetail(orderDetails);
            order.getDeliveryReq().setFilterMap(null);
            order.getReceiveInfo().setFilterMap(null);
            order.setChildOrderDetaillist(null);
        }
        result.setOrders(orderInfo);
        RsResponse<ListOrderSearchResult> response = new RsResponse<ListOrderSearchResult>();
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询列表信息成功！");
        response.setResult(result);
        return response;
    }

    /**
     * 获取卖家已卖出商品列表
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/slProduct/list", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ISO151416RsResult> orderProductList(@RequestBody RsRequest<ISO151416RsParam> request){
        ISO151416RsParam searchParam = request.getParam();
        if(searchParam.getPageCount() != NumberConst.IntDef.INT_ZERO && searchParam.getPageNo() != NumberConst.IntDef.INT_ZERO) {
            searchParam.setPaging(true);
        }else{
            searchParam.setPaging(false);
        }
        ISO151416RsResult pageResult = new ISO151416RsResult();
        List<SellerProductResult> sellerProductResultList = iso1514161Logic.findPageList(searchParam,pageResult);
        //返回参数
        List<SellerProductListResult> sellerProductList = new ArrayList<>();
        //临时储存相同订单的产品
        List<SellerProductResult> productList = new ArrayList<>();
        //从db取得数据不为空时
        if(!CollectionUtils.isEmpty(sellerProductResultList)){
            //设置每个产品的已付金额
            setActualPay(sellerProductResultList);
            //合并同一个订单的产品
            setSameProductList(sellerProductResultList,productList,sellerProductList);
        }
        pageResult.setSellerProductResult(sellerProductList);
        RsResponse<ISO151416RsResult> response = new RsResponse<>();
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("查询列表信息成功！");
        response.setResult(pageResult);
        return response;
    }

    /**
     * 设置订单中每个产品的已支付金额和订单状态名称
     * @param sellerProductResultList
     */
    private void setActualPay(List<SellerProductResult> sellerProductResultList){
        for(SellerProductResult productResult : sellerProductResultList){
            //付款方式是线上付款或货到付款
            if(productResult.getPaymentType() == OrderConst.PaymentType.PAYING_ONLINE){
                //如果是线上付款且订单状态是已付款之后,则实付款为数量乘以产品单价，否则是0
                if(productResult.getOrderStatus() == NumberConst.IntDef.INT_TWO || productResult.getOrderStatus() == NumberConst.IntDef.INT_THREE || productResult.getOrderStatus() == NumberConst.IntDef.INT_FOUR){
                    productResult.setActualPay(productResult.getPdPrice().multiply(productResult.getSuppQty()).setScale(2, BigDecimal.ROUND_HALF_UP));
                }else{
                    productResult.setActualPay(BigDecimal.ZERO);
                }
            }else if(productResult.getPaymentType() == OrderConst.PaymentType.CASH_ON_DELIVERY){
                //如果是货到付款且订单状态是全部收货之后,则实付款为数量乘以产品单价，否则是0
                if(productResult.getOrderStatus() == NumberConst.IntDef.INT_FOUR){
                    productResult.setActualPay(productResult.getPdPrice().multiply(productResult.getSuppQty()).setScale(2, BigDecimal.ROUND_HALF_UP));
                }else {
                    productResult.setActualPay(BigDecimal.ZERO);
                }
            }
        }
    }
    /**
     * 合并相同订单的产品
     * @param sellerProductResultList
     * @param productList
     * @param sellerProductList
     */
    private void setSameProductList(List<SellerProductResult> sellerProductResultList,List<SellerProductResult> productList,List<SellerProductListResult> sellerProductList){
        for (int i = 0; i < sellerProductResultList.size(); i++) {
            SellerProductListResult sellerProduct = new SellerProductListResult();
            if(i == sellerProductResultList.size() - 1){
                sellerProduct.setOrderId(sellerProductResultList.get(i).getOrderId());
                sellerProduct.setOrderCode(sellerProductResultList.get(i).getOrderCode());
                sellerProduct.setOrderTime(sellerProductResultList.get(i).getOrderTime());
                sellerProduct.setOrderStatus(sellerProductResultList.get(i).getOrderStatus());
                sellerProduct.setOrderStatusName(sellerProductResultList.get(i).getOrderStatusName());
                productList.add(sellerProductResultList.get(i));
                sellerProduct.setProductResultList(productList);
                sellerProductList.add(sellerProduct);
                productList = new ArrayList<>();
                break;
            }
            if(sellerProductResultList.get(i).getOrderId().equals(sellerProductResultList.get(i + 1).getOrderId())){
                productList.add(sellerProductResultList.get(i));
            }else{
                sellerProduct.setOrderId(sellerProductResultList.get(i).getOrderId());
                sellerProduct.setOrderCode(sellerProductResultList.get(i).getOrderCode());
                sellerProduct.setOrderTime(sellerProductResultList.get(i).getOrderTime());
                sellerProduct.setOrderStatus(sellerProductResultList.get(i).getOrderStatus());
                sellerProduct.setOrderStatusName(sellerProductResultList.get(i).getOrderStatusName());
                productList.add(sellerProductResultList.get(i));
                sellerProduct.setProductResultList(productList);
                sellerProductList.add(sellerProduct);
                productList = new ArrayList<>();
            }
        }
    }

    /**
     * 设置订单明细信息
     * @param order 设置订单明细信息
     */
    private void createOrderDetail(BaseOrderSearchResult order){
        //判断是否有子订单数据
        ArrayList<SoOrderDetail> childOrderDetaillist = (ArrayList<SoOrderDetail>)order.getChildOrderDetaillist();
        if(!CollectionUtils.isEmpty(order.getChildOrderDetaillist())) {
            List<SoOrderDetail> orderDetailList = order.getOrderDetail();
            if(order.getOrderDetail()==null){
                orderDetailList = new ArrayList<>();
            }
            List<SoOrderDetail> cloneChildOrderDetailList = (ArrayList)((ArrayList)childOrderDetaillist).clone();
            orderDetailList.addAll(cloneChildOrderDetailList);
        }
    }

}
