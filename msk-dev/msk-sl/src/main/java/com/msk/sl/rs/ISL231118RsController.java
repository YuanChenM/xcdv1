package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlProduct;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231101RsParam;
import com.msk.sl.bean.ISL231101RsResult;
import com.msk.sl.bean.ISL231118RsParam;
import com.msk.sl.logic.ISL231118Logic;
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
public class ISL231118RsController extends BaseRsController {

    /**logger*/
    private static Logger logger = LoggerFactory.getLogger(ISL231118RsController.class);
    @Autowired
    private ISL231118Logic isl231118Logic;

    /**
     * 卖家信息接口
     * @param param param
     * @return 卖家信息
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/searchSlPd",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231118Validator")
    public RsResponse<List<SlProduct>> searchSlPd(@RequestBody RsRequest<ISL231118RsParam> param){
        logger.debug("接口：取得卖家能销售的产品信息");
        RsResponse<List<SlProduct>> rs=new RsResponse<List<SlProduct>>();
        ISL231118RsParam isl231118RsParam=param.getParam();
        if(isDebug){
            rs.setResult(isl231118Logic.findSlPdInfo());
        }else{
            rs.setResult(isl231118Logic.findSlPdInfo(isl231118RsParam));
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("取得卖家能销售的产品信息成功！");
        return rs;
    }
}
