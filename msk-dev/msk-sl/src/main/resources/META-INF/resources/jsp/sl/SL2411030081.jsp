<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun2(message,slAccount){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
        $.pdialog.close();
        $('#main-content').postUrl(Main.contextPath + "/SL24110100/init/"+slAccount);
    }
</script>
<div class="page-content detail-page" id="SL2411030081_id">
    <form:form action="${ctx}/SL2411030081/insert" id="SL2411030081Form"
               metdod="post" enctype="multipart/form-data">
        <table id="SL2411030081DataGrid">
            <tr>
                <td align="right" width="50%">职务</td>
                <td align="left" width="50%">
                    <select name="memberDuties" id="memberDuties" style="width:135px;">
                        <option value="">--请选择--</option>
                            <c:forEach items="${EpTeam}" var="list" varStatus="i">
                                <option value="${list.constantValue}">${list.constantName}</option>
                            </c:forEach>
                        <%--<option value="1">公司董事长</option>
                        <option value="2">公司总经理</option>
                        <option value="3">公司副总经理</option>
                        <option value="4">销售部经理</option>
                        <option value="5">品控部经理</option>--%>
                    </select>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">姓名</td>
                <td align="left" width="50%">
                    <input type="text" id="memberName" name="memberName"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">年龄</td>
                <td align="left" width="50%">
                    <input type="text" id="memberAge" name="memberAge"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">联系方式</td>
                <td align="left" width="50%">
                    <input type="text" id="memberTel" name="memberTel"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">教育程度</td>
                <td align="left" width="50%">
                    <input type="text" id="memberEduc" name="memberEduc"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">头像上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file" id="image" />
                </td>
            </tr>

            <tr>
                <td align="right">
                    <msk:button buttonValue="保存" buttonId="SL2411030081.SAVE" buttonType="button"/>
                </td>
                <td align="left">
                    <msk:button buttonValue="取消" buttonId="SL2411030081.BACK" buttonType="button"/>
                </td>
            </tr>

        </table>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL2411030081.js"></script>
