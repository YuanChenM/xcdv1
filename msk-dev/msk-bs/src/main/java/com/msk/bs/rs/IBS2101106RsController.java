package com.msk.bs.rs;

import com.msk.bs.bean.IBS2101106Bean;
import com.msk.bs.bean.IBS2101106RsResult;
import com.msk.bs.logic.IBS2101106RsLogic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.BaseParam;
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
 * Created by cx on 2016/3/2.
 */
@RestController
public class IBS2101106RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101106RsController.class);
    @Autowired
    private IBS2101106RsLogic iBS2101106RsLogic;

    /**
     * 编辑买手冻品管家的买家信息接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/slExclusive/newOrUpdate", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.bs.validator.IBS2101106Validator")
    public RsResponse<IBS2101106RsResult> editBSExclusive(@RequestBody RsRequest<IBS2101106Bean> param) {
        logger.debug("编辑买手冻品管家的买家信息接口");
        RsResponse<IBS2101106RsResult> rs = new RsResponse<IBS2101106RsResult>();
        IBS2101106Bean iBS2101106Bean = param.getParam();
        iBS2101106Bean.setUpdId(param.getLoginId());
        iBS2101106RsLogic.editExclusive(iBS2101106Bean);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("更新买手冻品管家的买家信息成功");
        return rs;
    }
}
