<%--
  Created by IntelliJ IDEA.
  User: yuan_chen
  Date: 16/1/13
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <label>卖家产品计划调整合意一览</label>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173303/search" method="post">
        <table id="DS173303_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="month" align="center" filter="true">月度</th>
                <th coltype="text" name="district" align="center" filter="true">区域</th>
                <th coltype="text" name="sellerName" align="center" filter="true">卖家</th>
                <th coltype="text" name="half" align="center" filter="true">半旬</th>
                <th coltype="text" name="comeDate" align="center" filter="true">入力日期</th>
                <th coltype="text" name="product" align="center" filter="true">产品</th>
                <th coltype="text" name="formatName" align="center" filter="true">规格名称</th>
                <th coltype="text" name="formatOld" align="center">规格原有值</th>
                <th coltype="text" name="formatNew" align="center">规格更改值</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173303.js"></script>
