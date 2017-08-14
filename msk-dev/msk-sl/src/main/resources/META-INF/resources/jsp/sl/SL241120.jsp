<%--分销章程列表--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<style>
    td.details-control {
        background: url('${ctx}/static/core/images/action/details_open.png') no-repeat center center;
        cursor: pointer;
    }
    tr.details td.details-control {
        background: url('${ctx}/static/core/images/action/details_close.png') no-repeat center center;
    }
    .hideInfo{
        display: none;
    }
</style><script type="text/javascript">
    var chapClass='${chapClass}';
</script>
<c:if test="${chapClass eq 1}">
    <navigation:header title="卖家意见列表" backTitleArray="分销章程列表" backUrlArray="${ctx}/SL241109/init/1"></navigation:header>
</c:if>
<c:if test="${chapClass eq 2}">
    <navigation:header title="卖家意见列表" backTitleArray="卖家协议列表" backUrlArray="${ctx}/SL241109/init/2"></navigation:header>
</c:if>
<div class="page-content list-page">
    <form action="${ctx}/SL241120/search/${chapClass}" method="post" id="SL241120FormId">
        <div>
            <table id="SL241120_list_grid" showAddBtn="true">
                <thead>
                <tr>
                    <th coltype="text"  align="center" width="10px"></th>
                    <th coltype="text" width="25%" name="epName" filter="true">卖家名称</th>
                    <th coltype="text" width="15%" name="slContact" filter="true">联系人</th>
                    <th coltype="text" width="20%" name="slTel" filter="true">联系电话</th>
                    <th coltype="text" name="affirmResult">分销章程确认结果</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/sl/SL241120.js"></script>

