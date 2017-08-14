<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
    var ecTeamSize="${ecTeamSize}";
</script>

<div class="group-accordion" active="false">
    <h3>
        <label>电商团队</label>
    </h3>

    <div>
        <div>
            <tr>
                <td align="center">
                    <msk:button buttonValue="添加" buttonId="SL24110109.ADD" buttonType="button"/>
                </td>
            </tr>
        </div>
    <c:forEach items="${ecTeam}" var="ecTeam" varStatus="i">
    <div>
    <form:form action="${ctx}/SL24110109/update" id="SL24110109Form${i.index}"
               metdod="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">职务</td>
                <td align="left" width="50%">
                    <input type="text"  name="eleaderFlg" value="${ecTeam.eleaderFlg}" readonly/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">姓名</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberName" name="ememberName" value="${ecTeam.ememberName}"/>
                    <input type="hidden" id="eslCode" name="eslCode" value="${ecTeam.eslCode}"/>
                    <input type="hidden" id="ememberId" name="ememberId" value="${ecTeam.ememberId}"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">年龄</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberAge" name="ememberAge" value="${ecTeam.ememberAge}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">联系方式</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberTel" name="ememberTel" value="${ecTeam.ememberTel}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">教育程度</td>
                <td align="left" width="50%">
                    <input type="text" id="ememberEduc" name="ememberEduc" value="${ecTeam.ememberEduc}"/>
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
                    <msk:button buttonValue="保存" name="${i.index}" buttonId="SL24110109.UPDATE${i.index}" buttonType="button"/>
                </td>
                <td align="left">
                    <msk:button buttonValue="删除" name="${i.index}" buttonId="SL24110109.DELETE${i.index}" buttonType="button"/>
                </td>

            </tr>
        </table>
        </form:form>
        </div>
        </c:forEach>
    </div>
</div>
<script src="${ctx}/js/sl/SL24110109.js"></script>
