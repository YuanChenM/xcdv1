<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
    Title:卖家产品品种图片
    author:gyh
    createDate:2016-3-4
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<navigation:header title="产品品种图片" backTitleArray="" backUrlArray=""></navigation:header>
<div class="page-content list-page">
    <div>
        <table width="100%">
            <thead></thead>
            <tbody>
            <tr>
                <td>盘装图</td>
                <td><a class="tooltip" title="盘装图"
                       href="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/inTrayFigure.png"
                       target="_blank"><img
                        src="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/inTrayFigure.png"
                        height="100px" width="200px"/></a></td>
            </tr>
            <tr>
                <td>内袋图</td>
                <td><a class="tooltip" title="内袋图"
                       href="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/insideOfFigure.png"
                       target="_blank"><img
                        src="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/insideOfFigure.png"
                        height="100px" width="200px"/></a></td>
            </tr>
            <tr>
                <td>外箱开箱图</td>
                <td><a class="tooltip" title="外箱开箱图"
                       href="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/outsideBoxFigure.png"
                       target="_blank"><img
                        src="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/outsideBoxFigure.png"
                        height="100px" width="200px"/></a></td>
            </tr>
            <tr>
                <td>外箱开箱图</td>
                <td><a class="tooltip" title="外箱开箱图"
                       href="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/outsideBoxFigure.png"
                       target="_blank"><img
                        src="${fileSerUrl}/sl/${sl241116Bean.prodEpId}/pd/${sl241116Bean.pdClassesCode}/${sl241116Bean.machiningCode}/${sl241116Bean.pdBreedCode}/outsideBoxFigure.png"
                        height="100px" width="200px"/></a></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>