package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151424RsParam;
import com.msk.so.bean.ISO151424RsResult;
import com.msk.so.logic.ISO151424Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wang_jianzhou on 2016/4/18.
 */
@RestController
public class ISO151424RsController extends BaseRsController {

    @Autowired
    private ISO151424Logic iSO151424Logic;

    private static Logger logger = LoggerFactory.getLogger(ISO151424RsController.class);
    @RequestMapping(value = "/api/v1/so/sell/product/search",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ISO151424RsResult> findProduct(@RequestBody RsRequest<ISO151424RsParam> request){
        logger.debug("卖家商品管理接口");
        RsResponse<ISO151424RsResult> response = new RsResponse<ISO151424RsResult>();
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("处理成功");
        ISO151424RsResult rsResult = this.iSO151424Logic.findProduct(request);
        response.setResult(rsResult);
        return response;
    }

}
