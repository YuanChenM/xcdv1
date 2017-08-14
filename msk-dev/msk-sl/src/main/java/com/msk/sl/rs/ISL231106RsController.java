package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlDistReguSug;
import com.msk.core.web.base.BaseRsController;
import com.msk.sl.bean.ISL231106RsParam;
import com.msk.sl.logic.ISL231106Logic;
import com.msk.sl.logic.ISL231203Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * ISL231106RsController.
 * 编辑卖家产品标准
 *
 * @author gyh
 */
@RestController
public class ISL231106RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231106RsController.class);

    @Autowired
    private ISL231106Logic isl231106Logic;

    /**
     * 编辑卖家产品标准
     *
     * @param param param
     * @return 结果
     * @author gyh
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slQlt/newOrUpdate",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231106Validator")
    public RsResponse newSlQlt(@RequestBody RsRequest<ISL231106RsParam> param) {
        logger.info("编辑卖家产品标准");
        RsResponse rs = this.isl231106Logic.saveSlQlt(param);
        return rs;
    }
}
