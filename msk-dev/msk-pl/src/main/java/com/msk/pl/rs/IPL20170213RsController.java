package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170213RsParam;
import com.msk.pl.logic.IPL20170213Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyh on 2017/2/6.
 * 合伙人填报设置保存接口
 */
@RestController
public class IPL20170213RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170213RsController.class);


    @Autowired
    private IPL20170213Logic ipl20170213Logic;

    @RequestMapping(value = "/api/v1/pl/partner_ruler_save",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170213Validator")
    public RsResponse partnerRulerSave(@RequestBody RsRequest<IPL20170213RsParam> param) {
        RsResponse rs = new RsResponse();
        param.getParam().setEffectiveDate(DateTimeUtil.parseDate(param.getParam().getEffectiveTime(), "yyyy-MM-dd"));
        //保存合伙人填报设置，并根据结果返回信息。
        if (ipl20170213Logic.checkEffectiveTime(param.getParam()) == true) {
            if (ipl20170213Logic.savePlRuler(param.getParam()) > 0) {
                rs.setStatus(BusinessConst.RsStatus.SUCCESS);
                rs.setMessage("合伙人填报设置成功！");
                return rs;
            }
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("合伙人填报设置失败，请检查后重试！");
            return rs;
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("合伙人填报设置生效日期必须大于等于当前日期，请检查后重试！");
            return rs;
        }
    }

}
