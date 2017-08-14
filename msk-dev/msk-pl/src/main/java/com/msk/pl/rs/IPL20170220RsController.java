package com.msk.pl.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170214RsParam;
import com.msk.pl.bean.PlDomainBs;
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
 * 合伙人下买手列表查询
 */
@RestController
public class IPL20170220RsController extends BaseRsController {


    private static Logger logger = LoggerFactory.getLogger(IPL20170220RsController.class);


    @Autowired
    private IPL20170219Logic ipl20170219Logic;

    @RequestMapping(value = "/api/v1/pl/partner_bs_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<List<PlDomainBs>> partnerBsList(@RequestBody RsRequest<IPL20170214RsParam> param) {
        RsResponse<List<PlDomainBs>> rs = new RsResponse<List<PlDomainBs>>();
        List<PlDomainBs> domainBses = ipl20170219Logic.findDomainBsList(param.getParam());
        if (CollectionUtils.isEmpty(domainBses)) {
            rs.setMessage("该合伙人下没有买手信息！");
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        } else {
            rs.setMessage("查询成功！");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        }
        rs.setResult(domainBses);
        return rs;
    }

}
