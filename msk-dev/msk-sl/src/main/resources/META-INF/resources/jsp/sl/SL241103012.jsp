<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
    }
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>检测设备</label>
    </h3>
    <div>
    <div id="ordinary" style="display:block">
        <form:form action="${ctx}/SL241103012/save" id="SL241103012Form"
               method="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">设备名称</td>
                <td align="left" width="50%">
                    <input type="text" name="ddName" id="ddNameId"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">主要用途</td>
                <td align="left" width="50%">
                    <textarea cols="30" rows="5" name="ddEquipment"></textarea>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">检测设备图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="slEpDdFile" id="slEpDdPathId" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL241103012.SAVE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
    </div>
</div>
</div>
<script src="${ctx}/js/sl/SL241103012.js"></script>
