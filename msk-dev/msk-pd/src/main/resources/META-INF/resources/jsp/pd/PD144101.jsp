<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="navigation" uri="/msk-navigation" %>
<%--
    Title:轮播图设置
    author:gm
    createDate:2016-2-15
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    function callbackFun(message) {
        $.pdialog.close();
        HDF.closeLoadingMask();
        $List_Grid.fnDraw();
    }
</script>
<navigation:header title="轮播图设置" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">

    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>显示设置</label>
        </h3>
        <form:form action="${ctx}/PD144101/init" id="PD144101FormHeight" method="post">
            <div>
                <table width="100%">
                    <tr>
                        <td width="100px" align="right">图片百分比(%)：</td>
                        <td align="left">
                            <select id="modelHeight" name="modelHeight" style="width: 200px;">
                                <option value="0">==请选择==</option>
                                <c:forEach items="${modelHeightList}" var="item">
                                    <option
                                            <c:if test="${modelHeight eq item.modelHeight}">selected="selected"</c:if>> ${item.modelHeight}
                                    </option>
                                </c:forEach>
                            </select>
                            <msk:button buttonValue="保存" buttonType="button" buttonId="PD144101.SAVE"/>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>图片设置</label>
        </h3>
        <form:form action="${ctx}/PD144101/searchImg" id="PD144101Form" method="post">
            <table id="PD144101_list_grid">
                <thead>
                <tr width="20%">
                    <th coltype="sno" filter="false" width="5%">编号</th>
                    <th coltype="link" filter="false" width="50%" name="scrollImg">图片</th>
                    <th coltype="number" maxlength="2" filter="false" edit="true" width="10%" name="sort" height="10%">
                        排序
                    </th>
                    <th coltype="action" width="30%">
                        <msk:button buttonId="PD144101.DELETE" coltype="delete" class="h-button"
                                    useable="can_delete" buttonType="hidden" buttonValue="删除"/>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <br/>
            <msk:button buttonValue="新增" buttonId="PD144101.ADD" buttonType="button"/>
            <msk:button buttonValue="保存" buttonId="PD144101.PIC_SAVE" buttonType="button"/>
        </form:form>
    </div>
</div>
<script src="${ctx}/static/pd/js/PD144101.js"/>