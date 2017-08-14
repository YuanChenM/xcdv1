package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151425RsParam;
import com.msk.so.bean.ISO151425RsResult;
import com.msk.so.logic.ISO151425Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 查询订单是否已投诉接口
 * Created by wang_jianzhou on 2016/4/18.
 */
@RestController
public class ISO151425RsController extends BaseRsController {

    @Autowired
    private ISO151425Logic iSO151425Logic;

    private static Logger logger = LoggerFactory.getLogger(ISO151425RsController.class);
    @RequestMapping(value = "/api/v1/so/complain/submit/_query",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151425Validator")
    public RsResponse<ISO151425RsResult> findComplainCount(@RequestBody RsRequest<ISO151425RsParam> request){
        logger.debug("查询订单是否已投诉接口Controller");
        RsResponse<ISO151425RsResult> response = new RsResponse<ISO151425RsResult>();
        ISO151425RsResult rsResult = this.iSO151425Logic.findComplainCount(request.getParam());
        response.setResult(rsResult);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("处理成功");
        return response;
    }
}
