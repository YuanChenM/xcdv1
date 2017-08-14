package com.msk.org.rs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msk.common.consts.CommCodeMasterConst;
import com.msk.common.logic.CommonLogic;
import com.msk.core.bean.BaseParam;
import com.msk.core.bean.RsRequest;
import com.msk.core.bean.RsResponse;
import com.msk.core.entity.CommConstant;
import com.msk.core.utils.StringUtil;
import com.msk.core.web.base.BaseRsController;
import com.msk.core.web.bean.LoginUser;
import com.msk.core.web.consts.BusinessConst;
import com.msk.org.logic.AuthLogic;
import com.msk.sso.bean.LoginInfo;
import com.msk.sso.bean.LoginType;
import com.msk.sso.bean.LoginTypeResult;
import com.msk.sso.bean.SsoParam;

/**
 * Created by mabo on 2016/5/31.
 */
@RestController
public class AuthRsController extends BaseRsController {

    @Autowired
    private AuthLogic authLogic;
    @Autowired
    private CommonLogic commonLogic;

    /**
     * 获取全部的可登录用户类型。
     * 
     * @param req 请求
     * @return 全部的可登录用户类型
     */
    @RequestMapping(value = "api/v1/org/getLoginType",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<LoginTypeResult> getLoginUserTypes(@RequestBody RsRequest<BaseParam> req) {
        LoginTypeResult result = new LoginTypeResult();
        // 从常量表中获取系统中全部的登录类型
        List<CommConstant> constants = commonLogic.findConstantList(CommCodeMasterConst.LoginUserType.TYPE);
        if (constants != null && !constants.isEmpty()) {
            List<LoginType> types = new ArrayList<>();
            for (CommConstant constant : constants) {
                types.add(new LoginType(constant.getConstantValue(), constant.getConstantName()));
            }
            result.setLoginTypes(types);
        }
        RsResponse rs = new RsResponse();
        rs.setResult(result);
        return rs;
    }

    /**
     * 进入登录处理
     *
     * @param req 请求
     * @return 登陆页面
     */
    @RequestMapping(value = "api/v1/org/authUser",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<LoginInfo> authenticateUser(@RequestBody RsRequest<SsoParam> req) {

        RsResponse<LoginInfo> res = new RsResponse<>();
        res.setStatus(BusinessConst.RsStatus.FAIL);

        // 进行登录验证
        LoginInfo loginInfo = new LoginInfo();
        SsoParam param = null;
        if (req != null && req.getParam() != null) {
            param = req.getParam();
        }
        if (param != null && !StringUtil.isEmpty(param.getLoginId()) && !StringUtil.isEmpty(param.getLoginPwd())) {
            // 根据用户类型进行登录验证
            if (StringUtil.isEmpty(param.getUserType()) || BusinessConst.LoginUserType.EMPL.equals(param.getUserType())
                    || BusinessConst.LoginUserType.SELLER.equals(param.getUserType())
                    || BusinessConst.LoginUserType.BUYER.equals(param.getUserType())) {
                // 员工登录
                LoginUser loginUser = authLogic.getUserInfo(param.getLoginId(), param.getLoginPwd(),
                    param.getUserType());
                if (loginUser != null) {
                    loginInfo.setLoginId(loginUser.getEmplNo());
                    loginInfo.setUserType(loginUser.getUserType());
                    if (StringUtil.isEmpty(param.getUserType())) {
                        res.setMessage("警告：参数中用户类型未设置，以员工身份进行认证");
                    }
                    res.setResult(loginInfo);
                    res.setStatus(BusinessConst.RsStatus.SUCCESS);
                } else {
                    res.setMessage("用户验证失败：用户名或密码不正确");
                }
            } else {
                res.setMessage("用户验证失败：参数中用户类型不正确");
            }
        } else {
            res.setMessage("用户验证失败：登录名和密码不能为空");
        }

        return res;
    }

    /**
     * 清除token信息
     *
     * @param req 请求
     * @return 登陆页面
     */
    @RequestMapping(value = "api/v1/org/getLoginInfo",
        method = RequestMethod.POST,
        produces = { MediaType.APPLICATION_JSON_VALUE })
    public RsResponse<LoginUser> getLoginInfo(@RequestBody RsRequest<SsoParam> req) {
        RsResponse<LoginUser> res = new RsResponse<>();
        res.setStatus(BusinessConst.RsStatus.FAIL);

        SsoParam param = null;
        if (req != null && req.getParam() != null) {
            param = req.getParam();
        }

        if (param != null && !StringUtil.isEmpty(param.getLoginId())) {
            LoginUser loginUser = authLogic.getUserInfo(param.getLoginId(), null, param.getUserType());
            res.setResult(loginUser);
            res.setStatus(BusinessConst.RsStatus.SUCCESS);
        } else {
            res.setMessage("用户登录信息获取失败");
        }

        return res;
    }
}
