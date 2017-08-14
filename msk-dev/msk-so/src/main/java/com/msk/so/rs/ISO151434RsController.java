package com.msk.so.rs;


import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.SystemConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.so.bean.ISO151434OrderRsResult;
import com.msk.so.bean.ISO151434RsParam;
import com.msk.so.bean.ISO151434RsResult;
import com.msk.so.logic.ISO151434Logic;
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
 * Created by jiang_tengfei on 2016/5/23.
 */
@RestController
public class ISO151434RsController extends BaseRsController {
    private static Logger logger = LoggerFactory.getLogger(ISO151434RsController.class);

    @Autowired
    private ISO151434Logic iso151434Logic;

    @RequestMapping(value = "/api/v1/so/order/halfmonthcount",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151434Validator")
    public RsResponse<ISO151434OrderRsResult> halfMonthOrder(@RequestBody RsRequest<ISO151434RsParam> request){
        logger.info("开始查询列表！");

        RsResponse<ISO151434OrderRsResult> response = new RsResponse<ISO151434OrderRsResult>();
        ISO151434OrderRsResult iso151434OrderRsResult = new ISO151434OrderRsResult();

        List<ISO151434RsResult> iso151434RsResultList = iso151434Logic.findAll(request);

        iso151434OrderRsResult.setIso151434RsResultList(iso151434RsResultList);

        response.setStatus(SystemConst.RsStatus.SUCCESS);
        response.setResult(iso151434OrderRsResult);
        response.setMessage("查询成功！");
        logger.info("查询列表结束！");

        return response;
    }

}
