<%--
  订单明细修改界面
  User: rwf
  Date: 15/12/23
  Time: 下午3:48
  To change order info
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>

<form action="${ctx}/so/SO15140701/save" id="orderChangeForm" metdod="post" commandName="so14110801Bean"
           modelAttribute="so14110801Bean">
    <input type="hidden" id="returnDetailId" value="${returnDetailId}"/>
    <input type="hidden" id="returnId" value="${returnId}"/>
    <input type="hidden" id="orderId" value="${orderId}"/>
    <table>
        <tr>
        <tr>
            <td coltype="text">产品编码</td>
            <td>${pdCode}</td>
        </tr>
        <tr>
            <td coltype="text">产品名称</td>
            <td>${pdName}</td>
        </tr>
        <td>退货数量</td>
        <td>
            <input type="text" name="returnQty" id="overNum" value="${returnQty}" maxlength="21"/>
            <input type="hidden" value="${returnQty}" id="allNum"/>
        </td>
        </tr>
        <tr>
            <td>
                <msk:button buttonId="SO25110701_SAVE" buttonType="button" buttonValue="保存"/>
            </td>
            <td>
                <msk:button buttonId="SO25110701_CANCEL" buttonType="button" buttonValue="取消"/>
            </td>
        </tr>
    </table>
</form>
<script src="${ctx}/js/so/SO15140701.js"></script>
