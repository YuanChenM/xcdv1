<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<style type="text/css">
    td.text{
        text-align: center;
    }
    table.dataTable td.action{
        text-align: center;
    }
    td.select{
        text-align: center;
    }
</style>
<navigation:header title="中标管理" backTitleArray=" " backUrlArray=" "></navigation:header>
<%--<div class="page-content list-page">--%>

    <form action="${ctx}/TSC10001/search" method="post">
        <table id="TSC10001_Grid">
            <thead>
            <tr>
                <th coltype="text" name="zbid" filter="false" >ID</th>
                <th coltype="text" name="projectName" filter="false" >招标项目名称</th>
                <th coltype="text" name="winner" filter="true">中标厂商</th>
                <th coltype="text" name="checkTime" filter="false">开标时间</th>
                <th coltype="text" name="status" filter="true">状态</th>
                <th coltype="action">
                    <input type="button" id="detailBtn" hidden="true" title="详细" coltype="detail" class="h-button"/>
                  <%--  <input type="button" id="editBtn"  hidden="true" title="状态更新" coltype="edit" class="h-button" />--%>
                    <input type="button" id="deleteBtn" hidden="true" title="删除" coltype="delete" class="h-button" />
                </th>
            </tr>
            <%--<tr align="left"><msk:button buttonValue="新建" buttonId="TSC10001.NEW" buttonType="button" url="${ctx}/TSC10002/init"/></tr>--%>
            </thead>
            <tbody>

            </tbody>
        </table>

       <table>
            <tr align="left">
            <msk:button buttonValue="新建" buttonId="TSC10001.NEW" buttonType="button"/>
        </tr>
        </table>
        <%--<table><tr align="left"><msk:button buttonValue="新建" buttonId="TSC10001.NEW" buttonType="button"/></tr></table>--%>
    </form>
<%--</div>--%>

<script type="text/javascript" src="${ctx}/js/ds/TSC10001.js"></script>
