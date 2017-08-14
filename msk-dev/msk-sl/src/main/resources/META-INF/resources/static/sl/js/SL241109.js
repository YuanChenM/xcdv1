/**
 * 分销章程列表JS
 *
 * @author rwf
 */
var $List_Grid;
var SL241109 = {
    previewButtonId: "SL241109_PREVIEW",
    newButtonId: "SL241109_ADD",
    listButtonId:"SL241109_LIST",
    init: function () {
        $List_Grid = $('#sl241109_list_grid').grid({
            actionHandler: SL241109.actionHandler
        });
        this.bindButton();
    },
    actionHandler: function (rowdata, coltype, row, col) {
        //** 操作按钮 *//*
        if (coltype == "edit") {
            $.pdialog.open("章节数据编辑", Main.contextPath + "/SL241111/init/"+chapClass, {
                resizable: false,
                width: 700,
                height: 600
            }, {chapId: rowdata.chapId});
        }
        if (coltype == "check") {
            $('#main-content').postUrl(Main.contextPath + "/SL241110/init/"+rowdata.chapId+"/"+rowdata.chapNo+"/"+chapClass);
        }

    },
    bindButton: function () {
        $('#' + SL241109.previewButtonId).click(function () {
            $('#main-content').postUrl(Main.contextPath + "/SL241113/init/"+chapClass);
        });
        $("#" + SL241109.newButtonId).click(function () {
            SL241109.newData();
        });
        $("#" + SL241109.listButtonId).click(function () {
            SL241109.listDate();
        });
    },
    newData: function () {
        $.pdialog.open("章节新增信息详情", Main.contextPath + "/SL241111/init/"+chapClass, {
        width: 700,
        height: 600
    });
},
    listDate: function () {
        $('#main-content').postUrl(Main.contextPath + "/SL241120/init/"+chapClass);
    }
}
$(document).ready(function () {
    // 初始化调用
    SL241109.init();
});
