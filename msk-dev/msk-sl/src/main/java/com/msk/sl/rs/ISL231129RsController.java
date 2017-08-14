package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.*;
import com.msk.sl.logic.SL24110103Logic;
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
 * Created by Administrator on 2016/2/22.
 */
@RestController
public class ISL231129RsController extends BaseRsController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231129RsController.class);
    @Autowired
    private SL24110103Logic sl24110103Logic;
    /**
     * 查询企业专业资质证照
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpCert/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231129Validator")
    public RsResponse<ISL231129RsResult> querySLEpCertItem(@RequestBody RsRequest<ISL231129RsParam> param) {
        Integer epId=param.getParam().getEpId();
        ISL231129RsResult isl231129RsResult = this.sl24110103Logic.findListById(epId);
        RsResponse<ISL231129RsResult> rs = new RsResponse<ISL231129RsResult>();
        rs.setResult(isl231129RsResult);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("更新成功");
        return rs;
    }
}
