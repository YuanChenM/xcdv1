<%--
  Created by IntelliJ IDEA.
  User: pxg
  Date: 16/1/13
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <label>月度在线控制一览</label>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173102/search" method="post">
        <table id="DS173102_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="month" filter="true">月度</th>
                <th coltype="text" name="district" filter="true">区域</th>
                <th coltype="text" name="prod" filter="true">供应商</th>
                <th coltype="action" width="10px">
                    <input type="button" id="editBtn" hidden="true" title="详细信息" coltype="search" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173102.js"></script>
