<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:发货计划单录入
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发货计划单录入" backTitleArray="" backUrlArray="${ctx}"></navigation:header>

<div class="page-content list-page">
    <form action="${ctx}/SC181103/search" id="SC181103Form" method="post">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>
            <table WIDTH="100%">
                <tr>
                    <td width="10%" align="right">物流区名称</td>
                    <td align="left">
                        <select name="lgcsCode" id="lgcsCode">
                            <%--<option value='-1'>--请选择--</option>--%>
                            <c:forEach items="${areaList}" var="areaInfo">
                                <c:choose>
                                    <c:when test="${lgcsCode eq areaInfo.lgcsCode}">
                                        <option value="${areaInfo.lgcsCode}" selected>${areaInfo.lgcsName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${areaInfo.lgcsCode}">${areaInfo.lgcsName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <input type="hidden" name="lgcsName" id ="lgcsName" value="${lgcsName}"/>
                    <td width="8%" align="right">供应商</td>
                    <td align="left">
                        <select name="suppCode" id="suppCode">
                            <%--<option value='-1'>--请选择--</option>--%>
                            <c:forEach items="${suppList}" var="suppInfo">
                                <c:choose>
                                    <c:when test="${suppCode eq suppInfo.suppCode}">
                                        <option value="${suppInfo.suppCode}" selected>${suppInfo.suppName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${suppInfo.suppCode}">${suppInfo.suppName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="10%" align="right">分销月度</td>
                    <td  align="left">　
                        <input type="text" id="distMonth" name="distMonth" value="${distMonth}" readonly="true"/>
                    </td>
                    <%--<td align="left"><msk:button buttonValue="查询" buttonId="SC181103.SEARCH" buttonType="button"/></td>--%>
                </tr>
            </table>
        </div>

        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>计划发货明细（按车次发货）</label>
            </h3>
            <div>
                <table id="SC181103_list_grid" width="100%">
                    <thead>
                    <tr>
                        <th coltype="sno">序号</th>
                        <th coltype="text" width="10%" name="pdCode">产品编码</th>
                        <th coltype="text" width="9%" name="classesName">分类</th>
                        <th coltype="text" width="9%" name="breedName" filter="true">品种</th>
                        <th coltype="text" width="9%" name="featureName" filter="true">特征</th>
                        <th coltype="select" width="9%" name="gradeName" selectValue="gradeCode" readonly="true">等级
                            <select>
                                <c:forEach items="${pdGradeList}" var="pdGrade">
                                    <option value="${pdGrade.gradeCode}">${pdGrade.gradeName}</option>
                                </c:forEach>

                            </select>
                        </th>
                        <th coltype="select" width="9%" name="brandTypeName" selectValue="brandType" filter="true">品牌
                            <select>
                                <c:forEach items="${brandTypeList}" var="brandType1">
                                    <option value="${brandType1.constantValue}">${brandType1.constantName}</option>
                                </c:forEach>
                            </select>
                        </th>
                        <th coltype="text" width="9%" name="productSpecifical">外包装规格</th>
                        <th coltype="text" width="9%" name="netWeight">净重</th>
                        <th coltype="text" width="9%" name="manuName" filter="true">生产商</th>
                        <th coltype="select" width="9%" name="halfName" cellEditMode="true" edit="true" selectValue="halfCode">半旬
                            <select>
                                <option value="1">21-25日</option>
                                <option value="2">26-N日</option>
                                <option value="3">1-5日</option>
                                <option value="4">6-10日</option>
                                <option value="5">11-15日</option>
                                <option value="6">16-20日</option>
                            </select>
                        </th>
                        <th coltype="text" name="packNum" id="packNum" cellEditMode="true" edit="true" width="9%" maxlength="22">数量（KG）</th>
                        <%--<th coltype="action" width="9%">操作--%>
                            <%--<msk:button buttonValue="保存" buttonId="SC181103.SAVE" buttonType="hidden" coltype="detail" class="h-button" title="保存"/>--%>
                        <%--</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            <msk:button buttonValue="保存" buttonId="SC181103.SAVE" buttonType="button"/>
            </div>
        </div>
    </form>
</div>
<script src="${ctx}/static/ds/js/SC181103.js"></script>
<%--<script type="text/javascript" src="${ctx}/js/ds/SC181103.js"></script>--%>
