package com.msk.so.rs;
import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151803RsParam;
import com.msk.so.bean.ISO151803RsResult;
import com.msk.so.logic.ISO151803Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 订单发货明细信息查询
 * zhang_qiang1
 */

@RestController
public class ISO151803RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO151803RsController.class);

    @Autowired
    private ISO151803Logic iso151803Logic;

    /**
     * 订单发货明细信息查询
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/so/sdo/shipDetail/query",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO151803Validator")
    public RsResponse<ISO151803RsResult> modifyDbOrder(@RequestBody RsRequest<ISO151803RsParam> param) {
        logger.info("订单发货明细信息查询");
        RsResponse<ISO151803RsResult> rs = new RsResponse<ISO151803RsResult>();
        ISO151803RsResult ISO151803RsResult =this.iso151803Logic.findOrderInfo(param.getParam());
        if(ISO151803RsResult!=null){
            rs.setResult(ISO151803RsResult);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("订单发货明细信息查询成功！");
        }else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("订单发货明细信息查询失败！");
        }


        return rs;
    }
}
