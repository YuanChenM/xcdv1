package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151427Result;
import com.msk.so.bean.ISO151427RsParam;
import com.msk.so.logic.ISO151427Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wang_shuai on 2016/6/22.
 */
@RestController
public class ISO151427RsController extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151427RsController.class);
    @Autowired
    private ISO151427Logic iso151427Logic;


    @RequestMapping(value = "/api/{ver}/so/sdo/settlementDetail",method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151427Validator")
    public RsResponse<ISO151427Result> getSettlementDetail(@RequestBody RsRequest<ISO151427RsParam> param,@PathVariable("ver") String ver) {
        logger.info("查询结算详情");
        RsResponse<ISO151427Result> response = new RsResponse<ISO151427Result>();
        ISO151427RsParam iso151427RsParam=param.getParam();
        try{
            ISO151427Result result= this.iso151427Logic.findSettlementDetail(iso151427RsParam);
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setMessage("查询成功");
            response.setResult(result);
        }catch (Exception e){
            String message="查询失败,异常原因："+e.getMessage()+e.toString();
            System.out.println(message);
        }
        return response;
    }



}
