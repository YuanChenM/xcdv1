package com.msk.sso.rs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.common.utils.RsClientUtil;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.consts.BusinessConst;
import com.msk.sso.bean.LoginInfo;
import com.msk.sso.bean.SsoParam;
import com.msk.sso.bean.SsoResult;
import com.msk.sso.utils.TokenManager;

/**
 * 单点登录login页面的控制器
 *
 * @version 1.0
 **/
@RestController
public class LoginRsController extends BaseRsController {

    /** 日志 */
    private static Logger logger = LoggerFactory.getLogger(LoginRsController.class);

    @Autowired
    private RsClientUtil rsClient;

    /**
     * 检查token是否有效
     *
     * @return 有效时返回登录id
     */
    @RequestMapping(value = "api/v1/sso/createToken",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public SsoResult createToken(@RequestBody SsoParam param) {
        SsoResult result = new SsoResult();
        // 进行登录验证
        if (param != null) {
            // 根据config中的环境区分，获取相应url
            // TODO url从config文件中根据env获取
            String loginUrl = StringUtil.formatMessage("{0}/api/v1/org/authUser", ConfigManager.getApiServerUrl());
            RsRequest<SsoParam> rsParam = new RsRequest<>();
            rsParam.setLoginId("system");
            rsParam.setAuth("123456");
            rsParam.setSiteCode("bms");
            rsParam.setParam(param);
            RsResponse<LoginInfo> res = rsClient.postRsService(loginUrl, rsParam, LoginInfo.class);
            LoginInfo loginInfo = null;
            if (res != null && BusinessConst.RsStatus.SUCCESS.equals(res.getStatus())) {
                loginInfo = res.getResult();
            }
            if (loginInfo != null && TokenManager.getInstance().createToken(loginInfo)) {
                // 登录成功
                result.setToken(loginInfo.getToken());
                result.setLoginId(loginInfo.getLoginId());
                result.setUserType(loginInfo.getUserType());
                result.setEnv(param.getEnv());
                if (!StringUtil.isEmpty(param.getUrl())) {
                    result.setUrl(param.getUrl());
                } else {
                    // 默认页面
                    // TODO 做成配置
                    String defaultPageUrl = StringUtil.formatMessage("{0}/main", ConfigManager.getWebServerUrl());
                    result.setUrl(defaultPageUrl);
                }
            } else {
                // 登录失败
                result.setLoginId(param.getLoginId());
                result.setMessage("登录失败：用户名或密码不正确");
            }
        } else {
            result.setMessage("登录失败：请输入用户名或密码");
        }

        return result;
    }

    /**
     * 检查token是否有效
     *
     * @return 有效时返回登录id
     */
    @RequestMapping(value = "api/v1/sso/checkToken",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public SsoResult checkToken(@RequestBody SsoParam param) {
        SsoResult result = new SsoResult();

        // 检查token
        if (param != null && !StringUtil.isEmpty(param.getToken())) {
            // 检查原有token是否还有效
            LoginInfo loginInfo = TokenManager.getInstance().checkToken(param.getToken());
            if (loginInfo != null) {
                // 原有token还有效
                result.setToken(loginInfo.getToken());
                result.setLoginId(loginInfo.getLoginId());
                result.setUserType(loginInfo.getUserType());
                result.setMessage("token有效");
            } else {
                // 登录失败
                result.setMessage("token失效");
            }
        } else {
            // 登录失败
            result.setMessage("参数不正确");
        }
        return result;
    }

    /**
     * 清除token信息
     *
     * @return 登陆页面
     */
    @RequestMapping(value = "api/v1/sso/clearToken",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public SsoResult clearToken(@RequestBody SsoParam param) {
        SsoResult result = new SsoResult();

        if (param != null && !StringUtil.isEmpty(param.getToken()) && !StringUtil.isEmpty(param.getLoginId())) {

            // 检查原有token是否还有效
            if (TokenManager.getInstance().clearToken(param.getLoginId(), param.getToken())) {
                logger.debug("用户[{}]退出：{}", param.getLoginId(), param.getToken());
            } else {
                result.setMessage("token清除失败：登录id不匹配");
            }
        } else {
            result.setMessage("token清除失败：参数不正确");
        }

        return result;
    }
}
