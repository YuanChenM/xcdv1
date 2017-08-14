package com.msk.bs.rs;

import com.msk.bs.bean.IBS210110501RsResult;
import com.msk.bs.bean.IBS2101105RsParam;
import com.msk.bs.bean.IBS2101105RsResult;
import com.msk.bs.logic.BS2101102Logic;
import com.msk.bs.logic.IBS2101105RsLogic;
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
 * Created by gyh on 2016/2/14.
 * 查询冻品管家信息
 */
@RestController
public class IBS2101105RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101105RsController.class);
    @Autowired
    private IBS2101105RsLogic ibs2101105RsLogic;

    /**
     * 查询冻品管家信息接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/houseAccount/search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IBS210110501RsResult> search(@RequestBody RsRequest<IBS2101105RsParam> param) {
        logger.debug("查询冻品管家信息接口");
        RsResponse<IBS210110501RsResult> rs = new RsResponse<IBS210110501RsResult>();
        IBS210110501RsResult result = new IBS210110501RsResult();
        List<IBS2101105RsResult> houseList = ibs2101105RsLogic.findPageList(param.getParam(), result);
        if (!CollectionUtils.isEmpty(houseList) && houseList.size() > 0) {
            result.setHouseList(houseList);
            rs.setResult(result);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询冻品管家信息接口成功");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("暂不存在数据");
        }
        return rs;
    }
}
