<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    Title:正式上线修改添加
    author:pxg
    createDate:2016-02-23
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<div class="group-accordion" collapsible="false" active="false" id="TSC20033accordion" style="overflow: hidden">
    <h3 style="position: relative">
        <label>发货单计划详细信息</label>
    </h3>
    <form action="${ctx}/TSC20033/search" method="post">
        <table id="TSC20033_grid" showAddBtn="true" class="tree dataTable no-footer" width="auto">
            <thead>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="24">大宗食材发货订单（按车次发货）</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" rowspan="2" colspan="4">订单日期</td>
                <td align="center" width="40px" rowspan="2" colspan="6">2016/4/10</td>
                <td align="left" width="40px" colspan="14">大宗食材OEM加工订单合同
                    <select>
                        <option>SA0379003032201 鸡产品采购招标</option>
                        <option>SA0379003032202 鸭产品采购招标</option>
                        <option>SA0379003032203 猪产品采购招标</option>
                    </select>
                </td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="14">合同编号：<span class="editable">SA0379003032201BSHK02</span>  &nbsp;&nbsp;合同名称：<span class="editable">2016年3月中旬神农客实业（上海）有限公司鸡类产品采购招标	</span></td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="24">本次订单里程数，按百度地图测算约为<input type="text" value="798" style="width: 30px;"/>公里，运费单价为<input type="text" value="0.3" style="width: 30px;"/>元/吨公里，每吨运费约为<input type="text" value="240" style="width: 30px;"/>元。</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="24">按供需双方 2016年3月22 日签订的大宗食材OEM加工   基准合同及 SA0379003032201（订单号）订单要求，本次发货执行采购订单第  <input type="text" value="2" style="width: 30px;"/>次发货，订单明细如下：</td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px">序号</td>
                <td align="center" width="40px">一级分类</td>
                <td align="center" width="40px">二级分类</td>
                <td align="center" width="40px">产品名称</td>
                <td align="center" width="40px">产品规格</td>
                <td align="center" width="40px">编码</td>
                <td align="center" width="40px">产品标准代码</td>
                <td align="center" width="40px">外包装规格</td>
                <td align="center" width="40px">产品分级</td>
                <td align="center" width="40px">产品净重（KG/箱）</td>
                <td align="center" width="40px">发货箱数</td>
                <td align="center" width="40px">发货数量（KG）</td>
                <td align="center" width="40px">合同定价（元/KG）</td>
                <td align="center" width="40px">执行价（元/KG）</td>
                <td align="center" width="40px">采购金额</td>
                <td align="center" width="40px">包材单价（元/KG)</td>
                <td align="center" width="40px">包材使用数量（KG)</td>
                <td align="center" width="40px">包材费用（元）</td>
                <td align="center" width="40px">运费（元）</td>
                <td align="center" width="40px">预计到货时间</td>
                <td align="center" width="40px">实际发货数量</td>
                <td align="center" width="40px">合计（元）</td>
                <td align="center" width="40px">备注</td>
                <td align="center" width="40px">操作</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listThree}" var="list" varStatus="i">
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
                    <td>${list.attribute19}</td>
                    <td>${list.attribute20}</td>
                    <td>${list.attribute17}</td>
                    <td>${list.attribute18}</td>
                    <td><msk:button buttonValue="编辑" name="TSC20003_THREENAME" buttonId="TSC20003.UPDATETHREE${i.index}" buttonType="button"/><msk:button buttonValue="删除" name="TSC20003_THREEDELETE" buttonId="TSC20003.DELETETHREE${i.index}" buttonType="button"/></td>
                </tr>
            </c:forEach>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="10">合计</td>
                <td align="center" width="40px">2920</td>
                <td align="center" width="40px">29390</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px">292575</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px">29390</td>
                <td align="center" width="40px">5878</td>
                <td align="center" width="40px">7035.97</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px">29000</td>
                <td align="center" width="40px">305488.97</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
            </tr>
            <tr style="background:#DBDBDB">
                <td align="center" width="40px" colspan="4">采购订单预付金额</td>
                <td align="center" width="40px">本次预付：</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px" colspan="2">58515</td>
                <td align="center" width="40px">元</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px">包材费用</td>
                <td align="center" width="40px">5878</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px">运输费用</td>
                <td align="center" width="40px">7035.97</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px">246973.97</td>
                <td align="center" width="40px"></td>
                <td align="center" width="40px"></td>
            </tr>
            <tr>
                <td colspan="24"><msk:button buttonValue="新建" buttonId="TSC20033.NEW" buttonType="button"/>
                    <msk:button buttonValue="待运期计划查看" buttonId="TSC20033.SEARCH" buttonType="button"/></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>
<div>
    <form>
        <table class="tree dataTable no-footer">
            <tr>
                <td align="center" width="40px"><b>备注</b></td>
                <td align="center" width="40px" colspan="3" class="editable">-</td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>发货时间要求</b></td>
                <td align="center" width="40px" colspan="3" class="editable">2016/4/11</td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>发货单位、仓库地点</b></td>
                <td align="center" width="40px" colspan="3">发货单位：<span class="editable">寿光圣沣食品有限公司</span>仓库地址：<span class="editable">寿光市稻田镇昌大路北</span></td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>发货负责人</b></td>
                <td align="center" width="40px" class="editable">李全余</td>
                <td align="center" width="40px"><b>联系电话</b></td>
                <td align="center" width="40px" class="editable">13355490608</td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>发货执行人</b> </td>
                <td align="center" width="40px" class="editable">李全余</td>
                <td align="center" width="40px"><b>联系电话</b></td>
                <td align="center" width="40px" class="editable">13355490608</td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>运输单位</b></td>
                <td align="center" width="40px" colspan="3"><b>运输单位名称：</b> <span class="editable">寿光圣沣食品有限公司</span></td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>运输单位负责人</b></td>
                <td align="center" width="40px" class="editable">李全余</td>
                <td align="center" width="40px"><b>联系电话</b></td>
                <td align="center" width="40px" class="editable">13355490608</td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>运输单位执行人</b></td>
                <td align="center" width="40px" class="editable">李全余</td>
                <td align="center" width="40px"><b>联系电话</b></td>
                <td align="center" width="40px" class="editable">13355490608</td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>需方运抵仓库地址</b></td>
                <td align="center" width="40px" colspan="3"><b>运抵仓库地址：</b><span class="editable">上海市松江区开明路1168号（味硕实业（上海）有限公司）</span></td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>仓管负责人</b></td>
                <td align="center" width="40px" class="editable">仲米兰</td>
                <td align="center" width="40px"><b>联系电话</b></td>
                <td align="center" width="40px" class="editable">15858984286</td>
            </tr>
            <tr>
                <td align="center" width="40px"><b>验收负责人</b></td>
                <td align="center" width="40px" class="editable">叶明海</td>
                <td align="center" width="40px"><b>联系电话</b></td>
                <td align="center" width="40px" class="editable">13355490608</td>
            </tr>
        </table>
        <msk:button buttonValue="保存" buttonId="TSC20033.ADD" buttonType="button"/>
        <%-- <div>
             <table>
                 <tr>
                     <td>备注：供方盖章后的扫描件或传真件与原件具有同等法律效力。</td>
                 </tr>
                 <tr>
                     <td>供方确认（签字并盖章）。</td>
                     <td>需方确认（发货专用章）</td>
                 </tr>
                 <tr>
                     <td></td>
                     <td>订单执行人：高斌   15618970523</td>
                     <td>公司QQ：2853783700</td>
                 </tr>
                 <tr>
                     <td></td>
                     <td>订单审核人：陶文琤   15618970150</td>
                     <td>公司QQ：2853783700</td>
                 </tr>
                 <tr>
                     <td>确认日期：</td>
                     <td>发单日期：2016/4/1</td>
                 </tr>
             </table>
         </div>--%>
    </form>
</div>
<script src="${ctx}/js/ds/TSC20033.js"></script>
