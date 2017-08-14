<%-- 
    Title:品种产品目录报表
    author:xhy

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<style type="text/css">
    td.text{
        text-align: center;
    }
    table.dataTable td.action{
        text-align: center;
    }
    td.select{
        text-align: center;
    }
</style>
<%--<c:if test="${admin eq '1'}">--%>
    <navigation:header title="结算计划一览" backTitleArray="结算管理" backUrlArray="${ctx}/TSC30001/init"></navigation:header>
<%--</c:if>--%>
<div class="page-content list-page">
    <form action="${ctx}/TSC30002/search" method="post">
        <table id="TSC30002_list_grid" showAddBtn="true" >
            <thead>
            <tr>
                <th coltype="text" width="7%" name="jsNumber" filter="true">结算次数</th>
                <th coltype="text" width="17%" name="moneyAll" filter="true">合同金额</th>
                <th coltype="text" width="17%" name="percentage" filter="true">结算比例</th>
                <th coltype="text" width="17%" name="practicalMoney" filter="true">实际付款金额</th>
                <th coltype="select" width="17%" name="stateHt" filter="true">状态
                <select>
                    <option>已付</option>
                    <option>待付</option>
                    <option>取消</option>
                </select>
                </th>
                <th coltype="action">
                    <input type="hidden"coltype="edit" title="更新" class="h-button" />
                    <input type="hidden" coltype="search" title="附件查看"  class="h-button" />
                    <input type="button" id="deleteBtn" hidden="true" title="删除" coltype="delete" class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <table><tr align="left"><msk:button buttonValue="新建" buttonId="TSC30002.NEW" buttonType="button"/></tr><tr align="left"><msk:button buttonValue="模板下载" buttonId="TSC30002.DOWLOAD" buttonType="button"/></tr></table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC30002.js"></script>
