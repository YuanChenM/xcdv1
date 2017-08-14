<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<c:choose>
    <c:when test="${selfFlg==1 and oemFlg==1 and proxyFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型/代理型/OEM型）" backTitleArray="" backUrlArray=""></navigation:header>
    </c:when>
    <c:when test="${selfFlg==1 and oemFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型/OEM型）" backTitleArray="" backUrlArray=""></navigation:header>
    </c:when>
    <c:when test="${selfFlg==1 and proxyFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型/代理型）" backTitleArray="" backUrlArray=""></navigation:header>
    </c:when>
    <c:when test="${oemFlg==1 and proxyFlg==1}">
        <navigation:header title="卖家企业信息详细（代理商/OEM型）" backTitleArray="" backUrlArray=""></navigation:header>
    </c:when>
    <c:when test="${selfFlg==1}">
        <navigation:header title="卖家企业信息详细（自产型）" backTitleArray="" backUrlArray=""></navigation:header>
    </c:when>
    <c:when test="${proxyFlg==1}">
        <navigation:header title="卖家企业信息详细（代理型）" backTitleArray="" backUrlArray=""></navigation:header>
    </c:when>
    <c:when test="${oemFlg==1}">
        <navigation:header title="卖家企业信息详细（OEM型）" backTitleArray="" backUrlArray=""></navigation:header>
    </c:when>
 </c:choose>
<div class="page-content detail-page" style="margin-top:35px;">
    <%@include file="SL24110301.jsp"%>
    <c:choose>
     <c:when test="${selfFlg==1 and oemFlg==1 and proxyFlg==1}">
        <%@include file="SL24110302.jsp"%>
        <%@include file="SL24110303.jsp"%>
        <%@include file="SL24110304.jsp"%>
        <%@include file="SL24110305.jsp"%>
        <%@include file="SL24110306.jsp"%>
        <%@include file="SL24110307.jsp"%>
        <%@include file="SL24110308.jsp"%>
    </c:when>
    <%-- // 代理性+OEM --%>
    <c:when test="${proxyFlg==1 and oemFlg==1}">
        <%@include file="SL24110302.jsp"%>
        <%@include file="SL24110303.jsp"%>
        <%@include file="SL24110304.jsp"%>
        <%@include file="SL24110305.jsp"%>
        <%@include file="SL24110306.jsp"%>
    </c:when>
    
    <%-- // 代理性+自产 --%>
    <c:when test="${proxyFlg==1 and selfFlg==1}">
        <%@include file="SL24110302.jsp"%>
        <%@include file="SL24110303.jsp"%>
        <%@include file="SL24110304.jsp"%>
        <%@include file="SL24110305.jsp"%>
        <%@include file="SL24110306.jsp"%>
        <%@include file="SL24110308.jsp"%>
    </c:when>
    <%-- // 自产性 --%>
    <c:when test="${selfFlg==1}">
        <%@include file="SL24110302.jsp"%>
        <%@include file="SL24110303.jsp"%>
        <%@include file="SL24110304.jsp"%>
        <%@include file="SL24110305.jsp"%>
        <%@include file="SL24110306.jsp"%>
        <%@include file="SL24110307.jsp"%>
        <%@include file="SL24110308.jsp"%>
    </c:when>
     <%-- // 自产性 +OEM性--%>
    <c:when test="${selfFlg==1 and oemFlg==1}">
          <%@include file="SL24110302.jsp"%>
        <%@include file="SL24110303.jsp"%>
        <%@include file="SL24110304.jsp"%>
        <%@include file="SL24110305.jsp"%>
        <%@include file="SL24110306.jsp"%>
    </c:when>
    <%-- // 代理性 --%>
    <c:when test="${proxyFlg==1}">
        <%@include file="SL24110302.jsp"%>
        <%@include file="SL24110303.jsp"%>
        <%@include file="SL24110304.jsp"%>
        <%@include file="SL24110305.jsp"%>
        <%@include file="SL24110306.jsp"%>
        <%@include file="SL24110308.jsp"%>
    </c:when>
    <%-- // OEM性 --%>
    <c:when test="${oemFlg==1}">
     <%@include file="SL24110302.jsp"%>
        <%@include file="SL24110303.jsp"%>
        <%@include file="SL24110304.jsp"%>
        <%@include file="SL24110305.jsp"%>
        <%@include file="SL24110306.jsp"%>
    </c:when>
   </c:choose>  
</div>
<script src="${ctx}/js/sl/SL241103.js"></script>
