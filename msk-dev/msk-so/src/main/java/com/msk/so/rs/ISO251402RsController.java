package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.so.bean.ISO251402RsParam;
import com.msk.so.bean.ISO251402RsResult;
import com.msk.so.logic.ISO251402Logic;

/**
 * 
 * ISO251402RsController.
 * 创建分销订单接口
 * 
 * @author pxg
 */
@RestController
public class ISO251402RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO251402RsController.class);

    @Autowired
    private ISO251402Logic iSO251402Logic;

    /**
     * 创建标准订单标准分销订单
     * 
     * @param param param
     * @return 结果
     * @author pxg
     */
    @RequestMapping(value = "/api/v1/so/sdo/new",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO251402Validator")
    public RsResponse<ISO251402RsResult> createDbOrder(@RequestBody RsRequest<ISO251402RsParam> param) {
        logger.info("创建标准订单标准分销订单");
        RsResponse<ISO251402RsResult> rs = new RsResponse<ISO251402RsResult>();
        ISO251402RsResult result = new ISO251402RsResult();
        result = iSO251402Logic.save(param);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("创建标准分销订单成功！");
        rs.setResult(result);
        return rs;
    }
}
