<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="group-accordion" active="false">
    <h3>
        <label>卖家账号信息</label>
    </h3>
    <form:form action="${ctx}/SL24110101/update" id="SL24110101Form"
               metdod="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">卖家账号</td>
                <td align="left" width="50%">
                    <input type="text" id="slAccount" name="slAccount" value="${slAccount.slAccount}" readonly="readonly"/>
                    <span id="account_sp"></span>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">密码</td>
                <td align="left" width="50%">
                    <input type="text" id="accountPsd" name="accountPsd" value="${slAccount.accountPsd}"/>
                    <span id="pwd_sp"></span>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">用户名</td>
                <td align="left" width="50%">
                    <input type="text" id="slContact" name="slContact" value="${slAccount.slContact}"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">手机号</td>
                <td align="left" width="50%">
                    <input type="text" id="slTel" name="slTel" value="${slAccount.slTel}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">卖家头像图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL24110101.SAVE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL24110101.js"></script>
