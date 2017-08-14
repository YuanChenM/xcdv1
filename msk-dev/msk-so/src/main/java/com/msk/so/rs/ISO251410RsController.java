package com.msk.so.rs;

import java.util.List;

import com.msk.core.annotation.Validator;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.bean.ExceptionMessage;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.so.bean.ISO251410RsParam;
import com.msk.so.bean.ISO251410RsResult;
import com.msk.so.logic.ISO251410Logic;
import com.msk.so.validator.ISO251410Validator;

/**
 * 
 * ISO251404RsController.
 * 取消标准分销退货单
 * @author pxg
 */
@RestController
public class ISO251410RsController extends BaseRsController {

    /** logger */
    private static Logger logger = LoggerFactory.getLogger(ISO251410RsController.class);
    
    @Autowired
    private ISO251410Logic iSO251410Logic;
    
    /**
     * 取消标准分销退货单
     * @param param param
     * @return 结果
     * @author pxg
     */
    @RequestMapping(value="/api/v1/so/sro/cancel",
            method=RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass="ISO251410Validator")
    public RsResponse<ISO251410RsResult> modifyDbOrder(@RequestBody RsRequest<ISO251410RsParam> param){
        logger.info("取消标准分销退货单");
        ISO251410Validator isValidator=new ISO251410Validator();
        isValidator.validator(param.getParam());
        List<ExceptionMessage> exceptionMessages = isValidator.getExceptionMessageList();
        RsResponse<ISO251410RsResult> rs=new RsResponse<ISO251410RsResult>();
        if(!CollectionUtils.isEmpty(exceptionMessages)){
            rs.setStatus(BusinessConst.RsStatus.FAIL);
            rs.setMessage("数据校验不通过，请检查后提交！");
        }else{
            rs.setStatus(BusinessConst.RsStatus.SUCCESS);
            rs.setMessage("数据正常！");
            rs.setResult(iSO251410Logic.findAllList(param));
        }
        return rs;
    }
}
