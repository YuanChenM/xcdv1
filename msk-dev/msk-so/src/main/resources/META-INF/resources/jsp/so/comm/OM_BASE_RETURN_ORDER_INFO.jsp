<%--
  订单基本信息Include页面
  User: xhy
  Date: 15/12/24
  Time: 下午5:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion" collapsible="true" active="true">
   <h3>
		<label>退货单基本信息</label>
   </h3>
	<form:form>
		<table  style="widtd: 100%" CellSpacing=10 >
			<tr>
				 <td width="4.2%" align="right">退货单编码　</td>
	             <td width="10%" align="left">${returnOrder.returnCode}</td>
	             <td width="10%" align="right">订单编码　</td>
	             <td width="10%" align="left" >${returnOrder.orderCode}</td>
	        </tr>     
			<tr>
				 <td width="4.2%" align="right">退货单来源　</td>
	             <td width="10%" align="left">${returnOrder.returnSource}</td>
			</tr>
			<tr>
				 <td width="4.2%" align="right">退货方式　</td>
	             <td width="10%" align="left">${returnOrder.refundMode}</td>
	             <td width="10%" align="right">退货总金额(元)　</td>
	             <td width="10%" align="left" >${returnOrder.returnAmount}</td>
			</tr>
			<tr>
				 <td width="4.2%" align="right">是否已开发票　</td>
	             <td width="10%" align="left">${returnOrder.isInvoice}</td>
	             <td width="10%" align="right">是否已付款　</td>
	             <td width="10%" align="left" >${returnOrder.isPaid}</td>
			</tr>
			<tr>
				 <td width="4.2%" align="right">退货处理人　</td>
	             <td width="10%" align="left">${returnOrder.returnActor}</td>
	             <td width="10%" align="right">退货单状态　</td>
	             <td width="10%" align="left" >${returnOrder.returnStatusName}</td>
            </tr>
            <tr>
	             <td width="4.2%" align="right">退货单申请时间　</td>
	             <td width="10%" align="left">${returnOrder.returnTime}</td>
	             <td width="10%" align="right">退货原因　</td>
	             <td width="10%" align="left"  colspan="2">${returnOrder.returnReasonCode}</td>
            </tr>
            <tr>
	             <td width="4.2%" align="right">退货申请备注　</td>
	             <td width="10%" align="left" colspan="2">${returnOrder.returnGoodsAllMoney}</td>
            </tr>
		</table>
	</form:form>
</div>


