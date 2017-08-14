/**
 * 卖家交易记录
 *
 */
var $List_Grid;
$(function () {
    $("#tabs").tabs();
});
var SO153201 = {
    SO153201Grid: null,
    searchButtonId: "SO153201_SEARCH",
    formId: "SO153201Form",
    orderTimeStart: "#orderTimeStart",
    orderTimeEnd: "#orderTimeEnd",
    init: function () {
        this.searchData();
        $List_Grid = $('#SO153201_list_grid').grid({
            actionHandler: SO153201.actionHandler,
            linkHandler: SO153201.linkHandler
        });
        this.bindDatePicber(SO153201.orderTimeStart);
        this.bindDatePicber(SO153201.orderTimeEnd);

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
        $("#" + SO153201.searchButtonId).click(function () {
            FormUtils.setFormValue(SO153201.formId, "SO153201");

            /*formData = getFormData($("#" + SO153201.formId));
            $('#main-content').postUrl(Main.contextPath + "/SO153201/init/", formData);
             $('#main-content').postUrl(Main.contextPath + "/SO153201/init/",formData,function() {
             },{refreshHtml:false})*/
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
            //formData=getFormData($("#"+SO153201.formId));
            //$('#main-content').postUrl(Main.contextPath + "/SO153301/init/");
            $('#main-content').postUrl(Main.contextPath + "/SO153202/init/",{orderCode:rowdata.orderCode});
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    SO153201.init();
    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
