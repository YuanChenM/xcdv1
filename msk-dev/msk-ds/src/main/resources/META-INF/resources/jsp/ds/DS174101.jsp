<%--
  Created by IntelliJ IDEA.
  User: yuan_chen
  Date: 16/1/13
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var LOGISTICS_AREA = ${logisticsArea};
</script>
<navigation:header title="批次产品列表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/DS174101/search" method="post">
        <table id="DS174101_Grid">
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
                <th coltype="text" name="lgcsName" filter=true>销售区域</th>
                <th coltype="text" name="dateCode">日期</th>
                <th coltype="text" name="dateCode" filter=true>半旬</th>
                <th coltype="action">保存
                    <input type="hidden"coltype="save" title="保存" class="h-button" />
                </th>
                <th coltype="action">编辑
                    <input type="hidden"coltype="edit" title="编辑" class="h-button" />
                </th>
                <th coltype="action">删除
                    <input type="hidden"coltype="delete" title="删除" class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS174101.js"></script>
