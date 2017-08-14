package com.msk.by.rs;

import com.msk.by.bean.IBY121211RsParam;
import com.msk.by.logic.IBY121211Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByResearchCatDetail;
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
 * 买家产品品类和需求调研用IBY121211RsController.
 *
 * @author zhou_ling
 */
@RestController
public class IBY121211RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121211RsController.class);

    @Autowired
    private IBY121211Logic iby121211Logic;

    /**
     * 产品原种种源标准查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchCatDetail/findList",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByResearchCatDetail>> findBuyerCatDetail(@RequestBody RsRequest<IBY121211RsParam> param) {
        logger.debug("调用产品原种种源标准查询接口");

        String classesCode = param.getParam().getClassesCode();
        String machiningCode = param.getParam().getMachiningCode();
        String breedCode = param.getParam().getBreedCode();
        String featureCode =  param.getParam().getFeatureCode();
        String saleName =  param.getParam().getSaleName();
        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("detailId", param.getParam().getDetailId());
        baseParam.getFilterMap().put("buyerId", param.getParam().getBuyerId());
        baseParam.getFilterMap().put("classesCode", classesCode);
        baseParam.getFilterMap().put("machiningCode", machiningCode);
        baseParam.getFilterMap().put("breedCode", breedCode);
        baseParam.getFilterMap().put("saleName", saleName);
        baseParam.getFilterMap().put("featureCode", featureCode);
        List<ByResearchCatDetail> byResearchCatDetail = iby121211Logic.findBuyerCatDetailList(baseParam);

        RsResponse<List<ByResearchCatDetail>> rs = new RsResponse<>();
        rs.setResult(byResearchCatDetail);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询成功！");
        return rs;
    }

    /**
     * 买家产品品类和需求调研明细表更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_ling
     */
    @RequestMapping(value = "/api/v1/by/researchCatDetail/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<String> researchCatDetailUpdate(@RequestBody RsRequest<IBY121211RsParam> param){
        logger.debug("调用买家产品品类和需求调研明细表更新接口");

        RsResponse<String> rs = new RsResponse<>();
        int resultCount = iby121211Logic.updateBuyerCatDetail(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("更新失败,未找到可以被更新的数据!");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家产品品种安全标准调研更新成功!");
        }
        return rs;
    }

}
