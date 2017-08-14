<%--
  订单基本信息Include页面
  User: jiangnan
  Date: 15/12/23
  Time: 下午3:03
  To change this template use File | Settings | File Templates.
  update:gyh
  updateTime:2016.1.5
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion" collapsible="true" active="true">
	<h3>
		<label>订单基本信息</label>
	</h3>
		<table style="width: 100%"  CellSpacing=8>
			<tr>
			 <td width="12.5%" align="right">需求订单编码</td>
			 <td width="12.5%" align="left">${baseOrder.orderCode}</td>
			 <td width="12.5%" align="right">时间编码</td>
             <td width="12.5%" align="left">${baseOrder.orderViceCode}</td>
             <td width="12.5%" align="right">确认订单编码</td>
             <td width="12.5%" align="left">${baseOrder.confirmOrderCode}</td>
             <td width="12.5%" align="right">配送订单编码</td>
             <td align="left">${baseOrder.deliveryOrderCode}</td>
			</tr>
			<tr>
             <!--
            <%-- <td width="12.5%" align="right">物流区</td>
             <td width="12.5%" align="left">${baseOrder.districtCode}</td>
             --%>
             -->
             <td width="12.5%" align="right">物流区</td>
             <td width="12.5%" align="left">${baseOrder.districtName}</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">订单来源</td>
             <td width="12.5%" align="left">${baseOrder.orderSourceName}</td>
             <td width="12.5%" align="right">订单类型</td>
             <td width="12.5%" align="left">${baseOrder.orderTypeName}</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">付款类型</td>
             <td width="12.5%" align="left">${baseOrder.paymentName}</td>
             <td width="12.5%" align="right">订单总金额(元)</td>
             <td width="12.5%" align="left">${baseOrder.orderAmount}</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">是否开发票</td>
             <td width="12.5%" align="left">${baseOrder.needInvoiceName}</td>
             <td width="12.5%" align="right">是否分批发货</td>
             <td width="12.5%" align="left">${baseOrder.splitDeliveryFlg}</td>
             <td width="12.5%" align="right">是否有退货</td>
             <td width="12.5%" align="left">${baseOrder.returnFlgName}</td>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">冻品管家</td>
             <td width="12.5%" align="left">${baseOrder.sellers}</td>
             <td width="12.5%" align="right">订单员</td>
             <td width="12.5%" align="left">${baseOrder.orderTaker}</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
            <tr>
             <td width="12.5%" align="right">订单创建时间</td>
             <td width="12.5%" align="left">${baseOrder.orderDate}</td>
             <td width="12.5%" align="right">状态</td>
             <td width="12.5%" align="left">${baseOrder.orderStatusName}</td>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td width="12.5%"/>
             <td/>
            </tr>
                 <c:if test="${!empty so151402BeanList}">
                     <tr>
                         <td width="12.5%" align="right">子订单</td>
                         <td width="12.5%" align="left" >
                     <c:forEach items="${so151402BeanList}" var="so151402Bean" varStatus="status">
                             <a href="javascript:void(0)" onclick="childOrderIdClick(this)"  value='${so151402Bean.childOrderId}'>${so151402Bean.childOrderCode}</a>
                         <c:if test="${!status.last}">,</c:if>
                     </c:forEach>
                         </td>
                         <td width="12.5%"/>
                         <td width="12.5%"/>
                         <td width="12.5%"/>
                         <td/>
                     </tr>
                 </c:if>
		</table>
</div>

