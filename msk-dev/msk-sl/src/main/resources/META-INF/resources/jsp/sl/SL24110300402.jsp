<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
       //('#main-content').postUrl(Main.contextPath + "/SL241103000/init");
    }
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>企业厂区概要</label>
    </h3>
    <form:form action="${ctx}/SL24110300402/save" id="SL24110300402Form"
               method="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">厂区总资产（万元）　</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyAsset"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">厂区占地面积(亩)　</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyLandArea"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">厂房面积(平米)　</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyFloorArea"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">主要设备</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyEquipment"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">设计产能(万吨)</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyDesignCap"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">实际产能(万吨)</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyActualCap"/>
                </td>
            </tr>
            <tr>
            <td align="right" width="50%">外贸销售占比(%)</td>
            <td align="left" width="50%">
                <input type="text" name="ftyFtRate"/>
            </td>
        </tr>
            <tr>
                <td align="right" width="50%">直销占比(%)</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyDsRate"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">代理占比(%)</td>
                <td align="left" width="50%">
                    <input type="text" name="ftyAsRate"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">厂房平面图图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file" id="importFile" />
                </td>
            </tr>

            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL24110300402.SAVE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL24110300402.js"></script>
