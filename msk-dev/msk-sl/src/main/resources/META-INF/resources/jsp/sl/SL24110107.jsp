<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    var listSize = "${listSize}";
    var sl2411030073BeansSize="${sl2411030073BeansSize}";
</script>
<div class="group-accordion" active="false">
    <h3>
        <label>卖家品牌</label>
    </h3>

    <div>
        <div>
            <tr>
                <td align="center">
                    <msk:button buttonValue="添加" buttonId="SL24110107.ADD" buttonType="button"/>
                </td>
            </tr>
        </div>
        <c:forEach var="list" items="${list}" varStatus="i">
            <div>
                <form:form action="${ctx}/SL24110107/update" id="SL24110107Form${i.index}"
                           metdod="post" enctype="multipart/form-data">
                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td align="right" width="50%">产品分类　</td>
                            <td align="left" width="50%">
                                <input type="radio" name="brandClass"  <c:if test="${list.brandClass==0}">checked="checked"</c:if> value="0"/>卖家独立品牌
                                <input type="radio" name="brandClass"  <c:if test="${list.brandClass==1}">checked="checked"</c:if> value="1"/>神农先生联合
                                <input type="radio" name="brandClass"  <c:if test="${list.brandClass==2}">checked="checked"</c:if> value="2"/>神农客联合
                                <input type="radio" name="brandClass"  <c:if test="${list.brandClass==3}">checked="checked"</c:if> value="3"/>神农人家联合
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">品牌名称　</td>
                            <td align="left" width="50%">
                                <input type="text" id="brandName" name="brandName" value="${list.brandName}"/>
                                <input type="hidden" id="epId" name="epId" value="${list.epId}" readonly/>
                                <input type="hidden" id="brandId" name="brandId" value="${list.brandId}" readonly/>
                            </td>
                        </tr>

                        <tr>
                            <td align="right" width="50%">商标注册证编码　</td>
                            <td align="left" width="50%">
                                <input type="text" id="brandNo" name="brandNo" value="${list.brandNo}"
                                       readonly="readonly"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">有效期开始　</td>
                            <td align="left" width="50%">
                                <c:if test="${list.brandTermBegin == null}">
                                    <input type="text" name="brandTermBegin" id="brandTermBegin${i.index}"/>
                                </c:if>
                                <c:if test="${list.brandTermBegin != null}">
                                    <input type="text" name="brandTermBegin" id="brandTermBegin${i.index}"
                                           value="<fmt:formatDate value="${list.brandTermBegin}" pattern="yyyy-MM-dd" />"/>
                                </c:if>
                            </td>
                        </tr>

                        <tr>
                            <td align="right" width="50%">有效期截止　</td>
                            <td align="left" width="50%">
                                <c:if test="${list.brandTermEnd == null}">
                                    <input type="text" name="brandTermEnd" id="brandTermEnd${i.index}"/>
                                </c:if>
                                <c:if test="${list.brandTermEnd != null}">
                                    <input type="text" name="brandTermEnd" id="brandTermEnd${i.index}"
                                           value="<fmt:formatDate value="${list.brandTermEnd}" pattern="yyyy-MM-dd" />"/>
                                </c:if>
                            </td>
                        </tr>

                        <tr>
                            <td align="right" width="50%">荣誉证书编号　</td>
                            <td align="left" width="50%">
                                <input type="text" id="honorNo" name="honorNo" value="${list.honorNo}"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">荣誉描述　</td>
                            <td align="left" width="50%">
                                <input type="text" id="honorDes" name="honorDes" value="${list.honorDes}"/>
                                <input type="hidden" id="honorId" name="honorId" value="${list.honorId}" readonly="readonly"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">发证单位　</td>
                            <td align="left" width="50%">
                                <input type="text" id="certIssuer" name="certIssuer" value="${list.certIssuer}"/>
                            </td>
                        </tr>

                        <tr>
                            <td align="right" width="50%">发证日期　</td>
                            <td align="left" width="50%">
                                <c:if test="${list.certDate == null}">
                                    <input type="text" name="certDate" id="certDatex${i.index}"/>
                                </c:if>
                                <c:if test="${list.certDate != null}">
                                    <input type="text" name="certDate" id="certDatex${i.index}"
                                           value="<fmt:formatDate value="${list.certDate}" pattern="yyyy-MM-dd" />"/>
                                </c:if>
                            </td>
                        </tr>

                        <tr>
                            <td align="right" width="50%">品牌证书图片上传</td>
                            <td align="left" width="50%">
                                <input type="file" name="brand" id="brandCert"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">包装图片上传</td>
                            <td align="left" width="50%">
                                <input type="file" name="brandpac" id="brand"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right" width="50%">品牌荣誉证书上传</td>
                            <td align="left" width="50%">
                                <input type="file" name="brandHonor" id="honorCert"/>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">
                                <msk:button buttonValue="保存" name="${i.index}" buttonId="SL24110107.UPDATE${i.index}"
                                            buttonType="button"/>
                            </td>
                            <td align="left">
                                <msk:button buttonValue="删除" name="${i.index}" buttonId="SL24110107.DELETE${i.index}"
                                            buttonType="button"/>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
        </c:forEach>

        <c:forEach var="sl2411030073Bean" items="${sl2411030073Beans}" varStatus="i">
        <div>
            <form:form action="${ctx}/SL24110107/update2" id="SL241101070Form${i.index}" metdod="post">
                <table width="100%" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="right" width="50%">产品分类</td>
                        <td align="left" width="50%">
                            <input type="radio" name="brandClass"  <c:if test="${sl2411030073Bean.brandClass==0}">checked="checked"</c:if> value="0"/>卖家独立品牌
                            <input type="radio" name="brandClass"  <c:if test="${sl2411030073Bean.brandClass==1}">checked="checked"</c:if> value="1"/>神农先生联合
                            <input type="radio" name="brandClass"  <c:if test="${sl2411030073Bean.brandClass==2}">checked="checked"</c:if> value="2"/>神农客联合
                            <input type="radio" name="brandClass"  <c:if test="${sl2411030073Bean.brandClass==3}">checked="checked"</c:if> value="3"/>神农人家联合
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">生产商</td>
                        <td align="left" width="50%">
                            <input type="text" name="epName" value="${sl2411030073Bean.epName}" readonly="readonly"/>
                            <input type="hidden" name="producerEpId" value="${sl2411030073Bean.producerEpId}">
                            <input type="hidden" name="slCode" value="${sl2411030073Bean.slCode}">
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">品牌</td>
                        <td align="left" width="50%">
                            <input type="text" name="brandName" value="${sl2411030073Bean.brandName}" readonly="readonly"/>
                            <input type="hidden" name="brandEpId" value="${sl2411030073Bean.brandEpId}">
                            <input type="hidden" name="brandId" value="${sl2411030073Bean.brandId}">
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">代理及分销授权合同号</td>
                        <td align="left" width="50%">
                            <input type="text"  name="contractNo" value="${sl2411030073Bean.contractNo}" readonly="readonly">
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">授权单位</td>
                        <td align="left" width="50%">
                            <input type="text" name="epName1" value="${sl2411030073Bean.epName}" readonly="readonly"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">授权期限开始日期</td>
                        <td align="left" width="50%">
                            <c:if test="${sl2411030073Bean.termBegin == null}">
                                <input type="text" name="termBegin" id="termBegin0${i.index}"/>
                            </c:if>
                            <c:if test="${sl2411030073Bean.termBegin != null}">
                                <input type="text" name="termBegin" id="termBegin0${i.index}"
                                       value="<fmt:formatDate value="${sl2411030073Bean.termBegin}" pattern="yyyy-MM-dd" />"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td align="right" width="50%">授权期限截止日期</td>
                        <td align="left" width="50%">
                            <c:if test="${sl2411030073Bean.termEnd == null}">
                                <input type="text" name="termEnd" id="termEnd0${i.index}"/>
                            </c:if>
                            <c:if test="${sl2411030073Bean.termEnd != null}">
                                <input type="text" name="termEnd" id="termEnd0${i.index}"
                                       value="<fmt:formatDate value="${sl2411030073Bean.termEnd}" pattern="yyyy-MM-dd" />"/>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <msk:button buttonValue="保存"  buttonId="SL241101070.UPDATE${i.index}" buttonType="button"/>
                        </td>
                        <td align="left">
                            <msk:button buttonValue="删除"  buttonId="SL241101070.DELETE${i.index}" buttonType="button"/>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
        </c:forEach>
    </div>
</div>
<script src="${ctx}/js/sl/SL24110107.js"></script>
