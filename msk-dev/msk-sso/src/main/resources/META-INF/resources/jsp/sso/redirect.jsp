<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>后台管理系统${systemEnv}</title>
    <script src="${ctx}/static/core/js/jquery-1.11.1.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#redirectForm").submit();
        });
    </script>
</head>
<body>
<div>
    <form id="redirectForm" action="${result.url}" method="post">
        <input type="hidden" id="token" name="token" value="${result.token}" />
        <input type="hidden" id="loginId" name="loginId" value="${result.loginId}" />
    </form>
</div>
</body>
</html>