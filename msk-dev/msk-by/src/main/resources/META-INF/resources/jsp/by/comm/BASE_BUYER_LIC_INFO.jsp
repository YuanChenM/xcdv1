<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marshall
  Date: 16/3/9
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var buyerId=$("#buyerId").val();
    function callbackFun(message){
        HDF.closeLoadingMask();
        $('#main-content').postUrl(Main.contextPath+"/BY121304/init/"+buyerId);
    }
</script>
<div class="group-accordion" collapsible="false" active="true">
    <h3>
        <label>买家证照信息</label>
    </h3>
    <form:form id="licEditForm" metdod="post" enctype="multipart/form-data">
        <input type="hidden" id="buyerId" name="buyerId" value="${buyerId}"/>
        <table id="licShowTable" style="width: 100%"  CellSpacing=8>
            <tr>
                <td width="12.5%" align="right">营业执照类型:</td>
                <td width="12.5%" align="left">${licenceInfo.licDes}</td>
                <td width="12.5%" align="right">营业执照号码:</td>
                <td width="12.5%" align="left">${licenceInfo.licNumber}</td>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <td width="12.5%" align="right">法定代表人姓名:</td>
                <td width="12.5%" align="left">${licenceInfo.legalName}</td>
                <td width="12.5%" align="right">法定代表人证件类型:</td>
                <td width="12.5%" align="left">${licenceInfo.legalLicDes}</td>
                <td width="12.5%" align="right">法定代表人证件号码:</td>
                <td width="12.5%" align="left">${licenceInfo.legalLicNumber}</td>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <c:if test="${licencePic.picLicensePath != null && licencePic.picLicensePath != ''}">
                <tr align="center">
                    <td width="12.5%" align="right">营业执照</td>
                    <td colspan="3" width="62.5%" align="right"><img src="${licencePic.picLicensePath}" height="200px" width="200px"/></td>
                </tr>
            </c:if>
            <c:if test="${licencePic.picOrgStructurePath != null && licencePic.picOrgStructurePath != ''}">
                <tr align="center">
                    <td width="12.5%" align="right">组织机构代码证</td>
                    <td colspan="3" width="62.5%" align="right"><img src="${licencePic.picOrgStructurePath}" height="200px" width="200px"/></td>
                </tr>
            </c:if>
            <c:if test="${licencePic.picTaxRegistrationPath != null && licencePic.picTaxRegistrationPath != ''}">
                <tr align="center">
                    <td width="12.5%" align="right">税务登记证</td>
                    <td colspan="3" width="62.5%" align="right"><img src="${licencePic.picTaxRegistrationPath}" height="200px" width="200px"/></td>
                </tr>
            </c:if>
            <c:if test="${licencePic.picFoodCirculationPath != null && licencePic.picFoodCirculationPath != ''}">
                <tr align="center">
                    <td width="12.5%" align="right">食品流通许可证</td>
                    <td colspan="3" width="62.5%" align="right"><img src="${licencePic.picFoodCirculationPath}" height="200px" width="200px"/></td>
                </tr>
            </c:if>
            <c:if test="${licencePic.picCertPath != null && licencePic.picCertPath != ''}">
                <tr align="center">
                    <td width="12.5%" align="right">法定代表人证</td>
                    <td colspan="3" width="62.5%" align="right"><img src="${licencePic.picCertPath}" height="200px" width="200px"/></td>
                </tr>
            </c:if>
            <tr>
            <td width="12.5%" align="right">
                <msk:button buttonValue="编辑" buttonId="BuyerLic.Edit" buttonType="button"/>
            </td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
        </table>
        <table id="licEditTable" style="width: 100%;display:none;"  CellSpacing=8>
            <tr>
                <td width="12.5%" align="right">营业执照类型:</td>
                <td width="12.5%" align="left">
                    <select id="licName" name="licName">
                        <c:forEach items="${licTypeList}" var="licType">
                            <c:choose>
                                <c:when test="${licenceInfo.licName eq licType.constantValue}">
                                    <option value="${licType.constantValue}" selected>${licType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${licType.constantValue}">${licType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%" align="right">营业执照号码:</td>
                <td width="12.5%" align="left">
                    <input type="text" id="licNumber" name="licNumber" value="${licenceInfo.licNumber}">
                </td>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <td width="12.5%" align="right">法定代表人姓名:</td>
                <td width="12.5%" align="left">
                    <input type="text" id="legalName" name="legalName" value="${licenceInfo.legalName}"></td>
                <td width="12.5%" align="right">法定代表人证件类型:</td>
                <td width="12.5%" align="left">
                    <select id="legalLicType" name="legalLicType">
                        <c:forEach items="${legalLicTypeList}" var="legalLicType">
                            <c:choose>
                                <c:when test="${licenceInfo.legalLicType eq legalLicType.constantValue}">
                                    <option value="${legalLicType.constantValue}" selected>${legalLicType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${legalLicType.constantValue}">${legalLicType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%" align="right">法定代表人证件号码:</td>
                <td width="12.5%" align="left">
                    <input type="text" id="legalLicNumber" name="legalLicNumber" value="${licenceInfo.legalLicNumber}"></td>
                </td>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <td width="12.5%" align="right">营业执照:</td>
                <td width="12.5%" align="left">
                    <input type="file" name="busLicPic"/>
                </td>
                <td width="12.5%" align="right">组织机构代码证:</td>
                <td width="12.5%" align="left">
                    <input type="file" name="orgCertificatePic"/>
                </td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">税务登记证:</td>
                <td width="12.5%" align="left">
                    <input type="file" name="taxCertificatePic"/>
                </td>
                <td width="12.5%" align="right">食品流通许可证:</td>
                <td width="12.5%">
                    <input type="file" name="foodCertificatePic"/>
                </td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">法定代表人证:</td>
                <td width="12.5%" align="left">
                    <input type="file" name="legalCertificatePic"/>
                </td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">
                    <msk:button buttonValue="保存" buttonId="BuyerLic.Save" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<script type="text/javascript" src="${ctx}/js/by/comm/BASE_BUYER_LIC_INFO.js"></script>