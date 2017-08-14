package com.msk.bs.rs;


import com.msk.bs.bean.*;
import com.msk.bs.logic.IBS2101110RsLogic;
import com.msk.bs.logic.IBS2101111RsLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
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
 * Created by gyh on 2016/4/12.
 */
@RestController
public class IBS2101111RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101111RsController.class);
    @Autowired
    private IBS2101111RsLogic ibs2101111RsLogic;
    /**
     * 查询买手囤货联盟
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/searchSlBsLeagues",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IBS2101111RsResult> updatePsd(@RequestBody RsRequest<IBS2101111RsParam> param) {
        logger.debug("查询买手囤货联盟接口");
        RsResponse<IBS2101111RsResult> rs = new RsResponse<IBS2101111RsResult>();
        IBS2101111RsResult result=new IBS2101111RsResult();
        List<IBS210111101RsResult> slBsLeaguesList = ibs2101111RsLogic.findPageList(param.getParam(),result);
        result.setSlBsLeaguesList(slBsLeaguesList);
        rs.setResult(result);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询买手囤货联盟成功");
        return rs;
    }
}
