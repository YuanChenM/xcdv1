package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170402Param;
import com.msk.pl.bean.IPL20170402Result;
import com.msk.pl.logic.IPL20170402Logic;
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
 * Created by xuhongyang on 2017/2/6.
 */
@RestController
public class IPL20170402RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170402RsController.class);

    @Autowired
    private IPL20170402Logic ipl20170402Logic;

    @RequestMapping(value = "/api/v1/pl/bs_declaration_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170402Validator")
    public RsResponse<List<IPL20170402Result>> searchBsDeclarations(@RequestBody RsRequest<IPL20170402Param> param) {
        RsResponse<List<IPL20170402Result>> response = new RsResponse();
        if (null != param) {
            if (param.getParam() != null) {
                if (null != param.getParam().getDeclareYM()) {
                    param.getParam().setFilter("declareYM", param.getParam().getDeclareYM());
                }
            }
        }
        List<IPL20170402Result> bsDeclarations = ipl20170402Logic.searchDeclarations(param.getParam());
        if (bsDeclarations != null && bsDeclarations.size() > NumberConst.IntDef.INT_ZERO) {
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setMessage("查询成功！");
            response.setResult(bsDeclarations);
            return response;
        }
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("没有查询到数据！");
        return response;
    }

}
