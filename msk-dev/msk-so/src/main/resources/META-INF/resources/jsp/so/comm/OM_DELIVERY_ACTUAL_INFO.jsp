<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
        <div class="group-accordion" active="true">
            <h3>
                <label>实际配送信息</label>
            </h3>
            <div>
                <table class="tree dataTable no-footer" id="detailTable" style="width: 100%">
                    <tr style="background:#DBDBDB">
                        <td>配送单编码</td>
                        <td>发货单id</td>
                        <td>发货单编码</td>
                        <td>配送人</td>
                        <td>配送人电话</td>
                        <td>配送时间</td>
                        <td>配送方式</td>
                        <td>预计到货时间</td>
                        <td>实际到货时间</td>
                    </tr>
                    <c:forEach items="${delivers}" var="deliver" varStatus="i">
                        <tr class="treegrid-${deliver.shipId}">
                            <td >${deliver.deliverCode}</td>
                            <td >${deliver.shipId}</td>
                            <td >${deliver.shipCode }</td>
                            <td >${deliver.deliverPerson }</td>
                            <td >${deliver.personMobile }</td>
                            <td ><fmt:formatDate value="${deliver.deliverDate}" type="both" dateStyle="default"/></td>
                            <td >${deliver.deliverModeStr}</td>
                            <td ><fmt:formatDate value="${deliver.expectReceiveDate}" type="both"    dateStyle="default"/></td>
                            <td ><fmt:formatDate value="${deliver.actualReceiveDate}" type="both"  dateStyle="default"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>