package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEcTeam;
import com.msk.core.entity.SlSeller;
import com.msk.core.exception.BusinessException;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231142RsResult;
import com.msk.sl.bean.SL241103070Bean;
import com.msk.sl.logic.SL241103009Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/17.
 */
@RestController
public class ISL231142RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231142RsController.class);
    @Autowired
    private SL241103009Logic sL241103009Logic;
    /**
     * 增加卖家电商团队接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEcTeam/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231142Validator")
    public RsResponse<ISL231142RsResult> createSLEcTeam(@RequestBody RsRequest<SlEcTeam> param) {
        logger.debug("增加卖家电商团队接口");
        RsResponse<ISL231142RsResult> rs = new RsResponse<ISL231142RsResult>();
        ISL231142RsResult result = new ISL231142RsResult();
        SlEcTeam slEcTeam = param.getParam();

        //查询传过来的slCode是否存在sl_seller中
        BaseParam baseParam = new BaseParam();
        baseParam.setFilter("slCode",StringUtil.toSafeString(slEcTeam.getSlCode()));
        SlSeller slSeller = sL241103009Logic.findSLCode(baseParam);
        if(null == slSeller){
            throw new BusinessException("您输入的电商团队没有对应的卖家，请输入正确的slCode");
        }
        String slCode = slEcTeam.getSlCode();
        //memberId去数据库查询出当前slCode里memberId里最大的那个然后进行+1即可
        SL241103070Bean m = sL241103009Logic.maxBrandByEpId(slCode);
        if (m == null) {
            slEcTeam.setMemberId(1);
        } else {
            Integer mid = m.getEmemberId() + 1;
            slEcTeam.setMemberId(mid);
        }
        sL241103009Logic.saveEteamPort(slEcTeam);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("增加卖家电商团队成功");
        return rs;
    }
}
