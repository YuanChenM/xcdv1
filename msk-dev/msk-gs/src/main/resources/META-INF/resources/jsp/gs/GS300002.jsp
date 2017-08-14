<%-- 
    Title:报表
    author:gyh
    createDate:2016-6-22
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<style>
    #headBreadCrumb{
        display: none
    }
</style>
<script type="text/javascript" src="${ctx}/static/hightCharts/highcharts-more.js"></scrip>
<navigation:header title="销量趋势图" backTitleArray="" backUrlArray=""></navigation:header>
    <div id="container" style="height:700px"></div>
<script src="${ctx}/js/gs/GS300002.js"></script>