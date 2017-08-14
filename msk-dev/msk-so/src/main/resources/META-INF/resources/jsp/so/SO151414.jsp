<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发货单列表" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">
    <form action="${ctx}/SO151414/search" id="SO151414Form" method="post">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>
            <table>
                <tr>
                    <td width="10%" align="right">物流区</td>
                    <td>
                        <select width="25px" name="filterMap['districtName']" id="districtName">
                            <option value="">--请选择--</option>
                            <c:forEach items="${districtList}" var="district" varStatus="status">
                                <option value="${district.districtName}">${district.districtName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="10%" align="right">订单编号</td>
                    <td><input type="text" name="filterMap['orderCode']" id="orderCode"/></td>
                    <td coltype="text" width="10%" align="right">发货单ID</td>
                    <td><input type="text" name="filterMap['shipId']" id="shipId"/></td>
                    <td width="10%" align="right">发货单创建日期</td>
                    <td><input type="text" id="shipTimeStart" name="filterMap['shipTimeStart']" readonly="readonly"/>
                    </td>
                    <td width="10%" align="left">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;至</td>
                    <td>
                        <input type="text" width="15%" id="shipTimeEnd" name="filterMap['shipTimeEnd']"
                               readonly="readonly"/>
                    </td>
                    <td width="10%"></td>
                </tr>
                <tr>
                    <td width="10%" align="right">买家编码</td>
                    <td><input type="text" name="filterMap['buyersCode']" id="buyersCode"/></td>
                    <td width="10%" align="right">买家名称</td>
                    <td><input type="text" align="right" name="filterMap['buyersName']" id="buyersName"/></td>
                    <td width="10%" align="right">管家名称</td>
                    <td><input type="text" align="right" name="filterMap['frozenGoodsHousekeep']"
                               id="frozenGoodsHousekeep"/></td>
                    <td width="10%" align="right">收货地址</td>
                    <td><input type="text" align="right" name="filterMap['receiverAddr']" id="receiverAddr"/></td>
                    <td width="10%" align="right">发货仓已设定</td>
                    <td>
                        <select name="filterMap['whFlg']" id="whFlg">
                            <option value="">--请选择--</option>
                            <option value="0">是</option>
                            <option value="1">否</option>
                        </select>
                    </td>
                    <td align="right"><msk:button buttonValue="查询" buttonId="SO151414.SEARCH" buttonType="button"/></td>
                </tr>
            </table>
        </div>
        <div>
            <table id="SO151414_list_grid">
                <thead>
                <tr>
                    <th coltype="checkbox"></th>
                    <th coltype="text" width="20px" name="shipId">发货单ID</th>
                    <th coltype="text" width="40px" name="orderCode">订单编号</th>
                    <th coltype="text" width="7%" name="districtName">物流区</th>
                    <th coltype="text" width="40px" name="buyersCode">买家编码</th>
                    <th coltype="text" width="10%" name="buyersName">买家名称</th>
                    <th coltype="text" width="10%" name="frozenGoodsHousekeep">冻品管家</th>
                    <th coltype="text" width="40px" name="receiverAddr">收货地址</th>
                    <th coltype="text" width="10%" name="shipTime">发货单创建时间</th>
                    <th coltype="text" width="10%" name="shipStatusName">发货单状态</th>
                    <th coltype="text" width="30px" name="whName">发货仓库</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <div>
            <table>
                <tr>
                    <td width="150px" align="left">对选中发货单设定发货仓库</td>
                    <td>
                        <select name="filterMap['whCode']" id="whCode">
                            <option value="">--请选择--</option>
                            <c:forEach items="${whList}" var="wh" varStatus="status">
                                <option value="${wh.whCode}">${wh.whName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td coltype="text" width="80px" align="left">
                        <msk:button buttonType="button" buttonId="SO151414.SAVE" align="left" buttonValue="保存"/>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</div>
<script src="${ctx}/js/so/SO151414.js"></script>