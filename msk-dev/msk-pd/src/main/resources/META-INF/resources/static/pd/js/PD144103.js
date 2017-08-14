/**
 * 买手店列表JS
 *
 * @author cx
 */
var $List_Grid;
var PD144103 = {
    formId: "pd144103FormId",
    searchData: "PD144103_SEARCH",
    editButtonId: "PD144103_EDIT",
    newBtnId: "PD144103_NEW",
    saveButton: "PD144103_SAVE",
    init: function () {
        $List_Grid = $('#PD144103_list_grid').grid({
            paginate: false,
            actionHandler: PD144103.actionHandler
        });
        this.queryData();
        this.bindSearchButton();
        this.bindConfirmButton();
        this.bingNewBtn();
        /*    this.bindStartDatePicber('#taxablePeriodBegin');
         this.bindEndDatePicber('#taxablePeriodEnd');*/
    },
    // 绑定按钮
    bindSearchButton: function () {
        $("#" + PD144103.searchData).click(function () {
            FormUtils.setFormValue(PD144103.formId, "PD144103");
            $List_Grid.fnDraw();
        });
    },
    checkIsRepeat: function (arr) {
        var hash = {};
        for (var i in arr) {
            if (hash[arr[i]])
                return true;
            hash[arr[i]] = true;
        }
        return false;
    },
    bindConfirmButton: function () {
        $("#" + PD144103.saveButton).click(function () {
            var changeData = $List_Grid.getChangeData();// 获取改动的数据对象  是数组
            if (changeData.length == 0) {
                $.alertMessage.info("请先编辑要保存的数据！");
                return false;
            }
            var dataList = $List_Grid.fnGetData();
            var sortList = [];
            $.each(dataList, function (i) {
                var sort = dataList[i].sort;
                // 校验序号是否为非零开头的正整数.
                if (!/^\+?[1-9][0-9]*$/.test(sort)) {
                    $.alertMessage.info("请输入非零开头的正整数！");
                    e.preventDefault();
                }
                if (sort > dataList.length) {
                    $.alertMessage.info("排序序号最大为" + dataList.length + "！");
                    e.preventDefault();
                }
                return sortList.push(sort);
            });
            if (PD144103.checkIsRepeat(sortList)) {
                $.alertMessage.info("排序不能重复！");
                return false;
            }
            var json = {};// 创建json 对象
            for (var i in dataList) {//  把数组的对象封装到json
                json[i] = {"id": dataList[i].id, "sort": dataList[i].sort};
            }
            var jsonStr = JSON.stringify(json);//  转成jsonStr
            console.log(jsonStr);
            $('#main-content').postUrl(Main.contextPath + "/PD144103/batchEdit", {"jsonStr": jsonStr}, function (data) {
                FormUtils.setFormValue(PD144103.formId, "PD144103");
                $List_Grid.fnDraw();
            }, {refreshHtml: false});
        })
    },
    actionHandler: function (rowdata, coltype, row, col) {
        /** 操作按钮 */
        if (coltype == "edit") {
            $('#main-content').postUrl(Main.contextPath + "/PD144104/init", {

                id: rowdata.id,
                floorName: rowdata.floorName,
                color: rowdata.color,
                lgcsCode: rowdata.lgcsCode,
                lgcsName: rowdata.lgcsName,
                isEdit: 1
            });
        }
        if (coltype == "delete") {
            $.alertMessage.confirm("你确定要删除当前数据吗？", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/PD144103/deleteAppFloor", {
                    id: rowdata.id,
                    ver: rowdata.ver
                }, function (data) {
                    FormUtils.setFormValue(PD144103.formId, "PD144103");
                    $List_Grid.fnDraw();
                }, {refreshHtml: false}, function () {
                    alert("操作失败")
                });
            })
        }
    },

    queryData: function () {
        $("#" + PD144103.searchData).click(function () {
            formData = getFormData($("#" + PD144103.formId));
            console.log("formData: " + formData);
            $('#main-content').postUrl(
                $("#" + PD144103.formId).attr("action"), formData, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
        });
    },
    bingNewBtn: function () {
        $("#" + PD144103.newBtnId).click(function () {
            $('#main-content').postUrl(Main.contextPath + "/PD144104/init", {
                isEdit: 2
            });
        })
    }

}
$(document).ready(function () {
    // 初始化调用
    PD144103.init();
});
