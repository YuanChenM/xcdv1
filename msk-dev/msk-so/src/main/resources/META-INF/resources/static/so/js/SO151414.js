/**
 * 发货单列表JS
 *
 * @author rwf
 */
var $List_Grid;
var SO151414 = {
    searchButtonId: "SO151414_SEARCH",
    formId: "SO151414Form",
    shipTimeStart: "#shipTimeStart",
    shipTimeEnd: "#shipTimeEnd",
    init: function () {
        $List_Grid = $('#SO151414_list_grid').grid({});
        this.bindDatePicber(SO151414.shipTimeStart);
        this.bindDatePicber(SO151414.shipTimeEnd);
        SO151414.closeDate();
        this.bindSearchButton();
        this.save();
    },
    bindDatePicber: function (orderTimeId) {
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
            closeText: 'Clear'
        });
    },
    closeDate: function () {
        $(document).on("click", "button.ui-datepicker-close", function () {
            $.datepicker._clearDate($.datepicker._curInst.input);
        });
    },
    // 绑定按钮
    bindSearchButton: function () {
        $("#" + SO151414.searchButtonId).click(function () {
            FormUtils.setFormValue(SO151414.formId, "SO151414");
            $List_Grid.fnDraw()
        });
    },
    save: function () {
        $("#SO151414_SAVE").click(function () {
            if ($('#whCode').val() == "") {
                $.alertMessage.info("请设定发货仓库！");
                return;
            }
            var selectList = $List_Grid.getChoiceData();
            if (selectList.length == 0) {
                $.alertMessage.info("请选择发货单！");
                return;
            }
            var json = {};// 创建json 对象
            var i = 0;
            var flg = false;
            $.each(selectList, function (index, context) {
                var shipStatusName = context["shipStatusName"];
                if (!(shipStatusName == "待分配仓库" || shipStatusName == "待传递WMS")) {
                    $.alertMessage.info("请对发货单状态为待分配仓库或待传递WMS的发货单设定发货仓库！");
                    flg = true;
                    return;
                }
                json[i] = {"shipId": context["shipId"]};
                i++;
            });
            if (flg) {
                return;
            }
            var jsonStr = JSON.stringify(json);
            $('#main-content').postUrl(Main.contextPath + "/SO151414/save", {
                "jsonStr": jsonStr,
                "whCode": $('#whCode').val()
            });
        });
    }
}

$(function () {
    // 初始化调用
    SO151414.init();
});
