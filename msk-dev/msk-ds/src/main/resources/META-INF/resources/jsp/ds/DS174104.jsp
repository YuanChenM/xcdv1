<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="供应商库存在线查看" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="" active="false">
        <h3>
            <label>查询条件</label>
        </h3>
        <form:form action="${ctx}/SC181102/init" id="SC181102Form" method="post">
            <%--<input type="hidden" name="currenthalfCode" id="currenthalfCode" value="${halfParam.currentHalfCode}"/>--%>
            <table width="100%">
                <tbody>
                <tr>供应商库存在线查看</tr>

                <br>
                <br>
               <tr>
                    <td width="15%" align="center" style="background:#DBDBDB">销售区域</td>
                    <td align="left" width="25%">
                        <select name="distMonth" id="distMonth2">
                            <option value="" selected>请选择</option>
                            <option value="华东地区" >华东地区</option>
                            <option value="华南地区">华南地区</option>
                        </select>
                    </td>
                    <td width="60%"></td>
                </tr>

                <tr>
                    <td width="15%" align="center" style="background:#DBDBDB">供应商</td>
                    <td align="left" width="25%">
                        <select name="distMonth" id="distMonth1">
                            <option value="" selected>请选择</option>
                            <option value="上海咸驰达公司" >上海咸驰达公司</option>
                            <option value="上海甜驰达公司">上海甜驰达公司</option>
                        </select>
                    </td>
                    <td width="60%"></td>
                </tr>

                <tr>
                    <td width="15%" align="center" style="background:#DBDBDB">产品</td>
                    <td align="left" width="25%">
                         <input name="productName" id="productName" value="${halfParam.productName}"/>
                    </td>
                    <td width="60%"></td>
                </tr>

                <tr>
                    <td colspan="2">
                        <input style="width:90%" align="right"  name="productName" id="productName1" value="2016年02月24日产品库存数据"/>
                    </td>
                    <td><msk:button buttonValue="查询" buttonId="SC181102.SEARCH" buttonType="button"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>
    </div>

    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>供应商库存在线查看</label>
        </h3>
        <div>
            <table class="dataTable no-footer" id="SC181102ProductTable" style="width: 100%">
                <thead>
                <tr style="background:#DBDBDB">
                    <th>产品名称</th>
                    <th>产品规格</th>
                    <th>月度计划供应量(KG)</th>
                    <th>月度未完成计划供应量</th>
                    <th>计划生产量</th>
                    <th>待运库入库量</th>
                    <th>在途产品量</th>
                    <th>物流区销售库存量</th>
                    <th>在线三旬销售量预测</th>
                    <th>销售安全库存量</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:set var="s" value="0"></c:set>
                <c:set var="s1" value="0"></c:set>
                <c:set var="s2" value="0"></c:set>
                <c:set var="s3" value="0"></c:set>
                <c:set var="s4" value="0"></c:set>
                <c:set var="s5" value="0"></c:set>
                <c:set var="s6" value="0"></c:set>
                <c:set var="s7" value="0"></c:set>
                <c:forEach items="${biglist}" var="biglist" varStatus="j">

                <c:set var="sum" value="0"></c:set>
                <c:set var="sum1" value="0"></c:set>
                <c:set var="sum2" value="0"></c:set>
                <c:set var="sum3" value="0"></c:set>
                <c:set var="sum4" value="0"></c:set>
                <c:set var="sum5" value="0"></c:set>
                <c:set var="sum6" value="0"></c:set>
                <c:set var="sum7" value="0"></c:set>
                <c:forEach items="${biglist.list}" var="item" varStatus="i">
                <tr>


                    <c:if test="${i.index==0}">
                        <td rowspan="${fn:length(biglist.list)+1}">${item.classes}</td>
                    </c:if>

                    <td>${item.two}</td>


                    <td>${item.three}</td>
                    <c:set var="sum" value="${item.three+sum}"></c:set>

                    <td>${item.four}</td>
                    <c:set var="sum1" value="${item.four+sum1}"></c:set>

                    <td>${item.five}</td>
                    <c:set var="sum2" value="${item.five+sum2}"></c:set>

                    <td>${item.six}</td>
                    <c:set var="sum3" value="${item.six+sum3}"></c:set>

                    <td>${item.serven}</td>
                    <c:set var="sum4" value="${item.serven+sum4}"></c:set>

                    <td>${item.eight}</td>
                    <c:set var="sum5" value="${item.eight+sum5}"></c:set>

                    <td>${item.nine}</td>
                    <c:set var="sum6" value="${item.nine+sum6}"></c:set>

                    <td>${item.ten}</td>
                    <c:set var="sum7" value="${item.ten+sum7}"></c:set>

                    <c:if test="${i.index==0}">
                        <td rowspan="${fn:length(biglist.list)+1}"><msk:button buttonValue="计划调整" buttonId="SC181102.SEARCH" buttonType="button"/></td>
                    </c:if>

                </tr>
                </c:forEach>



                <tr style="background:#DBDBDB">
                    <td align="center">小计</td>
                    <td>${sum}</td>
                    <c:set var="s" value="${sum+s}"></c:set>
                    <td>${sum1}</td>
                    <c:set var="s1" value="${sum1+s1}"></c:set>
                    <td>${sum2}</td>
                    <c:set var="s2" value="${sum2+s2}"></c:set>
                    <td>${sum3}</td>
                    <c:set var="s3" value="${sum3+s3}"></c:set>
                    <td>${sum4}</td>
                    <c:set var="s4" value="${sum4+s4}"></c:set>
                    <td>${sum5}</td>
                    <c:set var="s5" value="${sum5+s5}"></c:set>
                    <td>${sum6}</td>
                    <c:set var="s6" value="${sum6+s6}"></c:set>
                    <td>${sum7}</td>
                    <c:set var="s7" value="${sum7+s7}"></c:set>
                </tr>
                </c:forEach>

                <tr style="background:#DBDBDB">
                    <td colspan="2" align="center">总计</td>
                    <td>${s}</td>
                    <td>${s1}</td>
                    <td>${s2}</td>
                    <td>${s3}</td>
                    <td>${s4}</td>
                    <td>${s5}</td>
                    <td>${s6}</td>
                    <td>${s7}</td>
                    <td></td>

                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
<%--<script type="text/javascript" src="${ctx}/js/ds/SC181102.js"></script>--%>

