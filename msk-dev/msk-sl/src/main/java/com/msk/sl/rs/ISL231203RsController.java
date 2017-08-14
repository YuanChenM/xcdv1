package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlDistReguSug;
import com.msk.core.web.base.BaseRsController;
import com.msk.sl.bean.ISL231202RsParam;
import com.msk.sl.logic.ISL231202Logic;
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
 * ISL231201RsController.
 * 更新分销章程卖家意见
 *
 * @author gyh
 */
@RestController
public class ISL231203RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231203RsController.class);

    @Autowired
    private ISL231203Logic isl231203Logic;

    /**
     * 取得神农客分销章程信息
     *
     * @param param param
     * @return 结果
     * @author gyh
     */
    @RequestMapping(value = "/api/v1/sl/chapInfo/update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231203Validator")
    public RsResponse updateDbOrder(@RequestBody RsRequest<SlDistReguSug> param) {
        logger.info("更新分销章程卖家意见");
        RsResponse rs = this.isl231203Logic.modifySlDistSug(param);
        return rs;
    }
}
