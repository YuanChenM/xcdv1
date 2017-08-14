package com.msk.pd.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pd.bean.IPD141147RsParam;
import com.msk.pd.bean.IPD141147RsResult;
import com.msk.pd.logic.IPD141147Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 产品对应生产商查询
 * IPD141111RsController.
 *
 * @author pxg
 */
@RestController
public class IPD141147RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IPD141147RsController.class);

    @Autowired
    private IPD141147Logic ipd141147Logic;

    /**
     * 产品对应生产商查询
     *
     * @param param param
     * @return 结果
     * @author zhou_Ling
     */
    @RequestMapping(value = "/api/v1/pd/pd_manufacture_info",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pd.validator.IPD141147Validator")
    public RsResponse<List<IPD141147RsResult>> createClasses(@RequestBody RsRequest<IPD141147RsParam> param) {
        // 查询所有产品类别信息
        RsResponse<List<IPD141147RsResult>> rs = new RsResponse<List<IPD141147RsResult>>();
        List<IPD141147RsResult> result = ipd141147Logic.queryData(param.getParam());
        if(!CollectionUtils.isEmpty(result) && result.size()>0){
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("数据查询成功!");
            rs.setResult(result);
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("数据不存在!");
        }
        return rs;
    }

}
