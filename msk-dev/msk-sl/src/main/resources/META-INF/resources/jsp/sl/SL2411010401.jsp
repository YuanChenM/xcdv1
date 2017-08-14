<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    var slepHonorList="${slepHonorList}";
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>企业荣誉描述</label>
    </h3>
    <div>
        <div>
            <tr>
                <td align="center">
                    <msk:button buttonValue="添加" buttonId="SL2411010401.ADD" buttonType="button"/>
                </td>
            </tr>
        </div>
    <c:forEach items="${slEpHonors}" var="epHonor" varStatus="i">
    <div>
        <form action="${ctx}/SL2411010401/update" id="SL2411010401Form${i.index}" method="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%" >荣誉证书发证日期(必填)　</td>
                <td align="left" width="50%" >
                    <c:if test="${epHonor.certDate == null}">
                    <input type="text" name="certDate" id="certDate${i.index}"/>
                    </c:if>
                    <c:if test="${epHonor.certDate != null}">
                    <input type="text" name="certDate" id="certDate${i.index}" value="<fmt:formatDate value="${epHonor.certDate}" pattern="yyyy-MM-dd" />"/>
                    </c:if>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%" >荣誉证书发证单位　</td>
                <td align="left" width="50%" >
                    <input type="text" name="certIssuer" value="${epHonor.certIssuer}"/>
                </td>
            </tr>
            <tr>
                <td align="left" width="50%" >
                    <input type="hidden" name="honorId" id="honorId${i.index}" value="${epHonor.honorId}"/>
                </td>
            </tr>
            <tr>
            <td align="right" width="50%" >荣誉描述(必填)　</td>
            <td align="left" width="50%" >
                <input type="text" name="honorDesc" id="honorDesc${i.index}" value="${epHonor.honorDesc}"/>
            </td>
            </tr>
            <tr>
                <td align="right" width="50%">${slEpCert.certName}图片上传</td>
                <td align="left" width="50%">
                    <input type="file"  name="file" id="importFile"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <msk:button buttonValue="保存"  buttonId="SL2411010401.UPDATE${i.index}" buttonType="button"/>
                </td>
                 <td align="left">
                     <msk:button buttonValue="删除" buttonId="SL2411010401.DELETE${i.index}" buttonType="button"/>
                 </td>
            </tr>

        </table>
    </form>
  </div>
    </c:forEach>
</div>
</div>
<script src="${ctx}/js/sl/SL2411010401.js"></script>
