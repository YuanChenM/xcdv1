<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <text>入库汇总通知单</text>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173211/search" method="post">
        <table id="DS173211_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px" align="center">编号</th>
                <th coltype="text" name="productName" align="center" filter="true">产品名称</th>
                <th coltype="text" name="productCode" align="center" filter="true">产品编码</th>
                <th coltype="text" name="productTypeName" align="center" filter="true">产品品种</th>
                <th coltype="text" name="productFeature" align="center" filter="true">产品特征</th>
                <th coltype="text" name="productLevel" align="center" filter="true">产品等级</th>
                <th coltype="text" name="productSpecifical" align="center" filter="true">外包装规格</th>
                <th coltype="text" name="netWeight" align="center" filter="true">净重</th>
                <th coltype="text" name="packageCode" align="center" filter="true">包装编码</th>
                <th coltype="text" name="productStorageQty_1">1-5号入库汇总量</th>
                <th coltype="text" name="productStorageQty_2">6-10号入库汇总量</th>
                <th coltype="text" name="productStorageQty_3">11-15号入库汇总量</th>
                <th coltype="text" name="productStorageQty_4">16-20号入库汇总量</th>
                <th coltype="text" name="productStorageQty_5">21-25号入库汇总量</th>
                <th coltype="text" name="productStorageQty_6">26-月底入库汇总量</th>
                <th coltype="text" name="sumProductStorageQty">本期合计入库汇总量</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173211.js"></script>

