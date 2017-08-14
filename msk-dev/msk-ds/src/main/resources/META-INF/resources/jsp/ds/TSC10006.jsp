<%-- 
    Title:卖家列表
    author:gyh
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<style type="text/css">
    #file{
        position: absolute;
        right: -15px;
    }
    #button{
        position: absolute;
        right: 150px;
    }
</style>
<div align="center">
	<form action="${ctx}/TSC10006/save" method="post">
		<table id="TSC10006_list_grid" showAddBtn="true" align="center" cellpadding="3" cellspacing="3">
            <tr>
                <td align="center">订单状态：</td>
                <td align="center" width="150px">
                    <select>
                        <option>订单待核销</option>
                        <option>订单已核销</option>
                        <option>合同已核销</option>
                        <option>合同订单核销审批</option>
                        <option>合同结束</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="center">核销合同：</td>
                <td align="center" id="file"><input type="file"/></td>
            </tr>
            <tr align="center">
                <td id="button"><msk:button buttonValue="更改" buttonId="TSC10006.DOWLOAD" buttonType="button"/>
                    <msk:button buttonValue="取消" buttonId="TSC10006.EXIT" buttonType="button"/></td>
            </tr>
		</table>
	</form>
</div>
<script src="${ctx}/js/ds/TSC10006.js"></script>
