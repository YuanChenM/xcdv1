<%--
    Title:卖家-交易记录查询
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="卖家-交易记录查询" backTitleArray="" backUrlArray="${ctx}"></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/SO153201/search" id="SO153201Form" method="post">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>
            <table WIDTH="100%">
                <tr>
                    <td  align="right">金额范围 :</td>
                    <td align="left">　
                        <input type="text" name="filterMap['orderAmountStart']" value="${param.filterMap.orderAmountStart}"/>
                        &emsp;~&emsp;
                        <input type="text" name="filterMap['orderAmountEnd']" value="${param.filterMap.orderAmountEnd}"/>
                    </td>
                    <td  align="right">金额类型 :</td>
                    <td align="left">　
                        <select name="filterMap['orderAmountType']">
                            <option value="0"></option>
                            <option value="1">收入</option>
                            <option value="2">支出</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td  align="right">卖家编码 :</td>
                    <td  align="left">　
                        <input type="text" name="filterMap['businessMain']" value="${param.filterMap.businessMain}"/>
                    </td>
                    <td  align="right">卖家 :</td>
                    <td  align="left">　
                        <input type="text" name="filterMap['businessName']" value="${param.filterMap.businessName}"/>
                    </td>
                </tr>
                <tr>
                    <td  align="right">时间范围 :</td>
                    <td  align="left">　
                        <input type="text" id="orderTimeStart" name="filterMap['timeStart']" value="${param.filterMap.timeStart}"/>
                        &emsp;~&emsp;
                        <input type="text" id="orderTimeEnd" name="filterMap['timeEnd']" value="${param.filterMap.timeEnd}"/>
                    </td>
                    <td align="right">时间类型 :</td>
                    <td align="left">
                        &emsp;
                        <select name="filterMap['timeType']" id="timeType">
                            <c:choose>
                                <c:when test="${empty param.filterMap.timeType}">
                                    <option value="1" selected>交易时间</option>
                                    <option value="2">创建时间</option>
                                </c:when>
                                <c:otherwise>
                                    <c:when test="${param.filterMap.timeType eq 1}">
                                        <option value="1" selected>交易时间</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="2" selected>创建时间</option>
                                    </c:otherwise>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td  align="right">是否付款 :</td>
                    <td align="left">　
                        <select name="filterMap['settlement']">
                            <option></option>
                            <option value="0">已付款</option>
                            <option value="1">待付款</option>
                        </select>
                    </td>
                    <td align="right"></td>
                    <td align="left"></td>
                </tr>
                <tr>
                    <td/>
                    <td/>
                    <td/>
                    <td align="right">
                        <msk:button buttonValue="查询" buttonId="SO153201.SEARCH" buttonType="button"/>
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <table id="SO153201_list_grid" WIDTH="100%">
                <thead>
                <tr>
                    <th coltype="text" width="15%" id="tranTime" name="tranTime">交易时间</th>
                    <th coltype="text" width="30%" name="selectCode">订单号</th>
                    <th coltype="text" width="15%" name="businessAssistant">付款方</th>
                    <th coltype="text" width="15%" name="businessMain">收款方</th>
                    <th coltype="link" width="10%" name="orderAmount">金额 | 明细</th>
                    <th coltype="text" width="10%" name="settlement">状态</th>
                    <th coltype="text" width="10%" name="remark">备注</th>
                    <th coltype="action" width="15%">操作
                        <input type="hidden" hidden="true" id="editBtn" value="交易记录详情" coltype="edit"
                               title="交易记录详情"
                               class="h-button"/>
                        <input type="hidden" hidden="true" id="printBtn" value="打印" coltype="print" title="打印" class="h-button"/>
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>

    </form>
</div>
<script src="${ctx}/js/so/SO153201.js"></script>
