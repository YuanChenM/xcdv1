package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170412Param;
import com.msk.pl.bean.IPL20170412RsPageResult;
import com.msk.pl.logic.IPL20170412Logic;
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
public class IPL20170412RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170412RsController.class);

    @Autowired
    private IPL20170412Logic ipl20170412Logic;

    @RequestMapping(value = "/api/v1/pl/partner_declaration_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170412Validator")
    public RsResponse<IPL20170412RsPageResult> searchTask(@RequestBody RsRequest<IPL20170412Param> paramRsRequest) {
        logger.debug("合伙人申报单列表查询");
        RsResponse<IPL20170412RsPageResult> response = new RsResponse();
        IPL20170412RsPageResult taskList = new IPL20170412RsPageResult();
        if (null != paramRsRequest) {
            IPL20170412Param param = paramRsRequest.getParam();
            taskList = ipl20170412Logic.searchTask(param);
        }
        if (taskList != null && taskList.getDataList() != null && taskList.getDataList().size() > NumberConst.IntDef.INT_ZERO) {
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setMessage("合伙人申报单列表查询成功！");
            response.setResult(taskList);
            return response;
        }
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("没有查询到数据！");
        return response;
    }

}
