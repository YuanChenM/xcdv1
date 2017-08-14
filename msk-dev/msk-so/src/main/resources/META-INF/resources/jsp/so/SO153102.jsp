<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="买家交易记录详情" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <%--${ctx}/SO153202/search--%>
    <form action="${ctx}/SO153102/search" id="SO153102Form" method="post">
        <input type="hidden" value="${orderCode}" id="orderCode" name="filterMap['orderCode']">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>订单详情</label>
            </h3>
            <table WIDTH="100%">
                <tr>
                    <td width="5%" align="left">收货地址:</td>
                    <td width="25%" align="left">${sO153102Bean.receiverAddr}</td>
                    <td width="50%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">卖家留言：</td>
                    <td width="55%" align="left">${sO153102Bean.remark}</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">订单状态:</td>
                    <td width="55%" align="left">${sO153102Bean.state}</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">订单编号：</td>
                    <td width="55%" align="left">${sO153102Bean.orderId}</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">成交时间：</td>
                    <td width="55%" align="left">${sO153102Bean.clossTime}</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">付款时间：</td>
                    <td width="55%" align="left">${sO153102Bean.paymentTime}</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">发货时间：</td>
                    <td width="55%" align="left">${sO153102Bean.sendTime}</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">完结时间：</td>
                    <td width="55%" align="left">${sO153102Bean.overTime}</td>
                    <td width="20%"><td/>
                </tr>
            </table>
        </div>
        <div class="group-accordion" collapsible="false" active="false">
            <h3 style="display: none;">
                <label></label>
            </h3>
            <table id="SO153102_list_grid" WIDTH="100%">
                <thead>
                <tr>
                    <th coltype="text" width="13%" name="createTime">创建时间</th>
                    <th coltype="text" width="13%" name="name">名称</th>
                    <th coltype="text" width="13%" name="weight">重量</th>
                    <th coltype="text" width="13%" name="money">金额</th>
                    <th coltype="text" width="13%" name="state">状态</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>

<script src="${ctx}/js/so/SO153102.js"></script>
