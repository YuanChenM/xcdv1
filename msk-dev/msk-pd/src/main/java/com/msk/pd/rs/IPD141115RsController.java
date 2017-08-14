package com.msk.pd.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141115RsParam;
import com.msk.pd.bean.IPD141115RsResult;
import com.msk.pd.logic.IPD141115Logic;
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
 * 产品信息
 * IPD141115RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141115RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141115RsController.class);

    @Autowired
    private IPD141115Logic ipd141115Logic;

    /**
     * 产品信息接口查询
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pdBidInfo",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141115RsResult> findPdInformation(@RequestBody RsRequest<IPD141115RsParam> param) {
        RsResponse<IPD141115RsResult> rs = new RsResponse<IPD141115RsResult>();
        //查询后台,获取List数据
      IPD141115RsResult result = this.ipd141115Logic.findListPdInformation(param.getParam());
        if (result != null) {
            logger.info("查询产品信息成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询产品信息成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("没有查询到数据！");
        return rs;

    }
}
