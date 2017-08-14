/**
 * 产品管理
 *
 * @author yangchunyan
 */
var $List_Grid;
var PD144107 = {
    formId: "PD144107Form",
    gridFormId: "PD144107GridForm",
    uploadFormId: "PD144107UploadForm",
    addButton: "PD144107_ADD",
    addCoverButton: "PD144107_ADDCOVER",
    deleteButton: "PD144107_DELETE",
    saveButton: "PD144107_SAVE",
    type: "",
    init: function () {
        $List_Grid = $('#PD144107_Grid').grid({
            paginate: false,
            actionHandler: PD144107.actionHandler,
            linkHandler: PD144107.linkHandler
        });
        this.bindSaveButton();
        this.bindAddButton();
        this.bindAddCoverButton();
        FormUtils.init(PD144107.formId, "PD144107");
        //$("#PD144107UploadForm").attr("action",Main.contextPath + "/PD144107/updateImg")
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "delete") {
            $.alertMessage.confirm("你确定要删除当前数据吗？", function () {
                $.alertMessage.close();
                rowdata.delFlg = 1;
                //rowdata.pdCode = $("#pdCode").val();
                $('#main-content').postUrl(Main.contextPath + "/PD144107/updateImg", {
                    id: rowdata.id,
                    source: 1,
                    pdCode: rowdata.pdCode,
                    delFlg: 1,
                    ver: rowdata.ver
                }, function (data) {
                    $("#pdCode").val(rowdata.pdCode);
                    $List_Grid.fnDraw();
                }, {refreshHtml: false}, function () {
                    alert("操作失败")
                });
            });
        }
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
    linkHandler: function (rowdata, colname, row, col) {
        if (colname == "appImg") {
            $.pdialog.open("图片", Main.contextPath + "/PD144107/showImg", {
                width: "500px",
                height: "500"
            }, {id: rowdata.id});
        }
    },
    bindSaveButton: function () {
        $("#" + PD144107.saveButton).click(function () {
            // 校验序号是否为正整数.
            var dataList = $List_Grid.fnGetData();
            var pdLabel = $("#pdLabel").val();
            var json = {};// 创建json 对象
            for (i = 0; i < dataList.length; i++) {//  把数组的对象封装到json
                json[i] = {
                    "pdCode": dataList[i]["pdCode"],
                    "sort": dataList[i]["sort"],
                    "id": dataList[i]["id"],
                    "ver": dataList[i]["ver"]
                };
            }
            var jsonStr = JSON.stringify(json);
            var coverImg = $("#coverImg").attr("src");

            var status = 9;
            if ($("#status").is(':checked')) {
                status = 0;
            }
            /* if (pdLabel == '') {
             $.alertMessage.info("请输入标签");
             return false;
             }*/
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
            if (PD144107.checkIsRepeat(sortList)) {
                $.alertMessage.info("排序不能重复！");
                return false;
            }
            var msg = '';
            if (coverImg == '' && status == 0){
                msg = "封面图片未上传,你确定要上架吗？"
            }else if(dataList = '' || dataList.length == 0 && status == 0){
                msg = "产品图片未上传,你确定要上架吗？"
            }
            if (msg) {
                $.alertMessage.confirm(msg, function () {
                    $.alertMessage.close();
                    $('#main-content').postUrl(Main.contextPath + "/PD144107/updateImg", {
                        "jsonStr": jsonStr,
                        "status": status,
                        "pdLabel": pdLabel,
                        "lgcsCode": $("#lgcsCode").text(),
                        "pdCode": $("#codeLbl").text()
                    }, function (data) {
                        $("#pdCode").val($("#codeLbl").text());
                        $List_Grid.fnDraw();
                    }, {refreshHtml: false});
                });
            } else {
                $('#main-content').postUrl(Main.contextPath + "/PD144107/updateImg", {
                    "jsonStr": jsonStr,
                    "status": status,
                    "pdLabel": pdLabel,
                    "lgcsCode": $("#lgcsCode").text(),
                    "pdCode": $("#codeLbl").text()
                }, function (data) {
                    $("#pdCode").val($("#codeLbl").text());
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
            }
        })
    },
    bindAddButton: function () {
        $("#" + PD144107.addButton).click(function () {
            PD144107.type = 1;
            $.pdialog.open("新增图片", Main.contextPath + "/PD144107/initUpload", {
                width: "400px",
                height: "400"
            }, {pdCode: $("#codeLbl").text(), type: "1"});
        });
    },
    bindAddCoverButton: function () {
        $("#" + PD144107.addCoverButton).click(function () {
            PD144107.type = 0;
            $.pdialog.open("新增图片", Main.contextPath + "/PD144107/initUpload", {
                width: "400px",
                height: "400"
            }, {pdCode: $("#codeLbl").text(), type: "0", "lgcsCode": $("#lgcsCode").text()});
        });
    },
    showImage: function (id) {
        if(id) {
            $.pdialog.open("图片", Main.contextPath + "/PD144107/showImg", {
                width: "500px",
                height: "500"
            }, {id: id});
        }
    }
};


$(document).ready(function () {
    // 初始化调用
    PD144107.init();
});