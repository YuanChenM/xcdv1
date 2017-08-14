package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.so.bean.ISO151430RsParam;
import com.msk.so.bean.ISO151430RsResult;
import com.msk.so.logic.ISO151430Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 
 * ISO151423RsController.
 * 库存查询接口
 * 
 * @author zhang_qiang1
 */
@RestController
public class ISO151430RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO151430RsController.class);

    @Autowired
    private ISO151430Logic iSO151423Logic;

    /**
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/so/queryStock/list",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151430Validator")
    public RsResponse<ISO151430RsResult> modifyDbOrder(@RequestBody RsRequest<ISO151430RsParam> param) {
        logger.info("查询可用库存");
        RsResponse<ISO151430RsResult> rs = new RsResponse<ISO151430RsResult>();
        ISO151430RsParam iso151430RsParam=param.getParam();
        String message;
        try{
            ISO151430RsResult result= this.iSO151423Logic.queryUsedStock(iso151430RsParam);
            rs.setResult(result);
            message="查询成功";
        }catch (Exception e){
            message="查询失败,异常原因："+e.getMessage()+e.toString();
            System.out.println(e.getMessage()+e.toString());
        }
        rs.setMessage(message);
        return rs;
    }
}
