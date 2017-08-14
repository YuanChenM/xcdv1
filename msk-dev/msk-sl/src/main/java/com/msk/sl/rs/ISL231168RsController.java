package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231168RsParam;
import com.msk.sl.bean.ISL231168RsResult;
import com.msk.sl.logic.ISL231166RsLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/24.
 */
@RestController
public class ISL231168RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231168RsController.class);
    @Autowired
    private ISL231166RsLogic iSL231166RsLogic;
    /**
     * 查询卖家产品类别
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slPdClasses/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231168Validator")
    public RsResponse<ISL231168RsResult> querySLPdClasses(@RequestBody RsRequest<ISL231168RsParam> param) {
        logger.debug("查询卖家产品类别接口");
        RsResponse<ISL231168RsResult> rs = new RsResponse<ISL231168RsResult>();
        ISL231168RsResult result = new ISL231168RsResult();
        result = iSL231166RsLogic.findSLPdClassesAllList(param);
        rs.setResult(result);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询卖家产品类别成功");
        return rs;
    }
}
