<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
    Title:物流区产品管理
    author:yuan_chen
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    function callbackFun(message) {
        $.pdialog.close();
        //$.alertMessage.info(message.split(";")[0]);
        HDF.closeLoadingMask();
        if(PD144107.type == 0) {
            $("#coverImg").attr("src", message.split(";")[1]);
            $("#tipImg").attr("href", message.split(";")[1]);
           // $("#tipImg").css("display","");
        }
        $("#pdCode").val($("#codeLbl").text());
        $List_Grid.fnDraw();
    }
</script>
<navigation:header title="产品管理" backTitleArray="产品上下架" backUrlArray="${ctx}/PD144106/init" ></navigation:header>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="false"  active="false">
        <h3>
            <label>产品管理</label>
        </h3>
        <div>
            <table width="70%">
                <tr>
                    <label hidden="hidden" id="lgcsCode">${bean.lgcsCode}</label>
                    <td width="3%" height="5%" align="right">产品编码:</td>
                    <td width="100px" align="left">
                        <label id="codeLbl">${bean.pdCode}</label>
                    </td>
                </tr>
                <tr>
                    <td width="3%" height="5%" align="right">产品名称:</td>
                    <td width="200px" align="left">
                        <label style="width:30%">${bean.pdName}</label>
                        <input width="200px" maxlength="20" type="hidden" name="pdName" disabled value="${bean.pdName}"/>
                    </td>
                </tr>
                <tr>
                    <td width="3%" height="5%" align="right">封面图片:</td>
                    <td width="100px" align="left">
                        <a href="javascript:PD144107.showImage(${bean.id})" class="ui-button"><img id="coverImg"
                                                                                 src="${bean.cover}" height="25px" width="25px" title="封面图片"/></a>
                        <msk:button buttonId="PD144107.ADDCOVER" buttonType="button" buttonValue="上传"/>
                    </td>
                </tr>
                <tr>
                    <td width="3%" height="5%" align="right">标签:</td>
                    <td width="200px" align="left">
                        <input width="200px" type="text" id="pdLabel" maxlength="20" name="pdLabel" value="${bean.pdLabel}"/>
                    </td>
                </tr>
                <tr>
                    <td width="15%" align="right">详情图片:</td>
                    <td><msk:button buttonId="PD144107.ADD" buttonType="button" buttonValue="新增"/></td>
                </tr>
                <tr>
                    <td width="15%" align="right"></td>
                    <td width="25%" align="left">
                        <form:form action="${ctx}/PD144107/search" id="PD144107Form"
                                   method="post">
                            <input name="filterMap[pdCode]" id="pdCode" type="hidden" value="${bean.pdCode}">
                            <table id="PD144107_Grid">
                                <thead>
                                <tr>
                                    <th coltype="link" filter="false" width="60%" name="appImg">图片</th>
                                    <th coltype="number" filter="false" maxlength="2" edit="true" width="10%" name="sort">顺序</th>
                                    <th coltype="action" width="30%">
                                        <msk:button buttonId="PD144107.DELETE" coltype="delete" class="h-button" useable="can_delete" buttonType="hidden" buttonValue="删除"/>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </form:form>
                    </td>
                </tr>
                <tr>
                    <td width="3%" height="5%" align="right"></td>
                    <td width="100px" align="left">
                        <msk:button buttonValue="保存" buttonId="PD144107.SAVE" buttonType="button"/>
                       <input type="checkbox" id="status" name="status" value="0" onclick="bindCheckBox()" checked />默认上架
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<script src="${ctx}/static/pd/js/PD144107.js"></script>