package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231181RsParam;
import com.msk.sl.bean.ISL231181Result;
import com.msk.sl.logic.ISL231181Logic;
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
public class ISL231181RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231181RsController.class);
    @Autowired
    private ISL231181Logic isl231181RsLogic;
    /**
     * 查询卖家所有信息接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/searchAll",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231181Validator")
    public RsResponse<ISL231181Result> deleteSLEpManager(@RequestBody RsRequest<ISL231181RsParam> param) {
        logger.debug("查询卖家所有信息接口");
        RsResponse<ISL231181Result> rs = new RsResponse<ISL231181Result>();
        ISL231181Result result=new ISL231181Result();
        result=isl231181RsLogic.findAllDate(param);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询卖家信息成功");
        rs.setResult(result);
        return rs;
    }
}
