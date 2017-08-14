<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<script type="text/javascript">
    function callbackFun2(message,slAccount){
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
        $.pdialog.close();
        //$('#main-content').postUrl(Main.contextPath + "/SL24110100/init/"+slAccount);
    }
</script>
    <div>
        <div>
            <table>
                <tr>
                    <td>
                        <input type="radio" name="brandType" value="1" onchange="myBrand()" checked="checked"/>自有品牌
                    </td>
                    <td>
                        <input type="radio" name="brandType" value="2" onchange="proxyBrand()"/>代理品牌
                    </td>
                </tr>
            </table>
        </div>
        <div id="myBrand" style="display:block">
            <form:form action="${ctx}/SL2411030071/insert" id="SL2411030071Form"
                       metdod="post" enctype="multipart/form-data">
                <table width="100%" border="0" cellpadding="3" cellspacing="3">
                    <tr>
                        <td align="right" width="50%">产品分类　</td>
                        <td align="left" width="50%">
                            <input type="radio" name="brandClass" value="0"/>卖家独立品牌
                            <input type="radio" name="brandClass" value="1"/>神农先生联合
                            <input type="radio" name="brandClass" value="2"/>神农客联合
                            <input type="radio" name="brandClass" value="3"/>神农人家联合
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">品牌名称　</td>
                        <td align="left" width="50%">
                            <input type="text" id="brandName" name="brandName"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">商标注册证编码　</td>
                        <td align="left" width="50%">
                            <input type="text" id="brandNo2" name="brandNo"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">有效期开始　</td>
                        <td align="left" width="50%">
                            <input type="text" name="termBegin" id="termBegin71"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">有效期截止　</td>
                        <td align="left" width="50%">
                            <input type="text" name="termEnd" id="termEnd71"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">荣誉证书编号　</td>
                        <td align="left" width="50%">
                            <input type="text" id="honorNo" name="honorNo"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">荣誉描述　</td>
                        <td align="left" width="50%">
                            <input type="text" id="honorDes" name="honorDes"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">发证单位　</td>
                        <td align="left" width="50%">
                            <input type="text" id="certIssuer" name="certIssuer"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">发证日期　</td>
                        <td align="left" width="50%">
                            <input type="text" name="certDate" id="certDate71"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">品牌证书图片上传　</td>
                        <td align="left" width="50%">
                            <input type="file" name="brandCertFile" id="brandCert"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">包装图片上传　</td>
                        <td align="left" width="50%">
                            <input type="file" name="brandFile" id="brand"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">品牌荣誉证书上传　</td>
                        <td align="left" width="50%">
                            <input type="file" name="file" id="honorCert"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">
                            <msk:button buttonValue="保存" buttonId="SL2411030071.SAVE" buttonType="button"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>

        <div id="proxyBrand" style="display:none">
            <form:form action="${ctx}/SL2411030071/insert2" id="SL24110300711Form"
                       metdod="post" commandName="agent" modelAttribute="agent">
                <table width="100%" border="0" cellpadding="3" cellspacing="3">
                    <tr>
                        <td align="right" width="50%">产品分类　</td>
                        <td align="left" width="50%">
                            <input type="radio" name="brandClass" value="0"/>卖家独立品牌
                            <input type="radio" name="brandClass" value="1"/>神农先生联合
                            <input type="radio" name="brandClass" value="2"/>神农客联合
                            <input type="radio" name="brandClass" value="3"/>神农人家联合
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">生产商列表　</td>
                        <td align="left" width="50%">
                            <form:select path="producerEpId" style="width:120px" id="prolist">
                                <form:option value="" label="请选择"/>
                                <form:options items="${proxyBean1}" itemValue="producerEpId" itemLabel="authEpName"/>
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">品牌列表　</td>
                        <td align="left" width="50%">
                            <form:select path="brandName" style="width:120px" id="brandlist">
                                <form:option value="" label="请选择"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">代理及分销授权合同号　</td>
                        <td align="left" width="50%">
                            <input type="text" id="contractNo" name="contractNo"/>
                        </td>
                    </tr>

                    <tr>
                        <td align="right" width="50%">授权单位　</td>
                        <td align="left" width="50%">
                            <input type="text" id="authEpName" name="authEpName"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">授权期限开始日期　</td>
                        <td align="left" width="50%">
                            <input type="text" name="authTermBegin" id="authTermBegin711"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">授权期限截止日期　</td>
                        <td align="left" width="50%">
                            <input type="text" name="authTermEnd" id="authTermEnd711"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">授权期限是否长期　</td>
                        <td align="left" width="50%">
                            <input type="radio" name="authTermUnliimited" value="0" checked="checked"/>否
                            <input type="radio" name="authTermUnliimited" value="1"/>是
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <msk:button buttonValue="保存" buttonId="SL24110300711.SAVE" buttonType="button"/>
                        </td>
                        <td></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
<script type="text/javascript">
    function myBrand(){
        $('#myBrand').css("display","block");
        $('#proxyBrand').css("display","none");
    }
    function proxyBrand(){
        $('#myBrand').css("display","none");
        $('#proxyBrand').css("display","block");
    }
</script>
<script src="${ctx}/js/sl/SL2411030071.js"></script>
