package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170224Param;
import com.msk.pl.bean.IPL20170224Result;
import com.msk.pl.logic.IPL20170224Logic;
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
 * 根据任务ID查询对应进货单
 */
@RestController
public class IPL20170224RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170224RsController.class);

    @Autowired
    private IPL20170224Logic iPL20170224Logic;

    @RequestMapping(value = "/api/v1/pl/bs_pl_list",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170224Validator")
    public RsResponse<List<IPL20170224Result>> findBreedList(@RequestBody RsRequest<IPL20170224Param> param) {

        RsResponse<List<IPL20170224Result>> rs = new RsResponse<List<IPL20170224Result>>();
        //查询后台,获取List数据
        List<IPL20170224Result> result = this.iPL20170224Logic.findPlInfoList(param.getParam());
        if (result != null && result.size() > NumberConst.IntDef.INT_ZERO) {
            logger.debug("根据任务ID查询对应进货单接口！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("根据任务ID查询对应进货单成功！ ");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("没有查询到数据！");
        return rs;
    }

}
