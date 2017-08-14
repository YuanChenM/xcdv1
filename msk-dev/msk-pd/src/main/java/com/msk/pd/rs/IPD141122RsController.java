package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141108RsParam;
import com.msk.pd.bean.IPD141122RsParam;
import com.msk.pd.bean.IPD141122RsResult;
import com.msk.pd.logic.IPD141122Logic;
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
 * Created by fjm on 2016/3/9.
 */

@RestController
public class IPD141122RsController extends BaseRsController{

    private static Logger logger = LoggerFactory.getLogger(IPD141122RsController.class);

    @Autowired
    private IPD141122Logic ipd141122RsLogic;

    @RequestMapping(value = "/api/v1/pd/pd_mat",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141122Validator")
    public RsResponse<IPD141122RsResult> selectSource(@RequestBody RsRequest<IPD141122RsParam> param){

        logger.info("原料种源信息查询接口");
        RsResponse<IPD141122RsResult> rsResponse = new RsResponse<IPD141122RsResult>();

        IPD141122RsResult ipdResult = new IPD141122RsResult();

        ipdResult = this.ipd141122RsLogic.selectSource(param);

        if(ipdResult != null){
            rsResponse.setResult(ipdResult);
            rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
            rsResponse.setMessage("原料种源信息查询成功");
            return rsResponse;
        }

        rsResponse.setStatus(BusinessConst.RsStatus.FAIL);
        logger.info("没有查询到数据！");
        rsResponse.setMessage("没有查询到数据！");
        return rsResponse;




    }


}
