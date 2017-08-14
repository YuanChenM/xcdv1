<%-- 
    Title:合同列表
    author:gyh
    createDate:2016-6-8
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<c:if test="${type eq '1'}">
    <navigation:header title="生产期计划管理" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<c:if test="${type eq '2'}">
    <navigation:header title="待运期计划管理" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<div class="page-content list-page" id="pageId">
    <form action="${ctx}/TSC10004/search" method="post">
        <table id="TSC10004_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <th coltype="sno" width="10%">ID</th>
                <th coltype="text" width="10%" name="contractNumber" filter="true">合同编号</th>
                <th coltype="text" width="30%" name="contractName" filter="true">合同名称</th>
                <th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>
                <th coltype="text" width="20%" name="contractDate">合同生效日期</th>
                <th coltype="select" align="center" name="status" filter="true">　　状态　　
                    <select>
                        <option value="0">未核销</option>
                        <option value="1">已核销</option>
                    </select>
                </th>
                <c:if test="${type eq '1'}">
                    <th coltype="action">生产计划管理
                        <input type="hidden" coltype="modifyEOLToEOS" title="生产管理" class="h-button"/>
                    </th>
                </c:if>
                <c:if test="${type eq '2'}">
                    <th coltype="action">待运计划管理
                        <input type="hidden" coltype="revoke" title="生产管理" class="h-button"/>
                    </th>
                </c:if>
                <c:if test="${type eq '3'}">
                    <th coltype="action">交货计划管理
                        <input type="hidden" coltype="return" title="生产管理" class="h-button"/>
                    </th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC20001.js"></script>
