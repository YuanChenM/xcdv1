<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun2(message,slAccount){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
        $.pdialog.close();
        //$('#main-content').postUrl(Main.contextPath + "/SL24110100/init/"+slAccount);
    }
</script>
<div class="page-content detail-page" id="SL2411030091_id">
    <form:form action="${ctx}/SL2411030091/insert" id="SL2411030091Form"
               metdod="post" enctype="multipart/form-data">
        <table id="SL2411030091DataGrid">
            <tr>
                <td align="right" width="50%">职务</td>
                <td align="left" width="50%">
                    <select name="eleaderFlg" id="eleaderFlg">
                        <option value="">--请选择--</option>
                        <option value="1">团队负责人</option>
                        <option value="0">团队成员</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">姓名</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberName" name="ememberName"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">年龄</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberAge" name="ememberAge"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">联系方式</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberTel" name="ememberTel"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">教育程度</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberEduc" name="ememberEduc"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">头像上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file" id="ec_teamImage" />
                </td>
            </tr>

            <tr>
                <td align="right">
                    <msk:button buttonValue="保存" buttonId="SL2411030091.SAVE" buttonType="button"/>
                </td>
                <td align="left">
                    <msk:button buttonValue="取消" buttonId="SL2411030091.BACK" buttonType="button"/>
                </td>

            </tr>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL2411030091.js"></script>
