<%--
    Title:发货明细
    author:cx
    createDate:2016-6-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="付款计划一览" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">

        <form action="${ctx}/TSC10012/search" method="post">
            <table id="TSC10012_list_grid" showAddBtn="true" width="100%">
                <thead>
                <tr>
                    <th coltype="sno" width="10%">ID</th>
                    <th coltype="text" width="10%" name="info1" filter="true">合同编号</th>
                    <th coltype="text" width="30%" name="info2" filter="true">合同名称</th>
                    <th coltype="text" width="30%" name="info3" filter="true">供应商</th>
                    <th coltype="text" width="20%" name="info4">付款单编号</th>
                    <th coltype="text" width="20%" name="info5">订单类型</th>
                    <th coltype="text" width="20%" name="info6">订单编码</th>
                    <th coltype="text" width="20%" name="info7">付款说明</th>
                    <th coltype="text" width="20%" name="info8">付款状态</th>
                    <th coltype="text" width="20%" name="info9">应付（元）</th>
                    <th coltype="text" width="20%" name="info10">已付（元）</th>
                    <th coltype="text" width="20%" name="info11">应收（元）</th>
                    <th coltype="text" width="20%" name="info11">已收（元）</th>
                    <th coltype="text" width="20%" name="info11">计划付/收款时间</th>
                    <th coltype="text" width="20%" name="info11">付/收款时间</th>
                    <th coltype="text" width="20%" name="info11">审批状态</th>
                    <th coltype="action" width="20%">查看
                        <input type="hidden" value="查看" coltype="detail" title="查看"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">申请
                        <input type="hidden" coltype="check" title="申请"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">审批
                        <input type="hidden" coltype="search" title="审批"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">审核
                        <input type="hidden" coltype="search" title="审核"  class="h-button" />
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </form>
    <div><msk:button buttonValue="新建" buttonId="TSC10012.SAVE" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC10012.js"></script>

