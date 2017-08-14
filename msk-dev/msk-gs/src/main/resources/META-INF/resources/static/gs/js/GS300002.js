/**
 * 报表
 *
 * @author gyh
 */
var $List_Grid;
var GS300001 = {
    init: function () {
        $('#headBreadCrumb').remove();
        this.showHightChart();
    },
    showHightChart: function () {
        Highcharts.setOptions({
            lang: {
                printChart: "打印图表",
                downloadJPEG: "下载JPEG 图片",
                downloadPDF: "下载PDF文档",
                downloadPNG: "下载PNG 图片",
                downloadSVG: "下载SVG 矢量图",
                exportButtonTitle: "导出图片",
                numericSymbols:null,//千分位
                thousandsSep:''//千分位的格式
            }
        });
        $('#container').highcharts({
            credits: {
                enabled: false//去水印
            },
            exporting: {
                enabled: true
            },
            title: {
                text: '三黄土鸡销量趋势图'
            },
            xAxis: {
                categories: ['80-100g 100-120g 130-150g<br/>7.6', '80-100g 100-120g 130-150g<br/>7.7', '80-100g 100-120g 130-150g<br/>7.8', '80-100g 100-120g 130-150g<br/>7.9', '80-100g 100-120g 130-150g<br/>7.10']
            },
            yAxis: [{
                min: 0,
                lineWidth: 1,
                tickPositions: [6, 14],
                gridLineWidth: 0,
                title: {
                    text: '元/公斤'
                },
                stackLabels: {
                    enabled: true,
                    style: {
                        'font-size': '10px',
                        fontWeight: 'lighter',
                        color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                    }
                }
            }, {
                min: 0,
                lineWidth: 1,
                gridLineWidth: 0,
                tickPositions: [0, 15000, 30000],
                title: {
                    text: '销售量 箱'
                },
                opposite: true,
                stackLabels: {
                    enabled: true,
                    style: {
                        fontWeight: 'normal',
                        'font-size': '10px',
                        color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
                    }
                }
            }],
            legend: {
                align: 'right',
                x: 0,
                verticalAlign: 'bottom',
                y: 0,
                floating: false,
                backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid) || 'white',
                borderColor: '#CCC',
                borderWidth: 1,
                shadow: false
            },
            tooltip: {
                formatter: function (thi) {
                    if(this.series.name=='大额通道'||this.series.name=='大宗通道'||this.series.name=='标准通道'){
                        return this.series.name + ': <br/>最高价:' + this.series.dataMax + '<br/>最低价:' + this.series.dataMin;
                    }
                    return this.series.name + ': ' + this.y + '<br/>';
                }
            },
            plotOptions: {
                column: {
                    stacking: 'normal',
                    dataLabels: {
                        enabled: true
                        //color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white'
                    },
                    events: {
                        mouseOver: function (thi) {
                            var chart = $('#container').highcharts();
                            if (thi.target.columnIndex == 0) {
                                chart.series[12].setData([11.5, 11.8, 12, 12.2, 11.9]);
                                chart.series[13].setData([12.5, 12.7, 12.5, 12.3, 12.5]);
                                chart.series[14].setData([11.2, 11.5, 11.8, 12.2, 12]);
                                chart.series[15].setData([8.36, 8.36, 8.36, 8.36, 8.36]);
                                chart.series[16].setData([8.55, 8.55, 8.55, 8.55, 8.55]);
                                chart.series[17].setData([8.47, 8.47, 8.47, 8.47, 8.47]);
                                chart.series[18].setData([11.66, 11.58, 11.63, 11.74, 11.82]);
                            } else if (thi.target.columnIndex == 1) {
                                chart.series[12].setData([11.9, 12, 13, 12.5, 12.9]);
                                chart.series[13].setData([13, 13, 12.7, 13.3, 12.5]);
                                chart.series[14].setData([11.7, 11.9, 12.1, 12.9, 13]);
                                chart.series[15].setData([8.66, 8.96, 9.1, 8.9, 9.4]);
                                chart.series[16].setData([8.65, 8.55, 8.65, 8.65, 8.65]);
                                chart.series[17].setData([8.49, 8.49, 8.49, 8.49, 8.49]);
                                chart.series[18].setData([11.96, 11.88, 11.73, 11.94, 11.92]);
                            } else if (thi.target.columnIndex == 2) {
                                chart.series[12].setData([12, 12.8, 13, 12.8, 13.0]);
                                chart.series[13].setData([13.2, 12.7, 13.1, 13, 12.8]);
                                chart.series[14].setData([12.2, 12.1, 13.1, 13.2, 13]);
                                chart.series[15].setData([9.0, 9.3,9.22, 8.9, 9.05]);
                                chart.series[16].setData([8.65, 8.65, 8.65, 8.65, 8.65]);
                                chart.series[17].setData([8.5, 8.5, 8.5, 8.5, 8.5]);
                                chart.series[18].setData([11.96, 11.88, 11.93, 11.94, 12]);
                            }
                        },
                        //mouseOut: function () {
                        //    $report.html('Moused out')
                        //        .css('color', 'red');
                        //}
                    }
                },
                line: {
                    dataLabels: {
                        enabled: true,
                        color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'gray'
                    }
                }
            },
            series: [{
                name: "80-100g大宗",
                type: 'column',
                yAxis: 1,
                stack: '80-100g',
                data: [3143.00, 2287.00, 2444.00, 2601.00, 2758.00],
                color: '#BCD2EE'
            }, {
                name: "80-100g大额",
                type: 'column',
                stack: '80-100g',
                yAxis: 1,
                data: [2143.00, 2287.00, 2444.00, 2601.00, 2758.00],
                color: '#B4EEB4'
            }, {
                name: "80-100g标准",
                type: 'column',
                stack: '80-100g',
                yAxis: 1,
                data: [2043.00, 2687.00, 2844.00, 2401.00, 2058.00],
            }, {
                name: "100-120g大宗",
                type: 'column',
                yAxis: 1,
                stack: '100-120g',
                data: [2143.00, 2257.00, 1444.00, 2641.00, 1758.00],
                color: '#BCD2EE'
            }, {
                name: "100-120g大额",
                type: 'column',
                stack: '100-120g',
                yAxis: 1,
                data: [2143.00, 3287.00, 2114.00, 1601.00, 3758.00],
                color: '#B4EEB4'
            }, {
                name: "100-120g标准",
                type: 'column',
                stack: '100-120g',
                yAxis: 1,
                data: [2243.00, 1487.00, 1114.00, 2301.00, 1158.00],
                color: '#00B2EE'
            }, {
                name: "130-150g大宗",
                type: 'column',
                yAxis: 1,
                stack: '130-150g',
                data: [2143.00, 3257.00, 2444.00, 1641.00, 2758.00],
                color: '#BCD2EE'
            }, {
                name: "130-150g大额",
                type: 'column',
                stack: '130-150g',
                yAxis: 1,
                data: [1943.00, 2287.00, 2674.00, 3401.00, 2158.00],
                color: '#B4EEB4'
            }, {
                name: "130-150g标准",
                type: 'column',
                stack: '130-150g',
                yAxis: 1,
                data: [1543.00, 2387.00, 1114.00, 1501.00, 1358.00],
                color: '#00B2EE'
            },
                {
                    name: '大宗通道',
                    yAxis: 0,
                    data: [
                        [10.05, 11.05],
                        [10.05, 11.05],
                        [10.05, 11.05],
                        [10.05, 11.05],
                        [10.05, 11.05]
                    ],
                    type: 'arearange',
                    color: '#BCD2EE'
                }, {
                    name: '大额通道',
                    yAxis: 0,
                    data: [
                        [11.20, 11.83],
                        [11.20, 11.83],
                        [11.20, 11.83],
                        [11.20, 11.83],
                        [11.20, 11.83]
                    ],
                    type: 'arearange',
                    color: '#B4EEB4'
                }, {
                    name: '标准通道',
                    yAxis: 0,
                    data: [
                        [11.93, 12.12],
                        [11.93, 12.12],
                        [11.93, 12.12],
                        [11.93, 12.12],
                        [11.93, 12.12]
                    ],
                    type: 'arearange',
                    color: '#00B2EE'
                }, {
                    name: '买卖肉',
                    dashStyle: 'dash',
                    yAxis: 0,
                    type: 'line',
                    data: [11.5, 11.8, 12, 12.2, 11.9]
                }, {
                    name: '华禽网',
                    yAxis: 0,
                    type: 'line',
                    dashStyle: 'dash',//设置为虚线
                    data: [12.5, 12.7, 12.5, 12.3, 12.5]
                }, {
                    name: '天环城',
                    dashStyle: 'dash',
                    yAxis: 0,
                    type: 'line',
                    data: [11.2, 11.5, 11.8, 12.2, 12]
                }, {
                    name: '圣龙',
                    yAxis: 0,
                    type: 'line',
                    data: [8.36, 8.36, 8.36, 8.36, 8.36]
                }, {
                    name: '荣达',
                    type: 'line',
                    yAxis: 0,
                    data: [8.55, 8.55, 8.55, 8.55, 8.55]
                }, {
                    name: '华康',
                    type: 'line',
                    yAxis: 0,
                    data: [8.47, 8.47, 8.47, 8.47, 8.47]
                }, {
                    name: '销售加均价',
                    yAxis: 0,
                    type: 'line',
                    data: [11.66, 11.58, 11.63, 11.74, 11.82]
                }
            ]
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    GS300001.init();
});
