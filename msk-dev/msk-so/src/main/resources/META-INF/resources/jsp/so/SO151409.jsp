<%--
    Title:分销正常库存
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="卖家销售排行" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">
    <form action="${ctx}/SO151409/search" id="SO151409Form" method="post">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>

            <div>
                <table>
                    <tr>
                        <td width="15%" align="right">物流区编码</td>
                        <td><input type="text" name="filterMap['lgcsCode']" id="lgcsCode"
                                   value="${param.filterMap.lgcsCode}"/></td>

                        <td width="15%" align="right">产品编码</td>
                        <td><input type="text" align="right" name="filterMap['pdCode']" id="pdCode"
                                   value="${param.filterMap.pdCode}"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td coltype="text" width="15%" align="right">供应商编码</td>
                        <td><input type="text" name="filterMap['suppCode']" id="suppCode"
                                   value="${param.filterMap.suppCode}"/></td>
                        <td coltype="text" width="15%" align="right">供应商名称</td>
                        <td><input type="text" name="filterMap['suppName']" id="suppName"
                                   value="${param.filterMap.suppName}"/></td>
                        <td width="15%"></td>
                        <td align="left"><msk:button buttonValue="查询" buttonId="SO151409_SEARCH" buttonType="button"/>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>

        <div>
            <table id="SO151409_list_grid">
                <thead>
                <tr>
                    <th coltype="text" width="40px" name="lgcsCode">物流区编号</th>
                    <th style="display: none" width="40px" name="orderLevel"></th>
                    <th coltype="text" width="40px" name="levelName">订单等级</th>
                    <th coltype="text" width="7%" name="pdCode">产品编码</th>
                    <th coltype="text" width="10%" name="suppCode">供应商编码</th>
                    <th coltype="text" width="10%"  name="suppName">供应商名称</th>
                    <th coltype="text" width="40px" name="priceCycle">价盘周期</th>
                    <th coltype="text" width="10%" name="salesAmount">销售额</th>
                    <th coltype="text" width="10%" name="distQua">分销资格</th>
                    <th coltype="text" width="30px" edit="true" cellEditMode="true" name="salesRanking">销售排行</th>
                    <th coltype="text" width="30px" edit="true" cellEditMode="true" name="wheelFrequency">轮单次数</th>
                    <th coltype="action">
                        <input type="hidden" hidden="true" id="saveBtn" value="保存" coltype="save" title="保存"
                               class="h-button"/>
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script src="${ctx}/js/so/SO151409.js"></script>
