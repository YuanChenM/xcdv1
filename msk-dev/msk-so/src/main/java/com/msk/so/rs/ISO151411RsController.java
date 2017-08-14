package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151411RsParam;
import com.msk.so.bean.ISO151411RsResult;
import com.msk.so.logic.ISO151411Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * ISO151411RsController
 *
 * @author sunjiaju
 * @version 1.0
 **/
@RestController
public class ISO151411RsController extends BaseRsController{

    @Autowired
    private ISO151411Logic iso151411Logic;

    /**
     * 支付结果查询接口
     * @param request 请求参数
     * @return
     */
    @RequestMapping(value = "/api/v1/so/payment/result/_search", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151411Validator")
    public RsResponse<ISO151411RsResult> searchPaymentResult(@RequestBody  RsRequest<ISO151411RsParam> request){
        ISO151411RsParam param = request.getParam();
        ISO151411RsResult result = this.iso151411Logic.searchPaymentResult(param);
        RsResponse<ISO151411RsResult> response = new RsResponse<ISO151411RsResult>();
        response.setResult(result);
        response.setMessage("查询成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        return response;
    }
}
