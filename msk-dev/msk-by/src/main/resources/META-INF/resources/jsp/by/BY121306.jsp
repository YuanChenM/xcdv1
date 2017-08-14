<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="msk" uri="/msk" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="菜场详细信息" backTitleArray="菜场列表" backUrlArray="${ctx}/BY121302/init/"></navigation:header>
<div class="page-content list-page">
<div class="group-accordion" collapsible="true" active="true">
    <h3>
        <label>菜场详细信息</label>
    </h3>
    <form:form action="${ctx}/BY121306/save/" id="by121306Form" method="post" enctype="multipart/form-data">
        <input type="hidden" name="fodMarketId" id="fodMarketId" value="${fodMarketId}">
        <table style="width: 100%;" CellSpacing=3>
            <tr>
                <td width="13.3%" align="right">菜场编码:</td>
                <td width="20%" align="left"><input type="text" value="${byMarketFood.marketCode}" id="marketCode" name="marketCode" style="width: 200px;"/></td>
                <td width="13.3%" align="right">菜场名称:</td>
                <td width="20%" align="left"><input type="text" value="${byMarketFood.marketName}" id="marketName" name="marketName" style="width: 200px;"/></td>
                <td width="13.3%" align="right">菜场地址:</td>
                <td width="20%" align="left"><input type="text" value="${byMarketFood.marketAddr}" id="marketAddr" name="marketAddr" style="width: 200px;"/></td>
            </tr>
            <tr>
                <td align="right">菜场类型:</td>
                <td align="left">
                    <input type="hidden" name="marketTypeName" id="marketTypeName" value="${byMarketFood.marketTypeName}">
                    <select id="marketType" name="marketType" style="width: 208px;">
                        <option value="">请选择</option>
                        <c:forEach items="${marketTypeList}" var="marketType">
                            <c:choose>
                                <c:when test="${byMarketFood.marketType eq marketType.constantValue}">
                                    <option value="${marketType.constantValue}" selected>${marketType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${marketType.constantValue}">${marketType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">地段类型:</td>
                <td align="left">
                    <input type="hidden" name="sectionTypeName" id="sectionTypeName" value="${byMarketFood.sectionTypeName}">
                    <select id="sectionType" name="sectionType" style="width: 208px;">
                        <option value="">请选择</option>
                        <c:forEach items="${marketSectionTypeList}" var="marketSectionType">
                            <c:choose>
                                <c:when test="${byMarketFood.sectionType eq marketSectionType.constantValue}">
                                    <option value="${marketSectionType.constantValue}" selected>${marketSectionType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${marketSectionType.constantValue}">${marketSectionType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">规模类型:</td>
                <td align="left">
                    <input type="hidden" name="sizeTypeName" id="sizeTypeName" value="${byMarketFood.sizeTypeName}">
                    <select id="sizeType" name="sizeType" style="width: 208px;">
                        <option value="">请选择</option>
                        <c:forEach items="${marketSizeTypeList}" var="marketSizeType">
                            <c:choose>
                                <c:when test="${byMarketFood.sizeType eq marketSizeType.constantValue}">
                                    <option value="${marketSizeType.constantValue}" selected>${marketSizeType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${marketSizeType.constantValue}">${marketSizeType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right">物流区:</td>
                <td align="left">
                    <select id="lgcsAreaCode" name="lgcsAreaCode" style="width: 208px;">
                        <option value="">请选择</option>
                        <c:forEach items="${logisticsAreaList}" var="logisticsArea">
                            <c:choose>
                                <c:when test="${byMarketFood.lgcsAreaCode eq logisticsArea.lgcsAreaCode}">
                                    <option value="${logisticsArea.lgcsAreaCode}" selected>${logisticsArea.lgcsAreaName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${logisticsArea.lgcsAreaCode}">${logisticsArea.lgcsAreaName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">地区(城市):</td>
                <td align="left">
                    <select id="cityCode" name="cityCode" style="width: 208px;">
                        <option value="">请选择</option>
                        <c:forEach items="${cityList}" var="city">
                            <c:choose>
                                <c:when test="${byMarketFood.cityCode eq city.cityCode}">
                                    <option value="${city.cityCode}" selected>${city.cityName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${city.cityCode}">${city.cityName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td align="right">区(县):</td>
                <td align="left">
                    <select id="districtCode" name="districtCode" style="width: 208px;">
                        <option value="">请选择</option>
                        <c:forEach items="${districtList}" var="district">
                            <c:choose>
                                <c:when test="${byMarketFood.districtCode eq district.districtCode}">
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
        <msk:button buttonValue="保存" buttonId="BY121306.Save" buttonType="button"/>
    </form:form>
</div>
</div>
<script type="text/javascript" src="${ctx}/js/by/BY121306.js"></script>
