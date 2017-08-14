<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <text>待运产品汇总通知单</text>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173203/search" method="post">
        <table id="DS173203_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px" rowspan="2" align="center">编号</th>
                <th coltype="text" name="productName" rowspan="2" align="center" filter="true">产品名称</th>
                <th coltype="text" name="productCode" rowspan="2" align="center" filter="true">产品编码</th>
                <th coltype="text" name="productTypeName" rowspan="2" align="center" filter="true">产品品种</th>
                <th coltype="text" name="productFeature" rowspan="2" align="center" filter="true">产品特征</th>
                <th coltype="text" name="productLevel" rowspan="2" align="center" filter="true">产品等级</th>
                <th coltype="text" name="productSpecifical" rowspan="2" align="center" filter="true">外包装规格</th>
                <th coltype="text" name="netWeight" rowspan="2" align="center" filter="true">净重</th>
                <th coltype="text" name="packageCode" rowspan="2" align="center" filter="true">包装编码</th>
                <th colspan="4" align="center" >当月26-月末</th>
                <th colspan="4" align="center" >下月01-05号</th>
                <th colspan="4" align="center" >下月06-10号</th>
                <th colspan="4" align="center" >下月11-15号</th>
                <th colspan="4" align="center" >下月16-20号</th>
                <th colspan="4" align="center" >下月21-25号</th>
            </tr>
            <tr>
                <th coltype="text" align="center"  name="productCode">本期期初库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际生产完成转待运库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际转在途产品库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期末库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期初库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际生产完成转待运库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际转在途产品库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期末库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期初库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际生产完成转待运库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际转在途产品库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期末库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期初库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际生产完成转待运库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际转在途产品库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期末库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期初库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际生产完成转待运库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际转在途产品库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期末库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期初库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际生产完成转待运库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期实际转在途产品库的库存量</th>
                <th coltype="text" align="center"  name="productCode">本期期末库存量</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173203.js"></script>

