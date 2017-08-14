package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD142001RsParam;
import com.msk.pd.bean.IPD142001RsResult;
import com.msk.pd.logic.IPD142001Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * IPD141141RsController.
 *
 * @author xhy
 */
@RestController
public class IPD142001RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IPD142001RsController.class);

    /**
     * IPD141141Logic
     */
    @Autowired
    private IPD142001Logic ipd141141ComLogic;

    /**
     * 共同设定查询
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/common/master_setting",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD142001Validator")
    public RsResponse<IPD142001RsResult> query(@RequestBody RsRequest<IPD142001RsParam> param) {
        logger.info("查询物流区等级产品信息");
        RsResponse<IPD142001RsResult> rs = new RsResponse<IPD142001RsResult>();
        IPD142001RsResult result = ipd141141ComLogic.findRsResultCom(param.getParam());
        if (result.getCommList().size() == NumberConst.IntDef.INT_ZERO) {
            rs.setMessage("共同设定查询失败！");
        } else {
            rs.setMessage("共同设定查询成功！");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(result);
        return rs;
    }
}
