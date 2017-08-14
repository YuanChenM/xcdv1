package com.msk.sl.rs;

import com.msk.common.logic.CommonLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.PdTcProviderPackage;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231172RsResult;
import com.msk.sl.bean.ISL231173RsParam;
import com.msk.sl.bean.SL241130Param;
import com.msk.sl.logic.ISL231173Logic;
import com.msk.sl.logic.SL241130Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by cx on 2016/3/10.
 */
@RestController
public class ISL231173RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231173RsController.class);
    @Autowired
    private ISL231173Logic iSL231173Logic;
    @Autowired
    private CommonLogic commonLogic;
    @Autowired
    private SL241130Logic sl241130Logic;
    /**
     * 卖家申请新产品包装
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slPd/newPdPkg",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231173Validator")
    public RsResponse<ISL231172RsResult> createSLPdPkg(@RequestBody RsRequest<ISL231173RsParam> param) {
        logger.debug("卖家申请新产品包装");
        RsResponse rs=new RsResponse();
        sl241130Logic.saveNewPd(param.getParam().getNewPdPkgList());
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("卖家申请新产品包装");
        return rs;
    }
}
