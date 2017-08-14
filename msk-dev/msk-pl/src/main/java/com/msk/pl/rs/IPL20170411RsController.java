package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170411Param;
import com.msk.pl.bean.IPL20170411RsPageResult;
import com.msk.pl.logic.IPL20170411Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@RestController
public class IPL20170411RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170411RsController.class);

    @Autowired
    private IPL20170411Logic ipl20170411Logic;

    @RequestMapping(value = "/api/v1/pl/partner_declaration_sum",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170411Validator")
    public RsResponse<IPL20170411RsPageResult> searchBsDeclarations(@RequestBody RsRequest<IPL20170411Param> paramRsRequest) {
        logger.debug("合伙人查看申报单任务完成统计接口开始调用");
        RsResponse<IPL20170411RsPageResult> response = new RsResponse();
        IPL20170411RsPageResult taskList = new IPL20170411RsPageResult();
        if (null != paramRsRequest) {
            IPL20170411Param param = paramRsRequest.getParam();
            taskList = ipl20170411Logic.searchTaskInfo(param);
        }

        if (taskList != null && taskList.getBsTaskList() != null && taskList.getBsTaskList().size() > NumberConst.IntDef.INT_ZERO) {
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setMessage("合伙人查看申报单任务完成统计接查询成功！");
            response.setResult(taskList);
            return response;
        }
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("没有查询到数据！");
        return response;
    }

}
