package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141107RsParam;
import com.msk.pd.bean.IPD141107RsResult;
import com.msk.pd.logic.IPD141107Logic;
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
 * 查询指定产品品种的标准质量档案卡信息
 * IPD141107RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141107RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141107RsController.class);

    @Autowired
    private IPD141107Logic ipd141107Logic;

    /**
     * 产品标准质量档案卡查询接口
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_tnc_std",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141107Validator")
    public RsResponse<List<IPD141107RsResult>> findPdQltStd(@RequestBody RsRequest<IPD141107RsParam> param) {
        logger.info("查询指定产品品种的标准质量档案卡信息");
        RsResponse<List<IPD141107RsResult>> rs = new RsResponse<List<IPD141107RsResult>>();

        List<IPD141107RsResult> res = this.ipd141107Logic.findListPdQltTncStd(param.getParam());
        if (res != null) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("数据正常！");
            rs.setResult(res);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage(" 产品标准质量档案卡查询异常!");
        return rs;
    }
}
