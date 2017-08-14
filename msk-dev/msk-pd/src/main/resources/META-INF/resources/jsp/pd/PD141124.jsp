<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:正式上线修改添加
    author:pxg
    createDate:2016-02-23
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="产品分类目录管理" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content detail-page" style="height:100%">
    <div class="group-accordion" collapsible="false" active="false" >
        <h3 style="position: relative">
            <label>查询条件</label>
        </h3>
        <div style="padding-left: 0px;padding-top: 0px;padding-bottom: 0px;padding-right: 0px;">
            <!--Modify 改善 #2615 产品系统录入慢，影响操作，需要优化 2016/09/20 by 杨春艳 Start-->
            <input type = "hidden" id="classtxt" value="${classesCode}">
            <input type = "hidden" id="machiningtxt" value="${machiningCode}">
            <input type = "hidden" id="breedtxt" value="${breedCode}">
            <input type = "hidden" id="featuretxt" value="${featureCode}">
            <input type = "hidden" id="weighttxt" value="${weightCode}">
            <!--Modify 改善 #2615 产品系统录入慢，影响操作，需要优化 2016/09/20 by 杨春艳 End-->
            <form>
                <table>
                    <tr>
                        <table>
                            <tr>
                                <td>
                                    <!--Modify 改善 #2615 产品系统录入慢，影响操作，需要优化 2016/09/20 by 杨春艳 Start-->
                                    第一级分类：<select id="oneClass" style="width:135px;" name="classesCode">
                                    <option value="0">--请选择--</option>
                                    <c:forEach items="${classesList}" var="list">
                                        <option value="${list.levelCode}" <c:if test="${list.levelCode==classesCode}">selected</c:if>>${list.levelName}</option>
                                    </c:forEach>
                                </select>
                                </td>
                                <td>
                                    第二级分类：<select id="twoClass" style="width:135px;" name="machiningCode">
                                    <option value="">--请选择--</option>
                                    <if test="!empty machiningList">
                                        <c:forEach items="${machiningList}" var="list">
                                            <option value="${list.levelCode}" <c:if test="${list.levelCode==machiningCode}">selected</c:if>>${list.levelName}</option>
                                        </c:forEach>
                                    </if>
                                </select>
                                </td>
                                <td>
                                    第三级分类：<select id="threeClass" style="width:135px;" name="breedCode">
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${breedList}" var="list">
                                        <option value="${list.levelCode}" <c:if test="${list.levelCode==breedCode}">selected</c:if>>${list.levelName}</option>
                                    </c:forEach>
                                </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    第四级分类：<select id="fourClass" style="width:135px;" name="featureCode">
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${featureList}" var="list">
                                        <option value="${list.levelCode}" <c:if test="${list.levelCode==featureCode}">selected</c:if>>${list.levelName}</option>
                                    </c:forEach>
                                </select>
                                </td>
                                <td>
                                    第五级分类：<select id="fiveClass" style="width:135px;" name="weightCode">
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${weightList}" var="list">
                                        <option value="${list.levelCode}" <c:if test="${list.levelCode==weightCode}">selected</c:if>>${list.levelName}</option>
                                    </c:forEach>
                                </select>
                                    <!--Modify 改善 #2615 产品系统录入慢，影响操作，需要优化 2016/09/20 by 杨春艳 End-->
                                </td>
                                <td>
                                    <msk:button buttonValue="查询" buttonId="PD141124.SEARCH" buttonType="button"/>
                                </td>
                            </tr>
                        </table>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div id="PD14112406Id"/>
</div>
<script src="${ctx}/js/pd/PD141124.js"></script>
