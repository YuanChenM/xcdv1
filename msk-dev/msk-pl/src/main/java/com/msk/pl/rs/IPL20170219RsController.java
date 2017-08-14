package com.msk.pl.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170214RsParam;
import com.msk.pl.bean.PlTerminalPartner;
import com.msk.pl.logic.IPL20170219Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by gyh on 2017/2/8.
 * 合伙人任务审核接口
 */
@RestController
public class IPL20170219RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170219RsController.class);


    @Autowired
    private IPL20170219Logic ipl20170219Logic;

    @RequestMapping(value = "/api/v1/pl/partner_terminal_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<List<PlTerminalPartner>> partneTerminalList(@RequestBody RsRequest<IPL20170214RsParam> param) {
        RsResponse<List<PlTerminalPartner>> rs = new RsResponse<List<PlTerminalPartner>>();
        List<PlTerminalPartner> terminalPartners = ipl20170219Logic.findTerminalList(param.getParam());
        if (CollectionUtils.isEmpty(terminalPartners)) {
            rs.setMessage("该合伙人下没有配送站信息！");
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        } else {
            rs.setMessage("查询成功！");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        }
        rs.setResult(terminalPartners);
        return rs;
    }

}
