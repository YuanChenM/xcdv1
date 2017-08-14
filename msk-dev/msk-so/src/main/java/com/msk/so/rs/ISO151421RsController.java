package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151421RsParam;
import com.msk.so.bean.ISO151421RsResult;
import com.msk.so.logic.ISO151421Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * ISO151421RsController.
 * 投诉一览查询接口
 *
 * @author sjj
 */
@RestController
public class ISO151421RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151421RsController.class);

    @Autowired
    private ISO151421Logic iSO151421Logic;

    /**
     * 投诉一览查询接口
     *
     * @param request param
     * @return 结果
     * @author sjj
     */
    @RequestMapping(value = "/api/v1/so/complain/list/_query",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.so.validator.ISO151421Validator")
    public RsResponse<ISO151421RsResult> findComplainList(@RequestBody RsRequest<ISO151421RsParam> request) {
        logger.info("投诉一览查询接口Controller");
        RsResponse<ISO151421RsResult> rs = new RsResponse<ISO151421RsResult>();
        ISO151421RsResult iSO151421RsResult = iSO151421Logic.findComplainList(request.getParam());
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("投诉一览查询成功！");
        rs.setResult(iSO151421RsResult);
        return rs;
    }
}
