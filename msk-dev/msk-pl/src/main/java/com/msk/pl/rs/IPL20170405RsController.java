package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170405Param;
import com.msk.pl.bean.IPL20170405Result;
import com.msk.pl.bean.PlDeclareInfo;
import com.msk.pl.bean.PlPdMst;
import com.msk.pl.logic.IPL20170405Logic;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
@RestController
public class IPL20170405RsController extends BaseRsController {

    @Autowired
    private IPL20170405Logic ipl20170405Logic;

    @RequestMapping(value = "api/v1/pl/bs_declaration_detail")
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170405Validator")
    public RsResponse<IPL20170405Result> init(@RequestBody RsRequest<IPL20170405Param> ipl20170405Param) {
        RsResponse<IPL20170405Result> rsResponse = new RsResponse<>();
        IPL20170405Result result = ipl20170405Logic.plDeclareInfoPageList(ipl20170405Param.getParam());
        rsResponse.setResult(result);
        if(!CollectionUtils.isEmpty(result.getDtList())){
            rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
            rsResponse.setMessage("查询成功！");
        }else {
            rsResponse.setStatus(BusinessConst.RsStatus.FAIL);
            rsResponse.setMessage("未查询到数据！");
        }

        return rsResponse;
    }
}
