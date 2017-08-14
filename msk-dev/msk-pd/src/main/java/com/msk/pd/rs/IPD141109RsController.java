package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141109RsParam;
import com.msk.pd.logic.IPD141109Logic;
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
 * 产品标准包装档案卡添加接口
 * IPD141109RsController.
 *
 * @author xhy
 */
@RestController
public class IPD141109RsController extends BaseRsController {

    /**
     * logger 日志
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141109RsController.class);

    @Autowired
    private IPD141109Logic ipd141109Logic;

    /**
     * 产品标准包装档案卡添加接口
     *
     * @return RsResponse 结果
     * @author xhy
     */
    @RequestMapping(value = "/api/v1/pd/pd_norms_std/new",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141109Validator")
    public RsResponse<IPD141109RsParam> findPdNormsStd(@RequestBody RsRequest<IPD141109RsParam> param) {
        RsResponse<IPD141109RsParam> rs = new RsResponse<IPD141109RsParam>();
        IPD141109RsParam result = new IPD141109RsParam();

        if (isDebug) {
            // 测试数据
            logger.info("产品标准包装档案卡添加接口,测试数据");
            result.setNormsCode("01");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("保存成功！");
            rs.setResult(result);
            return rs;
        }
        String normsCode = this.ipd141109Logic.saveNorms(param.getParam());
        if (StringUtils.isNotBlank(normsCode)) {
            result.setNormsCode(normsCode);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("保存成功！");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("保存失败！");
        return rs;

    }
}
