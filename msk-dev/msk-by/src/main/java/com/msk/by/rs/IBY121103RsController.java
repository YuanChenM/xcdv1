package com.msk.by.rs;

import com.msk.by.bean.IBY121103Bean;
import com.msk.by.bean.IBY121103RsParam;
import com.msk.by.logic.IBY121103Logic;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * IBY121103RsController.
 *
 * @author yang_yang
 */
@RestController
public class IBY121103RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121103RsController.class);

    @Autowired
    private IBY121103Logic iby121103Logic;

    /**
     * 获取区县批发市场查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/by/marketTerminal/find",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.by.validator.IBY121103Validator")
    public RsResponse<List<IBY121103Bean>> findMarketList(@RequestBody RsRequest<IBY121103RsParam> request){
        RsResponse<List<IBY121103Bean>> rs = new RsResponse<>();
        IBY121103RsParam param = request.getParam();

        List<IBY121103Bean> markerList = iby121103Logic.getMarkerList(param);
        if(!CollectionUtils.isEmpty(markerList)){
            rs.setMessage("数据查询成功");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setResult(markerList);
        }else{
            rs.setMessage("数据查询失败");
            rs.setStatus(BusinessConst.RsStatus.FAIL);
        }

        return rs;
    }

}
