package com.msk.pd.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141113RsParam;
import com.msk.pd.bean.IPD141113RsResult;
import com.msk.pd.logic.IPD141113Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * IPD141113RsController.
 *
 * @author yuan_chen
 */
@RestController
public class IPD141113RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141113RsController.class);

    /**
     * IPD141113Logic
     */
    @Autowired
    private IPD141113Logic ipd141113Logic;

    /**
     * 查询物流区产品信息
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/pd/pdBidLogiArea",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141113RsResult> query(@RequestBody RsRequest<IPD141113RsParam> param) {
        logger.info("查询物流区产品信息");
        RsResponse<IPD141113RsResult> rs = new RsResponse<IPD141113RsResult>();
        IPD141113RsResult result = ipd141113Logic.findRsResult(param.getParam());
        if (result.getTotalCount() == NumberConst.IntDef.INT_ZERO) {
            rs.setMessage("未查询到物流区产品信息！");
        } else {
            rs.setMessage("查询物流区产品信息成功！");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(result);
        return rs;
    }
}
