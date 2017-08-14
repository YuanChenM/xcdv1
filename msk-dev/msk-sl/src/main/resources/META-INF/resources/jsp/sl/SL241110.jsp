<%--分销章程卖家意见列表--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<c:if test="${chapClass eq 1}">
    <navigation:header title="第${chapNo}章节卖家意见列表" backTitleArray="分销章程列表" backUrlArray="${ctx}/SL241109/init/1"></navigation:header>
</c:if>
<c:if test="${chapClass eq 2}">
    <navigation:header title="第${chapNo}章节卖家意见列表" backTitleArray="卖家协议列表" backUrlArray="${ctx}/SL241109/init/2"></navigation:header>
</c:if>
<div class="page-content list-page">
    <form action="${ctx}/SL241110/search/${chapId}/${chapClass}" method="post" id="SL241110FormId">
        <div>
            <table id="SL241110_list_grid" showAddBtn="true">
                <thead>
                <tr>
                    <th coltype="text" width="10%" name="epName" filter="true">卖家名称</th>
                    <th coltype="select" width="10%" name="agreeFlgName" filter="true">确认结果
                        <select>
                            <option value="0">不同意</option>
                            <option value="1">同意</option>
                        </select>
                    </th>
                    <th coltype="text" width="10%" name="slSug">意见与建议</th>
                    <th coltype="text" width="10%" name="slContact">联系人</th>
                    <th coltype="text" width="10%" name="slTel">联系方式</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/sl/SL241110.js"></script>

