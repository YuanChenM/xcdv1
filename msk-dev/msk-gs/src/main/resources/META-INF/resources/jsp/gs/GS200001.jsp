<%-- 
    Title:SQL查询器
    author:gyh
    createDate:2016-6-22
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="SQL查询器" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/GS200001/search" method="post" id="GS200001FormId">
        <div class="group-accordion" active="true" collapsible="false">
            <h3>
                <label>SQL输入</label>
            </h3>

            <div>
                <table width="100%">
                    <tr>
                        <td align="center">
                            <textarea style="width: 100%;height:80px;" name="sqlInfo"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td align="center">
                            <msk:button buttonType="button" buttonValue="查询" buttonId="GS200001.SEARCH"/>
                        </td>
                    </tr>
                    <%--<tr>--%>
                        <%--<td><font color="red">注：为了显示正常，该功能要求查询字段必须存在，如果存在字段值为空的情况请在字段上加IFNULL函数，如SELECT IFNULL(E.LGCS_AREA_NAME,'') AS lgcsAreaName FROM TABLE。</font></td>--%>
                    <%--</tr>--%>
                </table>

            </div>
        </div>
        <div class="group-accordion" active="true" collapsible="false">
            <h3>
                <label>SQL输出</label>
            </h3>

            <div id="fieldInfo">
            </div>
        </div>
    </form>
</div>
<script src="${ctx}/js/gs/GS200001.js"></script>
