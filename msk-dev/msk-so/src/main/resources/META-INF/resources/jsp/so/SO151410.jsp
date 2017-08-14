<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:订单发货详细信息页面
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="${ctx}/static/core/js/jquery.PrintArea.js" ></script>
<input type="hidden" id="orderId" value="${orderId}">
<style>
    html { overflow-x:hidden; }
</style>
<div class="page-content list-page">
    <div id="baseorder"></div>
    <div id="orderbuyers"></div>
    <div id="basedelivery"></div>
    <div id="logisticsDetail"></div>
        <div id="orderDetail"> 
            <div class="group-accordion" active="true">
                <h3>
                    <label>发货单详细</label>
                </h3>
                <div>
                <table class="tree dataTable no-footer" id = "detailTable" style="width: 100%">
                <tr style="background:#DBDBDB">
                <td width="6.5%">发货单ID</td>
                    <td width="6.5%">预计发货时间</td>
                    <td width="6.5%">预计到货时间</td>
                <td width="6.5%">收货人名称</td>
                <td width="6.5%">收货人电话</td>
                <td width="6.5%">收货地址省</td>
                <td width="6.5%">收货地址市</td>
                <td width="6.5%">收货地址区</td>
                <td width="8.5%">收货地址详细地址</td>
                <td width="8.5%">辅助地址项目</td>
                <td width="10%">收货人详细地址管理Key</td>
                <td width="6.5%">付款类型</td>
                <td width="8%">配送方式</td>
                <td width="4%">发货单状态</td>
                <td width="2.5%">操作</td>
            </tr>
            <c:forEach items="${so151410Beans}" var="so151410Bean" varStatus="i">
                <tr class="treegrid-${so151410Bean.shipId}">
                    <td>${so151410Bean.shipId}</td>
                    <td>${so151410Bean.forecastSendTimeStr}</td>
                    <td>${so151410Bean.forecastReceiveTimeStr}</td>
                    <td>${so151410Bean.receiverName}</td>
                    <td>${so151410Bean.receiverTel}</td>
                    <td>${so151410Bean.receiverProvince}</td>
                    <td>${so151410Bean.receiverCity}</td>
                    <td>${so151410Bean.receiverDistrict}</td>
                    <td>${so151410Bean.receiverAddr}</td>
                    <td>${so151410Bean.receiverAddr2}</td>
                    <td>${so151410Bean.receiverAddrKey}</td>
                    <td>${so151410Bean.paymentTypeName}</td>
                    <td>${so151410Bean.deliveryTypeName}</td>
                    <td>${so151410Bean.shipStatusName}</td>
                    <td>
                        <msk:roleArea pageCode="SO151410" areaCode="CANCEL" needAuth="true">
                            <c:if test="${so151410Bean.canCancelQty eq 0}">
                                <img alt="取消" name="shipInfo" shipId="${so151410Bean.shipId}" src="${ctx}/static/core/images/action/close.png" title="取消">
                            </c:if>
                        </msk:roleArea>
                    </td>
                </tr>
                <c:if test="${so151410Bean.soOrderDetailAvailabilities.size() gt 0}">
                    <tr class="treegrid-${so151410Bean.shipId}-${i.index} treegrid-parent-${so151410Bean.shipId}" style="background:#DBDBDB">
                        <td>供应商编号</td>
                        <td colspan="3">供应商名称</td>
                        <td>产品编码</td>
                        <td colspan="2">产品名称</td>
                        <td>产品等级</td>
                        <td>供货数量</td>
                        <td>发货数量</td>
                        <td>收货数量</td>
                        <td>取消数量</td>
                        <td>退货数量</td>
                        <td>拒收数量</td>
                        <td></td>
                    </tr>
                    <c:forEach items="${so151410Bean.soOrderDetailAvailabilities}" var="soOrderDetailAvailabilitie">
                        <tr class="treegrid-${so151410Bean.shipId}-${i.index} treegrid-parent-${so151410Bean.shipId}">
                            <td>${soOrderDetailAvailabilitie.supplierCode}</td>
                            <td colspan="3">${soOrderDetailAvailabilitie.supplierName}</td>
                            <td>${soOrderDetailAvailabilitie.pdCode}</td>
                            <td colspan="2">${soOrderDetailAvailabilitie.pdName}</td>
                            <td>${soOrderDetailAvailabilitie.pdGradeName}</td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.suppQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.sendQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.receiveQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.cancelQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.returnQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.rejectionQty}"/></td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </table>
                </div>
            </div>
     </div>
</div>
<script src="${ctx}/static/so/js/SO151410.js"></script>
