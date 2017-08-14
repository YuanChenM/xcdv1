package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151401RsParam;
import com.msk.so.bean.ISO151401RsResult;
import com.msk.so.logic.ISO151401Logic;
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
 * @author sjj
 */
@RestController
public class ISO151401RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151401RsController.class);

    @Autowired
    private ISO151401Logic ISO151401Logic;

    /**
     * 产品信息接口查询
     *
     * @return RsResponse 结果
     * @author sjj
     */
    @RequestMapping(value = "/api/v1/pd/pd_stock",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.so.validator.ISO151401Validator")
    public RsResponse<ISO151401RsResult> findPdInformation(@RequestBody RsRequest<ISO151401RsParam> param) {
        RsResponse<ISO151401RsResult> rs = new RsResponse<ISO151401RsResult>();
        //查询后台,获取List数据
        ISO151401RsResult result = this.ISO151401Logic.findListSl(param.getParam());
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
