<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="msk" uri="/msk" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="group-accordion" collapsible="true" active="true">
    <h3>
        <label>买家类型</label>
    </h3>
    <form:form id="buyerTypeForm" metdod="post" enctype="multipart/form-data">
        <input type="hidden" name="buyerId" id="buyerId" value="${buyerId}">
        <table id="buyerTypeShow" style="width: 100%;" CellSpacing=8>
            <tr>
                <td width="12.5%" align="right">买家类型:</td>
                <td width="12.5%" align="left">${buyerDetail.superiorName}</td>
                <td width="12.5%" align="right">二级类型:</td>
                <td width="12.5%" align="left">${buyerDetail.superiorSubName}</td>
                <td width="12.5%" align="right">
                    <c:if test="${buyerDetail.superiorType ==8 && buyerDetail.superiorSubType==1}">
                        <input type="checkbox" value="1" disabled <c:if test="${buyerDetail.isMarketFlg==1}">checked="true" </c:if>/>菜场
                    </c:if>
                </td>
                <td width="12.5%" align="left"></td>
                <td width="12.5%" align="right"></td>
                <td width="12.5%" align="left"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">物流区:</td>
                <td width="12.5%" align="left">${buyerDetail.lgcsAreaName}</td>
                <td width="12.5%" align="right">地区(城市):</td>
                <td width="12.5%" align="left">${buyerDetail.cityName}</td>
                <td width="12.5%" align="right">区(县):</td>
                <td width="12.5%" align="left">${buyerDetail.districtName}</td>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <c:choose>
                    <c:when test="${buyerDetail.superiorType eq '1'}">
                        <td width="12.5%" align="right">批发市场:</td>
                        <td width="12.5%" align="left">${buyerDetail.superiorIdName}</td>
                        <td width="12.5%" align="right">批发市场等级:</td>
                        <td width="12.5%" align="left">${buyerDetail.superiorQua}</td>
                    </c:when>
                    <c:when test="${buyerDetail.superiorType eq '2'}">
                        <td width="12.5%" align="right">菜场:</td>
                        <td width="12.5%" align="left">${buyerDetail.superiorIdName}</td>
                        <td width="12.5%" align="right">菜场等级:</td>
                        <td width="12.5%" align="left">${buyerDetail.superiorQua}</td>
                    </c:when>
                    <c:otherwise>
                        <td width="12.5%" align="right"></td>
                        <td width="12.5%" align="left"></td>
                        <td width="12.5%" align="right"></td>
                        <td width="12.5%" align="left"></td>
                    </c:otherwise>
                </c:choose>
                <td width="12.5%" align="right"></td>
                <td width="12.5%" align="left"></td>
                <td width="12.5%" align="right"></td>
                <td width="12.5%" align="left"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">
                    <msk:button buttonValue="编辑" buttonId="BuyerType.Edit" buttonType="button"/>
                </td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
        </table>
        <table id="buyerTypeEdit" style="width: 100%;display: none;" CellSpacing=8>
            <tr>
                <td width="12.5%" align="right">买家类型:</td>
                <td width="12.5%" align="left">
                    <select id="superiorType" name="superiorType">
                        <option value="">请选择</option>
                        <c:forEach items="${buyerTypeList}" var="buyerType">
                            <c:choose>
                                <c:when test="${buyerDetail.superiorType eq buyerType.constantValue}">
                                    <option value="${buyerType.constantValue}"
                                            selected>${buyerType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${buyerType.constantValue}">${buyerType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%" align="right">二级类型:</td>
                <td width="12.5%" align="left">
                    <select id="buyerTypeId" name="superiorSubType">
                        <option value="${buyerDetail.superiorSubType}" selected>${buyerDetail.superiorSubName}</option>

                    </select></td>
                <td width="12.5%" align="right">

                        <div id="isFoodMarket" <c:if test="${buyerDetail.superiorType !=8 || buyerDetail.superiorSubType!=1}"> style="display: none"</c:if>>
                            <input type="checkbox" value="1" <c:if test="${buyerDetail.isMarketFlg==1}">checked="true" </c:if>name="isMarketFlg"/>菜场</div>

                </td>
                <td width="12.5%" align="left"><input type="hidden" id="superiorSubName" value="${buyerDetail.superiorSubName}" name="superiorSubName"></td>
                <td width="12.5%" align="right"></td>
                <td width="12.5%" align="left"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">物流区:</td>
                <td width="12.5%" align="left">
                    <select id="lgcsAreaCode" name="lgcsAreaCode">
                        <option value="">请选择</option>
                        <c:forEach items="${logisticsAreaList}" var="logisticsArea">
                            <c:choose>
                                <c:when test="${buyerDetail.lgcsAreaCode eq logisticsArea.lgcsAreaCode}">
                                    <option value="${logisticsArea.lgcsAreaCode}"
                                            selected>${logisticsArea.lgcsAreaName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${logisticsArea.lgcsAreaCode}">${logisticsArea.lgcsAreaName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%" align="right">地区(城市):</td>
                <td width="12.5%" align="left">
                    <select id="cityCode" name="cityCode">
                        <option value="">请选择</option>
                        <c:forEach items="${cityList}" var="city">
                            <c:choose>
                                <c:when test="${buyerDetail.cityCode eq city.cityCode}">
                                    <option value="${city.cityCode}" selected>${city.cityName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${city.cityCode}">${city.cityName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%" align="right">区(县):</td>
                <td width="12.5%" align="left">
                    <select id="districtCode" name="districtCode">
                        <option value="">请选择</option>
                        <c:forEach items="${districtList}" var="district">
                            <c:choose>
                                <c:when test="${buyerDetail.districtCode eq district.districtCode}">
                                    <option value="${district.districtCode}" selected>${district.districtName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${district.districtCode}">${district.districtName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <c:choose>
                    <c:when test="${buyerDetail.superiorType eq '1'}">
                        <td width="12.5%" align="right"><span id="superiorDec">批发市场:</span></td>
                        <td width="12.5%" align="left">
                            <select id="superiorId" name="superiorId">
                                <option value="">请选择</option>
                                <c:forEach items="${marketTerminalList}" var="marketTerminal">
                                    <c:choose>
                                        <c:when test="${marketTerminal.terMarketId eq buyerDetail.superiorId}">
                                            <option value="${marketTerminal.terMarketId}"
                                                    selected>${marketTerminal.marketName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${marketTerminal.terMarketId}">${marketTerminal.marketName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="12.5%" align="right"><span id="superiorQuaDec">批发市场等级:</span></td>
                        <td width="12.5%" align="left">
                            <input value="${buyerDetail.superiorQua}" name="superiorQua" id="superiorQua" readonly/>
                        </td>
                    </c:when>
                    <c:when test="${buyerDetail.superiorType eq '2'}">
                        <td width="12.5%" align="right"><span id="superiorDec">菜场:</span></td>
                        <td width="12.5%" align="left">
                            <select id="superiorId" name="superiorId">
                                <option value="">请选择</option>
                                <c:forEach items="${marketFoodList}" var="marketFood">
                                    <c:choose>
                                        <c:when test="${marketFood.fodMarketId eq buyerDetail.superiorId}">
                                            <option value="${marketFood.fodMarketId}"
                                                    selected>${marketFood.marketName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${marketFood.fodMarketId}">${marketFood.marketName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </td>
                        <td width="12.5%" align="right"><span id="superiorQuaDec">菜场等级:</span></td>
                        <td width="12.5%" align="left">
                            <input value="${buyerDetail.superiorQua}" name="superiorQua" id="superiorQua" readonly/>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td width="12.5%" align="right"><span id="superiorDec" style="display: none;"></span></td>
                        <td width="12.5%" align="left"><select id="superiorId" name="superiorId"
                                                               style="display: none;"></select></td>
                        <td width="12.5%" align="right"><span id="superiorQuaDec" style="display: none"></span></td>
                        <td width="12.5%" align="left"><input value="" name="superiorQua" id="superiorQua"
                                                              style="display: none" readonly/></td>
                    </c:otherwise>
                </c:choose>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
                <td width="12.5%"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">
                    <msk:button buttonValue="完成" buttonId="BuyerType.Save" buttonType="button"/>
                </td>
            </tr>
            <tr></tr>
        </table>
    </form:form>
</div>
<div class="group-accordion" collapsible="true" active="true">
    <h3>
        <label>买家基本信息</label>
    </h3>
    <form:form id="basicEditForm" metdod="post" enctype="multipart/form-data">
        <input type="hidden" name="buyerId" id="buyerId" value="${buyerId}">
        <table id="showTable" style="width: 100%;" CellSpacing=8>
            <tr>
                <td width="12.5%" align="right">买家编码:</td>
                <td width="12.5%" align="left">${buyerDetail.buyerCode}</td>
                <td width="12.5%" align="right">买家名称:</td>
                <td width="12.5%" align="left">${buyerDetail.buyerName}</td>
                <td width="12.5%" align="right">买家地址:</td>
                <td width="12.5%" align="left">${buyerDetail.buyerAddr}</td>
                <td width="12.5%" align="right"></td>
                <td width="12.5%" align="left"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">店铺号:</td>
                <td width="12.5%" align="left">${buyerDetail.storeNo}</td>
                <td width="12.5%" align="right">店铺面积:</td>
                <td width="12.5%" align="left">${buyerDetail.storeArea}</td>
                <td width="12.5%" align="right">营业电话:</td>
                <td width="12.5%" align="left">${buyerDetail.busiTel}</td>
                <td width="12.5%" align="right">员工人数:</td>
                <td width="12.5%" align="left">${buyerDetail.employeesNum}</td>
            </tr>
            <tr>
                <td width="12.5%" align="right">计划订货间隙:</td>
                <td width="12.5%" align="left">${buyerDetail.planOrderGap}</td>
                <td width="12.5%" align="right">计划订货量:</td>
                <td width="12.5%" align="left">${buyerDetail.planOrderNum}</td>
                <td width="12.5%" align="right">实际订货间隙:</td>
                <td width="12.5%" align="left">${buyerDetail.actualOrderGap}</td>
                <td width="12.5%" align="right">实际订货量:</td>
                <td width="12.5%" align="left">${buyerDetail.actualOrderNum}</td>
            </tr>
            <tr>
                <td width="12.5%" align="right">习惯支付方式:</td>
                <td width="12.5%" align="left">${buyerDetail.paymentTypeName}</td>
                <td width="12.5%" align="right">上线状态:</td>
                <td width="12.5%" align="left">${buyerDetail.marketingsStatusName}</td>
                <td width="12.5%" align="right">注册来源:</td>
                <td width="12.5%" align="left">${buyerDetail.registerSourceName}</td>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <td width="12.5%" align="right">买家网站:</td>
                <td width="12.5%" align="left">${buyerDetail.buyerWebsite}</td>
                <td width="12.5%" align="right">买家微信公众号:</td>
                <td width="12.5%" align="left">${buyerDetail.buyerWechat}</td>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <td width="12.5%" align="right">
                    <msk:button buttonValue="编辑" buttonId="Basic.Edit" buttonType="button"/>
                </td>
                <td width="12.5%" align="right">
                    <msk:button buttonValue="查看账号" buttonId="Basic.SeeAccount" buttonType="button"/>
                </td>
            </tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
            <tr></tr>
        </table>
        <table id="editTable" style="width: 100%;display: none;" CellSpacing=8>
            <tr>
                <td width="12.5%" align="right">买家编码:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.buyerCode}" id="buyerCode"
                                                      name="buyerCode"/></td>
                <td width="12.5%" align="right">买家名称:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.buyerName}" id="buyerName"
                                                      name="buyerName"/></td>
                <td width="12.5%" align="right">买家地址:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.buyerAddr}" id="buyerAddr"
                                                      name="buyerAddr"/></td>
                <td width="12.5%" align="right"></td>
                <td width="12.5%" align="left"></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">店铺号:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.storeNo}" id="storeNo"
                                                      name="storeNo"/></td>
                <td width="12.5%" align="right">店铺面积:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.storeArea}" id="storeArea"
                                                      name="storeArea"/></td>
                <td width="12.5%" align="right">营业电话:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.busiTel}" id="busiTel"
                                                      name="busiTel"/></td>
                <td width="12.5%" align="right">员工人数:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.employeesNum}" id="employeesNum"
                                                      name="employeesNum"/></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">计划订货间隙:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.planOrderGap}" id="planOrderGap"
                                                      name="planOrderGap"/></td>
                <td width="12.5%" align="right">计划订货量:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.planOrderNum}" id="planOrderNum"
                                                      name="planOrderNum"/></td>
                <td width="12.5%" align="right">实际订货间隙:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.actualOrderGap}"
                                                      id="actualOrderGap" name="actualOrderGap"/></td>
                <td width="12.5%" align="right">实际订货量:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.actualOrderNum}"
                                                      id="actualOrderNum" name="actualOrderNum"/></td>
            </tr>
            <tr>
                <td width="12.5%" align="right">习惯支付方式:</td>
                <td width="12.5%" align="left">
                    <select id="paymentType" name="paymentType">
                        <c:forEach items="${payTypeList}" var="payType">
                            <c:choose>
                                <c:when test="${buyerDetail.paymentType eq payType.constantValue}">
                                    <option value="${payType.constantValue}" selected>${payType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${payType.constantValue}">${payType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%" align="right">上线状态:</td>
                <td width="12.5%" align="left">
                    <select id="marketingsStatus" name="marketingsStatus">
                        <c:forEach items="${marketingStatusList}" var="marketingStatus">
                            <c:choose>
                                <c:when test="${buyerDetail.marketingsStatus eq marketingStatus.constantValue}">
                                    <option value="${marketingStatus.constantValue}"
                                            selected>${marketingStatus.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${marketingStatus.constantValue}">${marketingStatus.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
                <td width="12.5%" align="right">注册来源:</td>
                <td width="12.5%" align="left">${buyerDetail.registerSourceName}<input type="hidden"
                                                                                       value="${buyerDetail.registerSource}"
                                                                                       name="registerSource"
                                                                                       id="registerSource"/></td>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <td width="12.5%" align="right">买家网站:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.buyerWebsite}" id="buyerWebsite"
                                                      name="buyerWebsite"/></td>
                <td width="12.5%" align="right">买家微信公众号:</td>
                <td width="12.5%" align="left"><input type="text" value="${buyerDetail.buyerWechat}" id="buyerWechat"
                                                      name="buyerWechat"/></td>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
                <td width="12.5%"/>
            </tr>
            <tr>
                <td width="12.5%" align="right">
                    <msk:button buttonValue="完成" buttonId="Basic.Save" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
<script type="text/javascript" src="${ctx}/js/by/comm/BASE_BUYER_BASIC_INFO.js"></script>
