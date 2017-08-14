package com.msk.sl.rs;

import com.msk.common.logic.CommonLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEnterprise;
import com.msk.core.entity.SlEpBrand;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231146RsResult;
import com.msk.sl.logic.ISL231146RsLogic;
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
public class ISL231146RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231146RsController.class);
    @Autowired
    private ISL231146RsLogic iSL231146RsLogic;
    @Autowired
    private CommonLogic commonLogic;
    /**
     * 增加企业产品品牌接口
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpBrandcTeam/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231146Validator")
    public RsResponse<ISL231146RsResult> createSLEpBrandc(@RequestBody RsRequest<SlEpBrand> param) {
        logger.debug("增加企业产品品牌接口");
        RsResponse<ISL231146RsResult> rs = new RsResponse<ISL231146RsResult>();
        ISL231146RsResult isl231146RsResult=new ISL231146RsResult();
        SlEpBrand slEpBrand = param.getParam();
        //epId外间关联sl_enterprise（企业资质）
        //查询传过来的epid是否存在sl_enterprise中
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("epId", StringUtil.toSafeString(slEpBrand.getEpId()));
        SlEnterprise slEnterprise = iSL231146RsLogic.findEpId(baseParam);
        if(null == slEnterprise){
            throw new BusinessException("您输入的企业团队没有对应的企业，请输入正确的epId");
        }
        Long brandId=commonLogic.maxId("sl_ep_brand", "BRAND_ID");
        slEpBrand.setBrandId(brandId);
        int num = iSL231146RsLogic.saveSLEpBrandc(slEpBrand);
        if(num == 0){
            throw new BusinessException("保存失败，请输入正确的参数");
        }
        isl231146RsResult.setBrandId(brandId);
        rs.setResult(isl231146RsResult);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("增加企业产品品牌成功");
        return rs;
    }
}
