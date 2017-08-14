package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlAccount;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231105RsParam;
import com.msk.sl.bean.ISL231105RsResult;
import com.msk.sl.bean.ISL231184RsParam;
import com.msk.sl.bean.ISL231184RsResult;
import com.msk.sl.logic.ISL231184Logic;
import com.msk.sl.logic.SL241103001Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gyh on 2016/3/24.
 * 查询营业执照_注册号
 */
@RestController
public class ISL231184RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231184RsController.class);
    @Autowired
    private ISL231184Logic isl231184Logic;
    /**
     * 查询营业执照_注册号
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/check/checkLicNo",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231184Validator")
    public RsResponse checkLicNo(@RequestBody RsRequest<ISL231184RsParam> param) {
        logger.debug("查询营业执照_注册号接口");
        RsResponse<ISL231184RsResult> rs=new RsResponse<ISL231184RsResult>();
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        int count=this.isl231184Logic.getPageCount(param.getParam());
        ISL231184RsResult result=new ISL231184RsResult();
        if(count>0){
            result.setIsExistLicNo(1);
        }else{
            result.setIsExistLicNo(0);
        }
        rs.setResult(result);
        rs.setMessage("查询营业执照_注册号成功");
        return rs;
    }
}
