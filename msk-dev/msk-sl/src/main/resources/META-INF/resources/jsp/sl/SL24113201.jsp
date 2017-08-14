<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/comm/taglib.jsp" %>
<div align="center">
    <form:form action="${ctx}/SL24113201/save" id="SL24113201Form"
               metdod="post" enctype="multipart/form-data">
        <input type="hidden" name="artnoId" value="${slPdArtnos.artnoId}"/>
        <input type="hidden" name="slCode" value="${slPdArtnos.slCode}"/>
        <table width="100%" border="0" cellpadding="3" cellspacing="3">
            <tr>
                <td align="right" width="30%">卖家货号码</td>
                <td align="left" width="30%">
                    <input type="text" name="slPdArtno" value="${slPdArtnos.slPdArtno}" readonly="readonly"/>
                </td>
                <td align="right" width="30%" >卖家编码</td>
                <td align="left" width="30%">
                    <input type="text" name="slCodeDis" value="${slPdArtnos.slCodeDis}" readonly="readonly"/>
                </td>
            </tr>
                <tr>
                    <td align="right" width="30%">产品一级分类名称</td>
                    <td align="left" width="30%">
                        <input type="text" name="pdClassesName" value="${slPdArtnos.pdClassesName}" readonly="readonly"/>
                    </td>
                    <td align="right" width="30%">产品二级分类名称</td>
                    <td align="left" width="30%">
                        <input type="text" name="machiningName" value="${slPdArtnos.machiningName}" readonly="readonly"/>
                    </td>
                </tr>
            <tr>
                <td align="right" width="30%">产品品种名称</td>
                <td align="left" width="30%">
                    <input type="text" name="pdBreedName" value="${slPdArtnos.pdBreedName}" readonly="readonly"/>
                </td>
                <td align="right" width="30%">产品特征名称</td>
                <td align="left" width="30%">
                    <input type="text" name="pdFeatureName" value="${slPdArtnos.pdFeatureName}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">净重名称</td>
                <td align="left" width="30%">
                    <input type="text" name="weightName" value="${slPdArtnos.weightName}" readonly="readonly"/>
                </td>
                <td align="right" width="30%">包装名称</td>
                <td align="left" width="30%">
                    <input type="text" name="normsName" value="${slPdArtnos.normsName}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">销售平台</td>
                <td align="left" width="30%">
                    <input type="text" name="salePlatformName" value="${slPdArtnos.salePlatformName}" readonly="readonly"/>
                </td>
                <td align="right" width="30%">品牌商</td>
                <td align="left" width="30%">
                    <input type="text" name="epName" value="${slPdArtnos.epName}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">品牌</td>
                <td align="left" width="30%">
                    <input type="text" name="brandName" value="${slPdArtnos.brandName}" readonly="readonly"/>
                </td>
                <td align="right" width="30%">生成商名称</td>
                <td align="left" width="30%">
                    <input type="text" name="manufactureCode" value="${slPdArtnos.manufactureCode}" readonly="readonly"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">制造商名称</td>
                <td align="left" width="30%">
                    <input type="text" name="factoryCode" value="${slPdArtnos.factoryCode}" readonly="readonly"/>
                </td>
                <td align="right" width="30%">销售地区</td>
                <td align="left" width="30%">
                    <input type="text" name="saleRegionCode" value="${slPdArtnos.saleRegionCode}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">销售状态</td>
                <td align="left" width="30%">
                    <select name="saleStatus">
                        <c:forEach items="${list}" var="listData">
                            <c:if test="${listData.constantValue eq slPdArtnos.saleStatus}">
                                <option value="${listData.constantValue}" selected="selected">${listData.constantName}</option>
                            </c:if>
                            <option value="${listData.constantValue}">${listData.constantName}</option>
                        </c:forEach>
                    </select>
                </td>
                <td align="right" width="30%">国别</td>
                <td align="left" width="30%">
                    <c:if test="${slPdArtnos.pdCountry eq 1}">
                        <input type="radio" name="pdCountry" checked="checked" value="${slPdArtnos.pdCountry}" disabled="disabled"/>国内
                        <input type="radio" name="pdCountry" value="${slPdArtnos.pdCountry}" disabled="disabled"/>国外
                    </c:if>
                    <c:if test="${slPdArtnos.pdCountry eq 2}">
                        <input type="radio" name="pdCountry" value="${slPdArtnos.pdCountry}" disabled="disabled"/>国内
                        <input type="radio" name="pdCountry" checked="checked" value="${slPdArtnos.pdCountry}" disabled="disabled"/>国外
                    </c:if>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">产地</td>
                <td align="left" width="30%">
                    <input type="text" name="pdPlace" value="${slPdArtnos.pdPlace}"/>
                </td>
                <td align="right" width="30%">产品标准号</td>
                <td align="left" width="30%">
                    <input type="text" name="pdStandard" value="${slPdArtnos.pdStandard}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">配料</td>
                <td align="left" width="30%">
                    <input type="text" name="pdIngredient" value="${slPdArtnos.pdIngredient}"/>
                </td>
                <td align="right" width="30%">食品生产许可证号</td>
                <td align="left" width="30%">
                    <input type="text" name="foodLicense" value="${slPdArtnos.foodLicense}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">保质期</td>
                <td align="left" width="30%">
                    <input type="text" name="shelfLife" value="${slPdArtnos.shelfLife}"/>
                </td>
                <td align="right" width="30%">存储条件</td>
                <td align="left" width="30%">
                    <input type="text" name="storageCondition" value="${slPdArtnos.storageCondition}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="30%">包装规格</td>
                <td align="left" width="30%">
                    <input type="text" name="normsSpecification" value="${slPdArtnos.normsSpecification}"/>
                </td>
            </tr>
            <tr>
                <td width="30%"></td>
                <td align="right" width="30%">
                    <msk:button buttonValue="保存" buttonId="SL24113201.SAVE" buttonType="button"/>
                    <msk:button buttonValue="取消" buttonId="SL24113201.BACK" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL24113201.js"></script>
