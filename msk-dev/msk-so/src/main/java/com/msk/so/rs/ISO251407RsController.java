package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO251407RsParam;
import com.msk.so.bean.ISO251407RsResult;
import com.msk.so.logic.ISO251407Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ISO251404RsController.
 * 修改标准分销订单状态
 *
 * @author pxg
 */
@RestController
public class ISO251407RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO251407RsController.class);

    @Autowired
    private ISO251407Logic iSO251407Logic;

    /**
     * 修改标准分销订单状态
     *
     * @param param param
     * @return 结果
     * @author pxg
     */
    @RequestMapping(value = "/api/v1/so/sdo/update",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.so.validator.ISO251407Validator")
    public RsResponse<ISO251407RsResult> modifyDbOrder(@RequestBody RsRequest<ISO251407RsParam> param) {
        logger.info("修改标准分销订单状态");
        RsResponse<ISO251407RsResult> rs = new RsResponse<ISO251407RsResult>();
        ISO251407RsResult iSO251407RsResult = new ISO251407RsResult();
        iSO251407RsResult = iSO251407Logic.findAllList(param);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("修改标准分销订单状态成功！");
        rs.setResult(iSO251407RsResult);
        return rs;
    }
}
