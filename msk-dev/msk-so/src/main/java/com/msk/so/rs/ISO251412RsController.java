package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.logic.ISO251412Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.so.bean.ISO251412RsParam;
import com.msk.so.bean.ISO251412RsResult;


/**
 * 
 * ISO251404RsController.
 * 删除恢复标准分销订单
 * 
 * @author pxg
 */
@RestController
public class ISO251412RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO251412RsController.class);

    @Autowired
    private ISO251412Logic iSO251412Logic;

    /**
     * 删除/恢复标准分销订单
     * 
     * @param param param
     * @return 结果
     * @author pxg
     */
    @RequestMapping(value = "/api/v1/so/sdo/delete",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO251412Validator")
    public RsResponse<ISO251412RsResult> modifyDbOrder(@RequestBody RsRequest<ISO251412RsParam> param) {
        logger.info("删除/恢复标准分销订单");
        RsResponse<ISO251412RsResult> rs = new RsResponse<ISO251412RsResult>();
        ISO251412RsResult iSO251412RsResult = new ISO251412RsResult();
        if (isDebug) {
            iSO251412RsResult = iSO251412Logic.findAllList2();
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("删除/恢复标准分销订单成功！");
            rs.setResult(iSO251412RsResult);
        } else {
            iSO251412RsResult = iSO251412Logic.findAllList(param);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("删除/恢复标准分销订单成功！");
            rs.setResult(iSO251412RsResult);
        }
        return rs;
    }
}
