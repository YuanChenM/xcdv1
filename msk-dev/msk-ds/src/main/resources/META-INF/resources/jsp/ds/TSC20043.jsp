<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="navigation" uri="/msk-navigation" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="标签打印" backTitleArray="入库单一览,入库单详细" backUrlArray="${ctx}/TSC20041/init,${ctx}/TSC20041/initDetail"></navigation:header>
<div class="page-content list-page">
    <div class="group-accordion" collapsible="" active="false">
        <h3>
            <label>打印数据</label>
        </h3>
        <form:form action="${ctx}/TSC20043/init" id="TSC20043Form" method="post">
            <table width="100%">
                <tbody>
                <tr>
                    <td align="right">卖家名称：</td>
                    <td align="left">山东荣达畜禽销售部</td>
                </tr>
                <tr>
                    <td align="right">一级分类：</td>
                    <td align="left">鸭产品</td>
                    <td align="right">二级分类：</td>
                    <td align="left">分割品</td>
                    <td align="right">品种：</td>
                    <td align="left">带皮鸭胸</td>
                    <td  align="right">特征：</td><td>220-240g</td>
                    <td  align="right">等级：</td>
                    <td align="left">
                        <select style="width: 138px;" id="groupCode" name="groupCode">
                            <option value="">---请选择---</option>
                            <option value="1">A1</option>
                            <option value="2">A2</option>
                            <option value="3">A3</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">净重：</td>
                    <td align="left">10kg</td>
                    <td align="right">包装规格：</td>
                    <td align="left">1kg/只</td>
                    <td align="right">生产商：</td>
                    <td align="left">山东荣达农业发展有限公司</td>
                    <td align="right">入库平台：</td>
                    <td align="left">神农客</td>
                </tr>
                <tr>
                    <td align="right">货号：</td>
                    <td align="left">
                        <select style="width: 138px;" name="slPdArtno" id="slPdArtno">
                            <option value="">---请选择---</option>
                        </select>
                    </td>
                    <td align="right">品牌：</td>
                    <td align="left">
                        <select style="width: 138px;" id="brandId" name="brandId">
                            <option value="">---请选择---</option>
                        </select>
                    </td>
                    <td align="right" style="color:red">时间：</td>
                    <td align="left">
                        <input type="text"  id="priceDate" name="priceDate"/>
                    </td>
                    <td align="right" >半旬：</td>
                    <td align="left">
                        <select style="width: 138px;" name="half" id="half">
                            <option value="">---请选择---</option>
                            <option value="1">1-5日</option>
                            <option value="2">6-10日</option>
                            <option value="3">11-15日</option>
                            <option value="4">16-20日</option>
                            <option value="5">21-25日</option>
                            <option value="6">26日-月底</option>
                        </select>
                    </td>
                    <td align="right">流水号：</td>
                    <td align="left">
                        <input type="text"  id="number" style="width:80px" name="number" maxlength="5"  value="00001" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"/>&nbsp;&nbsp; ~<input type="text" style="width:80px" id="numberTwo" name="numberTwo" maxlength="5" value="00005" onFocus="if(value==defaultValue){value='';this.style.color='#000'}" onBlur="if(!value){value=defaultValue;this.style.color='#999'}" style="color:#999999"/>
                    </td>
                </tr>
                </tbody>
            </table>
            <msk:button buttonValue="生成打印数据" buttonId="TSC20043.SAVE" buttonType="button" align="left"/>
            <msk:button buttonValue="导出数据文件" buttonId="TSC20043.EXPORT" buttonType="button" align="left"/>
            <msk:button buttonValue="新打印标签" buttonId="TSC20043.DELETE" buttonType="button" align="left"/>
            <msk:button buttonValue="查询上次批次号" buttonId="TSC20043.SEARCH" buttonType="button" align="left"/>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <msk:button buttonValue="查询所有批次号" buttonId="TSC20043.SEARCHLOT" buttonType="button" align="left"/>
            <msk:button buttonValue="查询所有批次流水号" buttonId="TSC20043.SEARCHSERIAL" buttonType="button" align="left"/>
        </form:form>
    </div>
</div>
