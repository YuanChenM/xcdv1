/**
 * 买手交易记录
 *
 */
var $List_Grid;
$(function () {
    $("#tabs").tabs();
});
var SO153301 = {
    SO153301Grid: null,
    searchButtonId: "SO153301_SEARCH",
    formId: "SO153301Form",
    orderTimeStart: "#orderTimeStart",
    orderTimeEnd: "#orderTimeEnd",
    init: function () {
        this.searchData();
        $List_Grid = $('#SO153301_list_grid').grid({
            actionHandler: SO153301.actionHandler,
            linkHandler: SO153301.linkHandler
        });
        this.bindDatePicber(SO153301.orderTimeStart);
        this.bindDatePicber(SO153301.orderTimeEnd);

    },
    bindDatePicber: function (orderTimeId) {
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true
        });
    },
    searchData: function () {
        $("#" + SO153301.searchButtonId).click(function () {

            FormUtils.setFormValue(SO153301.formId, "SO153301");

            $List_Grid.fnDraw();

            if($("#timeType").val() == 1){
                $("#tranTime").html("交易时间");
            }else if($("#timeType").val() == 2){
                $("#tranTime").html("创建时间");
            }

        });
    },

    linkHandler: function (rowdata, colname, row, col) {
        if (colname == "money") {
            $.pdialog.open("卖家-支付明细", Main.contextPath + "/SO153202/init/", {
                resizable: false,
                width: 650,
                height: 200
            });
        }
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "edit") {
            //formData=getFormData($("#"+SO151401.formId));
            $('#main-content').postUrl(Main.contextPath + "/SO153302/init/",{orderCode:rowdata.orderCode});
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    SO153301.init();
    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
