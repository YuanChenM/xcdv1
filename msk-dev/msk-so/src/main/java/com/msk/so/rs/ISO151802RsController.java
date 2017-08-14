package com.msk.so.rs;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.consts.OrderConst;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.so.bean.rs.ISO151801RsParam;
import com.msk.so.bean.rs.ISO151801RsResult;
import com.msk.so.bean.rs.ISO151802RsParam;
import com.msk.so.bean.rs.ISO151802RsResult;
import com.msk.so.logic.rs.ISO151802Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liu_tao2 on 2016/7/21.
 */
@RestController
public class ISO151802RsController extends BaseRsController {

    @Autowired
    private ISO151802Logic iso151802Logic;

    /**
     * 现场退货操作
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/sdo/receive/reject",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_XML_VALUE },consumes = { MediaType.APPLICATION_XML_VALUE })
    public RsResponse<ISO151802RsResult> ReceiverReject(@RequestBody RsRequest<ISO151802RsParam> request){
        RsResponse<ISO151802RsResult> response = new RsResponse<ISO151802RsResult>();
        ISO151802RsParam param = request.getParam();
        param.setCrtId(request.getLoginId());
        param.setReturnSource(OrderConst.ReturnSource.PDA);
        ISO151802RsResult result = this.iso151802Logic.doReceiverReject(param);
        response.setMessage("现场退货操作成功");
        response.setResult(result);
        return response;
    }

}
