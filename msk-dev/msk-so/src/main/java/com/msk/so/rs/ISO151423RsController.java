package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151423RsParam;
import com.msk.so.bean.ISO151423RsResult;
import com.msk.so.logic.ISO151423Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * 管家快捷信息查询接口
 * Created by liu_tao2 on 2016/4/18.
 */
@RestController
public class ISO151423RsController {
    @Autowired
    private ISO151423Logic iso151423Logic;

    @RequestMapping(value = "/api/{ver}/so/sdo/{type}/search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ISO151423RsResult> search(@PathVariable("type") String type,@PathVariable("ver") String ver,@RequestBody RsRequest<ISO151423RsParam> request)
    {
        RsResponse<ISO151423RsResult> response = new RsResponse<ISO151423RsResult>();

        ISO151423RsParam param = request.getParam();

        ISO151423RsResult result = this.iso151423Logic.getResultInfo(param,type);

        result.setFilterMap(null);
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("处理成功");
        response.setResult(result);

        return response;
    }

}
