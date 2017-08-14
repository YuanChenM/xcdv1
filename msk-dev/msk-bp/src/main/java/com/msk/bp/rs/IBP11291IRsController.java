package com.msk.bp.rs;

import com.msk.bp.bean.IBP11291IRsParam;
import com.msk.bp.bean.IBP11291IRsResult;
import com.msk.bp.logic.IBP11291ILogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * IBP11291IRsController
 * 美侍客卖家产品价盘查询
 *
 * @author xu_wei
 */
@RestController
public class IBP11291IRsController extends BaseRsController {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(IBP11291IRsController.class);

    @Autowired
    private IBP11291ILogic ibp11291ILogic;

    /**
     * 美侍客卖家产品价盘表
     *
     * @param param param
     * @return 结果
     * @author xu_wei
     */
    @RequestMapping(value = "/api/v1/bp/bpPrice/list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<IBP11291IRsResult> modifyDbOrder(@RequestBody RsRequest<IBP11291IRsParam> param) {
        logger.info("查询美侍客卖家产品价盘信息");
        RsResponse<IBP11291IRsResult> rs = new RsResponse<IBP11291IRsResult>();
        if(StringUtils.isEmpty(param.getParam().getPricePeriod())){
            throw new BusinessException("价盘周期不可以为空。");
        }
        IBP11291IRsResult ibp11291IRsResult = ibp11291ILogic.findAllList(param);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询美侍客卖家产品价盘信息成功");
        rs.setResult(ibp11291IRsResult);
        return rs;
    }
}
