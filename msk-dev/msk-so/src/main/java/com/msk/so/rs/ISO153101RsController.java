package com.msk.so.rs;
import com.msk.core.annotation.Validator;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.BookKeepingParam;
import com.msk.so.logic.BookKeepingLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_xi on 2016/3/1.
 */
@RestController
public class ISO153101RsController extends BaseRsController {
    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO153101RsController.class);

    @Autowired
    //private ISO153101Logic logic;
    private BookKeepingLogic logic;

    @RequestMapping(value = "/api/v1/so/accountInterface/modifyAccountInfo",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO153101Validator")
    public RsResponse<Object> modifyAccountInfo(@RequestBody RsRequest<BookKeepingParam> param) {
        logger.info("调用记账接口开始");
        RsResponse<Object> rs = new RsResponse<Object>();
        if (isDebug) {
           //TODO
       } else {
            boolean ret = logic.updateOrSaveAmountRecord(param);
            if(ret) {
                rs.setStatus(BusinessConst.RsStatus.SUCCESS);
                rs.setMessage("记账接口调用处理成功！");
            }else {
                rs.setStatus(BusinessConst.RsStatus.FAIL);
                rs.setMessage("记账接口调用处理失败！");
            }
        }
        return rs;
    }
}
