<%-- 
    Title:PC端财务人员计费查看
    author:gyh
    createDate:2017-2-13
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="PC端财务人员计费查看" backTitleArray="" backUrlArray=""></navigation:header>
<style type="text/css">
    /*隐藏日的显示div*/
    .ui-datepicker-calendar {
        display: none;
    }
</style>
<div class="page-content list-page">
    <form action="${ctx}/PLR170201/search" method="post" id="plr170201FormId">
        <div class="group-accordion" active="true" collapsible="false">
            <h3>
                <label>查询条件</label>
            </h3>

            <div>
                <table width="100%">
                    <thead>
                    <tr>
                        <td align="right" width="5%">统计单位:</td>
                        <td align="left">
                            <select name="selectRule" style="width: 150px;">
                                <option value="0" selected="selected">合伙人</option>
                                <option value="1">配送站</option>
                                <option value="2">买手</option>
                            </select>
                        </td>
                        <td align="right" width="5%">合伙人:</td>
                        <td align="left">
                            <select name="partnerId" style="width: 150px;"></select>
                        </td>
                        <td align="right" width="5%"><font hidden="hidden" id="terminal_td">配送站:</font></td>
                        <td align="left">
                            <select name="terminalId" style="width: 150px;" hidden="hidden">
                            </select>
                        </td>
                        <td align="right" width="5%"><font hidden="hidden" id="bs_td">买手:</font>
                        </td>
                        <td align="left">
                            <select name="bsCode" style="width: 150px;" hidden="hidden">
                            </select>
                        </td>
                    </tr>
                    <tr>
                    <tr>
                        <td align="right" width="5%">时间:</td>
                        <td align="left">
                            <input type="text" name="crtDate" id="crtDate" value="2017-03"/>
                        </td>
                        <td colspan="6" align="right">
                            <msk:button buttonValue="查询" buttonId="PLR170201.SELECT" buttonType="button"/>
                        </td>
                    </tr>
                    </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div class="group-accordion" active="true" collapsible="false">
            <h3>
                <label>进货单列表</label>
            </h3>
            <table id="plr170201_list_grid" showAddBtn="true" width="100%">
                <thead>
                <th coltype="text" width="10%" name="partnerName">合伙人</th>
                <th coltype="text" width="10%" name="terminalName">配送站名称</th>
                <th coltype="text" width="10%" name="bsName">买手名称</th>
                <th coltype="date" width="10%" name="crtDate">时间</th>
                <th coltype="text" width="10%" name="validInfo">有效进货单数</th>
                <th coltype="text" width="10%" name="invalidInfo">无效进货单数</th>
                <th coltype="text" width="10%" name="allFee">激励金额(元)</th>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
        <table>
            <tr align="left"><msk:button buttonValue="导出" buttonId="PLR170201.EXPORT" buttonType="button"/></tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/plr/PLR170201.js"></script>
