package com.msk.so.rs;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.consts.OrderConst;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.rs.ISO151801RsParam;
import com.msk.so.bean.rs.ISO151801RsResult;
import com.msk.so.logic.rs.ISO151801Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liu_tao2 on 2016/7/18.
 */
@RestController
public class ISO151801RsController extends BaseRsController {

    @Autowired
    private ISO151801Logic iso151801Logic;

    /**
     * 迟收操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/sdo/receive/later",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_XML_VALUE })
    public RsResponse<ISO151801RsResult> ReceiverLater(@RequestBody RsRequest<ISO151801RsParam> request){
        RsResponse<ISO151801RsResult> response = new RsResponse<ISO151801RsResult>();
        ISO151801RsParam param = request.getParam();
        param.setCrtId(request.getLoginId());
        param.setReturnSource(OrderConst.ReturnSource.PDA);
        ISO151801RsResult result = this.iso151801Logic.doReceiverLater(param);
        response.setMessage("迟收操作成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setResult(result);
        return response;
    }

}
