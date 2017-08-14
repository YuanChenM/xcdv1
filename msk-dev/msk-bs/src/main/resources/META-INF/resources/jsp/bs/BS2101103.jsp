<%-- 
    Title:买手店管家会员列表
    author:cx
    createDate:2016-3-9
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var houseCodeDis = "${houseCodeDis}";
    var houseContact = "${houseContact}";
    var houseCode = "${houseCode}";
    var slContact = "${slContact}";
    var buyerId = "${buyerId}";
    var slCodeDis = "${slCodeDis}";
    var houseAccount = "${houseAccount}";
</script>
<navigation:header title="买手店管家会员列表" backTitleArray="买手店列表,冻品管家列表" backUrlArray="${ctx}/BS2101101/init/,${ctx}/BS2101102/init" backParamArray='/{"slCode":"${slCode}","slCodeDis":"${slCodeDis}","slContact":"${slContact}"}'></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/BS2101103/search" method="post" id="bs2101103FormId">
        <div>
            <table>
                <tr>
                    <td width="120px" style="background:#CCCCCC">买手编码</td>
                    <td align="center" width="150px">
                        <input type="input" id="slCodeDis" value="${slCodeDis}" name="filterMap[slCodeDis]" readonly="readonly"/>
                        <input type="hidden" value="${slCode}" name="filterMap[slCode]">
                        <input type="hidden" value="${buyerCode}" name="filterMap[buyerCode]">
                        <input type="hidden" value="${houseCode}" name="filterMap[houseCode]">
                    </td>
                    <td width="120px" style="background:#CCCCCC">买手名</td>
                    <td align="center" width="150px">
                        <input type="" id="slContact" value="${slContact}" readonly="readonly"/>
                    </td>
                </tr>
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
            </table>
        </div>

        <div>
            <table>
                <tr>
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
            </table>
        </div>
        <table id="bs2101103_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
               <%-- <th coltype="text" width="10%" name="buyerId" filter="true">买家ID</th>--%>
                <th coltype="text" width="10%" name="buyerCode" filter="true">买家编码</th>
                <th coltype="text" width="10%" name="buyerName" filter="true">买家名</th>
                <th coltype="text" width="10%" name="cityName" filter="">所属行政区域</th>
                <th coltype="text" width="10%" name="buyerAddr" filter="true">买家地址</th>
                <th coltype="text" width="10%" name="busiTel" filter="true">联系电话</th>
              <%--  <th coltype="text" width="10%" name="applyStatus" filter="true"></th>--%>
                <th coltype="select" name="applyStatusName" filter="true">申请状态
                    <select>
                        <option value="1">申请中</option>
                        <option value="2">专属会员</option>
                    </select>
                </th>
                <th coltype="text" width="10%" name="applyTime" filter="">申请日期</th>
                <th coltype="text" width="80px" name="startTime" filter="">开始日期</th>
                <th coltype="text" width="10%" name="endTime" filter="">结束日期</th>
                <th coltype="action" width="60px">解除关系
                    <input type="hidden" value="解除关系" coltype="add" title="解除关系" class="h-button"/>
                </th>
                <th coltype="action" width="60px">成为专属买家
                    <input type="hidden" value="成为专属买家" coltype="edit" title="成为专属买家" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script src="${ctx}/js/bs/BS2101103.js"></script>
