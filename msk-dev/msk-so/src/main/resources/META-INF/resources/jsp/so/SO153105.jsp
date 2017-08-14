<%-- 
    Title:买家-电子对账单-收入
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/comm/taglib.jsp" %>
<link rel="stylesheet" href="${ctx}/static/treegrid/css/jquery.treegrid.css">
<script type="text/javascript" src="${ctx}/static/treegrid/js/jquery.treegrid.js"></script>
<script type="text/javascript" src="${ctx}/static/js/core/ichart.1.2.min.js"></script>
<script>
    $(function(){
        var data = [
            {name : '鸡类',value : 30,color:'#fedd74'},
            {name : '鸭类',value : 25,color:'#82d8ef'},
            {name : '鹅类',value : 15,color:'#f76864'}
        ];

        var chart = new iChart.Donut2D({
            render : 'canvasDiv',
            center:{
                shadow:true,
                shadow_offsetx:0,
                shadow_offsety:2,
                shadow_blur:2,
                shadow_color:'#b7b7b7',
                color:'#6f6f6f'
            },
            data: data,
            offsetx:-60,
            shadow:true,
            background_color:'#f4f4f4',
            separate_angle:10,//分离角度
            tip:{
                enable:true,
                showType:'fixed'
            },
            legend : {
                enable : true,
                shadow:true,
                background_color:null,
                border:false,
                legend_space:30,//图例间距
                line_height:34,//设置行高
                sign_space:10,//小图标与文本间距
                sign_size:30,//小图标大小
                color:'#6f6f6f',
                fontsize:30,//文本大小
                listeners:{
                    click:function(l,e,m){

                    }
                }
            },
            sub_option:{
                label:false,
                color_factor : 0.3
            },
            showpercent:true,
            decimalsnum:2,
            width : 800,
            height : 400,
            radius:140
        });

        /**
         *利用自定义组件构造左侧说明文本。
         */
        chart.plugin(new iChart.Custom({
            drawFn:function(){
                /**
                 *计算位置
                 */
                var y = chart.get('originy');
                /**
                 *在左侧的位置，设置竖排模式渲染文字。
                 */
                chart.target.textAlign('center')
                        .textBaseline('middle')
                        .textFont('600 24px 微软雅黑')
                        .fillText('收入比例',100,y,false,'#6d869f', 'tb',26,false,0,'middle');

            }
        }));

        chart.draw();
    });

</script>
<div class="group-accordion" active="true">
    <h3>
        <label>买家-电子对账单-收入</label>
    </h3>
    <div>
        <div id='canvasDiv' style="float:left;width: 50%"></div>
        <div style="float:left;width: 50%">
        <table class="tree dataTable no-footer" style="width: 100%">
            <tr style="background:#DBDBDB">
                <td>名称</td>
                <td>金额</td>
                <td>备注</td>
            </tr>
            <c:forEach items="${list}" var="list" varStatus="j">
                <tr class="treegrid-${j.index}">
                    <td name="listName" value="${list.name}">${list.name}</td>
                    <td>${list.price}</td>
                    <td>${list.remarks}</td>
                </tr>
                <c:if test="${list.sO153105InfoBean.size() gt 0}">
                    <c:forEach items="${list.sO153105InfoBean}" var="sO153105InfoBean" varStatus="i">
                        <tr class="treegrid-${j.index}-${i.index+1} treegrid-parent-${j.index}">
                            <td name="sO153105InfoBeanName"
                                value="${sO153105InfoBean.name}">${sO153105InfoBean.name}</td>
                            <td>${sO153105InfoBean.price}</td>
                            <td>${sO153105InfoBean.remarks}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </c:forEach>
        </table>
        </div>
    </div>
</div>
<script src="${ctx}/js/so/SO153105.js"></script>
