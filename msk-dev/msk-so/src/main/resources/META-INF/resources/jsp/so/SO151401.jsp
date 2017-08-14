 <%--
    Title:卖家审批审核列表
    author:rwf
    createDate:2015-12-14
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="订单列表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/SO151401/search" id="SO151401Form" method="post">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>
            <table>
                <tr>
                    <td width="15%" align="right">需求订单编码</td>
                    <td><input type="text" name="filterMap['orderCode']" id="orderCode"/></td>
                    <td coltype="text" width="15%" align="right">确认订单编码</td>
                    <td><input type="text" name="filterMap['confirmOrderCode']" id="confirmOrderCode"/></td>
                    <td coltype="text" width="15%" align="right">配送订单编码</td>
                    <td><input type="text" name="filterMap['deliveryOrderCode']" id="deliveryOrderCode"/></td>
                    <td></td>
                </tr>
                <tr>
                    <td width="15%" align="right">买家编码</td>
                    <td><input type="text" name="filterMap['buyersCode']" id="buyersCode"/></td>
                    <td width="15%" align="right">买家名称</td>
                    <td><input type="text" align="right" name="filterMap['buyersName']" id="buyersName"/></td>
                    <td width="15%" align="right">冻品管家</td>
                    <td><input type="text" align="right" name="filterMap['frozenGoodsHousekeep']" id="frozenGoodsHousekeep"/></td>
                    <td width="15%"></td>
                    <td width="15%"></td>
                    <td></td>
                </tr>
                <tr>
                    <td width="15%" align="right">是否有退货</td>
                    <td>
                        <select name="filterMap['returnFlg']" id="returnFlg">
                            <option value="">--请选择--</option>
                            <option value="1">是</option>
                            <option value="2">否</option>
                        </select>
                    </td>
                    <td width="15%" align="right">是否分批发货</td>
                    <td>
                        <select name="filterMap['splitDeliveryFlg']" id="splitDeliveryFlg">
                            <option value="">--请选择--</option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </td>
                    <td width="15%" align="right">是否开发票</td>
                    <td>
                        <select name="filterMap['needInvoice']" id="needInvoice">
                            <option value="">--请选择--</option>
                            <option value="1">是</option>
                            <option value="2">否</option>
                        </select>
                    </td>
                    <td width="15%"></td>
                    <td></td>
                </tr>
                <tr>
                    <td width="20%" align="right">物流区</td>
                    <td>
                        <select width="25px" name="filterMap['districtName']"  id="districtName">
                            <option value="" >--请选择--</option>
                            <c:forEach items="${districtList}" var="district" varStatus="status">
                                <option value="${district.districtName}">${district.districtName}</option>
                            </c:forEach>
                        </select>
                    </td>

                    <%-- <td width="15%" align="right">物流区</td>
                     <td>
                         <select:codemaster width="20px" id='districtName' name='filterMap["districtName"]'
                                            codeName="districtName" blank="true"
                                            value="${param.filterMap.districtName}"/>

                     </td>--%>
                    <td width="15%"></td>
                    <td width="15%"></td>
                    <td width="15%"></td>
                    <td width="15%"></td>
                    <td></td>
                </tr>
                <tr>
                    <td align="right">订单创建时间</td>
                    <td colspan="5">
                        <input type="text" id="orderTimeStart" name="filterMap['orderTimeStart']" readonly="readonly"/>
                        &emsp;~&emsp;
                        <input type="text" width="15%" id="orderTimeEnd" name="filterMap['orderTimeEnd']" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td align="right">订单ID</td>
                    <td>
                        <input type="text" name="filterMap['orderId']" id="orderId"/>
                    </td>
                    <!--Add by wang_jianzhou for Bug#3786 at 2016/11/21 Start.-->
                    <td align="right">发货单ID</td>
                    <td>
                        <input type="text" name="filterMap['shipId']" id="shipId"/>
                    </td>
                    <!--Add by wang_jianzhou for Bug#3786 at 2016/11/21 end.-->
                </tr>
                <tr>
                    <td width="15%" align="right">订单来源</td>
                    <td>
                        <select:codemaster width="25px" id='orderSource' name='filterMap["orderSource"]' codeName="orderSource" blank="true" value="${param.filterMap.orderSource}"/>
                        <%--<select:codemaster codeName="OrderSource" name="order.orderSource" id="orderSource"/>--%>
                        <%--<select name="filterMap['orderSource']" id="orderSource">
                           &lt;%&ndash; <option value="" >--请选择--</option>
                            <c:forEach items="${sourceList}" var="source" varStatus="status">
                                &lt;%&ndash;<c:if test="not empty typeSource.orderSource">&ndash;%&gt;
                                <option value="${source.orderSource}">${typeSource.sourceName}</option>
                                &lt;%&ndash;</c:if>&ndash;%&gt;
                            </c:forEach>
                        </select>&ndash;%&gt;
                        <option value="">--请选择--</option>
                               <option value="1">神农客电商平台</option>
                               <option value="2">美侍客电商平台</option>
                               <option value="3">大促会平台</option>
                               <option value="4">Call Center</option>
                               <option value="5">神农客APP</option>
                               <option value="6">美侍客APP</option>
                               <option value="7">大促会APP</option>
                        </select>--%>
                    </td>
                    <td width="15%" align="right">订单类型</td>
                    <td>
                        <%--<select:codemaster width="20px" id='orderType' name='filterMap["orderType"]' codeName="OrderType" blank="true"/>--%>
                        <select name="filterMap['orderType']" id="orderType">
                            <option value="" >--请选择--</option>
                            <c:forEach items="${typeList}" var="type" varStatus="status">
                                <%--<c:if test="not empty typeSource.orderType">--%>
                                <option value="${type.orderType}">${type.typeName}</option>
                                <%--</c:if>--%>
                            </c:forEach>
                        </select>
                        <%--<select name="filterMap['orderType']" id="orderType">
                            <option value="">--请选择--</option>
                            <option value="1">分销</option>
                            <option value="2">第三方</option>
                            <option value="3">大促会</option>
                        </select>--%>
                    </td>
                    <td width="15%" align="right">订单状态</td>
                    <td>
                        <%--#1512 update by sjj 20160808 start--%>
                        <input type="hidden" name="filterMap['orderStatus']" id="orderStatus" value="">
                        <select id="checkbox-orderStatus" width="120px">
                            <option value="1">新建</option>
                            <option value="2">待付款</option>
                            <option value="3">已付款</option>
                            <option value="4">待审核</option>
                            <option value="5">已审核</option>
                            <option value="6">待分销</option>
                            <option value="7">分销中</option>
                            <option value="8">已确认</option>
                            <option value="9">待发货</option>
                            <option value="10">部分发货</option>
                            <option value="11">部分收货</option>
                            <option value="12">全部发货</option>
                            <option value="13">已完成</option>
                            <option value="14">分销失败</option>
                            <option value="15">全部退货</option>
                            <option value="99">已取消</option>
                        </select>
                        <%--#1512 update by sjj 20160808 end--%>
                    </td>
                    <td width="15%"></td>
                    <td align="left"><msk:button buttonValue="查询" buttonId="SO151401.SEARCH" buttonType="button"/>
                </tr>
            </table>
        </div>
        <div>
            <table id="SO251101_list_grid">
                <thead>
                <tr>
                    <th coltype="text" width="20px" name="orderId">订单ID</th>
                    <th coltype="text" width="40px" name="orderCode">需求订单编码</th>
                    <%--<th coltype="text" width="40px" name="auxiliaryCode">时间编码</th>--%>
                    <%--<th coltype="text" width="7%" name="districtCode">物流区</th>--%>
                    <th coltype="text" width="7%" name="districtName">物流区</th>
                    <th coltype="text" width="7%" name="buyersTypeName">买家类型</th>
                    <th coltype="text" width="10%" name="orderSource">订单来源</th>
                    <th coltype="text" width="10%" name="orderType">订单类型</th>
                    <th coltype="text" width="40px" name="buyersCode">买家编码</th>
                    <th coltype="text" width="10%" name="buyersName">买家名称</th>
                    <%-- <th coltype="text" width="10%" name="buyersType">买家类型</th>--%>
                    <th coltype="text" width="10%" name="frozenGoodsHousekeep">冻品管家</th>
                    <th coltype="text" width="40px" name="orderTime">订单创建时间</th>
                    <th coltype="text" width="10%" name="orderQty">订单数量</th>
                    <th coltype="text" width="10%" name="orderAmount">订单总金额(元)</th>
                    <th coltype="text" width="30px" name="orderStatus">订单状态</th>

                    <th coltype="action">操作
                        <msk:button buttonValue="订单详情" buttonId="SO151401.editBtn" buttonType="hidden"
                                    coltype="edit"/>
                        <c:if test="${loginUser.userType ne ('99')}">
                            <msk:button buttonValue="发货单详情" buttonId="SO151401.checkBtn" buttonType="hidden"
                                        coltype="check"/>
                        </c:if>
                        <msk:button buttonValue="申请退货" buttonId="SO151401.RETURN" buttonType="hidden"
                                    coltype="return"/>
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
    <c:if test="${loginUser.userType ne ('99')}">
        <msk:button buttonType="button" buttonId="SO151401.NEW" url="${ctx}/SO151408/init/-1" buttonValue="创建竞价囤货订单"/>
        <msk:button buttonValue="订单详细数据导出" buttonId="SO151401.EXPORT" buttonType="button" align="left"/>
        <msk:button buttonValue="订单列表数据导出" buttonId="SO151401.EXPORTORDER" buttonType="button" align="left"/>
    </c:if>

</div>
<script src="${ctx}/js/so/SO151401.js"></script>