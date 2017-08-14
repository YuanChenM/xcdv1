<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<navigation:header title="需求数量设置" backTitleArray="需求数量设置" backUrlArray="${ctx}/SP171103/init"></navigation:header>
<div class="page-content list-page">
    <form:form action="${ctx}/SP171103/search" id="SP171103Form" metdod="post">
        <table id="SP171103_Grid">
            <thead>
            <tr>
                <th coltype="text" name="pdName" filter="true">产品名称</th>
                <th coltype="text" name="pdCode" filter="true">产品编码</th>
                <th coltype="text" name="pdBreed">产品品种</th>
                <th coltype="text" name="pdFeature">产品特征</th>
                <th coltype="text" name="pdWeight">净重</th>
                <th coltype="text" name="pdPackage">包装编码</th>
                <th coltype="text" name="needNum" edit="true">需求总量</th>
                <th coltype="text" name="isBid">是否投标</th>
                <th coltype="action" width="10px">操作
                    <input type="button" id="editBtn" hidden="true" title="分配" coltype="edit" class="h-button" />
                </th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
    </form:form>

    <msk:button buttonValue="发布需求" buttonId="SP171103.SAVE" buttonType="button" />
    <msk:button buttonValue="返回" buttonId="SP171103.BACK" buttonType="button" url="${ctx}/SP171102/init" />
</div>
<script type="text/javascript" src="${ctx}/js/sp/SP171103.js"></script>

