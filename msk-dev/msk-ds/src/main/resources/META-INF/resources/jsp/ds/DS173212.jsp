<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <text>总计划供应量在线变更汇总通知单画面</text>
    </span>
</div>
<div class="page-content list-page">
    <form action="${ctx}/DS173212/search" method="post">
        <table id="DS173212_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px" rowspan="3">编号</th>
                <th coltype="text" name="productName" rowspan="3">产品名称</th>
                <th coltype="text" name="productCode" rowspan="3">产品编码</th>
                <th coltype="text" name="productTypeName" rowspan="3">产品品种</th>
                <th coltype="text" name="productFeature" rowspan="3">产品特征</th>
                <th coltype="text" name="productLevel" rowspan="3">产品等级</th>
                <th coltype="text" name="productSpecifical" rowspan="3">外包装规格</th>
                <th coltype="text" name="netWeight" rowspan="3">净重</th>
                <th coltype="text" name="packageCode" rowspan="3">包装编码</th>
                <th colspan="6">当月21-25号</th>
                <th colspan="6">当月26-月末</th>
                <th colspan="6">下月1-5号</th>
                <th colspan="6">下月6-10号</th>
                <th colspan="6">下月11-15号</th>
                <th colspan="6">下月16-20号</th>
                <th colspan="6">下月21-25号</th>
                <th colspan="6">下月26-月末</th>
                <th colspan="6">合计</th>
                <th colspan="3">本期结论</th>
            </tr>
            <tr>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" colspan="2">本期总计划供应量调整卖家响应</th>
                <th coltype="text" colspan="2">本期生产量调整卖家响应</th>
                <th coltype="text" colspan="2">本期待运量调整卖家响应</th>
                <th coltype="text" rowspan="2">本期实际供应汇总量</th>
                <th coltype="text" rowspan="2">本期实际生产汇总量</th>
                <th coltype="text" rowspan="2">本期实际待运汇总量</th>
            </tr>
            <tr>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">增加数量</th>
                <th coltype="text">减少数量</th>
                <th coltype="text">继续生产暂停调运量</th>
                <th coltype="text">提前调运数量</th>
                <th coltype="text">增加汇总量</th>
                <th coltype="text">减少汇总量</th>
                <th coltype="text">增加汇总量</th>
                <th coltype="text">减少汇总量</th>
                <th coltype="text">继续生产暂停调运汇总量</th>
                <th coltype="text">提前调运汇总量</th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173212.js"></script>

