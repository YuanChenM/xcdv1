package com.msk.bs.rs;


import com.msk.bs.bean.IBS2101114Param;
import com.msk.bs.bean.IBS2101114Result;
import com.msk.bs.logic.IBS2101114RsLogic;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.SystemConst;
import com.msk.core.web.base.BaseRsController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 根据买家ID查询该买家归属管家的信息
 * Created by zhu_kai1 on 2016/7/13.
 */
@RestController
public class IBS2101114RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IBS2101114RsController.class);

    @Autowired
    private IBS2101114RsLogic ibs2101114RsLogic;

    @RequestMapping(value = "/api/v1/bs/searchHouseInfo", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IBS2101114Result> searchHouseInfo(@RequestBody RsRequest<IBS2101114Param> request){
        logger.info("开始查询归属管家信息");
        IBS2101114Param param = request.getParam();
        RsResponse<IBS2101114Result> response = new RsResponse<IBS2101114Result>();
        IBS2101114Result ibs2101114Result = ibs2101114RsLogic.searchHouseInfo(param);
        if(null !=ibs2101114Result){
            response.setResult(ibs2101114Result);
            response.setStatus(SystemConst.RsStatus.SUCCESS);
            response.setMessage("处理成功");
        }else{
            response.setStatus(SystemConst.RsStatus.FAIL);
            response.setMessage("没有查询到对应的结果");
        }
        logger.info("查询归属管家信息结束");
        return  response;
    }
}
