package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.StringConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231153RsParam;
import com.msk.sl.bean.ISL231153RsResult;
import com.msk.sl.logic.ISL231150RsLogic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/23.
 */
@RestController
public class ISL231153RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231153RsController.class);
    @Autowired
    private ISL231150RsLogic iSL231150RsLogic;
    /**
     * 查询卖家产品品牌
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slPdBrandcTeam/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231153Validator")
    public RsResponse<ISL231153RsResult> querySLPdBrandc(@RequestBody RsRequest<ISL231153RsParam> param) {
        logger.debug("查询卖家产品品牌接口");
        RsResponse<ISL231153RsResult> rs = new RsResponse<ISL231153RsResult>();
        ISL231153RsResult result = new ISL231153RsResult();
        result = iSL231150RsLogic.findSLPdBrandcAllList(param);
        if(CollectionUtils.isNotEmpty(result.getSlPdBrandList()) && result.getSlPdBrandList().size()>0){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        }
        rs.setResult(result);
        rs.setMessage("查询卖家产品品牌成功");
        return rs;
    }
}
