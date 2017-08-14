<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var ORDER_ID = "${soOrderDetailAvailability.orderId}";
</script>
<div class="page-content detail-page" style="width: 400px">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>订单明细信息</label>
        </h3>

        <form action="${ctx}/SO151404/save" id="orderDetailChangeForm" metdod="post">
            <input type="hidden" name="orderDetailId" value="${orderDetailId}"/>
            <input type="hidden" name="orderId" value="${orderId}"/>
            <table CellSpacing=10 width="100%">
                <tr>
                    <td>单价(元/箱):<input type="text" name="pdPrice" value="${orderDetail.pdPrice}" maxlength="11"/></td>
                </tr>
                <table style="widtd: 100%" id="OM24110201_2">
                    <tr>
                        <td>
                            <msk:button buttonId="SO151404.SAVE" buttonType="button" buttonValue="保存"/>
                        </td>
                        <td>
                            <msk:button buttonId="SO151404.CANCEL" buttonType="button" buttonValue="取消"/>
                        </td>
                    </tr>
                </table>
            </table>
        </form>
    </div>
</div>
<script src="${ctx}/static/so/js/SO151404.js"></script>
