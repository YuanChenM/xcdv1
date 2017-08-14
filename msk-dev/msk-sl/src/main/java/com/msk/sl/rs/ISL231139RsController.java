package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEpManager;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231139RsResult;
import com.msk.sl.logic.SL24110108Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/17.
 */
@RestController
public class ISL231139RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231139RsController.class);
    @Autowired
    private SL24110108Logic sL24110108Logic;
    /**
     * 修改企业管理团队接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpManager/update",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231139Validator")
    public RsResponse<ISL231139RsResult> updateSLEpManager(@RequestBody RsRequest<SlEpManager> param) {
        logger.debug("修改企业管理团队接口");
        RsResponse<ISL231139RsResult> rs = new RsResponse<ISL231139RsResult>();
        SlEpManager slEpManager = param.getParam();
        sL24110108Logic.updateSlEpManagerPort(slEpManager);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("修改企业管理团队成功");
        return rs;
    }
}
