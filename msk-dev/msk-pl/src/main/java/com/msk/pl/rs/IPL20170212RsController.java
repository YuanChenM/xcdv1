package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170212Param;
import com.msk.pl.bean.IPL20170212Result;
import com.msk.pl.logic.IPL20170212Logic;
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
 * 买手计费查询接口
 */
@RestController
public class IPL20170212RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170212RsController.class);

    @Autowired
    private IPL20170212Logic iPL20170212Logic;

    @RequestMapping(value = "/api/v1/pl/bs_fee_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170212Validator")
    public RsResponse<IPL20170212Result> findBreedList(@RequestBody RsRequest<IPL20170212Param> param) {
        RsResponse<IPL20170212Result> rs = new RsResponse<IPL20170212Result>();
        //查询后台,获取List数据
        IPL20170212Result result = this.iPL20170212Logic.findFeeList(param.getParam());
        if (result != null && result.getTotalAmount()!=null) {
            logger.debug("买手计费查询接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买手计费查询成功!");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("没有查询到数据！");
        return rs;
    }

}
