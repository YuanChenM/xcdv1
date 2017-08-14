<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion" active="false">
    <h3>
        <label>企业库容概括</label>
    </h3>
    <div>
    <form:form action="${ctx}/SL2411010502/update" id="SL2411010502Form"
               method="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">原料库容（立方）　</td>
                <td align="left" width="50%">
                    <input type="text" name="scapMaterial" value="${slEpCap.scapMaterial}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">成品库容（立方）　</td>
                <td align="left" width="50%">
                    <input type="text" name="scapProduct" value="${slEpCap.scapProduct}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">仓库图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file" id="importFile2" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL2411010502.UPDATE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
    </div>
</div>
<script src="${ctx}/js/sl/SL2411010502.js"></script>
