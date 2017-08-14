<%-- 
    Title:品种产品目录报表
    author:xhy

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="page-content detail-page">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>角色详细信息</label>
        </h3>
        <form:form action="${ctx}/TSC50002/add" id="TSC50002Form"
                   method="post">
            <table width="100%">
                <tr>
                    <td width="15%" align="right">角色:</td>
                    <td><input type="text" name="classestreeName3" value="采购员"
                                disabled/></td>
                </tr>
                <tr>
                    <td width="15%" align="right">账号:</td>
                    <td><input type="text" name="classestreeName3" value="CG001"
                               id="classestreeName3" disabled/></td>
                </tr>
                <tr>
                    <td width="15%" align="right">用户名称:</td>
                    <td><input type="text" name="classestreeName3" value="张玉"
                               id="classestreeName4" disabled/></td>
                </tr>
                <tr>
                    <td width="15%" align="right">密码:</td>
                    <td><input type="text" name="classestreeName3" value="542354"
                               disabled/></td>
                </tr>
            </table>
        </form:form>
    </div>
    <div>
      <%--  <msk:button buttonValue="保存" buttonId="TSC50002.SAVE" buttonType="button"/>--%>
    </div>
</div>

<script src="${ctx}/js/ds/TSC50002.js"></script>
