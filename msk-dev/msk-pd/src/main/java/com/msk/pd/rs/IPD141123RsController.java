package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.*;
import com.msk.pd.logic.IPD141123Logic;
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
 * Created by FjM on 2016/3/14.
 */
@RestController
public class IPD141123RsController extends BaseRsController{
    private static Logger logger = LoggerFactory.getLogger(IPD141125RsController.class);

    @Autowired
    private IPD141123Logic ipd141123Logic;

    @RequestMapping(value = "/api/v1/pd/pd_org_std",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141123Validator")
    public RsResponse<List<IPD141123RsResult>> selectSource(@RequestBody RsRequest<IPD141123RsParam> param){
        logger.info("原种种源档案卡查询接口");
        //新建响应对象
        /*RsResponse<IPD141124RsResult> rsResponse = new RsResponse<IPD141124RsResult>();*/
        RsResponse<List<IPD141123RsResult>> rsResponse = new RsResponse<List<IPD141123RsResult>>();
        /*IPD141124RsResult ipdResult = new IPD141124RsResult();*/
        List<IPD141123RsResult> s= this.ipd141123Logic.selectSource(param);

        if(s.size() >= 1){
            rsResponse.setResult(s);
            rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
            rsResponse.setMessage("原种种源档案卡查询成功");
            return rsResponse;
        }

        rsResponse.setStatus(BusinessConst.RsStatus.FAIL);


        logger.info("没有查询到数据！");
        rsResponse.setMessage("没有查询到数据！");
        return rsResponse;

    }
}
