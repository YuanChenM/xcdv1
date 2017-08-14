<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<navigation:header title="磋商分配" backTitleArray="磋商分配" backUrlArray="${ctx}/SP171104/init"></navigation:header>
<div class="page-content list-page">

    <table>
        <tr>
            <td>产品:</td>
            <td>盐水鸭</td>
        </tr>
        <tr>
            <td>总需求量:</td>
            <td>2000</td>
        </tr>
    </table>
    <br>

    <form:form action="${ctx}/SP171104/search" id="SP171104Form" metdod="post">
        <table id="SP171104_Grid">
            <thead>
            <tr>
                <th coltype="text" name="companyId">企业ID</th>
                <th coltype="text" name="companyCode" filter="true">企业编号</th>
                <th coltype="text" name="companyName" filter="true">企业名称</th>
                <th coltype="text" name="account" filter="true">账号</th>
                <th coltype="text" name="showName" filter="true">名称</th>
                <th coltype="text" name="mobilePhone" filter="true">手机号码</th>
                <th coltype="text" name="allotNum" edit="true">分配量</th>
                <th coltype="text" name="declareNum">申报量</th>
                <th coltype="action" width="10px">历史磋商
                    <input type="button" id="editBtn" hidden="true" title="查看" coltype="edit" class="h-button" />
                </th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
    </form:form>

    <msk:button buttonValue="保存分配" buttonId="SP171103.SAVE" buttonType="button" />
    <msk:button buttonValue="确认需求" buttonId="SP171103.CONFIRM" buttonType="button" />
    <msk:button buttonValue="返回" buttonId="SP171103.BACK" buttonType="button" url="${ctx}/SP171103/init" />
</div>
<script type="text/javascript" src="${ctx}/js/sp/SP171104.js"></script>

