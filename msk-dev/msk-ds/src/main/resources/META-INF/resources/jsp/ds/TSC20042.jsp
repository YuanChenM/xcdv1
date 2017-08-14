<%-- 
    Title:入库单详细
    author:gyh
    createDate:2016-6-12
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<navigation:header title="入库单详细" backTitleArray="入库单一览" backUrlArray="${ctx}/TSC20041/init"></navigation:header>
<div class="page-content list-page">
    <form action="" method="post">
        <div>
            <table width="100%">
                <tr>
                    <td align="left" width="100">计划到货日期：</td>
                    <td align="left">2016年6月19日</td>
                    <td align="left" width="120">实际到货日期：</td>
                    <td align="left">2016年6月19日</td>
                </tr>
                <tr>
                    <td align="left">调入单位：</td>
                    <td align="left">山东荣达畜禽销售部</td>
                    <td align="left">合同编号：</td>
                    <td align="left"><a class="toOther1" href="javascript:void(0);">20160607001001</a></td>
                </tr>
                <tr>
                    <td align="left">仓库地址：</td>
                    <td align="left">松江仓库</td>
                    <td align="left">发货单编号：</td>
                    <td align="left"><a class="toOther" href="javascript:void(0);">FH20160607001003</a></td>
                </tr>
                <tr>
                    <td align="left">供应商：</td>
                    <td align="left">山东荣达农业发展有限公司</td>
                    <td align="left">入库方式：</td>
                    <td align="left">采购入库</td>
                </tr>
            </table>
        </div>
        <div>
            <table width="100%" class="dataTable no-footer">
                <thead>
                <tr>
                    <th rowspan="2">序号</th>
                    <th rowspan="2">一级分类</th>
                    <th rowspan="2">二级分类</th>
                    <th rowspan="2">品种名称</th>
                    <th rowspan="2">商品条码</th>
                    <th colspan="4">计划到货规格及数量</th>
                    <th colspan="4">实际到货规格及数量</th>
                    <th rowspan="2">是否神农客包装（必填）</th>
                    <th rowspan="2">到货箱条码（必填）</th>
                    <th rowspan="2">生产日期（必填）</th>
                    <th rowspan="2">标签打印</th>
                </tr>
                <tr>
                    <th>特征</th>
                    <th>净重</th>
                    <th>箱数</th>
                    <th>重量kg</th>
                    <th>特征</th>
                    <th>净重</th>
                    <th>箱数(必填)</th>
                    <th>重量kg</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>鸭产品</td>
                    <td>分割品</td>
                    <td>带皮鸭胸</td>
                    <td>201606120004</td>
                    <td>220-240g</td>
                    <td>10kg</td>
                    <td>20</td>
                    <td>10kg*20</td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td>
                        <a class="cellButton detail" title="标签打印" href="javascript:void(0);" col="10"><img src="/msk-web/static/core/images/action/detail.png"></a>
                    </td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>鸭产品</td>
                    <td>副产品</td>
                    <td>鸭胗</td>
                    <td>201606120004</td>
                    <td>220-240g</td>
                    <td>5kg</td>
                    <td>20</td>
                    <td>10kg*20</td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td>
                        <a class="cellButton detail" title="标签打印" href="javascript:void(0);" col="10"><img src="/msk-web/static/core/images/action/detail.png"></a>
                    </td>
                </tr>
                <tr>
                    <td>3</td>
                    <td>鸭产品</td>
                    <td>分割品</td>
                    <td>鸭锁骨</td>
                    <td>201606120004</td>
                    <td>220-240g</td>
                    <td>10kg</td>
                    <td>20</td>
                    <td>10kg*20</td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td><input style="width:50px" type="text"></td>
                    <td>
                        <a class="cellButton detail" title="标签打印" href="javascript:void(0);" col="10"><img src="/msk-web/static/core/images/action/detail.png"></a>
                    </td>
                </tr>
                <tr>
                    <td colspan="11" align="right">合计:</td>
                    <td colspan="6" align="left"><input type="text" style="width:50px">(箱)</td>
                </tr>
                </tbody>
            </table>
        </div>
    </form>
    <div><msk:button buttonValue="保存" buttonId="TSC20044.SAVE" buttonType="button"/></div>
</div>
<script src="${ctx}/js/ds/TSC20042.js"></script>
