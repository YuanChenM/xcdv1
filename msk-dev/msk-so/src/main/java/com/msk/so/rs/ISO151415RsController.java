package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.order.BaseOrderStatusParam;
import com.msk.so.bean.order.BaseOrderStatusResult;
import com.msk.so.bean.order.OrderDeliverParam;
import com.msk.so.bean.order.OrderReceiptParam;
import com.msk.so.logic.ISO151415Logic;
import com.msk.so.logic.order.OrderStatusHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * *订单状态修改功能
 * *@author jiang_nan
 * *@version 1.0
 **/
@RestController
public class ISO151415RsController extends BaseRsController{
    @Autowired
    private OrderStatusHandle orderStatusHandle;

    @Autowired
    private ISO151415Logic iso151415Logic;
    /**
     * 整单取消
     * @param request 请求参数
     * @return 返回结果JSON数据
     */
    @RequestMapping(value = "/api/v1/so/sdo/cancel",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<BaseOrderStatusResult> cancel(@RequestBody RsRequest<BaseOrderStatusParam> request){
        RsResponse<BaseOrderStatusResult> response = new RsResponse<BaseOrderStatusResult>();
        BaseOrderStatusParam param = request.getParam();
        param.setUpdId(request.getLoginId());
        response.setMessage("订单取消");
        response.setResult(this.orderStatusHandle.modifyOrderCancel(param));
        // add for Bug#2673 at 2016/09/14 by sun_jiaju Start
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        // add for Bug#2673 at 2016/09/14 by sun_jiaju End
        return response;
    }

    @RequestMapping(value = "/api/v1/so/sdo/{type}",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<BaseOrderStatusResult> modifyOrderStatus(@PathVariable("type") String type,@RequestBody RsRequest<BaseOrderStatusParam> request){
        RsResponse<BaseOrderStatusResult> response = new RsResponse<BaseOrderStatusResult>();
        BaseOrderStatusParam param = request.getParam();
        param.setUpdId(request.getLoginId());
        response.setMessage("订单状态修改");
        response.setResult(this.orderStatusHandle.modifyOrderStatus(type, param));
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        return response;
    }

    /**
     * 订单收货操作
     * @param request 请求参数
     * @return 处理结果集
     */
    @RequestMapping(value = "/api/v2/so/sdo/part/receipt", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_XML_VALUE })
    public RsResponse<BaseOrderStatusResult> orderReceivingOrDeliver(@RequestBody RsRequest<OrderReceiptParam> request){
        RsResponse<BaseOrderStatusResult> response = new RsResponse<BaseOrderStatusResult>();
        OrderReceiptParam param = request.getParam();
        param.setUpdId(request.getLoginId());
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        response.setMessage("订单receipt成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        BaseOrderStatusResult result = this.iso151415Logic.modifyPartReceipt(param);
        response.setResult(result);
        return response;
    }

    /**
     * 订单发货操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v2/so/sdo/part/deliver", method = RequestMethod.POST, produces = { MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_XML_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151415partDeliverValidator")
    public RsResponse<BaseOrderStatusResult> orderDeliver(@RequestBody RsRequest<OrderDeliverParam> request){
        RsResponse<BaseOrderStatusResult> response = new RsResponse<BaseOrderStatusResult>();
        OrderDeliverParam param = request.getParam();
        param.setUpdId(request.getLoginId());
        BaseOrderStatusResult result = this.iso151415Logic.modifyPartDeliver(param);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("订单发货成功");
        response.setResult(result);
        return response;
    }

}
