package com.msk.sl.rs;

import com.msk.common.logic.CommonLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.PdTcProvider;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231172RsParam;
import com.msk.sl.bean.ISL231172RsResult;
import com.msk.sl.bean.SL241130Param;
import com.msk.sl.logic.ISL231172Logic;
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
public class ISL231172RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231172RsController.class);

    @Autowired
    private SL241130Logic sl241130Logic;
    @Autowired
    private ISL231172Logic iSL231172Logic;
    @Autowired
    private CommonLogic commonLogic;
    /**
     * 卖家申请新产品品种/特征/净重
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slPd/newPdBFW",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231172Validator")
    public RsResponse<ISL231172RsResult> createSLPdBFW(@RequestBody RsRequest<ISL231172RsParam> param) {
        logger.debug("卖家申请新产品品种/特征/净重");
        RsResponse rs=new RsResponse();
        sl241130Logic.saveNewPd(param.getParam().getNewPdBFWList());
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("卖家申请新产品品种/特征/净重申请成功");
        return rs;
    }
}
