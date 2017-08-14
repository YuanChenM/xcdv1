package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlAccount;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231104RsResult;
import com.msk.sl.logic.SL24110101Logic;
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
public class ISL231104RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231104RsController.class);
    @Autowired
    private SL24110101Logic sL24110101Logic;
    /**
     * 修改卖家账户接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slAccount/update",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231104Validator")
    public RsResponse<ISL231104RsResult> updateSLAccount(@RequestBody RsRequest<SlAccount> param) {
        logger.debug("修改卖家账户接口");
        RsResponse<ISL231104RsResult> rs=new RsResponse<ISL231104RsResult>();
        SlAccount slAccount = param.getParam();
        sL24110101Logic.update(slAccount);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("修改卖家账户成功");
        return rs;
    }
}
