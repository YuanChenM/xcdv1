<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:订单明细详细信息页面
    update:gyh
    updateTime:2016.1.5
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="${ctx}/static/core/js/jquery.PrintArea.js" ></script>
<input type="hidden" id="orderId" value="${orderId}">
<input type="hidden" id="orderCode" value="${orderCode}">
<input type="hidden" id="orderTypeHidden" value="${so151402Bean.orderType}">
<input type="hidden" id="ver" value="${so151402Bean.ver}">
 <%--#1129 add by sjj 20160712 start--%>
<input type="hidden" id="printUrl" value="${printUrl}">
<input type="hidden" id="callBackUrl" value="${callBackUrl}">
 <%--#1129 add by sjj 20160712 end--%>
<style>
    html { overflow-x:hidden; }
</style>
<div class="page-content list-page">
    <div id = "point">
    <div id="baseorder"></div>
    <div id="orderbuyers"></div>
    <div id="basedelivery"></div>
    <div id="logisticsDetail">
        <%--<div class="group-accordion" active="false">
            <h3>
                <label>本单配送信息</label>
            </h3>
            <div>
                <!--  2016-01-02 06:38:37 上海物流中心 装车扫描<br>
                 2016-01-02 06:40:35 上海物流中心 出库扫描<br>
                 2016-01-02 08:12:58 送达卸货<br>
                 2016-01-02 08:22:46 确认收货<br>  -->
            </div>
        </div>--%>
    </div>
        <div id="orderDetail">
            <div class="group-accordion" active="true">
                <h3>
                    <label>订单明细</label>
                </h3>
                <div>
                    <form action="${ctx}/SO151401/init" id="SO151402Form" method="post">
                        <input type="hidden" name="filterMap['requireOrderCode']" id="requireOrderCode" value="${baseParam.filterMap.requireOrderCode}"/>
                        <input type="hidden" name="filterMap['confirmOrderCode']" id="confirmOrderCode" value="${baseParam.filterMap.confirmOrderCode}"/>
                        <input type="hidden" name="filterMap['deliveryOrderCode']" id="deliveryOrderCode" value="${baseParam.filterMap.deliveryOrderCode}"/>
                        <input type="hidden" name="filterMap['buyersCode']" id="buyersCode" value="${baseParam.filterMap.buyersCode}"/>
                        <input type="hidden" name="filterMap['buyersName']" id="buyersName" value="${baseParam.filterMap.buyersName}"/>
                        <input type="hidden" name="filterMap['returnFlg']" id="returnFlg" value="${baseParam.filterMap.returnFlg}"/>
                        <%-- <input type="hidden" name="filterMap['splitDeliveryFlg']" id="splitDeliveryFlg" value="${baseParam.filterMap.splitDeliveryFlg}"/>--%>
                        <input type="hidden" name="filterMap['splitDeliveryFlgName']" id="splitDeliveryFlgName" value="${baseParam.filterMap.splitDeliveryFlgName}"/>
                        <input type="hidden" name="filterMap['needInvoice']" id="needInvoice" value="${baseParam.filterMap.needInvoice}"/>
                        <input type="hidden" name="filterMap['districtCode']" id="districtCode" value="${baseParam.filterMap.districtCode}"/>
                        <input type="hidden" name="filterMap['orderTimeStart']" id="orderTimeStart" value="${baseParam.filterMap.orderTimeStart}"/>
                        <input type="hidden" name="filterMap['orderTimeEnd']" id="orderTimeEnd" value="${baseParam.filterMap.orderTimeEnd}"/>
                        <input type="hidden" name="filterMap['orderSource']" id="orderSource" value="${baseParam.filterMap.orderSource}"/>
                        <input type="hidden" name="filterMap['orderType']" id="orderType" value="${baseParam.filterMap.orderType}"/>
                        <input type="hidden" name="filterMap['orderStatus']" id="orderStatus" value="${baseParam.filterMap.orderStatus}"/>
                    </form>
                    <table class="tree dataTable no-footer" id = "detailTable" style="width: 100%">
            <tr style="background:#DBDBDB">
                <td width="6%">期望配送日</td>
                <td width="8%">产品编码</td>
                <td width="6.5%">产品名称</td>
                <td width="6.5%">产品规格</td>
                <td width="7.5%">产品净重(kg/箱)</td>
                <td width="6.5%">包装规格</td>
                <td width="6.5%">产品等级</td>
                <td width="6.5%">单价(元/箱)</td>
                <td width="6.5%">金额(元)</td>
                <td width="6.5%">订购数量</td>
                <td width="6.5%">发货数量</td>
                <td width="6.5%">收货数量</td>
                <td width="6.5%">取消数量</td>
                <td width="6.5%">退货数量</td>
                <td width="6.5%">拒收数量</td>
                <td width="4.5%">状态</td>
                <td width="2%">操作</td>
            </tr>
            <c:forEach items="${so251108Beans}" var="so251108Bean" varStatus="i">
                <tr class="treegrid-${so251108Bean.orderDetailId}">
                    <td align="left">${so251108Bean.expectedDate}</td>
                    <td>${so251108Bean.pdCode}</td>
                    <td>${so251108Bean.pdName}</td>
                    <td>${so251108Bean.featureName}</td>
                    <td>${so251108Bean.netWeightOut}</td>
                    <td>${so251108Bean.normsName}</td>
                    <td>${so251108Bean.pdLevel}</td>
                    <td>${so251108Bean.pdPrice}</td>
                    <td>${so251108Bean.pdPriceAll}</td>
                    <td align="right">${so251108Bean.orderQty}</td>
                    <td align="right">${so251108Bean.sendQty}</td>
                    <td align="right">${so251108Bean.receiveQty}</td>
                    <td align="right">${so251108Bean.cancelQty}</td>
                    <td align="right">${so251108Bean.returnQty}</td>
                    <td align="right">${so251108Bean.rejectionQty}</td>
                    <td>${so251108Bean.detailStatusName}</td>
                    <td>
                        <msk:roleArea pageCode="SO251108" areaCode="UPDATE" needAuth="true">
                        <c:if test="${loginUser.userType ne ('99')}">
                            <c:if test="${so251108Bean.detailStatus <= 3 || so251108Bean.detailStatus == 8}">
                                <img alt="编辑" name="orderDetailInfo" orderDetailId="${so251108Bean.orderDetailId}" src="${ctx}/static/core/images/action/edit.png" title="编辑">
                            </c:if>
                        </c:if>
                        </msk:roleArea>
                    </td>
                </tr>
                <c:if test="${so251108Bean.soOrderDetailAvailabilities.size() gt 0}">
                    <tr class="treegrid-${so251108Bean.orderDetailId}-${i.index} treegrid-parent-${so251108Bean.orderDetailId}" style="background:#DBDBDB">
                        <td colspan="3"></td>
                        <td></td>
                        <td></td>
                        <td>供应商编号</td>
                        <td colspan="3">供应商名称</td>
                        <td>供货数量</td>
                        <td>发货数量</td>
                        <td>收货数量</td>
                        <td>取消数量</td>
                        <td>退货数量</td>
                        <td>拒收数量</td>
                        <td></td>
                        <td></td>
                    </tr>
                    <c:forEach items="${so251108Bean.soOrderDetailAvailabilities}" var="soOrderDetailAvailabilitie">
                        <tr class="treegrid-${so251108Bean.orderDetailId}-${i.index} treegrid-parent-${so251108Bean.orderDetailId}">
                            <td colspan="3"></td>
                            <td></td>
                            <td></td>
                            <td>${soOrderDetailAvailabilitie.supplierCode}</td>
                            <td colspan="3">${soOrderDetailAvailabilitie.supplierName}</td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.suppQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.sendQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.receiveQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.cancelQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.returnQty}"/></td>
                            <td align="right"><fmt:formatNumber type="number" value="${soOrderDetailAvailabilitie.rejectionQty}"/></td>
                            <td></td>
                            <td>
                                <%--Delete for Bug #2595 at 2016/11/11 by sun_jiaju Start--%>
                                <%--<msk:roleArea pageCode="SO251108" areaCode="AVAUPDATE" needAuth="true">--%>
                                <%--<c:if test="${loginUser.userType ne ('99')}">--%>
                                    <%--<c:if test="${soOrderDetailAvailabilitie.status eq 1}">--%>
                                        <%--<img alt="编辑" name="SO151402" orderDetailAvailabilityId="${soOrderDetailAvailabilitie.orderDetailAvailabilityId}" src="${ctx}/static/core/images/action/edit.png" title="编辑">--%>
                                    <%--</c:if>--%>
                                <%--</c:if>--%>
                                <%--</msk:roleArea>--%>
                                <%--Delete for Bug #2595 at 2016/11/11 by sun_jiaju End--%>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </table>
                </div>
            </div>
     </div>
    <div>
        <c:if test="${loginUser.userType ne ('99')}">
        <table>
            <tr>
                <td><msk:button buttonValue="打印需求订单" buttonId="SO251108.NEW" buttonType="hidden"/></td>
                <td><msk:button buttonValue="打印确认订单" buttonId="SO251108.MODIFY" buttonType="hidden"/></td>
                <td><msk:button buttonValue="打印配送订单" buttonId="SO251108.DELETE" buttonType="hidden"/></td>
                <%--<c:if test="${!(orderStatusName eq '全部收货')}">--%>
                <c:if test="${orderStatusName eq '全部发货'|| orderStatusName eq '待发货'}">
                    <td><msk:button buttonValue="订单完成" buttonId="SO251108.OVER" buttonType="button"/></td>
                </c:if>
                <c:if test="${so151402Bean.orderType eq 4 and so151402Bean.orderStatus eq 2}">
                    <td><msk:button buttonValue="已付款" buttonId="SO251108.CHANGE" buttonType="button"/></td>
                </c:if>
                <%--<td><msk:button buttonValue="订单删除" buttonId="SO251108.REALDELETE" buttonType="button"/></td>--%>
                <c:if test="${so151402Bean.receiveQty eq '0.00' && so151402Bean.rejectionQty eq '0.00'  && so151402Bean.cancelQty eq '0.00' && so151402Bean.childFlag eq '0'}">
                <td><msk:button buttonValue="订单取消" buttonId="SO251108.CANCEL" buttonType="button"/></td>
                </c:if>
                <%-- <td><msk:button buttonValue="返回" buttonId="SO251108.BACK" buttonType="button" /></td>--%>
                <%--#1129 add by sjj 20160712 start--%>
                <td><msk:button buttonValue="页面打印" buttonId="SO251108.PRINT" buttonType="button"/></td>
                <%--#1129 add by sjj 20160712 end--%>
                <c:if test="${so151402Bean.childFlag eq 0 and so151402Bean.orderStatus eq '4'}">
                    <td><msk:button buttonValue="手动确认" buttonId="SO251108.CONFIRM" buttonType="button"/></td>
                </c:if>
            </tr>
        </table>
        </c:if>
    </div>
</div>
<script src="${ctx}/static/so/js/SO151402.js"></script>
</div>