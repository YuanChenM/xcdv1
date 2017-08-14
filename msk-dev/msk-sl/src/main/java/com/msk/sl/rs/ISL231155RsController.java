package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEpBrandHonor;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231151RsResult;
import com.msk.sl.logic.ISL231154RsLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/23.
 */
@RestController
public class ISL231155RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231155RsController.class);
    @Autowired
    private ISL231154RsLogic iSL231154RsLogic;
    /**
     * 修改企业产品品牌荣誉接口
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpBrandHonor/update",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231155Validator")
    public RsResponse<ISL231151RsResult> updateSLPdBrandc(@RequestBody RsRequest<SlEpBrandHonor> param) {
        logger.debug("修改企业产品品牌荣誉接口");
        RsResponse<ISL231151RsResult> rs = new RsResponse<ISL231151RsResult>();
        SlEpBrandHonor slEpBrandHonor = param.getParam();
        int num = iSL231154RsLogic.updateSlEpBrandHonor(slEpBrandHonor);
        if(num==0){
            throw new BusinessException("更新失败，请输入正确的参数");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("修改企业产品品牌荣誉成功");
        return rs;
    }
}
