package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151420RsParam;
import com.msk.so.bean.ISO151420RsResult;
import com.msk.so.logic.ISO151420Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * ISO151420RsController.
 * 投诉提交接口
 *
 * @author sjj
 */
@RestController
public class ISO151420RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151420RsController.class);

    @Autowired
    private ISO151420Logic iSO151420Logic;

    /**
     * 投诉提交接口
     *
     * @param request
     * @return 结果
     * @author sjj
     */
    @RequestMapping(value = "/api/v1/so/complain/_submit",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.so.validator.ISO151420Validator")
    public RsResponse<ISO151420RsResult> complainOrder(@RequestBody RsRequest<ISO151420RsParam> request) {
        logger.info("投诉提交Controller");
        ISO151420RsParam param = request.getParam();
        param.setCrtId(request.getLoginId());
        ISO151420RsResult iSO151420RsResult = iSO151420Logic.complainOrder(param);
        RsResponse<ISO151420RsResult> rs = new RsResponse<ISO151420RsResult>();
        if (null != iSO151420RsResult){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("投诉提交成功！");
            rs.setResult(iSO151420RsResult);
        }else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("投诉提交失败！");
        }
        return rs;
    }
}
