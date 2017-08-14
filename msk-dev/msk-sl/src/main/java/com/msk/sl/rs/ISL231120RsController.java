package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlSeller;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231120RsResult;
import com.msk.sl.logic.SL241103001Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cx on 2016/2/15.
 */
@RestController
public class ISL231120RsController extends BaseRsController {

    private static Logger logger = LoggerFactory.getLogger(ISL231120RsController.class);
    @Autowired
    private SL241103001Logic sL241103001Logic;

    /**
     * 增加卖家基本信息接口
     * @param param
     * @return
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slSeller/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231120Validator")
    public RsResponse<ISL231120RsResult> createSlSeller(@RequestBody RsRequest<SlSeller> param){
        logger.debug("增加卖家基本信息接口");
        RsResponse<ISL231120RsResult> rs=new RsResponse<ISL231120RsResult>();
        SlSeller slSeller = param.getParam();
        sL241103001Logic.saveSeller(slSeller);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("增加卖家基本信息成功");
        return rs;
    }
}
