package com.msk.so.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.so.bean.HouseAccountSalesResult;
import com.msk.so.bean.ISO151406RsParam;
import com.msk.so.bean.ISO151406RsResult;
import com.msk.so.logic.ISO151406Logic;
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
 * ISO151406RsController
 *
 * @author sunjiaju
 * @version 1.0
 */
@RestController
public class ISO151406RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151406RsController.class);

    @Autowired
    private ISO151406Logic iso151406Logic;

    /**
     * 冻品管家旗下买家月销售额查询
     *
     * @param request 请求参数
     * @return
     */
    @RequestMapping(value = "/api/v1/so/houseaccount/sales/_search", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.so.validator.ISO151406Validator")
    public RsResponse<ISO151406RsResult> searchSales(@RequestBody RsRequest<ISO151406RsParam> request) {
        logger.info("查询销售额开始");
        ISO151406RsParam param = request.getParam();
        List<HouseAccountSalesResult> salesList = this.iso151406Logic.searchSales(param);
        ISO151406RsResult result = new ISO151406RsResult();
        RsResponse<ISO151406RsResult> response = new RsResponse<ISO151406RsResult>();
        if (CollectionUtils.isNotEmpty(salesList)) {
            result.setSalesList(salesList);
            response.setResult(result);
            response.setMessage("查询销售额成功");
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
        } else {
            response.setMessage("查询不到管家相应月份的销售额");
            response.setStatus(BusinessConst.RsStatus.FAIL);
        }
        return response;
    }
}
