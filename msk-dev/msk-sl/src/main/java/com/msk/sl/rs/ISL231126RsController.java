package com.msk.sl.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231126RsParam;
import com.msk.sl.bean.ISL231126RsResult;
import com.msk.sl.logic.ISL231126RsLogic;
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
 * Created by cx on 2016/2/16.
 */
@RestController
public class ISL231126RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231126RsController.class);
    @Autowired
    private ISL231126RsLogic iSL231126RsLogic;
    /**
     * 查询证照基础信息接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slMstCertInfo/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<List<ISL231126RsResult>> search(@RequestBody RsRequest<ISL231126RsParam> param) {
        logger.debug("查询证照基础信息接口");
        RsResponse<List<ISL231126RsResult>> rs = new RsResponse<List<ISL231126RsResult>>();
        rs.setResult(iSL231126RsLogic.search(param.getParam()));
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询证照基础信息成功");
        return rs;
    }
}
