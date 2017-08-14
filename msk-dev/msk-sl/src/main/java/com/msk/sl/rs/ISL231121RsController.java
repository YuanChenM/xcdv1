package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlSeller;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231121RsResult;
import com.msk.sl.logic.SL24110102Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cx on 2016/2/15.
 */
@RestController
public class ISL231121RsController extends BaseRsController {
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231121RsController.class);
    @Autowired
    private SL24110102Logic sL24110102Logic;
    /**
     * 修改卖家基本信息接口
     *
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slSeller/update",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231121Validator")
    public RsResponse<ISL231121RsResult> updateSLSeller(@RequestBody RsRequest<SlSeller> param) {
        logger.debug("修改卖家基本信息接口");
        RsResponse<ISL231121RsResult> rs=new RsResponse<ISL231121RsResult>();
        SlSeller slSeller = param.getParam();
        sL24110102Logic.updateSl(slSeller);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("修改卖家基本信息成功");
        return rs;
    }
}
