<%--
  Created by IntelliJ IDEA.
  User: jiangnan
  Date: 16/1/5
  Time: 上午10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
        $.pdialog.close();
        $('#main-content').postUrl(Main.contextPath + "/MS112101/init");
    } 
</script>
<form id="MS112102_FORM_SUBMIT"  action="${ctx}/MS112102/upload" method="post" enctype="multipart/form-data">
    <div class="page-content list-page">
    <table>
        <tr>
            <td>文件</td>
            <td><input type="file" name="file" id="importFile" /></td>
        </tr>
        <tr>
            <td>模板</td>
            <td><a href="${fileSerUrl}/MemberShip/templet.xls">会员卡账号管理台账模板下载</a></td>
        </tr>
        <tr>
            <td colspan="2"> <input type="button" value="上传" id="uploadButton" /></td>
        </tr>
    </table>
    </div>
</form>

<script type="text/javascript" src="${ctx}/js/ms/MS112102.js"></script>
