package com.msk.so.rs;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.consts.OrderConst;
import com.msk.core.annotation.Validator;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.so.bean.ISO251401RsParam;
import com.msk.so.bean.ISO251401RsResult;
import com.msk.so.logic.ISO251401Logic;

/**
 * 
 * ISO251401RsController.
 * 
 * @author gyh
 */
@RestController
public class ISO251401RsController extends BaseRsController {
    // /** logger */
    // private static Logger logger = LoggerFactory.getLogger(ISO251401RsController.class);

    @Autowired
    private ISO251401Logic iso251401Logic;

    /**
     * 创建购物需求订单接口
     * 
     * @param param param
     * @return 结果
     * @author gyh
     */
    @RequestMapping(value = "/api/v1/so/pro/new",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    @Validator(validatorClass = "com.msk.so.validator.ISO251401Validator")
    public RsResponse<ISO251401RsResult> createOrder(@RequestBody RsRequest<ISO251401RsParam> param) {
        // 保存购物需求
        RsResponse<ISO251401RsResult> rs = new RsResponse<ISO251401RsResult>();
        String siteCode = param.getSiteCode();
        ISO251401RsParam iso251401RsParam = param.getParam();
        //根据Site Code设置订单来源
        if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_SNK.equals(siteCode)){
            iso251401RsParam.setOrderSource(OrderConst.OrderSource.SNK);
        }else if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_MSK.equals(siteCode)){
            iso251401RsParam.setOrderSource(OrderConst.OrderSource.MSK);
        }else if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_WSC.equals(siteCode)){
            iso251401RsParam.setOrderSource(OrderConst.OrderSource.WSC);
        }else if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_NEW_WSC.equals(siteCode)){
            iso251401RsParam.setOrderSource(OrderConst.OrderSource.NEW_WSC);
        }
        else if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_APP.equals(siteCode)){
            iso251401RsParam.setOrderSource(OrderConst.OrderSource.APP);
        }
        //买家APP
        else if(CommCodeMasterConst.SystemCode.SYSTEM_CODE_BUYER_APP.equals(siteCode)){
            iso251401RsParam.setOrderSource(OrderConst.OrderSource.BUYER_APP);
        } else if (CommCodeMasterConst.SystemCode.SYSTEM_CODE_DQS.equals(siteCode)){
            iso251401RsParam.setOrderSource(OrderConst.OrderSource.DQS);
            iso251401Logic.checkBuyersInfo(iso251401RsParam);
        }
        iso251401RsParam.setCrtId(param.getLoginId());
        ISO251401RsResult result = iso251401Logic.createSoPro(iso251401RsParam,siteCode);
        rs.setStatus(BusinessConst.RsStatus.SUCCESS);
        rs.setMessage("创建购物需求订单成功。");
        rs.setResult(result);
        return rs;
    }
}
