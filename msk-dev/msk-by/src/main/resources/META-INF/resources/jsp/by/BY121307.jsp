<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="新增买家" backTitleArray="买家列表" backUrlArray="${ctx}/BY121303/init/"></navigation:header>
<script type="text/javascript">
    var buyerId = $("#buyerId").val();
    function BY121307CallbackFun(message) {
        HDF.closeLoadingMask();
        $('#main-content').postUrl(Main.contextPath + "/BY121303/init");
    }
</script>
<input type="hidden" value="${buyerId}" name="buyerId" id="buyerId"/>

<div class="page-content list-page">
    <form:form id="BY121307Form" action="${ctx}/BY121307/save/${buyerId}" method="post" enctype="multipart/form-data">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>买家类型</label>
            </h3>
            <table style="width: 100%;" CellSpacing=8>
                <tr>
                    <td width="12.5%" align="right">买家类型:</td>
                    <td width="12.5%" align="left">
                        <select id="superiorType" name="buyerBasicInfo.superiorType">
                            <c:forEach items="${buyerTypeList}" var="buyerType">
                                <option value="${buyerType.constantValue}">${buyerType.constantName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="12.5%" align="right">二级类型:</td>
                    <td width="12.5%" align="left">
                        <select id="buyerTypeId" name="buyerBasicInfo.superiorSubType">
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td width="12.5%" align="right">
                        <div id="isFoodMarket" style="display: none">
                            <input type="checkbox" value="1" name="buyerBasicInfo.isMarketFlg"/>菜场
                        </div>
                    </td>
                    <td width="12.5%" align="left">
                        <input type="hidden" id="superiorSubName" name="buyerBasicInfo.superiorSubName">
                    </td>
                    <td width="12.5%" align="right"></td>
                    <td width="12.5%" align="left"></td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">物流区:</td>
                    <td width="12.5%" align="left">
                        <select id="lgcsAreaCode" name="buyerBasicInfo.lgcsAreaCode">
                            <option value="">请选择</option>
                            <c:forEach items="${logisticsAreaList}" var="logisticsArea">
                                <option value="${logisticsArea.lgcsAreaCode}">${logisticsArea.lgcsAreaName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="12.5%" align="right">地区(城市):</td>
                    <td width="12.5%" align="left">
                        <select id="cityCode" name="buyerBasicInfo.cityCode">
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td width="12.5%" align="right">区(县):</td>
                    <td width="12.5%" align="left">
                        <select id="districtCode" name="buyerBasicInfo.districtCode">
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                </tr>
                <tr>
                    <td width="12.5%" align="right">
                        <span id="superiorDec">批发市场:</span>
                    </td>
                    <td width="12.5%" align="left">
                        <select id="superiorId" name="buyerBasicInfo.superiorId">
                            <option value="">请选择</option>
                        </select>
                    </td>
                    <td width="12.5%" align="right">
                        <span id="superiorQuaDec">批发市场等级:</span>
                    </td>
                    <td width="12.5%" align="left">
                        <input value="" name="buyerBasicInfo.superiorQua" id="superiorQua" readonly/>
                    </td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                </tr>
            </table>
        </div>
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>买家基本信息</label>
            </h3>
            <table style="width: 100%;" CellSpacing=8>
                <tr>
                    <td width="12.5%" align="right">买家名称:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="buyerName"
                                                          name="buyerBasicInfo.buyerName"/></td>
                    <td width="12.5%" align="right">买家地址:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="buyerAddr"
                                                          name="buyerBasicInfo.buyerAddr"/></td>
                    <td width="12.5%" align="right"></td>
                    <td width="12.5%" align="left"></td>
                    <td width="12.5%" align="right"></td>
                    <td width="12.5%" align="left"></td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">店铺号:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="storeNo"
                                                          name="buyerBasicInfo.storeNo"/></td>
                    <td width="12.5%" align="right">店铺面积:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="storeArea"
                                                          name="buyerBasicInfo.storeArea"/></td>
                    <td width="12.5%" align="right">营业电话:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="busiTel"
                                                          name="buyerBasicInfo.busiTel"/></td>
                    <td width="12.5%" align="right">员工人数:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="employeesNum"
                                                          name="buyerBasicInfo.employeesNum" style="ime-mode:disabled;"
                                                          onpaste="return false;"/></td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">计划订货间隙:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="planOrderGap"
                                                          name="buyerBasicInfo.planOrderGap"/></td>
                    <td width="12.5%" align="right">计划订货量:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="planOrderNum"
                                                          name="buyerBasicInfo.planOrderNum"/></td>
                    <td width="12.5%" align="right">实际订货间隙:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="actualOrderGap"
                                                          name="buyerBasicInfo.actualOrderGap"/></td>
                    <td width="12.5%" align="right">实际订货量:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="actualOrderNum"
                                                          name="buyerBasicInfo.actualOrderNum"/></td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">习惯支付方式:</td>
                    <td width="12.5%" align="left">
                        <select:codemaster codeName="PaymentMethod" name="buyerBasicInfo.paymentType" id="paymentType"/>
                    </td>
                    <td width="12.5%" align="right">上线状态:</td>
                    <td width="12.5%" align="left">
                        <select:codemaster codeName="MarketingSatus" name="buyerBasicInfo.marketingsStatus"
                                           id="marketingsStatus"/>
                    </td>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                </tr>
                <tr>
                    <td width="12.5%" align="right">买家网站:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="buyerWebsite"
                                                          name="buyerBasicInfo.buyerWebsite"/></td>
                    <td width="12.5%" align="right">买家微信公众号:</td>
                    <td width="12.5%" align="left"><input type="text" value="" id="buyerWechat"
                                                          name="buyerBasicInfo.buyerWechat"/></td>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                </tr>
            </table>
        </div>
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>买家销售收货信息</label>
            </h3>
            <table style="width: 100%;" CellSpacing=8>
                <tr>
                    <td width="12.5%" align="right">买家收货地址:</td>
                    <td colspan="7" width="87.5%" align="left">
                        <input type="text" name="buyerRecAddrList[0].receiveAddr" id="receiveAddr1"/>
                        <input type="text" name="buyerRecAddrList[1].receiveAddr" id="receiveAddr2"/>
                    </td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">买家收货时间:</td>
                    <td colspan="7" width="87.5%" align="left">
                        <c:forEach items="${recTimeCommList}" var="recTime">
                            <input type="checkbox" name="buyerRecTime"
                                   value="${recTime.constantValue}"/>${recTime.constantName}
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">买家销售对象:</td>
                    <td colspan="7" width="87.5%" align="left">
                        <c:forEach items="${salestargetCommList}" var="salestarget">
                            <input type="checkbox" name="buyerSalestarget"
                                   value="${salestarget.constantValue}"/>${salestarget.constantName}
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">买家销售产品:</td>
                    <td colspan="7" width="87.5%" align="left">
                        <c:forEach items="${pdClaCommList}" var="pdCla">
                            <input type="checkbox" name="buyerPdCla" value="${pdCla.classesCode}"/>${pdCla.classesName}
                        </c:forEach>
                    </td>
                </tr>
            </table>
        </div>
        <div class="group-accordion" collapsible="false" active="true">
            <h3>
                <label>买家证照信息</label>
            </h3>
            <table style="width: 100%;" CellSpacing=8>
                <tr>
                    <td width="12.5%" align="right">营业执照类型:</td>
                    <td width="12.5%" align="left">
                        <select:codemaster codeName="LicType" name="buyerLicence.licName" id="licName"/>
                    </td>
                    <td width="12.5%" align="right">营业执照号码:</td>
                    <td width="12.5%" align="left">
                        <input type="text" id="licNumber" name="buyerLicence.licNumber" value="">
                    </td>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                </tr>
                <tr>
                    <td width="12.5%" align="right">法定代表人姓名:</td>
                    <td width="12.5%" align="left">
                        <input type="text" id="legalName" name="buyerLicence.legalName" value=""></td>
                    <td width="12.5%" align="right">法定代表人证件类型:</td>
                    <td width="12.5%" align="left">
                        <select:codemaster codeName="LegalLicType" name="buyerLicence.legalLicType" id="legalLicType"/>
                    </td>
                    <td width="12.5%" align="right">法定代表人证件号码:</td>
                    <td width="12.5%" align="left">
                        <input type="text" id="legalLicNumber" name="buyerLicence.legalLicNumber" value=""></td>
                    </td>
                    <td width="12.5%"/>
                    <td width="12.5%"/>
                </tr>
                <tr>
                    <td width="12.5%" align="right">营业执照:</td>
                    <td width="12.5%" align="left">
                        <input type="file" name="busLicPic"/>
                    </td>
                    <td width="12.5%" align="right">组织机构代码证:</td>
                    <td width="12.5%" align="left">
                        <input type="file" name="orgCertificatePic"/>
                    </td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">税务登记证:</td>
                    <td width="12.5%" align="left">
                        <input type="file" name="taxCertificatePic"/>
                    </td>
                    <td width="12.5%" align="right">食品流通许可证:</td>
                    <td width="12.5%">
                        <input type="file" name="foodCertificatePic"/>
                    </td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                </tr>
                <tr>
                    <td width="12.5%" align="right">法定代表人证:</td>
                    <td width="12.5%" align="left">
                        <input type="file" name="legalCertificatePic"/>
                    </td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                    <td width="12.5%"></td>
                </tr>
            </table>
        </div>
    </form:form>

    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>买家雇员信息</label>
        </h3>

        <form action="${ctx}/BY121304/search/${buyerId}" method="post">
            <table id="BY121307_Grid">
                <thead>
                <tr>
                    <th coltype="sno" width="20px">编号</th>
                    <th coltype="text" name="employeeTypeName" filter=false>员工类型</th>
                    <th coltype="text" name="employeeName" filter=true>员工姓名</th>
                    <th coltype="text" name="employeeTel" filter=true>手机号</th>
                    <th coltype="text" name="employeeQq" filter=true>QQ号</th>
                    <th coltype="text" name="employeeWechat" filter=true>微信号</th>
                    <th coltype="text" name="busCardFlgName" filter=false>有无名片照</th>
                    <th coltype="text" name="contactPersonName" filter=false>是否联络人</th>
                    <th coltype="text" name="purchaseName" filter=false>是否采购人</th>
                    <th coltype="text" name="receivePersonName" filter=false>是否收货人</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <msk:button buttonValue="新增" buttonId="BY121307.ADD" buttonType="button"/>
        </form>
    </div>
    <msk:button buttonValue="完成" buttonId="BY121307.SAVE" buttonType="button"/>
</div>
<script type="text/javascript" src="${ctx}/js/by/BY121307.js"></script>
