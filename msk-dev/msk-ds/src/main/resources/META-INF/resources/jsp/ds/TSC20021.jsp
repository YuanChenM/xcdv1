<%-- 
    Title:发货计划列表
    author:gyh
    createDate:2016-6-14
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="订单发货确认单管理" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC20021/search" method="post">
        <table id="TSC20021_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <th coltype="sno" width="10%">ID</th>
                <th coltype="text" width="10%" name="info1" filter="true">发货计划编号</th>
                <th coltype="text" width="10%" name="contractNumber" filter="true">合同编号</th>
                <th coltype="text" width="30%" name="contractName" filter="true">合同名称</th>
                <th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>
                <th coltype="text" width="20%" name="contractDate">发货时间要求</th>
                <th coltype="select" align="center" name="info2">发货负责人</th>
                <th coltype="text" width="20%" name="info3">运输负责人</th>
                <th coltype="text" width="20%" name="info4">运抵仓库</th>
                <th coltype="action">发货计划详细
                    <input type="hidden" coltype="detail" title="发货计划详细" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <div><msk:button buttonValue="新建" buttonId="TSC20021.SAVE" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC20021.js"></script>
