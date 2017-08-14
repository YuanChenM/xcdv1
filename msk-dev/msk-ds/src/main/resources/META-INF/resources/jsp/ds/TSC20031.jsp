<%-- 
    Title:发货单一览
    author:gyh
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="生产商发货单管理" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC20021/search" method="post">
        <table id="TSC20031_list_grid" showAddBtn="true" width="100%">
            <thead>
            <th coltype="sno" width="10%">ID</th>
            <th coltype="text" width="10%" name="info1" filter="true">发货单编号</th>
            <th coltype="text" width="10%" name="contractNumber" filter="true">合同编号</th>
            <th coltype="text" width="30%" name="contractName" filter="true">合同名称</th>
            <th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>
            <th coltype="text" width="20%" name="contractDate">发货时间要求</th>
            <th coltype="select" align="center" name="info2">发货负责人</th>
            <th coltype="text" width="20%" name="info3">运输负责人</th>
            <th coltype="text" width="20%" name="info4">运抵仓库</th>
            <th coltype="action">发货单详细
                <input type="hidden" coltype="detail" title="发货单详细" class="h-button"/>
            </th>
            <%--<tr>--%>
            <%--<th coltype="sno" width="10%">ID</th>--%>
            <%--<th coltype="text" width="20%" name="contractNumber" filter="true">合同编号</th>--%>
            <%--<th coltype="text" width="30%" name="contractName" filter="true">合同名称</th>--%>
            <%--<th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>--%>
            <%--<th coltype="text" width="30%" name="contractDate" filter="true">合同生效日期</th>--%>
            <%--<th coltype="select" width="30%" name="status" filter="true">状态--%>
            <%--<select>--%>
            <%--<option value="0">未核销</option>--%>
            <%--<option value="1">已核销</option>--%>
            <%--</select>--%>
            <%--</th>--%>
            <%--<th coltype="action" width="20%">发货单--%>
            <%--<input type="hidden" value="发货单" coltype="detail" title="发货单"  class="h-button" />--%>
            <%--</th>--%>
            <%--</tr>--%>
            </thead>
            <tbody>
            </tbody>
        </table>
        <table>
            <tr align="left"><msk:button buttonValue="新建" buttonId="TSC20031.NEW" buttonType="button"/>
                <%--<msk:button buttonValue="模板下载" buttonId="TSC20031.DOWLOAD" buttonType="button"/></tr>--%>
        </table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC20031.js"></script>
