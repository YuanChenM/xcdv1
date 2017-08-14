<%--
  Created by IntelliJ IDEA.
  User: marshall
  Date: 16/3/9
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="批发市场列表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/BY121301/search" method="post">
        <table id="BY121301_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="marketCode" filter=true>批发市场编码</th>
                <th coltype="link" name="marketName" filter=true>批发市场名称</th>
                <th coltype="text" name="marketAddr" filter=false>批发市场地址</th>
                <th coltype="text" name="marketLevelName" filter=false>批发市场级别</th>
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
        <msk:button buttonType="button" buttonId="BY121301.NEW"  buttonValue="新增"/>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/by/BY121301.js"></script>


