package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.PdTcProviderPackage;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141144RsParam;
import com.msk.pd.bean.IPD141144RsResult;
import com.msk.pd.bean.IPD141145RsParam;
import com.msk.pd.bean.IPD141145RsResult;
import com.msk.pd.logic.IPD141144Logic;
import com.msk.pd.logic.IPD141145Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * 卖家申请产品审核状态查询
 * IPD141145RsController.
 *
 * @author gyh
 */
@RestController
public class IPD141145RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141145RsController.class);

    @Autowired
    private IPD141145Logic ipd141145Logic;

    /**
     * 卖家申请产品审核状态查询
     *
     * @return RsResponse 结果
     * @author gyh
     */
    @RequestMapping(value = "/api/v1/pd/slpd_audit_status",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141145Validator")
    public RsResponse<IPD141145RsResult> findPdInformation(@RequestBody RsRequest<IPD141145RsParam> param) {
        RsResponse<IPD141145RsResult> rs = new RsResponse<IPD141145RsResult>();
        //查询后台,获取List数据
        IPD141145RsResult result = new IPD141145RsResult();
        result.setSellerCode(param.getParam().getSellerCode());
        List<PdTcProviderPackage> pdList = this.ipd141145Logic.findPageList(param.getParam(), result);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        if (!CollectionUtils.isEmpty(pdList) && pdList.size() > 0) {
            logger.info("卖家申请产品审核状态查询成功");
            result.setPdList(pdList);
            rs.setMessage("卖家申请产品审核状态查询成功！");
            rs.setResult(result);
        }
        rs.setMessage("没有查询到数据！");
        return rs;

    }
}
