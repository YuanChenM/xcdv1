<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:买手店列表
    author:cx
    createDate:2016-3-7
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="买手店列表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/BS2101101/search" method="post" id="bs2101101FormId">
        <input type="hidden" name="filterMap[applyStatus]" value="${applyStatus}">
        <input type="hidden" name="filterMap[slCode]" value="${slCode}">

        <div>
            <table>
                <tr>
                    <td width="100px" style="background:#CCCCCC">省</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="provinceCode" id="province">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdProvince.provinceCode eq provinceCode}">
                                        <option value="${mdProvince.provinceCode}"
                                                selected="selected">${mdProvince.provinceName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${mdProvince.provinceCode}">${mdProvince.provinceName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="100px" style="background:#CCCCCC">地区</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="cityCode" id="city">
                            <option value="0">请选择</option>
                            <c:forEach items="${cityList}" var="cityList" varStatus="i">
                                <c:choose>
                                    <c:when test="${cityList.cityCode eq cityCode}">
                                        <option value="${cityList.cityCode}"
                                                selected="selected">${cityList.cityName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${cityList.cityCode}">${cityList.cityName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="100px" style="background:#CCCCCC">区</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="districtCode" id="district">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdDistrictList}" var="mdDistrictList" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdDistrictList.districtCode eq districtCode}">
                                        <option value="${mdDistrictList.districtCode}"
                                                selected="selected">${mdDistrictList.districtName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${mdDistrictList.districtCode}">${mdDistrictList.districtName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="829px"/>
                    <td><msk:button buttonValue="新增" buttonId="BS2101101.NEW" buttonType="button"/></td>
                </tr>
            </table>
        </div>
        <div>
            <table id="bs2101101_list_grid" showAddBtn="true" width="100%">
                <thead>
                <tr>
                    <th coltype="text" name="slCodeDis" filter="true">买手编码</th>
                    <th coltype="text" name="slContact" filter="true">买手名称</th>
                    <th coltype="text" name="shopName" filter="true">店铺名称</th>
                    <th coltype="text" name="slIdcard" filter="true">身份证号码</th>
                    <th coltype="text" name="cityName" filter="">行政区划</th>
                    <th coltype="text" name="lgcsAreaName" filter="true">物流区划</th>
                    <th coltype="text" name="slAddress" filter="true">买手地址</th>
                    <th coltype="text" name="slTel" filter="true">联系电话</th>
                    <c:choose>
                    <c:when test="${applyStatus eq 1}">
                        <%--<th coltype="action">联盟--%>
                        <%--<input type="hidden" value="联盟" coltype="return" title="联盟" class="h-button"/>--%>
                        <%--</th>--%>
                    </c:when>
                    <c:otherwise>
                    <th coltype="text" name="stewardNum">当前管家数</th>
                    <th coltype="text" name="buyerNum">当前专属买家数</th>
                    <th coltype="action">冻品管家
                        <input type="hidden" value="冻品管家" coltype="export" title="冻品管家" class="h-button"/>
                    </th>
                        <%-- <th coltype="action">新增
                             <input type="hidden" value="新增" coltype="edit" title="新增" class="h-button"/>
                         </th>--%>
                    <th coltype="action">修改
                        <input type="hidden" value="修改" coltype="check" title="修改" class="h-button"/>
                    </th>
                        <%--<th coltype="action">申请联盟--%>
                        <%--<input type="hidden" value="申请联盟" coltype="audit" title="申请联盟" class="h-button"/>--%>
                        <%--</th>--%>
                    </c:otherwise>
                    </c:choose>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <%--  <table><tr align="left"><msk:button buttonValue="新建" buttonId="SL241101.NEW" buttonType="button"/></tr></table>--%>
    </form>
</div>
<script src="${ctx}/js/bs/BS2101101.js"></script>
