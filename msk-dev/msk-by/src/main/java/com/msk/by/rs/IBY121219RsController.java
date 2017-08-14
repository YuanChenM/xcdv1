package com.msk.by.rs;

import com.msk.by.logic.IBY121217Logic;
import com.msk.by.logic.IBY121219Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByResearchStdNor;
import com.msk.core.entity.ByResearchStdNor;
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
 * 买家产品品种包装标准调研用Controller.
 *
 * @author zhou_ling
 */
@RestController
public class IBY121219RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121219RsController.class);

    @Autowired
    private IBY121219Logic iby121219Logic;

    /**
     * 买家产品品种包装标准调研接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchStdNor/findList",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByResearchStdNor>> findBuyerStdNor(@RequestBody RsRequest<ByResearchStdNor> param) {
        logger.debug("调用买家产品品种包装标准调研查询接口");
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("buyerId", param.getParam().getBuyerId());
        baseParam.getFilterMap().put("standardId", param.getParam().getStandardId());
        baseParam.getFilterMap().put("normsCode", param.getParam().getNormsCode());
        List<ByResearchStdNor> byResearchStdNor = iby121219Logic.findBuyerNorList(baseParam);
        RsResponse<List<ByResearchStdNor>> rs = new RsResponse<>();
        rs.setResult(byResearchStdNor);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询成功！");
        return rs;
    }

    /**
     * 买家产品品种安全标准更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchStdNor/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<String> updateBuyerStdNor(@RequestBody RsRequest<ByResearchStdNor> param) {
        logger.debug("调用买家产品品种包装标准更新接口");
        RsResponse<String> rs = new RsResponse<>();
        int resultCount = iby121219Logic.updateBuyerNor(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("更新失败,未找到可以被更新的数据!");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家产品品种包装标准调研更新成功!");
        }
        return rs;
    }

}
