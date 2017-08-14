package com.msk.sl.rs;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEcTeam;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231144RsResult;
import com.msk.sl.logic.SL24110109Logic;
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
public class ISL231144RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231144RsController.class);
    @Autowired
    private SL24110109Logic sL24110109Logic;
    /**
     * 删除卖家电商团队接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEcTeam/delete",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    //@Validator(validatorClass = "com.msk.sl.validator.ISL231140Validator")
    public RsResponse<ISL231144RsResult> deleteSLEcTeam(@RequestBody RsRequest<SlEcTeam> param) {
        logger.debug("删除卖家电商团队接口");
        RsResponse<ISL231144RsResult> rs = new RsResponse<ISL231144RsResult>();
        SlEcTeam slEcTeam = param.getParam();
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slCode", StringUtil.toSafeString(slEcTeam.getSlCode()));
        List<SlEcTeam> list = sL24110109Logic.findSLEcTeamYesOrOn(baseParam);
        if(list.isEmpty()){
            throw new BusinessException("您要删除的电商团队不存在，请输入正确的slCode");
        }
        sL24110109Logic.removeETeamPort(slEcTeam);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("删除卖家电商团队成功");
        return rs;
    }
}
