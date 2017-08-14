<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div align="center">
    <form action="${ctx}/TSC10003/save" method="post">
        <table id="TSC10003_list_grid" showAddBtn="true" align="center">
            <tr>
                <td align="right">状态更新：</td>
                <td align="left" width="150px">
                    <select>
                        <option>编辑</option>
                        <option>生效</option>
                        <option>作废</option>
                    </select>
                </td>
                <td align="left"><msk:button buttonValue="更改" buttonId="TSC10003.DOWLOAD" buttonType="button"/></td>
            </tr>
            <%--<tr>
                <td align="right"></td>
                <td align="left"><msk:button buttonValue="更改" buttonId="TSC10003.DOWLOAD" buttonType="button"/></td>
            </tr>--%>
        </table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC10003.js"></script>
