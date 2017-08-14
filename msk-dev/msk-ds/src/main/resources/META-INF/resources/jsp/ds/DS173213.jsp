<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<div class="page-header">
    <span class="page-title">
        <text>销售库存量在线汇总通知单画面</text>
    </span>
</div>
<div class="page-content list-page">
        <table>
            <tr>
                <td coltype="text">区域名称:</td>
                <td>
                    <select>
                        <option value="0">--请选择--</option>
                        <option value="01101">浦东新区</option>
                        <option value="01102">黄浦区</option>
                        <option value="01103">徐汇区</option>
                        <option value="01104">长宁区</option>
                        <option value="01105">静安区</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td coltype="text">卖家:</td>
                <td>
                    <select>
                        <option value="0">--请选择--</option>
                        <option value="1">神农客</option>
                        <option value="2">美食客</option>
                    </select>
                </td>
            </tr>
                <td>日期开始:</td>
                 <td>
                    <input type="text" name="provideDate" id="provideDate" value="<fmt:formatDate value="${msCardmanager.provideDate}" pattern="yyyy-MM-dd" />"/>
                    日期结束: <input type="text" name="provideDate2" id="provideDate2" value="<fmt:formatDate value="${msCardmanager.provideDate}" pattern="yyyy-MM-dd" />"/>
                </td>
            <tr>
                <td></td>
                <td align="right"><msk:button buttonId="DS173213.UPDATE" buttonType="button" buttonValue="出力Excel"/></td>
            </tr>
        </table>
</div>
<script type="text/javascript" src="${ctx}/js/ds/DS173213.js"></script>

