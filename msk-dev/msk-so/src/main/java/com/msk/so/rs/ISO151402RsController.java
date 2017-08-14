package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.order.*;
import com.msk.so.logic.rs.ISO151402Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * ISO151402RsController
 *
 * @author sunjiaju
 * @version 1.0
 **/
@RestController
public class ISO151402RsController extends BaseRsController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151402RsController.class);

    @Autowired
    private ISO151402Logic iso151402Logic;

    /**
     * 打印查询订单详细信息及入口
     * @param request 请求参数
     * @return
     */
    @RequestMapping(value = "/api/v1/so/detail/print", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public synchronized RsResponse<OrderPrintBean> createOrder(@RequestBody  RsRequest<OrderPrintParam> request){
        OrderPrintParam param = request.getParam();
        OrderPrintBean orderPrint = this.iso151402Logic.findOrderBasic(param);
        RsResponse<OrderPrintBean> response = new RsResponse<OrderPrintBean>();
        if (orderPrint != null){
            response.setMessage("查询成功");
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setResult(orderPrint);
        } else {
            response.setMessage("查询没有数据");
            response.setStatus(BusinessConst.RsStatus.FAIL);
        }
        return response;
    }
}
