<%--
  Created by IntelliJ IDEA.
  User: ren_qiang
  Date: 2016/10/27
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="产品楼层设置" backTitleArray="" backUrlArray=""></navigation:header>

<div class="page-content list-page">

    <form action="${ctx}/PD144103/search" method="post" id="pd144103FormId">
        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>楼层设置</label>
            </h3>

            <table width="100%">
                <tr>
                    <td width="5%" align="right">物流区</td>
                    <td width="10%" align="left">
                        <select class="_sel" name="lgcsCode" id="wl_select">
                            <c:forEach items="${lgcsAreaList}" var="lgcsAreaBean" varStatus="i">
                                <option value="${lgcsAreaBean.lgcsAreaCode}">${lgcsAreaBean.lgcsAreaName}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td width="10%" align="right">楼层名称</td>
                    <td width="10%" align="left">
                        <input id="FloorName" name="filterMap[floorName]" maxlength="20"/>
                    </td>

                    <td width="50px">
                        <msk:button buttonId="PD144103.SEARCH" buttonType="button" buttonValue="查询"></msk:button>
                    </td>
                </tr>

            </table>

        </div>

        <div class="group-accordion" collapsible="true" active="true">
            <h3>
                <label>楼层信息</label>
            </h3>
            <div>
                <table id="PD144103_list_grid" width="100%">
                    <thead>
                    <tr>
                        <th coltype="sno" width="20px">编号</th>
                        <th coltype="text" name="lgcsName">物流区</th>
                        <th coltype="text" name="floorName">名称</th>
                        <th coltype="text" name="pdNum">产品数量</th>
                        <th coltype="text" name="showColor">悬停色彩</th>
                        <th coltype="text" filterType="number" name="sort" cellEdit="true" edit="true" maxlength="2"
                            width="10%" height="10%">排序
                        </th>
                        <th coltype="datetime" name="crtTime">创建时间</th>
                        <th coltype="action">操作
                            <msk:button buttonValue="编辑" buttonType="hidden" coltype="edit" class="h-button"
                                        buttonId="PD144103.EDIT"/>
                            <msk:button buttonValue="删除" buttonType="hidden" coltype="delete" class="h-button"
                                        buttonId="PD144103.DELETE"/>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <br/>
                <msk:button buttonValue="新增" buttonId="PD144103.NEW"   buttonType="button"/>
                <msk:button buttonValue="保存" buttonId="PD144103.SAVE"  buttonType="button"/>
            </div>
        </div>
    </form>
</div>

<script src="${ctx}/static/pd/js/PD144103.js"></script>
