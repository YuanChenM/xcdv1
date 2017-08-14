/**
 * IMS112101RsController.java
 *
 * @screen
 * @author rwf
 */
package com.msk.ms.rs;

import com.msk.core.web.consts.BusinessConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.annotation.Validator;
import com.msk.ms.bean.IMS112101RsParam;
import com.msk.ms.bean.IMS112101RsResult;
import com.msk.ms.logic.IMS112101Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * IMS112101RsController.
 *
 * @author rwf
 */
@RestController
public class IMS112101RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IMS112101RsController.class);

    @Autowired
    private IMS112101Logic ims112101Logic;

    /**
     * @return RsResponse<IMS112101RsResult>
     * @param param 参数
     * @author rwf
     * 
     */

    @RequestMapping(value = "/api/v1/ms/card_provide",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.ms.validator.IMS112101Validator")
    public RsResponse<IMS112101RsResult> cardProvide(@RequestBody RsRequest<IMS112101RsParam> param) {
        logger.info("发放会员卡");
        RsResponse<IMS112101RsResult> rs = new RsResponse<IMS112101RsResult>();
        //接收输出数据
        IMS112101RsResult ims112101RsResult = this.ims112101Logic.findOneRecord(param);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("数据正常！");
        rs.setResult(ims112101RsResult);
        return rs;
    }
}
