<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:三级分类操作
    author:xhy
    createDate:2016-2-19
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="/comm/taglib.jsp" %>
        <form:form action="${ctx}/PD144107/upload" method="post" name="PD144108Form" id="PD144108Form" enctype="multipart/form-data">
            <input type="hidden" id="code" value="${pdCode}" name="pdCode">
            <input type="hidden" id="type" value="${type}" name="source">
            <input type="hidden" id="lgcsCode" value="${lgcsCode}" name="lgcsCode">
            <table width="100%">
                <tr>
                    <td width="30%" height="5%" align="right">上传图片(<2MB):</td>
                    <td width="100px" align="left">
                       <input type="file" width="100px" name="productImgFile" id="coverPath"/>
                        <img src="" id=imgShow>
                    </td>
                </tr>
                <tr> <td width="20%" height="5%" align="right">
                    <td align="left">
                        <msk:button buttonValue="保存" buttonId="PD144108.SAVE" buttonType="button"/>
                        </td>
                </tr>
            </table>
        </form:form>
<script src="${ctx}/static/pd/js/PD144108.js"></script>