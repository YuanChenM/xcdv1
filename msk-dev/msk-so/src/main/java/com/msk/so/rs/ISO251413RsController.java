package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.SystemConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.so.bean.ISO251413RsParam;
import com.msk.so.bean.ISO251413RsResult;
import com.msk.so.logic.ISO251413Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 三合一  订单收货接口 融合了 收货，退货，拒收接口
 */
@RestController
public class ISO251413RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251413RsController.class);

    @Autowired
    private ISO251413Logic iso251413Logic;


    /**
     * 三合一  订单收货接口
     *
     * @param rsRequest
     * @return
     */
    @RequestMapping(value = "/api/so/sdo/_receive",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE})
       @Validator(validatorClass = "com.msk.so.validator.ISO251413Validator")
    public RsResponse<ISO251413RsResult> modifyDbOrder(@RequestBody RsRequest<ISO251413RsParam> rsRequest) {
        RsResponse<ISO251413RsResult> rsResponse = new RsResponse<>();
        logger.info("调用收货接口_开始");
        ISO251413RsParam param = rsRequest.getParam();
        param.setUpdId(rsRequest.getLoginId());
        try {
            rsResponse.setStatus(SystemConst.RsStatus.SUCCESS);
            ISO251413RsResult result = this.iso251413Logic.receiveShip(param);
            rsResponse.setResult(result);
        } catch (Exception e) {
            rsResponse.setStatus(SystemConst.RsStatus.FAIL);
            rsResponse.setMessage(e.getMessage());
            logger.debug(e.getMessage());
            e.printStackTrace();
        }
        logger.info("调用收货接口_结束");
        return rsResponse;
    }
}
