package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170225Param;
import com.msk.pl.bean.IPL20170225Result;
import com.msk.pl.logic.IPL20170225Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhongyang on 2017/2/6.
 *
 */
@RestController
public class IPL20170225RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170225RsController.class);

    @Autowired
    private IPL20170225Logic iPL20170225Logic;

    @RequestMapping(value = "/api/v1/pl/bs_statement_number",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170225Validator")
    public RsResponse<IPL20170225Result> findBreedList(@RequestBody RsRequest<IPL20170225Param> param) {
        RsResponse<IPL20170225Result> rs = new RsResponse<IPL20170225Result>();
        //查询后台,获取List数据
        IPL20170225Result result = this.iPL20170225Logic.findReDay(param.getParam());
        if (result!=null) {
            logger.debug("查询补报天数！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("查询补报天数成功!");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("没有查询到数据!");
        return rs;
    }

    }
