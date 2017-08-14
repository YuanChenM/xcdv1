package com.msk.pl.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.utils.DateTimeUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170401Param;
import com.msk.pl.bean.IPL20170401Result;
import com.msk.pl.logic.IPL20170401Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xuhongyang on 2017/2/6.
 */
@RestController
public class IPL20170401RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170401RsController.class);

    @Autowired
    private IPL20170401Logic ipl20170401Logic;

    @RequestMapping(value = "/api/v1/pl/bs_declaration_datelist",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public RsResponse<List<IPL20170401Result>> findDateList(@RequestBody RsRequest<IPL20170401Param> param) {
        RsResponse<List<IPL20170401Result>> response = new RsResponse();


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, -1);

        SimpleDateFormat formatDay = new SimpleDateFormat("dd");
        // 获取前月的最后一天
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String  lastDay = formatDay.format(cale.getTime());

        cale = Calendar.getInstance();
        int day = cale.get(Calendar.DATE);

        String newYear;
        if(day >= 26 && day <= Integer.valueOf(lastDay)){
            int year = cale.get(Calendar.YEAR);
            int month = cale.get(Calendar.MONTH) + 2;
            newYear = year + "-" + month;
        }else {
            newYear = DateTimeUtil.formatDate("yyyy-MM", DateTimeUtil.getCustomerDate());
        }


        String lastYear = DateTimeUtil.formatDate("yyyy-MM", cale.getTime());
        param.getParam().setFilter("lastYear", lastYear);
        param.getParam().setFilter("newYear", newYear);
        List<IPL20170401Result> dateList = ipl20170401Logic.findDateList(param.getParam());
        if (dateList != null && dateList.size() > NumberConst.IntDef.INT_ZERO) {
            logger.debug("申报年月成功");
            response.setStatus(BusinessConst.RsStatus.SUCCESS);
            response.setMessage("查询成功！");
            response.setResult(dateList);
            return response;
        }
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        response.setMessage("没有查询到数据！");
        return response;
    }


}
