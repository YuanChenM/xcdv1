<%-- 
    Title:发货单新增
    author:gyh
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="入库单信息" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/TSC20021/search" method="post">
        <div>
            <table width="100%">
                <tr>
                    <td align="left" width="100">计划到货日期：</td>
                    <td align="left"><input type="text"></td>
                    <td align="left" width="120">实际到货日期：</td>
                    <td align="left"><input type="text"></td>
                </tr>
                <tr>
                    <td align="left">调入单位：</td>
                    <td align="left"><input type="text"></td>
                    <td align="left">仓库地址：</td>
                    <td align="left"><input type="text"></td>
                </tr>
                <tr>
                    <td align="left">入库方式：</td>
                    <td align="left" colspan="3">
                        <input type="radio" checked="checked"/>采购入库
                        <input type="radio"/>调拨入库
                        <input type="radio"/>样品入库
                        <input type="radio"/>退货入库
                    </td>
                </tr>
            </table>
        </div>
        <div class="group-accordion" active="true" collapsible="false">
            <h3>
                <label> 发货单选择</label>
            </h3>

            <div>
                <table id="TSC20031_list_grid" showAddBtn="true" width="100%">
                    <thead>
                    <th coltype="radio"></th>
                    <th coltype="sno" width="10%">ID</th>
                    <th coltype="text" width="10%" name="info1" filter="true">发货单编号</th>
                    <th coltype="text" width="10%" name="contractNumber">合同编号</th>
                    <th coltype="text" width="30%" name="contractName">合同名称</th>
                    <th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>
                    <th coltype="text" width="20%" name="contractDate">合同生
                        效日期</th>
                    <th coltype="select" align="center" name="status" filter="true">　　状态　　
                        <select>
                            <option value="0">未核销</option>
                            <option value="1">已核销</option>
                        </select>
                    </th>
                    <th coltype="action" width="20%">发货单明细
                        <input type="hidden" value="发货单明细" coltype="detail" title="发货单明细" class="h-button"/>
                    </th>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
    <div><msk:button buttonValue="保存" buttonId="TSC20044.SAVE" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC20031.js"></script>
