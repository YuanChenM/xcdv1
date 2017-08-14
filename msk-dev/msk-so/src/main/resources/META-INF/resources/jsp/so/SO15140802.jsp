<%--
  Created by IntelliJ IDEA.
  User: jiangnan
  Date: 16/1/26
  Time: 下午3:35
  To chang e this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="page-content list-page">
    <form action="${ctx}/SO15140801/search2" id="SO15140801Form" method="post">
        <input type="hidden" name="lgcsCode" value="${productStock.lgcsCode}"/>
        <input type="hidden" name="slCode" value="${productStock.slCode}"/>
        <input type="hidden" id="salePlatform" name="salePlatform" value="${productStock.salePlatform}"/>
        <input type="hidden" name="supplyPlatform" value="${productStock.salePlatform}"/>
        <input type="hidden" id="pricecycleId" name="pricecycleId" value="${productStock.pricecycleId}"/>

        <table id="SO151408Grid">
            <thead>
                <tr>
                    <th coltype="checkbox"></th>
                    <c:if test="${isSupp}">
                        <th coltype="text" filter="true" name="supplierCode">供应商编码</th>
                        <th coltype="text" filter="true" name="supplierName">供应商名称</th>
                    </c:if>
                    <th coltype="text" filter="true" name="classesName">产品分类</th>
                    <th coltype="text" filter="true" name="breedName">产品品种</th>
                    <th coltype="text" filter="true" name="featureName">产品包装</th>
                    <th coltype="text" filter="true" name="unit">产品单位</th>
                    <th coltype="text" filter="true" name="pdCode">产品编码</th>
                    <th coltype="text" filter="true" name="pdName">产品名称</th>
                    <th coltype="number" edit="true" name="activeQty">下单数量</th>
                    <th coltype="number" name="price">产品价格(元)</th>
                    <th coltype="number" name="priceCyclePeriod">价盘周期</th>
                    <th coltype="number" name="orderLevelName">订单级别</th>
                    <th coltype="text" filter="true" name="lgcsName">销售区域</th>
                    <th coltype="action"></th>
                    <th style="display: none"  name="normsOut">包装规格</th>
                    <th style="display: none"  name="packingVolume">单箱体积</th>
                    <th style="display: none"  name="netWeightOut">净重</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <msk:button buttonType="button" buttonId="SO15140801.CONFIRM" buttonValue="确认"/>
</div>

<script src="${ctx}/static/so/js/SO15140802.js"></script>