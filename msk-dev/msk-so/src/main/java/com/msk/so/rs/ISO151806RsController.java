package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.SystemConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.so.bean.ISO151806RsParam;
import com.msk.so.bean.ISO151806RsResult;
import com.msk.so.logic.ISO151806Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * zhang_qiang1  库存调整接口
 */
@RestController
public class ISO151806RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151806RsController.class);

    @Autowired
    private ISO151806Logic iso151806Logic;

    /**
     * 调整库存方法
     *
     * @param rsRequest
     * @return
     */
    @RequestMapping(value = "/api/v1/so/inventory/_adjust", method = RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE})
    @Validator(validatorClass = "com.msk.so.validator.ISO151806Validator")
    public RsResponse<ISO151806RsResult> adjustInventory(@RequestBody RsRequest<ISO151806RsParam> rsRequest) {
        logger.info("库存调整接口");
        RsResponse<ISO151806RsResult> restResponse = new RsResponse<ISO151806RsResult>();
        ISO151806RsParam param = rsRequest.getParam();
        param.setUpdId(rsRequest.getLoginId());// 传入修改人Id
        try {
            ISO151806RsResult result = this.iso151806Logic.adjustInventory(param);
            restResponse.setResult(result);
            restResponse.setStatus(SystemConst.RsStatus.SUCCESS);
        } catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            restResponse.setStatus(SystemConst.RsStatus.FAIL);
            restResponse.setMessage(e.getMessage());
        }
        return restResponse;
    }
}
