<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript" src="${ctx}/static/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="${ctx}/static/js/ueditor/ueditor.all.js"></script>
<script type="text/javascript">
	var ue = UE.getEditor('container',{
		initialFrameHeight:250,
		elementPathEnabled:false,
		initialFrameWidth:638,
		wordCount:false
	});
	var chapClass='${chapClass}';
</script>
<c:if test="${chapClass eq 1}">
	<navigation:header title="分销数据编辑信息详情" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<c:if test="${chapClass eq 2}">
	<navigation:header title="卖家协议编辑信息详情" backTitleArray="" backUrlArray=""></navigation:header>
</c:if>
<div class="page-content detail-page">
	<form:form action="${ctx}/SL241111/save/${isAdd}/${chapClass}" id="SL241111Form"
		metdod="post" name="myForm" enctype="multipart/form-data">
		<input type="hidden" value="${sL241109Bean.chapId}" name="chapId"/>
		<table class="dataTable no-footer">
		<thead>
			<tr>
				<c:if test="${isAdd eq 'add'}">
					<th>章节:<input type="text" style="height: 22px; width: 150px"
								  name="chapNo" value="${sL241109Bean.chapNo}"/></th>
				</c:if>
				<c:if test="${isAdd eq 'update'}">
					<th>章节:<input type="text" style="height: 22px; width: 150px"
								  name="chapNo" value="${sL241109Bean.chapNo}" readonly="readonly"/></th>
				</c:if>
			</tr>
			<tr>
				<th>标题:<input type="text" style="height: 22px; width: 150px"
					name="chapTitle" value="${sL241109Bean.chapTitle}" /></th>
			</tr>
			</thead>
		</table>
		<script id="container" name="content" type="text/plain">
			${sL241109Bean.content}
		</script>
		</form:form>
	<msk:button buttonValue="提交" buttonType="button" buttonId="PD141111.SUB" />
</div>
<script src="${ctx}/js/sl/SL241111.js"></script>
