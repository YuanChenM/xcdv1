package com.msk.pd.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141142RsParam;
import com.msk.pd.bean.IPD141142RsResult;
import com.msk.pd.logic.IPD141142Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * IPD142142RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141142RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141142RsController.class);

    /**
     * IPD142142Logic
     */
    @Autowired
    private IPD141142Logic ipd141142Logic;

    /**
     * 查询物流区等级产品信息
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/pd/pd_standard_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IPD141142RsResult> query(@RequestBody RsRequest<IPD141142RsParam> param) {
        logger.info("查询物流区等级产品信息");
        RsResponse<IPD141142RsResult> rs = new RsResponse<IPD141142RsResult>();
        //查询后台,获取List数据
        IPD141142RsResult result = this.ipd141142Logic.findPdStandardIdList(param.getParam());
        if (result != null && result.getSearchList().size() > NumberConst.IntDef.INT_ZERO) {
            logger.info("查询产品标准数据接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询产品标准数据接口成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("查询产品标准数据接口,数据错误！");
        return rs;
    }
}
