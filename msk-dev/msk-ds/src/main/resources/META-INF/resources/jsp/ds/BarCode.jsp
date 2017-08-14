<%--
  Created by IntelliJ IDEA.
  User: marshall
  Date: 16/4/29
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="条形码列表" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <form action="${ctx}/BarCode/search" method="post">
        <table id="BarCode_Grid">
            <thead>
            <tr>
                <th coltype="sno" width="20px">编号</th>
                <th coltype="text" name="barcodeId" filter="true">UUID</th>
                <th coltype="text" name="brand" filter="true">品牌</th>
                <th coltype="text" name="grade" filter="true">产品等级</th>
                <th coltype="text" name="barcode" filter="true">条形码</th>
                <th coltype="text" name="readcode" filter="true">阅读码</th>
                <th coltype="action">
                    <input type="hidden" coltype="delete" title="删除" class="h-button"/>
                </th>
            </tr>
            </thead>
            <tbody>
            </tbody>
        </table>
    </form>
    <br/>
    <div>
        <table>
            <tr>
                <td>UUID</td>
                <td><input name="printBarcodeId" id="printBarcodeId" size="50"/></td>
            </tr>
            <tr>
                <td>需打印总量</td>
                <td><input name="printTotalCount" id="printTotalCount"/></td>
            </tr>
            <tr>
                <td><msk:button buttonType="button" buttonId="BarCode.PRINT" buttonValue="打印"/></td>
                <td><td><input type="hidden" name="printEnvironment" id="printEnvironment" value="${environment}"/></td></td>
            </tr>
        </table>
    </div>
    <br/>
    <br/>

    <form action="${ctx}/BarCode/save" id="BarCodeSaveForm">
        <div>
            <table>
                <tr>
                    <td>UUID</td>
                    <td><input name="barcodeId" id="barcodeId" size="50"/>&nbsp;&nbsp;PS:&nbsp;UUID若不填写,则新增一条随机UUID的数据,若填写,则新增指定UUID的数据</td>
                </tr>
                <tr>
                    <td>品牌</td>
                    <td><input name="brand" id="brand"/></td>
                </tr>
                <tr>
                    <td>产品等级</td>
                    <td><input name="grade" id="grade"/></td>
                </tr>
                <tr>
                    <td>条形码</td>
                    <td><input name="barcode" id="barcode" size="100"/></td>
                </tr>
                <tr>
                    <td>阅读码</td>
                    <td><input name="readcode" id="readcode" size="100"/></td>
                </tr>
            </table>
            <msk:button buttonType="button" buttonId="BarCode.NEW" buttonValue="新增"/>
        </div>
    </form>
</div>
<script type="text/javascript" src="${ctx}/js/ds/BarCode.js"></script>


