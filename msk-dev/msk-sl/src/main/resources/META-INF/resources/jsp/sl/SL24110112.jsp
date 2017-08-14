<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    var maSize="${slEpDdBeanList.size()}";
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>检测设备</label>
    </h3>

    <div>
        <div>
            <tr>
                <td align="center">
                    <msk:button buttonValue="添加" buttonId="SL24110112.ADD" buttonType="button"/>
                </td>
            </tr>
        </div>
    <c:forEach items="${slEpDdBeanList}" var="slEpDd" varStatus="i">
    <div>
    <form:form action="${ctx}/SL24110112/update" id="SL24110112Form${i.index}"
               metdod="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">设备名称</td>
                <td align="left" width="50%">
                    <input type="text"  name="ddName" value="${slEpDd.ddName}"/>
                    <input type="hidden" name="ddId" value="${slEpDd.ddId}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">主要用途</td>
                <td align="left" width="50%">
                    <input type="text" id="ddEquipmentId" name="ddEquipment" value="${slEpDd.ddEquipment}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">检测设备图片</td>
                <td align="left" width="50%">
                    <input type="file" id="slEpDdPathId" name="file"/>
                </td>
            </tr>
            <tr>
                <td align="right">
                    <msk:button buttonValue="保存" name="${i.index}" buttonId="SL24110112.UPDATE${i.index}" buttonType="button"/>
                </td>
                <td align="left">
                    <msk:button buttonValue="删除" name="${i.index}" buttonId="SL24110112.DELETE${i.index}" buttonType="button"/>
                </td>

            </tr>
        </table>
        </form:form>
        </div>
        </c:forEach>
    </div>
</div>
<script src="${ctx}/js/sl/SL24110112.js"></script>
