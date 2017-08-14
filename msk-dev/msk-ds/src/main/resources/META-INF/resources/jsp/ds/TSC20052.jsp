<%-- 
    Title:OEM供应商对账单
    author:xhy
    createDate:2016-6-12
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<navigation:header title="发货差异单详细" backTitleArray="生产商发货差异单管理" backUrlArray="${ctx}/TSC20051/init"></navigation:header>
<div class="page-content detail-page">
    <div>
        <table width="100%">
            <tr>
                <td align="right" width="40px">购货单位:</td>
                <td align="left" width="8px">
                    <input type="text" value="上海浦东金枝禽类有限公司"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="40px">订单执行人:</td>
                <td align="left" width="8px">
                    <input type="text" value="赵金龙"/>
                </td>
                <td align="right" width="40px">对账执行人:</td>
                <td align="left" width="8px">
                    <input type="text" value="崔小明"/>
                </td>
                <td align="right" width="40px">对账审核人:</td>
                <td align="left" width="8px">
                    <input type="text" value="孙瑶"/>
                </td>
            </tr>
        </table>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>OEM供应商基本信息：</label>
        </h3>
        <table width="100%">
            <tr>
                <td align="right" width="35px">供应商编码:</td>
                <td align="left" width="8px">
                    <input type="text" value="2546845245"/>
                </td>
                <td align="right" width="35px">对账期间:</td>
                <td align="left" width="8px">
                    <input type="text" name="corresponding" value="2016-4-21"/> ~ <input type="text" name="corresponding" value="2016-4-25"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="35px">供应商名称:</td>
                <td align="left" width="8px">
                    <input type="text" value="山东荣达农业发展有限公司"/>
                </td>
                <td align="right" width="35px">地址:</td>
                <td align="left" width="8px">
                    <input type="text" value="山东万鑫市的范德萨路15号"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="35px">对账联系人:</td>
                <td align="left" width="8px">
                    <input type="text" value="宏康"/>
                </td>
                <td align="right" width="35px">对账联系人电话:</td>
                <td align="left">
                    <input type="text" value="18365478524"/>
                </td>
            </tr>
            <tr>
                <td align="right" width="35px">财务联系人:</td>
                <td align="left" width="8px">
                    <input type="text" value="郎壮"/>
                </td>
                <td align="right" width="35px">财务联系人电话:</td>
                <td align="left" width="8px">
                    <input type="text" value="18565845632"/>
                </td>
            </tr>
        </table>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>对账业务信息：</label>
        </h3>

        <div>
            <table width="100%" class="tree dataTable no-footer" width="auto">
                <tr>
                    <td style="text-align: left" colspan="18">　采购订单号　:　2565479841654</td>
                </tr>
                <tr style="background:#DBDBDB">
                    <td align="center" rowspan="2">发货日期</td>
                    <td align="center" rowspan="2">发货订单号</td>
                    <td align="center" rowspan="2">一级分类</td>
                    <td align="center" rowspan="2">二级分类</td>
                    <td align="center" rowspan="2">品种</td>
                    <td align="center" rowspan="2">特征</td>
                    <td align="center" rowspan="2">产品标准代码</td>
                    <td align="center" rowspan="2">计量单位</td>
                    <td align="center" rowspan="2">执行价格(元)</td>
                    <td align="center" colspan="4">数量(箱)</td>
                    <td align="center" colspan="2">金额(元)</td>
                    <td align="center" colspan="2">对账结果</td>
                    <td align="center" rowspan="2">备注</td>
                </tr>
                <tr style="background:#DBDBDB">
                    <td align="center">发货数量(箱)</td>
                    <td align="center">入库数量(箱)</td>
                    <td align="center">补货数量(箱)</td>
                    <td align="center">退货数量(箱)</td>
                    <td align="center">已付金额(元)</td>
                    <td align="center">应付金额(元)</td>
                    <td align="center">数量（短缺为“-”）(箱)</td>
                    <td align="center">金额（多付为“-”）(元)</td>
                </tr>
                    <tr>
                        <td>2016-4-11</td>
                        <td>FH20160607001001</td>
                        <td>鸭产品</td>
                        <td>分割品</td>
                        <td>带皮鸭胸</td>
                        <td>220-240g</td>
                        <td>0220102022</td>
                        <td>箱</td>
                        <td>10.00</td>
                        <td>100</td>
                        <td>100</td>
                        <td>0</td>
                        <td>0</td>
                        <td>100.00</td>
                        <td>1000.00</td>
                        <td>100.00</td>
                        <td>1000.00</td>
                        <td>质量合格,金额全付款</td>
                    </tr>

                <tr>
                    <td>2016-4-11</td>
                    <td>FH20160607001001</td>
                    <td>鸭产品</td>
                    <td>副产品</td>
                    <td>鸭胗</td>
                    <td>220-240g</td>
                    <td>0220102023</td>
                    <td>箱</td>
                    <td>10.00</td>
                    <td>100</td>
                    <td>100</td>
                    <td>0</td>
                    <td>0</td>
                    <td>100.00</td>
                    <td>1000.00</td>
                    <td>100.00</td>
                    <td>1000.00</td>
                    <td>质量合格,金额全付款</td>
                </tr>

                <tr>
                    <td>2016-4-11</td>
                    <td>FH20160607001001</td>
                    <td>鸭产品</td>
                    <td>分割品</td>
                    <td>鸭锁骨</td>
                    <td>220-240g</td>
                    <td>0220102024</td>
                    <td>箱</td>
                    <td>10.00</td>
                    <td>100</td>
                    <td>100</td>
                    <td>0</td>
                    <td>0</td>
                    <td>100.00</td>
                    <td>1000.00</td>
                    <td>100.00</td>
                    <td>1000.00</td>
                    <td>质量合格,金额全付款</td>
                </tr>

                <tr>
                    <td style="text-align: right" colspan="18">总计箱数:300箱　　总计金额　: 3000.00元</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="group-accordion" collapsible="true" active="true">
        <h3>
            <label>包材库存对账信息：</label>
        </h3>

        <div>
            <table width="100%" class="tree dataTable no-footer" width="auto">
                <tr style="background:#DBDBDB">
                    <td align="center">包材类别</td>
                    <td align="center">发货数量(箱)</td>
                    <td align="center">使用数量(箱)</td>
                    <td align="center">库存数量(箱)</td>
                    <td align="center">对账结果（短缺为“-”）(箱)</td>
                </tr>
                <c:forEach items="${listData}" begin="1" end="1"  varStatus="i" >
                    <tr>
                        <td>纸箱类（按尺寸填写）</td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="-"></td>
                    </tr>
                    <tr>
                        <td>内袋类（按尺寸填写）</td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="-"></td>
                    </tr>
                    <tr>
                        <td>外包装标签类（按产品填写）</td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="-"></td>
                    </tr>
                    <tr>
                        <td>内袋标签类（按产品填写）</td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="-"></td>
                    </tr>
                    <tr>
                        <td>封箱胶带类（按颜色填写）</td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="100"></td>
                        <td><input type="text" value="-"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="group-accordion" collapsible="false" active="false">
        <h3>
            <label>确认结果信息：</label>
        </h3>
    <div>
        <P>(1)累计数量为:<input type="text" value="100"/> ，差异（短缺为负数）：<input type="text" value="-"/></P>
        <p>(2)累计金额为： ￥  <input type="text" value="1000"/>元 ，差异（多付为负数）：<input type="text" value="-"/> 元。</p>
        <p>(3)累计应开发票金额: <input type="text" value="1000"/> 元  。</p>
        <p>(4)对账差异处理方案：<textarea>找负责人</textarea></p>
    </div>
    </div>
    <div>
        <msk:button buttonValue="保存" buttonId="PD14112405.SAVE" buttonType="button"/>
    </div>
</div>
<script src="${ctx}/js/ds/TSC20052.js"></script>