package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170217RsParam;
import com.msk.pl.bean.IPL20170217RsResult;
import com.msk.pl.logic.IPL20170217Logic;
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
 * 合伙人进货单查看接口
 */
@RestController
public class IPL20170217RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170217RsController.class);


    @Autowired
    private IPL20170217Logic ipl20170217Logic;

    @RequestMapping(value = "/api/v1/pl/partner_task_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170217Validator")
    public RsResponse<IPL20170217RsResult> partnerTaskList(@RequestBody RsRequest<IPL20170217RsParam> param) {
        RsResponse<IPL20170217RsResult> rs = new RsResponse<IPL20170217RsResult>();
        IPL20170217RsResult rsResult=ipl20170217Logic.plInfoList(param.getParam());
        if(rsResult.getTotalCount() == NumberConst.IntDef.INT_ZERO){
            rs.setMessage("进货单查询无数据！");
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        }else{
            rs.setMessage("进货单查询成功！");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        }
        rs.setResult(rsResult);
        return rs;
    }

}
