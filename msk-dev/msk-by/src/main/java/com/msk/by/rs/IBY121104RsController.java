package com.msk.by.rs;

import com.msk.by.bean.IBY121104Bean;
import com.msk.by.bean.IBY121104RsParam;
import com.msk.by.logic.IBY121104Logic;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * IBY121104RsController.
 *
 * @author yang_yang
 */
@RestController
public class IBY121104RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121104RsController.class);

    @Autowired
    private IBY121104Logic iby121104Logic;

    /**
     * 获取区县批发市场/菜场查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/by/marketFood/find",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.by.validator.IBY121104Validator")
    public RsResponse<List<IBY121104Bean>> findMarketList(@RequestBody RsRequest<IBY121104RsParam> request){
        RsResponse<List<IBY121104Bean>> rs = new RsResponse<>();
        IBY121104RsParam param = request.getParam();

        List<IBY121104Bean> markerList = iby121104Logic.getMarkerList(param);
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
