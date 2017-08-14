<%--
    Title:卖家物流区产品管理
    author:yuan_chen
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="卖家物流区产品管理" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>物流区选择</label>
        </h3>
        <div>
            <c:forEach items="${logisticsAreas}" var="logisticsArea">
                &nbsp;
                <a href="javascript:void(0)" name="selectLgcs"
                   selectSlCode="${sellerCode}" selectLogistics="${logisticsArea.lgcsCode}">${logisticsArea.lgcsName}</a>
                &nbsp;
            </c:forEach>
        </div>
    </div>
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>物流区产品列表</label>
        </h3>
        <form action="${ctx}/SL131121/search" id="SL131121Form" metdod="post">
            <div>
                <input type="hidden" name="filterMap['lgcsCode']" id="lgcsCode" value="${lgcsCode}"/>
                <input type="hidden" name="filterMap['sellerCode']" id="slCode" value="${sellerCode}"/>
                <table id="SL131121_Grid">
                    <thead>
                    <tr>
                        <th coltype="checkbox" name="checkFlag"></th>
                        <th coltype="sno" width="20px">编号</th>
                        <th coltype="text" name="slCode">卖家编码</th>
                        <th coltype="text" name="slName">卖家名称</th>
                        <th coltype="text" name="lgcsCode">物流区编码</th>
                        <th coltype="text" name="lgcsName">物流区名称</th>
                        <th coltype="text" filter="true" name="classesCode">分类编码</th>
                        <th coltype="text" filter="true" name="classesName">产品分类</th>
                        <th coltype="text" filter="true" name="breedCode">品种编码</th>
                        <th coltype="text" filter="true" name="breedName">产品品种</th>
                        <th coltype="text" filter="true" name="featureCode">特征编码</th>
                        <th coltype="text" filter="true" name="featureName">产品特征</th>
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
                <%--<msk:button buttonId="SL131121.BATCHSAVE" buttonType="button" buttonValue="批量更新"/>--%>
            </div>
        </form>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/sl/SL131121.js"></script>