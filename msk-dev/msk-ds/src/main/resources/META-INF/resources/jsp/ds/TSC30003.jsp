<%-- 
    Title:品种产品目录报表
    author:xhy

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="page-content detail-page">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>新增结算操作</label>
        </h3>
        <form:form action="${ctx}/TSC30003/add" id="TSC30003Form"
                   method="post">
            <table width="100%">

                <tr>
                    <td width="15%" align="right">合同货数:</td>
                    <td><input type="text" name="classestreeName3" value="${classestree.classestreeName3}"
                               id="classestreeName3"/></td>
                    <td><input type="hidden" name="classestreeCode3" value="${classestree.classestreeCode3}"/></td>
                </tr>
                <tr>
                    <td width="15%" align="right">结算比例:</td>
                    <td><input type="text" name="classestreeName3" value="${classestree.classestreeName3}"
                               id="classestreeName4"/></td>
                    <td><input type="hidden" name="classestreeCode3" value="${classestree.classestreeCode3}"/></td>
                </tr>
                <tr>
                    <td width="15%" align="right">附件上传:</td>
                    <td><input type="file" name="classestreeName3" value="${classestree.classestreeName3}"
                               /></td>
                </tr>
            </table>
        </form:form>
    </div>
    <div>
        <msk:button buttonValue="保存" buttonId="TSC30003.SAVE" buttonType="button"/>
    </div>
</div>

<script src="${ctx}/js/ds/TSC30003.js"></script>
