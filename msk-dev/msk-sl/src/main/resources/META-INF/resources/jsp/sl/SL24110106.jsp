<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<div class="group-accordion" active="false">
    <h3>
        <label>企业实验室、检测设备以及产品质量控制系统描述</label>
    </h3>
    <form:form action="${ctx}/SL24110106/update" id="SL24110106Form"
               metdod="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%" >实验室面积(平米)　</td>
                <td align="left" width="50%" >
                    <input type="text" name="labArea" value="${slEpCap.labArea}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%" >实验室功能　</td>
                <td align="left" width="50%" >
                    <input type="text" name="labFunction" value="${slEpCap.labFunction}"/>
                </td>
            </tr><tr>
            <td align="right" width="50%" >投资(万元)　</td>
            <td align="left" width="50%" >
                <input type="text" name="labInvestment" value="${slEpCap.labInvestment}"/>
            </td>
        </tr>
            <tr>
                <td align="right" width="50%">人员数量　</td>
                <td align="left" width="50%">
                    <input type="text" name="labMember" value="${slEpCap.labMember}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">主要设备及用途　</td>
                <td align="left" width="50%">
                    <input type="text" name="ddEquipment" value="${slEpCap.ddEquipment}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">实验室图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="labFile" id="importFile" />
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">检测设备图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="ddEquFile" id="importFile2" />
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">品控组织架构　</td>
                <td align="left" width="50%">
                    <input type="file" name="controllFile" id="importFile3" />
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">质量控制系统图　</td>
                <td align="left" width="50%">
                    <input type="file" name="qualityFile" id="importFile4" />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL24110106.UPDATE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL24110106.js"></script>
