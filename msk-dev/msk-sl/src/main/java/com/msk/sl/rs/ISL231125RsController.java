package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231125RsParam;
import com.msk.sl.bean.ISL231125RsResult;
import com.msk.sl.logic.ISL231125RsLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/16.
 */
@RestController
public class ISL231125RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231125RsController.class);
    @Autowired
    private ISL231125RsLogic iSL231125RsLogic;
    /**
     * 查询企业基本资质接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEnterprise/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231125Validator")
    public RsResponse<ISL231125RsResult> querySLSeller(@RequestBody RsRequest<ISL231125RsParam> param) {
        logger.debug("查询企业基本资质接口");
        RsResponse<ISL231125RsResult> rs = new RsResponse<ISL231125RsResult>();
        ISL231125RsResult result = new ISL231125RsResult();
        result = iSL231125RsLogic.findAllList(param);
        rs.setResult(result);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询企业基本资质成功");
        return rs;
    }
}
