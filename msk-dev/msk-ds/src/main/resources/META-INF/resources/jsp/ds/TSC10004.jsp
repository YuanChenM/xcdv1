<%-- 
    Title:卖家列表
    author:gyh
    createDate:2016-1-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<navigation:header title="合同管理" backTitleArray="" backUrlArray=""></navigation:header>
<style type="text/css">
    .ui-selectmenu-text{
        height: 10px;
    }
</style>
<div class="page-content list-page">
	<form action="${ctx}/TSC10004/search" method="post">
		<table id="TSC10004_list_grid" showAddBtn="true" width="100%">
			<thead>
				<tr>
					<th coltype="sno" width="10%">ID</th>
					<th coltype="text" width="20%" name="contractNumber" filter="true">合同编号</th>
					<th coltype="text" width="30%" name="contractName" filter="true">合同名称</th>
                    <th coltype="text" width="30%" name="manufacture" filter="true">生产商</th>
                    <th coltype="text" width="30%" name="contractDate" filter="true">合同生效日期</th>
                    <th coltype="select" width="50%" name="status" filter="true">状态
                        <select style="height:20px;" size="2">
                            <option value="0">未核销</option>
                            <option value="1">已核销</option>
                        </select>
                    </th>
                    <th coltype="action" width="20%">详细
                        <input type="hidden" value="详细" coltype="detail" title="详细"  class="h-button" />
                    </th>
					<th coltype="action" width="20%">状态
                        <input type="hidden" coltype="check" title="状态"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">删除
                        <input type="hidden" coltype="delete" title="删除"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">生产计划
                        <input type="hidden" coltype="search" title="生产计划"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">待运期计划
                        <input type="hidden" coltype="search" title="待运期计划"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">发货计划
                        <input type="hidden" coltype="search" title="发货计划"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">发货单
                        <input type="hidden" coltype="search" title="发货单"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">入库单
                        <input type="hidden" coltype="search" title="入库单"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">发货差异单
                        <input type="hidden" coltype="search" title="发货单差异单"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">结算
                        <input type="hidden" coltype="search" title="结算"  class="h-button" />
                    </th>
                    <th coltype="action" width="20%">发票
                        <input type="hidden" coltype="search" title="发票"  class="h-button" />
                    </th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
        <table><tr align="left"><msk:button buttonValue="新建" buttonId="TSC10004.NEW" buttonType="button"/>
            <msk:button buttonValue="模板下载" buttonName="TSC10004.ONENAME" buttonId="TSC10004.DOWLOAD" buttonType="button"/></tr></table>
	</form>
</div>
<script src="${ctx}/js/ds/TSC10004.js"></script>
