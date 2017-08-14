package com.msk.by.rs;

import com.msk.by.logic.IBY121214Logic;
import com.msk.by.logic.IBY121215Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByResearchStdFed;
import com.msk.core.entity.ByResearchStdTnc;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
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
 * 买家产品饲养标准调研用Controller.
 *
 * @author zhou_ling
 */
@RestController
public class IBY121215RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121215RsController.class);

    @Autowired
    private IBY121215Logic iby121215Logic;

    /**
     * 买家产品饲养标准调研接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchStdFed/findList",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByResearchStdFed>> findBuyerStdFed(@RequestBody RsRequest<ByResearchStdFed> param) {
        logger.debug("调用买家产品饲养标准调研查询接口");

        String classesCode = param.getParam().getClassesCode();
        String machiningCode = param.getParam().getMachiningCode();
        String breedCode = param.getParam().getBreedCode();
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("buyerId", param.getParam().getBuyerId());
        baseParam.getFilterMap().put("classesCode", classesCode);
        baseParam.getFilterMap().put("machiningCode", machiningCode);
        baseParam.getFilterMap().put("breedCode", breedCode);
        baseParam.getFilterMap().put("treeCode", classesCode + machiningCode + breedCode);

        List<ByResearchStdFed> byResearchStdFed = iby121215Logic.findBuyerFedList(baseParam);
        RsResponse<List<ByResearchStdFed>> rs = new RsResponse<>();
        rs.setResult(byResearchStdFed);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询成功！");
        return rs;
    }

    /**
     * 买家产品饲养标准调研更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchStdFed/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<String> updateBuyerStdFed(@RequestBody RsRequest<ByResearchStdFed> param) {
        logger.debug("调用买家产品饲养标准调研更新接口");
        RsResponse<String> rs = new RsResponse<>();
        int resultCount = iby121215Logic.updateBuyerFed(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("更新失败,未找到可以被更新的数据!");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家产品饲养标准调研更新成功!");
        }
        return rs;
    }

}