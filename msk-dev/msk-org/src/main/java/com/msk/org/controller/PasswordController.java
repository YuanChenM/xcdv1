package com.msk.org.controller;

import com.alibaba.fastjson.TypeReference;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.utils.ConfigManager;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseController;
import com.msk.core.web.bean.LoginUser;
import com.msk.org.bean.param.ModifyPasswordParam;
import com.msk.sso.client.bean.RestResponse;
import com.msk.sso.client.utils.RestClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 修改密码
 */
@Controller
@RequestMapping("comm")
public class PasswordController extends BaseController {

    /**
     * 初期化页面
     * @return
     */
    @RequestMapping(value = "password",method = RequestMethod.POST)
    public String initPasswordPage(){
        return "/common/updatePassword";
    }

    /**
     * 更新密码
     */
    @RequestMapping(value = "update",method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<Boolean> update(String oldPassword, String newPassword){
        LoginUser loginUser = this.getLoginUser();
        // 调用密码修改接口参数
        ModifyPasswordParam param = new ModifyPasswordParam();
        param.setEmployId(loginUser.getEmplId());
        param.setEmployCode(loginUser.getEmplNo());
        param.setNewPassword(newPassword);
        param.setOldPassword(oldPassword);
        RsRequest<ModifyPasswordParam> requestBody = new RsRequest<>();
        requestBody.setParam(param);

        // 调用密码修改接口
        String url = StringUtil.formatMessage("{0}/api/employ/password/_modify", ConfigManager.getOrgServer());//http://localhost:8082/api/employ/password/_modify";
        RestResponse<Boolean> result = RestClientUtil.post(url, requestBody, new TypeReference<RestResponse<Boolean>>() {
        });

        return result;
    }
}
