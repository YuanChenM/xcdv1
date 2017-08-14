<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <text>卖家产品月度通知单管控一览</text>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173201/search" method="post">
        <table id="DS173201_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="areaName">区域</th>
                <th coltype="text" name="sellerName">卖家</th>
                <th coltype="text" name="distMonth">月度</th>
                <th coltype="action" width="10px">
                    <input type="button" id="productDetailBtn" hidden="true" title="计划生产汇总通知单" coltype="detail" class="h-button"/>计划生产汇总通知单
                </th>
                <th coltype="action" width="10px">
                    <input type="button" id="waitDetailBtn" hidden="true" title="待运库库存汇总通知单" coltype="detail" class="h-button"/>待运库库存汇总通知单
                </th>
                <th coltype="action" width="10px">
                    <input type="button" id="onWayBtn" hidden="true" title="在途产品库库存汇总通知单" coltype="detail" class="h-button"/>在途产品库库存汇总通知单
                </th>
                <th coltype="action" width="10px">
                    <input type="button" id="storageBtn" hidden="true" title="入库汇总通知单" coltype="detail" class="h-button"/>入库汇总通知单
                </th>
                <th coltype="action" width="10px">
                    <input type="button" id="createCodeBtn" hidden="true" title="批次编码生成打印单生成" coltype="repair" class="h-button"/>批次编码生成打印单生成
                </th>
                <th coltype="action" width="10px">
                    <input type="button" id="detailBtn" hidden="true" title="发货入库通知单" coltype="product" class="h-button"/>发货入库通知单
                </th>
                <th coltype="action" width="30px">
                    <input type="button" id="mainPlanBtn" hidden="true" title="总计划供应量在线变更汇总通知单画面" coltype="detail" class="h-button"/>总计划供应量在线变更汇总通知单画面
                </th>
                <th coltype="action" width="10px">
                    <input type="button" id="manageBtn" hidden="true" title="卖家供应链库存在线管理表画面" coltype="repair" class="h-button"/>卖家供应链库存在线管理表画面
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173201.js"></script>

