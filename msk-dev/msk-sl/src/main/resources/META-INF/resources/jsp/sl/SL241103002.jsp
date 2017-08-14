<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
    function callbackFun(message){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
        $('#main-content').postUrl(Main.contextPath + "/SL241103000/init");
    }
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>卖家基本信息</label>
    </h3>
    <form:form action="${ctx}/SL241103002/save" id="SL241103002Form"
               metdod="post" enctype="multipart/form-data">
        <table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
                <td align="right" width="50%">卖家主经营类型</td>
                <td align="left" width="50%">
                    <input type="radio" name="slMainClass" value="1"/>自产型
                    <input type="radio" name="slMainClass" value="2"/>代理型
                    <input type="radio" name="slMainClass" value="3"/>OEM型
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">二级经营类型</td>
                <td align="left" width="50%">
                    <input name="licBusiType" type="checkbox" value="自产型"/>自产型
                    <input name="licBusiType" type="checkbox" value="代理型"/>代理型
                    <input name="licBusiType" type="checkbox" value="OEM型"/>OEM型
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">营业执照注册号</td>
                <td align="left" width="50%">
                    <input type="text" name="licNo"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">公司场地</td>
                <td align="left" width="50%">
                    <input type="text" name="licAddr"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">经营范围</td>
                <td align="left" width="50%">
                    <input type="text" name="licBusiScope"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">法人代表</td>
                <td align="left" width="50%">
                    <input type="text" name="licLegalPerson"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">注册资本(万元)</td>
                <td align="left" width="50%">
                    <input type="text" name="licRegCapital"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">实收资本(万元)</td>
                <td align="left" width="50%">
                    <input type="text" name="licPaidinCapital"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">成立日期</td>
                <td align="left" width="50%">
                    <input type="text" name="licCrtDate" id="licCrtDate"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">营业开始日期</td>
                <td align="left" width="50%">
                    <input type="text" name="licTermBegin" id="licTermBegin"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">营业截止日期</td>
                <td align="left" width="50%">
                    <input type="text" name="licTermEnd" id="licTermEnd"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">区划编码（6位）</td>
                <td align="left" width="50%">
                    <input type="text" name="slAreaCode" id="slAreaCode"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">税务登记证号</td>
                <td align="left" width="50%">
                    <input type="text" name="taxNo"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">一般增值税纳税人资格认定编号</td>
                <td align="left" width="50%">
                    <input type="text" name="taxVatNo"/>
                </td>
            </tr>

            <tr>
                <td align="right" width="50%">组织代码证编号</td>
                <td align="left" width="50%">
                    <input type="text" name="orgNo"/>
                </td>
            </tr>

            <tr>
            <td align="right" width="50%">银行开户人</td>
            <td align="left" width="50%">
                <input type="text" name="balLegalPerson"/>
            </td>
            </tr>

            <tr>
            <td align="right" width="50%">开户银行</td>
            <td align="left" width="50%">
                <input type="text" name="balBank"/>
            </td>
            </tr>
            <tr>
            <td align="right" width="50%">银行账户</td>
            <td align="left" width="50%">
                <input type="text" name="balAccount"/>
            </td>
            </tr>

            <tr>
                <td align="right" width="50%">营业执照图片上传</td>
                <td align="left" width="50%">
                    <input type="file" name="file" id="importFile" />
                </td>
            </tr>

            <tr>
                <td></td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="SL241103002.SAVE" buttonType="button"/>
                </td>
                    <%--<td align="left" width="50%">
                        <msk:button buttonValue="取消" buttonId="SL241103001.BACK" buttonType="button"/>
                    </td>--%>
            </tr>
        </table>
    </form:form>
</div>
<script src="${ctx}/js/sl/SL241103002.js"></script>
