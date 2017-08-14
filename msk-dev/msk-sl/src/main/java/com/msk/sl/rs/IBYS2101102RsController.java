package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlAccount;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231102RsResult;
import com.msk.sl.logic.SL241103001Logic;
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
public class IBYS2101102RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBYS2101102RsController.class);
    @Autowired
    private SL241103001Logic sL241103001Logic;
    /**
     * 增加买手店卖家账户接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bys/slInfo/slAccount/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231102Validator")
    public RsResponse<ISL231102RsResult> createSLAccount(@RequestBody RsRequest<SlAccount> param){
        logger.debug("增加买手店卖家账户接口");
        RsResponse<ISL231102RsResult> rs=new RsResponse<ISL231102RsResult>();
        SlAccount slAccount = param.getParam();
        sL241103001Logic.saveAccount(slAccount);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("增加买手店卖家账户成功");
        return rs;
    }
}
