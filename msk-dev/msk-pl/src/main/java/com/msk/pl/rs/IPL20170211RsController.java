package com.msk.pl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseUploadController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.pl.bean.IPL20170211Param;
import com.msk.pl.logic.IPL20170211Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuhongyang on 2017/2/9.
 * 进货单产品查询
 */
@RestController
public class IPL20170211RsController extends BaseUploadController {

    private static Logger logger = LoggerFactory.getLogger(IPL20170211RsController.class);


    @Autowired
    private IPL20170211Logic iPL20170211Logic;

    @RequestMapping(value = "/api/v1/pl/bs_task_pd_delete",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.pl.validator.IPL20170211Validator")
    public RsResponse findPdInfoById(@RequestBody RsRequest<IPL20170211Param> param) {
        RsResponse rs = new RsResponse();
        //查询后台,获取数据
        int flg = this.iPL20170211Logic.deletePlPdInfo(param.getParam());
        if (flg > NumberConst.IntDef.INT_ZERO) {
            logger.debug("进货单产品删除接口！DB连接");
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("进货单产品删除接成功 ");
            return rs;
        }
        rs.setStatus(BusinessConst.RsStatus.FAIL);
        rs.setMessage("删除失败！");
        return rs;
    }

}
