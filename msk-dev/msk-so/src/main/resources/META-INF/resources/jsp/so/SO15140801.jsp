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
    <form action="${ctx}/SO15140801/search" id="SO15140801Form" method="post">
        <input type="hidden" name="lgcsCode" value="${productStock.lgcsCode}"/>
        <input type="hidden" name="slCode" value="${productStock.slCode}"/>
        <input type="hidden" id="salePlatform" name="salePlatform" value="${productStock.salePlatform}"/>
        <input type="hidden" name="supplyPlatform" value="${productStock.salePlatform}"/>

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
                    <th coltype="text" filter="true" name="pdCode">产品编码</th>
                    <th coltype="text" name="pdName">产品名称</th>
                    <th coltype="number" edit="true" name="activeQty">下单数量(箱)</th>
                    <th coltype="number" edit="true" name="price">产品价格(元/箱)</th>
                    <th coltype="text" filter="true" name="lgcsName">销售区域</th>
                    <th coltype="text" name="invQty">可售库存</th>
                    <th coltype="action"></th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <msk:button buttonType="button" buttonId="SO15140801.CONFIRM" buttonValue="确认"/>
</div>

<script src="${ctx}/static/so/js/SO15140801.js"></script>