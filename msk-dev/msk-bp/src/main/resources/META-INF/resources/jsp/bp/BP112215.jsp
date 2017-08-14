<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<style>
    td.details-control {
        background: url('${ctx}/static/core/images/action/details_open.png') no-repeat center center;
        cursor: pointer;
    }
    tr.details td.details-control {
        background: url('${ctx}/static/core/images/action/details_close.png') no-repeat center center;
    }
</style>
<navigation:header title="价盘平台查看" backTitleArray="价盘平台查看" backUrlArray="${ctx}/BP112215/init"></navigation:header>
<div class="page-content list-page">
    <form:form action="${ctx}/BP112215/search" id="BP112215Form" metdod="post">
        <table id="BP112215_Grid">
            <thead>
            <tr>
                <th coltype="text" align="center" width="10px"></th>
                <th coltype="sno" name="pricecycleId">序号</th>
                <th coltype="text" name="pricecyclePeriod" filter="true">价盘半旬</th>
                <th coltype="text" name="logiareaName" filter="true">区域</th>
                <th coltype="text" name="slName" filter="true">供应商</th>
                <th coltype="text" name="pdName" filter="true">品名</th>
                <th coltype="text" name="machining">配料</th>
                <th coltype="text" name="featureName">规格</th>
                <th coltype="text" name="netweight">净重(kg/箱)</th>
                <th coltype="text" name="pdGrade">产品等级</th>
                <th coltype="text" name="stockNum">箱数</th>
                <%--<th coltype="text" name="priceofkg" filter="true">报价</th>
                <th coltype="text" name="discount" filter="true">折扣率</th>--%>
                <th coltype="action" width="10px">操作</th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
    </form:form>
</div>
<script type="text/javascript" src="${ctx}/js/bp/BP112215.js"></script>

