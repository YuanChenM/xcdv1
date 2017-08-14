package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151429RsParam;
import com.msk.so.bean.ISO151429RsResult;
import com.msk.so.logic.ISO151429Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wang_shuai on 2016/6/24.
 */
@RestController
public class ISO151429RsController extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151429RsController.class);
    @Autowired
    private ISO151429Logic iso151429Logic;


    @RequestMapping(value = "/api/{ver}/so/sdo/housekeepingPdInfo",method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151429Validator")
    public RsResponse<ISO151429RsResult> getHousekeepingPdInfo(@RequestBody RsRequest<ISO151429RsParam> param,@PathVariable("ver") String ver) {
        logger.info("查询管家可出售商品");
        RsResponse<ISO151429RsResult> response = new RsResponse<ISO151429RsResult>();
        ISO151429RsParam iso151429RsParam=param.getParam();
        try{
            ISO151429RsResult result= this.iso151429Logic.findHousekeepingPdInfo(iso151429RsParam);
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
