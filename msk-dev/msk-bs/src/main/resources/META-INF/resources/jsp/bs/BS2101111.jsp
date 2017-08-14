<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:查询买手冻品管家的买家履历信息
    author:cx
    createDate:2016-4-19
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<c:if test="${flagNum =='1'}">
    <navigation:header title="买手冻品管家的买家履历信息" backTitleArray="买手店列表,冻品管家列表"
                       backUrlArray="${ctx}/BS2101101/init/,${ctx}/BS2101102/init" backParamArray='/{"slCode":"${slCode}","slCodeDis":"${slCodeDis}","slContact":"${slContact}"}'></navigation:header>
</c:if>
<c:if test="${flagNum != '1'}">
    <navigation:header title="买手店冻品管家与卖家关系履历" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<div class="page-content list-page">
    <form action="${ctx}/BS2101112/search" method="post" id="bs2101111FormId">
        <div>
            <table>
                <tr>
                    <td width="100px" style="background:#CCCCCC">是否查询当前关系</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="searchDataFlag" id="searchDataFlag">
                            <option value="1" selected="selected">只查过去的履历</option>
                            <option value="2">包含当前关系</option>
                        </select>
                    </td>
                </tr>
                <c:if test="${flagNum =='1'}">
                    <tr>
                        <td width="100px" style="background:#CCCCCC">冻品管家编码</td>
                        <td align="center" width="150px">
                            <input type="" id="houseCodeDis" value="${houseCodeDis}" readonly="readonly"/>
                        </td>
                        <td width="100px" style="background:#CCCCCC">冻品管家名</td>
                        <td align="center" width="150px">
                            <input type="" id="houseContact" value="${houseContact}" readonly="readonly"/>
                        </td>
                    </tr>
                </c:if>
                <input type="hidden" value="${slCode}" name="filterMap[slCode]">
                <input type="hidden" value="${slContact}" name="filterMap[slContact]">
                <input type="hidden" value="${slCodeDis}" name="filterMap[slCodeDis]">
                <input type="hidden" value="${buyerId}" name="filterMap[buyerId]">
                <input type="hidden" value="${houseCode}" name="filterMap[houseCode]">
                <input type="hidden" value="${houseCodeDis}" name="filterMap[houseCodeDis]">
                <input type="hidden" value="${houseContact}" name="filterMap[houseContact]">
                <input type="hidden" value="${houseAccount}" name="filterMap[houseAccount]">
                <td width="150px" style="background:#CCCCCC">根据买家区域查询</td>
                <td width="100px" style="background:#CCCCCC">省</td>
                <td align="center" width="150px">
                    <select style="width:120px" name="provinceCode" id="province_select">
                        <option value="" label="请选择"/>
                        <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                            <option value="${mdProvince.provinceCode}">${mdProvince.provinceName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td width="100px" style="background:#CCCCCC">地区</td>
                <td align="center" width="150px">
                    <select style="width:120px" name="cityCode" id="city_select">
                        <option value="" label="请选择"/>
                    </select>
                </td>
                <td width="100px" style="background:#CCCCCC">区</td>
                <td align="center" width="150px">
                    <select style="width:120px" name="districtCode" id="district_select">
                        <option value="" label="请选择"/>
                    </select>
                </td>
                </tr>
                <c:if test="${flagNum !='1'}">
                    <tr>
                        <td width="150px" style="background:#CCCCCC">根据冻品管家虚拟区域查询</td>
                        <td width="100px" style="background:#CCCCCC">省</td>
                        <td align="center" width="150px">
                            <select style="width:120px" name="provinceCode1" id="province_select1">
                                <option value="" label="请选择"/>
                                <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                                    <option value="${mdProvince.provinceCode}">${mdProvince.provinceName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="100px" style="background:#CCCCCC">地区</td>
                        <td align="center" width="150px">
                            <select style="width:120px" name="cityCode1" id="city_select1">
                                <option value="" label="请选择"/>
                            </select>
                        </td>
                        <td width="100px" style="background:#CCCCCC">区</td>
                        <td align="center" width="150px">
                            <select style="width:120px" name="districtCode1" id="district_select1">
                                <option value="" label="请选择"/>
                            </select>
                        </td>

                    </tr>
                </c:if>
            </table>
        </div>
        <div>
            <table id="bs2101111_list_grid" showAddBtn="true" width="100%">
                <thead>
                <tr>
                    <c:if test="${flagNum != '1'}">
                    <th coltype="text" name="houseInfo.houseCodeDis" filter="true">冻品管家编码</th>
                    <th coltype="text" name="houseInfo.houseContact" filter="true">冻品管家名称</th>
                    <th coltype="text" name="houseInfo.vhouseAddress" filter="true">冻品管家虚拟地址</th>
                    </c:if>
                    <%--<th coltype="select" name="searchDataFlag" filter="true">履历与当前关系
                        <select>
                            <option value="1">只查过去的履历</option>
                            <option value="2">包含当前关系</option>
                        </select>
                    </th>--%>
                    <th coltype="text" name="buyerInfo.buyerCode" filter="true">买家编码</th>
                    <th coltype="text" name="buyerInfo.buyerName" filter="true">买家名称</th>
                    <th coltype="text" name="buyerInfo.districtName1" filter="">买家行政区划</th>
                    <th coltype="text" name="buyerInfo.buyerAddr" filter="true">买家地址</th>
                    <th coltype="text" name="buyerInfo.busiTel" filter="true">联系电话</th>
                    <th coltype="text" name="startTime" filter="">开始日期</th>
                    <th coltype="text" name="endTime" filter="">结束日期</th>
                    <th coltype="text" name="buyerReason" filter="true">买家解除原因</th>
                    <th coltype="text" name="buyershopReason" filter="true">买手解除原因</th>
                    <th coltype="action">详细
                        <input type="hidden" value="详细" coltype="return" title="详细" class="h-button"/>
                    </th>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script src="${ctx}/js/bs/BS2101111.js"></script>
