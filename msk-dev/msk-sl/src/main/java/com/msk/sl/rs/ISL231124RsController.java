package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231124RsResult;
import com.msk.sl.logic.SL24110102Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/16.
 */
@RestController
public class ISL231124RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231124RsController.class);
    @Autowired
    private SL24110102Logic sL24110102Logic;

    /**
     * 修改企业基本资质接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEnterprise/update", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL241121Validator")
    public RsResponse<ISL231124RsResult> updateSLEnterprise(@RequestBody RsRequest<SlEnterprise> param) {
        logger.debug("修改企业基本资质接口");
        RsResponse<ISL231124RsResult> rs = new RsResponse<ISL231124RsResult>();
        SlEnterprise slEnterprise = param.getParam();
        sL24110102Logic.updateEp(slEnterprise);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("修改企业基本资质成功");
        return rs;
    }
}
