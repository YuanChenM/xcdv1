/**
 * 买家交易记录
 *
 */
var $List_Grid;
$(function () {
    $("#tabs").tabs();
});
var SO153101 = {
    SO153101Grid: null,
    searchButtonId: "SO153101_SEARCH",
    formId: "SO153101Form",
    orderTimeStart: "#orderTimeStart",
    orderTimeEnd: "#orderTimeEnd",
    init: function () {
        this.searchData();
        $List_Grid = $('#SO153101_list_grid').grid({
            actionHandler: SO153101.actionHandler,
            linkHandler: SO153101.linkHandler
        });
        this.bindDatePicber(SO153101.orderTimeStart);
        this.bindDatePicber(SO153101.orderTimeEnd);

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
        $("#" + SO153101.searchButtonId).click(function () {

            FormUtils.setFormValue(SO153101.formId, "SO153101");

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
            $('#main-content').postUrl(Main.contextPath + "/SO153102/init/",{orderCode:rowdata.orderCode});
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    SO153101.init();
    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
