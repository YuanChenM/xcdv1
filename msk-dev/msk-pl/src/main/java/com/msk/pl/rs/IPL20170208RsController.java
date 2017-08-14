package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170208Param;
import com.msk.pl.bean.IPL20170208Result;
import com.msk.pl.logic.IPL20170208Logic;
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
 * 买家信息查询接口
 */
@RestController
public class IPL20170208RsController extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170208RsController.class);


    @Autowired
    private IPL20170208Logic iPL20170208Logic;

    @RequestMapping(value = "/api/v1/pl/bs_task_save",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170208Validator")
    public RsResponse<IPL20170208Result> saveAndUpdatePlInfo(@RequestBody RsRequest<IPL20170208Param> param) {
        RsResponse<IPL20170208Result> rs = new RsResponse<IPL20170208Result>();
        IPL20170208Result result;
        if (param.getParam().getPlId() != null) {
            result = this.iPL20170208Logic.upDatePlInfo(param.getParam());
        } else {
            result = this.iPL20170208Logic.savePlInfo(param.getParam());
        }
        //查询后台,获取数据
        if (rs != null ) {
            logger.debug("进货单保存修改接口！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("买进货单保存修改成功 ");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("操作失败！");
        return rs;
    }


}
