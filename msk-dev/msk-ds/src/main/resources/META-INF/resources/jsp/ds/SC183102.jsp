<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp"%>
<navigation:header title="卖家产品计划调整历史一览" backTitleArray=" " backUrlArray=" "></navigation:header>
<div class="page-content list-page">

    <form action="${ctx}/SC183102/search" method="post">
        <table id="SC183102_Grid">
            <thead>
            <tr>
                <th coltype="text" name="suppDsId" filter="true" >供应商分销流水号</th>
                <th coltype="text" name="planFlowId" filter="true" >库存实际流水号</th>
                <th coltype="text" name="distMonth" filter="true">分销月度</th>
                <th coltype="text" name="lgcsName" filter="true">物流区域</th>
                <th coltype="text" name="suppName" filter="true">供应商名称</th>
                <%--<th coltype="text" name="pdStockType" filter="true">产品库存类型</th>--%>
                <th coltype="select" name="pdStockType" filter="true">产品库存类型
                    <select>
                        <option value="1">生产期产品</option>
                        <option value="2">待运库产品</option>
                        <option value="3">在途产品</option>
                        <option value="4">入销售库产品</option>
                    </select>
                </th>


                <%--<th coltype="text" name="halfCode" filter="true">半旬码</th>--%>
                <th coltype="select" name="halfCode" filter="true">半旬码
                    <select>
                        <option value="1">21-25日</option>
                        <option value="2">26-N日</option>
                        <option value="3">1-5日</option>
                        <option value="4">6-10日</option>
                        <option value="5">11-15日</option>
                        <option value="6">16-20日</option>
                    </select>
                </th>

                <th coltype="text"  name="classesCode" filter="true">产品类别</th>
                <th coltype="text"  name="breedCode" filter="true">产品品种</th>
                <th coltype="text"  name="featureCode" filter="true">产品特征</th>
                <th coltype="text"  name="gradeCode" filter="true">产品等级</th>

                <th coltype="text"  name="outSpec" filter="true">外包装规格</th>
                <th coltype="text"  name="outNw" filter="true">外包装净重</th>
                <th coltype="text"  name="pdCode" filter="true">产品编码</th>
                <th coltype="text"  name="normsCode" filter="true">包装编码</th>

                <th coltype="text"  name="adjustDate" filter="true">录入日期</th>
                <th coltype="text"  name="oldPlanNum" filter="true">原实际数量</th>
                <th coltype="text"  name="newPlanNum" filter="true">新实际数量</th>

                <th coltype="action">
                    <input type="button" id="deleteBtn" hidden="true" title="删除" coltype="delete" class="h-button"/>
                    <input type="button" id="editBtn" hidden="true" title="编辑" coltype="edit" class="h-button" />
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
        <%-- <table><tr align="left"><msk:button buttonValue="新建" buttonId="SC183102.NEW" buttonType="button" url="${ctx}/SC182102/init"/></tr></table>--%>
    </form>
</div>

<script src="${ctx}/js/ds/SC183102.js"></script>
