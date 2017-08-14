package com.msk.by.rs;

import com.msk.by.logic.IBY121204Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerSalestarget;
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
 * IBY121204RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121204RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121204RsController.class);

    @Autowired
    private IBY121204Logic iby121204Logic;

    /**
     * 买家销售对象更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/salesTarget/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerSalesTargetUpdate(@RequestBody RsRequest<List<ByBuyerSalestarget>> param){
        RsResponse<Object> rs = new RsResponse<>();
        int resultCount = iby121204Logic.buyerSalesTargetModify(param.getParam());
        if(resultCount == NumberConst.IntDef.INT_ZERO){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家销售对象更新失败！");
        }else {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家销售对象更新成功!");
        }
        return rs;
    }
    /**
     * 买家销售对象查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/salesTarget/findList",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByBuyerSalestarget>> buyerSalesTargetFindList(@RequestBody RsRequest<ByBuyerSalestarget> param){
        RsResponse<List<ByBuyerSalestarget>> rs = new RsResponse<>();
        List<ByBuyerSalestarget> salesTargetList = iby121204Logic.buyerSalesTargetFind(param.getParam());
        if(CollectionUtils.isEmpty(salesTargetList)){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家销售对象信息不存在");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家销售对象获取成功");
            rs.setResult(salesTargetList);
        }
        return rs;
    }
}
