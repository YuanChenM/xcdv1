package com.msk.ds.rs;

import com.msk.core.bean.BasePageParam;
import com.msk.core.bean.PageResult;
import com.msk.core.entity.TempBarcode;
import com.msk.ds.bean.BarCodeParam;
import com.msk.ds.logic.BarCodeLogic;
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

import java.util.List;

/**
 *
 * BarCodeRsController.
 *
 * @author yuan_chen
 */
@RestController
public class BarCodeRsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(BarCodeRsController.class);

    @Autowired
    private BarCodeLogic barCodeLogic;

    /**
     * 查询打印信息
     *
     * @param param param
     * @return 结果
     */
    @RequestMapping(value = "/api/v1/ds/barcode/query",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<List<TempBarcode>> query(@RequestBody RsRequest<BarCodeParam> param) {
        RsResponse<List<TempBarcode>> rs = new RsResponse<>();

        BasePageParam pageParam = new BasePageParam();
        pageParam.setPaging(true);
        pageParam.setStartPos(param.getParam().getPrintStart() - 1);
        pageParam.setPageSize(param.getParam().getPrintEnd() - param.getParam().getPrintStart() + 1);
        pageParam.getFilterMap().put("barcodeId", param.getParam().getBarcodeId());
        PageResult<TempBarcode> pageResult = barCodeLogic.findPage(pageParam, TempBarcode.class);

        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("查询成功！");
        rs.setResult(pageResult.getData());
        return rs;
    }
}
