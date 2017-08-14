package com.msk.by.rs;

import com.msk.by.logic.IBY121205Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerLicence;
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
 * IBY121205RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121205RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121205RsController.class);

    @Autowired
    private IBY121205Logic iby121205Logic;

    /**
     * 买家证照信息更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/licence/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerLicenceUpdate(@RequestBody RsRequest<ByBuyerLicence> param){
        RsResponse<Object> rs = new RsResponse<>();
        int resultCount = iby121205Logic.buyerLicenceModify(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家证照信息更新失败！");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家证照信息更新成功");
        }
        return rs;
    }
    /**
     * 买家证照信息查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/licence/find",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ByBuyerLicence> buyerLicenceFind(@RequestBody RsRequest<ByBuyerLicence> param){
        RsResponse<ByBuyerLicence> rs = new RsResponse<>();
        ByBuyerLicence licence = iby121205Logic.buyerLicenceFind(param.getParam());
        if(null == licence){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家证照信息不存在");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家证照信息获取成功");
            rs.setResult(licence);
        }
        return rs;
    }
}
