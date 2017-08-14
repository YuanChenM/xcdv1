package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151404RsParam;
import com.msk.so.bean.ISO151404RsResult;
import com.msk.so.bean.SellerListResult;
import com.msk.so.logic.ISO151404Logic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ISO151404RsController
 *
 * @author sunjiaju
 * @version 1.0
 **/
@RestController
public class ISO151404RsController extends BaseRsController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151404RsController.class);

    @Autowired
    private ISO151404Logic iso151404Logic;

    /**
     * 查询订单卖家详细信息
     * @param request 请求参数
     * @return
     */
    @RequestMapping(value = "/api/v1/so/returnCode/check", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151404Validator")
    public synchronized RsResponse<ISO151404RsResult> checkReturnCode(@RequestBody  RsRequest<ISO151404RsParam> request){
        ISO151404RsParam param = request.getParam();
        ISO151404RsResult result = this.iso151404Logic.getCount(param);
        RsResponse<ISO151404RsResult> response = new RsResponse<ISO151404RsResult>();
        if (result != null){
            response.setMessage("查询成功");
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setResult(result);
        } else{
            response.setMessage("查询失败");
            response.setStatus(BusinessConst.RsStatus.FAIL);
        }

        return response;
    }
}
