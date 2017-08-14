package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231101RsParam;
import com.msk.sl.bean.ISL231101RsResult;
import com.msk.sl.bean.ISL231183RsParam;
import com.msk.sl.logic.ISL231101Logic;
import com.msk.sl.logic.ISL231183Logic;
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
 * Created by gyh on 2016/3/18.
 * 卖家账号密码修改
 */
@RestController
public class ISL231183RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231183RsController.class);
    @Autowired
    private ISL231183Logic isl231183Logic;

    /**
     * 卖家信息接口
     *
     * @param param param
     * @return 卖家信息
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slAccount/psdUpdate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231183Validator")
    public RsResponse psdUpdate(@RequestBody RsRequest<ISL231183RsParam> param) {
        logger.debug("卖家账号密码修改");
        RsResponse rs = new RsResponse();
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage(isl231183Logic.psdUpdate(param.getParam()));
        return rs;
    }
}
