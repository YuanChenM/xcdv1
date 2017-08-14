<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<%--<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
        $('#main-content').postUrl(Main.contextPath + "/SL241103000/init");
    }
</script>--%>
<div class="group-accordion" active="false" id="SL241103008accordion">
    <h3>
        <label>公司团队</label>
    </h3>
    <div id="initSL241103008">
    <form:form action="${ctx}/SL241103008/insert" id="SL241103008Form"
               metdod="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">

            <tr>
                <td align="right" width="50%">职务</td>
                <td align="left" width="50%">
                    <select name="memberDuties" id="memberDuties" style="width:135px;">
                        <option value="">--请选择--</option>
                        <%--<c:forEach items="${EpTeam}" var="list" varStatus="i">
                            <option value="${list.constantName}">${list.constantValue}</option>
                        </c:forEach>--%>
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
                    <msk:button buttonValue="保存" buttonId="SL241103008.SAVE" buttonType="button"/>
                </td>
                <td></td>

            </tr>
        </table>
    </form:form>
</div>
</div>
<script src="${ctx}/js/sl/SL241103008.js"></script>
