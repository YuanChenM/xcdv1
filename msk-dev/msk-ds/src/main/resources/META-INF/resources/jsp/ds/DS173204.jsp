<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <text>在途产品汇总通知单</text>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173204/search" method="post">
        <table id="DS173204_Grid">
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
                <th coltype="text" name="productOnWayQty_1">当月26-月末<br/>在途产品库库存汇总量</th>
                <th coltype="text" name="productOnWayQty_2">下月01-05号<br/>在途产品库库存汇总量</th>
                <th coltype="text" name="productOnWayQty_3">下月06-10号<br/>在途产品库库存汇总量</th>
                <th coltype="text" name="productOnWayQty_4">下月11-15号<br/>在途产品库库存汇总量</th>
                <th coltype="text" name="productOnWayQty_5">下月16-20号<br/>在途产品库库存汇总量</th>
                <th coltype="text" name="productOnWayQty_6">下月21-25号<br/>在途产品库库存汇总量</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173204.js"></script>

