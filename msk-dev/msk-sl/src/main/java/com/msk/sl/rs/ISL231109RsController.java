package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlDistReguSug;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231109RsParam;
import com.msk.sl.bean.ISL231109RsResult;
import com.msk.sl.logic.ISL231109Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * ISL231109RsController.
 * 查询卖家质量标准
 *
 * @author gyh
 */
@RestController
public class ISL231109RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231109RsController.class);

    @Autowired
    private ISL231109Logic isl231109Logic;

    /**
     * 查询卖家质量标准
     *
     * @param param param
     * @return 结果
     * @author gyh
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slQlt/search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231109Validator")
    public RsResponse<ISL231109RsResult> modifyDbOrder(@RequestBody RsRequest<ISL231109RsParam> param) {
        logger.info("查询卖家产品标准");
    ISL231109RsResult results = new ISL231109RsResult();
    results.setSlPdList(this.isl231109Logic.findSlProductInfo(param.getParam()));
    RsResponse<ISL231109RsResult> rs = new RsResponse<ISL231109RsResult>();
    rs.setStatus(BusinessConst.RsStatus.SUCCESS);
//        if(!CollectionUtils.isEmpty(results)){
//            rs.setMessage("查询卖家产品标准成功");
//        }else{
//            rs.setMessage("查询卖家质量标准成功，该产品不存在质量标准");
//        }
    rs.setResult(results);
    return rs;
}
}
