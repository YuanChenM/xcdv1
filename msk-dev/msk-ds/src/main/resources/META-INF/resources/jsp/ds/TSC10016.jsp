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
        <label>订单运输确认单</label>
    </h3>

    <div>

        <table class="tree dataTable no-footer" showAddBtn="true" id="TSC10014Table">
            <tr>
                <td colspan="3">一、托运人信息</td>
            </tr>
            <tr>
                <td rowspan="3">托运人</td>
            </tr>
            <tr>
                <td>公司名称</td>
                <td colspan="2">　　　　<input type="text"></td>
            </tr>
            <tr>
                <td>托运管理人</td>
                <td>联系人：<input type="text"> 联系电话：<input type="text"></td>
            </tr>
            <tr>
                <td colspan="4">二、运输人信息</td>
            </tr>
            <tr>
                <td rowspan="5">运输单位信息</td>
            </tr>
            <tr>
                <td>公司名称</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>地址</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>性质和规模</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>联系人及电话</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td rowspan="6">驾驶员信息</td>
            </tr>
            <tr>
                <td>姓名</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>家庭住址</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>驾驶证号</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td rowspan="17">车辆信息</td>
            </tr>
            <tr>
                <td>车牌号</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>车辆品牌</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>发动机品牌</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>发动机类型</td>
                <td colspan="2"><input type="radio" name="1">进口
                    <input type="radio" name="1">合资
                </td>
            </tr>
            <tr>
                <td>冷机品牌</td>
                <td colspan="2"><input type="text"></td>
            </tr>

            <tr>
                <td>冷机类型</td>
                <td colspan="2"><input type="radio" name="1">独立冷机
                    <input type="radio" name="1">非独立冷机
                </td>
            </tr>

            <tr>
                <td>冷机功率</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>车厢外形尺寸（长*宽*高）</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>核载重量（吨）</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>实际载重量（吨）</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td rowspan="3">车速范围（km/h)</td>
            </tr>
            <tr>
                <td>正常车速　　 <input type="text"></td>
            </tr>
            <tr>
                <td>最高车速 　　<input type="text"></td>
            </tr>
            <tr>
                <td rowspan="2">油耗</td>
            </tr>
            <tr>
                <td>空车标准油耗 <input type="text"></td>
            </tr>
            <tr>
                <td>满载标准油耗</td>
                <td>　　　 　　　<input type="text"></td>
            </tr>
            <tr>
                <td colspan="4">三、收货单位信息</td>
            </tr>

            <tr>
                <td rowspan="4">收货信息</td>
            </tr>
            <tr>
                <td>收货地址</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>收货管理人</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>运输监控人</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td colspan="4">四、运输指令单</td>
            </tr>
            <tr>
                <td rowspan="5">装货管理</td>
            </tr>
            <tr>
                <td>装货时间</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>供应商装货管理人</td>
                <td colspan="2"><input type="text"></td>
            </tr>
            <tr>
                <td>装货要求</td>
                <td colspan="2">包装破损、脏污不予接收，如接收由运输人负责承担责任</td>
            </tr>
            <tr>
                <td>随车资料</td>
                <td colspan="2">首次发货：
                    <br/>1、盖章三证　　<input type="file">
                    <br/>2、官方检测报告<input type="file">
                    <br/>3、动检证　　　<input type="file">
                    <br/>4、出货清单　　<input type="file">
                    <br/>非首次发货：
                    <br/>1、官方检测报告<input type="file">
                    <br/>2、动检证　　　<input type="file">
                    <br/>3、出货清单　　<input type="file"></td>
            </tr>
            <tr>
                <td rowspan="3">行车时间及路线图</td>
            </tr>
            <tr>
                <td>行车时间</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>地图线路</td>
                <td><input type="file"></td>
            </tr>
            <tr>
                <td >卸货指引</td>
                <td colspan="2">1、到底目的地前5小时，与收货管理人联系，确定到达时间及收货时间；
                   <br/> 2、到达指定仓库后需先进行车厢温度和产品中心温度检测，检测完成司机签字后才允许卸货；
                   <br/> 3、卸车等待时间超过半小时，需向运输监控人投诉；</td>
            </tr>
        </table>

        <div>
            甲方发起人签字：  　　　　　　　　　　　　　　托运管理人签字：　　　　　　　　　　　　　　运输人签字：
         <br/>   日期：　　　　　　　　　　　　　　　　　　　日期：　　　　　　　　　　　　　　　　　　　日期：
        </div>
    </div>
</div>

<%--<script src="${ctx}/js/ds/TSC10015.js"></script>--%>

