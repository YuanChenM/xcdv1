<%-- 
    Title:品种产品目录报表
    author:xhy

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="page-content detail-page">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>更新结算操作</label>
        </h3>
        <form:form action="${ctx}/TSC30004/add" id="TSC30004Form"
                   method="post">
            <table width="100%">

                <tr>
                    <td width="15%" align="right">实付金额:</td>
                    <td><input type="text" name="classestreeName3" value="10万"
                               id="classestreeName3"/></td>
                    <td><input type="hidden" name="classestreeCode3" value="${classestree.classestreeCode3}"/></td>
                </tr>
                <tr>
                    <td width="15%" align="right">状态:</td>
                    <td>
                        <select style="width:135px ">
                            <option value="volvo" selected>已付</option>
                            <option value="saab">待付</option>
                            <option value="opel">取消</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td width="15%" align="right">修改附件:</td>
                    <td><input type="file" name="classestreeName3" value="${classestree.classestreeName3}"
                            /></td>
                </tr>
            </table>
        </form:form>
    </div>
    <div>
        <msk:button buttonValue="保存" buttonId="TSC30004.SAVE" buttonType="button"/>
    </div>
</div>

<script src="${ctx}/js/ds/TSC30004.js"></script>
