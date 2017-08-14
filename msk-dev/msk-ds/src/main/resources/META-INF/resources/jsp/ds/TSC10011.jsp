<%--
    Title:发货单一览
    author:cx
    createDate:2016-6-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发货订单一览" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC10011/search" method="post">
        <table id="TSC10011_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <th coltype="sno" width="10%">ID</th>

                <th coltype="text" width="10%" name="contractNumber" filter="true">合同编号</th>
                <th coltype="text" width="30%" name="contractName" filter="true">合同名称</th>
                <th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>
                <th coltype="text" width="20%" name="info1">发货单编号</th>
                <th coltype="text" align="center" name="info2">第·N批次发货</th>
                <th coltype="text" width="20%" name="info3">运输单编号</th>
                <th coltype="text" width="20%" name="info4">发货时间</th>
                <th coltype="select" align="center" name="info5" filter="true">发货状态　　
                    <select>
                        <option value="0">已发货</option>
                        <option value="1">未发货</option>
                    </select>
                </th>
                <th coltype="action">查看
                    <input type="hidden" coltype="detail" title="发货计划详细" class="h-button"/>
                </th>
                <th coltype="action">编辑
                    <input type="hidden" coltype="detail" title="发货计划详细" class="h-button"/>
                </th>
                <th coltype="action">删除
                    <input type="hidden" coltype="edit" title="发货计划详细" class="h-button"/>
                </th>
                <th coltype="action">三方确认
                    <input type="hidden" coltype="detail" title="发货计划详细" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <div><msk:button buttonValue="新建" buttonId="TSC10011.SAVE" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC10011.js"></script>
