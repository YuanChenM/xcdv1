package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231191Result;
import com.msk.sl.bean.ISL231191RsParam;
import com.msk.sl.logic.ISL231191RsLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pxg on 2016/4/26.
 */
@RestController
public class ISL231191RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231191RsController.class);
    @Autowired
    private ISL231191RsLogic isl231191Logic;
    /**
     * 查询卖家产品货号信息
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slArtNo/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231191Validator")
    public RsResponse<ISL231191Result> search(@RequestBody RsRequest<ISL231191RsParam> param) {
        logger.debug("查询卖家产品货号接口");
        RsResponse<ISL231191Result> rs = new RsResponse<ISL231191Result>();
        rs.setResult(isl231191Logic.queryData(param));
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询卖家产品货号信息成功");
        return rs;
    }
}
