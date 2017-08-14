package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.*;
import com.msk.pd.logic.IPD141122Logic;
import com.msk.pd.logic.IPD141124Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by FjM on 2016/3/10.
 */
@RestController
public class IPD141124RsController extends BaseRsController{

    private static Logger logger = LoggerFactory.getLogger(IPD141122RsController.class);

    @Autowired
    private IPD141124Logic ipd141124RsLogic;

    @RequestMapping(value = "/api/v1/pd/pd_fed_std",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141124Validator")
    public RsResponse<List<PD141147Bean>> selectSource(@RequestBody RsRequest<IPD141124RsParam> param){
        logger.info("饲养指标档案卡查询接口");
        //新建响应对象
        /*RsResponse<IPD141124RsResult> rsResponse = new RsResponse<IPD141124RsResult>();*/
        RsResponse<List<PD141147Bean>> rsResponse = new RsResponse<List<PD141147Bean>>();
        /*IPD141124RsResult ipdResult = new IPD141124RsResult();*/
        List<PD141147Bean> s= this.ipd141124RsLogic.selectSource(param);

        if(s.size() >= 1){
            rsResponse.setResult(s);
            rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
            rsResponse.setMessage("饲养指标档案卡查询成功");
            return rsResponse;
        }

        rsResponse.setStatus(BusinessConst.RsStatus.FAIL);


        logger.info("没有查询到数据！");
        rsResponse.setMessage("没有查询到数据！");
        return rsResponse;

    }
}
