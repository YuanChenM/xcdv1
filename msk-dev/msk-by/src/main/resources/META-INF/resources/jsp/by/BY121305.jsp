<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="msk" uri="/msk" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="批发市场详细信息" backTitleArray="批发市场列表" backUrlArray="${ctx}/BY121301/init/"></navigation:header>
<div class="page-content list-page">
<div class="group-accordion" collapsible="true" active="true">
    <h3>
        <label>批发市场详细信息</label>
    </h3>
    <form:form action="${ctx}/BY121305/save/" id="by121305Form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="terMarketId" id="terMarketId" value="${terMarketId}">
        <table style="width: 100%;" CellSpacing=3>
            <tr>
                <td width="15%" align="right">批发市场编码:</td>
                <td width="35%" align="left"><input type="text" value="${byMarketTerminal.marketCode}" id="marketCode" name="marketCode" style="width: 200px;"/></td>
                <td width="15%" align="right">批发市场名称:</td>
                <td width="35%" align="left"><input type="text" value="${byMarketTerminal.marketName}" id="marketName" name="marketName" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td align="right">批发市场地址:</td>
                <td align="left"><input type="text" value="${byMarketTerminal.marketAddr}" id="marketAddr" name="marketAddr" style="width: 200px;"/></td>
                <td align="right">批发市场级别:</td>
                <td align="left">
                    <input type="hidden" name="marketLevelName" id="marketLevelName" value="${byMarketTerminal.marketLevelName}">
                    <select id="marketLevel" name="marketLevel" style="width: 210px;">
                        <option value="">请选择</option>
                        <c:forEach items="${marketLevelList}" var="marketLevel">
                            <c:choose>
                                <c:when test="${byMarketTerminal.marketLevel eq marketLevel.constantValue}">
                                    <option value="${marketLevel.constantValue}" selected>${marketLevel.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${marketLevel.constantValue}">${marketLevel.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
         </table>
        <table style="width: 100%;" CellSpacing=3>
            <tr>
                <td width="15%" align="right">物流区:</td>
                <td align="left">
                    <select id="lgcsAreaCode" name="lgcsAreaCode">
                        <option value="">请选择</option>
                        <c:forEach items="${logisticsAreaList}" var="logisticsArea">
                            <c:choose>
                                <c:when test="${byMarketTerminal.lgcsAreaCode eq logisticsArea.lgcsAreaCode}">
                                    <option value="${logisticsArea.lgcsAreaCode}" selected>${logisticsArea.lgcsAreaName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${logisticsArea.lgcsAreaCode}">${logisticsArea.lgcsAreaName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="20%" align="right">地区(城市):</td>
                <td align="left">
                    <select id="cityCode" name="cityCode">
                        <option value="">请选择</option>
                        <c:forEach items="${cityList}" var="city">
                            <c:choose>
                                <c:when test="${byMarketTerminal.cityCode eq city.cityCode}">
                                    <option value="${city.cityCode}" selected>${city.cityName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${city.cityCode}">${city.cityName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="10%" align="right">区(县):</td>
                <td width="35%" align="left">
                    <select id="districtCode" name="districtCode">
                        <option value="">请选择</option>
                        <c:forEach items="${districtList}" var="district">
                            <c:choose>
                                <c:when test="${byMarketTerminal.districtCode eq district.districtCode}">
                                    <option value="${district.districtCode}" selected>${district.districtName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${district.districtCode}">${district.districtName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <msk:button buttonValue="保存" buttonId="BY121305.Save" buttonType="button"/>
    </form:form>
</div>
</div>
<script type="text/javascript" src="${ctx}/js/by/BY121305.js"></script>
