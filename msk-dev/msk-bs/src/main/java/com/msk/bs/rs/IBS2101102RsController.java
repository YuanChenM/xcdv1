package com.msk.bs.rs;

import com.msk.bs.bean.IBS2101102RsParam;
import com.msk.bs.bean.IBS2101102RsResult;
import com.msk.bs.logic.IBS2101102RsLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
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

/**
 * Created by cx on 2016/2/14.
 */
@RestController
public class IBS2101102RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101102RsController.class);
    @Autowired
    private IBS2101102RsLogic IBS2101102RsLogic;
    /**
     * 编辑买手店卖家账户接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/slAccount/newOrUpdate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.bs.validator.IBS2101102Validator")
    public RsResponse<IBS2101102RsResult> editSLAccount(@RequestBody RsRequest<IBS2101102RsParam> param) {
        logger.debug("编辑买手店卖家账户接口");
        RsResponse<IBS2101102RsResult> rs = new RsResponse<IBS2101102RsResult>();
        //IBS2101102RsParam iBS2101102RsParam = param.getParam();
        IBS2101102RsLogic.editAccount(param);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("编辑买手店卖家账户成功");
        return rs;
    }
}
