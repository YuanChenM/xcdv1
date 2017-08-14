package com.msk.bs.rs;


import com.msk.bs.bean.IBS2101107Bean;
import com.msk.bs.bean.IBS2101107RsParam;
import com.msk.bs.bean.IBS2101107RsResult;
import com.msk.bs.logic.IBS2101108RsLogic;
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
 * Created by cx on 2016/3/28.
 */
@RestController
public class IBS2101108RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101108RsController.class);
    @Autowired
    private IBS2101108RsLogic ibS2101108RsLogic;
    /**
     * 查询买手冻品管家的买家信息
     * @param request request
     * @return rs
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/searchBuyer",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IBS2101107RsResult> querySlExclusive(@RequestBody RsRequest<IBS2101107RsParam> request) {
        logger.debug("查询公共买家池买家信息接口");
        RsResponse<IBS2101107RsResult> rs = new RsResponse<IBS2101107RsResult>();
        IBS2101107RsResult result = new IBS2101107RsResult();
        List<IBS2101107Bean> slBuyerList = ibS2101108RsLogic.findPageList(request.getParam(),result);
        if(!CollectionUtils.isEmpty(slBuyerList)&&slBuyerList.size()>0){
            result.setSlBuyerList(slBuyerList);
            rs.setResult(result);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询公共买家池买家信息成功");
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("暂不存在数据");
        }
        return rs;
    }
}
