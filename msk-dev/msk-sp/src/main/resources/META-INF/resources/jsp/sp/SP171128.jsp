<%--
    Title:分销正常库存
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="神农客产品库存一览" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">
    <form action="${ctx}/SP171128/search" id="BP112211Form" method="post">
        <input name="filterMap['dayAmount']" type="hidden" value="${dayAmount}" id="dayAmount" />
        <input name="filterMap['startDate']" type="hidden" id="startDate" value="<fmt:formatDate value='${startDate}' pattern='yyyy-MM-dd' />"/>
        <input name="filterMap['endDate']" type="hidden" id="endDate" value="<fmt:formatDate value='${endDate}' pattern='yyyy-MM-dd' />"/>
        <input name="filterMap['cycleCode']" type="hidden" id="cycleCode" value="${cycleCode}"/>
        <input name="loginId" type="hidden" id="loginId" value="${loginId}"/>
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>查询条件</label>
            </h3>
            <table WIDTH="100%">
                <tr>
                    <td  align="right">区域 :</td>
                    <td align="left">　
                        <select width="25px" name="filterMap['lgcsName']"  id="lgcsName">
                            <option value="" selected="true" >--请选择--</option>
                            <c:forEach items="${districtList}" var="district" varStatus="status">
                                <option value="${district.lgcsName}">${district.lgcsName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td align="left"><msk:button buttonValue="查询" buttonId="SP171128.SEARCH" buttonType="button"/>
                </tr>
            </table>
        </div>

        <div>
            <span WIDTH="30%" id="cycle" style="background-color: #FFB48F;font-size:14pt;display:inline-block;height: 30px;;"></span>
            <table id="SP171128_list_grid">
                <thead>
                <tr>
                    <th width="40px"coltype="sno">序号</th>
                    <th coltype="text" width="40px" name="lgcsName">区域</th>
                    <th coltype="text" width="7%" name="pdName">品名</th>
                    <th coltype="text" width="10%" name="machining">配料</th>
                    <th coltype="text" width="10%"  name="feacherName">规格</th>
                    <th coltype="text" width="40px" name="weightVal">净重(kg/箱)</th>
                    <th coltype="text" width="10%" name="pdLevel">产品等级</th>
                    <th style="display: none" width="40px" name="pdCode">产品编码</th>
                    <th coltype="text" width="10%" name="stockWeight">现有库存重量(KG)</th>
                    <th coltype="text" width="30px" name="quotationStatus">报价状态</th>
                    <th coltype="action" width="60px">操作
                        <input type="hidden" value="报价" coltype="check" title="报价" class="h-button" />
                        <input type="hidden" value="查看其它报价" coltype="detail" title="查看其它报价" class="h-button" />
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script src="${ctx}/js/sp/SP171128.js"></script>
