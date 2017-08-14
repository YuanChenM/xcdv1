<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script type="text/javascript">
    var buyerId=$("#buyerId").val();
    var editType = $("#editType").val();
    function callbackFun(message){
        HDF.closeLoadingMask();
        if(editType == "BY121307Add"){
            $.pdialog.close();
            BY121307.BY121307Grid.fnDraw();
        }else{
            $('#main-content').postUrl(Main.contextPath+"/BY121304/init/"+buyerId,null,function(){
                $.pdialog.close();
            });
        }
    }
</script>
<div class="page-content list-page">
    <div>
    <form:form action="${ctx}/BY12130401/save/" id="BY12130401Form"
               method="post" enctype="multipart/form-data">
        <input type="hidden" id="id" name="id" value="${id}"/>
        <input type="hidden" id="buyerId" name="buyerId" value="${buyerId}"/>
        <input type="hidden" id="editType" name="editType" value="${editType}"/>
        <table style="width: 100%;" CellSpacing=8>
            <tr>
                <td align="right" width="50%">员工姓名</td>
                <td align="left" width="50%">
                    <c:choose>
                        <c:when test="${editType eq 'BY121307Add' || editType eq 'BY121304Add'}">
                            <input type="text" id="employeeName" name="employeeName" value="${buyerEmployee.employeeName}"/>
                        </c:when>
                        <c:otherwise>
                            <input type="text" id="employeeName" name="employeeName" value="${buyerEmployee.employeeName}" readonly/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">员工类型</td>
                <td align="left" width="50%">
                    <select id="employeeType" name="employeeType" style="width:133px">
                        <c:forEach items="${employeeTypeList}" var="employeeType">
                            <c:choose>
                                <c:when test="${employeeType.constantValue eq buyerEmployee.employeeType}">
                                    <option value="${employeeType.constantValue}" selected>${employeeType.constantName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${employeeType.constantValue}">${employeeType.constantName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">手机号</td>
                <td align="left" width="50%">
                    <input type="text" id="employeeTel" name="employeeTel" value="${buyerEmployee.employeeTel}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">QQ号</td>
                <td align="left" width="50%">
                    <input type="text" id="employeeQq" name="employeeQq" value="${buyerEmployee.employeeQq}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">微信号</td>
                <td align="left" width="50%">
                    <input type="text" id="employeeWechat" name="employeeWechat" value="${buyerEmployee.employeeWechat}"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">
                    <c:choose>
                        <c:when test="${buyerEmployee.busCardFlg eq '1'}">
                            <input type="checkbox" id="busCardFlg" name="busCardFlg" checked/>有无名片照
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" id="busCardFlg" name="busCardFlg"/>有无名片照
                        </c:otherwise>
                    </c:choose>
                </td>
                <td align="left" width="50%">
                    <c:choose>
                        <c:when test="${buyerEmployee.contactPerson eq '1'}">
                            <input type="checkbox" id="contactPerson" name="contactPerson" checked/>是否联络人
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" id="contactPerson" name="contactPerson"/>是否联络人
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td align="right" width="50%">
                    <c:choose>
                        <c:when test="${buyerEmployee.purchase eq '1'}">
                            <input type="checkbox" id="purchase" name="purchase" checked/>是否采购人
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" id="purchase" name="purchase"/>是否采购人
                        </c:otherwise>
                    </c:choose>
                </td>
                <td align="left" width="50%">
                    <c:choose>
                        <c:when test="${buyerEmployee.receivePerson eq '1'}">
                            <input type="checkbox" id="receivePerson" name="receivePerson" checked/>是否收货人
                        </c:when>
                        <c:otherwise>
                            <input type="checkbox" id="receivePerson" name="receivePerson"/>是否收货人
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <c:if test="${buyerEmployee.busCardFlg eq '1'}">
                <tr align="center">
                    <td width="50%" align="right">雇员名片照</td>
                    <td width="50%" align="left"><img src="${buyerEmployee.busCardPicPath}" height="100px" width="100px"/></td>
                </tr>
            </c:if>
            <tr>
                <td width="40%" align="right"></td>
                <td width="60%" align="left">
                    <input type="file" name="busCardPic" id = "busCardPic"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td width="60%" align="left">
                    <span id="errorMessage" style="color:#FF0000"></span>
                </td>
            </tr>
            <tr>
                <td align="right">
                </td>
                <td align="left">
                    <msk:button buttonValue="保存" buttonId="BY12130401.SAVE" buttonType="button"/>
                </td>
            </tr>
        </table>
    </form:form>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/by/BY12130401.js"></script>