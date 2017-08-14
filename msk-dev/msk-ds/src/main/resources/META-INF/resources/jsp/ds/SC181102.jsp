<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="供应商月度管控表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="" active="false">
        <h3>
            <label>查询条件</label>
        </h3>
        <form:form action="${ctx}/SC181102/init" id="SC181102Form" method="post">
            <input type="hidden" name="currenthalfCode" id="currenthalfCode" value="${halfParam.currentHalfCode}"/>

            <table width="100%">
                <tbody>
                <tr>
                    <td width="10%" align="right">分销月度</td>
                    <td align="left">
                        <select name="distMonth" id="distMonth">
                            <c:forEach items="${distMonth.distMonthList}" var="dist">
                                <c:choose>
                                    <c:when test="${halfParam.distMonth eq dist.distMonth}">
                                        <option value="${dist.distMonth}" selected>${dist.distMonth}</option>
                                        <%-- <option value="201602" selected>201602</option>--%>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dist.distMonth}">${dist.distMonth}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="10%" align="right">地区</td>
                    <td align="left">
                        <select name="areaCode" id="areaCode">
                                <%--<option value='-1'>--请选择--</option>--%>
                            <c:forEach items="${halfParam.areaInfoList}" var="areaInfo">
                                <c:choose>
                                    <c:when test="${halfParam.areaCode eq areaInfo.areaCode}">
                                        <option value="${areaInfo.areaCode}" selected>${areaInfo.areaName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${areaInfo.areaCode}">${areaInfo.areaName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="8%" align="right">供应商</td>
                    <td align="left">
                        <select name="supplierCode" id="supplierCode">
                                <%--<option value='-1'>--请选择--</option>--%>
                            <c:forEach items="${halfParam.supplierInfoList}" var="suppInfo">
                                <c:choose>
                                    <c:when test="${halfParam.supplierCode eq suppInfo.supplierCode}">
                                        <option value="${suppInfo.supplierCode}" selected>${suppInfo.supplierName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${suppInfo.supplierCode}">${suppInfo.supplierName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="8%" align="right">产品</td>
                    <td align="left">
                        <input type="text" name="productName" id="productName" value="${halfParam.productName}" onkeydown="if(event.keyCode==13) return false;"/>
                            <%--<input name="productName" id="productName" value="${halfParam.productName}"/>--%>
                    </td>
                    <td align="left"><msk:button buttonValue="查询" buttonId="SC181102.SEARCH" buttonType="button"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>生产期产品管控</label>
        </h3>
        <div>
            <table class="dataTable no-footer" id="SC181102ProductTable" style="width: 100%">
                <thead>
                <tr style="background:#DBDBDB">
                    <th rowspan="2" colspan="2"></th>
                    <th colspan="2">${halfParam.dataSelectBefore}</th>
                    <th colspan="4">${halfParam.dataSelect}</th>
                    <th rowspan="2">合计</th>
                </tr>
                <tr style="background:#DBDBDB">
                    <c:forEach items="${halfParam.halfNameList}" var="halfName">
                        <th>${halfName.halfName}</th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="3"></td>
                    <td>需求数量</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('1')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumOrigPlanNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumOrigPlanNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('1')}">
                            <td>${productSumSumNum.sumSumOrigPlanNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>计划</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('1')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumPlanNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumPlanNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('1')}">
                            <td>${productSumSumNum.sumSumPlanNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>实际</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('1')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumActualNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumActualNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('1')}">
                            <td>${productSumSumNum.sumSumActualNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <c:forEach items="${productNum.productList}" var="product">
                    <c:if test="${product.planType eq ('1')}">
                        <tr>
                            <td rowspan="3">${product.productName}</td>
                            <td>需求数量</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('1') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <td style="background-color: #FDB">${productNum.origPlanNum}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.origPlanNum}</td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumOrigPlanNum}</td>
                        </tr>
                        <tr>
                            <td>计划</td>
                            <c:set var="productNumIndex" value="0"></c:set>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('1') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <c:set var="productNumIndex" value="${productNumIndex+1}"/>
                                            <td style="background-color: #FDB">${productNum.newPlanNum}</td>
                                        </c:when>
                                        <c:when test="${halfParam.currentHalfCode > productNum.halfCode}">
                                            <c:set var="productNumIndex" value="${productNumIndex+1}"/>
                                            <td>${productNum.newPlanNum}</td>
                                        </c:when>
                                        <%--                                    <c:when test="${productNum.halfCode == 6}">
                                                                                <c:set var="productNumIndex" value="${productNumIndex+1}"/>
                                                                                <td>${productNum.newPlanNum}</td>
                                                                            </c:when>--%>
                                        <c:otherwise>
                                            <c:set var="productNumIndex" value="${productNumIndex+1}"/>
                                            <td>${productNum.newPlanNum}&nbsp;&nbsp;
                                                <c:choose>
                                                    <c:when test="${userType eq ('2')}">
                                                        <msk:button buttonValue="计划调整" name="SC181102Plan_${productNum.productName}_${productNum.halfCode}_1" buttonId="SC181102Plan_${productNum.productCode}_${productNum.halfCode}_1" buttonType="button" />
                                                    </c:when>
                                                    <c:otherwise>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <c:if test="${productNumIndex==5}">
                                <td>0</td>
                            </c:if>

                            <td>${product.sumPlanNum}</td>
                        </tr>
                        <tr>
                            <td>实际</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('1') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <c:choose>
                                                <c:when test="${productNum.halfCode == 6}">
                                                    <td style="background-color: #FDB">${productNum.newActualNum}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td style="background-color: #FDB">${productNum.newActualNum}&nbsp;&nbsp;
                                                        <c:choose>
                                                            <c:when test="${userType eq ('2')}">
                                                                <msk:button buttonValue="实际录入" name="SC181102Actual_${productNum.productName}_${productNum.halfCode}_1" buttonId="SC181102Actual_${productNum.productCode}_${productNum.halfCode}_1" buttonType="button" />
                                                            </c:when>
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.newActualNum}</td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumActualNum}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>待运库产品管控</label>
        </h3>
        <div>
            <table class="dataTable no-footer" style="width: 100%">
                <thead>
                <tr style="background:#DBDBDB">
                    <th rowspan="2" colspan="2"></th>
                    <th colspan="2">${halfParam.dataSelectBefore}</th>
                    <th colspan="4">${halfParam.dataSelect}</th>
                    <th rowspan="2">合计</th>
                </tr>
                <tr style="background:#DBDBDB">
                    <c:forEach items="${halfParam.halfNameList}" var="halfName">
                        <th>${halfName.halfName}</th>
                    </c:forEach>
                </tr>
                </thead>
                <t>
                    <tr>
                        <td rowspan="3"></td>
                        <td>需求数量</td>
                        <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                            <c:if test="${productSumNum.planType eq ('2')}">
                                <c:choose>
                                    <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                        <td style="background-color: #FDB">${productSumNum.sumOrigPlanNum}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${productSumNum.sumOrigPlanNum}</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                            <c:if test="${productSumSumNum.planType eq ('2')}">
                                <td>${productSumSumNum.sumSumOrigPlanNum}</td>
                            </c:if>
                        </c:forEach>
                    </tr>
                    <tr>
                        <td>计划</td>
                        <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                            <c:if test="${productSumNum.planType eq ('2')}">
                                <c:choose>
                                    <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                        <td style="background-color: #FDB">${productSumNum.sumPlanNum}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${productSumNum.sumPlanNum}</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                            <c:if test="${productSumSumNum.planType eq ('2')}">
                                <td>${productSumSumNum.sumSumPlanNum}</td>
                            </c:if>
                        </c:forEach>
                    </tr>
                    <tr>
                        <td>实际</td>
                        <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                            <c:if test="${productSumNum.planType eq ('2')}">
                                <c:choose>
                                    <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                        <td style="background-color: #FDB">${productSumNum.sumActualNum}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${productSumNum.sumActualNum}</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                            <c:if test="${productSumSumNum.planType eq ('2')}">
                                <td>${productSumSumNum.sumSumActualNum}</td>
                            </c:if>
                        </c:forEach>
                    </tr>
                    <c:forEach items="${productNum.productList}" var="product">
                    <c:if test="${product.planType eq ('2')}">
                    <tr>
                        <td rowspan="3">${product.productName}</td>
                        <td>需求数量</td>
                        <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                            <c:if test="${productNum.planType eq ('2') && product.productName eq(productNum.productName)}">
                                <c:choose>
                                    <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                        <td style="background-color: #FDB">${productNum.origPlanNum}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${productNum.origPlanNum}</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <td>${product.sumOrigPlanNum}</td>
                    </tr>
                    <tr>
                        <td>计划</td>
                        <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                            <c:if test="${productNum.planType eq ('2') && product.productName eq(productNum.productName)}">
                                <c:choose>
                                    <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                        <td style="background-color: #FDB">${productNum.newPlanNum}</td>
                                    </c:when>
                                    <c:when test="${productNum.halfCode == 1}">
                                        <td>${productNum.newPlanNum}</td>
                                    </c:when>
                                    <c:when test="${halfParam.currentHalfCode > productNum.halfCode}">
                                        <td>${productNum.newPlanNum}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${productNum.newPlanNum}&nbsp;&nbsp;
                                            <c:choose>
                                                <c:when test="${userType eq ('2')}">
                                                    <msk:button buttonValue="计划调整" name="SC181102Plan_${productNum.productName}_${productNum.halfCode}_2" buttonId="SC181102Plan_${productNum.productCode}_${productNum.halfCode}_2" buttonType="button" />
                                                </c:when>
                                                <c:otherwise>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <td>${product.sumPlanNum}</td>
                    </tr>
                    <tr>
                        <td>实际</td>
                        <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                            <c:if test="${productNum.planType eq ('2') && product.productName eq(productNum.productName)}">
                                <c:choose>
                                    <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                        <c:choose>
                                            <c:when test="${productNum.halfCode == 1}">
                                                <td style="background-color: #FDB">${productNum.newActualNum}</td>
                                            </c:when>
                                            <c:otherwise>
                                                <td style="background-color: #FDB">${productNum.newActualNum}&nbsp;&nbsp;
                                                    <c:choose>
                                                        <c:when test="${userType eq ('2')}">
                                                            <msk:button buttonValue="实际录入" name="SC181102Actual_${productNum.productName}_${productNum.halfCode}_2" buttonId="SC181102Actual_${productNum.productCode}_${productNum.halfCode}_2" buttonType="button" />
                                                        </c:when>
                                                        <c:otherwise>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${productNum.newActualNum}</td>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </c:forEach>
                        <td>${product.sumActualNum}</td>
                    </tr>
                    </c:if>
                    </c:forEach>
                    </tbody>
            </table>
        </div>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>在途产品管控</label>
        </h3>
        <div>
            <table class="dataTable no-footer" style="width: 100%">
                <thead>
                <tr style="background:#DBDBDB">
                    <th rowspan="2" colspan="2"></th>
                    <th colspan="2">${halfParam.dataSelectBefore}</th>
                    <th colspan="4">${halfParam.dataSelect}</th>
                    <th rowspan="2">合计</th>
                </tr>
                <tr style="background:#DBDBDB">
                    <c:forEach items="${halfParam.halfNameList}" var="halfName">
                        <th>${halfName.halfName}</th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="3"></td>
                    <td>需求数量</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('3')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumOrigPlanNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumOrigPlanNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('3')}">
                            <td>${productSumSumNum.sumSumOrigPlanNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>计划</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('3')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumPlanNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumPlanNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('3')}">
                            <td>${productSumSumNum.sumSumPlanNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>实际</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('3')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumActualNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumActualNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('3')}">
                            <td>${productSumSumNum.sumSumActualNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <c:forEach items="${productNum.productList}" var="product">
                    <c:if test="${product.planType eq ('3')}">
                        <tr>
                            <td rowspan="3">${product.productName}</td>
                            <td>需求数量</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('3') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <td style="background-color: #FDB">${productNum.origPlanNum}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.origPlanNum}</td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumOrigPlanNum}</td>
                        </tr>
                        <tr>
                            <td>计划</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('3') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <td style="background-color: #FDB">${productNum.newPlanNum}</td>
                                        </c:when>
                                        <c:when test="${productNum.halfCode == 1}">
                                            <td>${productNum.newActualNum}</td>
                                        </c:when>
                                        <c:when test="${halfParam.currentHalfCode > productNum.halfCode}">
                                            <td>${productNum.newPlanNum}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.newPlanNum}&nbsp;&nbsp;
                                                <c:choose>
                                                    <c:when test="${userType eq ('2')}">
                                                        <msk:button buttonValue="计划调整" name="SC181102Plan_${productNum.productName}_${productNum.halfCode}_3" buttonId="SC181102Plan_${productNum.productCode}_${productNum.halfCode}_3" buttonType="button" />
                                                    </c:when>
                                                    <c:otherwise>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumPlanNum}</td>
                        </tr>
                        <tr>
                            <td>实际</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('3') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <c:choose>
                                                <c:when test="${productNum.halfCode == 1}">
                                                    <td style="background-color: #FDB">${productNum.newActualNum}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td style="background-color: #FDB">${productNum.newActualNum}&nbsp;&nbsp;
                                                        <c:choose>
                                                            <c:when test="${userType eq ('2')}">
                                                                <msk:button buttonValue="实际录入" name="SC181102Actual_${productNum.productName}_${productNum.halfCode}_3" buttonId="SC181102Actual_${productNum.productCode}_${productNum.halfCode}_3" buttonType="button" />
                                                            </c:when>
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.newActualNum}</td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumActualNum}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>入销售库产品管控</label>
        </h3>
        <div>
            <table class="dataTable no-footer" style="width: 100%">
                <thead>
                <tr style="background:#DBDBDB">
                    <th rowspan="2" colspan="2"></th>
                    <th colspan="2">${halfParam.dataSelectBefore}</th>
                    <th colspan="4">${halfParam.dataSelect}</th>
                    <th rowspan="2">合计</th>
                </tr>
                <tr style="background:#DBDBDB">
                    <c:forEach items="${halfParam.halfNameList}" var="halfName">
                        <th>${halfName.halfName}</th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="3"></td>
                    <td>需求数量</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('4')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumOrigPlanNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumOrigPlanNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('4')}">
                            <td>${productSumSumNum.sumSumOrigPlanNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>计划</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('4')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumPlanNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumPlanNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('4')}">
                            <td>${productSumSumNum.sumSumPlanNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <tr>
                    <td>实际</td>
                    <c:forEach items="${productSumNum.productSumNumList}" var="productSumNum" varStatus="i">
                        <c:if test="${productSumNum.planType eq ('4')}">
                            <c:choose>
                                <c:when test="${halfParam.currentHalfCode == i.index + 1}">
                                    <td style="background-color: #FDB">${productSumNum.sumActualNum}</td>
                                </c:when>
                                <c:otherwise>
                                    <td>${productSumNum.sumActualNum}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
                    </c:forEach>
                    <c:forEach items="${productSumNum.productSumSumNumList}" var="productSumSumNum">
                        <c:if test="${productSumSumNum.planType eq ('4')}">
                            <td>${productSumSumNum.sumSumActualNum}</td>
                        </c:if>
                    </c:forEach>
                </tr>
                <c:forEach items="${productNum.productList}" var="product">
                    <c:if test="${product.planType eq ('4')}">
                        <tr>
                            <td rowspan="3">${product.productName}</td>
                            <td>需求数量</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('4') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <td style="background-color: #FDB">${productNum.origPlanNum}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.origPlanNum}</td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumOrigPlanNum}</td>
                        </tr>
                        <tr>
                            <td>计划</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('4') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <td style="background-color: #FDB">${productNum.newPlanNum}</td>
                                        </c:when>
                                        <c:when test="${productNum.halfCode == 1}">
                                            <td>${productNum.newActualNum}</td>
                                        </c:when>
                                        <c:when test="${halfParam.currentHalfCode > productNum.halfCode}">
                                            <td>${productNum.newPlanNum}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.newPlanNum}&nbsp;&nbsp;
                                                <c:choose>
                                                    <c:when test="${userType eq ('2')}">
                                                        <msk:button buttonValue="计划调整" name="SC181102Plan_${productNum.productName}_${productNum.halfCode}_4" buttonId="SC181102Plan_${productNum.productCode}_${productNum.halfCode}_4" buttonType="button" />
                                                    </c:when>
                                                    <c:otherwise>
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumPlanNum}</td>
                        </tr>
                        <tr>
                            <td>实际</td>
                            <c:forEach items="${productNum.productNumList}" var="productNum" varStatus="i">
                                <c:if test="${productNum.planType eq ('4') && product.productName eq(productNum.productName)}">
                                    <c:choose>
                                        <c:when test="${halfParam.currentHalfCode == productNum.halfCode}">
                                            <c:choose>
                                                <c:when test="${productNum.halfCode == 1}">
                                                    <td style="background-color: #FDB">${productNum.newActualNum}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td style="background-color: #FDB">${productNum.newActualNum}&nbsp;&nbsp;
                                                        <c:choose>
                                                            <c:when test="${userType eq ('2')}">
                                                                <msk:button buttonValue="实际录入" name="SC181102Actual_${productNum.productName}_${productNum.halfCode}_4" buttonId="SC181102Actual_${productNum.productCode}_${productNum.halfCode}_4" buttonType="button" />
                                                            </c:when>
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:when>
                                        <c:otherwise>
                                            <td>${productNum.newActualNum}</td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:if>
                            </c:forEach>
                            <td>${product.sumActualNum}</td>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/ds/SC181102.js"></script>
