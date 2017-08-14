<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<div class="group-accordion" collapsible="true" active="true">
    <h3>
        <label>交易成功</label>
    </h3>

    <div>
        <div>
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <tr align="center" style="background:#DBDBDB">
                    <th coltype="text" width="12%" name="type">类型</th>
                    <th coltype="text" width="12%" name="name">消费名称</th>
                    <th coltype="text" width="12%" name="price">实付金额</th>
                    <th coltype="text" width="12%" name="discount">优惠</th>
                    <th coltype="text" width="12%" name="coupon">优惠券</th>
                    <th coltype="text" width="12%" name="serviceCharge">服务费</th>
                    <th coltype="text" name="total">总额(元)</th>
                </tr>
                <tr align="center">
                    <td coltype="text" height="50px" name="">${SO153203Bean.type}</td>
                    <td coltype="text" height="50px" name="">${SO153203Bean.name}</td>
                    <td coltype="text" height="50px" name="">${SO153203Bean.price}</td>
                    <td coltype="text" height="50px" name="">${SO153203Bean.discount}</td>
                    <td coltype="text" height="50px" name="">${SO153203Bean.coupon}</td>
                    <td coltype="text" height="50px" name="">${SO153203Bean.serviceCharge}</td>
                    <td coltype="text" height="50px" name="">${SO153203Bean.total}</td>
                </tr>
            </table>
        </div>
    </div>
</div>



<div class="group-accordion" collapsible="true" active="true">
    <h3>
        <label>交易描述</label>
    </h3>

    <div>
        <div>
            <table class="tree dataTable no-footer" style="widtd: 100%">
                <tr align="center" style="background:#DBDBDB">
                    <th coltype="text" width="12%" name="type">描述</th>
                    <th coltype="text" width="12%" name="name">对方信息</th>
                    <th coltype="text" width="12%" name="price">创建时间</th>
                    <th coltype="text" width="12%" name="price">付款时间</th>
                    <th coltype="text" width="12%" name="price">结束时间</th>
                </tr>
                <tr align="center">
                    <td coltype="text" height="50px" name="">神龙客</td>
                    <td coltype="text" height="50px" name="">神龙客有限公司 ton***@diditaxi.com.cn</td>
                    <td coltype="text" height="50px" name="">2016.01.25 10:03:38</td>
                    <td coltype="text" height="50px" name="">2016.01.25 10:03:39</td>
                    <td coltype="text" height="50px" name="">2016.02.25 10:03:39</td>
                </tr>
            </table>
        </div>
    </div>
</div>