package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151426RsParam;
import com.msk.so.bean.ISO151426RsResult;
import com.msk.so.logic.ISO151426Logic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by liu_tao2 on 2016/4/19.
 */
@RestController
public class ISO151426RsController {

    @Autowired
    private ISO151426Logic iso151426Logic;

    @RequestMapping(value = "/api/{ver}/so/sdo/housekeeping/detail", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ISO151426RsResult> detail(@PathVariable("ver") String ver,@RequestBody RsRequest<ISO151426RsParam> request)
    {
        RsResponse<ISO151426RsResult> response = new RsResponse<ISO151426RsResult>();

        ISO151426RsParam param = request.getParam();

        ISO151426RsResult result = this.iso151426Logic.findPageResult(param);

        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("处理成功");
        response.setResult(result);

        return response;
    }
}
