package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231191Result;
import com.msk.sl.bean.ISL231191RsParam;
import com.msk.sl.bean.ISL231192Result;
import com.msk.sl.bean.ISL231192RsParam;
import com.msk.sl.logic.ISL231191RsLogic;
import com.msk.sl.logic.ISL231192RsLogic;
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
public class ISL231192RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231192RsController.class);
    @Autowired
    private ISL231192RsLogic isl231192Logic;
    /**
     * 查询卖家产品货号对应的详细信息
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slArtNoPdInfo/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231192Validator")
    public RsResponse<ISL231192Result> search(@RequestBody RsRequest<ISL231192RsParam> param) {
        logger.debug("查询卖家产品货号对应的详细信息接口");
        RsResponse<ISL231192Result> rs = new RsResponse<ISL231192Result>();
        rs.setResult(isl231192Logic.queryData(param));
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询卖家产品货号对应的详细信息成功");
        return rs;
    }
}
