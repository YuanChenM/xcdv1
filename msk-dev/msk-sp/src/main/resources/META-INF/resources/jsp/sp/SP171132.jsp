<%--
    Title:发布需求数量-产品选择
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发布需求数量-产品选择" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">
    <form action="${ctx}/SP171132/search" id="SP171132Form" method="post">
        <input name="filterMap['dayAmount']" type="hidden" value="${dayAmount}" id="dayAmount" />
        <input name="filterMap['startDate']" type="hidden" id="startDate" value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd' />"/>
        <input name="filterMap['endDate']" type="hidden" id="endDate" value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd' />"/>
        <input name="filterMap['cycleCode']" type="hidden" id="cycleCode" value="${cycleCode}"/>
        <input name="loginId" type="hidden" id="loginId" value="${loginId}"/>
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>产品选择</label>
            </h3>
            <table WIDTH="100%">
                <tr>
                    <td width="10%" align="right">一级分类</td>
                    <td align="left">
                        <select name="distMonth" id="distMonth">
                            <c:forEach items="${distMonth.distMonthList}" var="dist">
                                <c:choose>
                                    <c:when test="${halfParam.distMonth eq dist.distMonth}">
                                        <option value="${dist.distMonth}" selected>${dist.distMonth}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dist.distMonth}">${dist.distMonth}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="10%" align="right">品种</td>
                    <td align="left">
                        <select name="areaCode" id="areaCode">
                            <%--<option value='-1'>--请选择--</option>--%>
                            <c:forEach items="${halfParam.areaInfoList}" var="areaInfo">
                                <c:choose>
                                    <c:when test="${halfParam.areaCode eq areaInfo.areaCode}">
                                        <option value="${areaInfo.areaCode}" selected>${areaInfo.areaName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${areaInfo.areaCode}">${areaInfo.areaName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="10%" align="right">二级分类</td>
                    <td align="left">
                        <select name="distMonth" id="distMonth">
                            <c:forEach items="${distMonth.distMonthList}" var="dist">
                                <c:choose>
                                    <c:when test="${halfParam.distMonth eq dist.distMonth}">
                                        <option value="${dist.distMonth}" selected>${dist.distMonth}</option>
                                        <%-- <option value="201602" selected>201602</option>--%>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${dist.distMonth}">${dist.distMonth}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="10%" align="right">特征</td>
                    <td align="left">
                        <select name="areaCode" id="areaCode">
                            <%--<option value='-1'>--请选择--</option>--%>
                            <c:forEach items="${halfParam.areaInfoList}" var="areaInfo">
                                <c:choose>
                                    <c:when test="${halfParam.areaCode eq areaInfo.areaCode}">
                                        <option value="${areaInfo.areaCode}" selected>${areaInfo.areaName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${areaInfo.areaCode}">${areaInfo.areaName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td>
                    <td align="left"><msk:button buttonValue="查询" buttonId="SP171132.SEARCH" buttonType="button"/></td>
                </tr>
            </table>
        </div>

        <div>
            <span WIDTH="30%" id="cycle" style="background-color: #FFB48F;font-size:14pt;display:inline-block;height: 30px;;"></span>
            <table id="SP171132_list_grid">
                <thead>
                <tr>
                    <th width="40px"coltype="sno">序号</th>
                    <th style="display: none" width="40px" name="pricecycleId">报价ID</th>
                    <th style="display: none" width="40px" name="lgcsCode">区域编号</th>
                    <th style="display: none" width="40px" name="slCode">卖家编号</th>
                    <th style="display: none" width="40px" name="slName">区域编号</th>
                    <th style="display: none" width="40px" name="pdCode">产品编号</th>
                    <th coltype="text" width="40px" name="lgcsName">区域</th>
                    <th coltype="text" width="7%" name="pdName">品名</th>
                    <th coltype="text" width="10%" name="machining">配料</th>
                    <th coltype="text" width="10%"  name="feacherName">规格</th>
                    <th coltype="text" width="40px" name="weightVal">净重(kg/箱)</th>
                    <th coltype="text" width="10%" name="pdLevel">产品等级</th>
                    <th coltype="text" width="10%" name="stockWeight">现有库存重量(KG)</th>
                    <th coltype="text" width="30px" name="quotationStatus">报价状态</th>
                    <th coltype="action" width="60px">操作
                        <input type="hidden" value="报价" coltype="check" title="报价" class="h-button" />
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script src="${ctx}/js/sp/SP171132.js"></script>
