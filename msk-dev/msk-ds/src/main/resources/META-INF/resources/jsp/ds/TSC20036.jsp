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
<div class="page-content detail-page" id="TSC20036page">
    <form action="${ctx}/TSC20036/search" method="post">
        <table id="TSC20036_grid" showAddBtn="true" width="auto">
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
                <td>到货日期：</td>
                <td><input type="text"/></td>
                <td>数量(吨)：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>箱数：</td>
                <td><input type="text"/></td>
                <td>到货日期：</td>
                <td><input type="text"/></td>
                </td>
                <td>数量(吨)：</td>
                <td><input type="text"/></td>
            </tr>
            <tr>
                <td>箱数：</td>
                <td><input type="text"/></td>
                <td>备注：</td>
                <td><input type="text"/></td>
            </tr>
            <tr align="center">
                <td align="center" id="saveId"><msk:button buttonValue="保存" buttonId="TSC20036.SAVE" buttonType="button"/><msk:button buttonValue="取消" buttonId="TSC20036.BACK" buttonType="button"/></td>
            </tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC20036.js"></script>
