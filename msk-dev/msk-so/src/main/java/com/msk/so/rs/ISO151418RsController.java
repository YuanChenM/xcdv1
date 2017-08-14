package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151417RsParam;
import com.msk.so.bean.ISO151417RsResult;
import com.msk.so.bean.ISO151418RsParam;
import com.msk.so.bean.ISO151418RsResult;
import com.msk.so.logic.rs.ISO151418Logic;
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
public class ISO151418RsController extends BaseRsController {
    private static Logger logger = LoggerFactory.getLogger(ISO151418RsController.class);

    @Autowired
    private ISO151418Logic iso151418Logic;

    /**
     * 评价查询列表接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/evaluate/list/_query", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ISO151418RsResult> searchEvaluateList(@RequestBody RsRequest<ISO151418RsParam> request){
        logger.info("查询评价列表接口开始");
        RsResponse<ISO151418RsResult> response = new RsResponse<>();
        ISO151418RsParam param = request.getParam();
        ISO151418RsResult result = iso151418Logic.searchEvaluateList(param);
        response.setResult(result);
        response.setMessage("查询评价列表成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        logger.info("查询评价列表接口结束");
        return response;
    }
}
