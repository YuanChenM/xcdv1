<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ren_qiang
  Date: 2016/10/28
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<script src="${ctx}/static/pd/js/jquery.minicolors.js"></script>
<link rel="stylesheet" href="${ctx}/static/pd/js/jquery.minicolors.css">
<style>
  ._sel{
    width: 135px;
  }

</style>
<navigation:header title="产品楼层新增页面" backTitleArray="产品楼层设置" backUrlArray="${ctx}/PD144103/init"></navigation:header>
<div class="page-content list-page">

  <div class="group-accordion" collapsible="false" active="true" >
    <h3>
      <label>产品楼层设置</label>
    </h3>
    <table width="100%">

      <tr>
        <td align="right"><span style="color:red">*</span>楼层名称(20个字符)：</td>
        <td align="left">
          <input type="hidden" id="isEdit" name="isEdit" value="${isEdit}"/>
          <input type="hidden" id="id" name="id" value="${pdAppFloor.id}"/>
          <input type="hidden" id="originColor" name="originColor" value="${pdAppFloor.color}"/>
          <input id="floorName" name="floorName" maxlength="20" <c:if test="${1==isEdit}"> disabled="disabled" </c:if> value="${pdAppFloor.floorName}" />
        </td>
        <td align="right"><span style="color:red">*</span>悬停色彩：</td>
        <td align="left">
          <input type="text" id="color" name="color" readonly value="${pdAppFloor.color}" class="form-control demo" data-control="hue">
        </td>
        <td align="right"><span style="color:red">*</span>物流区：</td>
        <td align="left">
          <%--<c:if test="${1 ==isEdit}">--%>
          <select style="width:120px;<c:if test="${1==isEdit}">display: none </c:if>" id="wl_select">
            <option value="">==请选择==</option>
            <c:forEach items="${lgcsList}" var="lgcsAreaBean" varStatus="i">
              <c:if test="${lgcsAreaBean.lgcsAreaCode == pdAppFloor.lgcsCode }">
                <option value="${lgcsAreaBean.lgcsAreaCode}" selected="selected">${lgcsAreaBean.lgcsAreaName}</option>
              </c:if>
              <c:if test="${lgcsAreaBean.lgcsAreaCode != pdAppFloor.lgcsCode }">
                <option value="${lgcsAreaBean.lgcsAreaCode}">${lgcsAreaBean.lgcsAreaName}</option>
              </c:if>
            </c:forEach>
          </select>
            <label id="lgcsName" style="width:120px;<c:if test="${2==isEdit}">display: none </c:if>">${pdAppFloor.lgcsName}</label>
          <input type="hidden" id="lgcsCode" name="lgcsCode" value="${pdAppFloor.lgcsCode}"/>
        </td>
        <td>
          <msk:button buttonId="PD144104.SAVE" buttonType="button" buttonValue="保存" ></msk:button>
        </td>
      </tr>
    </table>
  </div>
  <form action="${ctx}/PD144104/search" method="post" id="pd144104FormId1">
    <input type="hidden" id="floorId" name="floorId" value="${floorId}"/>
    <input type="hidden" id="addFloorId" name="lgcsCode" value="${lgcsCode}"/>
    <div class="group-accordion" collapsible="false" active="true" >
      <h3>
        <label>楼层产品信息</label>
      </h3>
      <div>
        <table id="PD144104_list_grid" showAddBtn="true" width="100%" >
          <thead>
          <tr>
            <th coltype="sno">编号</th>
            <th coltype="text" name="pdCode" >产品编码</th>
            <th coltype="text"  name="pdName">产品名称</th>
            <th coltype="action">操作
              <msk:button buttonValue="删除" buttonType="hidden" coltype="delete" class="h-button" buttonId="PD144104.DELETE"/>
            </th>
          </tr>
          </thead>
          <tbody>
          </tbody>
        </table>
        <br/>
        <msk:button buttonId="PD144104.NEW" buttonType="button" buttonValue="新增产品"></msk:button></div>
    </div>
  </form>
</div>

<script src="${ctx}/static/pd/js/PD144104.js"></script>
