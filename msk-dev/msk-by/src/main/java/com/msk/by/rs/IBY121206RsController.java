package com.msk.by.rs;

import com.msk.by.bean.IBY121206RsParam;
import com.msk.by.logic.IBY121206Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
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
 * IBY121206RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121206RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121206RsController.class);

    @Autowired
    private IBY121206Logic iby121206Logic;

    /**
     * 买家证照图片更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/pictures/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerLicencePicUpdate(@RequestBody RsRequest<IBY121206RsParam> param){
        RsResponse<Object> rs = new RsResponse<>();
        int resultCount = iby121206Logic.buyerLicencePicModify(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家证照图片更新失败！");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家证照图片更新成功");
        }
        return rs;
    }
    /**
     * 买家证照图片查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/pictures/find",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<IBY121206RsParam> buyerLicencePicFind(@RequestBody RsRequest<IBY121206RsParam> param){
        RsResponse<IBY121206RsParam> rs = new RsResponse<>();
        IBY121206RsParam iby121206RsParam = iby121206Logic.buyerLicencePicFind(param.getParam());
        if(null == iby121206RsParam){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家证照图片信息不存在");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家证照图片获取成功");
            rs.setResult(iby121206RsParam);
        }
        return rs;
    }
}
