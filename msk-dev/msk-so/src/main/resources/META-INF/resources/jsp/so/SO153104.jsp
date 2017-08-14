<%--
    Title:买家-电子对账单-支出
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="${ctx}/static/js/core/ichart.1.2.min.js"></script>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css"/>
<navigation:header title="买家电子账单" backTitleArray="" backUrlArray="${ctx}"></navigation:header>
<div class="page-content list-page">
    <div id="tabs" class="page-content list-page">
            <ul>
                <li><a href="#tabs-1">电子对账单-支出</a></li>
                <li><a href="#tabs-2">电子对账单-收入</a></li>
            </ul>
            <div id="tabs-1">
                <div id='canvasDiv' style="float:left;width:40%"></div>
                <div style="float:right;width:48%;">
                    <table class="tree dataTable no-footer">
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>金额</th>
                            <th>消费比例</th>
                            <th>备注</th>
                        </tr>
                        </thead>
                        <tbody id ="detailInfo">
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="tabs-2">
                <div id='income' style="float:left;width:40%"></div>
                    <div style="float:right;width:48%;">
                        <table class="tree dataTable no-footer">
                            <thead>
                            <tr style="background:#DBDBDB">
                                <td>名称</td>
                                <td>金额</td>
                                <td>消费比例</td>
                                <td>备注</td>
                            </tr>
                            </thead>
                            <tbody id ="detailInfo1">
                            </tbody>
                        </table>
                    </div>
            </div>
    </div>
</div>
<script src="${ctx}/js/so/SO153104.js"></script>
