<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:正式上线修改添加
    author:pxg
    createDate:2016-02-23
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="group-accordion" collapsible="false" active="false" id="TSC10005accordion4">
    <h3 style="position: relative">
        <label>合同基础信息</label>
    </h3>
    <form action="${ctx}/TSC10005/search" method="post">
        <table>
            <tr>
                <td><b>合同编号：</b></td>
                <td>20160607001001</td>
            </tr>
            <tr>
                <td><b>合同名称：</b></td>
                <td>2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标</td>
            </tr>
            <tr>
                <td><b>生产商：</b></td>
                <td>河北某某畜禽养殖有限公司</td>
            </tr>
            <tr>
                <td><b>合同生效日期：</b></td>
                <td>2016-03-20</td>
            </tr>
            <tr>
                <td><b>合同状态：</b></td>
                <td>未核销</td>
            </tr>
        </table>
    </form>
</div>
<div class="group-accordion" collapsible="false" active="false" id="TSC10005accordion">
    <h3 style="position: relative">
        <label>合同订单信息</label>
    </h3>
    <form action="${ctx}/TSC10005/search" method="post">
        <table id="TSC10005_grid" showAddBtn="true" class="tree dataTable no-footer" width="auto">
            <thead>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" rowspan="3">序号</td>
                <td align="center" width="40px" rowspan="3">一级分类</td>
                <td align="center" width="40px" rowspan="3">二级分类</td>
                <td align="center" width="40px" colspan="6">产品信息</td>
                <td align="center" width="40px" rowspan="3">产品标签码</td>
                <td align="center" width="40px" rowspan="3">OEM品牌及产品等级</td>
                <td align="center" width="40px" rowspan="3">产品质量标准</td>
                <td align="center" width="40px" colspan="2">加工信息</td>
                <td align="center" width="40px" colspan="7">货值</td>
                <td align="center" width="40px" colspan="2">本次付款数</td>
                <td align="center" width="40px" rowspan="3">备注</td>
                <td align="center" width="40px" rowspan="3">操作</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="3">品种名</td>
                <td align="center" width="40px" rowspan="2">产品特征</td>
                <td align="center" width="40px" rowspan="2">单箱净重(kg)</td>
                <td align="center" width="40px" rowspan="2">包装规格</td>
                <td align="center" width="40px" rowspan="2">数量(吨)</td>
                <td align="center" width="40px" rowspan="2">箱数</td>
                <td align="center" width="40px" colspan="5">中标价(元/kg)</td>
                <td align="center" width="40px" rowspan="2">本次结算标准价(元/kg)</td>
                <td align="center" width="40px" rowspan="2">货值(元)</td>
                <td align="center" width="40px" rowspan="2">首付比例(%)</td>
                <td align="center" width="40px" rowspan="2">付款额(元)</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px">标准市场销售名</td>
                <td align="center" width="40px">学名</td>
                <td align="center" width="40px">俗名</td>
                <td align="center" width="40px">不含包装离岸价</td>
                <td align="center" width="40px">包装成本</td>
                <td align="center" width="40px">含包装离岸价</td>
                <td align="center" width="40px">干线运费</td>
                <td align="center" width="40px">含包装到岸价</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listData}" var="list" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${list.attribute22}</td>
                    <td>${list.attribute23}</td>
                    <td>${list.attribute1}</td>
                    <td>${list.attribute2}</td>
                    <td>${list.attribute3}</td>
                    <td>${list.attribute4}</td>
                    <td>${list.attribute5}</td>
                    <td>${list.attribute6}</td>
                    <td>${list.attribute7}</td>
                    <td>${list.attribute8}</td>
                    <td>${list.attribute9}</td>
                    <td>${list.attribute10}</td>
                    <td>${list.attribute11}</td>
                    <td>${list.attribute12}</td>
                    <td>${list.attribute13}</td>
                    <td>${list.attribute14}</td>
                    <td>${list.attribute15}</td>
                    <td>${list.attribute16}</td>
                    <td>${list.attribute17}</td>
                    <td>${list.attribute18}</td>
                    <td>${list.attribute19}</td>
                    <td>${list.attribute20}</td>
                    <td>${list.attribute21}</td>
                    <td><msk:button buttonValue="编辑" name="TSC10005_ONENAME" buttonId="TSC10005.UPDATE${i.index}" buttonType="button"/><msk:button buttonValue="删除" buttonId="TSC10004.DELETE${i.index}" name="TSC10005_ONEDELETE" buttonType="button"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table>
            <tr>
                <msk:button buttonValue="新增" buttonId="TSC10005.ADD" buttonType="button"/>
            </tr>
        </table>
    </form>
</div>
<div class="group-accordion" collapsible="false" active="false" id="TSC10005accordion2">
    <h3 style="position: relative">
        <label>订单包材质量要求</label>
    </h3>
    <form action="${ctx}/TSC10005/search" method="post">
        <table id="TSC10005_grid1" showAddBtn="true" class="tree dataTable no-footer">
            <thead>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" rowspan="3">序号</td>
                <td align="center" width="40px" rowspan="3">一级分类</td>
                <td align="center" width="40px" rowspan="3">二级分类</td>
                <td align="center" width="40px" colspan="6">产品信息</td>
                <td align="center" width="40px" colspan="6">神农卫士包材标准</td>
                <td align="center" width="40px" colspan="6">本次订单包材信息</td>
                <td align="center" width="40px" colspan="6">本次包材需求量(个)</td>
                <td align="center" width="40px" rowspan="3">包材提供方式</td>
                <td align="center" width="40px" rowspan="3">包材审核方式</td>
                <td align="center" width="40px" rowspan="3">包材结算方式</td>
                <td align="center" width="40px" rowspan="3">操作</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="3">品种名</td>
                <td align="center" width="40px" rowspan="2">产品特征</td>
                <td align="center" width="40px" rowspan="2">单箱净重(kg)</td>
                <td align="center" width="40px" rowspan="2">包装规格</td>
                <td align="center" width="40px" colspan="2">纸箱</td>
                <td align="center" width="40px" colspan="2">内袋</td>
                <td align="center" width="40px" rowspan="2">胶带颜色</td>
                <td align="center" width="40px" rowspan="2">标签内容(准入产品标签)</td>
                <td align="center" width="40px" colspan="2">纸箱</td>
                <td align="center" width="40px" colspan="2">内袋</td>
                <td align="center" width="40px" rowspan="2">胶带颜色</td>
                <td align="center" width="40px" rowspan="2">标签内容</td>
                <td align="center" width="40px" rowspan="2">纸箱</td>
                <td align="center" width="40px" rowspan="2">内袋</td>
                <td align="center" width="40px" rowspan="2">胶带</td>
                <td align="center" width="40px" colspan="3">标签</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px">标准市场销售名</td>
                <td align="center" width="40px">学名</td>
                <td align="center" width="40px">俗名</td>
                <td align="center" width="40px">质量标注</td>
                <td align="center" width="40px">规格</td>
                <td align="center" width="40px">质量标准</td>
                <td align="center" width="40px">规格</td>
                <td align="center" width="40px">质量标准</td>
                <td align="center" width="40px">规格</td>
                <td align="center" width="40px">质量标准</td>
                <td align="center" width="40px">规格</td>
                <td align="center" width="40px">纸箱大标签</td>
                <td align="center" width="40px">纸箱小标签</td>
                <td align="center" width="40px">内袋标签</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listThree}" var="list" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${list.attribute28}</td>
                    <td>${list.attribute29}</td>
                    <td>${list.attribute1}</td>
                    <td>${list.attribute2}</td>
                    <td>${list.attribute3}</td>
                    <td>${list.attribute4}</td>
                    <td>${list.attribute5}</td>
                    <td>${list.attribute6}</td>
                    <td>${list.attribute7}</td>
                    <td>${list.attribute8}</td>
                    <td>${list.attribute9}</td>
                    <td>${list.attribute10}</td>
                    <td>${list.attribute11}</td>
                    <td>${list.attribute12}</td>
                    <td>${list.attribute13}</td>
                    <td>${list.attribute14}</td>
                    <td>${list.attribute15}</td>
                    <td>${list.attribute16}</td>
                    <td>${list.attribute17}</td>
                    <td>${list.attribute18}</td>
                    <td>${list.attribute19}</td>
                    <td>${list.attribute20}</td>
                    <td>${list.attribute21}</td>
                    <td>${list.attribute22}</td>
                    <td>${list.attribute23}</td>
                    <td>${list.attribute24}</td>
                    <td>${list.attribute25}</td>
                    <td>${list.attribute26}</td>
                    <td>${list.attribute27}</td>
                    <td><msk:button buttonValue="编辑" name="TSC10005_TWONAME" buttonId="TSC10005.UPDATETWO${i.index}" buttonType="button"/><msk:button buttonValue="删除" name="TSC10005_TWODELETE" buttonId="TSC10004.DELETETWO${i.index}" buttonType="button"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table>
            <tr>
                <msk:button buttonValue="新增" buttonId="TSC10005.ADD2" buttonType="button"/>
            </tr>
        </table>
    </form>
</div>
<div class="group-accordion" collapsible="false" active="false" id="TSC10005accordion3">
    <h3 style="position: relative">
        <label>本次订单交货期安排</label>
    </h3>
    <form action="${ctx}/TSC10005/search" method="post">
        <table id="TSC10005_grid3" showAddBtn="true" class="tree dataTable no-footer">
            <thead>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" rowspan="3">序号</td>
                <td align="center" width="40px" rowspan="3">一级分类</td>
                <td align="center" width="40px" rowspan="3">二级分类</td>
                <td align="center" width="40px" colspan="6">产品信息</td>
                <td align="center" width="40px" rowspan="3">产品标签码</td>
                <td align="center" width="40px" colspan="3">第1次到货日及数量</td>
                <td align="center" width="40px" colspan="3">第N次到货日及数量</td>
                <td align="center" width="40px" rowspan="3">备注</td>
                <td align="center" width="40px" rowspan="3">操作</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="3">品种名</td>
                <td align="center" width="40px" rowspan="2">产品特征</td>
                <td align="center" width="40px" rowspan="2">单箱净重(kg)</td>
                <td align="center" width="40px" rowspan="2">包装规格</td>
                <td align="center" width="40px" rowspan="2">到货日期</td>
                <td align="center" width="40px" rowspan="2">数量(吨)</td>
                <td align="center" width="40px" rowspan="2">箱数</td>
                <td align="center" width="40px" rowspan="2">到货日期</td>
                <td align="center" width="40px" rowspan="2">数量(吨)</td>
                <td align="center" width="40px" rowspan="2">箱数</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px">标准市场销售名</td>
                <td align="center" width="40px">学名</td>
                <td align="center" width="40px">俗名</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listDataTwo}" var="list" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${list.attribute15}</td>
                    <td>${list.attribute16}</td>
                    <td>${list.attribute1}</td>
                    <td>${list.attribute2}</td>
                    <td>${list.attribute3}</td>
                    <td>${list.attribute4}</td>
                    <td>${list.attribute5}</td>
                    <td>${list.attribute6}</td>
                    <td>${list.attribute7}</td>
                    <td>${list.attribute8}</td>
                    <td>${list.attribute9}</td>
                    <td>${list.attribute10}</td>
                    <td>${list.attribute11}</td>
                    <td>${list.attribute12}</td>
                    <td>${list.attribute13}</td>
                    <td>${list.attribute14}</td>
                    <td><msk:button buttonValue="编辑" name="TSC10005_THREENAME" buttonId="TSC10005.UPDATETHREE${i.index}" buttonType="button"/><msk:button buttonValue="删除" name="TSC10005_THREEDELETE" buttonId="TSC10004.DELETETHREE${i.index}" buttonType="button"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table>
            <tr>
                <msk:button buttonValue="新增" buttonId="TSC10005.ADD3" buttonType="button"/>
            </tr>
        </table>
    </form>
</div>
<div class="group-accordion" collapsible="false" active="false" id="TSC10005accordion4">
    <h3 style="position: relative">
        <label>附件</label>
    </h3>
    <form action="${ctx}/TSC10005/search" method="post">
        <table>
            <tr>
                <td><b>商务合同:</b></td>
                <td><a href="#">点击下载文件</a> </td>
                <td><b>上传文件：</b><input type="file"/></td>
            </tr>
            <tr>
                <td><b>中标成交确认书:</b></td>
                <td><a href="#">点击下载文件</a> </td>
                <td><b>上传文件：</b><input type="file"/></td>
            </tr>
            <tr>
                <td><b>食材订单加工合同:</b></td>
                <td><a href="#">点击下载文件</a> </td>
                <td><b>上传文件：</b><input type="file"/></td>
            </tr>
            <tr>
                <td><b>核销责任书:</b></td>
                <td><a href="#">点击下载文件</a> </td>
                <td><b>上传文件：</b><input type="file"/></td>
            </tr>
            <tr>
                <td><b>付款信息(第一次付款用):</b></td>
                <td><a href="#">点击下载文件</a> </td>
                <td><b>上传文件：</b><input type="file"/></td>
            </tr>
            <tr>
                <td><b>付款项目申请表:</b></td>
                <td><a href="#">点击下载文件</a> </td>
                <td><b>上传文件：</b><input type="file"/></td>
            </tr>
        </table>
        <table>
            <tr>
                <msk:button buttonValue="上传" buttonId="TSC10005.ADD4" buttonType="button"/>
            </tr>
        </table>
    </form>
</div>
<script src="${ctx}/js/ds/TSC10005.js"></script>
