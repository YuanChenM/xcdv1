<%-- 
    Title:发货计划列表
    author:gyh
    createDate:2016-6-14
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发货计划管理" backTitleArray="合同管理" backUrlArray="${ctx}/TSC10004/init"></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC20038/search" method="post">
        <table id="TSC20021_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <th coltype="sno" width="10%">ID</th>
                <th coltype="text" width="10%" name="info1" filter="true">发货计划编号</th>
                <th coltype="text" width="10%" name="contractNumber">合同编号</th>
                <th coltype="text" width="30%" name="contractName">合同名称</th>
                <th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>
                <th coltype="text" width="20%" name="contractDate">合同生效日期</th>
                <th coltype="select" align="center" name="status" filter="true">　　状态　　
                    <select>
                        <option value="0">未核销</option>
                        <option value="1">已核销</option>
                    </select>
                </th>
                <th coltype="action">发货计划详细
                    <input type="hidden" coltype="detail" title="发货计划详细" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <div><msk:button buttonValue="新建" buttonId="TSC20021.SAVE" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC20021.js"></script>
