<%--
  Created by IntelliJ IDEA.
  User: jiangnan
  Date: 16/1/5
  Time: 上午9:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <label>会员卡列表</label>
    </span>
</div>
<div class="page-content list-page">
<form id="MS112101Form" action="${ctx}/MS112101/search" method="post">
    <div class="page-content list-page" collapsible="false" active="false">
        <div class="group-accordion" collapsible="false" active="false">

            <h3>
                <label>查询条件</label>
            </h3>
            <table width="100%">
                <tr>
                    <td width="10%" align="right">会员卡编码</td>
                    <td align="left" width="10%" colspan="2">
                        <input type="text" id="msCardno" name="filterMap['msCardno']"/>
                    </td>
                    <td width="10%" align="right">买家编码</td>
                    <td align="left" width="10%" colspan="2">
                        <input type="text" id="buyerCode" name="filterMap['buyerCode']"/>
                    </td>
                    <td width="10%" align="right">买家名称</td>
                    <td align="left" width="10%" colspan="2">
                        <input type="text" id="buyerName" name="filterMap['buyerName']"/>
                    </td>
                </tr>
                <tr>
                    <td width="10%" align="right">发放日期</td>
                    <td align="left" width="10%" colspan="5">
                        <input type="text" name="filterMap['startTime']" id="startTime"/>
                        &emsp;～&emsp;
                        <input type="text" name="filterMap['endTime']" id="endTime"/>
                    </td>
                    <td width="10%" align="right">是否已激活</td>
                    <td align="left" width="10%">
                        <select name="filterMap['isActivate']" id="isActivate">
                            <option value="">--请选择--</option>
                            <option value="0">是</option>
                            <option value="1">否</option>
                        </select>
                    </td>
                    <td width="10%" align="right">是否已发放</td>
                    <td align="left" width="10%">
                        <select name="filterMap['isProvide']" id="isProvide">
                            <option value="">--请选择--</option>
                            <option value="0">未发放</option>
                            <option value="1">发放锁定中</option>
                            <option value="2">已发放</option>
                            <option value="3">挂失</option>
                            <option value="4">废止</option>
                        </select>
                    </td>
                    <td align="right">
                        <msk:button buttonValue="查询" buttonId="MS112101.SEARCH" buttonType="button"/>
                    </td>
                </tr>
            </table>
        </div>
        <div>
        <table id="MS112101DataGrid">
            <thead>
            <tr>
                <th coltype="text" width="15%" name="msCardno">会员卡编码</th>
                <th coltype="text" width="15%" name="buyerCode">买家编码</th>
                <th coltype="text" width="15%" name="buyerName">买家名称</th>
                <th coltype="text" width="15%" name="isActivate">是否已激活</th>
                <th coltype="text" width="15%" name="isProvide">是否已发放</th>
                <th coltype="text" width="15%" name="provideDate">发放日期</th>
                <th coltype="action" width="15%">查看详情
                    <input type="hidden" id="MS112101.SEARCH" coltype="check" title="会员卡详细信息" class="h-button"/>
                    <input type="hidden" id="MS112101.Edit"   coltype="edit"  title="会员卡信息编辑" class="h-button"/>
                    <input type="hidden" id="MS112101.UpdatePW"   coltype="detail"  title="会员密码修改" class="h-button"/>
                    <input type="hidden" id="MS112101.PrintBtn" coltype="print" title="打印" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        </div>
    </div>
</form>
<msk:button buttonValue="上传会员卡" buttonId="MS112101.UPLOAD" buttonType="button"/>
</div>
<script type="text/javascript" src="${ctx}/js/ms/MS112101.js"></script>