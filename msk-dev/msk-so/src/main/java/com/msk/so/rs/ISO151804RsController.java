package com.msk.so.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.ISO151804ReasonResult;
import com.msk.so.bean.ISO151804RsParam;
import com.msk.so.bean.ISO151804RsResult;
import com.msk.so.logic.ISO151804Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 根据退货类型查询可用的退货原因
 * zhang_qiang1
 */

@RestController
public class ISO151804RsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151804RsController.class);

    @Autowired
    private ISO151804Logic iso151804Logic;

    /**
     * 退货原因查询
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/so/sro/returnReason/search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<ISO151804RsResult> findReturnReasonJson(@RequestBody RsRequest<ISO151804RsParam> param) {
        logger.info("退货原因查询");
        RsResponse<ISO151804RsResult> rs = new RsResponse<ISO151804RsResult>();
        ISO151804RsResult result = new ISO151804RsResult();
        List<ISO151804ReasonResult> reasonResults = this.iso151804Logic.findReturnReasons(param.getParam());
        if (!CollectionUtils.isEmpty(reasonResults)) {
            result.setReasonList(reasonResults);
            rs.setResult(result);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("退货原因查询成功！");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("退货原因查询失败！");
        }
        return rs;
    }


    /**
     * 输入  输出都是xml
     *
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/so/sro/returnReason/search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_XML_VALUE})
    public RsResponse<ISO151804RsResult> findReturnReasonXML(@RequestBody RsRequest<ISO151804RsParam> param) {
        logger.info("退货原因查询");
        RsResponse<ISO151804RsResult> rs = new RsResponse<ISO151804RsResult>();
        ISO151804RsResult result = new ISO151804RsResult();
        List<ISO151804ReasonResult> reasonResults = this.iso151804Logic.findReturnReasons(param.getParam());
        if (!CollectionUtils.isEmpty(reasonResults)) {
            result.setReasonList(reasonResults);
            rs.setResult(result);
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("退货原因查询成功！");
        } else {
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("退货原因查询失败！");
        }
        return rs;
    }
}
