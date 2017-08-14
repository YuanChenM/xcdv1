<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
    }
    var dataSize=${slEpAgentAuthAndSlEpOem.size()}
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>生产商/OEM商信息编辑</label>
    </h3>
    <div>
        <div>
            <tr>
                <td align="center">
                    <msk:button buttonValue="添加" buttonId="SL241101010.ADD" buttonType="button"/>
                </td>
            </tr>
        </div>
            <c:forEach items="${slEpAgentAuthAndSlEpOem}" var="slEpOem" varStatus="i">
            <form:form action="${ctx}/SL241101010/update" id="SL241101010Form${i.index}" method="post">
                <c:if test="${null!=slEpOem}">
                    <input type="hidden" name="markFlg" value="${slEpOem.markFlg}"/>
                    <input type="hidden" name="slCode" value="${slEpOem.slCode}"/>
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td align="right" width="50%">生产商名称</td>
                            <td align="left" width="50%">
                                <input type="text" name="epName" id="epNameId${i.index}" readonly="readonly" style="width:180px" value="${slEpOem.epName}"/>
                                <input type="text" name="producerEpId" id="producerEpId${i.index}" style="display:none" value="${slEpOem.producerEpId}"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">授权经销合同号</td>
                            <td align="left" width="50%">
                                <input type="text" name="contractNo" style="width:180px" value="${slEpOem.contractNo}"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">授权单位</td>
                            <td align="left" width="50%">
                                <input type="text" name="authEpName" style="width:180px" value="${slEpOem.authEpName}"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">授权期限开始</td>
                            <td align="left" width="50%">
                                <input type="text" name="authTermBegin" class="authTermBeginThree" id="authTermBeginThree${i.index}" style="width:180px" value="<fmt:formatDate value="${slEpOem.authTermBegin}" pattern="yyyy-MM-dd"/>"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">授权期限结束</td>
                            <td align="left" width="50%">
                                <input type="text" name="authTermEnd" class="authTermEndTwo" id="authTermEndTwo${i.index}" style="width:180px" value="<fmt:formatDate value="${slEpOem.authTermEnd}" pattern="yyyy-MM-dd"/>"/>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td align="left">
                                <msk:button buttonValue="保存" buttonId="SL241101010.SAVE${i.index}" buttonType="button" name="buttonName" saveId="${i.index}"/>
                                <msk:button buttonValue="删除" buttonId="SL241101010.DELETE${i.index}" buttonType="button" name="buttonDeleteName" deleteId="${i.index}"/>
                            </td>
                        </tr>
                    </table>
                </c:if>
            </form:form>
                </c:forEach>
        </div>
</div>
<script src="${ctx}/js/sl/SL241101010.js"></script>
