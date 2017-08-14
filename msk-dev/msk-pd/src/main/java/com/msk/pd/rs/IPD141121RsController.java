package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141121RsParam;
import com.msk.pd.bean.IPD141121RsResult;
import com.msk.pd.logic.IPD141121Logic;
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
 * 产品技术标准接口
 * IPD141121RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141121RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141121RsController.class);

    @Autowired
    private IPD141121Logic ipd141121Logic;

    /**
     * 产品等级&卫生质量标准
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_mct_std",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141121Validator")
    public RsResponse<List<IPD141121RsResult>> findListMct(@RequestBody RsRequest<IPD141121RsParam> param) {
        RsResponse<List<IPD141121RsResult>> rs = new RsResponse<List<IPD141121RsResult>>();
        //查询后台,获取List数据
        List<IPD141121RsResult> result = this.ipd141121Logic.findListMct(param.getParam());
        rs.setResult(result);
        if (result != null) {
            logger.info("产品技术标准接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("产品技术标准接口成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("产品技术标准接口,数据错误！");
        return rs;

    }
}
