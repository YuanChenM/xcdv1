<%--
  买家基本信息
  User: jiangnan
  Date: 15/12/23
  Time: 下午3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion" active="false">
	<h3>
		<label>退货人信息</label>
	</h3>
	<form:form>
		<table  style="width: 100%">
			<tr>
				 <td width="12%" align="right">退货买家编码　</td>
	             <td width="12%" align="left">${returnOrderBuyer.buyersCode }</td>
	             <td width="12%" align="right">退货买家名称　</td>
	             <td width="12%" align="left" >${returnOrderBuyer.buyersName }</td>
			</tr>
			<tr>
				 <td width="12%" align="right">退货联系人　</td>
	             <td width="12%" align="left">${returnOrderBuyer.consignee }</td>
	             <td width="12%" align="right">退货人联系电话　</td>
	             <td width="12%" align="left" >${returnOrderBuyer.consigneeMobile }</td>
	             <td width="12%" align="right">退货人联系QQ号　</td>
	             <td width="12%" align="left">${returnOrderBuyer.consigneeQq }</td>
	             <td width="12%" align="right">退货人联系微信号　</td>
	             <td width="12%" align="left" >${returnOrderBuyer.consigneeWeixin }</td>
			</tr>
			<tr>
				 <td width="12%" align="right">退货人省份　</td>
	             <td width="12%" align="left">${returnOrderBuyer.consigneeAddrProvince }</td>
	             <td width="12%" align="right">城市　</td>
	             <td width="12%" align="left" >${returnOrderBuyer.consigneeAddrCity }</td>
	             <td width="12%" align="right">区/街道　</td>
	             <td width="12%" align="left">${returnOrderBuyer.consigneeAddrArea }</td>
			</tr>
			<tr >
				 <td width="12%" align="right">退货人详细地址　</td>
	             <td width="12%" align="left" colspan="3">${returnOrderBuyer.consigneeAddr }</td>
            </tr>
		</table>
	 </form:form>
</div>


