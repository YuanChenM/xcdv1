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
<navigation:header title="结算管理" backTitleArray="" backUrlArray=""></navigation:header>
<%--<div class="group-accordion" collapsible="false" active="false" id="tsc30001accordion"
     style=" width:auto;overflow:auto; ">--%>
<div class="page-content list-page">
    <form action="${ctx}/TSC30001/search" method="post">
        <table id="TSC30001_list_grid" showAddBtn="true">
            <thead>
            <tr>
                <th coltype="sno" width="7%" name="jsCode" filter="false">ID</th>
                <th coltype="text" width="17%" name="bargainCode" filter="true">合同编号</th>
                <th coltype="text" width="17%" name="bargainName" filter="true">合同名称</th>
                <th coltype="text" width="17%" name="plantName">厂商</th>
                <th coltype="text" width="17%" name="effectTime" filter="true">合同生效时间</th>
                <th coltype="select" width="17%" name="stateHt" filter="true">状态
                <select>
                    <option>未核销</option>
                    <option>已核销</option>
                </select>
                </th>
                <th coltype="action">
                    <input type="hidden" coltype="search" title="查看结算计划"  class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <table><tr align="left"><msk:button buttonValue="新建" buttonId="TSC20031.NEW" buttonType="button"/>
    </form>
</div>
<script src="${ctx}/js/ds/TSC30001.js"></script>
