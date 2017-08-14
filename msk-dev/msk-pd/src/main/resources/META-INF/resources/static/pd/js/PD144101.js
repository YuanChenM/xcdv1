/**
 * 轮播图设置JS
 *
 * @author yuan_chen
 */
var $List_Grid;
var PD144101 = {
    formId: "PD144101FormHeight",
    addButtonId: "PD144101_ADD",
    deleteButton: "PD144101_DELETE",
    saveButtonId: "PD144101_SAVE",
    savePicButtonId: "PD144101_PIC_SAVE",
    init: function () {
        this.bindAddButton();
        this.bindSaveButton();
        this.bindSavePicButton();
        $List_Grid = $('#PD144101_list_grid').grid({
            paginate: false,
            actionHandler: PD144101.actionHandler,
            linkHandler: PD144101.linkHandler
        });
        FormUtils.init(PD144101.gridFormId, "PD144101");
    },

    bindAddButton: function () {
        $("#" + PD144101.addButtonId).click(function () {
            $.pdialog.open("新增图片", Main.contextPath + "/PD144101/initUpload", {width: "600", height: "200"});


        });
    },

    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "delete") {
            $.alertMessage.confirm("你确定要删除当前数据吗？", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/PD144101/deleteImg", rowdata, function (data) {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false}, function () {
                    alert("操作失败")
                });
            });
        }
    },

    linkHandler: function (rowdata, colname, row, col) {
        if (colname == "scrollImg") {
            $.pdialog.open("图片", Main.contextPath + "/PD144101/showImg?scrollImg=" + rowdata.scrollImg + "&id=" + rowdata.id, {
                width: "500px",
                height: "500"
            });
        }
    },

    bindSaveButton: function () {
        /** 操作按钮 */
        $("#" + PD144101.saveButtonId).click(function () {
            var param = {
                modelHeight: $("#modelHeight").val()
            };
            if (0 == param.modelHeight) {
                $.alertMessage.info("请选择图片百分比！");
                return false;
            }
            $('#PD144101FormHeight').postUrl(Main.contextPath + "/PD144101/saveHeight", param, function (data) {
                if (data > 0) {
                    $.alertMessage.info("保存成功!");
                } else {
                    $.alertMessage.info("保存失败!");
                }
            }, {refreshHtml: false});

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

    bindSavePicButton: function () {
        $("#" + PD144101.savePicButtonId).click(function () {
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
            if (PD144101.checkIsRepeat(sortList)) {
                $.alertMessage.info("排序不能重复！");
                return false;
            }
            var json = {};// 创建json 对象
            for (var i in dataList) {//  把数组的对象封装到json
                json[i] = {"id": dataList[i].id, "sort": dataList[i].sort};
            }
            var jsonStr = JSON.stringify(json);//  转成jsonStr
            $('#main-content').postUrl(Main.contextPath + "/PD144101/modifyImgSort", {"jsonStr": jsonStr}, function (data) {
                FormUtils.setFormValue(PD144101.formId, "PD144101");
                $List_Grid.fnDraw();
            }, {refreshHtml: false});
        });
    }
};
$(document).ready(function () {
    // 初始化调用
    PD144101.init();
});