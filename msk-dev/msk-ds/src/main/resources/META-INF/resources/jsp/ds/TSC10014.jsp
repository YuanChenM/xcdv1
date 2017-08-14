<%--
    Title:运输明细
    author:cx
    createDate:2016-6-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>

<div class="group-accordion" collapsible="false" active="false">
    <h3>
        <label>运输明细</label>
    </h3>

    <div>
        <table  class="tree dataTable no-footer" showAddBtn="true" id="TSC10014Table">
            <tr>
                <td>备注</td>
                <td colspan="3"></td>
            </tr>
            <tr>
                <td>发货单位名称</td>
                <td colspan="3"></td>
            </tr>
            <tr>
                <td>发货仓库</td>
                <td colspan="3"></td>
            </tr>
            <tr>
                <td>发货执行人</td>
                <td>张三</td>
                <td>联系电话</td>
                <td>12345678912</td>
            </tr>
            <tr>
                <td>运输单位名称</td>
                <td colspan="3">寿光圣沣食品有限公司</td>
            </tr>
            <tr>
                <td>运输单位负责人</td>
                <td>李四</td>
                <td>联系电话</td>
                <td>12312342234</td>
            </tr>
            <tr>
                <td>需方运抵仓库地址</td>
                <td colspan="3">上海市松江区开明路1168号（味硕实业（上海）有限公司）</td>
            </tr>
            <tr>
                <td>仓库负责人</td>
                <td>王五</td>
                <td>联系电话</td>
                <td>12312342234</td>
            </tr>
            <tr>
                <td>验收负责人</td>
                <td>丁六</td>
                <td>联系电话</td>
                <td>12312342234</td>
            </tr>
        </table>
    </div>
</div>
<form action="${ctx}/TSC10014/search" method="post">
    <table id="TSC10014_list_grid" showAddBtn="true" width="100%">
        <thead>
        <tr>
            <th coltype="sno" width="10%">ID</th>
            <th coltype="text" width="10%" name="info1" filter="true">运输编号</th>
            <th coltype="text" width="30%" name="info2" filter="true">车次编号</th>
            <th coltype="text" width="30%" name="info3" filter="true">状态</th>
            <th coltype="text" width="20%" name="info4">预计发货时间</th>
            <th coltype="text" width="20%" name="info5">发货时间</th>
            <th coltype="text" width="20%" name="info6">预计到货时间</th>
            <th coltype="text" width="20%" name="info7">到货时间</th>
            <th coltype="text" width="20%" name="info8">里程（公里）</th>
            <th coltype="text" width="20%" name="info9">产品编码</th>
            <th coltype="text" width="20%" name="info10">产品名称</th>
            <th coltype="text" width="20%" name="info11">规格</th>
            <th coltype="text" width="20%" name="info12">等级</th>
            <th coltype="text" width="20%" name="info13">计划发货数量（箱）</th>
            <th coltype="text" width="20%" name="info14">发货数量（箱）</th>
            <th coltype="text" width="20%" name="info15">发货重量（吨）</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</form>
<script src="${ctx}/js/ds/TSC10014.js"></script>

