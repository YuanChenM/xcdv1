package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141138RsParam;
import com.msk.pd.bean.IPD141138RsResult;
import com.msk.pd.logic.IPD141138Logic;
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
 * 产品净重一览查询接口
 * IPD141138RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141138RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141138RsController.class);

    @Autowired
    private IPD141138Logic ipd141138Logic;

    /**
     * 产品净重一览查询接口
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_weight",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141138Validator")
    public RsResponse<List<IPD141138RsResult>> findBreedList(@RequestBody RsRequest<IPD141138RsParam> param) {
        RsResponse<List<IPD141138RsResult>> rs = new RsResponse<List<IPD141138RsResult>>();
        //查询后台,获取List数据
        List<IPD141138RsResult> result = this.ipd141138Logic.findListWeight(param.getParam());
        if (result.size() > NumberConst.IntDef.INT_ZERO) {
            logger.info("查询产品净重一览查询接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询产品净重一览查询接口成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("查询产品净重一览查询接口,数据错误！");
        return rs;

    }
}
