package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141144RsParam;
import com.msk.pd.bean.IPD141144RsResult;
import com.msk.pd.logic.IPD141144Logic;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 卖家产品库存查询
 * IPD141144RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141144RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141144RsController.class);

    @Autowired
    private IPD141144Logic ipd141144Logic;

    /**
     * 产品信息接口查询
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_stock/该接口移入订单模块ISO151401RsController（避免url重复）",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141144Validator")
    public RsResponse<IPD141144RsResult> findPdInformation(@RequestBody RsRequest<IPD141144RsParam> param) {
        RsResponse<IPD141144RsResult> rs = new RsResponse<IPD141144RsResult>();
        //查询后台,获取List数据
        IPD141144RsResult result = this.ipd141144Logic.findListSl(param.getParam());
        if (null != result && StringUtils.isNotBlank(result.getSellerCode())) {
            logger.info("卖家产品库存查询成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询卖家产品库存查询接口成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("没有查询到数据！");
        return rs;

    }
}
