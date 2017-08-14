<%--
    Title:物流区产品管理
    author:yuan_chen
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="物流区产品管理" backTitleArray="" backUrlArray="" ></navigation:header>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>物流区选择</label>
        </h3>
        <div>
            <input type="hidden" name="lgcsAreaCode" value="${lgcsAreaCode}"/>
            <%--<input type="hidden" name="lgcsCode" value="${lgcsCode}"/>--%>
            <%--<msk:button buttonId="PD141121.SELECT" buttonType="button" buttonValue="选择"/><br><br>--%>
            <c:forEach items="${logisticsAreas}" var="logisticsArea">
                &nbsp;
                <%--<a href="javascript:void(0)" name="selectLgcs" selectLogistics="${logisticsArea.lgcsCode}">${logisticsArea.lgcsName}</a>--%>
                <a href="javascript:void(0)" name="selectLgcs" selectLogistics="${logisticsArea.lgcsAreaCode}">${logisticsArea.lgcsAreaName}</a>
                &nbsp;
            </c:forEach>
        </div>
    </div>
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>物流区产品列表</label>
        </h3>

        <%--<form action="${ctx}/PD141121/search/${lgcsCode}" id="PD141121Form" metdod="post">--%>
        <form action="${ctx}/PD141121/search/${lgcsAreaCode}" id="PD141121Form" metdod="post">
            <div>
                <table id="PD141121_Grid">
                    <thead>
                    <tr>
                        <th coltype="checkbox" name="checkFlag"></th>
                        <th coltype="sno" width="20px">编号</th>
                        <th coltype="text" filter="false" name="lgcsAreaCode">物流区编码</th>
                        <th coltype="text" filter="false" name="lgcsAreaName">物流区名称</th>
                        <th coltype="text" filter="true" name="classesCode">分类编码</th>
                        <th coltype="text" filter="true" name="classesName">产品分类</th>
                        <th coltype="text" filter="true" name="machiningCode">二级分类编码</th>
                        <th coltype="text" filter="true" name="machiningName">二级分类</th>
                        <th coltype="text" filter="true" name="breedCode">品种编码</th>
                        <th coltype="text" filter="true" name="breedName">产品品种</th>
                        <th coltype="text" filter="true" name="featureCode">特征编码</th>
                        <th coltype="text" filter="true" name="featureName">产品特征</th>
                        <th coltype="text" filter="true" name="weightCode">净重编码</th>
                        <th coltype="text" filter="true" name="weightName">净重名称</th>
                        <th coltype="text" filter="true" name="gradeCode">等级编码</th>
                        <th coltype="text" filter="true" name="gradeName">等级名称</th>
                        <th coltype="action">
                            <input type="hidden" coltype="add" title="添加" class="h-button" useable="can_add"/>
                            <input type="hidden" coltype="delete" title="删除" class="h-button" useable="can_delete"/>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div>
               <input type="hidden" name="filterMap[lgcsAreaCode]" value="${lgcsAreaCode}" id="ss">
                <msk:button buttonId="PD141121.CHECKED" buttonType="button" buttonValue="物流区产品查看"/>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/pd/PD141121.js"></script>