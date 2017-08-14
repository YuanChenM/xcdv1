package com.msk.bs.rs;

import com.msk.bs.bean.IBS210110301Bean;
import com.msk.bs.bean.IBS2101103RsParam;
import com.msk.bs.bean.IBS2101103RsResult;
import com.msk.bs.logic.IBS2101102RsLogic;
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
 * Created by cx on 2016/2/29.
 */
@RestController
public class IBS2101103RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBS2101103RsController.class);
    @Autowired
    private IBS2101102RsLogic ibS2101102RsLogic;

    /**
     *  查询买手店卖家账户
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/bs/slInfo/slAccount/search",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IBS2101103RsResult> querySLShopAccount(@RequestBody RsRequest<IBS2101103RsParam> request) {
        logger.debug("查询买手店卖家账户接口");
        RsResponse<IBS2101103RsResult> rs = new RsResponse<IBS2101103RsResult>();
        IBS2101103RsResult result = new IBS2101103RsResult();
        List<IBS210110301Bean> buyershopList = ibS2101102RsLogic.findPageList(request.getParam(),result);
        if(!CollectionUtils.isEmpty(buyershopList)&&buyershopList.size()>0){
            result.setBuyershopList(buyershopList);
            rs.setResult(result);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询买手店买手账户成功");
        }else{
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("暂不存在数据");
        }
        return rs;
    }
}
