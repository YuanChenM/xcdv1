<%--
    Title:付款计划
    author:cx
    createDate:2016-6-28
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>

<div class="group-accordion" collapsible="false" active="false">
    <h3>
        <label>付款申请表</label>
    </h3>

    <div>

        编号：
        <table class="tree dataTable no-footer" showAddBtn="true" id="TSC10014Table">
            <tr>
                <td colspan="3">请款项目名称：</td>
            </tr>
            <tr>
                <td rowspan="11">付款说明</td>
            </tr>
            <tr>
                <td colspan="2">一、本次请款情况</td>
            </tr>
            <tr>
                <td>1、合同总金额：</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>2、付款约定：</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td colspan="2">3、本次申请金额 <input type="text"> 元</td>
            </tr>

            <tr>
                <td colspan="2">二、付款主体</td>
            </tr>
            <tr>
                <td>付款单位1：</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>支付金额：</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>付款单位2：</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>支付金额：</td>
                <td><input type="text"></td>
            </tr>

            <tr>
                <td colspan="2">三、本次支付完成后，累计支付 元，尚余金额 元。</td>
            </tr>
            <tr>
                <td rowspan="8">附件</td>
            </tr>
            <tr>
                <td colspan="2"> 一、首次付款提交附件：</td>
            </tr>
            <tr>
                <td>1、订单合同</td>
                <td> <input type="file"></td>
            </tr>
            <tr>
                <td colspan="2"> 二、非首次付款提交附件：</td>
            </tr>
            <tr>
                <td>1、发货订单</td>
                <td> <input type="file"></td>
            </tr>
            <tr>
                <td>2、运输订单</td>
                <td> <input type="file"></td>
            </tr>
            <tr>
                <td colspan="2">三、余款结算提交附件：</td>
            </tr>
            <tr>
                <td>1、核销单</td>
                <td> <input type="file"></td>
            </tr>
        </table>

        <div>
            请款发起人
            <br/>
            （签字）
            <br/>
            日期：

        </div>
    </div>
</div>

<%--<script src="${ctx}/js/ds/TSC10015.js"></script>--%>

