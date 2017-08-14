package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170202Param;
import com.msk.pl.bean.IPL20170202Result;
import com.msk.pl.logic.IPL20170202Logic;
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
 * Created by xuhongyang on 2017/2/6.
 *
 */
@RestController
public class IPL20170202RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170202RsController.class);

    @Autowired
    private IPL20170202Logic iPL20170202Logic;

    @RequestMapping(value = "/api/v1/pl/bs_task_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170202Validator")
    public RsResponse<List<IPL20170202Result>> findBreedList(@RequestBody RsRequest<IPL20170202Param> param) {
        RsResponse<List<IPL20170202Result>> rs = new RsResponse<List<IPL20170202Result>>();
        //查询后台,获取List数据
        List<IPL20170202Result> result = this.iPL20170202Logic.findTaskList(param.getParam());
        if (result!=null) {
            logger.debug("买手任务列表接口成功！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买手任务列表,查询成功!");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("没有查询到数据！");
        return rs;
    }

    }
