<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="group-accordion" active="false">
    <h3>
        <label>卖家基本信息编辑</label>
    </h3>
    <form:form action="${ctx}/SL24110102/update" id="SL24110102Form"
               metdod="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">卖家主经营类型</td>
                <td align="left" width="50%">
                        <input type="radio" <c:if test="${slSeller.slMainClass==0}">checked="checked"</c:if> name="slMainClass" value="0"  />生产商
                        <input type="radio" <c:if test="${slSeller.slMainClass==1}">checked="checked"</c:if> name="slMainClass" value="1"/>自产型
                        <input type="radio" <c:if test="${slSeller.slMainClass==2}">checked="checked"</c:if> name="slMainClass" value="2"/>代理型
                        <input type="radio" <c:if test="${slSeller.slMainClass==3}">checked="checked"</c:if> name="slMainClass" value="3"/>OEM型
                </td>
            </tr>
            <tr>
                <td align="right" width="50%" >二级经营类型</td>
                <td align="left" width="50%">
                    <input name="slSecondaryClass" <c:if test="${slSeller.selfFlg==1}">checked="checked"</c:if> type="checkbox" value="1" />自产型
                    <input name="slSecondaryClass" <c:if test="${slSeller.agentFlg==1}">checked="checked"</c:if> type="checkbox" value="2" />代理型
                    <input name="slSecondaryClass" <c:if test="${slSeller.oemFlg==1}">checked="checked"</c:if> type="checkbox" value="3"/>OEM型

                </td>
            </tr>

                <tr>
                    <td align="right" width="50%">公司全名</td>
                    <td align="left" width="50%">
                        <input type="text" id="epName" name="epName" value="${slEnterprise.epName}"/>
                        <input type="hidden" id="epId" name="epId" value="${slEnterprise.epId}"/>
                        <input type="hidden" id="slCode" name="slCode" value="${slSeller.slCode}"/>
                    </td>
                </tr>
            <tr>
                <td align="right" width="50%">是否是三证合一卖家</td>
                <td align="left" width="50%">
                    <c:if test="${slEnterprise.licType==0}">
                        <input type="radio" name="licType" value="0" checked="checked"/>否
                        <input type="radio" name="licType" value="1"/>是
                    </c:if>
                    <c:if test="${slEnterprise.licType==1}">
                        <input type="radio" name="licType" value="0"/>否
                        <input type="radio" name="licType" value="1" checked="checked"/>是
                    </c:if>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">营业执照名称</td>
                <td align="left" width="50%">
                    <input type="text" name="licName" value="${slEnterprise.licName}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">营业执照注册号</td>
                <td align="left" width="50%">
                    <input type="text" name="licNo" value="${slEnterprise.licNo}"/>
                    <input type="hidden" id="slAccount" name="slAccount" value="${slSeller.slAccount}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">省（含省、直辖市）</td>
                <td align="left" width="50%">
                    <select  style="width:120px" name="provinceCode" id="province_select">
                        <option value="0">请选择</option>
                        <c:forEach items="${mdProvinces}" var="mdProvince" varStatus="i">
                            <c:choose>
                                <c:when test="${mdProvince.provinceCode eq slSeller.provinceCode}">
                                    <option value="${mdProvince.provinceCode}" selected="selected">${mdProvince.provinceName}</option>
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
                <td align="right" width="50%">地区（含地级市）</td>
                <td align="left" width="50%">
                    <select  style="width:120px" name="cityCode" id="city_select">
                        <option value="0">请选择</option>
                        <c:forEach items="${cityList}" var="cityList" varStatus="i">
                            <c:choose>
                                <c:when test="${cityList.cityCode eq slSeller.cityCode}">
                                    <option value="${cityList.cityCode}" selected="selected">${cityList.cityName}</option>
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
                <td align="right" width="50%">区（含县级市、县、区）</td>
                <td align="left" width="50%">
                    <select  style="width:120px" name="districtCode" id="district_select">
                        <option value="0">请选择</option>
                        <c:forEach items="${mdDistrictList}" var="mdDistrictList" varStatus="i">
                            <c:choose>
                                <c:when test="${mdDistrictList.districtCode eq slSeller.districtCode}">
                                    <option value="${mdDistrictList.districtCode}" selected="selected">${mdDistrictList.districtName}</option>
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
                <td align="right" width="50%">公司场地</td>
                <td align="left" width="50%">
                    <input type="text" name="licAddr" value="${slEnterprise.licAddr}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">经营类型</td>
                <td align="left" width="50%">
                    <input type="text" name="licBusiType" value="${slEnterprise.licBusiType}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">经营范围</td>
                <td align="left" width="50%">
                    <input type="text" name="licBusiScope" value="${slEnterprise.licBusiScope}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">生产国籍</td>
                <td align="left" width="50%">
                        <input type="radio" <c:if test="${slSeller.slConFlg==1}">checked="checked"</c:if> name="slConFlg" value="1" />国产
                        <input type="radio" <c:if test="${slSeller.slConFlg==2}">checked="checked"</c:if>name="slConFlg" value="2"/>进口
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">法人代表</td>
                <td align="left" width="50%">
                    <input type="text" name="licLegalPerson" value="${slEnterprise.licLegalPerson}"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">注册资本(万元)</td>
                <td align="left" width="50%">
                    <input type="text" name="licRegCapital" value="${slEnterprise.licRegCapital}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">实收资本(万元)</td>
                <td align="left" width="50%">
                    <input type="text" name="licPaidinCapital" value="${slEnterprise.licPaidinCapital}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">成立日期</td>
                <td align="left" width="50%">
                    <input type="text" name="licCrtDate" id="licCrtDate" value="<fmt:formatDate value="${slEnterprise.licCrtDate}" pattern="yyyy-MM-dd" />"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">营业开始日期</td>
                <td align="left" width="50%">
                    <input type="text" name="licTermBegin" id="licTermBegin" value="<fmt:formatDate value="${slEnterprise.licTermBegin}" pattern="yyyy-MM-dd" />"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">营业截止日期</td>
                <td align="left" width="50%">
                    <input type="text" name="licTermEnd" id="licTermEnd" value="<fmt:formatDate value="${slEnterprise.licTermEnd}" pattern="yyyy-MM-dd" />"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">营业期限是否是长期</td>
                <td align="left" width="50%">
                        <input type="radio" <c:if test="${slEnterprise.licTermUnliimited==0}"> checked="checked"</c:if> name="licTermUnliimited" value="0"/>否
                        <input type="radio" <c:if test="${slEnterprise.licTermUnliimited==1}"> checked="checked"</c:if> name="licTermUnliimited" value="1"/>是
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">税务登记证号</td>
                <td align="left" width="50%">
                    <input type="text" name="taxNo" value="${slEnterprise.taxNo}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">一般增值税纳税人资格认定编号</td>
                <td align="left" width="50%">
                    <input type="text" name="taxVatNo" value="${slEnterprise.taxVatNo}"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">组织代码证编号</td>
                <td align="left" width="50%">
                    <input type="text" name="orgNo" value="${slEnterprise.orgNo}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">组织代码证开始日期</td>
                <td align="left" width="50%">
                    <input type="text" name="orgTermBegin" id="orgTermBegin" value="<fmt:formatDate value="${slEnterprise.orgTermBegin}" pattern="yyyy-MM-dd" />"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">组织代码证截止日期</td>
                <td align="left" width="50%">
                    <input type="text" name="orgTermEnd" id="orgTermEnd" value="<fmt:formatDate value="${slEnterprise.orgTermEnd}" pattern="yyyy-MM-dd" />"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">银行开户人</td>
                <td align="left" width="50%">
                    <input type="text" name="balLegalPerson" value="${slEnterprise.balLegalPerson}"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">开户银行</td>
                <td align="left" width="50%">
                    <input type="text" name="balBank" value="${slEnterprise.balBank}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">银行账户</td>
                <td align="left" width="50%">
                    <input type="text" name="balAccount" value="${slEnterprise.balAccount}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">食品流通许可证_许可证编号</td>
                <td align="left" width="50%">
                    <input type="text" name="fdlNo" value="${slEnterprise.fdlNo}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">食品流通许可证_开始日期</td>
                <td align="left" width="50%">
                    <input type="text" name="fdlTermBegin" id="fdlTermBegin" value="<fmt:formatDate value="${slEnterprise.fdlTermBegin}" pattern="yyyy-MM-dd" />"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">食品流通许可证_截止日期</td>
                <td align="left" width="50%">
                    <input type="text" name="fdlTermEnd" id="fdlTermEnd" value="<fmt:formatDate value="${slEnterprise.fdlTermEnd}" pattern="yyyy-MM-dd" />"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">营业执照图片上传</td>
                <td align="left" width="50%">
                    <c:if test="${slEnterprise.licType==0}">
                    <input type="file" name="licfile" id="licfileId"/>
                    </c:if>
                    <c:if test="${slEnterprise.licType==1}">
                        <input type="file" name="licfile" id="licfileId" disabled="disabled"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">税务登记证图片上传</td>
                <td align="left" width="50%">
                    <c:if test="${slEnterprise.licType==0}">
                    <input type="file" name="taxfile" id="taxfileId"/>
                    </c:if>
                    <c:if test="${slEnterprise.licType==1}">
                        <input type="file" name="taxfile" id="taxfileId" disabled="disabled"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">组织机构代码证图片上传</td>
                <td align="left" width="50%">
                    <c:if test="${slEnterprise.licType==0}">
                    <input type="file" name="orgfile" id="orgfileId"/>
                    </c:if>
                    <c:if test="${slEnterprise.licType==1}">
                        <input type="file" name="orgfile" id="orgfileId" disabled="disabled"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">银行开户许可证图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="balfile"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">三证合一证照图片上传</td>
                <td align="left" width="50%">
                    <c:if test="${slEnterprise.licType==0}">
                        <input type="file" name="epthrfile" id="epthrfileId" disabled="disabled"/>
                    </c:if>
                    <c:if test="${slEnterprise.licType==1}">
                        <input type="file" name="epthrfile" id="epthrfileId"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL24110102.SAVE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL24110102.js"></script>
