<%-- 
    Title:卖家-电子对账单-支出
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<navigation:header title="卖家-电子对账单" backTitleArray="资金池管理" backUrlArray="${ctx}"></navigation:header>
<div class="page-content list-page">
    <div id="SO153205Id"></div>
    <div class="group-accordion" active="true">
        <h3>
            <label>卖家-电子对账单-支出</label>
        </h3>

        <div>
            <table class="tree dataTable no-footer" style="width: 100%">
                <tr style="background:#DBDBDB">
                    <td>名称</td>
                    <td>金额</td>
                    <td>备注</td>
                </tr>
                <c:forEach items="${list}" var="list" varStatus="j">
                    <tr class="treegrid-${j.index}">
                        <td name="listName" value="${list.name}">${list.name}</td>
                        <td>${list.price}</td>
                        <td>${list.remarks}</td>
                    </tr>
                    <c:if test="${list.sO153204InfoBean.size() gt 0}">
                        <c:forEach items="${list.sO153204InfoBean}" var="sO153204InfoBean" varStatus="i">
                            <tr class="treegrid-${j.index}-${i.index+1} treegrid-parent-${j.index}">
                                <td name="sO153204InfoBeanName" value="${sO153204InfoBean.name}">${sO153204InfoBean.name}</td>
                                <td>${sO153204InfoBean.price}</td>
                                <td>${sO153204InfoBean.remarks}</td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<script src="${ctx}/js/so/SO153204.js"></script>
