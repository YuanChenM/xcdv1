package com.msk.ol.rs;

import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.consts.NumberConst;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.ol.bean.IOL101001RsParam;
import com.msk.ol.bean.IOL101001RsResult;
import com.msk.sms.utils.SmsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/3/28.
 */
@RestController
public class IOL101001RsController extends BaseRsController{
    private static Logger logger = LoggerFactory.getLogger(IOL101001RsController.class);

    /**
     * 获得短信验证码信息
     * @param request 请求参数
     * @return 短信验证码
     */
    @RequestMapping(value = "/api/v1/ol/send/captcha", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<IOL101001RsResult> sendMessage(@RequestBody RsRequest<IOL101001RsParam> request){
        String captcha = SmsUtils.createRandom(Boolean.TRUE, NumberConst.IntDef.INT_SIX);
        logger.debug("验证码："+captcha);
        String message = "尊敬的用户您好您本次验证码为"+captcha+"请在10分钟内使用完了工作人员不会索要号码请勿泄露号码";
        logger.debug("发送的内容："+message);
        IOL101001RsParam param = request.getParam();
        String mobile = param.getMobile();
        SmsUtils.sendCaptchaMessage(mobile,message);
        RsResponse<IOL101001RsResult> response = new RsResponse<>();
        IOL101001RsResult result = new IOL101001RsResult();
        result.setCaptcha(captcha);
        response.setResult(result);
        response.setMessage("验证码短信发送成功");
        response.setStatus(BusinessConst.RsStatus.SUCCESS);
        return response;
    }
}
