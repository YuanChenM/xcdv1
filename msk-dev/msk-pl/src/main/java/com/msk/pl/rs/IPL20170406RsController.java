package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170406Param;
import com.msk.pl.bean.PlDeclareInfo;
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
public class IPL20170406RsController extends BaseRsController{

    @Autowired
    private IPL20170405Logic ipl20170405Logic;

    @RequestMapping(value = "api/v1/pl/bs_declaration_sync")
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170406Validator")
    public RsResponse<List<PlDeclareInfo>> init(@RequestBody RsRequest<IPL20170406Param> ipl20170406Param) {
        RsResponse<List<PlDeclareInfo>> rsResponse = new RsResponse<>();
        List<PlDeclareInfo> plPdMstList =ipl20170405Logic.plDeclareInfoList(ipl20170406Param.getParam());
        rsResponse.setResult(plPdMstList);
        if(!CollectionUtils.isEmpty(plPdMstList)){
            rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
            rsResponse.setMessage("查询成功！");
        }else {
            rsResponse.setStatus(BusinessConst.RsStatus.FAIL);
            rsResponse.setMessage("未查询到数据！");
        }

        return rsResponse;
    }
}
