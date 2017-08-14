
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-content list-page">
    <form id="resetAccountFrom" method="post">
        <table id="ResetAccountPwd_Grid">
            <input type="hidden" id="buyerId" name="buyerId" value="${buyerId}">
            <thead>
            <tr>
                <td width="60%" style="text-align: right;padding-right: 20px;">手机号:</td>
                <td><input name="telNo" id="telNewNo" value="${telNo}"></td>
            </tr>
            <tr>
                <td style="text-align: right;padding-right: 20px;">账号:</td>
                <td><input name="accountName" id="accountNewName"  value="${accountName}" onblur="ResetAccountPwd.changePassWord();"></td>
            </tr>
            <tr>
                <td style="text-align: right;padding-right: 20px;">密码:</td>
                <td><input name="accountPass" id="accountNewPass"  value="${accountPass}"></td>
            </tr>
            <tr>
                <td  style="text-align: right;">
                    <msk:button buttonValue="重置" buttonId="Account.Reset" buttonType="button"/>
                </td>
                <td  style="text-align: left;padding-left: 25px;">
                    <msk:button buttonValue="取消" buttonId="Account.Cancel" buttonType="button"/>
                </td>
            </tr>
            </thead>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/by/comm/ResetAccountPwd.js"></script>
