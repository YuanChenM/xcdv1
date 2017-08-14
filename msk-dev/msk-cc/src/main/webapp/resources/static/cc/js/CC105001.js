/**
 * 回访清单
 *
 */
var $List_Grid;
$(function () {
    $("#tabs").tabs();
});
var CC105001 = {
    CC105001Grid: null,
    searchButtonId: "CC105001_SEARCH",
    formId: "CC105001Form",
    //orderTimeStart: "#orderTimeStart",
    //orderTimeEnd: "#orderTimeEnd",
    init: function () {
        this.searchData();
        $List_Grid = $('#CC105001_list_grid').grid({
            actionHandler: CC105001.actionHandler
        });
        //this.bindDatePicber(CC105001.orderTimeStart);
        //this.bindDatePicber(CC105001.orderTimeEnd);

    },
    //bindDatePicber: function (orderTimeId) {
    //    $(orderTimeId).datepicker({
    //        showButtonPanel: true,
    //        dateFormat: 'yy-mm-dd',
    //        changeMonth: true,
    //        changeYear: true
    //    });
    //},
    searchData: function () {
        $("#" + CC105001.searchButtonId).click(function () {
            FormUtils.setFormValue(CC105001.formId, "CC105001");

            /*formData = getFormData($("#" + CC105001.formId));
             $('#main-content').postUrl(Main.contextPath + "/CC105001/init/", formData);
             $('#main-content').postUrl(Main.contextPath + "/CC105001/init/",formData,function() {
             },{refreshHtml:false})*/
            $List_Grid.fnDraw();

            //if($("#timeType").val() == 1){
            //    $("#tranTime").html("交易时间");
            //}else if($("#timeType").val() == 2){
            //    $("#tranTime").html("创建时间");
            //}

        });
    },

    //linkHandler: function (rowdata, colname, row, col) {
    //    if (colname == "money") {
    //        $.pdialog.open("卖家-支付明细", Main.contextPath + "/CC105002/init/", {
    //            resizable: false,
    //            width: 650,
    //            height: 200
    //        });
    //    }
    //},
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "edit") {
            //formData=getFormData($("#"+CC105001.formId));
            //$('#main-content').postUrl(Main.contextPath + "/SO153301/init/");
            $('#main-content').postUrl(Main.contextPath + "/CC105002/init/",{orderCode:rowdata.orderCode});
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    CC105001.init();
    $.core.sleep(1000);
    $List_Grid.fnDraw();
});
