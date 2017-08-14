package com.msk.pl.rs;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.PlPdMst;
import com.msk.pl.logic.IPL20170403Logic;
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
public class IPL20170403RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170403RsController.class);

    @Autowired
    private IPL20170403Logic ipl20170403Logic;

    @RequestMapping(value = "/api/v1/pl/pd_classes",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<List<PlPdMst>> findDateList(@RequestBody RsRequest<BaseParam> param) {
        RsResponse<List<PlPdMst>> response = new RsResponse();
        List<PlPdMst> classesList = ipl20170403Logic.searchClasses();
        if (classesList != null && classesList.size() > NumberConst.IntDef.INT_ZERO) {
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setMessage("产品一级分类查询成功！");
            response.setResult(classesList);
            return response;
        }
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("没有查询到数据！");
        return response;
    }

}
