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
        <label>批次编码列表信息</label>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173209/search" method="post">
        <table id="DS173209_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px" rowspan="2">编号</th>
                <th coltype="text" align="center" rowspan="2" name="pdBarCode">产品条形码</th>
                <th align="center" colspan="7">主码</th>
                <th align="center" colspan="3">辅码</th>
            </tr>
            <tr>
                <th coltype="text" name="district" align="center">产品地域</th>
                <th coltype="text" name="className" align="center">产品类别</th>
                <th coltype="text" name="breedName" align="center">产品品种</th>
                <th coltype="text" name="featureName" align="center">产品特征</th>
                <th coltype="text" name="level" align="center">产品等级</th>
                <th coltype="text" name="pdCode" align="center">产品编码</th>
                <th coltype="text" name="normsCode" align="center">包装编码</th>
                <th coltype="text" name="sellerCode" align="center">卖家编码</th>
                <th coltype="text" name="comeTime" align="center">预计发货时间</th>
                <th coltype="text" name="pdBatchCode" align="center">产品批次编码</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173209.js"></script>
