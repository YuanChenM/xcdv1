package com.msk.sl.rs;

import com.msk.core.consts.NumberConst;
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
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231119RsParam;
import com.msk.sl.bean.ISL231119RsResult;
import com.msk.sl.logic.ISL231119Logic;

/**
 * ISL231119RsController.
 *
 * @author yuan_chen
 */
@RestController
public class ISL231119RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISL231119RsController.class);

    /** ISL231119Logic */
    @Autowired
    private ISL231119Logic isl231119Logic;

    /**
     * 查询物流区卖家产品信息
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/sl/slBidLogiArea",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<ISL231119RsResult> query(@RequestBody RsRequest<ISL231119RsParam> param) {
        logger.info("查询物流区卖家产品信息");
        if (param == null){
            param = new RsRequest<ISL231119RsParam>();
        }
        RsResponse<ISL231119RsResult> rs = new RsResponse<ISL231119RsResult>();
        ISL231119RsResult result = isl231119Logic.findRsResult(param.getParam());
        if (result.getTotalCount() == NumberConst.IntDef.INT_ZERO){
            rs.setMessage("未查询到物流区卖家产品信息！");
        }else{
            rs.setMessage("查询物流区卖家产品信息成功！");
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setResult(result);
        return rs;
    }
}
