package com.msk.by.rs;

import java.util.List;

import com.msk.core.consts.NumberConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.by.logic.IBY121212Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.ByResearchStdOrg;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;

/**
 * 买家产品原种种源标准调研用Controller.
 *
 * @author yuan_chen
 */
@RestController
public class IBY121212RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121212RsController.class);

    @Autowired
    private IBY121212Logic iby121212Logic;

    /**
     * 产品原种种源标准查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchStdOrg/findList",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByResearchStdOrg>> findBuyerStdOrg(@RequestBody RsRequest<ByResearchStdOrg> param) {
        logger.debug("调用产品原种种源标准查询接口");

        String classesCode = param.getParam().getClassesCode();
        String machiningCode = param.getParam().getMachiningCode();
        String breedCode = param.getParam().getBreedCode();
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("buyerId", param.getParam().getBuyerId());
        baseParam.getFilterMap().put("classesCode", classesCode);
        baseParam.getFilterMap().put("machiningCode", machiningCode);
        baseParam.getFilterMap().put("breedCode", breedCode);
        baseParam.getFilterMap().put("treeCode", classesCode + machiningCode + breedCode);

        List<ByResearchStdOrg> byResearchStdOrgs = iby121212Logic.findBuyerOrgList(baseParam);
        RsResponse<List<ByResearchStdOrg>> rs = new RsResponse<>();
        rs.setResult(byResearchStdOrgs);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询成功！");
        return rs;
    }

    /**
     * 买家产品原种种源标准更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchStdOrg/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<String> updateBuyerStdOrg(@RequestBody RsRequest<ByResearchStdOrg> param) {
        logger.debug("调用产品原种种源标准更新接口");
        RsResponse<String> rs = new RsResponse<>();
        int resultCount = iby121212Logic.updateBuyerOrg(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("更新失败,未找到可以被更新的数据!");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家产品原种种源标准更新成功!");
        }
        return rs;
    }
}
