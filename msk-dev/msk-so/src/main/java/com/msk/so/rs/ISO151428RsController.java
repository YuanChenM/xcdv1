package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151428RsParam;
import com.msk.so.bean.ISO151428RsResult;
import com.msk.so.logic.ISO151428Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wang_shuai on 2016/6/24.
 */
@RestController
public class ISO151428RsController extends BaseController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151428RsController.class);
    @Autowired
    private ISO151428Logic iso151428Logic;


    @RequestMapping(value = "/api/{ver}/so/sdo/buyRecord",method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151428Validator")
    public RsResponse<ISO151428RsResult> getBuyRecordInfo(@RequestBody RsRequest<ISO151428RsParam> param,@PathVariable("ver") String ver) {
        logger.info("查询购买记录");
        RsResponse<ISO151428RsResult> response = new RsResponse<ISO151428RsResult>();
        ISO151428RsParam iso151428RsParam=param.getParam();
        try{
            ISO151428RsResult result= this.iso151428Logic.findBuyRecord(iso151428RsParam);
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
