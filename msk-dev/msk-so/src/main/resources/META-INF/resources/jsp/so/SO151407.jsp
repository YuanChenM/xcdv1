<%--
    Title:退货订单明细
    xhy
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>

<input type="hidden" id="returnId" value="${returnId}"/>
<input type="hidden" id="orderId" value="${orderId}"/>
<input type="hidden" id="returnCode" value="${returnCode}"/>
<style>
    .tree .row_active {
        background-color: #B9D3EE;
    }
</style>
<div class="page-content list-page">
    <!--退货单基本信息  -->
    <div id="baseReturnOrder"></div>
    <!--退货人信息  -->
    <div id="returnBuyers"></div>
    <!-- 订单详情 -->
    <div class="group-accordion" active=false>
        <h3>
            <label>订单详情</label>
        </h3>

        <div>
            <table class="tree dataTable no-footer" style="width: 100% ">
                <tr style="background: #DBDBDB">
                    <td width="9%">期望配送日</td>
                    <td width="9%">产品编码</td>
                    <td width="9%">产品名称</td>
                    <td width="9%">产品规格</td>
                    <td width="9%">包装规格</td>
                    <td width="9%">单件体积(m³/箱)</td>
                    <td width="9%">单价(元/箱)</td>
                    <td width="9%">数量</td>
                    <td width="9%">重量(kg)</td>
                    <td width="9%">体积(m³)</td>
                    <td width="9%">金额(元)</td>
                </tr>

                <!-- 循环退货订单中的所有商品数据 -->
                <c:forEach items="${detailList}" var="detailInfo">
                    <!-- 显示品种类别 和详细信息 -->
                    <tr>
                        <td>${detailInfo.expectedDate}</td>
                        <td>${detailInfo.pdCode}</td>
                        <td>${detailInfo.pdName}</td>
                        <td>${detailInfo.featureName}</td>
                        <!--Modify by wang_jianzhou for Bug#3784 at 2016/11/18 Start.-->
                        <td>${detailInfo.normsName}</td>
                        <!--Modify by wang_jianzhou for Bug#3784 at 2016/11/18 end.-->
                        <td>${detailInfo.packingVolume}</td>
                        <td>${detailInfo.pdPrice}</td>
                        <td>${detailInfo.orderQty}</td>
                        <td>${detailInfo.weight}</td>
                        <td>${detailInfo.volume}</td>
                        <td>${detailInfo.oneAllMoney}</td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="11" align="right">金额合计：${orderAllMoney}　　　</td>
                </tr>
            </table>
        </div>
    </div>

    <!--退货产品信息  -->
    <div class="group-accordion" active=true>
        <h3>
            <label>本次退货记录</label>
        </h3>

        <div>
            <table class="tree dataTable no-footer" style="width: 100% ">
                <tr style="background: #DBDBDB">
                    <td width="10%">产品编码</td>
                    <td width="10%">产品名称</td>
                    <td width="10%">产品规格</td>
                    <td width="10%">包装规格</td>
                    <td width="10%">单件体积(m³/箱)</td>
                    <td width="10%">单价(元/箱)</td>
                    <td width="10%">退货数量</td>
                    <td width="10%">重量(kg)</td>
                    <td width="10%">体积(m³)</td>
                    <td width="2px">操作</td>
                </tr>

                <!-- 循环退货订单中的所有商品数据 -->
                <c:forEach items="${returnGoodsList}" var="returnGoods2">
                    <!-- 显示品种类别 和详细信息 -->
                    <tr>

                        <td>${returnGoods2.pdCode}</td>
                        <td>${returnGoods2.pdName}</td>
                        <td>${returnGoods2.featureName}</td>
                        <!--Modify by wang_jianzhou for Bug#3784 at 2016/11/18 Start.-->
                        <td>${returnGoods2.normsName}</td>
                        <!--Modify by wang_jianzhou for Bug#3784 at 2016/11/18 end.-->
                        <td>${returnGoods2.packingVolume}</td>
                        <td>${returnGoods2.pdPrice}</td>
                        <td>
                            ${returnGoods2.returnQty}
                        </td>
                        <td>${returnGoods2.weight}</td>
                        <td>${returnGoods2.volume}</td>
                        <td>
                            <msk:roleArea pageCode="SO151407" areaCode="EDIT" needAuth="true">
                                <img alt="编辑" name="SO251107" pdCode="${returnGoods2.pdCode}"
                                     pdName="${returnGoods2.pdName}" returnQty="${returnGoods2.returnQty}"
                                     returnDetailId="${returnGoods2.returnDetailId}"
                                     src="${ctx}/static/core/images/action/edit.png"
                                     title="编辑">
                            </msk:roleArea>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <%--<msk:button buttonValue="打印退货单" buttonId="SO151407.PRINT" buttonType="button"/>--%>
    <%--<msk:button buttonValue="完成退货" buttonId="SO151407.OVER" buttonType="button"/>--%>
    <%--<msk:button buttonValue="返回" buttonId="SO151407.BACK" buttonType="button" url="${ctx}/SO151406/init"/></td>--%>
</div>
<script src="${ctx}/js/so/SO151407.js"></script>

