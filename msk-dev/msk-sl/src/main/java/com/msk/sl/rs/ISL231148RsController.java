package com.msk.sl.rs;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEpBrand;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231148RsResult;
import com.msk.sl.logic.ISL231146RsLogic;
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
 * Created by cx on 2016/2/18.
 */
@RestController
public class ISL231148RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231148RsController.class);
    @Autowired
    private ISL231146RsLogic iSL231146RsLogic;
    /**
     * 删除企业产品品牌接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpBrandcTeam/delete",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    //@Validator(validatorClass = "com.msk.sl.validator.ISL231148Validator")
    public RsResponse<ISL231148RsResult> deleteSLEpBrandc(@RequestBody RsRequest<SlEpBrand> param) {
        logger.debug("删除企业产品品牌接口");
        RsResponse<ISL231148RsResult> rs = new RsResponse<ISL231148RsResult>();
        SlEpBrand slEpBrand = param.getParam();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("epId", StringUtil.toSafeString(slEpBrand.getEpId()));
        //查看当前epid是否对应有企业
        List<SlEpBrand> list = iSL231146RsLogic.findSLEpBrandcYesOrOn(baseParam);
        if(list.isEmpty()){
            throw new BusinessException("您要删除的电商团队不存在，请输入正确的slCode");
        }
        iSL231146RsLogic.removeSLEpBrandc(slEpBrand);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("删除企业产品品牌成功");
        return rs;
    }
}
