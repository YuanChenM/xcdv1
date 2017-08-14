<%--
  Created by IntelliJ IDEA.
  User: marshall
  Date: 16/3/9
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<c:if test="${superiorId eq 'all'}">
    <navigation:header title="买家列表" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<c:if test="${!(superiorId eq 'all')}">
    <c:if test="${type eq '1'}">
        <navigation:header title="${market.marketName}的买家列表" backTitleArray="批发市场列表"
                           backUrlArray="${ctx}/BY121301/init/"></navigation:header>
    </c:if>
    <c:if test="${type eq '2'}">
        <navigation:header title="${market.marketName}的买家列表" backTitleArray="菜场列表"
                           backUrlArray="${ctx}/BY121302/init/"></navigation:header>
    </c:if>
</c:if>
<div class="page-content list-page">
    <form action="${ctx}/BY121303/search/${superiorId}" method="post">
        <table id="BY121303_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="accountName" filter=true>买家账号</th>
                <th coltype="text" name="telNo" filter=true>注册手机</th>
                <th coltype="text" name="buyerCode" filter=true>买家编码</th>
                <th coltype="text" name="storeNo" filter=true>店铺号</th>
                <th coltype="text" name="buyerName" filter=true>买家名称</th>
                <th coltype="text" name="bossName" filter=true>老板名称</th>
                <th coltype="text" name="superiorName" filter=true>买家类型</th>
                <th coltype="text" name="marketingsStatusName" filter=true>营销/销售类型</th>
                <th coltype="text" name="lgcsAreaName" filter=true>物流区名称</th>
                <th coltype="text" name="cityName" filter=true>城市(地区)名称</th>
                <th coltype="text" name="districtName" filter=true>区(县)名称</th>
                <th coltype="text" name="buyerAddr" filter=true>买家地址</th>
                <th coltype="action">
                    <input type="hidden" coltype="edit" title="编辑" class="h-button"/>
                    <input type="hidden"coltype="delete" title="删除" class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <input type="hidden" value="${message}" id="message"/>
    买家手机号:<input value="" type="text" name="telNo" id="telNo" maxlength="11"/>
    <msk:button buttonValue="新增" buttonId="BY121303.ADD" buttonType="button"/>
</div>
<script type="text/javascript" src="${ctx}/js/by/BY121303.js"></script>