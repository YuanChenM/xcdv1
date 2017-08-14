package com.msk.by.rs;

import com.msk.by.logic.IBY121209Logic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.entity.ByBuyerRecTime;
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
 * IBY121209RsController.
 *
 * @author zhou_yajun
 */
@RestController
public class IBY121209RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IBY121209RsController.class);

    @Autowired
    private IBY121209Logic iby121209Logic;

    /**
     * 买家收货时间段更新接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/receiveTime/update",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<Object> buyerReceiveTimeUpdate(@RequestBody RsRequest<List<ByBuyerRecTime>> param){
        RsResponse<Object> rs = new RsResponse<>();
        int deleteResult = iby121209Logic.buyerReceiveTimeModify(param.getParam());
        if (deleteResult > NumberConst.IntDef.INT_ZERO) {
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家收货时间段更新成功!");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家收货时间段更新失败!");
        }
        return rs;
    }
    /**
     * 买家收货时间段查询接口
     *
     * @param param param
     * @return 结果
     * @author zhou_yajun
     */
    @RequestMapping(value = "/api/v1/by/receiveTime/findList",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<ByBuyerRecTime>> buyerReceiveTimeFind(@RequestBody RsRequest<ByBuyerRecTime> param){
        RsResponse<List<ByBuyerRecTime>> rs = new RsResponse<>();
        List<ByBuyerRecTime> receiveTimeList = iby121209Logic.buyerReceiveTimeFind(param.getParam());
        if(CollectionUtils.isEmpty(receiveTimeList)){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("买家收货时间信息不存在");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家收货时间获取成功");
            rs.setResult(receiveTimeList);
        }
        return rs;
    }
}
