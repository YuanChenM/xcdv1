package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231201RsParam;
import com.msk.sl.bean.ISL231201RsResult;
import com.msk.sl.logic.ISL231201Logic;
import com.msk.sl.logic.SL241109Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * ISL231201RsController.
 * 取得神农客分销章程信息
 *
 * @author gyh
 */
@RestController
public class ISL231201RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231201RsController.class);

    @Autowired
    private ISL231201Logic isl231201Logic;

    /**
     * 取得神农客分销章程信息
     *
     * @param param param
     * @return 结果
     * @author gyh
     */
    @RequestMapping(value = "/api/v1/sl/chapInfo",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231201Validator")
    public RsResponse<List<ISL231201RsResult>> modifyDbOrder(@RequestBody RsRequest<ISL231201RsParam> param) {
        logger.info("取得神农客分销章程信息");
        RsResponse<List<ISL231201RsResult>> rs = new RsResponse<List<ISL231201RsResult>>();
        List<ISL231201RsResult> list = new ArrayList<ISL231201RsResult>();
        if (isDebug) {
            list = isl231201Logic.findSlDistReguChap();
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setResult(list);
        } else {
            BaseParam baseParam = new BaseParam();
            baseParam.setFilter("chapClass", param.getParam().getChapClass());
            list = isl231201Logic.findSlDistReguChap(baseParam);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setResult(list);
        }
        return rs;
    }
}
