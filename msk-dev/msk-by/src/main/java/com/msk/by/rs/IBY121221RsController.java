package com.msk.by.rs;

import java.util.List;

import com.msk.by.bean.IBY121221Bean;
import com.msk.by.logic.IBY121221Logic;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.consts.CodeMasterConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.by.bean.IBY121220Bean;
import com.msk.by.logic.IBY121220Logic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;

/**
 * 买家产品品种调研用Controller.
 *
 * @author yuan_chen
 */
@RestController
public class IBY121221RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121221RsController.class);

    @Autowired
    private IBY121220Logic iby121220Logic;

    @Autowired
    private IBY121221Logic iby121221Logic;

    /**
     * 买家产品品种调研状态查询接口
     *
     * @param param param
     * @return 结果
     * @author yuan_chen
     */
    @RequestMapping(value = "/api/v1/by/research/findResearchTypeList",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<IBY121221Bean>> findBuyerResearch(@RequestBody RsRequest<IBY121220Bean> param) {
        logger.debug("调用买家产品品种调研状态查询接口");

        BaseParam baseParam = iby121220Logic.setParam(param.getParam());
        String breedCode = param.getParam().getBreedCode();
        String isStandard = param.getParam().getIsStandard();

        if(StringUtil.isNullOrEmpty((isStandard))){
            if(StringUtil.isNullOrEmpty((breedCode))){
                isStandard = CodeMasterConst.IsStandard.NO;
            }else {
                isStandard = CodeMasterConst.IsStandard.YES;
            }
        }

        baseParam.getFilterMap().put("breedCode", breedCode);
        baseParam.getFilterMap().put("isStandard", isStandard);
        List<IBY121221Bean> iby121221Beans = iby121221Logic.findBuyerResearch(baseParam);
        RsResponse<List<IBY121221Bean>> rs = new RsResponse<>();
        rs.setResult(iby121221Beans);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("买家产品品种调研状态查询成功！");
        return rs;
    }


}
