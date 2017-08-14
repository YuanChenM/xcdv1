package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231101RsParam;
import com.msk.sl.bean.ISL231101RsResult;
import com.msk.sl.logic.ISL231101Logic;
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
 * Created by gyh on 2016/1/14.
 */
@RestController
public class ISL231101RsController extends BaseRsController {
    /**logger*/
    private static Logger logger = LoggerFactory.getLogger(ISL231101RsController.class);
    @Autowired
    private ISL231101Logic isl231101Logic;

    /**
     * 卖家信息接口
     * @param param param
     * @return 卖家信息
     */
    @RequestMapping(value = "/api/v1/sl/slInfo",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231101Validator")
    public RsResponse<List<ISL231101RsResult>> slInfo(@RequestBody RsRequest<ISL231101RsParam> param){
        RsResponse<List<ISL231101RsResult>> rs=new RsResponse<List<ISL231101RsResult>>();
        ISL231101RsParam isl231101RsParam=param.getParam();
        if(isDebug){
            rs.setResult(isl231101Logic.findSlInfo());
        }else{
            rs.setResult(isl231101Logic.findSlInfo(isl231101RsParam));
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("取得卖家信息成功");
        return rs;
    }
}
