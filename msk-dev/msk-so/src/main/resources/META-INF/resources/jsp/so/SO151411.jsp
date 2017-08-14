<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:申请退货页面
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="${ctx}/static/core/js/jquery.PrintArea.js" ></script>
<input type="hidden" id="orderId" value="${orderId}">
<input type="hidden" id="listSize" value="${so151411Beans.size()}">
<style>
    html { overflow-x:hidden; }
</style>
<div class="page-content list-page">
    <form action="${ctx}/SO151411/save" method="post" id="SO151411Form">
    <div id="baseorder"></div>
        <div>
            <div class="group-accordion" active="true">
                <h3>
                    <label>供货详细</label>
                </h3>
                <div>
                <table class="tree dataTable no-footer" id = "detailTable" style="width: 100%">
                <tr style="background:#DBDBDB">
                <td width="10%">供应商编号</td>
                <td width="20%">供应商名称</td>
                <td width="10%">产品编码</td>
                <td width="20%">产品名称</td>
                <td width="5%">产品等级</td>
                <td width="5%">单价(元/箱)</td>
                <td width="5%">供货数量</td>
                <td width="5%">发货数量</td>
                <td width="5%">收货数量</td>
                <td width="5%">已退货数量</td>
                <td width="5%">本次退货数量</td>
                <td width="5%">状态</td>
                </tr>
            <c:forEach items="${so151411Beans}" var="so151411Bean" varStatus="varStatus">
                <tr>
                    <td>${so151411Bean.supplierCodeShow}</td>
                    <td>${so151411Bean.supplierName}</td>
                    <td>${so151411Bean.pdCode}</td>
                    <td>${so151411Bean.pdName}</td>
                    <td>${so151411Bean.pdGradeName}</td>
                    <td align="right">${so151411Bean.pdPrice}</td>
                    <td align="right">${so151411Bean.suppQty}</td>
                    <td align="right">${so151411Bean.sendQty}</td>
                    <td align="right">${so151411Bean.receiveQty}</td>
                    <td align="right">${so151411Bean.returnedQty}</td>
                    <td align="right"><input type="text" style="text-align:right " id="returnQty${varStatus.index}" onchange="changeReturnQty(${varStatus.index})" maxlength="21" value="${so151411Bean.returnQty}"></td>
                    <td>${so151411Bean.statusName}</td>
                    <input type="hidden" id="receiveQty${varStatus.index}" value="${so151411Bean.receiveQty}">
                    <input type="hidden" id="returnedQty${varStatus.index}" value="${so151411Bean.returnedQty}">
                    <input type="hidden" id="orderDetailAvailabilityId${varStatus.index}" value="${so151411Bean.orderDetailAvailabilityId}">
                    <input type="hidden" id="pdCode${varStatus.index}" value="${so151411Bean.pdCode}">
                    <input type="hidden" id="lgcsCode${varStatus.index}" value="${so151411Bean.lgcsCode}">
                    <input type="hidden" id="supplierCode${varStatus.index}" value="${so151411Bean.supplierCode}">
                    <input type="hidden" id="sellerCode${varStatus.index}" value="${so151411Bean.sellerCode}">
                    <input type="hidden" id="orderType${varStatus.index}" value="${so151411Bean.orderType}">
                    <input type="hidden" id="pdPrice${varStatus.index}" value="${so151411Bean.pdPrice}">
                </tr>
            </c:forEach>
        </table>
                </div>
            </div>
     </div>
    </form>
    <table>
        <tr>
            <c:if test="${allReturn eq false}">
                <td><msk:button buttonValue="申请退货" buttonId="SO151411.RETURN" buttonType="button"/></td>
            </c:if>
        </tr>
    </table>
</div>
<script src="${ctx}/static/so/js/SO151411.js"></script>
