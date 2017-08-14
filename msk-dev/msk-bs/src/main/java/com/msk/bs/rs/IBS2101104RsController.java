package com.msk.bs.rs;

import com.msk.bs.bean.IBS2101102RsResult;
import com.msk.bs.bean.IBS2101104RsParam;
import com.msk.bs.bean.IBS2101104SlHouseAccount;
import com.msk.bs.logic.IBS2101104RsLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlHouseAccount;
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
 * Created by cx on 2016/2/29.
 */
@RestController
public class IBS2101104RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101104RsController.class);
    @Autowired
    private IBS2101104RsLogic bS2101104RsLogic;
    /**
     * 编辑冻品管家信息接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/slSeller/newOrUpdate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.bs.validator.IBS2101104Validator")
    public RsResponse<IBS2101102RsResult> editBSSeller(@RequestBody RsRequest<IBS2101104RsParam> param) {
        logger.debug("编辑冻品管家信息接口");
        RsResponse<IBS2101102RsResult> rs = new RsResponse<IBS2101102RsResult>();
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        SlHouseAccount account=bS2101104RsLogic.editBSSeller(param.getParam());
        IBS2101102RsResult rsResult=new IBS2101102RsResult();
        rsResult.setHouseAccount(account.getHouseAccount());
        rsResult.setHouseCode(account.getHouseCode());
        rs.setResult(rsResult);
        rs.setMessage("更新成功");
        return rs;
    }
}
