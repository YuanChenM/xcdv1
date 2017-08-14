<%--
  订单明细供应商修改界面
  User: rwf
  Date: 15/12/23
  Time: 下午3:48
  To change order info
  update:gyh
  updateTime:2016.1.6
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var ORDER_ID = "${soOrderDetailAvailability.orderId}";
</script>
<div class="page-content detail-page" style="width: 400px">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>供应商信息</label>
        </h3>

        <form action="${ctx}/SO151403/save" id="orderChangeForm" metdod="post">
            <input type="hidden" name="orderId" value="${soOrderDetailAvailability.orderId}"/>
            <input type="hidden" name="orderDetailAvailabilityId"
                   value="${soOrderDetailAvailability.orderDetailAvailabilityId}"/>
            <table CellSpacing=10 width="100%">
                <tr>
                    <td>供应商编码:${soOrderDetailAvailability.supplierCode}</td>
                </tr>
                <tr>
                    <td>供应商名称:${soOrderDetailAvailability.supplierName}</td>
                </tr>
                <tr>
                   <%-- <td>供应数量:<input type="text" name="num" value="${soOrderDetailAvailability.suppQty}"/></td>--%>
                    <td>供应数量:<input type="text" name="suppQty" value="${soOrderDetailAvailability.suppQty}" maxlength="21"/></td>
                </tr>
                <tr>
                    <td>发货数量:<input type="text" name="sendQty" value="${soOrderDetailAvailability.sendQty}" maxlength="21"/></td>
                </tr>
                <tr>
                    <td>收货数量:<input type="text" name="receiveQty" value="${soOrderDetailAvailability.receiveQty}" maxlength="21"/></td>
                </tr>
                <tr>
                    <td>取消数量:<input type="text" name="cancelQty" value="${soOrderDetailAvailability.cancelQty}" maxlength="21"/></td>
                </tr>
                <tr>
                    <td>退货数量:<input type="text" name="returnQty" value="${soOrderDetailAvailability.returnQty}" maxlength="21"/></td>
                </tr>
                <tr>
                    <td>拒收数量:<input type="text" name="rejectionQty" value="${soOrderDetailAvailability.rejectionQty}" maxlength="21"/></td>
                </tr>
                <table style="widtd: 100%" id="OM24110201_2">
                    <tr>
                        <td>
                            <msk:button buttonId="SO151403.SAVE" buttonType="button" buttonValue="保存"/>
                        </td>
                        <td>
                            <msk:button buttonId="SO151403.CANCEL" buttonType="button" buttonValue="取消"/>
                        </td>
                    </tr>
                </table>
            </table>
        </form>
    </div>
</div>
<script src="${ctx}/js/so/SO151403.js"></script>
