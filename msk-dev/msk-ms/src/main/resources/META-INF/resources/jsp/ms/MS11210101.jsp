<%--
  @author fjm
  @MS11210101.jsp_会员卡信息修改页面
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="page-content detail-page" id="MS11210101_id">
	<form:form action="${ctx}/MS11210101/update" id="MS11210101Form"
		metdod="post" commandName="msCardmanager" modelAttribute="msCardmanager">
		<table id="MS11210101DataGrid">
		       <tr>
                    <td align="right">会员卡编码</td>
                    <td align="left" colspan="2">
                        <input type="text" id="msCardno" name="msCardno" value="${msCardmanager.msCardno}"  readonly/>
                    </td>
                    <td align="right">发放日期</td>
                    <td align="left" colspan="5">
                    <input type="text" name="provideDate" id="provideDate" value="<fmt:formatDate value="${msCardmanager.provideDate}" pattern="yyyy-MM-dd" />"/>
                        <span id="proDate"></span>
                    </td>
                </tr>
                <tr>
                    <td align="right">买家编码</td>
                    <td align="left" colspan="2">
                        <input type="text" id="buyerCode" name="buyerCode" value="${msCardmanager.buyerCode}"/>
                    </td>
                    <td align="right">买家名称</td>
                    <td align="left" colspan="5">
                        <input type="text" id="buyerName" name="buyerName" value="${msCardmanager.buyerName}"/>
                    </td>
                 </tr>
                 <tr>
                   <td align="right">采购批次</td>
                   <td align="left" colspan="2">
                        <input type="text" id="purchaseLot" name="purchaseLot" value="${msCardmanager.purchaseLot}"/>
                    </td>
                  
                    <c:if test="${msCardmanager.isProvide =='0'}">
                    <td align="right">是否已发放</td>
                    <td align="left">
                        <select name="isProvide" id="isProvide">
                            <option value="0" <c:if test="${'0' eq msCardmanager.isProvide}">selected</c:if>>未发放</option>
                            <option value="1">发放锁定中</option>
                        </select>
                    </td>
                    </c:if>
                    <c:if test="${msCardmanager.isProvide =='1'}">
                    <td align="right">是否已发放</td>
                    <td align="left">
                        <select name="isProvide" id="isProvide">
                            <option value="1" <c:if test="${'1' eq msCardmanager.isProvide}">selected</c:if>>发放锁定中</option>
                            <option value="0">未发放</option>
                            <option value="2">已发放</option>
                        </select>
                    </td>
                    </c:if>
                    <c:if test="${msCardmanager.isProvide =='2'}">
                    <td align="right">是否已发放</td>
                    <td align="left">
                        <select name="isProvide" id="isProvide">
                            <option value="2" <c:if test="${'2' eq msCardmanager.isProvide}">selected</c:if>>已发放</option>
                            <option value="3">挂失</option>
                            <option value="4">废止</option>
                        </select>
                    </td>
                    </c:if>
                    <c:if test="${msCardmanager.isProvide =='3'}">
                    <td align="right">是否已发放</td>
                    <td align="left">
                        <select name="isProvide" id="isProvide">
                            <option value="3" <c:if test="${'3' eq msCardmanager.isProvide}">selected</c:if>>挂失</option>
                        </select>
                    </td>
                    </c:if>
                    <c:if test="${msCardmanager.isProvide =='4'}">
                    <td align="right">是否已发放</td>
                    <td align="left">
                        <select name="isProvide" id="isProvide">
                            <option value="4" <c:if test="${'4' eq msCardmanager.isProvide}">selected</c:if>>废止</option>
                        </select>
                    </td>
                    </c:if> 
                </tr>
                <tr>                
                    <td align="right" colspan="3">                  
                        <msk:button buttonValue="保存" buttonId="MS11210101.SAVE" buttonType="button"/>
                    </td> 
                    <td align="left" colspan="3">                  
                        <msk:button buttonValue="取消" buttonId="MS11210101.BACK" buttonType="button"/>
                    </td>
                </tr>
	
		</table>
	</form:form>
</div>

<script src="${ctx}/js/ms/MS11210101.js"></script>



