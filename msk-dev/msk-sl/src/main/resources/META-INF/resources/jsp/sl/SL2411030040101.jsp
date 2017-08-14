<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
       // $('#main-content').postUrl(Main.contextPath + "/SL241103000/init");
    }
</script>
<div class="page-content detail-page">
    <form action="${ctx}/SL2411030040101/save" id="SL2411030040101Form"
               method="post"  enctype="multipart/form-data">
        <table >
            <tr>
                <td align="right" width="50%" >荣誉证书发证日期　</td>
                <td align="left" width="50%" >
                    <input type="text" name="certDate" id="addcertDate"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%" >荣誉证书发证单位　</td>
                <td align="left" width="50%" >
                    <input type="text" name="certIssuer"/>
                </td>
            </tr>
            <tr>
            <td align="right" width="50%" >证书荣誉描述　</td>
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
                <td align="right">
                    <msk:button buttonValue="保存" buttonId="SL2411030040101.SAVE" buttonType="button"/>
                </td>
                <td align="left">
                    <msk:button buttonValue="取消" buttonId="SL2411030040101.BACK" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/sl/SL2411030040101.js"></script>
