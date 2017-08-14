<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:SQL查询器子页面
    author:gyh
    createDate:2016-6-22
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<div>共<font color="red"><c:if test="${fields.size()==0}">${fields.size()}</c:if><c:if test="${fields.size()>0}">${fields.size()-1}</c:if></font>条记录</div>
<div style="height:180px;">
    <table width="100%" class="dataTable no-footer">
        <thead>
        <tr>
            <c:forEach var="field" items="${fields[0]}">
                <td>${field.key}</td>
            </c:forEach>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${fields}" var="fieldMap" varStatus="i">
            <tr>
                    <%--<c:forEach var="field" items="${fieldMap}">--%>
                    <%--<td>${field.value}</td>--%>
                    <%--</c:forEach>--%>
                <c:if test="${i.index!=0}">
                    <c:forEach var="field" items="${fields[0]}">
                        <c:choose>
                            <c:when test="${fieldMap[field.key] == null}">
                                <td></td>
                            </c:when>
                            <c:otherwise>
                                <td>${fieldMap[field.key]}</td>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:if>

            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

