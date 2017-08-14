/**
 * PC端财务人员计费查看JS
 *
 * @author gyh
 */
var $List_Grid;
var PLR170201 = {
    exportButtonId: "PLR170201_EXPORT",
    selectButtonId: "PLR170201_SELECT",
    formId: "plr170201FormId",
    init: function () {
        $List_Grid = $('#plr170201_list_grid').grid({});
        //绑定查询事件
        this.bindSelectButton();
        //绑定下拉事件
        this.changeSelect();
        //日期控件
        this.bindDatePicber('#crtDate');
    },
    bindDatePicber: function (orderTimeId) {
        this.changeDatePicber();
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm',
            changeMonth: true,
            changeYear: true,
            //设置显示格式
            onClose: function (dateText, inst) {
                var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
                var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
                $(this).datepicker('setDate', new Date(year, month, 1));
            }
        });
    },
    // 绑定按钮
    bindSelectButton: function () {
        $("#" + PLR170201.selectButtonId).click(function () {
            $List_Grid.fnDraw();
        });
        $("#" + PLR170201.exportButtonId).click(function () {
            $("#plr170201FormId").attr("action",Main.contextPath+"/PLR170201/exportData");
            $("#plr170201FormId").submit();
            $("#plr170201FormId").attr("action",Main.contextPath+"/PLR170201/search");
        });
    },
    changeSelect: function () {
        var selectRuleObj = $("select[name='selectRule']");
        var partnerIdObj = $("select[name='partnerId']");
        var terminalIdObj = $("select[name='terminalId']");
        var bsCodeObj = $("select[name='bsCode']");
        var terminal_td = $("#terminal_td");
        var bs_td = $("#bs_td");
        partnerIdObj.html('');
        partnerIdObj.append("<option value=''>请选择</option>");
        $('#main-content').postUrl(Main.contextPath + "/PLR170201/findPartner", null, function (data) {
            $.each(data, function (i, item) {
                partnerIdObj.append("<option value='" + item.partnerId + "'>" + item.partnerName + "</option>");
            });
        }, {refreshHtml: false});
        partnerIdObj.change(function () {
            terminalIdObj.html('');
            terminalIdObj.append("<option value=''>请选择</option>");
            $('#main-content').postUrl(Main.contextPath + "/PLR170201/findTerminal", {partnerId: partnerIdObj.val()}, function (data) {
                $.each(data, function (i, item) {
                    terminalIdObj.append("<option value='" + item.terminalId + "'>" + item.terminalName + "</option>");
                });
            }, {refreshHtml: false});
            bsCodeObj.html('');
            bsCodeObj.append("<option value=''>请选择</option>");
            $('#main-content').postUrl(Main.contextPath + "/PLR170201/findBs", {
                partnerId: partnerIdObj.val(),
                terminalId: terminalIdObj.val()
            }, function (data) {
                $.each(data, function (i, item) {
                    bsCodeObj.append("<option value='" + item.bsCode + "'>" + item.bsName + "</option>");
                });
            }, {refreshHtml: false});
        });
        terminalIdObj.change(function () {
            bsCodeObj.html('');
            bsCodeObj.append("<option value=''>请选择</option>");
            $('#main-content').postUrl(Main.contextPath + "/PLR170201/findBs", {
                partnerId: partnerIdObj.val(),
                terminalId: terminalIdObj.val()
            }, function (data) {
                $.each(data, function (i, item) {
                    bsCodeObj.append("<option value='" + item.bsCode + "'>" + item.bsName + "</option>");
                });
            }, {refreshHtml: false});
        });
        selectRuleObj.change(function () {
            var ruleVal = selectRuleObj.val();
            if (ruleVal == 0) {
                terminalIdObj.hide();
                bsCodeObj.hide();
                terminal_td.hide();
                bs_td.hide();
            } else if (ruleVal == 1) {
                terminalIdObj.show();
                bsCodeObj.hide();
                terminal_td.show();
                bs_td.hide();
                terminalIdObj.html('');
                terminalIdObj.append("<option value=''>请选择</option>");
                $('#main-content').postUrl(Main.contextPath + "/PLR170201/findTerminal", {partnerId: partnerIdObj.val()}, function (data) {
                    $.each(data, function (i, item) {
                        terminalIdObj.append("<option value='" + item.terminalId + "'>" + item.terminalName + "</option>");
                    });
                }, {refreshHtml: false});
            } else {
                terminalIdObj.show();
                bsCodeObj.show();
                terminal_td.show();
                bs_td.show();
                bsCodeObj.html('');
                bsCodeObj.append("<option value=''>请选择</option>");
                $('#main-content').postUrl(Main.contextPath + "/PLR170201/findBs", {
                    partnerId: partnerIdObj.val(),
                    terminalId: terminalIdObj.val()
                }, function (data) {
                    $.each(data, function (i, item) {
                        bsCodeObj.append("<option value='" + item.bsCode + "'>" + item.bsName + "</option>");
                    });
                }, {refreshHtml: false});
            }

        });

    },
    //日期汉化
    changeDatePicber: function () {
        $.datepicker.regional['zh-CN'] = {
            clearText: '清除',
            clearStatus: '清除已选日期',
            closeText: '关闭',
            closeStatus: '不改变当前选择',
            prevText: '< 上月',
            prevStatus: '显示上月',
            prevBigText: '<<',
            prevBigStatus: '显示上一年',
            nextText: '下月>',
            nextStatus: '显示下月',
            nextBigText: '>>',
            nextBigStatus: '显示下一年',
            currentText: '今天',
            currentStatus: '显示本月',
            monthNames: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            monthNamesShort: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            monthStatus: '选择月份',
            yearStatus: '选择年份',
            weekHeader: '周',
            weekStatus: '年内周次',
            dayNames: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
            dayNamesShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
            dayNamesMin: ['日', '一', '二', '三', '四', '五', '六'],
            dayStatus: '设置 DD 为一周起始',
            dateStatus: '选择 m月 d日, DD',
            dateFormat: 'yy-mm-dd',
            firstDay: 1,
            initStatus: '请选择日期',
            isRTL: false
        };
        $.datepicker.setDefaults($.datepicker.regional['zh-CN']);
    }
};
$(document).ready(function () {
    // 初始化调用
    PLR170201.init();
});
