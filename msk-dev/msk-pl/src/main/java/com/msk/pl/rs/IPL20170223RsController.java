package com.msk.pl.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170223RsParam;
import com.msk.pl.bean.IPL20170223RsResult;
import com.msk.pl.logic.IPL20170223Logic;
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
 * 合伙人任务完成统计接口
 */
@RestController
public class IPL20170223RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170223RsController.class);


    @Autowired
    private IPL20170223Logic ipl20170231Logic;

    @RequestMapping(value = "/api/v1/pl/partner_task_percent",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPL20170223RsResult> partnerTaskPercent(@RequestBody RsRequest<IPL20170223RsParam> param) {
        RsResponse<IPL20170223RsResult> rs = new RsResponse<IPL20170223RsResult>();
        IPL20170223RsResult result = ipl20170231Logic.partnerTaskPercent(param.getParam());
        if (result.getTotalCount() == NumberConst.IntDef.INT_ZERO) {
            rs.setMessage("合伙人任务完成统计无数据！");
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        } else {
            rs.setMessage("合伙人任务完成统计成功！");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        }
        rs.setResult(result);
        return rs;
    }

}
