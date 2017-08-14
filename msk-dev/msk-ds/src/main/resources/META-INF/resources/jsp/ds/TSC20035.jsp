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
<div class="page-content detail-page" id="TSC20035page">
    <form action="${ctx}/TSC20035/search" method="post">
        <table id="TSC20035_grid" showAddBtn="true" width="auto">
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
            <td>质量标准：</td>
            <td><input type="text"/></td>
            <td>规格：</td>
            <td><input type="text"/></td>
            <td>质量标准：</td>
            <td><input type="text"/></td>
            </td>
            <tr>
                <td>规格：</td>
                <td><input type="text"/></td>
                <td>胶带颜色：</td>
                <td><input type="text"/></td>
                <td>标签内容(准入产品标签)：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>质量标准：</td>
                <td><input type="text"/></td>
                <td>规格：</td>
                <td><input type="text"/></td>
                <td>质量标准：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>规格：</td>
                <td><input type="text"/></td>
                <td>胶带颜色：</td>
                <td><input type="text"/></td>
                <td>标签内容：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>纸箱：</td>
                <td><input type="text"/></td>
                <td>内袋：</td>
                <td><input type="text"/></td>
                <td>胶带：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>纸箱大标签：</td>
                <td><input type="text"/></td>
                <td>纸箱小标签：</td>
                <td><input type="text"/></td>
                <td>内袋标签：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr>
                <td>包材提供方式：</td>
                <td><input type="text"/></td>
                <td>包材审核方式：</td>
                <td><input type="text"/></td>
                <td>包材结算方式：</td>
                <td><input type="text"/></td>
                </td>
            </tr>
            <tr align="center">
                <td align="center" id="saveId"><msk:button buttonValue="保存" buttonId="TSC20035.SAVE" buttonType="button"/><msk:button buttonValue="取消" buttonId="TSC20035.BACK" buttonType="button"/></td>
            </tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC20035.js"></script>
