<%-- 
    Title:退货单列表
    author:rwf
    updateDate:2015-12-31
    updateAuthor:rwf
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="退货单列表" backTitleArray="" backUrlArray=""></navigation:header>
   <div class="page-content list-page">
    <form action="${ctx}/SO151406/search" id="SO151406Form" method="post">
        <div class="group-accordion" collapsible="" active="false">
            <h3>
                <label>查询条件</label>
            </h3>
            <table width="100%">
                <tr>
                    <td width="13%" align="right">退货单编码</td>
                    <td align="left" width="13%" colspan="3">
                        <input type="text" id="returnCode" name="filterMap['returnCodeQuery']"/>
                    </td>
                    <td width="13%" align="right">订单编码</td>
                    <td align="left" width="13%" colspan="3">
                        <%--<input type="text" id="orderCode" name="filterMap['orderCodeQuery']"/>--%>
                        <input type="text" id="orderCode" name="filterMap['orderCode']"/>
                    </td>
                </tr>
                <tr>
                    <td width="13%" align="right">买家编码</td>
                    <td align="left" width="13%" colspan="3">
                        <input type="text" id="buyersCode" name="filterMap['buyersCodeQuery']"/>
                    </td>
                    <td width="13%" align="right">买家名称</td>
                    <td align="left" width="13" colspan="3">
                        <input type="text" id="buyersName" name="filterMap['buyersNameQuery']"/>
                    </td>
                </tr>
                <tr>
                    <td width="13%" align="right">退货单来源</td>
                    <td align="left" width="13%">
                        <%--Modify for Bug#3789 at 2016/11/21 by sun_jiaju Start--%>
                        <select:codemaster width="25px" id='orderSource' name='filterMap["returnSource"]' codeName="ReturnSource" blank="true" />
                        <%--Modify for Bug#3789 at 2016/11/21 by sun_jiaju End--%>
                    </td>
                    <td width="13%" align="right">是否已付款</td>
                    <td align="left" width="13%">
                        <select name="filterMap['isPaid']" id="isPaid">
                            <option value="">--请选择--</option>
                            <option value="1">是</option>
                            <option value="2">否</option>
                        </select>
                    </td>
                    <td width="13%" align="right">退货方式</td>
                    <td align="left" width="13%">
                        <select name="filterMap['returnMode']" id="returnMode">
                            <option value="">--请选择--</option>
                            <option value="1">全退</option>
                            <option value="2">部分退</option>
                        </select>
                    </td>
                    <td width="13%" align="right">是否已开票</td>
                    <td align="left" width="13%">
                        <select id="isInvoice" name="filterMap['isInvoice']">
                            <option value="">--请选择--</option>
                            <option value="1">是</option>
                            <option value="2">否</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="13%" align="right">退货单申请时间</td>
                    <td align="left" width="13%" colspan="3">
                        <input type="text" name="filterMap['startTime']" id="startTime" readonly="readonly"/>
                        &emsp;～&emsp;
                        <input type="text" name="filterMap['endTime']" id="endTime" readonly="readonly"/>
                    </td>
                    <td width="13%" align="right">退货单状态</td>
                    <td align="left" width="13%">
                        <select name="filterMap['returnStatus']" id="returnStatus">
                            <option value="">--请选择--</option>
                            <option value="1">申请中</option>
                            <option value="2">待审批</option>
                            <option value="3">已审核</option>
                            <option value="4">待处理</option>
                            <option value="5">处理中</option>
                            <option value="6">收货中</option>
                            <option value="7">已收货</option>
                            <option value="8">已入库</option>
                            <option value="9">迟收成功</option>
                            <option value="99">已取消</option>
                        </select>
                    </td>
                    <td width="13%" align="right">退货单类型</td>
                    <td align="left" width="13%">
                        <select name="filterMap['returnType']" id="returnType">
                            <option value="">--请选择--</option>
                            <option value="1">迟收</option>
                            <option value="2">拒收</option>
                            <option value="3">退货</option>
                        </select>
                    </td>
                    <td align="right">
                        <msk:button buttonValue="查询" buttonId="SO151406.SEARCH" buttonType="button"/>
                    </td>
                </tr>
            </table>
        </div>
         <div class="group-accordion" collapsible="false" active="false">
            <h3 style="display: none;">
                <label></label>
            </h3>
        <table id="SO151406_list_grid" >
            <thead>
            <tr>
                <th coltype="link" width="10%" name="returnCode">退货单编码</th>
               <%-- <th coltype="link" width="5%" name="orderCode">需求订单编码</th>--%>
                <th coltype="link" width="10%" name="orderCode">订单编码</th>
                <th coltype="text" width="7%" name="buyersCode">买家编码</th>
                <th coltype="text" width="10%" name="buyersName">买家名称</th>
                <th coltype="text" width="10%" name="returnSource">退货单来源</th>
                <th coltype="text" width="5%" name="isPaid">是否已付款</th>
                <th coltype="text" width="5%" name="returnMode">退货方式</th>
                <th coltype="text" width="10%" name="returnAmount">退货单总金额(元)</th>
                <th coltype="text" width="10%" name="returnTime">退货单申请时间</th>
                <th width="10%" name="returnStatus" style="display: none">退货单状态编号</th>
                <th coltype="text" width="10%" name="returnStatusName">退货单状态</th>
                <%--<th coltype="action">打印
                    <msk:button buttonValue="打印" buttonId="SO151406.PRINT" buttonType="hidden"
                                coltype="print"/>
                </th>--%>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        </div>
    </form>
   </div>
<script src="${ctx}/js/so/SO151406.js"></script>
