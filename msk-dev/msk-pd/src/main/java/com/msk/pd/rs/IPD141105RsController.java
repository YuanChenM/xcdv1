package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141105RsParam;
import com.msk.pd.bean.IPD141105RsResult;
import com.msk.pd.logic.IPD141105Logic;
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
 * 查询产品主码数据列表 产品主码查询接口
 * IPD141105RsController.
 * 
 * @author xhy
 */
@RestController
public class IPD141105RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IPD141105RsController.class);

    @Autowired
    private IPD141105Logic ipd141105Logic;

    /**
     * 产品主码查询接口
     * 
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_standard",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.pd.validator.IPD141105Validator")
    public RsResponse<List<IPD141105RsResult>> findStandard(@RequestBody RsRequest<IPD141105RsParam> param) {
        logger.info("查询订单主码数据");
        RsResponse<List<IPD141105RsResult>> rs = new RsResponse<List<IPD141105RsResult>>();

        // 查询订单主码
        List<IPD141105RsResult> findAllPdCode = this.ipd141105Logic.findAllPdCode(param.getParam());
        if (findAllPdCode != null) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("数据查询正常正常！");
            rs.setResult(findAllPdCode);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("数据库中没有对应的产品类型数据!");
        rs.setResult(null);
        return rs;
    }
}
