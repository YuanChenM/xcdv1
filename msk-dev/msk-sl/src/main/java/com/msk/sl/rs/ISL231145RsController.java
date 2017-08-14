package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231145RsParam;
import com.msk.sl.bean.ISL231145RsResult;
import com.msk.sl.logic.SL241103009Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/19.
 */
@RestController
public class ISL231145RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231145RsController.class);
    @Autowired
    private SL241103009Logic sL241103009Logic;
    /**
     * 查询卖家电商团队接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEcTeam/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231145Validator")
    public RsResponse<ISL231145RsResult> querySLEpManager(@RequestBody RsRequest<ISL231145RsParam> param) {
        logger.debug("查询卖家电商团队接口");
        RsResponse<ISL231145RsResult> rs = new RsResponse<ISL231145RsResult>();
        ISL231145RsResult result = new ISL231145RsResult();
        result = sL241103009Logic.findSlEcTeamAllList(param);
        rs.setResult(result);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询卖家电商团队成功");
        return rs;
    }
}
