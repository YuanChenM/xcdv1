<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<div class="page-header">
    <span class="page-title">
        <text>卖家产品月度在线控制表详细</text>
    </span>
</div>
    <div class="page-content list-page">
    <div>
        <table class="tree dataTable no-footer" style="width: 100%">
            <thead>
            </thead>
            <tbody>
            <tr>
                <td rowspan="2" name="sellerName" align="center">卖家</td>
                <td rowspan="2" name="sellerCode" align="center">产品</td>
                <td colspan="8" align="center">当月21-25号</td>
                <td colspan="8" align="center">当月26-月末</td>
                <td colspan="8" align="center">下月1-5号</td>
                <td colspan="8" align="center">下月6-10号</td>
                <td colspan="8" align="center">下月11-15号</td>
                <td colspan="8" align="center">下月16-20号</td>
                <td colspan="8" align="center">下月21-25号</td>
                <td colspan="8" align="center">下月26-月末</td>
            </tr>
            <tr>
                <td name="totalPlanProductionQty_1" align="center">计划生产量</td>
                <td name="totalActualProductionQty_1" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_1" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_1" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_1" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_1" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_1" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_1" align="center">实际入销售库量</td>
                <td name="totalPlanProductionQty_2" align="center">计划生产量</td>
                <td name="totalActualProductionQty_2" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_2" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_2" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_2" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_2" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_2" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_2" align="center">实际入销售库量</td>
                <td name="totalPlanProductionQty_3" align="center">计划生产量</td>
                <td name="totalActualProductionQty_3" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_3" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_3" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_3" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_3" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_3" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_3" align="center">实际入销售库量</td>
                <td name="totalPlanProductionQty_4" align="center">计划生产量</td>
                <td name="totalActualProductionQty_4" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_4" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_4" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_4" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_4" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_4" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_4" align="center">实际入销售库量</td>
                <td name="totalPlanProductionQty_5" align="center">计划生产量</td>
                <td name="totalActualProductionQty_5" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_5" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_5" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_5" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_5" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_5" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_5" align="center">实际入销售库量</td>
                <td name="totalPlanProductionQty_6" align="center">计划生产量</td>
                <td name="totalActualProductionQty_6" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_6" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_6" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_6" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_6" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_6" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_6" align="center">实际入销售库量</td>
                <td name="totalPlanProductionQty_7" align="center">计划生产量</td>
                <td name="totalActualProductionQty_7" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_7" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_7" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_7" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_7" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_7" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_7" align="center">实际入销售库量</td>
                <td name="totalPlanProductionQty_8" align="center">计划生产量</td>
                <td name="totalActualProductionQty_8" align="center">实际生产量</td>
                <td name="totalPlanWaitTranSportQty_8" align="center">计划待运量</td>
                <td name="totalActualWaitTranSportQty_8" align="center">实际待运量</td>
                <td name="totalPlanOnWayQty_8" align="center">计划在途量</td>
                <td name="totalActualOnWayQty_8" align="center">实际在途量</td>
                <td name="totalPlanWaitStorageQty_8" align="center">计划入销售库量</td>
                <td name="totalActualPlanWaitStorageQty_8" align="center">实际入销售库量</td>
            </tr>
            <c:forEach items="${sellerList}" var="seller" varStatus="i">
                <!-- 显示品种类别         -->
                <tr class="treegrid-${seller.sellerCode}" style="background:#DBDBDB">
                    <td >${seller.sellerName}</td>
                    <td></td>
                    <td>${seller.totalPlanProductionQty_1}</td>
                    <td>${seller.totalActualProductionQty_1}</td>
                    <td>${seller.totalPlanWaitTranSportQty_1}</td>
                    <td>${seller.totalActualWaitTranSportQty_1}</td>
                    <td>${seller.totalPlanOnWayQty_1}</td>
                    <td>${seller.totalActualOnWayQty_1}</td>
                    <td>${seller.totalPlanWaitStorageQty_1}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_1}</td>
                    <td>${seller.totalPlanProductionQty_2}</td>
                    <td>${seller.totalActualProductionQty_2}</td>
                    <td>${seller.totalPlanWaitTranSportQty_2}</td>
                    <td>${seller.totalActualWaitTranSportQty_2}</td>
                    <td>${seller.totalPlanOnWayQty_2}</td>
                    <td>${seller.totalActualOnWayQty_2}</td>
                    <td>${seller.totalPlanWaitStorageQty_2}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_2}</td>
                    <td>${seller.totalPlanProductionQty_3}</td>
                    <td>${seller.totalActualProductionQty_3}</td>
                    <td>${seller.totalPlanWaitTranSportQty_3}</td>
                    <td>${seller.totalActualWaitTranSportQty_3}</td>
                    <td>${seller.totalPlanOnWayQty_3}</td>
                    <td>${seller.totalActualOnWayQty_3}</td>
                    <td>${seller.totalPlanWaitStorageQty_3}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_3}</td>
                    <td>${seller.totalPlanProductionQty_4}</td>
                    <td>${seller.totalActualProductionQty_4}</td>
                    <td>${seller.totalPlanWaitTranSportQty_4}</td>
                    <td>${seller.totalActualWaitTranSportQty_4}</td>
                    <td>${seller.totalPlanOnWayQty_4}</td>
                    <td>${seller.totalActualOnWayQty_4}</td>
                    <td>${seller.totalPlanWaitStorageQty_4}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_4}</td>
                    <td>${seller.totalPlanProductionQty_5}</td>
                    <td>${seller.totalActualProductionQty_5}</td>
                    <td>${seller.totalPlanWaitTranSportQty_5}</td>
                    <td>${seller.totalActualWaitTranSportQty_5}</td>
                    <td>${seller.totalPlanOnWayQty_5}</td>
                    <td>${seller.totalActualOnWayQty_5}</td>
                    <td>${seller.totalPlanWaitStorageQty_5}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_5}</td>
                    <td>${seller.totalPlanProductionQty_6}</td>
                    <td>${seller.totalActualProductionQty_6}</td>
                    <td>${seller.totalPlanWaitTranSportQty_6}</td>
                    <td>${seller.totalActualWaitTranSportQty_6}</td>
                    <td>${seller.totalPlanOnWayQty_6}</td>
                    <td>${seller.totalActualOnWayQty_6}</td>
                    <td>${seller.totalPlanWaitStorageQty_6}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_6}</td>
                    <td>${seller.totalPlanProductionQty_7}</td>
                    <td>${seller.totalActualProductionQty_7}</td>
                    <td>${seller.totalPlanWaitTranSportQty_7}</td>
                    <td>${seller.totalActualWaitTranSportQty_7}</td>
                    <td>${seller.totalPlanOnWayQty_7}</td>
                    <td>${seller.totalActualOnWayQty_7}</td>
                    <td>${seller.totalPlanWaitStorageQty_7}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_7}</td>
                    <td>${seller.totalPlanProductionQty_8}</td>
                    <td>${seller.totalActualProductionQty_8}</td>
                    <td>${seller.totalPlanWaitTranSportQty_8}</td>
                    <td>${seller.totalActualWaitTranSportQty_8}</td>
                    <td>${seller.totalPlanOnWayQty_8}</td>
                    <td>${seller.totalActualOnWayQty_8}</td>
                    <td>${seller.totalPlanWaitStorageQty_8}</td>
                    <td>${seller.totalActualPlanWaitStorageQty_8}</td>
                </tr>
                <!--  循环显示产品 -->
                <c:forEach items="${seller.productList}" var="product"  varStatus="j">
                    <tr class="treegrid-${i.index}-${j.index} treegrid-parent-${product.sellerCode}">
                        <td></td>
                        <td>${product.productName}</td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_1}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_2}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_3}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_4}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_5}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_6}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_7}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanProductionQty_8}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualProductionQty_8}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitTranSportQty_8}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualWaitTranSportQty_8}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanOnWayQty_8}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualOnWayQty_8}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103P" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalPlanWaitStorageQty_8}</a></td>
                        <td><a href="javascript:void(0)" name="DS173103A" sellerCode="${product.sellerCode}" productCode="${product.productCode}">${product.totalActualPlanWaitStorageQty_8}</a></td>
                    </tr>
                </c:forEach>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173103.js"></script>

