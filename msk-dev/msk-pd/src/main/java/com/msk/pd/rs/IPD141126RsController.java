package com.msk.pd.rs;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141126RsParam;
import com.msk.pd.bean.IPD141126RsResult;
import com.msk.pd.logic.IPD141126Logic;

/**
 * Created by FjM on 2016/3/11.
 */
@RestController
public class IPD141126RsController extends BaseRsController {
    private static Logger logger = LoggerFactory.getLogger(IPD141126RsController.class);

    @Autowired
    private IPD141126Logic ipd141126Logic;

    @RequestMapping(value = "/api/v1/pd/pd_tsp_std",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.pd.validator.IPD141126Validator")
    public RsResponse<List<IPD141126RsResult>> selectSource(@RequestBody RsRequest<IPD141126RsParam> param) {
        logger.debug("存储运输指标档案卡查询接口");
        // 新建响应对象
        RsResponse<List<IPD141126RsResult>> rsResponse = new RsResponse<List<IPD141126RsResult>>();
        List<IPD141126RsResult> s = this.ipd141126Logic.selectSource(param);

        if (s.size() >= 1) {
            rsResponse.setResult(s);
            rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
            rsResponse.setMessage("存储运输指标档案卡查询成功");
            return rsResponse;
        }

        rsResponse.setStatus(BusinessConst.RsStatus.FAIL);
        logger.debug("没有查询到数据！");
        rsResponse.setMessage("没有查询到数据！");
        return rsResponse;

    }
}
