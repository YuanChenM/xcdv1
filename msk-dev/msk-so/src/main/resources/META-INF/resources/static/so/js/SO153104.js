var SO153104 = {
    chart: null,
    init: function () {
        //$('.tree').treegrid();
        //$("#SO153105Id").postUrl(Main.contextPath+"/SO153105/init/");
    },
    initTabs: function () {
        $("#tabs").tabs({
        });
        $('#tabs').click(function(event, ui) {
            //重新刷新Accordion高度
            $(".group-accordion").accordion("refresh");
        });


    },
    initDonut2D: function (divId) {
        var data = [
            {name: '鸡类', value: 40.0, color: '#4572a7'},
            {name: '鸭类', value: 37.1, color: '#aa4643'},
            {name: '鹅类', value: 13.8, color: '#89a54e'},
            {name: '牛类', value: 1.6, color: '#80699b'},
            {name: '羊类', value: 1.4, color: '#92a8cd'},
            {name: '鱼类', value: 1.2, color: '#db843d'},
            {name: '其他', value: 4.9, color: '#a47d7c'}
        ];
        var chart = new iChart.Pie3D({
            render: divId,
            data: data,
            title: {
                text: '支出比例',
                color: '#3e576f'
            },
            sub_option: {
                label: {
                    background_color: null,
                    sign: false,//设置禁用label的小图标
                    padding: '0 4',
                    border: {
                        enable: false,
                        color: '#be5985'
                    },
                    fontsize: 11,
                    fontweight: 600,
                    color: '#be5985'
                },
                border: {
                    width: 2,
                    color: '#ffffff'
                },
                listeners: {
                    /**
                     * r:iChart.Rectangle2D对象
                     * e:eventObject对象
                     * m:额外参数
                     */
                    click: function (r, e, m) {
                        //TODO 重新刷新数据
                        var name = r.get("name");
                        //alert(name);
                        if(name == "鸭类"){
                            $("#detailInfo").html("<tr><td>鸭掌</td><td>1200.00</td><td>10%</td><td>冷冻</td></tr><tr><td>鸭块</td><td>100.00</td><td>17.1%</td><td>新鲜</td></tr><tr><td>鸭翅</td><td>1800.00</td><td>10%</td><td>冷冻</td></tr>");
                            $("#detailInfo1").html("<tr><td>鸭掌</td><td>1200.00</td><td>10%</td><td>冷冻</td></tr><tr><td>鸭块</td><td>100.00</td><td>17.1%</td><td>新鲜</td></tr><tr><td>鸭翅</td><td>1800.00</td><td>10%</td><td>冷冻</td></tr>");
                        }else if(name == "鹅类"){
                            $("#detailInfo").html("<tr><td>鹅掌</td><td>200.00</td><td>5%</td><td>冷冻</td></tr><tr><td>鹅块</td><td>100.00</td><td>3%</td><td>新鲜</td></tr><tr><td>鹅翅</td><td>1800.00</td><td>5%</td><td>冷冻</td></tr>");
                            $("#detailInfo1").html("<tr><td>鹅掌</td><td>200.00</td><td>5%</td><td>冷冻</td></tr><tr><td>鹅块</td><td>100.00</td><td>3%</td><td>新鲜</td></tr><tr><td>鹅翅</td><td>1800.00</td><td>5%</td><td>冷冻</td></tr>");
                        }else if(name == "鸡类"){
                            $("#detailInfo").html("<tr><td>鸡爪</td><td>500.00</td><td>10%</td><td>冷冻</td></tr><tr><td>鸡块</td><td>100.00</td><td>20%</td><td>新鲜</td></tr><tr><td>鸭翅</td><td>800.00</td><td>10%</td><td>冷冻</td></tr>");
                            $("#detailInfo1").html("<tr><td>鸡爪</td><td>500.00</td><td>10%</td><td>冷冻</td></tr><tr><td>鸡块</td><td>100.00</td><td>20%</td><td>新鲜</td></tr><tr><td>鸭翅</td><td>800.00</td><td>10%</td><td>冷冻</td></tr>");
                        }else{
                            $("#detailInfo").html("");
                            $("#detailInfo1").html("");
                        }
                    }
                }
            },
            shadow: true,
            shadow_blur: 6,
            shadow_color: '#aaaaaa',
            shadow_offsetx: 0,
            shadow_offsety: 0,
            background_color: '#fefefe',
            yHeight: 20,//饼图厚度
            offset_angle: 0,//逆时针偏移120度
            mutex: true,//只允许一个扇形弹出
            showpercent: true,
            decimalsnum: 2,
            width: 550,
            height: 400,
            radius: 150
        });
        chart.draw();
    }

}
$(document).ready(function () {
    // 初始化调用
    SO153104.init();
    SO153104.initTabs();
    SO153104.initDonut2D("canvasDiv");
    SO153104.initDonut2D("income");
});
