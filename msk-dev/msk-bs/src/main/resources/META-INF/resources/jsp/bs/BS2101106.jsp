<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="group-accordion" active="true">
    <h3>
        <label>买手基本信息编辑</label>
    </h3>

    <div id="" style="display:block">
        <form:form action="${ctx}/BS2101106/update" id="BS2101106Form" method="post" enctype="multipart/form-data">
            <table width="100%" border="0" cellpadding="0" cellspacing="10px">
                <tr>
                    <td align="right" width="">买手身份证号　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="slIdcard" name="slIdcard"
                               value="${bs2101105Bean.slIdcard}"/>
                        <input style="width:200px;" type="hidden" id="slAccount" name="slAccount"
                               value="${bs2101105Bean.slAccount}"/>
                        <input style="width:200px;" type="hidden" id="slCode" name="slCode"
                               value="${bs2101105Bean.slCode}"/>
                    </td>
                </tr>
                <tr>
                    <c:if test="${flagNum =='1'}">
                        <td align="right" width="18%"></td>
                    </c:if>
                    <c:if test="${flagNum ==''|| flagNum ==null}">
                        <td align="right" width="18%">买手编码　</td>
                        <td align="left" width="">
                            <input style="width:200px;" type="text" id="slCodeDis" name="slCodeDis" readonly="readonly" value="${bs2101105Bean.slCodeDis}"/>
                        </td>
                    </c:if>
                </tr>
                <tr>
                    <td align="right" width="">买手性别　</td>
                    <td align="left" width="">
                        <input type="radio" <c:if test="${bs2101105Bean.flag1=='1'}">checked="checked"</c:if> name="flag1" value="1"/>男
                        <input type="radio" <c:if test="${bs2101105Bean.flag1=='2'}">checked="checked"</c:if> name="flag1" value="2"/>女
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">国籍　</td>
                    <td align="left" width="">
                        <input type="radio"
                               <c:if test="${bs2101105Bean.slConFlg==1}">checked="checked"</c:if> name="slConFlg"
                               value="1"/>国产
                        <input type="radio"
                               <c:if test="${bs2101105Bean.slConFlg==2}">checked="checked"</c:if> name="slConFlg"
                               value="2"/>进口
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">省（含省、直辖市）</td>
                    <td align="left" width="">
                        <select style="width:120px" name="provinceCode" id="province1">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdProvince.provinceCode eq bs2101105Bean.provinceCode}">
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
                </tr>
                <tr>
                    <td align="right" width="">地区（含地级市）</td>
                    <td align="left" width="">
                        <select style="width:120px" name="cityCode" id="city1">
                            <option value="0">请选择</option>
                            <c:forEach items="${cityList}" var="cityList" varStatus="i">
                                <c:choose>
                                    <c:when test="${cityList.cityCode eq bs2101105Bean.cityCode}">
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
                </tr>
                <tr>
                    <td align="right" width="">区（含县级市、县、区）</td>
                    <td align="left" width="">
                        <select style="width:120px" name="districtCode" id="district1">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdDistrictList}" var="mdDistrictList" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdDistrictList.districtCode eq bs2101105Bean.districtCode}">
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
                <tr>
                    <td align="right" width="">买手开店资格　</td>
                    <td align="left" width="">
                        <input type="radio" <c:if test="${bs2101105Bean.shopQua=='0'}">checked="checked"</c:if> name="shopQua" value="0"/>无资格
                        <input type="radio" <c:if test="${bs2101105Bean.shopQua=='1'}">checked="checked"</c:if> name="shopQua" value="1"/>有资格
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">微信号码　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="memo1" name="memo1" value="${bs2101105Bean.memo1}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">QQ号码　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="memo2" name="memo2" value="${bs2101105Bean.memo2}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">邮箱　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="memo3" name="memo3" value="${bs2101105Bean.memo3}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">固定电话　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="memo4" name="memo4" value="${bs2101105Bean.memo4}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">传真号　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="memo5" name="memo5" value="${bs2101105Bean.memo5}"/>
                    </td>
                </tr>
                <!-- '1:行业型	2:创业型	3:关系型	4:配送型',-->
                <tr>
                    <td align="right" width="">买手类型　</td>
                    <td align="left" width="">
                        <input type="radio"
                               <c:if test="${bs2101105Bean.memo6==1}">checked="checked"</c:if> name="memo6" value="1"/>行业型
                        <input type="radio"
                               <c:if test="${bs2101105Bean.memo6==2}">checked="checked"</c:if> name="memo6" value="2"/>创业型
                        <input type="radio"
                               <c:if test="${bs2101105Bean.memo6==3}">checked="checked"</c:if> name="memo6" value="3"/>关系型
                        <input type="radio"
                               <c:if test="${bs2101105Bean.memo6==4}">checked="checked"</c:if> name="memo6" value="4"/>配送型
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">买手地址　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="slAddress" name="slAddress"
                               value="${bs2101105Bean.slAddress}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">纬度　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="lat" name="lat" value="${bs2101105Bean.lat}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">经度　</td>
                    <td align="left" width="">
                        <input style="width:200px;" type="text" id="lon" name="lon" value="${bs2101105Bean.lon}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">工作履历及证明材料（必须）</td>
                    <td align="left" width="">
                        <input type="file" name="file"/>
                       <%-- &nbsp;&nbsp;&nbsp;
                        <c:if test="${not empty bs2101105Bean.memo8}">
                            <a href="${bs2101105Bean.memo8}"><font color=blue>点击下载附件</font></a>
                        </c:if>--%>
                        <input type="hidden" id="memo8" name="memo8" value="${bs2101105Bean.memo8}"/>
                    </td>
                <tr>
                    <td></td>
                    <td align="left">
                        <msk:button buttonValue="保存" buttonId="BS2101106.SAVE" buttonType="button"/>
                    </td>
                </tr>
            </table>
        </form:form>
    </div>
</div>


<script src="${ctx}/js/bs/BS2101106.js"></script>
