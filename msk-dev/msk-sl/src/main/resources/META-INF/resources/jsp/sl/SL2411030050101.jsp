<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
       // $('#main-content').postUrl(Main.contextPath + "/SL241103000/init");
    }
</script>
<div class="page-content detail-page" active="false">
    <form action="${ctx}/SL2411030050101/save" id="SL2411030050101Form"
               method="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%" >车间名称(必填)　</td>
                <td align="left" width="50%" >
                    <input type="text" name="workshopName" />
                </td>
            </tr>
            <tr>
                <td align="right" width="50%" >车间生产产品　</td>
                <td align="left" width="50%" >
                    <input type="text" name="product"/>
                </td>
            </tr><tr>
            <td align="right" width="50%" >车间工艺流程特点　</td>
            <td align="left" width="50%" >
                <input type="text" name="process"/>
            </td>
        </tr>
            <tr>
                <td align="right" width="50%">车间图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file" id="importFile" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <msk:button buttonValue="保存" buttonId="SL2411030050101.SAVE" buttonType="button"/>
                </td>
                <td align="left">
                    <msk:button buttonValue="取消" buttonId="SL2411030050101.BACK" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/sl/SL2411030050101.js"></script>
