package com.msk.sl.rs;

import com.msk.core.annotation.Validator;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.SlEpCap;
import com.msk.core.exception.BusinessException;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sl.bean.ISL231127RsResult;
import com.msk.sl.logic.SL24110300402Logic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by Administrator on 2016/2/22.
 */
@RestController
public class ISL231131RsController extends BaseRsController{
    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ISL231131RsController.class);
    @Autowired
    private SL24110300402Logic sl24110300402Logic;
    /**
     * 新增企业生产能力
     * @param param param
     * @return rs
     */
    @RequestMapping(value = "/api/v1/sl/slInfo/slEpCap/new",method = RequestMethod.POST,produces = {MediaType.APPLICATION_JSON_VALUE})
    @Validator(validatorClass = "com.msk.sl.validator.ISL231131Validator")
    public RsResponse<ISL231127RsResult> deleteSLEpCert(@RequestBody RsRequest<SlEpCap> param) {
        SlEpCap slEpCap =param.getParam();
        Long epId = slEpCap.getEpId();
        SlEpCap cap=this.sl24110300402Logic.findSlEpCapIfExist(epId);
        if(null!=cap){
            throw new BusinessException("已经存在数据，无法继续增加，请到编辑页面查看修改");
        }
        this.sl24110300402Logic.saveSlEpCap(slEpCap);
        RsResponse<ISL231127RsResult> rs=new RsResponse<ISL231127RsResult>();
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("保存成功");
        return rs;
    }
}
