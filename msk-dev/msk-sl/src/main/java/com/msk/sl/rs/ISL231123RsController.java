package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231123RsResult;
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
 * Created by cx on 2016/2/16.
 */
@RestController
public class ISL231123RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231123RsController.class);
    @Autowired
    private SL241103001Logic sL241103001Logic;
    /**
     * 增加企业基本资质接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEnterprise/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231123Validator")
    public RsResponse<ISL231123RsResult> createSLEnterprise(@RequestBody RsRequest<SlEnterprise> param) {
        logger.debug("增加企业基本资质接口");
        RsResponse<ISL231123RsResult> rs=new RsResponse<ISL231123RsResult>();
        SlEnterprise slEnterprise = param.getParam();
        sL241103001Logic.saveEp(slEnterprise);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("增加企业基本资质成功");
        return rs;
    }
}
