package com.msk.pd.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141131RsParam;
import com.msk.pd.bean.IPD141131RsResult;
import com.msk.pd.logic.IPD141131Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 原种种源信息同步接口
 * IPD141131RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141131RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141131RsController.class);

    @Autowired
    private IPD141131Logic ipd141131Logic;

    /**
     * 产品等级&卫生质量标准
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_org_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141131RsResult> findBreedList(@RequestBody RsRequest<IPD141131RsParam> param) {
        RsResponse<IPD141131RsResult> rs = new RsResponse<IPD141131RsResult>();
        //查询后台,获取List数据
       IPD141131RsResult result = this.ipd141131Logic.findListOrg(param.getParam());
        if (result != null && result.getSearchList().size() > NumberConst.IntDef.INT_ZERO) {
            logger.info("查询产品特征一览查询接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询产品特征一览查询接口成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("查询产品特征一览查询接口,数据错误！");
        return rs;

    }
}
