package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231180RsParam;
import com.msk.sl.bean.ISL231180RsResult;
import com.msk.sl.logic.ISL231180RsLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/2/29.
 */
@RestController
public class ISL231180RsController extends BaseRsController {
    /**注入ISL231180logic*/
    @Autowired
    private ISL231180RsLogic isl231180Logic;
    /**
     * 编辑卖家信息All
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/newOrUpdateAll", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231180Validator")
    public RsResponse<ISL231180RsResult> deleteSLProduct(@RequestBody RsRequest<ISL231180RsParam> param) {
        RsResponse<ISL231180RsResult> rs=new RsResponse<ISL231180RsResult>();
        ISL231180RsParam isl231180RsParam=param.getParam();
        if("1".equals(isl231180RsParam.getDelFlg()) && !(StringUtil.isEmpty(isl231180RsParam.getSlAccount().getSlAccount()))){
            /**删除操作*/
            this.isl231180Logic.deleteSlAccount(isl231180RsParam);
            rs.setMessage("删除成功");
        }else{
            /**获取创建者的ID*/
            ISL231180RsResult isl231180RsResult=this.isl231180Logic.saveSlData(isl231180RsParam);
            rs.setResult(isl231180RsResult);
            rs.setMessage("编辑成功");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        return rs;
    }

}











