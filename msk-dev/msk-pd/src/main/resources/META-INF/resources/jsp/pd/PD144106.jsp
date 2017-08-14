<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="产品上下架" backTitleArray="" backUrlArray="" ></navigation:header>
<div class="page-content list-page" style="height:100%">
    <form action="${ctx}/PD144106/search" id="PD144106Form" method="post">
        <div class="group-accordion" collapsible="false" active="false">
            <h3 style="position: relative">
                <label>查询条件</label>
            </h3>
            <div>
                <table>
                    <tr>
                        <td width="100px" align="right">产品名称:</td>
                        <td align="left">
                             <input type="text" style="width:100px" id="pdName" name="filterMap['pdName']"/>
                        </td>
                        <td width="100px" align="right">物流区:</td>
                        <td align="left">
                            <select style="width:120px" id="lgcsCode" name="filterMap['lgcsCode']">
                                <option value="">==请选择==</option>
                                <c:forEach items="${logisticsAreas}" var="area">
                                    <option value="${area.lgcsAreaCode}">${area.lgcsAreaName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="100px" align="right">状态:</td>
                        <td align="left">
                            <select style="width:120px" id="status" name="filterMap['status']">
                                    <option value="">==请选择==</option>
                                    <option value="9">未发布</option>
                                    <option value="0">已上架</option>
                                    <option value="1">已下架</option>
                            </select>
                        </td>
                        <td>
                            <msk:button buttonValue="查询" buttonId="PD144106.SEARCH" buttonType="button"/>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="PD144106Id" style="height: auto">
            <div class="group-accordion" collapsible="false" active="false">
                <h3 style="position: relative">
                    <label>产品信息列表</label>
                </h3>
                <div width="100%">
                    <table id="PD144106_Grid">
                        <thead>
                        <tr>
                            <th coltype="sno" width="20px">编号</th>
                            <th coltype="text" filter="false" name="lgcsName">物流区</th>
                            <th coltype="text" filter="false" name="pdCode">产品编码</th>
                            <th coltype="text" filter="false" name="pdName">产品名称</th>
                            <th coltype="text" filter="false" name="status">状态</th>
                            <th coltype="action">操作
                                <msk:button buttonId="PD144106.EDIT" coltype="edit" class="h-button" useable="can_edit" buttonType="hidden" buttonValue="编辑"/>
                                <msk:button buttonId="PD144106.ON" coltype="upload" class="h-button" useable="can_on" buttonType="hidden" buttonValue="上架"/>
                                <msk:button buttonId="PD144106.OFF" coltype="download" class="h-button" useable="can_off" buttonType="hidden" buttonValue="下架"/>
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </form>
</div>

<script type="text/javascript" src="${ctx}/static/pd/js/PD144106.js"></script>