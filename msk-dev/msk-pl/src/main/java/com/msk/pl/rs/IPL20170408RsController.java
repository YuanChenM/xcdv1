package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.*;
import com.msk.pl.logic.IPL20170408Logic;
import com.msk.pl.util.beanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tao_zhifa on 2017/4/17.
 */
@RestController
public class IPL20170408RsController extends BaseRsController {


    @Autowired
    private IPL20170408Logic ipl20170408Logic;


    @RequestMapping(value = "api/v1/pl/bs_declaration_check")
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170408Validator")
    public RsResponse<IPL20170408Result> init(@RequestBody RsRequest<IPL20170408Param> ipl20170408Param) {
        RsResponse<IPL20170408Result> rsResponse = new RsResponse<>();
        PlDeclarePriceperiodMst plDeclarePriceperiodMst = null;
        if (("0").equals(ipl20170408Param.getParam().getIsChecked())) {
            plDeclarePriceperiodMst = ipl20170408Logic.selectPricePeriodMstByNewDate(ipl20170408Param.getParam());
        }
        if (("1").equals(ipl20170408Param.getParam().getIsChecked())) {
            plDeclarePriceperiodMst = ipl20170408Logic.selectPricePeriodMstByPpId(ipl20170408Param.getParam());
        }

        PlDeclareTask plDeclareTask;
        plDeclareTask = ipl20170408Logic.selectPeriods(plDeclarePriceperiodMst,ipl20170408Param.getParam());
        if (plDeclareTask == null || plDeclareTask.getPpId() == null) {
            plDeclareTask = ipl20170408Logic.saveDeclareTask(plDeclarePriceperiodMst, ipl20170408Param);
        }

        String show = "";
        if (StringUtils.isNotEmpty(plDeclarePriceperiodMst.getPricePeriodDate())) {
            String per = plDeclarePriceperiodMst.getPricePeriod();
//            String mm = plDeclarePriceperiodMst.getPricePeriodMonth();
            String date = plDeclarePriceperiodMst.getPricePeriodDate();
//            String star = date.split("日")[0];
//            String end = date.split("日")[1];
//            end = end.split("-")[1];
//            show = per + "(" + mm + star + "-" + mm + end + ")";
            show = per + "("+date+")";

        }
        IPL20170408Result ipl20170408Result = beanUtils.toBean(plDeclareTask,IPL20170408Result.class);
        ipl20170408Result.setPricePeriodDate(show);
        List<PlPdMst> plPdMstList = ipl20170408Logic.findMstAll(ipl20170408Param.getParam());
        ipl20170408Logic.savePlDeclareInfo(plPdMstList, plDeclareTask, ipl20170408Param);
        rsResponse.setResult(ipl20170408Result);
        rsResponse.setStatus(BusinessConst.RsStatus.SUCCESS);
        rsResponse.setMessage("查询成功！");
        return rsResponse;
    }


}
