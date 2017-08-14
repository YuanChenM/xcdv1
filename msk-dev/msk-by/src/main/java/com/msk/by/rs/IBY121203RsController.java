package com.msk.by.rs;

import com.msk.by.logic.IBY121203Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.ByBuyerPdCla;
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
 * IBY121203RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121203RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121203RsController.class);

    @Autowired
    private IBY121203Logic iby121203Logic;

    /**
     * 买家经营产品类别更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/pdClassification/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerPdClassificationUpdate(@RequestBody RsRequest<List<ByBuyerPdCla>> param){
        RsResponse<Object> rs = new RsResponse<>();
        iby121203Logic.buyerPdClassificationModify(param.getParam());
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("买家经营产品类别更新成功");
        return rs;
    }
    /**
     * 买家经营产品类别查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/pdClassification/findList",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByBuyerPdCla>> buyerPdClassificationFind(@RequestBody RsRequest<ByBuyerPdCla> param){
        RsResponse<List<ByBuyerPdCla>> rs = new RsResponse<>();
        List<ByBuyerPdCla> pdClassificationList = iby121203Logic.buyerPdClassificationFind(param.getParam());
        if(CollectionUtils.isEmpty(pdClassificationList)){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家产品类型信息不存在");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家产品类型获取成功");
            rs.setResult(pdClassificationList);
        }
        return rs;
    }
}
