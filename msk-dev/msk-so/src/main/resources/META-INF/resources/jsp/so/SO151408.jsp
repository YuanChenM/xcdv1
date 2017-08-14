<!--
Title:订单新增或者变更页面
author:jiang_nan
createDate:2016-01-26
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="订单新增" backTitleArray="订单列表" backUrlArray="${ctx}/SO151401/init/"></navigation:header>
<div class="page-content list-page">
    <form:form commandName="SO151408Bean" id="SO151408Form" method="post" modelAttribute="SO151408Bean" action="${ctx}/SO151408/save">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>订单基本信息</label>
            </h3>
            <div>
                <table width="100%">
                    <tr>
                        <td style="text-align: right">卖家编号</td>
                        <td>
                            <form:input path="order.sellerCode" value="0000000" id="sellerCode" readonly="true"/>
                        </td>
                        <td style="text-align: right">卖家名称</td>
                        <td>
                            <form:input path="order.sellerName" value="神农客实业有限公司" id="sellerName" readonly="true"/>
                        </td>
                        <td style="text-align: right">订单区域</td>
                        <td>
                            <form:select path="order.districtCode" id="districtCode" items="${logisticsAreaList}"
                                         itemValue="lgcsAreaCode" itemLabel="lgcsAreaName"/>
                            <input name="filterMap['districtCode']" type="hidden" value="111111"/>
                        </td>
                        <td style="text-align: right">买手名称</td>
                        <td>
                            <form:input path="order.buyersName" id="buyersName"/>
                        </td>
                    </tr>
                    <tr>
                        <td style="text-align: right">买家类型</td>
                        <td>
                            <form:input path="order.buyersType" value="买手" id="buyersType" readonly="true"/>
                            <%--<select:codemaster codeName="OrderBuyerType" name="order.buyersType" id="buyersType"/>--%>
                        </td>
                        <td style="text-align: right">订单来源</td>
                        <td>
                            <form:input path="order.orderSource" value="冻期所" id="orderSource" readonly="true"/>
                            <%--<select:codemaster codeName="OrderSource" name="order.orderSource" id="orderSource"/>--%>
                        </td>
                        <td style="text-align: right">订单类型</td>
                        <td>
                            <form:input path="order.orderType" value="买手囤货订单" id="orderType" readonly="true"/>
                            <%--<select:codemaster codeName="OrderType" name="order.orderType" id="orderType" />--%>
                        </td>
                        <td style="text-align: right">是否需要发票</td>
                        <td><select:codemaster codeName="YESNO" name="order.needInvoice" id="needInvoice"/></td>
                    </tr>
                    <tr>
                        <td style="text-align: right">付款方式</td>
                        <td><select:codemaster codeName="PaymentType" name="order.paymentType" id="paymentType"/></td>
                        <td style="text-align: right">订单总金额</td>
                        <td>
                            <form:input path="order.orderAmount" id="orderAmount" readonly="true"></form:input>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>配送信息</label>
            </h3>
            <div>
                <table width="100%">
                    <tr>
                        <td style="text-align: right">是否需要动检证</td>
                        <td>
                            <form:select id="vicFlg" path="orderReceiveDemand.vicFlg">
                                <form:option value="0">否</form:option>
                                <form:option value="1">是</form:option>
                            </form:select>
                        </td>
                        <td style="text-align: right">收货人地址</td>
                        <td colspan="7">
                            <form:input path="orderReceiveDemand.receiverProvince" id="receiverProvince"/>省
                            <form:input path="orderReceiveDemand.receiverCity" id="receiverCity"/>市
                            <form:input path="orderReceiveDemand.receiverDistrict" id="receiverDistrict"/>区
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="group-accordion" collapsible="true" active="true" id="accordionProductData">
            <h3>
                <label>下单产品</label>
            </h3>
            <div style="min-height: 150px">
                <table width="100%" class="dataTable no-footer">
                    <thead>
                    <tr>
                        <th>产品编码</th>
                        <th>产品名称</th>
                        <th>产品价格</th>
                        <th>下单数量</th>
                    </tr>
                    </thead>
                    <tbody id="productData"></tbody>
                </table>

            </div>

        </div>
    </form:form>
    <div>
        <msk:button buttonType="button" buttonId="SO151408.SEARCH" buttonValue="产品选择"/>
        <msk:button buttonType="button" buttonId="SO151408.SAVE" buttonValue="保存"/>
    </div>
</div>

<script src="${ctx}/js/so/SO151408.js"></script>
