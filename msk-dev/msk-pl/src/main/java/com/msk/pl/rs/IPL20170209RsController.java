package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170209Param;
import com.msk.pl.bean.IPL20170209Result;
import com.msk.pl.logic.IPL20170209Logic;
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
 * 进货单产品保存修改接口
 */
@RestController
public class IPL20170209RsController extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170209RsController.class);

    @Autowired
    private IPL20170209Logic iPL20170209Logic;

    @RequestMapping(value = "/api/v1/pl/bs_task_pd_save",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170209Validator")
    public RsResponse<IPL20170209Result> saveAndUpDatePdInfo(@RequestBody RsRequest<IPL20170209Param> param) {
        RsResponse<IPL20170209Result> rs = new RsResponse<IPL20170209Result>();

        IPL20170209Result result;
        if (param.getParam().getPlPdId() != null && param.getParam().getPlPdId() != NumberConst.IntDef.INT_ZERO) {
            result = this.iPL20170209Logic.updatePlPdInfo(param.getParam());
        } else {
            result = this.iPL20170209Logic.savePlPdInfo(param.getParam());
        }
        //查询后台,获取数据
        if (result != null) {
            logger.debug("进货单产品保存修改接口！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("进货单产品保存修改成功 ");
            rs.setResult(result);
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("操作失败！");
        return rs;
    }


}
