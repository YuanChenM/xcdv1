var $List_Grid;
var SO151406 = {
    searchButtonId: "SO151406_SEARCH",
    formId: "SO151406Form",
    init: function () {
        $List_Grid = $('#SO151406_list_grid').grid({
            linkHandler: SO151406.linkHandler
        });
        this.bindDatePicber('#startTime');
        this.bindDatePicber('#endTime');
        SO151406.closeDate();
        //Delete for Bug#3766 at 2016/11/21 by sun_jiaju Start
        //FormUtils.init(SO151406.formId, "SO251106");
        //Delete for Bug#3766 at 2016/11/21 by sun_jiaju End
        this.bindSearchButton();
        this.enterSearchData();
    },
    bindDatePicber : function(orderTimeId){
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            closeText: 'Clear'
        });
    },
    closeDate : function(){
        $(document).on("click","button.ui-datepicker-close",function(){
            $.datepicker._clearDate($.datepicker._curInst.input);
        });
    },
    // 绑定按钮
    bindSearchButton: function () {
        $("#" + SO151406.searchButtonId).click(function () {
            FormUtils.setFormValue(SO151406.formId, "SO251106");
            $List_Grid.fnDraw()
        });
    },
    enterSearchData:function(){
        //绑定回车键
        document.onkeydown=function enterDown(e){
            //兼容火狐,chrome和ie的事件对象
            e = e||event;

            if(e.keyCode == 13) {
                FormUtils.setFormValue(SO151406.formId, "SO251106");
                $List_Grid.fnDraw()
            }
            return;
        }
    },
    linkHandler: function (rowdata, colname, row, col) {
        if (colname == "returnCode") {
            var data = new Object();
            data['orderId'] = rowdata.orderId;
            Main.detailWindow(Main.contextPath + "/SO151407/init/"+rowdata.returnId, data, "退货单详情");
        }
        if (colname == "orderCode") {
            var data = new Object();
            data['enterMark'] = "return";
            Main.detailWindow(Main.contextPath + "/SO151402/init/"+rowdata.orderId, data, "订单详情");
        }
    }
}

$(document).ready(function () {
    // 初始化调用
    SO151406.init();
});
