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
<navigation:header title="" backTitleArray="供应商一览" backUrlArray=""></navigation:header>
<%--<div class="group-accordion" collapsible="false" active="false" id="tsc30001accordion"
     style=" width:auto;overflow:auto; ">--%>
<div class="page-content list-page">
    <form action="${ctx}/TSC40001/search" method="post">
        <table id="TSC40001_list_grid" showAddBtn="true">
            <thead>
            <tr>
                <th coltype="text" width="14%" name="producerCode" filter="true">供应商编码</th>
                <th coltype="text" width="17%" name="producerName" filter="true">供应商名称</th>
                <th coltype="text" width="17%" name="contactsName" filter="true">联系人</th>
                <th coltype="text" width="17%" name="contactsPhone"filter="true">联系电话</th>
                <th coltype="text" width="17%" name="region" filter="true">地址</th>
                <th coltype="action">详细
                    <input type="hidden" coltype="search" title="详细"  class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <table><tr align="left"><msk:button buttonValue="新建" buttonId="TSC40001.NEW" buttonType="button"/>
    </form>
</div>
<script src="${ctx}/js/ds/TSC40001.js"></script>
