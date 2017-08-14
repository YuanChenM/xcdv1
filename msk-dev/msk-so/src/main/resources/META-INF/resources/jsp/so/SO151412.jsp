<%--
   Title:领地买手销售订单
   author:sjj
   createDate:2017-3-6
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="领地买手销售订单汇总导出" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">
    <form id="SO151413Form" method="post">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>
            <table>
                <tr>
                    <td width="10%" align="right">领地名称</td>
                    <td><input type="text" id="demesne"/></td>
                    <td width="13%" coltype="text" align="right">买手名称</td>
                    <td><input type="text" id="slShowName"/></td>
                    <td width="13%" coltype="text" align="right">产品编码</td>
                    <td><input type="text" id="pdCode"/></td>
                    <td width="14%" coltype="text" align="right">订单创建时间</td>
                    <td>
                        <input type="text" id="startTime" readonly="readonly"/>
                        &emsp;~&emsp;
                        <input type="text" id="endTime" readonly="readonly"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="8"></td>
                    <td>
                        <msk:button buttonValue="导出EXECL" buttonId="SO151412.EXPORT" buttonType="button" align="left"/>
                    </td>
                </tr>
            </table>
        </div>
    </form>

</div>
<script src="${ctx}/js/so/SO151412.js"></script>