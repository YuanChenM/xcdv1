<%--
  Created by IntelliJ IDEA.
  User: marshall
  Date: 16/3/9
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="菜场列表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/BY121302/search" method="post">
        <table id="BY121302_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="marketCode" filter=true>菜场编码</th>
                <th coltype="link" name="marketName" filter=true>菜场名称</th>
                <th coltype="text" name="marketAddr" filter=false>菜场地址</th>
                <th coltype="text" name="marketTypeName" filter=false>菜场类型</th>
                <th coltype="text" name="sectionTypeName" filter=false>菜场地段</th>
                <th coltype="text" name="sizeTypeName" filter=false>菜场规模</th>
                <th coltype="text" name="lgcsAreaCode" filter=false>物流区编码</th>
                <th coltype="text" name="lgcsAreaName" filter=false>物流区名称</th>
                <th coltype="text" name="cityCode" filter=false>城市(地区)编码</th>
                <th coltype="text" name="cityName" filter=false>城市(地区)名称</th>
                <th coltype="text" name="districtCode" filter=false>区(县)编码</th>
                <th coltype="text" name="districtName" filter=false>区(县)名称</th>
                <th coltype="action">
                    <input type="hidden"coltype="edit" title="编辑" class="h-button" />
                    <input type="hidden"coltype="delete" title="删除" class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <div>
        <msk:button buttonType="button" buttonId="BY121302.NEW" buttonValue="新增"/>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/by/BY121302.js"></script>