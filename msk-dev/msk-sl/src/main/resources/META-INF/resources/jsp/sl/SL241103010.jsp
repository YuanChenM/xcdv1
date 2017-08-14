<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
    }
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>生产商/OEM商信息编辑</label>
    </h3>
    <div>
    <div id="ordinary" style="display:block">
        <form:form action="${ctx}/SL241103010/save" id="SL241103010Form"
               method="post">
        <p align="center"><input type="radio" value="1" name="markFlg" checked="checked">代理商<input type="radio" value="2" name="markFlg">OEM代理商</p>
        <div align="center"><a href="#" id="agentCheck" style="color:red">点击选择生产商</a> </div>
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">生产商名称</td>
                <td align="left" width="50%">
                    <input type="text" name="epName" id="epNameId" disabled="disabled" style="width:180px"/>
                    <input type="text" name="producerEpId" id="producerEpId" style="display:none"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">授权经销合同号</td>
                <td align="left" width="50%">
                    <input type="text" name="contractNo" style="width:180px"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">授权单位</td>
                <td align="left" width="50%">
                    <input type="text" name="authEpName" style="width:180px"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">授权期限开始</td>
                <td align="left" width="50%">
                    <input type="text" name="authTermBegin" id="authTermBeginThree" style="width:180px"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">授权期限结束</td>
                <td align="left" width="50%">
                    <input type="text" name="authTermEnd" id="authTermEndTwo" style="width:180px"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL241103010.SAVE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
    </div>
</div>
</div>
<script src="${ctx}/js/sl/SL241103010.js"></script>
