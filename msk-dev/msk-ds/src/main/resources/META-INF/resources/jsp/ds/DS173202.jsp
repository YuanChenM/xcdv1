<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <text>二期神农客卖家中标产品计划生产汇总通知单</text>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173202/search" method="post">
        <table id="DS173202_Grid">
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
                <th colspan="3" align="center" >当月21-25号</th>
                <th colspan="3" align="center" >当月26-月末</th>
                <th colspan="3" align="center" >下月01-05号</th>
                <th colspan="3" align="center" >下月06-10号</th>
                <th colspan="3" align="center" >下月11-15号</th>
                <th colspan="3" align="center" >下月16-20号</th>
                <th colspan="3" align="center" >下月21-25号</th>
                <th colspan="3" align="center" >下月26-月末</th>
            </tr>
            <tr>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
                <th align="center" coltype="text"  name="productCode">平台自动生成的计划生产量</th>
                <th align="center" coltype="text"  name="productCode">卖家确认的生产量</th>
                <th align="center" coltype="text"  name="productCode">实际生产完成转待运库的库存量</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173202.js"></script>

