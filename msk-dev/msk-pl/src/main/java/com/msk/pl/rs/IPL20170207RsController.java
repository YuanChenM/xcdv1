package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170207Param;
import com.msk.pl.bean.IPL20170207Result;
import com.msk.pl.logic.IPL20170207Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by xuhongyang on 2017/2/6.
 *买家信息查询接口
 */
@RestController
public class IPL20170207RsController extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170207RsController.class);


    @Autowired
    private IPL20170207Logic IPL20170207Logic;

    @RequestMapping(value = "/api/v1/pl/buyer_search",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170207Validator")
    public RsResponse<IPL20170207Result> findBreedList(@RequestBody RsRequest<IPL20170207Param> param) {
        RsResponse<IPL20170207Result> rs = new RsResponse<IPL20170207Result>();

        //查询后台,获取数据
        IPL20170207Result result = this.IPL20170207Logic.findBuyerInfo(param.getParam());
        if (result!=null) {
            logger.debug("买家信息查询接口！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买家信息查询成功 ");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("没有查询到数据！");
        return rs;
    }


    }
