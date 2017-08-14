package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141108RsParam;
import com.msk.pd.bean.IPD141108RsResult;
import com.msk.pd.logic.IPD141108Logic;
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
 * 产品标准包装档案卡查询参数接口
 * IPD141108RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141108RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141108RsController.class);

    @Autowired
    private IPD141108Logic ipd141108Logic;

    /**
     * 产品标准包装档案卡查询参数接口
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_norms_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141108Validator")
    public RsResponse<List<IPD141108RsResult>> findPdNormsStd(@RequestBody RsRequest<IPD141108RsParam> param) {
        logger.info(" 产品标准包装档案卡查询参数接口");
        RsResponse<List<IPD141108RsResult>> rs = new RsResponse<List<IPD141108RsResult>>();
        List<IPD141108RsResult> res = ipd141108Logic.findListPdQltTncStd(param.getParam());
        if (res.size() > NumberConst.IntDef.INT_ZERO) {
            logger.info(" 产品标准包装档案卡查询参数接口,DB,查询OK");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("数据正常！");
            rs.setResult(res);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("产品标准包装档案卡查询接口,数据错误！");
        return rs;
    }
}
