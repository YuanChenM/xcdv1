<%--
    Title:发布需求数量-物流区选择（单一选择）
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发布需求数量-物流区选择" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">
    <form action="${ctx}/SP171131/search" id="SP171131Form" method="post">
        <input name="filterMap['dayAmount']" type="hidden" value="${dayAmount}" id="dayAmount" />
        <input name="filterMap['startDate']" type="hidden" id="startDate" value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd' />"/>
        <input name="filterMap['endDate']" type="hidden" id="endDate" value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd' />"/>
        <input name="filterMap['cycleCode']" type="hidden" id="cycleCode" value="${cycleCode}"/>
        <input name="loginId" type="hidden" id="loginId" value="${loginId}"/>
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>发布需求</label>
            </h3>
            <table width="100%" id="SP171131_Grid">
                <tbody>
                <tr>
                    <td width="10%" align="right">选择物流区</td>
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
                </tr>
                <tr>
                    <td width="10%" align="right">期数时间</td>
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
                </tr>
                <tr>
                    <td width="10%" align="right">填报时间</td>
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
                    <td align="left"><msk:button buttonValue="查询" buttonId="SC181102.SEARCH" buttonType="button"/></td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script src="${ctx}/js/sp/SP171131.js"></script>
