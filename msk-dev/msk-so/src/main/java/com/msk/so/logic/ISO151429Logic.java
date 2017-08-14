package com.msk.so.logic;

import com.msk.common.utils.RsClientUtil;
import com.msk.core.base.BaseDao;
import com.msk.core.base.BaseLogic;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.ConfigManager;
import com.msk.so.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wang_shuai on 2016/6/24.
 */
@Service
public class ISO151429Logic extends BaseLogic {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISO151429Logic.class);

    @Autowired
    @Override
    public void setBaseDao(BaseDao baseDao) {
        super.setBaseDao(baseDao);
    }
    @Autowired
    private RsClientUtil rsClientUtil;

    @Transactional(readOnly = true)
    public ISO151429RsResult findHousekeepingPdInfo(ISO151429RsParam iso151429RsParam){
        logger.info("开始查询管家可出售的商品");
        ISO151429RsResult iso151429RsResult = new ISO151429RsResult();
        List<ISO151429HouseKeepingPd> resultList = new ArrayList<ISO151429HouseKeepingPd>();
        if(iso151429RsParam.getPageCount() != NumberConst.IntDef.INT_ZERO && iso151429RsParam.getPageNo() != NumberConst.IntDef.INT_ZERO)
        {
            iso151429RsParam.setPaging(true);
        }
        else
        {
            iso151429RsParam.setPaging(false);
        }
        resultList = this.findPageList(iso151429RsParam,iso151429RsResult);

        //调用价盘查询箱价的接口，得到商品价格list
        //String pdPriceUrl = "http://10.20.16.147:8090/msk-snk-price/api/sp/getPriceBox";
        String pdPriceUrl = ConfigManager.getApiSearchPriceUrl();
        ISO151429PriceParam iso151429PriceParam = new ISO151429PriceParam();
        RsRequest<ISO151429PriceParam> request = new RsRequest<ISO151429PriceParam>();
        //String lgcs = "41";
        //List<String> list  = new ArrayList<>();
        //list.add("0210108161");
        //iso151429PriceParam.setLgcsCode(lgcs);
        //iso151429PriceParam.setPdCodes(list);
        request.setAuth("MSK00001");
        request.setSiteCode("101");
        request.setLoginId("msk01");
        request.setParam(iso151429PriceParam);
        RsResponse<ISO151429PriceResult> response = rsClientUtil.postRsService(pdPriceUrl, request, ISO151429PriceResult.class);
        List<ISO151429PriceBean> priceBeans = new ArrayList<ISO151429PriceBean>();
        priceBeans = response.getResult().getSearchList();

        for(ISO151429HouseKeepingPd houseKeepingPd:resultList){
            for (ISO151429PriceBean priceBean:priceBeans){
                if(houseKeepingPd.getPdCode().equals(priceBean.getPdCode())){
                    houseKeepingPd.setUnitPrice(priceBean.getWayGradePriceBox());
                }
            }

        }
        iso151429RsResult.setHouseKeepingPdList(resultList);



        return iso151429RsResult;

    }
}
