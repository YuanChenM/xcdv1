package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231149RsParam;
import com.msk.sl.bean.ISL231149RsResult;
import com.msk.sl.logic.ISL231146RsLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/22.
 */
@RestController
public class ISL231149RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231149RsController.class);
    @Autowired
    private ISL231146RsLogic iSL231146RsLogic;
    /**
     * 查询企业产品品牌接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpBrandcTeam/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231149Validator")
    public RsResponse<ISL231149RsResult> querySLEpBrandc(@RequestBody RsRequest<ISL231149RsParam> param) {
        logger.debug("查询企业产品品牌接口");
        RsResponse<ISL231149RsResult> rs = new RsResponse<ISL231149RsResult>();
        ISL231149RsResult result = new ISL231149RsResult();
        result = iSL231146RsLogic.findSLEpBrandcAllList(param);
        rs.setResult(result);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询企业产品品牌成功");
        return rs;
    }
}
