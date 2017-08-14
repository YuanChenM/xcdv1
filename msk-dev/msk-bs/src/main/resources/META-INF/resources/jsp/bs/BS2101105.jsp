<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript">
    var slIdcard = "${bs2101105Bean.slIdcard}";
    var slAccount = "${bs2101105Bean.slAccount}";
    var slCode = "${bs2101105Bean.slCode}";
    var slCodeDis = "${bs2101105Bean.slCodeDis}";
    var slConFlg = "${bs2101105Bean.slConFlg}";
    var flag1 = "${bs2101105Bean.flag1}";
    var shopQua = "${bs2101105Bean.shopQua}";
    var shopQua = "${bs2101105Bean.shopQua}";
    var memo1 = "${bs2101105Bean.memo1}";
    var memo2 = "${bs2101105Bean.memo2}";
    var memo3 = "${bs2101105Bean.memo3}";
    var memo4 = "${bs2101105Bean.memo4}";
    var memo5 = "${bs2101105Bean.memo5}";
    var memo6 = "${bs2101105Bean.memo6}";
    var slAddress = "${bs2101105Bean.slAddress}";
    var lat = "${bs2101105Bean.lat}";
    var lon = "${bs2101105Bean.lon}";
    var shopName = "${bs2101105Bean.shopName}";
    var shopId = "${bs2101105Bean.shopId}";
    var managingCharact1 = "${bs2101105Bean.managingCharact1}";
    var managingCharact2 = "${bs2101105Bean.managingCharact2}";
    var managingCharact3 = "${bs2101105Bean.managingCharact3}";
    var provinceCode = "${bs2101105Bean.provinceCode}";
    var cityCode = "${bs2101105Bean.cityCode}";
    var districtCode = "${bs2101105Bean.districtCode}";
    var shopId = "${bs2101105Bean.shopId}";
    var shopLogo = "${bs2101105Bean.shopLogo}";
    var flagNum = "${bs2101105Bean.flagNum}";
    var memo8 = "${bs2101105Bean.memo8}";

</script>
<script type="text/javascript">
    function callbackFun(message) {
        $.alertMessage.info(message);
        HDF.closeLoadingMask();
    }
</script>
<%--<navigation:header title="买手账号信息编辑" backTitleArray="买手店列表" backUrlArray="${ctx}/BS2101101/init"></navigation:header>--%>
<div class="page-content list-page">
    <div class="group-accordion" active="true">
        <h3>
            <label>买手账号信息编辑</label>
        </h3>

        <div id="" style="display:block">
            <form:form action="${ctx}/BS2101105/update" id="BS2101105Form" method="post" enctype="multipart/form-data">
                <table width="100%" border="0" cellpadding="0" cellspacing="10px">
                    <tr>

                        <c:if test="${bs2101105Bean.flagNum =='1'}">
                            <td align="right" width="18%">买手账号（必须）　</td>
                            <td align="left" width="">
                                <input style="width:200px;" type="text" id="slAccount1" name="slAccount" value="${bs2101105Bean.slAccount}" onblur="accountTest()">
                                <span id="account_sp"></span>
                            </td>
                        </c:if>
                        <c:if test="${bs2101105Bean.flagNum ==''|| bs2101105Bean.flagNum ==null}">
                            <td align="right" width="18%">买手账号（必须）　</td>
                            <td align="left" width="">
                                <input style="width:200px;" type="text" id="slAccount" name="slAccount" readonly="readonly"
                                       value="${bs2101105Bean.slAccount}"
                                       onblur="accountTest()">

                            </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td align="right" width="">密码（必须）　</td>
                        <td align="left" width="">
                            <input style="width:200px;" type="text" id="accountPsd" name="accountPsd"
                                   value="${bs2101105Bean.accountPsd}" onblur="pwdTest()"/>
                            <span id="pwd_sp"></span>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="">用户姓名　</td>
                        <td align="left" width="">
                            <input style="width:200px;" type="text" id="slContact" name="slContact"
                                   value="${bs2101105Bean.slContact}"/>
                          <%--  <span id="name_sp"></span>--%>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="">手机号　</td>
                        <td align="left" width="">
                            <input style="width:200px;" type="text" id="slTel" name="slTel"
                                   value="${bs2101105Bean.slTel}" onblur="pwdTest()"/>
                            <%--<span id="phone_sp"></span>--%>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="">头像图片上传　</td>
                        <td align="left" width="">
                            <c:if test="${not empty bs2101105Bean.accountImg}">
                                <img src="${bs2101105Bean.accountImg}" alt="买手头像" height="100px" width="100px">
                            </c:if>
                            <input type="hidden" id="accountImg" name="accountImg" value="${bs2101105Bean.accountImg}"/>
                            <input type="file" name="file"/>
                        </td>
                    </tr>
                    <tr>
                        <td/>
                        <td align="left">
                            <font color="#C0C0C0">可上传3个附件每个附件大小不得超过2M。<%--附件支持的格式有：'jpg', 'bmp', 'png',
                                'gif','txt','rar','zip','doc','docx','ini','conf','eml'--%></font>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td align="left" width="100px">
                            <msk:button buttonValue="保存" buttonId="BS2101105.UPDATE" buttonType="button"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
    <!--卖家基本信息  -->
    <div id="slSellerPage"></div>
    <!--店铺基本信息  -->
    <div id="slShopInfo"></div>
</div>


<script src="${ctx}/js/bs/BS2101105.js"></script>

