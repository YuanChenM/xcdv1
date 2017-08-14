<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="ver" value="0101"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统${systemEnv}</title>
    <link href="${ctx}/static/core/css/pub.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/sso/css/iconfont.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/sso/css/iconfont-main.css" rel="stylesheet" type="text/css">
    <link href="${ctx}/static/core/css/jquery-ui.min.css" rel="stylesheet" type="text/css">
    <script src="${ctx}/static/core/js/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/core/js/jquery-ui.min.js" type="text/javascript"></script>
    <script src="${ctx}/static/sso/js/login.js?v=${ver}" type="text/javascript"></script>
    <style>
        .login-backgroud-color {
            background-color: white;
        }

        .custom-combobox {
            position: relative;
            display: inline-block;
        }

        .custom-combobox-toggle {
            position: absolute;
            top: 0;
            bottom: 0;
            margin-left: -1px;
            padding: 0;
            background: none;
            border: none;
        }

        .custom-combobox-input {
            margin: 0 0 0 15px;
            padding: 5px 10px 5px 0;
            width: 180px;
            background: none;
            border: none;
            font-family: "Microsoft Yahei";
            font-size: 14px;
            color: #333;
        }
    </style>

    <script type="text/javascript">
        $(function () {
            $("#userType").combobox();
            $("#submitNew").click(function () {
                if ($("#loginId").val() == "") {
                    alert("请输入用户名!");
                    $("#loginId").focus().select();
                    return false;
                }
                if ($("#loginPwd").val() == "") {
                    alert("请输入密码!");
                    $("#loginPwd").focus().select();
                    return false;
                }
                $("#loginForm").submit();
//            $.ajax({
//                url: $("#loginForm").attr("action"),
//                options: {},
//                async: false,
//                type: "POST",
//                dataType: "json",
//                data: {
//                    loginId: $("#loginId").val(),
//                    loginPwd: $("#loginPwd").val(),
//                },
//                success: function (result) {
//                    if(result.token != null){
//
//                    }else{
//                        alert(result.message);
//                    }
//                },
//                error: function () {
//                    alert("通信故障，请重试！");
//                }
//            });
            });

            $(window).keydown(function (e) {
                if (e.which == 13) {
                    $("#submitNew").click();
                }
            });
        });
    </script>
</head>
<body>

<div>

    <div id="popup_filter"></div>
    <div class="wrapper">
        <div id="login_hd">
            <div class="login_hd">
                <div id="login-logo"
                     style="height:98px; background: url('${ctx}/static/sso/images/logo.png') no-repeat;background-size: 25%;vertical-align: central;">
                </div>
            </div>
        </div>
        <div class="login_middle"
             style="background: url('${ctx}/static/sso/images/wallpaper-1.png') no-repeat center;">
            <form method="post" action="${ctx}/login" id="loginForm">
                <input type="hidden" name="env" value="${result.env}"/>
                <input type="hidden" name="url" value="${result.url}"/>

                <div id="background" class="login_box_bg">
                    <div id="login-bg" class="form login-backgroud-color" style="top: 20px; height:45px;">
                        <span style="margin-left:9%;font-size:24px;line-height:20px;">用户登录</span>
                    </div>
                    <div id="newVersionLogin" class="form login-backgroud-color">
                        <table class="all_input">
                            <tbody>
                            <tr>
                                <td></td>
                                <td style="height:45px;padding: 5px;">
                                    <label id="lblUserType" for="userType"></label>
                                    <i class="iconfont icon-login">&#xe630;</i>
                                    <select id="userType" name="userType">
                                        <c:forEach items="${userTypes}" var="type" varStatus="status">
                                            <option value="${type.code}" <c:if test="${type.code==result.userType}">selected</c:if>>${type.name}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                                <td></td>
                            </tr>
                            <tr class="line">
                                <td></td>
                                <td class="tdline_2" width="30" style="height: 0px;"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td style="height:40px;padding: 5px;">
                                    <label id="lblNewUserName" for="loginId"></label>
                                    <i class="iconfont icon-login">&#xe630;</i>
                                    <input id="loginId" class="module_app_input___gray_neoskin"
                                           style="margin-left:15px; margin-top: 0; width:200px;" placeholder="用户名"
                                           type="text"
                                           value="${result.loginId}"
                                           tabindex="1"
                                           name="loginId" autocapitalize="off">
                                </td>
                                <td></td>
                            </tr>
                            <tr class="line">
                                <td></td>
                                <td class="tdline_2" width="30" style="height: 0px;"></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td style="height:40px;padding: 5px;">
                                    <label id="lblNewPassword" for="loginPwd"></label>
                                    <i class="iconfont icon-login">&#xe61f;</i>
                                    <input id="loginPwd" class="module_app_input___gray_neoskin"
                                           style="margin-left:15px; margin-top: 0; width:200px;" placeholder="密码"
                                           type="password" value=""
                                           tabindex="1"
                                           name="loginPwd" autocapitalize="off">
                                    <a class="forget" href="#"></a>
                                </td>
                                <td></td>
                            </tr>
                            </tbody>
                        </table>
                        <div style="margin-left:9%;height:20px;">
                            <span style="font-size:12px;color:red;line-height:20px;">${result.message}</span>
                        </div>
                        <div class="btn_wrap login-backgroud-color">
                            <input type="button" name="submitNew" value="登录" id="submitNew" class="btn_login_submit">
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div>
            <p class="copyright" style="text-align: center; margin-bottom: 60px;">Copyright © 2016 Xian Chi Da
                Group. All Rights Reserved.<br/><a href="http://www.miitbeian.gov.cn/" target="_blank">网站备案/许可证号：沪ICP备14048035号-2</a></p>
        </div>

        <!--大黑罩子-->
        <div id="J_mask" class="sec-bg-full hidden">
        </div>
        <!--浮层-->
        <div class="box_popup sec-pop hidden" style="background-color: #fff; margin: 0" id="J_risk">
            <a href="javascript:;" class="btn_close">× </a>

            <div class="box_risk">
                <h3>
                    您的账号存在风险，暂时无法登录
                </h3>

                <div class="box_button">
                    <input type="button" class="btn" value="知道了">
                </div>
            </div>
        </div>
    </div>

</div>
</body>
</html>