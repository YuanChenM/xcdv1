<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="中标成交确认书管理" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content detail-page" style="margin-top:35px;">
    <div class="group-accordion" collapsible="false" active="true">
        <h3>
            <label>中标项目详细信息</label>
        </h3>

        <table style="border:0px">
            <tr>
                <td align="left">招标项目名称:&nbsp;</td>
                <td><input type="text" id="projectName" name="projectName" value="${list.projectName}"/></td>
            </tr>

            <tr>
                <td align="left">中标公司名称:&nbsp;</td>
                <td><input type="text" id="winner" name="winner" value="${list.winner}"/></td>
            </tr>

            <tr>
                <td align="left">开标时间:&nbsp;&nbsp;</td>
                <td><input type="text" id="checkTime" name="checkTime" value="${list.checkTime}"/></td>
            </tr>

            <tr>
                <td align="left">开标起始时间:&nbsp;</td>
                <td><input type="text" id="beginTime" name="beginTime" value="${list.beginTime}"/></td>
            </tr>

            <tr>
                <td align="left">开标截止时间:&nbsp;</td>
                <td><input type="text" id="endTime" name="endTime" value="${list.endTime}"/></td>
            </tr>
        </table>

    </div>
    <div class="group-accordion" collapsible="false" active="true">
        <h3>
            <label>中标产品清单</label>
        </h3>

        <div>
            <table id="TSC10002_grid" showAddBtn="true" class="tree dataTable no-footer" width="100%">
                <thead>
                <tr style="background:#DBDBDB">
                    <td align="left" width="40px" colspan="21">
                        神农客实业（上海）有限公司××年××月××日××期××半旬招标，你单位为中标单位之一，中标信息如下，请予确认。
                    </td>
                </tr>
                <tr style="background:#DBDBDB">
                    <td align="center" width="40px" colspan="21">
                        中标产品清单
                    </td>
                </tr>
                <tr style="background:#DBDBDB">
                    <td align="center" width="40px" rowspan="3">序号</td>
                    <td align="center" width="40px" rowspan="3">一级分类</td>
                    <td align="center" width="40px" rowspan="3">二级分类</td>
                    <td align="center" width="40px" colspan="6">产品信息</td>
                    <td align="center" width="40px" rowspan="3">OEM品牌及产品等级</td>
                    <td align="center" width="40px" rowspan="3">产品质量标准</td>
                    <td align="center" width="40px" colspan="2">加工信息</td>
                    <td align="center" width="40px" colspan="7">货值</td>
                    <td align="center" width="40px" rowspan="3">备注</td>

                </tr>
                <tr style="background:#DBDBDB">
                    <td align="center" width="40px" colspan="3">品种名</td>
                    <td align="center" width="40px" rowspan="2">产品特征</td>
                    <td align="center" width="40px" rowspan="2">净重(kg/箱)</td>
                    <td align="center" width="40px" rowspan="2">包装规格</td>
                    <td align="center" width="40px" rowspan="2">数量(吨)</td>
                    <td align="center" width="40px" rowspan="2">箱数</td>
                    <td align="center" width="40px" colspan="5">中标价(元/kg)</td>
                    <td align="center" width="40px" rowspan="2">本次结算标准价(元/kg)</td>
                    <td align="center" width="40px" rowspan="2">货值(元)</td>
                </tr>
                <tr style="background:#DBDBDB">
                    <td align="center" width="40px">标准市场销售名</td>
                    <td align="center" width="40px">学名</td>
                    <td align="center" width="40px">俗名</td>
                    <td align="center" width="40px">不含包装离岸价</td>
                    <td align="center" width="40px">包装成本</td>
                    <td align="center" width="40px">含包装离岸价</td>
                    <td align="center" width="40px">干线运费</td>
                    <td align="center" width="40px">到岸价</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${lists}" var="list" varStatus="i">
                    <tr>
                        <td>${i.index+1}</td>
                        <td>${list.yjfl}</td>
                        <td>${list.ejfl}</td>
                        <td>${list.xsm}</td>
                        <td>${list.xm}</td>
                        <td></td>
                        <td>${list.tz}</td>
                        <td>${list.jz}</td>
                        <td>${list.gg}</td>
                        <td>${list.dj}</td>
                        <td>${list.zlbz}
                        </td>
                        <td>${list.sl}</td>
                        <td>${list.xs}</td>
                        <td>${list.bhlaj}</td>
                        <td>${list.cb}</td>
                        <td>${list.laj}</td>
                        <td>${list.yf}</td>
                        <td>${list.daj}</td>
                        <td>${list.bzj}</td>
                        <td>${list.hz}</td>
                        <td></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div>
        以上表格内容经双方确认，同意签字盖章并扫描回复。
        <br/>
        <table width="100%">
            <tr>
                <td width="50%">
                    发标方：神农客实业（上海）有限公司
                    （签字、盖章）
                    <br/>
                    <br/>
                    <img src="${ctx}/static/core/images/action/tuzhang2.png"/>
                    <br/>
                    <br/>
                    <br/>
                    日期：2016.6.24
                </td>
                <td>
                    中标方：河北创融公司
                    （签字、盖章）
                    <br/>
                    <br/>
                    <img src="${ctx}/static/core/images/action/tuzhang1.png"/>
                    <br/>
                    <br/>
                    <br/>
                    日期：2016.6.24
                </td>
            </tr>
        </table>
    </div>
</div>
<script src="${ctx}/js/ds/TSC10002.js"></script>