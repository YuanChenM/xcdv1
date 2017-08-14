<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<c:if test="${admin eq '1'}">
    <navigation:header title="发票确认" backTitleArray="合同管理" backUrlArray="${ctx}/TSC10004/init"></navigation:header>
</c:if>
<c:if test="${admin eq null}">
    <navigation:header title="发票确认" backTitleArray="发票管理" backUrlArray="${ctx}/BS2101101/init"></navigation:header>
</c:if>
<div class="page-content list-page">
    <div class="group-accordion" active="true">
        <h3>
            <label>发票确认</label>
        </h3>
        <form:form action="#" id="TSC30012Form" method="post" enctype="multipart/form-data">
            <table class="tree dataTable no-footer" showAddBtn="true" id="TSC30012Table">
                <tr style="background: #DBDBDB">
                    <td colspan="6" align="center">供应商发票开具确认单</td>
                        <%--   <td colspan="5"></td>--%>
                </tr>
                <tr>
                    <td colspan="2" align="center" style="background: #DBDBDB">开票单位</td>
                    <td colspan="4" align="center">
                        <input type="text" id="1" value="上海神龙客实业有限公司" style="width:300px;"/>
                    </td>
                </tr>
                <tr>
                    <td rowspan="7" align="center" width="7%" style="background: #DBDBDB">开票信息</td>
                </tr>
                <tr>
                    <td align="center" width="15%" style="background: #DBDBDB">订单合同金额</td>
                    <td align="center" colspan="4">
                        <input type="text" id="2" value="14.7(万元)"/>
                    </td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">实际付款金额</td>
                    <td align="center" colspan="4"><input type="text" id="3" value="14.7(万元)"/>
                    </td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">应开发票金额</td>
                    <td align="center" colspan="4"><input type="text" id="4" value="14.7(万元)"/>
                    </td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">发票性质</td>
                    <td align="center" colspan="4">
                        <input type="radio" checked="checked" name="type" value="1">增值税专用发票
                        <input type="radio" name="type" value="2">增值税普通发票
                        <input type="radio" name="type" value="3">普通发票
                    </td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">发票周期</td>
                    <td align="center" colspan="4">
                        <select>
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                        </select>年
                    </td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">发票送达时间</td>
                    <td align="center" colspan="4"><input type="text" id="time" name="time"/></td>
                </tr>
                <tr>
                    <td rowspan="10" align="center" id="row" style="background: #DBDBDB">开票资料</td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">购货单位名称</td>
                    <td align="center" colspan="4"><input type="text" id="6" value=" 神农客实业有限公司"
                                                          style="width:300px;border-style:none"/></td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">纳税人识别号</td>
                    <td align="center" colspan="4"><input type="text" id="7" value="001"/>
                    </td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">地址、电话</td>
                    <td align="center" colspan="4"><input type="text" id="8" value="上海浦东 13286337792"
                            /></td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">开户行及帐号</td>
                    <td align="center" colspan="4"><input type="text" id="9" value="中国建设银行 张江支行 00834059823"
                                                          style="width:300px;"/></td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">货物及应税劳务名称</td>
                    <td align="center" style="background: #DBDBDB">规格型号</td>
                    <td align="center" style="background: #DBDBDB">单位</td>
                    <td align="center" style="background: #DBDBDB">数量</td>
                    <td align="center" style="background: #DBDBDB">价税合计金额</td>
                </tr>
                <tr>
                    <td align="center"><input type="text" id="10" value="鸭产品 分割品 带皮鸭胸	" style="width:180px;"/></td>
                    <td align="center"><input type="text" id="11" value="10kg*1"/></td>
                    <td align="center"><input type="text" id="12" value="kg"/></td>
                    <td align="center"><input type="text" id="13" value="500(箱)"/></td>
                    <td align="center"><input type="text" id="14" value="49000(元)"/></td>
                </tr>
                <tr>
                    <td align="center"><input type="text" id="15" value="鸭产品 副产品 鸭胗" style="width:180px;"/></td>
                    <td align="center"><input type="text" id="16" value="10kg*1"/></td>
                    <td align="center"><input type="text" id="17" value="kg"/></td>
                    <td align="center"><input type="text" id="18" value="500(箱)"/></td>
                    <td align="center"><input type="text" id="19" value="49000(元)"/></td>
                </tr>
                <tr id="add">
                    <td align="center"><input type="text" id="20" value="鸭产品 分割品 鸭锁骨" style="width:180px;"/></td>
                    <td align="center"><input type="text" id="21" value="10kg*1"/></td>
                    <td align="center"><input type="text" id="22" value="kg"/></td>
                    <td align="center"><input type="text" id="23" value="500(箱)"/></td>
                    <td align="center"><input type="text" id="24" value="49000(元)"/></td>
                </tr>
                <tr>
                    <td align="center" id="addRow">添加</td>
                    <td align="center" colspan="4"></td>
                </tr>
                <tr>
                    <td align="center" colspan="3" style="background: #DBDBDB">合计</td>
                    <td align="center">1500(箱)</td>
                    <td align="center">14.7(万元)</td>
                </tr>
                <tr>
                    <td align="center" rowspan="4" style="background: #DBDBDB">寄送人信息</td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">收件人地址</td>
                    <td align="center" colspan="4"><input type="text" id="27" value="上海市 浦东新区张江高科 科苑路"
                                                          style="width:300px;"/></td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">收 件 人</td>
                    <td align="center" colspan="2"><input type="text" id="28" value="小徐"/>
                    </td>
                    <td align="center">联系电话</td>
                    <td align="center"><input type="text" id="29" value="13286337792"/></td>
                </tr>
                <tr>
                    <td align="center" style="background: #DBDBDB">寄送方式</td>
                    <td align="center" colspan="4">
                        <input type="text" id="31" value="顺丰快递"/>
                        <br/>
                        备注：快递费用自理
                    </td>
                </tr>
            </table>

            <div>发票状态
                <input type="radio" checked="checked" name="state" value="1">已收
                <input type="radio" name="state" value="2">未收
            </div>
            <br/>

            <div>
                上传附件
                <input type="file">
            </div>
            <br/>
            <div>
                <msk:button buttonValue="保存" buttonId="TSC30012.SAVE" buttonType="button"/>
            </div>
        </form:form>
    </div>
</div>
<script type="text/javascript" src="${ctx}/js/ds/TSC30012.js"></script>

