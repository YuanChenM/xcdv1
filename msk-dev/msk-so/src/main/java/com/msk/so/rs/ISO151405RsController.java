package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151405RsParam;
import com.msk.so.bean.ISO151405RsResult;
import com.msk.so.bean.PdSalesResult;
import com.msk.so.logic.ISO151405Logic;
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
 * ISO151405RsController
 *
 * @author sunjiaju
 * @version 1.0
 **/
@RestController
public class ISO151405RsController extends BaseRsController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151405RsController.class);

    @Autowired
    private ISO151405Logic iso151405Logic;

    /**
     * 产品销量查询接口
     * @param request 请求参数
     * @return
     */
    @RequestMapping(value = "/api/v1/so/pdSalesVolumn/list", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public synchronized RsResponse<ISO151405RsResult> checkReturnCode(@RequestBody  RsRequest<ISO151405RsParam> request){
        ISO151405RsParam param = request.getParam();
        List<PdSalesResult> pdList = this.iso151405Logic.getPdList(param);
        ISO151405RsResult result = new ISO151405RsResult();
        RsResponse<ISO151405RsResult> response = new RsResponse<ISO151405RsResult>();
        if (CollectionUtils.isNotEmpty(pdList)){
            result.setPdList(pdList);
            response.setResult(result);
            response.setMessage("查询成功");
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
        } else{
            response.setMessage("查询无产品销量信息！");
            response.setStatus(BusinessConst.RsStatus.FAIL);
        }

        return response;
    }
}
