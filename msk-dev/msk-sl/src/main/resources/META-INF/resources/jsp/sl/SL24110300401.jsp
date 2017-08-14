<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
        //$('#main-content').postUrl(Main.contextPath + "/SL241103000/init");
    }
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>企业荣誉证书</label>
    </h3>
    <form action="${ctx}/SL24110300401/save" id="SL24110300401Form"
               method="post"  enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
            <td align="right" width="50%" >荣誉证书发证日期(必填)　</td>
            <td align="left" width="50%" >
                <input type="text" name="certDate" id="certDate"/>
            </td>
        </tr>
            <tr>
                <td align="right" width="50%" >荣誉证书发证单位　</td>
                <td align="left" width="50%" >
                    <input type="text" name="certIssuer"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%" >证书荣誉描述(必填)　</td>
                <td align="left" width="50%" >
                    <input type="text" name="honorDesc"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">企业荣誉图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file" id="importFile" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL24110300401.SAVE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/sl/SL24110300401.js"></script>
