package com.msk.pd.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141141RsParam;
import com.msk.pd.bean.IPD141141RsResult;
import com.msk.pd.logic.IPD141141Logic;
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
public class IPD141141RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141141RsController.class);

    /**
     * IPD141141Logic
     */
    @Autowired
    private IPD141141Logic ipd141141Logic;

    /**
     * 查询物流区等级产品信息
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/pd/pdGradeBidLogiArea",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141141RsResult> query(@RequestBody RsRequest<IPD141141RsParam> param) {
        logger.info("查询物流区等级产品信息");
        RsResponse<IPD141141RsResult> rs = new RsResponse<IPD141141RsResult>();
        IPD141141RsResult result = ipd141141Logic.findRsResult(param.getParam());
        if (result.getTotalCount() == NumberConst.IntDef.INT_ZERO) {
            rs.setMessage("未查询到物流区产品信息！");
        } else {
            rs.setMessage("查询物流区等级产品信息成功！");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(result);
        return rs;
    }
}
