package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170221RsParam;
import com.msk.pl.bean.IPL20170221RsResult;
import com.msk.pl.logic.IPL20170221Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyh on 2017/2/9.
 * 合伙人进货单统计查询接口
 */
@RestController
public class IPL20170222RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170222RsController.class);


    @Autowired
    private IPL20170221Logic ipl20170221Logic;

    @RequestMapping(value = "/api/v1/pl/partner_task_sum",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170221Validator")
    public RsResponse<IPL20170221RsResult> partnerTaskSum(@RequestBody RsRequest<IPL20170221RsParam> param) {
        RsResponse<IPL20170221RsResult> rs = new RsResponse<IPL20170221RsResult>();
        //1:计费查询 2:进货单统计查询
        param.getParam().setSelectType(2);
        IPL20170221RsResult result=ipl20170221Logic.partnerFeeList(param.getParam());
        if(result.getTotalCount() == NumberConst.IntDef.INT_ZERO){
            rs.setMessage("合伙人进货单统计查询无数据！");
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        }else{
            rs.setMessage("合伙人进货单统计查询成功！");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        }
        rs.setResult(result);
        return rs;
    }

}
