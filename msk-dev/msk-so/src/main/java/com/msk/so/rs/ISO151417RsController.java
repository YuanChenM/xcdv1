package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151417RsParam;
import com.msk.so.bean.ISO151417RsResult;
import com.msk.so.logic.rs.ISO151417Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liutao on 2016/10/11.
 */
@RestController
public class ISO151417RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(ISO151417RsController.class);

    @Autowired
    private ISO151417Logic iso151417Logic;

    /**
     * 评价提交接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/evaluate/_submit", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151417Validator")
    public RsResponse<ISO151417RsResult> createEvaluate(@RequestBody RsRequest<ISO151417RsParam> request){
        logger.info("创建订单评价开始");
        RsResponse<ISO151417RsResult> response = new RsResponse<>();
        ISO151417RsParam param = request.getParam();
        param.setCrtId(request.getLoginId());
        param.setCrtTime(DateTimeUtil.getCustomerDate());
        ISO151417RsResult result = iso151417Logic.createEvaluate(param);
        response.setResult(result);
        response.setMessage("订单评价创建成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        logger.info("创建订单评价结束");
        return response;
    }
}
