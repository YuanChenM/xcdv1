package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEpCert;
import com.msk.core.entity.SlEpCertItem;
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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Administrator on 2016/2/22.
 */
@RestController
public class ISL231130RsController extends BaseRsController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231130RsController.class);
    @Autowired
    private SL24110103Logic sl24110103Logic;
    /**
     * 查询企业专业资质证照
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpCert/delete",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231130Validator")
    public RsResponse<ISL231130RsResult> deleteSLEpCert(@RequestBody RsRequest<ISL231130RsParam> param) {
        List<ISL231127CertInfoList> certInfoList=param.getParam().getCertInfoList();
        this.sl24110103Logic.deleteSlEpCertItem(certInfoList);
        RsResponse<ISL231130RsResult> rs=new RsResponse<ISL231130RsResult>();
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("删除成功");
        return rs;
    }
}
