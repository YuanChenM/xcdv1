<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="查询所有批次流水号" backTitleArray="产品批次入库及标签打印" backUrlArray="${ctx}/SC182211/init/"></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/SC182213/search" method="post" id="sc182213FormId">
        <%--<input type="hidden" name="filterMap[hideSlMainClass]" value="1">--%>
        <div>
            <table id="sc182213_list_grid" showAddBtn="true" width="100%">
                <thead>
                <tr>
                    <th coltype="text"  width="20%" name="lotId" filter="true">批次ID</th>
                    <th coltype="text"  width="20%" name="serialId" filter="true">流水ID</th>
                    <th coltype="text"  width="20%" name="lotCode" filter="false">阅读码</th>
                    <th coltype="text"  width="20%" name="readCode" filter="false">批次码</th>
                    <th coltype="text"  width="20%" name="crtTime" filter="false">插入时间</th>
                    <th coltype="action" >
                        <input type="hidden" value="删除" coltype="delete" title="删除该批次标签" class="h-button" />
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </form>
    <msk:button buttonValue="保存" name="SC182213.SAVE"  buttonId="SC182213.SAVE" buttonType="button" />
</div>
<script type="text/javascript" src="${ctx}/js/ds/SC182213.js"></script>
