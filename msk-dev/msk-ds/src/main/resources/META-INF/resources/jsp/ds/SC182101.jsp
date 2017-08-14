<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发货入库通知单一览" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/SC182101/search" id="SC182101Form" method="post">
        <table id="SC182101_Grid">
            <thead>
            <tr>
                <th coltype="text" name="deliveryStockId" filter="true" width="20px">发货入库通知单号</th>
                <th coltype="text" name="distMonth" filter="true">周期</th>
                <%--<th coltype="text" name="lgcsCode" filter="true">物流区</th>
                <th coltype="text" name="suppCode" filter="true">卖家</th>
                <th coltype="text" name="halfName" filter="true">半旬</th>
                <th coltype="text" name="deliveryStockStatus" filter="true">状态</th>--%>
                <th coltype="text" name="lgcsName" filter="true">物流区</th>
                <th coltype="text" name="suppName" filter="true">卖家</th>
                <th coltype="text" name="manuName" filter="true">生产商</th>
                <%--<th coltype="select" width="90px" name="halfName" filter="true">半旬
                    <select>
                        <option value="1">21-25日</option>
                        <option value="2">26-N日</option>
                        <option value="3">1-5日</option>
                        <option value="4">6-10日</option>
                        <option value="5">11-15日</option>
                        <option value="6">16-20日</option>
                    </select>
                </th>--%>
                <th coltype="select" width="80px" name="statusName" filter="true">状态
                    <select>
                        <option value="1">未申请</option>
                        <option value="2">申请中</option>
                        <option value="3">已确认</option>
                        <option value="4">待收货</option>
                        <option value="5">已收货</option>
                        <option value="6">部分收货</option>
                    </select>
                </th>
                <th coltype="text" name="deliveryReceiveStockTime" filter="true">实际到货时间</th>
                <th coltype="text" name="sendPlanNum">计划发货箱数</th>
                <th coltype="text" name="sendActualNum">实际发货箱数</th>
                <th coltype="text" name="receiveNum">实际收货箱数</th>
                <th coltype="text" name="sendPlanQty">计划发货重量(KG)</th>
                <th coltype="text" name="sendActualQty">实际发货重量(KG)</th>
                <th coltype="text" name="recriveQty">实际收货重量(KG)</th>
                <th coltype="text" name="differNum">差异箱数</th>
                <th coltype="text" name="differQty">差异重量(KG)</th>

                <%--<th coltype="text" name="deliveryWarehouseAddr" filter="true">发货仓库地点</th>
                <th coltype="text" name="deliveryResponName" filter="true">发货责任人</th>
                <th coltype="text" name="transportUnitName" filter="true">运输单位名称</th>
                <th coltype="text" name="transportUnitResponName" filter="true">运输单位负责人</th>
                <th coltype="text" name="stockAddr" filter="true">运抵仓库地址</th>
                <th coltype="text" name="stockResponName" filter="true">仓管负责人</th>--%>
                <th coltype="action" width="10px">
                    <%--<c:if test="${userType == 2}">
                        <input type="button" id="deleteBtn" hidden="true" title="删除" coltype="delete" class="h-button"/>
                    </c:if>--%>
                    <input type="button" id="editBtn" hidden="true" title="编辑" coltype="edit" class="h-button" />
                </th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>

    </form>
    <div id="userType" style="display:none"><c:out value="${loginUser.userType}"></c:out></div>
    <div id="crtId" style="display:none"><c:out value="${loginUser.emplId}"></c:out></div>

    <c:if test="${userType == 2}">
        <msk:button buttonValue="新增" buttonId="SC182101.ADD" buttonType="button" url="${ctx}/SC182102/init/false" />
    </c:if>
    <msk:button buttonValue="发货入库一览数据导出" buttonId="SC182101.EXPORT" buttonType="button" align="left"/>

</div>
<script type="text/javascript" src="${ctx}/js/ds/SC182101.js"></script>
