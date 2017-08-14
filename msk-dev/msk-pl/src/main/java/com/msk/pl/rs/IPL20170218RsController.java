package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.PLInfo;
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
 * Created by gyh on 2017/2/8.
 * 合伙人任务审核接口
 */
@RestController
public class IPL20170218RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170218RsController.class);


    @Autowired
    private IPL20170217Logic ipl20170217Logic;

    @RequestMapping(value = "/api/v1/pl/partner_task_modify",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170218Validator")
    public RsResponse partnerTaskModify(@RequestBody RsRequest<PLInfo> param) {
        RsResponse rs = new RsResponse();
        if( ipl20170217Logic.modifyPlInfo(param.getParam()) > NumberConst.IntDef.INT_ZERO){
            rs.setMessage("进货单审核成功！");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            return rs;
        }
        rs.setMessage("进货单审核失败，请重试！");
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        return rs;
    }

}
