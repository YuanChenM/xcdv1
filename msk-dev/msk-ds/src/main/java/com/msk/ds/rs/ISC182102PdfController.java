package com.msk.ds.rs;

import com.msk.core.bean.BaseParam;
import com.msk.core.bean.PageResult;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.SystemConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.ds.bean.*;
import com.msk.ds.logic.SC182101Logic;
import com.msk.ds.logic.SC182102Logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 发货入库明细PDF打印接口
 *
 * Created by li_kai1 on 2016/8/5.
 */
@RestController

public class ISC182102PdfController extends BaseRsController {
    /**
     * logger
     *
     */
    private static Logger logger = LoggerFactory.getLogger(ISC182102PdfController.class);

    @Autowired
    private SC182102Logic sc182102Logic;
    @Autowired
    private SC182101Logic sc182101Logic;
    /**
     * PDF页面数据打印Controller,以deliveryStockId为条件检索数据库是否存在发货入库单的信息,
     * 存在返回"S",不存在返回"F",并把原SC182102页面分页数据作为PDF页面data.(所有逻辑保持和SC182102画面一致)
     *
     * @return 分页查询数据
     */
    @RequestMapping(value = "/api/v1/sc/deliveryDetail/pdf/print",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.POST)
    public synchronized RsResponse<ISC182102RsResult> search(@RequestBody RsRequest<ISC182102Param> param) {
        RsResponse<ISC182102RsResult> response = new RsResponse<ISC182102RsResult>();
        ISC182102Param isc182102Param = param.getParam();

        BaseParam baseParam = new BaseParam();
        baseParam.getFilterMap().put("deliveryStockId",isc182102Param.getDeliveryStockId());
        SC182101Bean sc182101Bean = sc182101Logic.findPdfInfo(baseParam);

        response.setMessage("PDF获取数据失败");
        response.setStatus(SystemConst.RsStatus.FAIL);
        SC181102Param sc181102Param = new SC181102Param();
        if (sc182101Bean != null) {
            //已确认
            String status = BusinessConst.StockStatusName.IsSure;
            if(isc182102Param.getEdit()){
                //待收货
                if(BusinessConst.DeliveryStockStatus.NoDelivery.equals(sc182101Bean.getDeliveryStockStatus())){
                    status = BusinessConst.StockStatusName.NoDelivery;
                }
                //已收货
                if(BusinessConst.DeliveryStockStatus.Delivery.equals(sc182101Bean.getDeliveryStockStatus())){
                    status = BusinessConst.StockStatusName.Delivery;
                }
            }



            sc182101Bean.setStatusName(status);

            sc181102Param.setDistMonth(sc182101Bean.getDistMonth());
            sc181102Param.setAreaCode(sc182101Bean.getLgcsCode());
            sc181102Param.setSupplierCode(sc182101Bean.getSuppCode());
            sc181102Param.setHalfCode(sc182101Bean.getHalfCode());
            sc181102Param.getFilterMap().put("deliveryStockId", sc182101Bean.getDeliveryStockId());
            //获取半旬
            DistSuppChain halfName = sc182102Logic.getHalfName(sc181102Param);

            //从获取到的半旬list里，将与之对应的halfcode 的halfname 置入bean内
            if(null != halfName){

                for(DistSuppChain obj:halfName.getHalfNameList()){

                    if(sc181102Param.getHalfCode().equals(obj.getHalfCode())){

                        sc182101Bean.setHalfName(obj.getHalfName());
                    }
                }
            }
            PageResult<SC182102Param> pageList = sc182102Logic.findPageList(sc181102Param,isc182102Param.getEdit());

            List<SC182102Param> dataList = pageList.getData();
            ISC182102RsResult isc182102RsResult = new ISC182102RsResult();
            isc182102RsResult.setSc182102Info(sc182101Bean);
            isc182102RsResult.setDetailList(dataList);

            response.setStatus(SystemConst.RsStatus.SUCCESS);
            response.setMessage("PDF获取数据成功");
            response.setResult(isc182102RsResult);
        }
        return response;

    }
}
