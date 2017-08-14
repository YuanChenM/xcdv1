package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151418RsParam;
import com.msk.so.bean.ISO151418RsResult;
import com.msk.so.bean.ISO151419RsParam;
import com.msk.so.bean.ISO151419RsResult;
import com.msk.so.logic.rs.ISO151418Logic;
import com.msk.so.logic.rs.ISO151419Logic;
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
public class ISO151419RsController extends BaseRsController {
    private static Logger logger = LoggerFactory.getLogger(ISO151419RsController.class);

    @Autowired
    private ISO151419Logic iso151419Logic;

    /**
     * 评价是否已提交接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/evaluate/submit/_query", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ISO151419RsResult> searchEvaluateSubmit(@RequestBody RsRequest<ISO151419RsParam> request){
        logger.info("查询评价是否已提交接口开始");
        RsResponse<ISO151419RsResult> response = new RsResponse<>();
        ISO151419RsParam param = request.getParam();
        ISO151419RsResult result = iso151419Logic.searchEvaluateSubmit(param);
        response.setResult(result);
        response.setMessage("查询评价是否已提交成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        logger.info("查询评价是否已提交接口结束");
        return response;
    }
}
