<%-- 
    Title:卖家列表
    author:gyh
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<navigation:header title="发货单一览" backTitleArray="合同一览" backUrlArray="${ctx}/TSC20031/init"></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC20032/search" method="post">
        <table id="TSC20032_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <th coltype="sno" width="10%">ID</th>
                <th coltype="text" width="20%" name="orderNumber" filter="true">发货单编号</th>
                <th coltype="text" width="30%" name="orderDate" filter="true">发货单日期</th>
                <th coltype="text" width="30%" name="production" filter="true">生产商</th>
                <th coltype="text" width="30%" name="address" filter="true">仓库地址</th>
                <th coltype="action" width="20%">发货单明细
                    <input type="hidden" value="发货单明细" coltype="detail" title="发货单明细"  class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <table><tr align="left"><msk:button buttonValue="新建" buttonId="TSC20032.NEW" buttonType="button"/></tr></table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC20032.js"></script>
