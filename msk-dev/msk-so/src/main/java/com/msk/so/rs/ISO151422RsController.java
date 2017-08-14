package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151422RsResult;
import com.msk.so.bean.rs.ISOReturnOrder;
import com.msk.so.logic.ISO151422Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 退货入库
 * zhang_qiang1
 */
@RestController
public class ISO151422RsController extends BaseRsController {

    @Autowired
    private ISO151422Logic iso151422Logic;

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151422RsController.class);


    /**
     * 退货入库
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/v1/so/ro/inbound", method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
    @Validator(validatorClass = "com.msk.so.validator.ISO151422Validator")
    public RsResponse<ISO151422RsResult> inbound(@RequestBody RsRequest<ISOReturnOrder> request) {
        RsResponse<ISO151422RsResult> response = new RsResponse<ISO151422RsResult>();
        ISOReturnOrder param = request.getParam();
        param.setUpdId(request.getLoginId());
        param.setUpdTime(DateTimeUtil.getCustomerDate());
        String message = "操作成功！";
        try {
            ISO151422RsResult result = iso151422Logic.inbound(param);
            if (result != null) {
                response.setStatus(BusinessConst.RsStatus.SUCCESS);
                response.setResult(result);
            } else {
                response.setStatus(BusinessConst.RsStatus.FAIL);
            }
        } catch (Exception e) {
            message = "操作失败！原因：" + e.getMessage();
            response.setStatus(BusinessConst.RsStatus.FAIL);
            System.out.println(e.getMessage());
        }
        response.setMessage(message);
        return response;
    }
}
