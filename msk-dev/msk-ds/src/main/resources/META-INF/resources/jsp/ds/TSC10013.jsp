<%--
    Title:发货明细
    author:cx
    createDate:2016-6-27
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>发货明细</label>
        </h3>

        <form action="${ctx}/TSC10013/search" method="post">
            <div class="page-content list-page">
                <div> 订单合同大宗食材第 车发货订单</div>
                <table class="tree dataTable no-footer">
                    <tr>
                        <td colspan="13">编号：</td>
                    </tr>
                    <tr>
                        <td colspan="13">一、发货信息</td>
                    </tr>
                    <tr>
                        <td colspan="3">加工方</td>
                        <td colspan="5"><input type="text"></td>
                        <td>发货地址</td>
                        <td colspan="4"><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="3">到货仓库</td>
                        <td colspan="5"><input type="text"></td>
                        <td>地址</td>
                        <td colspan="4"><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="2">预计发货时间</td>
                        <td colspan="2"><input type="text"></td>
                        <td colspan="2">预计到货时间</td>
                        <td colspan="2"><input type="text"></td>
                        <td>预计公里数</td>
                        <td colspan="4"><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="13">本次发货运费结算方式：
                            <input type="radio">价内结算<input type="radio">价外结算 运费单价为<input type="text"> 元/吨公里，每吨运费为 <input
                                    type="text"> 元
                        </td>
                    </tr>
                    <tr>
                        <td colspan="13">二、发货订单内容</td>
                    </tr>
                    <tr>
                        <td>序号</td>
                        <td>产品名称</td>
                        <td>产品规格</td>
                        <td>产品净重（KG/箱)</td>
                        <td>外包装规格</td>
                        <td>质量等级</td>
                        <td>产品属性码</td>
                        <td>发货箱数</td>
                        <td>发货数量（KG）</td>
                        <td>离岸价（到岸价）（元/KG）</td>
                        <td>采购金额</td>
                        <td>合计（元）</td>
                        <td>备注</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="13">三、本次支付结算</td>
                    </tr>
                    <tr>
                        <td colspan="5">本次订单付款总金额（元）</td>
                        <td colspan="8"><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="5">本次订单已付预付款（元）</td>
                        <td colspan="8"><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="5">本次订单需支付余款（元））</td>
                        <td colspan="8"><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="5">本次订单价内（外）运费（元）</td>
                        <td colspan="8"><input type="text"></td>
                    </tr>
                    <tr>
                        <td colspan="5">本次订单应付合计（元）</td>
                        <td colspan="8"><input type="text"></td>
                    </tr>
                </table>
            </div>
            <div>甲方单位　　　　　　　　　　　　　　　　　　　　　　　乙方单位　　<br/>

                甲方订单填写人　　　　　　　　　　　　　　　　　　　　乙方订单确认人<br/>

                甲方订单审核人　　　　　　　　　　　　　　　　　　　　确认日期<br/>

                发单日期
            </div>

        </form>
    </div>
    <div><msk:button buttonValue="保存" buttonId="TSC10013.SAVE" buttonType="button"/></div>
    <div id="transportId"></div>
</div>


