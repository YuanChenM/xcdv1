package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151403RsParam;
import com.msk.so.bean.ISO151403RsResult;
import com.msk.so.bean.SellerListResult;
import com.msk.so.logic.ISO151403Logic;
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
 * ISO151403RsController
 *
 * @author sunjiaju
 * @version 1.0
 **/
@RestController
public class ISO151403RsController extends BaseRsController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151403RsController.class);

    @Autowired
    private ISO151403Logic iso151403Logic;

    /**
     * 查询订单卖家详细信息
     * @param request 请求参数
     * @return
     */
    @RequestMapping(value = "/api/v1/so/seller/search", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151403Validator")
    public synchronized RsResponse<ISO151403RsResult> findSellers(@RequestBody  RsRequest<ISO151403RsParam> request){
        ISO151403RsParam param = request.getParam();
        List<SellerListResult> sellerList = this.iso151403Logic.findSellers(param);
        RsResponse<ISO151403RsResult> response = new RsResponse<ISO151403RsResult>();
        if (CollectionUtils.isNotEmpty(sellerList)){
            ISO151403RsResult result = new ISO151403RsResult();
            result.setSellerList(sellerList);
            response.setMessage("查询成功");
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setResult(result);
        } else {
            response.setMessage("查询没有数据");
            response.setStatus(BusinessConst.RsStatus.FAIL);
        }
        return response;
    }
}
