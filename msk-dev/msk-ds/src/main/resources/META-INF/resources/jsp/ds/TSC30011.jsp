<%--
    Title:发票管理列表
    author:cx
    createDate:2016-3-7
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="发票管理列表" backTitleArray="" backUrlArray="${ctx}/TSC10004/init"></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC30011/search" method="post" id="tsc30011FormId">
        <div>
            <table id="TSC30011_Grid" showAddBtn="true" width="100%">
                <thead>
                <tr>
                    <th coltype="sno"width="10%">ID</th>
                    <th coltype="text" name="code" filter="true">合同编号</th>
                    <th coltype="text" name="name" filter="true">合同名称</th>
                    <th coltype="text" name="changshang" filter="true">生产商</th>
                    <th coltype="text" name="time" filter="">合同生效日期</th>
                    <th coltype="select" name="type" filter="true">状态
                        <select style="height:20px;" size="2">
                            <option value="0">未核销</option>
                            <option value="1">已核销</option>
                        </select>
                    </th>
                    <th coltype="action" name="发票确认">发票确认
                        <input type="hidden" title="发票确认" coltype="export" class="h-button"/>
                    </th>
                    <th coltype="action" name="发票状态">发票状态
                        <input type="hidden"  coltype="check" title="发票状态" class="h-button"/>
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/TSC30011.js"></script>
