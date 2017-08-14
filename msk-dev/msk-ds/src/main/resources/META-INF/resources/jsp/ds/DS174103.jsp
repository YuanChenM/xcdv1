<%--
  Created by IntelliJ IDEA.
  User: yuan_chen
  Date: 16/1/13
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="卖家产品列表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/DS174103/search" method="post">
        <table id="DS174103_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="slCode" align="center" filter=true>卖家编号</th>
                <th coltype="text" name="slName" filter=true>卖家名称</th>
                <th coltype="text" name="classesCode" filter=true>类别编码</th>
                <th coltype="text" name="classesName" filter=true>类别名称</th>
                <th coltype="text" name="breedCode" filter=true>品种编码</th>
                <th coltype="text" name="breedName" filter=true>品种名称</th>
                <th coltype="text" name="featureCode" filter=true>特征编码</th>
                <th coltype="text" name="featureName" filter=true>特征名称</th>
                <th coltype="select" name="gradeName" filter=true>产品等级
                    <select>
                        <option value="1">A1</option>
                        <option value="2">A2</option>
                        <option value="3">A3</option>
                    </select>
                </th>
                <th coltype="text" name="pkgCode" filter=true>包装编码</th>
                <th coltype="action">
                    <input type="hidden"coltype="add" title="添加" class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS174103.js"></script>
