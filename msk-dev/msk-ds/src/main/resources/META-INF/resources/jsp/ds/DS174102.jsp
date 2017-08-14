<%--
  Created by IntelliJ IDEA.
  User: yuan_chen
  Date: 16/1/13
  Time: 上午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="产品批次编码生成" backTitleArray="批次产品列表" backUrlArray="${ctx}/DS174101/init"></navigation:header>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>卖家产品信息</label>
        </h3>
        <form action="${ctx}/DS174102/save" id="DS174102Form" metdod="post">
            <div>
                <input type="hidden" name="lotId" value="${lotId}"/>
                <input type="hidden" name="lotCode" value="${lotCode}"/>
            <table CellSpacing=10 style="width: 100%">
                <tr>
                    <td width="10%" align="right">卖家名称</td>
                    <td width="15%" align="left">${dsSlPdLot.slName}</td>
                    <td width="10%" align="right">批次码</td>
                    <td width="15%" align="left">${dsSlPdLot.dateCode}</td>
                    <td width="10%" align="right">类别</td>
                    <td width="15%" align="left">${dsSlPdLot.classesName}</td>
                    <td width="10%" align="right">品种</td>
                    <td width="15%" align="left">${dsSlPdLot.breedName}</td>
                </tr>
                <tr>
                    <td align="right">销售区域</td>
                    <td align="left">${dsSlPdLot.lgcsName}</td>
                    <td align="right">包装规格</td>
                    <td align="left">${dsSlPdLot.pkgSpec}</td>
                    <td align="right">特征</td>
                    <td align="left">${dsSlPdLot.featureName}</td>
                    <td align="right">等级</td>
                    <td align="left">${dsSlPdLot.gradeName}</td>
                </tr>
                <tr>
                    <td align="right">加工方式</td>
                    <td align="left">${dsSlPdLot.processingWay}</td>
                    <td align="right">包装方式</td>
                    <td align="left">${dsSlPdLot.pkgWay}</td>
                    <td align="right">品牌</td>
                    <td align="left">${dsSlPdLot.brand}</td>
                    <td align="right">厂家</td>
                    <td align="left">${dsSlPdLot.manufacturer}</td>
                </tr>
                <tr>
                    <td align="right">储存方式</td>
                    <td align="left">${dsSlPdLot.storageWay}</td>
                    <td align="right">净重</td>
                    <td align="left">${dsSlPdLot.netweight}</td>
                    <td align="right">产地</td>
                    <td align="left">${dsSlPdLot.prodcingarea}</td>
                    <td align="right"></td>
                    <td align="left"></td>
                </tr>
                <tr>
                    <td align="right">生产时间</td>
                    <td align="left">${dsSlPdLot.pdTime}</td>
                    <td align="right">保质期</td>
                    <td align="left">${dsSlPdLot.shelfLife}</td>
                    <td align="right"></td>
                    <td align="left"></td>
                    <td align="right"></td>
                    <td align="left"></td>
                </tr>
                <tr>
                    <td align="right">生成数量</td>
                    <td align="left"><input id="lotNum" name="lotNum" value="1"/></td>
                    <td align="right">
                        <msk:button buttonId="DS174102.SAVE" buttonType="button" buttonValue="生成"/>
                    </td>
                    <td align="left"></td>
                    <td align="right"></td>
                    <td align="left"></td>
                    <td align="right"></td>
                    <td align="left"></td>
                </tr>
            </table>
            </div>
            <div>
                <msk:button buttonId="DS174102.BACK" buttonType="button" buttonValue="返回"/>
            </div>
        </form>
    </div>
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>批次编码列表</label>
        </h3>
        <table id="DS174102_Grid" action="${ctx}/DS174102/search/${lotId}">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="serialId" filter=true>流水号</th>
                <th coltype="text" name="lotCode" filter=true>批次编码</th>
                <th coltype="action">
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS174102.js"></script>
