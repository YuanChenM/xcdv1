package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151433RsResult;
import com.msk.so.bean.ISO151433RsParam;
import com.msk.so.logic.ISO151433Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by sunjiaju on 2016/7/14.
 */
@RestController
public class ISO151433RsController extends BaseRsController {
    private static Logger logger = LoggerFactory.getLogger(ISO151433RsController.class);

    @Autowired
    private ISO151433Logic iso151433Logic;
    @RequestMapping(value = "/api/v1/so/sdo/shipment/cancel",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_XML_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151433Validator")
    public RsResponse<ISO151433RsResult> halfMonthOrder(@RequestBody RsRequest<ISO151433RsParam> request){
        logger.info("订单发货取消回传接口！");
        request.getParam().setUpdId(request.getLoginId());
        RsResponse<ISO151433RsResult> response = new RsResponse<ISO151433RsResult>();
        ISO151433RsResult iso151433RsResult = iso151433Logic.cancelShipment(request.getParam());
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setResult(iso151433RsResult);
        response.setMessage("订单发货取消成功！");
        logger.info("订单发货取消结束！");
        return response;
    }

}
