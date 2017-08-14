<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:公共买家池列表
    author:cx
    createDate:2016-3-3
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<c:choose>
    <c:when test="${pageType eq 1}">
        <navigation:header title="公共买家池列表" backTitleArray="买手店列表,冻品管家列表"
                           backUrlArray="${ctx}/BS2101101/init/,${ctx}/BS2101102/init" backParamArray='/{"slCode":"${slCode}","slCodeDis":"${slCodeDis}","slContact":"${slContact}"}'></navigation:header>
    </c:when>
    <c:otherwise>
        <navigation:header title="公共买家池列表" backTitleArray=""
                           backUrlArray=""></navigation:header>
    </c:otherwise>
</c:choose>
<div class="page-content list-page">

    <form action="${ctx}/BS2101104/search/" method="post" id="BS2101104FormId">
        <div>
            <table>
                <tr>
                    <input type="hidden" value="${slCode}" name="filterMap[slCode]">
                    <td width="100px" style="background:#CCCCCC">省</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="filterMap[provinceCode]" id="province_select">
                            <option value="" label="请选择"/>
                            <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                                <option value="${mdProvince.provinceCode}">${mdProvince.provinceName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="100px" style="background:#CCCCCC">地区</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="filterMap[cityCode]" id="city_select">
                            <option value="" label="请选择"/>
                        </select>
                    </td>
                    <td width="100px" style="background:#CCCCCC">区</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="filterMap[districtCode]" id="district_select">
                            <option value="" label="请选择"/>
                        </select>
                    </td>
                    <%--<td>--%>
                        <%--<msk:button buttonValue="查询" buttonId="BS2101104.search" buttonType="button"/>--%>
                    <%--</td>--%>
                </tr>
            </table>
        </div>
        <table id="bs2101104_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="accountName" filter="true">买家账号</th>
                <th coltype="text" name="telNo" filter="true">注册手机</th>
                <th coltype="text" name="buyerCode" filter="true">买家编码</th>
                <th coltype="text" name="buyerName" filter="true">买家名</th>
                <th coltype="text" name="superiorName" filter="true">买家类型</th>
                <th coltype="text" name="marketingsStatusName" filter="true">营销/销售类型</th>
                <th coltype="text" name="buyerAddr" filter="true">买家地址</th>
                <th coltype="text" name="busiTel" filter="true">联系电话</th>
                <th coltype="text" name="lgcsAreaName">物流区名称</th>
                <th coltype="text" name="domainName">所属行政区域</th>
                <c:choose>
                    <c:when test="${pageType eq 1}">
                        <th coltype="action" width="60px">成为专属买家
                            <input type="hidden" value="成为专属买家" coltype="add" title="成为专属买家" class="h-button"/>
                        </th>
                        <th coltype="action" width="60px">买家申请成为专属会员
                            <input type="hidden" value="买家申请成为专属会员" coltype="edit" title="买家申请成为专属会员" class="h-button"/>
                        </th>
                        <th coltype="action" width="60px">冻品管家申请成为专属会员
                            <input type="hidden" value="冻品管家申请成为专属会员" coltype="edit" title="冻品管家申请成为专属会员"
                                   class="h-button"/>
                        </th>
                        <th coltype="action" width="60px">成为抢单买家
                            <input type="hidden" value="成为抢单买家" coltype="edit" title="成为抢单买家" class="h-button"/>
                        </th>
                    </c:when>
                </c:choose>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script src="${ctx}/js/bs/BS2101104.js"></script>
