/**
 * 买手店列表JS
 *
 * @author cx
 */
var $List_Grid;
var PD144104 = {
    formId: "pd144104FormId",
    formId1: "pd144104FormId1",
    searchData: "PD144104_SEARCH",
    newBtnId: "PD144104_NEW",
    saveButton: "PD144104_SAVE",
    init: function () {
        var id = $("#id").val();
        if (!id) {
            $("#addFloorId").val($("#wl_select").val());
            $("#" + PD144104.newBtnId).hide();
        } else {
            $("#floorId").val($("#id").val());
            $("#addFloorId").val($("#lgcsCode").val());
            $("#" + PD144104.newBtnId).show();
        }
        $List_Grid = $('#PD144104_list_grid').grid({
            actionHandler: PD144104.actionHandler
        });


        this.queryData();
        this.bindSearchButton();
        this.bindConfirmButton();
        this.bingNewBtn();
        this.initColor();
        /*    this.bindStartDatePicber('#taxablePeriodBegin');
         this.bindEndDatePicber('#taxablePeriodEnd');*/
    },
    initColor: function () {
        $('.demo').each(function () {

            $(this).minicolors({
                control: $(this).attr('data-control') || 'hue',
                defaultValue: $(this).attr('data-defaultValue') || '',
                inline: $(this).attr('data-inline') === 'true',
                letterCase: $(this).attr('data-letterCase') || 'lowercase',
                opacity: $(this).attr('data-opacity'),
                position: $(this).attr('data-position') || 'bottom left',
                change: function (hex, opacity) {
                    if (!hex) return;
                    if (opacity) hex += ', ' + opacity;
                    try {
                        console.log(hex);
                    } catch (e) {
                    }
                },
                theme: 'bootstrap'
            });

        });
    },
    // 绑定按钮
    bindSearchButton: function () {
        $("#" + PD144104.searchData).click(function () {
            FormUtils.setFormValue(PD144104.formId1, "PD144104");
            $List_Grid.fnDraw();
        });
    },
    bindConfirmButton: function () {
        $("#" + PD144104.saveButton).click(function () {
            var floorName = $("#floorName").val();
            var color = $("#color").val();
            var lgcsName = '';
            var lgcsCode = '';
            var id = $("#id").val();
            if (id) {
                lgcsCode = $("#lgcsCode").val();
                lgcsName = $("#lgcsName").text();
            } else {
                lgcsCode = $("#wl_select").val();
                lgcsName = $("#wl_select").find("option:selected").text();
            }
            var param = {
                id: id,
                floorName: floorName,
                color: color,
                isEdit: 1,
                lgcsCode: lgcsCode,
                lgcsName: lgcsName
            }
            if (PD144104.validate(param)) {
                $('#main-content').postUrl(Main.contextPath + "/PD144104/save", param, function (data) {
                    if (data != "") {
                        $.alertMessage.info("保存成功!");
                        param.id = data;
                        $('#main-content').postUrl(Main.contextPath + "/PD144104/init", param, function (data) {
                        })
                        //$List_Grid.fnDraw();
                    } else {
                        $.alertMessage.info("保存失败!");
                    }
                }, {refreshHtml: false});
            }
        });
    },
    validate: function () {
        var floorName = $("#floorName").val();
        var color = $("#color").val();
        var lgcsCode = '';
        var id = $("#id").val();
        if (id) {
            lgcsCode = $("#lgcsCode").val();
            lgcsName = $("#lgcsName").text();
        } else {
            lgcsCode = $("#wl_select").val();
            lgcsName = $("#wl_select").find("option:selected").text();
        }
        if (!floorName) {
            $.alertMessage.info("请填写楼层名称");
            return false;
        } else if (!color) {
            $.alertMessage.info("请选择悬浮颜色");
            return false;
        } else if (!lgcsCode) {
            $.alertMessage.info("请选择物流区");
            return false;
        }
        var originColor = $('#originColor').val();
        if (color == originColor && $('#isEdit').val() == 1) {
            $.alertMessage.info("请先编辑要保存的数据");
            return false;
        }
        return true;
    },
    actionHandler: function (rowdata, coltype, row, col) {
        if (coltype == "delete") {
            $.alertMessage.confirm("你确定要删除当前数据吗？", function () {
                $.alertMessage.close();
                $('#main-content').postUrl(Main.contextPath + "/PD144104/delete", rowdata, function (data) {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
            })
        }
    },

    queryData: function () {
        $("#" + PD144104.searchData).click(function () {
            formData = getFormData($("#" + PD144104.formId1));
            $('#main-content').postUrl(
                $("#" + PD144104.formId1).attr("action"), formData, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
        });
    },
    searchDetailData: function () {
        formData = getFormData($("#" + PD144104.formId1));
        $('#main-content').postUrl(
            $("#" + PD144104.formId1).attr("action"), formData, function () {
                $List_Grid.fnDraw();
            }, {refreshHtml: false});
    },
    bingNewBtn: function () {
        $("#" + PD144104.newBtnId).click(function () {
            var isEdit = $("#isEdit").val();
            var id = $("#id").val();
            var floorName = '';
            var lgcsCode = '';
            var lgcsName = '';
            if (id) {
                lgcsCode = $("#lgcsCode").val();
                lgcsName = $("#lgcsName").text();
            } else {
                lgcsCode = $("#wl_select").val();
                lgcsName = $("#wl_select").find("option:selected").text();
            }
            $.pdialog.open("新增产品", Main.contextPath + "/PD144105/init", {resizable: true, width: 900, height: 610},
                {
                    floorId: id,
                    floorName: floorName,
                    lgcsCode: lgcsCode,
                    isEdit: isEdit,
                    lgcsName: lgcsName
                })
        })
    }

}
$(document).ready(function () {
    // 初始化调用
    PD144104.init();
});
