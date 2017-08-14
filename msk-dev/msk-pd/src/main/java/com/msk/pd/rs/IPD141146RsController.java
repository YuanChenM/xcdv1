package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141146RsParam;
import com.msk.pd.bean.IPD141146RsResult;
import com.msk.pd.logic.IPD141146Logic;
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
 * Created by yang_chunyan on 2016/4/29.
 */
@RestController
public class IPD141146RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IPD141146RsController.class);

    @Autowired
    private IPD141146Logic ipd141146Logic;
    /**
     * 产品信息查询接口
     *
     * @return RsResponse 结果
     * @author yang_chunyan
     */
    @RequestMapping(value = "/api/v1/pd/pd_pdInfo",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141146RsResult> findPdInfo(@RequestBody RsRequest<IPD141146RsParam> param) {
        logger.info("查询产品信息");
        RsResponse<IPD141146RsResult> rs = new RsResponse<IPD141146RsResult>();

        IPD141146RsResult res = ipd141146Logic.findPdInfo(param.getParam());
        if (res != null) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("数据正常！");
            rs.setResult(res);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("产品信息查询异常!");
        return rs;
    }
}
