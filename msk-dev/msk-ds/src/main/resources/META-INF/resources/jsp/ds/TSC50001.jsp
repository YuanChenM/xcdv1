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
<navigation:header title="采购员仓库员一览" backTitleArray="" backUrlArray=""></navigation:header>
<%--<div class="group-accordion" collapsible="false" active="false" id="TSC50001accordion"
     style=" width:auto;overflow:auto; ">--%>
<div class="page-content list-page">
    <form action="${ctx}/TSC50001/search" method="post">
        <table id="TSC50001_list_grid" showAddBtn="true">
            <thead>
            <tr>
                <th coltype="text" width="15" name="id" filter="true">ID</th>
                <th coltype="text" width="17%" name="role" filter="true">员工角色</th>
                <th coltype="text" width="17%" name="account" filter="true">账号</th>
                <th coltype="text" width="17%" name="pepName" filter="true">名称(用户名)</th>
                <th coltype="action">详细
                    <input type="hidden" coltype="search" title="详细"  class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
      <%--  <table><tr align="left"><msk:button buttonValue="新建" buttonId="TSC20031.NEW" buttonType="button"/>--%>
    </form>
</div>
<script src="${ctx}/js/ds/TSC50001.js"></script>
