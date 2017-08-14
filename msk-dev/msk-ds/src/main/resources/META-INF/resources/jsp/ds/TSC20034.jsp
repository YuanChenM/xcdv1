<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:正式上线修改添加
    author:pxg
    createDate:2016-02-23
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<style type="text/css">
    #saveId{
        position: absolute;
        left: 400px;
        }
</style>
<div class="page-content detail-page" id="TSC20034page">
    <form action="${ctx}/TSC20034/search" method="post">
        <table id="TSC20034_grid" showAddBtn="true" width="auto">
            <tr>
                <td>
                    一级分类：
                </td>
                <td>
                    <select style="width:137px;">
                        <option>鸡产品</option>
                        <option>鸭产品</option>
                        <option>猪产品</option>
                    </select>
                </td>
                <td>
                    二级分类：
                </td>
                <td>
                    <select style="width:137px;">
                        <option>白条鸡</option>
                        <option>分割品</option>
                        <option>副产品</option>
                    </select>
                </td>
                <td>
                    品种：
                </td>
                <td>
                    <select style="width:137px;">
                        <option>白条肉鸡</option>
                        <option>三黄土鸡</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    特征：
                </td>
                <td>
                    <select style="width:137px;">
                        <option>1kg/只(10只)</option>
                        <option>0.83kg/只(12只)</option>
                    </select>
                </td>
                <td>
                    净重：
                </td>
                <td>
                    <select style="width:137px;">
                        <option>10kg</option>
                        <option>20kg</option>
                    </select>
                </td>
                <td>
                    包装：
                </td>
                <td>
                    <select style="width:137px;">
                        <option>10kg*1</option>
                        <option>10kg*5</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>标准市场销售名：</td>
                <td><input type="text"/></td>
                <td>学名：</td>
                <td><input type="text"/></td>
                <td>俗名：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>产品标签码：</td>
                <td><input type="text"/></td>
                <td>产品等级：</td>
                <td>
                    <select style="width:137px;">
                        <option>A1</option>
                        <option>A2</option>
                        <option>A3</option>
                    </select>
                </td>
                <td>产品质量标准：</td>
                <td>
                    <textarea cols="18" rows="4"></textarea>
                </td>
            </tr>
            <tr>
                <td>数量(吨)：</td>
                <td><input type="text"/></td>
                <td>箱数：</td>
                <td><input type="text"/></td>
                <td>不含包装离岸价：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>包装成本：</td>
                <td><input type="text"/></td>
                <td>含包装离岸价：</td>
                <td><input type="text"/></td>
                <td>干线运费：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>含包装到岸价：</td>
                <td><input type="text"/></td>
                <td>本次结算标准价(元/kg)：</td>
                <td><input type="text"/></td>
                <td>货值(元)：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>首付比例(%)：</td>
                <td><input type="text"/></td>
                <td>付款额(元)：</td>
                <td><input type="text"/></td>
                <td>备注：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr align="center">
                <td align="center" id="saveId"><msk:button buttonValue="保存" buttonId="TSC20034.SAVE" buttonType="button"/><msk:button buttonValue="取消" buttonId="TSC20034.BACK" buttonType="button"/></td>
            </tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC20034.js"></script>
