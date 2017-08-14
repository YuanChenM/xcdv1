<%-- 
    Title:分销章程列别
    author:rwf
    createDate:2015-12-18
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var fileSerUrl = '${fileSerUrl}';
    var chapClass='${chapClass}';
</script>
<c:if test="${chapClass eq 1}">
    <navigation:header title="分销章程列表" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<c:if test="${chapClass eq 2}">
    <navigation:header title="卖家协议列表" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<div class="page-content list-page">
    <form action="${ctx}/SL241109/search/${chapClass}" method="post">
        <table id="sl241109_list_grid" showAddBtn="true">
            <thead>
            <tr>
                <th coltype="text" width="10%" name="chapNo" filter="true">章节</th>
                <th coltype="text" width="30%" name="chapTitle" filter="true">标题</th>
                <th coltype="action" width="10%">操作
                    <input type="button" hidden="true" id="editBtn" value="编辑" coltype="edit" title="编辑"
                           class="h-button"/>
                    <input type="button" hidden="true" id="editBtn1" value="卖家意见" coltype="check" title="卖家意见"
                           class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            <table id="useForButton">
                <tr>
                    <td>
                        <msk:button buttonId="SL241109.ADD" buttonType="button" buttonValue="添加章节"/>
                    </td>
                    <td>
                        <msk:button buttonId="SL241109.PREVIEW" buttonType="button" buttonValue="预览"/>
                    </td>
                    <td>
                        <msk:button buttonId="SL241109.LIST" buttonType="button" buttonValue="卖家意见列表"/>
                    </td>

                </tr>
            </table>
            </tbody>
        </table>
    </form>
</div>
<script src="${ctx}/js/sl/SL241109.js"></script>
