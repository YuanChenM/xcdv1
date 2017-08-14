<%-- 
    Title:入库单一览
    author:gyh
    createDate:2016-6-12
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<navigation:header title="生产商入库单管理" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC20041/search" method="post">
        <table id="TSC20041_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <th coltype="sno">ID</th>
                <th coltype="text" name="info2" filter="true">入库单编号</th>
                <th coltype="text" name="info3" filter="true">供应商</th>
                <th coltype="text" name="info4">计划到货日期</th>
                <th coltype="text" name="info5">调入单位</th>
                <th coltype="text" name="info6">仓库地址</th>
                <th coltype="select" width="15%" align="center" name="info7" filter="true">入库方式
                    <select>
                        <option>采购入库</option>
                        <option>调拨入库</option>
                        <option>样品入库</option>
                        <option>退货入库</option>
                    </select>
                </th>
                <th coltype="text" name="info8" filter="true">合同编号</th>
                <th coltype="text" name="info9" filter="true">合同名称</th>
                <th coltype="text" name="info10" filter="true">发货单编号</th>
                <th coltype="action">详情
                    <input type="hidden" coltype="detail" title="入库单详细" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <div><msk:button buttonValue="新建" buttonId="TSC20041.NEW" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC20041.js"></script>
