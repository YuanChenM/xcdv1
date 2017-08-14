<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:三级分类操作
    author:xhy
    createDate:2016-2-19
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<form:form action="${ctx}/PD144101/upload" method="post" name="PD144102Form" id="PD144102Form"
           enctype="multipart/form-data">
    <table width="100%">
        <tr>
            <td width="20%" height="5%" align="right">上传图片(<2MB)：</td>
            <td width="100px" align="left">
                <input type="file" width="100px" name="productImgFile" id="coverPath"/>
            </td>
        </tr>
    </table>
    <div>
        <br/>
        <msk:button buttonValue="保存" buttonId="PD144102.SAVE" buttonType="button"/>
    </div>
</form:form>
<script src="${ctx}/static/pd/js/PD144102.js"></script>