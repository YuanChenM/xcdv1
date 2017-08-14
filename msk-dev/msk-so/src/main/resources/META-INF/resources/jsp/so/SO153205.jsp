<%-- 
    Title:卖家-电子对账单-收入
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<div class="group-accordion" active="true">
    <h3>
        <label>卖家-电子对账单-收入</label>
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
                <c:if test="${list.sO153205InfoBean.size() gt 0}">
                    <c:forEach items="${list.sO153205InfoBean}" var="sO153205InfoBean" varStatus="i">
                        <tr class="treegrid-${j.index}-${i.index+1} treegrid-parent-${j.index}">
                            <td name="sO153205InfoBeanName"
                                value="${sO153205InfoBean.name}">${sO153205InfoBean.name}</td>
                            <td>${sO153205InfoBean.price}</td>
                            <td>${sO153205InfoBean.remarks}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </table>
    </div>
</div>

<script src="${ctx}/js/so/SO153205.js"></script>