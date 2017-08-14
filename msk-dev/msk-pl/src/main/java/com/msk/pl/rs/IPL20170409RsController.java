package com.msk.pl.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170409Param;
import com.msk.pl.bean.IPL20170409Result;
import com.msk.pl.bean.PlDeclarePriceperiodMst;
import com.msk.pl.logic.IPL20170409Logic;
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
 * Created by zhao_chen1 on 2017/4/18.
 */
@RestController
public class IPL20170409RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170409RsController.class);

    @Autowired
    private IPL20170409Logic ipl20170409Logic;

    @RequestMapping(value = "/api/v1/pl/bs_declaration_periodlist",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<List<PlDeclarePriceperiodMst>> findDateList(@RequestBody RsRequest<IPL20170409Param> param) {
        RsResponse<List<PlDeclarePriceperiodMst>> response = new RsResponse();
        logger.info("根据当前日期获取价盘期数");
        String today = DateTimeUtil.formatDate(DateTimeUtil.FORMAT_DATE_YYYYMMDD, DateTimeUtil.getCustomerDate());
        String year = today.split("-")[0];
        String month = today.split("-")[1];
        String day = today.split("-")[2];
        Integer dd = Integer.valueOf(day);
        if (dd >= 0 && dd <= 5) {
            day = "1日-5日";
        } else if (dd >= 6 && dd <= 10) {
            day = "6日-10日";
        } else if (dd >= 11 && dd <= 15) {
            day = "11日-15日";
        } else if (dd >= 16 && dd <= 20) {
            day = "16日-20日";
        } else if (dd >= 21 && dd <= 25) {
            day = "21日-25日";
        } else if (dd >= 26) {
            day = "26日-月末";
        }

        String pricePeriodYm = year + "-" + month;
        param.getParam().setFilter("priceYm", pricePeriodYm);
        param.getParam().setFilter("day", day);
        IPL20170409Result result = ipl20170409Logic.searchPricePeriodByDate(param.getParam());
        if (null != result) {

            String pricePeriod = result.getPricePeriod();
            param.getParam().setFilter("endPricePeriod", pricePeriod);
            Integer value = Integer.valueOf(pricePeriod.split("期")[0]);
            pricePeriod = (value - 6) + "期";
            param.getParam().setFilter("startPricePeriod", pricePeriod);
            logger.info("根据当前价盘期数获取前6个价盘期数");
            List<PlDeclarePriceperiodMst> periodList = ipl20170409Logic.searchPricePeriod(param.getParam());
            /*if (CollectionUtils.isNotEmpty(periodList)) {
                logger.info("拼接返回日期格式");
                for (int i = 0; i < periodList.size(); i++) {
                    String per = periodList.get(i).getPricePeriod();
                    String mm = periodList.get(i).getPricePeriodMonth();
                    String date = periodList.get(i).getPricePeriodDate();
                    String star = date.split("日")[0];
                    String end = date.split("日")[1];
                    end = end.split("-")[1];
                    String show = per + "(" + mm + star + "-" + mm + end + ")";
                    periodList.get(i).setPricePeriod(show);
                }
            }*/
            if (periodList != null && periodList.size() > NumberConst.IntDef.INT_ZERO) {
                response.setStatus(BusinessConst.RsStatus.SUCCESS);
                response.setMessage("查询成功！");
                response.setResult(periodList);
                return response;
            }
        }
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("没有查询到数据！");
        return response;
    }

}
