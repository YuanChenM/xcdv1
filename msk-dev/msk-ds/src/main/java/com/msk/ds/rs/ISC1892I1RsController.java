package com.msk.ds.rs;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.ds.bean.ISC1892I1Param;
import com.msk.ds.bean.ISC1892I1RsResult;
import com.msk.ds.logic.ISC1892I1Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * ISC1892I1RsController.
 * 扫码入库虚拟库存变更API
 *
 * @author xu_wei
 */
@RestController
public class ISC1892I1RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISC1892I1RsController.class);

    /**
     * ISC1892I1Logic
     */
    @Autowired
    private ISC1892I1Logic ISC1892I1Logic;

    /**
     * 扫码入库虚拟库存变更
     *
     * @param request request
     * @return 结果
     */
    @RequestMapping(value = "/api/{type}/sc/modify",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_XML_VALUE },
            consumes = { MediaType.APPLICATION_XML_VALUE })
    public RsResponse<ISC1892I1RsResult> modify(@PathVariable("type") String type,
                                                @RequestBody RsRequest<ISC1892I1Param> request) {
        logger.info("扫码入库虚拟库存变更");
        //获取当前用户信息
        BaseParam baseParam = new BaseParam();
        this.setCommonParam(baseParam);
        request.getParam().setCrtId(baseParam.getCrtId());

        RsResponse<ISC1892I1RsResult> rs = new RsResponse<ISC1892I1RsResult>();
        ISC1892I1RsResult ISC1892I1RsResult = ISC1892I1Logic.modifyStock(request);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("扫码入库处理成功！");
        rs.setResult(ISC1892I1RsResult);
        return rs;
    }
}
