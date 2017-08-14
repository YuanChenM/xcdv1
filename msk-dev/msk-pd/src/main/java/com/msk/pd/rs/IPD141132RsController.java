package com.msk.pd.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141132RsParam;
import com.msk.pd.bean.IPD141132RsResult;
import com.msk.pd.logic.IPD141132Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 饲养标准指标信息同步接口
 * IPD141132RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141132RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141132RsController.class);

    @Autowired
    private IPD141132Logic ipd141132Logic;

    /**
     * 产品等级&卫生质量标准
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_fed_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141132RsResult> findBreedList(@RequestBody RsRequest<IPD141132RsParam> param) {
        RsResponse<IPD141132RsResult> rs = new RsResponse<IPD141132RsResult>();
        //查询后台,获取List数据
        IPD141132RsResult result = this.ipd141132Logic.findListFed(param.getParam());
        if (result != null && result.getSearchList().size() > NumberConst.IntDef.INT_ZERO) {
            logger.info("查询饲养标准指标信息同步接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询饲养标准指标信息同步接口成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("查询饲养标准指标信息同步接口,数据错误！");
        return rs;

    }
}
