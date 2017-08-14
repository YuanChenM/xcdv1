package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlAccount;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231105RsParam;
import com.msk.sl.bean.ISL231105RsResult;
import com.msk.sl.logic.ISL231105Logic;
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
public class ISL231105RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231105RsController.class);
    @Autowired
    private ISL231105Logic isl231105Logic;

    /**
     * 查询卖家账户接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slAccount/search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231105Validator")
    public RsResponse<ISL231105RsResult> querySLAccount(@RequestBody RsRequest<ISL231105RsParam> param) {
        logger.debug("查询卖家账户接口");
        RsResponse<ISL231105RsResult> rs = new RsResponse<ISL231105RsResult>();
        ISL231105RsParam iSL231105RsParam = param.getParam();
        ISL231105RsResult slAccount1 = isl231105Logic.querySlAccount(iSL231105RsParam);
        if (null == slAccount1) {
            throw new BusinessException("卖家账户不存在!");
        }
        rs.setResult(slAccount1);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询卖家账户成功");
        return rs;
    }
}
