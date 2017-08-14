package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151805RsBeanResult;
import com.msk.so.bean.ISO151805RsParam;
import com.msk.so.logic.rs.ISO151805Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liutao on 2016/10/18.
 */
@RestController
public class ISO151805RsController {

    @Autowired
    private ISO151805Logic iso151805Logic;


    /**
     * 订单明细及价盘通道查询接口查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/order/detail/price/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
    //Modify by wang_jianzhou for bug#3818 at 2016/12/06 Start.
    public RsResponse<ISO151805RsBeanResult> searchOrderDetailPrice(@RequestBody RsRequest<ISO151805RsParam> request) {
        ISO151805RsBeanResult result = iso151805Logic.searchOrderDetailPrice(request);
        RsResponse<ISO151805RsBeanResult> response = new RsResponse<ISO151805RsBeanResult>();
    //Modify by wang_jianzhou for bug#3818 at 2016/12/06 end.
        response.setMessage("订单明细及价盘通道查询接口查询成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setResult(result);
        return response;
    }
}
