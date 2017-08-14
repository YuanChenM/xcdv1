<%--
   Title:买手囤货库存
   author:sjj
   createDate:2017-3-6
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="买手囤货库存余额导出" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">
    <form id="SO151413Form" method="post">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>
            <table>
                <tr>
                    <td coltype="text" width="15%" align="right">买手名称</td>
                    <td><input type="text" id="slShowName"/></td>
                    <td coltype="text" width="15%" align="right">产品编码</td>
                    <td><input type="text" id="pdCode"/></td>
                    <td width="5%"></td>
                    <td>
                        <msk:button buttonValue="导出EXECL" buttonId="SO151413.EXPORT" buttonType="button" align="left"/>
                    </td>
                    <td width="50%"></td>
                </tr>
            </table>
        </div>
    </form>
</div>
<script src="${ctx}/js/so/SO151413.js"></script>