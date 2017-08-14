package com.msk.sl.rs;

import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEpBrand;
import com.msk.core.entity.SlEpBrandHonor;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231154RsResult;
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
 * Created by cx on 2016/2/17.
 */
@RestController
public class ISL231154RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231154RsController.class);
    @Autowired
    private ISL231154RsLogic iSL231154RsLogic;
    @Autowired
    private  CommonLogic  commonLogic;

    /**
     * 增加企业产品品牌荣誉接口
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpBrandHonor/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    //@Validator(validatorClass = "com.msk.sl.validator.ISL231154Validator")
    public RsResponse<ISL231154RsResult> createSLEpBrandHonor(@RequestBody RsRequest<SlEpBrandHonor> param) {
        logger.debug("增加企业产品品牌荣誉");
        RsResponse<ISL231154RsResult> rs = new RsResponse<ISL231154RsResult>();
        ISL231154RsResult result = new ISL231154RsResult();
        SlEpBrandHonor slEpBrandHonor = param.getParam();
        //调用共通获取HONOR_ID最大值
        Long honorId = commonLogic.maxId("sl_ep_brand_honor", "HONOR_ID");
        slEpBrandHonor.setHonorId(honorId);
        //查询传过来的epId ,brandId 是否存在sl_ep_brand中
        BaseParam baseParam = new BaseParam();
        SlEpBrand slEpBrand = new SlEpBrand();
        baseParam.setFilter("epId", StringUtil.toSafeString(slEpBrandHonor.getEpId()));
        baseParam.setFilter("brandId", StringUtil.toSafeString(slEpBrandHonor.getBrandId()));
        slEpBrand = iSL231154RsLogic.findSlEpBrand(baseParam);
        if(null == slEpBrand){
            throw new BusinessException("您输入的企业品牌不存在，请输入正确数据");
        }
        //保存操作
        int num = iSL231154RsLogic.saveSLEpBrandHonor(slEpBrandHonor);
        if(num == 0){
            throw new BusinessException("保存数据失败！");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("增加企业产品品牌荣誉成功");
        return rs;
    }
}