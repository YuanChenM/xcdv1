<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="神农客卖家产品报价" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/SP171129/save" id="SP171129Form" method="post">
        <input type="hidden" name="pricecyclePeriod" value="${sp171129Param.cycleCode}">
        <input type="hidden" name="pdCode" value="${sp171129Param.pdCode}">
        <input type="hidden" name="logiAreaCode" value="${sp171129Param.lgcsCode}">
        <input type="hidden" name="logiAreaName" value="${sp171129Param.lgcsName}">
        <input type="hidden" name="slCode" value="${sp171129Param.slCode}">
        <input type="hidden" name="slName" value="${sp171129Param.slName}">
        <input type="hidden" name="weightVal" value="${sp171129Param.weightVal}">

        <div class="group-accordion" collapsible="" active="false">
            <h3>
                <label>神农客卖家产品报价</label>
            </h3>
            <table WIDTH="100%">
                <tr>
                    <td width="5%" align="left">物流区:</td>
                    <td width="25%" align="left">${sp171129Param.lgcsName}</td>
                    <td width="50%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">价盘期：</td>
                    <td width="55%" align="left">第${sp171129Param.dayAmount}期</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">价盘所属期:</td>
                    <td width="55%" align="left">${sp171129Param.startDate}  ~   ${sp171129Param.endDate}</td>
                    <td width="20%"><td/>
                </tr>
                <tr>
                    <td width="15%" align="left">产品名称：</td>
                    <td width="55%" align="left">${sp171129Param.pdName} ${sp171129Param.machining} ${sp171129Param.feacherName} <c:if test="${sp171129Param.weightVal != 0}" >${sp171129Param.weightVal}kg</c:if> ${sp171129Param.pdLevel}</td>
                    <td width="20%"><td/>
                </tr>
            </table>
        </div>
        <div>
            <table class="dataTable no-footer" id="" style="width: 100%">
                <thead>
                    <tr style="background:#DBDBDB">
                        <th align="center" coltype="text" width="10%" name="" rowspan="2">分销通道及通道等级</th>
                        <th align="center" coltype="text" width="18%" name="" colspan="2" rowspan="1">通道准入标准（按订单起订量）</th>
                        <th align="center" coltype="text" width="8%" name="" rowspan="2">通道等级标准报价平衡系数(%)</th>
                        <th align="center" coltype="text" width="8%" name="" rowspan="2">本期价盘等级系数</th>
                        <th align="center" coltype="text" width="8%" name="" rowspan="2">上期价盘</br>(元/KG)</th>
                        <th align="center" coltype="text" width="8%" name="" rowspan="2">本期报价</br>(元/KG)</th>
                        <th align="center" coltype="text" width="10%" name="" rowspan="2">备注</th>
                    </tr>
                    <tr style="background:#DBDBDB">
                        <th align="center" coltype="text">下限</th>
                        <th align="center" coltype="text">上限</th>
                    </tr>
                </thead>
                <tbody id="SP171129Tbody">
                    <c:choose>
                        <c:when test="${sp171129BeanList eq null}">
                            <tr>
                                <td align="center" colspan="12">
                                    对不起，没有查询到数据！
                                </td>
                            </tr>
                        </c:when>
                        <c:otherwise>
                            <c:forEach items="${sp171129BeanList}" var="item" varStatus="status">
                                <tr>
                                    <td align="center" id="orderLevelCodeTd${status.index}"
                                        style="
                                        <c:choose>
                                        <c:when test="${item.isBidderFlg eq '1'}">
                                                background-color:#AA7428
                                        </c:when>
                                        <c:otherwise>
                                                background-color:#DBDBDB
                                        </c:otherwise>
                                        </c:choose>">
                                        <input type="hidden" name="bp112212Beans[${status.index}].pricecycleDetailId" value="${item.pricecycleDetailId}">
                                        <input type="hidden" name="bp112212Beans[${status.index}].isBidderFlg" value="${item.isBidderFlg}" id="isBidderFlg${status.index}">
                                        <input type="hidden" value="${item.orderLevelCode}" name="sp171129Beans[${status.index}].orderLevelCode" id="orderLevelCode${status.index}"/>
                                        <input type="text" id="orderLevelName${status.index}" name="sp171129Beans[${status.index}].orderLevelName"
                                        style="width: 100%;border-style: solid; border-width: 0;
                                        <c:choose>
                                            <c:when test="${item.isBidderFlg eq '1'}">
                                                ;background-color:#AA7428
                                            </c:when>
                                            <c:otherwise>
                                                ;background-color:#DBDBDB
                                            </c:otherwise>
                                        </c:choose>" value="${item.orderLevelName}" readonly="readonly">
                                    </td>
                                    <td>
                                        <input id="levelStandMin${status.index}" value="${item.levelStandMin}" style="width:100%" name="sp171129Beans[${status.index}].levelStandMin" onchange="levelStandMinChange()" maxlength="19">
                                    </td>
                                    <td style="background-color: #DBDBDB">
                                        <input type="text" id="levelStandMax${status.index}" name="sp171129Beans[${status.index}].levelStandMax" style="border-style: solid; border-width: 0;width: 100%;background-color: #DBDBDB" value="${item.levelStandMax}" readonly="readonly">
                                    </td>
                                    <td style="background-color: #DBDBDB">
                                        <input type="text" id="standardCoefficient${status.index}" name="sp171129Beans[${status.index}].standardCoefficient" style="border-style: solid; border-width: 0;width: 100%;background-color: #DBDBDB" value="${item.standardCoefficient}" readonly="readonly">
                                    </td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${item.orderLevelCode eq '5'}">
                                                <input type="text" id="currentCoefficient${status.index}" name="sp171129Beans[${status.index}].currentCoefficient" style="border-style: solid; border-width: 0;background-color:#AA758B;width: 100%" value="${item.currentCoefficient}" readonly="readonly" maxlength="8">
                                            </c:when>
                                            <c:otherwise>
                                                <input type="text" id="currentCoefficient${status.index}" style="width: 100%" name="sp171129Beans[${status.index}].currentCoefficient" value="${item.currentCoefficient}" onchange="currentCoefficientChange(${status.index})" maxlength="8">
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td style="background-color: #DBDBDB">
                                        <c:if test="${empty item.lastPriceOfKg}">
                                            <input type="text" id="lastPriceOfKg${status.index}" name="sp171129Beans[${status.index}].lastPriceOfKg" style="border-style: solid; border-width: 0;width: 100%;background-color: #DBDBDB" value="0.00" readonly="readonly">
                                        </c:if>
                                        <c:if test="${not empty item.lastPriceOfKg}">
                                            <input type="text" id="lastPriceOfKg${status.index}" name="sp171129Beans[${status.index}].lastPriceOfKg" style="border-style: solid; border-width: 0;width: 100%;background-color: #DBDBDB" value="${item.lastPriceOfKg}" readonly="readonly">
                                        </c:if>
                                    </td>
                                    <td id="priceOfKgTd">
                                        <input type="text" id="priceOfKg${status.index}" name="sp171129Beans[${status.index}].priceOfKg" value="${item.priceOfKg}" onchange="priceOfKgChange(${status.index})"
                                               style="width: 100%
                                        <c:if test="${item.orderLevelCode eq '5'}">
                                               ;background-color:#AA758B
                                        </c:if>" maxlength="7">
                                    </td>
                                    <td>
                                        <input type="text" id="remark${status.index}" name="sp171129Beans[${status.index}].remark" value="${item.remark}" style="width: 100%" maxlength="20">
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </tbody>
            </table>
        </div>
        <msk:button buttonValue="保存" buttonId="SP171129.SAVE" buttonType="button"/>
        <%--<msk:button buttonValue="返回" buttonId="SP171129.BACK" url="${ctx}/SP171129/init" buttonType="button"/>--%>
    </form>
</div>

<script src="${ctx}/js/sp/SP171129.js"></script>
