package com.msk.bs.rs;


import com.msk.bs.bean.IBS2101109RsParam;
import com.msk.bs.bean.IBS2101109RsResult;
import com.msk.bs.bean.IBS210111001RsParam;
import com.msk.bs.bean.IBS2101110RsParam;
import com.msk.bs.logic.IBS2101109RsLogic;
import com.msk.bs.logic.IBS2101110RsLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
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

/**
 * Created by gyh on 2016/4/8.
 */
@RestController
public class IBS2101110RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101110RsController.class);
    @Autowired
    private IBS2101110RsLogic ibs2101110RsLogic;
    /**
     * 编辑买手囤货联盟
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/updateSlBsLeagues",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.bs.validator.IBS2101110Validator")
    public RsResponse updatePsd(@RequestBody RsRequest<IBS2101110RsParam> param) {
        logger.debug("编辑买手囤货联盟接口");
        RsResponse rs = new RsResponse();
        ibs2101110RsLogic.editSlBsBuyerLeagues(param.getParam().getSlBsLeaguesList());
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("买手囤货联盟更新成功");
        return rs;
    }
}
