package com.msk.ds.rs;

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
import com.msk.ds.bean.IDS174101RsParam;
import com.msk.ds.bean.IDS174101RsResult;
import com.msk.ds.logic.IDS174101Logic;

/**
 *
 * IDS174101RsController.
 * 查询批次产品信息
 *
 * @author yuan_chen
 */
@RestController
public class IDS174101RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(IDS174101RsController.class);

    /** IDS174101Logic */
    @Autowired
    private IDS174101Logic ids174101Logic;

    /**
     * 查询批次产品信息
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/ds/ds_pdLotInfo",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<IDS174101RsResult> queryProductLotInfo(@RequestBody RsRequest<IDS174101RsParam> param) {
        logger.info("查询批次产品信息");
        RsResponse<IDS174101RsResult> rs = new RsResponse<IDS174101RsResult>();
        IDS174101RsResult result = ids174101Logic.findRsResult(param.getParam());
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询批次产品信息成功！");
        rs.setResult(result);
        return rs;
    }
}
