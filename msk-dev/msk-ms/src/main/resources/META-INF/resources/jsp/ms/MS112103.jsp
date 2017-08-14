<%--
  Created by IntelliJ IDEA.
  User: jiangnan
  Date: 16/1/5
  Time: 上午11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="page-content list-page">
    <table width="100%">
        <tr>
            <td>会员卡编码　${ms112103Bean.msCardno }</td>
            <td></td>
        </tr>
        <tr>
            <td>买家编号　${ms112103Bean.buyerCode }</td>
            <td>买家名称 　${ms112103Bean.buyerName }</td>
        </tr>
        <tr>
            <td>是否已激活　${ms112103Bean.isActivate }</td>
            <td>是否已发放　${ms112103Bean.isProvide }</td>
        </tr>
        <tr>
            <td>发放日期　${ms112103Bean.provideDate }</td>
            <td></td>
        </tr>
        <tr>
            <td>采购批次　${ms112103Bean.purchaseLot }</td>
            <td></td>
        </tr>
    </table>
</div>

