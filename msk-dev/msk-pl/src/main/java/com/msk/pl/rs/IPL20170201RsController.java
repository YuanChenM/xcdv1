package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170201Param;
import com.msk.pl.bean.IPL20170201Result;
import com.msk.pl.logic.IPL20170201Logic;
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
public class IPL20170201RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170201RsController.class);

    @Autowired
    private IPL20170201Logic iPL20170201Logic;

    @RequestMapping(value = "/api/v1/pl/wquser_auth",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170201Validator")
    public RsResponse<IPL20170201Result> findBreedList(@RequestBody RsRequest<IPL20170201Param> param) {
        RsResponse<IPL20170201Result> rs = new RsResponse<IPL20170201Result>();
        //查询后台,获取List数据
        IPL20170201Result result = this.iPL20170201Logic.findUserExist(param.getParam());
        if (result!=null && (result.getIsBs() != NumberConst.IntDef.INT_ZERO || result.getIsPartner() != NumberConst.IntDef.INT_ZERO)) {
            logger.debug("外勤用户验证接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("外勤用户验证成功!");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("没有查询到数据！");
        return rs;
    }

    }
