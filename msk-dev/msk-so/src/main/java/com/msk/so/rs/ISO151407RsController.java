package com.msk.so.rs;


import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151407RsParam;
import com.msk.so.bean.ISO151407RsResult;
import com.msk.so.bean.OrderCountBean;
import com.msk.so.logic.ISO151407Logic;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by sunjiaju on 2016/8/10.
 */
@RestController
public class ISO151407RsController extends BaseRsController {
    @Autowired
    private ISO151407Logic iso151407Logic;

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO151407RsController.class);

    @RequestMapping(value = "/api/v1/so/orderSource/search",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151407Validator")
    public RsResponse<ISO151407RsResult> searchOrderSourceCount(@RequestBody RsRequest<ISO151407RsParam> param) {
        logger.info("查询买家各下单方式订单数量");
        RsResponse<ISO151407RsResult> rs = new RsResponse<ISO151407RsResult>();
        ISO151407RsResult result = new ISO151407RsResult();
        List<OrderCountBean> orderCountInfoList = this.iso151407Logic.searchOrderSourceCount(param.getParam());
        if (CollectionUtils.isNotEmpty(orderCountInfoList)){
            result.setOrderCountInfoList(orderCountInfoList);
            rs.setResult(result);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询买家各下单方式订单数量成功");
        } else {
            rs.setResult(result);
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("该买家查询不到下单数量");
        }
        return rs;
    }


}
