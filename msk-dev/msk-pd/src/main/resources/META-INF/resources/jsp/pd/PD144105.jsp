<%--
    Title:产品楼层新增页面
    author:ren_qiang
    createDate:2016-10-28
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>

<style>

    /*  ._sel{
           width: 64%;
       }
    .td_label{
        width: 22%;
    }*/


</style>


<div class="page-content list-page">
    <form action="${ctx}/PD144105/search" method="post" id="pd144105FormId">
        <input type="hidden" name="floorId" id="floorId" value="${param.floorId}"/>
        <input type="hidden" name="lgcsCode" id="lgcsCode" value="${param.lgcsCode}"/>
        <input type="hidden" name="lgcsName" id="lgcsName" value="${param.lgcsName}"/>
        <input type="hidden" name="color" id="color" value="${param.color}"/>
        <input type="hidden" name="isEdit" id="isEdit" value="${param.isEdit}"/>
        <input type="hidden" name="floorName" id="floorName" value="${param.floorName}"/>

        <div class="group-accordion" collapsible="false" active="false">
            <h3>
                <label>产品查询</label>
            </h3>
            <table width="100%">
                <tr>
                    <td align="right" class="td_label">
                        一级分类
                    </td>
                    <td align="" class="td_value">
                        <select class="_sel" id="classesCode" name="classesCode">
                            <option value="">==请选择==</option>
                            <c:forEach items="${pdClasseslst}" var="pdClasses" varStatus="i">
                                <option value="${pdClasses.classestreeCode}">
                                        ${pdClasses.levelName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td align="right">
                        二级分类
                    </td>
                    <td align="" class="td_value">
                        <select class="_sel" id="machiningCode" name="machiningCode">
                            <option value="">==请选择==</option>
                        </select>
                    </td>

                    <td class="td_name" align="right">品种</td>
                    <td class="td_value">
                        <input type="hidden" name="breadName" id="breadName1" value=""/>
                        <select class="_sel" name="breedCode" id="breedCode">
                            <option value="">==请选择==</option>

                        </select>
                    </td>
                </tr>

                <tr>
                    <td class="td_name" align="right">特征</td>
                    <td class="td_value">
                        <input type="hidden" name="featureName" id="featureName"/>
                        <select class="_sel" name="featureCode" id="featureCode">
                            <option value="">==请选择==</option>

                        </select>
                    </td>

                    <td class="td_name" align="right">净重</td>
                    <td class="td_value">
                        <input type="hidden" name="weightName" id="weightName"/>
                        <select class="_sel" name="weightCode" id="weightCode">
                            <option value="">==请选择==</option>

                        </select>
                    </td>

                    <td class="td_name" align="right">等级</td>
                    <td class="td_value">
                        <input type="hidden" name="gradeName" id="gradeName"/>
                        <select class="_sel" name="gradeCode" id="gradeCode">
                            <option value="">==请选择==</option>
                            <c:forEach items="${gradeList}" var="pdGrade" varStatus="i">
                                <option value="${pdGrade.gradeCode}">${pdGrade.gradeName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        <msk:button buttonId="PD144105.SEARCH" buttonType="button" buttonValue="查询"></msk:button>
                    </td>

                </tr>

            </table>

        </div>
        <div class="group-accordion" collapsible="false" active="false">
            <h3>
                <label>楼层产品信息</label>
            </h3>

            <div>
                <table class="accordion" id="PD144105_list_grid" showAddBtn="true" width="100%">
                    <thead>
                    <tr>
                        <th coltype="checkbox" name="checkFlag" width="20px"></th>
                        <th coltype="sno" width="20px">编号</th>
                        <th coltype="text" name="pdCode">产品编码</th>
                        <th coltype="text" name="pdName">产品名称</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <msk:button buttonId="PD144105.SAVE" buttonType="button" buttonValue="保存"></msk:button>
            </div>
        </div>
    </form>
</div>
<script src="${ctx}/static/pd/js/PD144105.js"></script>
