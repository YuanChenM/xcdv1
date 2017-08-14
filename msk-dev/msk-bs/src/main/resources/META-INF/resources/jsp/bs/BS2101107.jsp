<%-- 
    Title:冻品管家新增
    author:pxg
    createDate:2016-4-5
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<c:if test="${flagNum =='1'}">
    <navigation:header title="新增冻品管家" backTitleArray="买手店列表,冻品管家列表"
                       backUrlArray="${ctx}/BS2101101/init/,${ctx}/BS2101102/init"
                       backParamArray='/{"slCode":"${slCode}","slCodeDis":"${slCodeDis}","slContact":"${slContact}"}'></navigation:header>
</c:if>
<c:if test="${flagNum =='' || flagNum ==null}">
    <navigation:header title="修改冻品管家" backTitleArray="买手店列表,冻品管家列表"
                       backUrlArray="${ctx}/BS2101101/init/,${ctx}/BS2101102/init"
                       backParamArray='/{"slCode":"${slCode}","slCodeDis":"${slCodeDis}","slContact":"${slContact}"}'></navigation:header>
</c:if>
<div class="page-content list-page" style="height:100%">
    <div class="group-accordion" active="true" id="SL2101107accordion">
        <h3>
            <label>冻品管家账户信息</label>
        </h3>

        <form action="${ctx}/BS2101107/save" id="BS2101107FormInfo"
              method="post" enctype="multipart/form-data">
            <input type="hidden" name="slCode" value="${slCode}"/>
            <input type="hidden" name="slCodeDis" value="${slCodeDis}"/>
            <input type="hidden" name="slContact" value="${slContact}"/>
            <table width="100%" border="0" cellpadding="3" cellspacing="3">
                <tr>
                    <td align="right" width="50%">管家账号</td>
                    <td align="left" width="50%">
                        <c:if test="${flagNum =='1'}">
                            <input type="text" name="houseAccount" value="${ibs2101104SlHouseAccount.houseAccount}"/>
                        </c:if>
                        <c:if test="${flagNum =='' || flagNum ==null}">
                            <input type="text" name="houseAccount" value="${ibs2101104SlHouseAccount.houseAccount}"
                                   readonly="readonly"/>
                        </c:if>
                        <input type="hidden" name="houseCode" value="${ibs2101104SlHouseAccount.houseCode}"/>
                        <input type="hidden" name="houseCodeDis" value="${ibs2101104SlHouseAccount.houseCodeDis}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家显示名称</td>
                    <td align="left" width="50%">
                        <input type="text" name="houseShowName" value="${ibs2101104SlHouseAccount.houseShowName}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">联系人姓名</td>
                    <td align="left" width="50%">
                        <input type="text" name="houseContact" value="${ibs2101104SlHouseAccount.houseContact}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">联系人电话</td>
                    <td align="left" width="50%">
                        <input type="text" name="houseTel" value="${ibs2101104SlHouseAccount.houseTel}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">性别</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.flag1==1}">checked="checked"</c:if> name="flag1"
                               value="1"/>男
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.flag1==2}">checked="checked"</c:if> name="flag1"
                               value="2"/>女
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">登录密码</td>
                    <td align="left" width="50%">
                        <input type="text" name="accountPsd" value="${ibs2101104SlHouseAccount.accountPsd}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家身份证</td>
                    <td align="left" width="50%">
                        <input type="text" name="slIdcard" value="${ibs2101104SlHouseAccount.slIdcard}"/>
                    </td>
                </tr>
                <tr>
                    <%--  '1：国产，2：进口',--%>
                    <td align="right" width="50%">国籍</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.slConFlg==1}">checked="checked"</c:if>
                               name="slConFlg" value="1"/>国产
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.slConFlg==2}">checked="checked"</c:if>
                               name="slConFlg" value="2"/>进口
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">微信号码</td>
                    <td align="left" width="50%">
                        <input type="text" name="wechat" value="${ibs2101104SlHouseAccount.wechat}"/>
                    </td>
                </tr>
                <td align="right" width="50%">QQ号码</td>
                <td align="left" width="50%">
                    <input type="text" name="qq" value="${ibs2101104SlHouseAccount.qq}"/>
                </td>
                </tr>
                <tr>
                    <td align="right" width="50%">邮箱</td>
                    <td align="left" width="50%">
                        <input type="text" name="email" value="${ibs2101104SlHouseAccount.email}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">固定电话</td>
                    <td align="left" width="50%">
                        <input type="text" name="fixedTel" value="${ibs2101104SlHouseAccount.fixedTel}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">传真号</td>
                    <td align="left" width="50%">
                        <input type="text" name="fax" value="${ibs2101104SlHouseAccount.fax}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">个人感慨</td>
                    <td align="left" width="50%">
                        <textarea rows="3" cols="18" name="flag5">${ibs2101104SlHouseAccount.flag5}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">服务态度</td>
                    <td align="left" width="50%">
                        <textarea rows="3" cols="18" name="flag4">${ibs2101104SlHouseAccount.flag4}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">个人特长</td>
                    <td align="left" width="50%">
                        <textarea rows="3" cols="18" name="flag3">${ibs2101104SlHouseAccount.flag3}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">从业经历</td>
                    <td align="left" width="50%">
                        <textarea rows="3" cols="18" name="flag2">${ibs2101104SlHouseAccount.flag2}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="">省（含省、直辖市）</td>
                    <td align="left" width="">
                        <select style="width:120px" name="provinceCode" id="province">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdProvince.provinceCode eq ibs2101104SlHouseAccount.provinceCode}">
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
                        <select style="width:120px" name="cityCode" id="city">
                            <option value="0">请选择</option>
                            <c:forEach items="${cityList}" var="cityList" varStatus="i">
                                <c:choose>
                                    <c:when test="${cityList.cityCode eq ibs2101104SlHouseAccount.cityCode}">
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
                        <select style="width:120px" name="districtCode" id="district">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdDistrictList}" var="mdDistrictList" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdDistrictList.districtCode eq ibs2101104SlHouseAccount.districtCode}">
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
                    <td align="right" width="50%">管家地址</td>
                    <td align="left" width="50%">
                        <textarea rows="3" cols="18" name="houseAddress"
                                >${ibs2101104SlHouseAccount.houseAddress}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">虚拟省区</td>
                    <td align="left" width="50%">
                        <select style="width:136px;height:20px" name="vprovinceCode" id="vprovince_select">
                            <option value="0">请选择</option>
                            <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdProvince.provinceCode eq ibs2101104SlHouseAccount.vprovinceCode}">
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
                    <td align="right" width="50%">虚拟地区</td>
                    <td align="left" width="50%">
                        <select style="width:136px;height:20px" name="vcityCode" id="vcity_select">
                            <option value="0">请选择</option>
                            <c:forEach items="${vcityList}" var="cityList" varStatus="i">
                                <c:choose>
                                    <c:when test="${cityList.cityCode eq ibs2101104SlHouseAccount.vcityCode}">
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
                    <td align="right" width="50%">虚拟区</td>
                    <td align="left" width="50%">
                        <select style="width:136px;height:20px" name="vdistrictCode" id="vdistrict_select">
                            <option value="0">请选择</option>
                            <c:forEach items="${vmdDistrictList}" var="mdDistrictList" varStatus="i">
                                <c:choose>
                                    <c:when test="${mdDistrictList.districtCode eq ibs2101104SlHouseAccount.vdistrictCode}">
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
                    <td align="right" width="50%">虚拟管家地址</td>
                    <td align="left" width="50%">
                        <textarea rows="3" cols="18" name="vhouseAddress"
                                >${ibs2101104SlHouseAccount.vhouseAddress}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">地址维度</td>
                    <td align="left" width="50%">
                        <input type="text" name="lat" value="${ibs2101104SlHouseAccount.lat}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">地址精度</td>
                    <td align="left" width="50%">
                        <input type="text" name="lon" value="${ibs2101104SlHouseAccount.lon}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">虚拟地址维度</td>
                    <td align="left" width="50%">
                        <input type="text" name="vlat" value="${ibs2101104SlHouseAccount.vlat}"/>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">虚拟地址精度</td>
                    <td align="left" width="50%">
                        <input type="text" name="vlon" value="${ibs2101104SlHouseAccount.vlon}"/>
                    </td>
                </tr>
                <tr>
                    <%--   '0:没签署，1：签署',--%>
                    <td align="right" width="50%">买手签署</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.buyerAsign==0}">checked="checked"</c:if>
                               name="buyerAsign" value="0"/>已签署
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.buyerAsign==1}">checked="checked"</c:if>
                               name="buyerAsign" value="1"/>未签署
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家介绍</td>
                    <td align="left" width="50%">
                        <textarea rows="3" cols="18" name="houseIntroduce"
                                >${ibs2101104SlHouseAccount.houseIntroduce}</textarea>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">级别</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseClass==1}">checked="checked"</c:if>
                               name="houseClass" value="1"/>店主
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseClass==2}">checked="checked"</c:if>
                               name="houseClass" value="2"/>店员
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类</td>
                    <td align="left" width="50%">
                        <select style="width:136px;height:20px;text-align: center" name="houseCategory"
                                id="houseCategoryId">
                            <option value="">--请选择--</option>
                            <option value="0"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==0}">selected="selected"</c:if>>
                                基本冻品管家
                            </option>
                            <option value="1"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==1}">selected="selected"</c:if>>
                                分销
                            </option>
                            <option value="2"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==2}">selected="selected"</c:if>>
                                菜场
                            </option>
                            <option value="3"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==3}">selected="selected"</c:if>>
                                团膳
                            </option>
                            <option value="4"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==4}">selected="selected"</c:if>>
                                火锅
                            </option>
                            <option value="5"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==5}">selected="selected"</c:if>>
                                中餐
                            </option>
                            <option value="6"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==6}">selected="selected"</c:if>>
                                西餐
                            </option>
                            <option value="7"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==7}">selected="selected"</c:if>>
                                小吃烧烤
                            </option>
                            <option value="8"
                                    <c:if test="${ibs2101104SlHouseAccount.houseCategory==8}">selected="selected"</c:if>>
                                加工厂
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类基本</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory0==1}">checked="checked"</c:if>
                               name="houseCategory0" id="houseCategory0Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory0==0}">checked="checked"</c:if>
                               name="houseCategory0" id="houseCategory0No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类分销</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory1==1}">checked="checked"</c:if>
                               name="houseCategory1" id="houseCategory1Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory1==0}">checked="checked"</c:if>
                               name="houseCategory1" id="houseCategory1No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类菜场</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory2==1}">checked="checked"</c:if>
                               name="houseCategory2" id="houseCategory2Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory2==0}">checked="checked"</c:if>
                               name="houseCategory2" id="houseCategory2No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类团膳</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory3==1}">checked="checked"</c:if>
                               name="houseCategory3" id="houseCategory3Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory3==0}">checked="checked"</c:if>
                               name="houseCategory3" id="houseCategory3No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类火锅</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory4==1}">checked="checked"</c:if>
                               name="houseCategory4" id="houseCategory4Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory4==0}">checked="checked"</c:if>
                               name="houseCategory4" id="houseCategory4No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类中餐</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory5==1}">checked="checked"</c:if>
                               name="houseCategory5" id="houseCategory5Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory5==0}">checked="checked"</c:if>
                               name="houseCategory5" id="houseCategory5No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类西餐</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory6==1}">checked="checked"</c:if>
                               name="houseCategory6" id="houseCategory6Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory6==0}">checked="checked"</c:if>
                               name="houseCategory6" id="houseCategory6No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类小吃烧烤</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory7==1}">checked="checked"</c:if>
                               name="houseCategory7" id="houseCategory7Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory7==0}">checked="checked"</c:if>
                               name="houseCategory7" id="houseCategory7No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td align="right" width="50%">管家分类加工厂</td>
                    <td align="left" width="50%">
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory8==1}">checked="checked"</c:if>
                               name="houseCategory8" id="houseCategory8Yes" value="1"/>是
                        <input type="radio"
                               <c:if test="${ibs2101104SlHouseAccount.houseCategory8==0}">checked="checked"</c:if>
                               name="houseCategory8" id="houseCategory8No" value="0"/>否
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="left">
                        <msk:button buttonValue="保存" buttonId="SL2101107.SAVE" buttonType="button"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script src="${ctx}/js/bs/BS2101107.js"></script>
