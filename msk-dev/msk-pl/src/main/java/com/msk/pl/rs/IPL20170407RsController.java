package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170406Param;
import com.msk.pl.bean.IPL20170407Param;
import com.msk.pl.bean.PlDeclareInfo;
import com.msk.pl.logic.IPL20170405Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
@RestController
public class IPL20170407RsController extends BaseRsController{

    @Autowired
    private IPL20170405Logic ipl20170405Logic;

    @RequestMapping(value = "api/v1/pl/bs_declaration_save")
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170407Validator")
    public RsResponse<Integer> init(@RequestBody RsRequest<IPL20170407Param> ipl20170407Param) {
        RsResponse<Integer> rsResponse = new RsResponse<>();
        int count =ipl20170405Logic.savePlDeclareInfoPrice(ipl20170407Param);
        rsResponse.setResult(count);
        rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
        rsResponse.setMessage("保存成功！");
        return rsResponse;
    }
}
