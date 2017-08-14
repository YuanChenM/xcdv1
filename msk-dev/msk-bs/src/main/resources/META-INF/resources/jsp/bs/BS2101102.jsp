<%--
    Title:冻品管家列表
    author:cx
    createDate:2016-3-8
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var slCode = "${slCode}";
    var slCodeDis = "${slCodeDis}";
    var slContact = "${slContact}";
    /*  var houseCodeDis = "${houseCodeDis}";
     var houseContact = "${houseContact}";
     var houseCode = "${houseCode}";*/
    var buyerId = "${buyerId}";
    var provinceCode1 = "${provinceCode1}";
    var cityCode1 = "${cityCode1}";
    var districtCode1 = "${districtCode1}";
</script>
<navigation:header title="冻品管家列表" backTitleArray="买手店列表"
                   backUrlArray="${ctx}/BS2101101/init/?provinceCode=${provinceCode}&cityCode=${cityCode}&districtCode=${districtCode}"></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/BS2101102/search/" method="post" id="bs2101102FormId">
        <div>
            <table>
                <tr>
                    <td width="120px" style="background:#CCCCCC">买手编码</td>
                    <td align="center" width="150px">
                        <input type="input" id="slCodeDis" value="${slCodeDis}" name="filterMap[slCodeDis]"
                               readonly="readonly"/>
                        <input type="hidden" value="${slCode}" name="filterMap[slCode]">
                        <input type="hidden" value="${houseCode}" name="filterMap[houseCode]">
                        <input type="hidden" value="${provinceCode}">
                        <input type="hidden" value="${cityCode}">
                        <input type="hidden" value="${districtCode}">
                    <td width="120px" style="background:#CCCCCC">买手名</td>
                    <td align="center" width="150px">
                        <input type="" id="slContact" value="${slContact}" readonly="readonly"/>
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <table>
                <tr>
                    <td width="100px" style="background:#CCCCCC">省</td>
                    <td align="center" width="150px">
                        <select style="width:120px" name="provinceCode1" id="province">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdProvince.provinceCode eq provinceCode1}">
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
                        <select style="width:120px" name="cityCode1" id="city">
                            <option value="0">请选择</option>
                            <c:forEach items="${cityList}" var="cityList" varStatus="i">
                                <c:choose>
                                    <c:when test="${cityList.cityCode eq cityCode1}">
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
                        <select style="width:120px" name="districtCode1" id="district">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdDistrictList}" var="mdDistrictList" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdDistrictList.districtCode eq districtCode1}">
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
                </tr>
            </table>
        </div>
        <table id="bs2101102_list_grid" showAddBtn="true" width="100%">
            <thead>
            <tr>
                <%--   <input type="hidden" name="slCodeDis" value="${slCodeDis}"/>
                   <th coltype="text" width="10%" name="houseCodeDis" filter="true">冻品管家编码</th>
                   <%--<th coltype="text" width="10%" name="houseAccount" filter="true">冻品管家账号</th>--%>
                <th coltype="text" width="10%" name="houseContact" filter="true">管家姓名</th>
                <th coltype="text" width="10%" name="slIdcard" filter="true">身份证号码</th>
                <th coltype="text" width="10%" name="cityName" filter="">行政区划</th>
                <th coltype="text" width="10%" name="vhouseAddress" filter="true">管家地址</th>
                <th coltype="text" width="10%" name="houseTel" filter="true">联系电话</th>
                <th coltype="text" width="80px" name="greade" filter="true">管家等级</th>
                <th coltype="text" width="10%" name="buyerNum">当前专属买家数</th>
                <th coltype="action" width="60px">新增管家
                    <input type="hidden" value="新增管家" coltype="add" title="新增管家" class="h-button"/>
                </th>
                <th coltype="action" width="60px">修改管家
                    <input type="hidden" value="修改管家" coltype="edit" title="修改管家" class="h-button"/>
                </th>
                <th coltype="action" width="60px">新增专属买家
                    <input type="hidden" value="新增专属买家" coltype="add" title="新增专属买家" class="h-button"/>
                </th>
                <th coltype="action" width="60px">已有买家
                    <input type="hidden" value="已有买家" coltype="edit" title="已有买家" class="h-button"/>
                </th>
                <th coltype="action" width="60px">新增抢单买家
                    <input type="hidden" value="新增抢单买家" coltype="add" title="新增抢单买家" class="h-button"/>
                </th>
                <th coltype="action" width="60px">已有抢单买家
                    <input type="hidden" value="已有抢单买家" coltype="edit" title="已有抢单买家" class="h-button"/>
                </th>
                <th coltype="action" width="60px">解除关系
                    <input type="hidden" value="解除关系" coltype="check" title="解除关系" class="h-button"/>
                </th>
                <th coltype="action" width="60px">冻品管家的会员履历信息
                    <input type="hidden" value="冻品管家的会员履历信息" coltype="edit" title="冻品管家的会员履历信息" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <%--<table><tr align="left"><msk:button buttonValue="新建" buttonId="SL241101.NEW" buttonType="button"/></tr></table>--%>
    </form>
</div>
<script src="${ctx}/js/bs/BS2101102.js"></script>
