package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170215RsResult;
import com.msk.pl.bean.IPL20170216RsParam;
import com.msk.pl.logic.IPL20170215Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyh on 2017/2/7.
 * 前次合伙人填报设置查询接口
 */
@RestController
public class IPL20170216RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170216RsController.class);


    @Autowired
    private IPL20170215Logic ipl20170215Logic;

    @RequestMapping(value = "/api/v1/pl/partner_feesetting_query",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170216Validator")
    public RsResponse<IPL20170215RsResult> partnerRulerQuery(@RequestBody RsRequest<IPL20170216RsParam> param) {
        RsResponse<IPL20170215RsResult> rs = new RsResponse<IPL20170215RsResult>();
        IPL20170215RsResult rsResult=ipl20170215Logic.incentiveFeeSettingQuery(param.getParam());
        if(rsResult==null){
            rs.setMessage("前次合伙人进货单激励费用设置查询无数据！");
        }else{
            rs.setMessage("前次合伙人进货单激励费用设置查询成功！");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(rsResult);
        return rs;
    }

}
