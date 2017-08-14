<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    var listSize="${workshoplistSize}";
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>企业生产车间、设备、产品工艺流程描述</label>
    </h3>
    <div>
        <div>
            <tr>
                <td align="center">
                    <msk:button buttonValue="添加" buttonId="SL2411010501.ADD" buttonType="button"/>
                </td>
            </tr>
        </div>
    <c:forEach items="${slEpWorkshops}" var="workshop" varStatus="i">
        <div>
            <form action="${ctx}/SL2411010501/update" id="SL2411010501Form${i.index}"  method="post" enctype="multipart/form-data">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="right" width="50%" >车间名称　</td>
                        <td align="left" width="50%" >
                            <input type="text" name="workshopName" value="${workshop.workshopName}"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%" >车间生产产品　</td>
                        <td align="left" width="50%" >
                            <input type="text" name="product" value="${workshop.product}"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%" >车间工艺流程特点　</td>
                        <td align="left" width="50%" >
                            <input type="text" name="process" value="${workshop.process}"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%" >车间图片上传　</td>
                        <td align="left" width="50%" >
                            <input type="file" name="file"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%" >
                            <input type="hidden" name="workshopId" value="${workshop.workshopId}"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <msk:button buttonValue="保存" buttonId="SL2411010501.UPDATE${i.index}" buttonType="button"/>
                        </td>
                        <td align="left">
                            <msk:button buttonValue="删除" buttonId="SL2411010501.DELETE${i.index}" buttonType="button"/>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        </c:forEach>
    </div>
</div>
<script src="${ctx}/js/sl/SL2411010501.js"></script>
