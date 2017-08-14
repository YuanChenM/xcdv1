package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151408RsParam;
import com.msk.so.bean.ISO151408RsResult;
import com.msk.so.logic.ISO151408Logic;
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
 * ISO151408RsController.
 * 创建标准分销退货单
 * 
 * @author sjj
 */
@RestController
public class ISO151408RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO151408RsController.class);

    @Autowired
    private ISO151408Logic iSO151408Logic;

    /**
     * 创建标准分销退货单
     * 
     * @param param param
     * @return 结果
     * @author sjj
     */
    @RequestMapping(value = "/api/v1/so/sro/new",method = RequestMethod.POST,produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151408Validator")
    public RsResponse<ISO151408RsResult> modifyDbOrder(@RequestBody RsRequest<ISO151408RsParam> param) {
        logger.info("创建标准分销退货单");
        RsResponse<ISO151408RsResult> rs = new RsResponse<ISO151408RsResult>();
        ISO151408RsResult result = iSO151408Logic.returnOrder(param);
        if (result != null){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("创建标准分销退货单成功！");
            rs.setResult(result);
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("创建标准分销退货单成功！");
        }
        return rs;
    }
}
