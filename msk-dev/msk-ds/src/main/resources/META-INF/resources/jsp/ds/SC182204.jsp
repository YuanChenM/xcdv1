<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="产品批次明细生成" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form:form action="${ctx}/SC182204/save" id="SC182204Form" method="post">
    <div class="group-accordion" collapsible="" active="false">
        <h3>
            <label>查询条件</label>
        </h3>
        <div>
            <table width="100%">
                    <tbody>
                    <tr>
                        <td width="10%" align="right">半旬期</td>
                        <td align="left">
                            <input type="text" name="halfPeriod" value="${halfPeriod}" readonly="true" style="background:#DBDBDB" />
                        </td>
                        <td width="10%" align="right">销售区域</td>
                        <td align="left">
                            <select name="lgcsCode" id="lgcsCode">
                                <c:forEach items="${sc182204Bean.lgcsAreaList}" var="areaInfo">
                                    <c:choose>
                                        <c:when test="${sc182204Bean.lgcsCode eq areaInfo.lgcsCode}">
                                            <option value="${areaInfo.lgcsCode}" selected>${areaInfo.lgcsName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${areaInfo.lgcsCode}">${areaInfo.lgcsName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="8%" align="right">供应商</td>
                        <td align="left">
                            <select name="suppCode" id="suppCode">
                                <c:forEach items="${sc182204Bean.supplyList}" var="suppInfo">
                                    <c:choose>
                                        <c:when test="${sc182204Bean.suppCode eq suppInfo.suppCode}">
                                            <option value="${suppInfo.suppCode}" selected>${suppInfo.suppName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${suppInfo.suppCode}">${suppInfo.suppName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="8%" align="right">&nbsp;&nbsp;</td>
                        <td align="left"><msk:button buttonValue="查询" buttonId="SC182204.SEARCH" buttonType="button"/></td>
                    </tr>
                    </tbody>
            </table>
        </div>
    </div>
    <div class="group-accordion" collapsible="true" active="true" >
        <h3>
            <label>产品批次明细</label>
        </h3>

        <div>
            <%--
            <table class="dataTable no-footer" id="SC182204ProductTable" style="width: 100%">
                <tr>
                    <td width="91" rowspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">选择</td>
                    <td colspan="6" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品属性</td>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">品质属性</td>
                    <td width="71" rowspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">总箱数</td>
                    <td width="128" rowspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold"><p>品牌</p>
                        <p>Logo</p></td>
                    <td width="196" rowspan="2" align="center" bgcolor="#CCCCCC" style="font-weight:bold">条形主码</td>
                </tr>
                <tr>
                    <td width="61" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品类别</td>
                    <td width="59" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品名称</td>
                    <td width="96" align="center" bgcolor="#CCCCCC" style="font-weight:bold">配料</td>
                    <td width="80" align="center" bgcolor="#CCCCCC" style="font-weight:bold">规格</td>
                    <td width="76" align="center" bgcolor="#CCCCCC" style="font-weight:bold">净重</td>
                    <td width="74" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品等级</td>
                    <td width="95" align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产日期</td>
                    <td width="89" align="center" bgcolor="#CCCCCC" style="font-weight:bold">保质期</td>
                    <td width="162" align="center" bgcolor="#CCCCCC" style="font-weight:bold">储存方法</td>
                    <td width="210" align="center" bgcolor="#CCCCCC" style="font-weight:bold">食品生产许可证</td>
                </tr>
                <tr>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产商</td>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产商地址</td>
                    <td align="center" bgcolor="#CCCCCC" style="font-weight:bold">生产商电话</td>
                    <td rowspan="2" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产地</td>
                    <td rowspan="2" align="center" bgcolor="#CCCCCC" style="font-weight:bold">打印页码</td>
                </tr>
                <tr>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">授权商</td>
                    <td colspan="4" align="center" bgcolor="#CCCCCC" style="font-weight:bold">授权商地址</td>
                    <td align="center" bgcolor="#CCCCCC" style="font-weight:bold">授权商电话</td>
                </tr>
                <c:forEach items="${stockActualList}" var="stockActual" varStatus="i">
                    <tr>
                        <td rowspan="3" align="center"><input type="checkbox" name="productParamList[${i.index}].checkbox" id="checkbox" value="0"/>&nbsp;</td>
                        <td>&nbsp;${stockActual.productBean.pdClasses.classesName}</td>
                        <td>&nbsp;${stockActual.productBean.pdBreed.breedName}</td>
                        <td>&nbsp;${stockActual.productBean.pdMachining.machiningName}</td>
                        <td>&nbsp;${stockActual.productBean.pdFeature.featureName}</td>
                        <td>&nbsp;${stockActual.productBean.pdWeight.weightName}</td>
                        <td>&nbsp;${stockActual.productBean.pdGrade.gradeName}</td>
                        <input type="hidden" name="productParamList[${i.index}].classesCode" id="classesCode" value="${stockActual.productBean.pdClasses.classesCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].machiningCode" id="machiningCode" value="${stockActual.productBean.pdMachining.machiningCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].breedCode" id="breedCode" value="${stockActual.productBean.pdBreed.breedCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].featureCode" id="featureCode" value="${stockActual.productBean.pdFeature.featureCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].weightCode" id="weightCode" value="${stockActual.productBean.pdWeight.weightCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].gradeCode" id="gradeCode" value="${stockActual.productBean.pdGrade.gradeCode}"/>

                        <td>&nbsp;<input type="text" name="productParamList[${i.index}].manuDate" id="manuDate" value="" size="10"/></td>
                        <td><label>&nbsp;
                            <input type="text" name="productParamList[${i.index}].shelfLife" id="shelfLife" value="" size="10"/></label></td>
                        <td>&nbsp;<input type="text" name="productParamList[${i.index}].storCondition" id="storCondition" value="" size="15"/></td>
                        <td>&nbsp;<input type="text" name="productParamList[${i.index}].foodManuLicen" id="foodManuLicen" value="" size="30"/></td>
                        <td rowspan="3">&nbsp;${stockActual.sumNewActNum}</td>
                        <input type="hidden" name="productParamList[${i.index}].sumNewActNum" id="sumNewActNum" value="${stockActual.sumNewActNum}"/>
                        <td rowspan="3">&nbsp;</td>
                        <td rowspan="2">&nbsp;${stockActual.proLotNum}</td>
                        <input type="hidden" name="productParamList[${i.index}].proLotNum" id="proLotNum" value="${stockActual.proLotNum}"/>
                    </tr>

              <tr>
                  <td colspan="4">&nbsp;<input type="text" name="productParamList[${i.index}].client" id="client" value="" size="55"/></td>
                  <td colspan="4">&nbsp;<input type="text" name="productParamList[${i.index}].clientAddr" id="clientAddr" value="" size="58"/></td>
                  <td>&nbsp;<input type="text" name="productParamList[${i.index}].clientPhone" id="clientPhone" value="" size="15"/></td>
                  <td colspan="2" rowspan="2">&nbsp;<input type="text" name="productParamList[${i.index}].manuOrigin" id="manuOrigin" value="" size="30"/></td>
              </tr>
              <tr>
                  <td colspan="4">&nbsp;<input type="text" name="productParamList[${i.index}].unClient" id="unClient" value="" size="55"/></td>
                  <td colspan="4">&nbsp;<input type="text" name="productParamList[${i.index}].unClientAddr" id="unClientAddr" value="" size="58"/></td>
                  <td>&nbsp;<input type="text" name="productParamList[${i.index}].unClientPhone" id="unClientPhone" value="" size="15"/></td>
                  <td>&nbsp;${stockActual.productPrintNum}</td>
                  <input type="hidden" name="productParamList[${i.index}].productPrintNum" id="productPrintNum" value="${stockActual.productPrintNum}"/>
                  <input type="hidden" name="productParamList[${i.index}].halfPeriod" id="halfPeriod" value="${stockActual.halfPeriod}"/>
                  <input type="hidden" name="productParamList[${i.index}].normsCode" id="normsCode" value="${stockActual.normsCode}"/>
              </tr>
              </c:forEach>
          </table>
          --%>

                <table class="dataTable no-footer" id="SC182204ProductTable" style="width: 100%">
                    <tr>
                        <td width="55" align="center" bgcolor="#CCCCCC" style="font-weight:bold">选择</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品类别</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品名称</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">配料</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">规格</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">净重</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">产品等级</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">总箱数</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">品牌Logo</td>
                        <td width="200" align="center" bgcolor="#CCCCCC" style="font-weight:bold">操作码</td>
                        <td width="200" align="center" bgcolor="#CCCCCC" style="font-weight:bold">阅读码</td>
                        <td width="85" align="center" bgcolor="#CCCCCC" style="font-weight:bold">打印页码</td>
                    </tr>
                    <c:forEach items="${stockActualList}" var="stockActual" varStatus="i">
                    <tr>
                        <td height="30" align="center"><input type="checkbox" name="productParamList[${i.index}].checkbox" id="checkbox" value="0"/>&nbsp;</td>
                        <td>&nbsp;${stockActual.productBean.pdClasses.classesName}</td>
                        <td>&nbsp;${stockActual.productBean.pdBreed.breedName}</td>
                        <td>&nbsp;${stockActual.productBean.pdMachining.machiningName}</td>
                        <td>&nbsp;${stockActual.productBean.pdFeature.featureName}</td>
                        <td>&nbsp;${stockActual.productBean.pdWeight.weightName}</td>
                        <td>&nbsp;${stockActual.productBean.pdGrade.gradeName}</td>
                        <input type="hidden" name="productParamList[${i.index}].classesCode" id="classesCode" value="${stockActual.productBean.pdClasses.classesCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].machiningCode" id="machiningCode" value="${stockActual.productBean.pdMachining.machiningCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].breedCode" id="breedCode" value="${stockActual.productBean.pdBreed.breedCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].featureCode" id="featureCode" value="${stockActual.productBean.pdFeature.featureCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].weightCode" id="weightCode" value="${stockActual.productBean.pdWeight.weightCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].gradeCode" id="gradeCode" value="${stockActual.productBean.pdGrade.gradeCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].sumNewActNum" id="sumNewActNum" value="${stockActual.sumNewActNum}"/>
                        <input type="hidden" name="productParamList[${i.index}].proLotNum" id="proLotNum" value="${stockActual.proLotNum}"/>
                        <input type="hidden" name="productParamList[${i.index}].readProLotNum" id="readProLotNum" value="${stockActual.readProLotNum}"/>
                        <input type="hidden" name="productParamList[${i.index}].productPrintNum" id="productPrintNum" value="${stockActual.productPrintNum}"/>
                        <input type="hidden" name="productParamList[${i.index}].lgcsCode" id="lgcs" value="${stockActual.lgcsCode}"/>
                        <input type="hidden" name="productParamList[${i.index}].suppCode" id="supp" value="${stockActual.suppCode}"/>
                        <td>&nbsp;${stockActual.sumNewActNum}</td>
                        <td>&nbsp;</td>
                        <td>&nbsp;${stockActual.proLotNum}</td>
                        <td>&nbsp;${stockActual.readProLotNum}</td>
                        <td>&nbsp;${stockActual.productPrintNum}</td>
                    </tr>
                    </c:forEach>
                    </table>


            <c:if test="${stockActualList!= null && fn:length(stockActualList) > 0}">
          <td align="right"><msk:button buttonValue="标签数据产生" name="SC182204.SAVE"  buttonId="SC182204.SAVE" buttonType="button"/></td>
            </c:if>
      </div>
  </div>
  </form:form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/SC182204.js"></script>
