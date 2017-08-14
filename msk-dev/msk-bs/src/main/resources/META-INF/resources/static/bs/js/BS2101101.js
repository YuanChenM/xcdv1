/**
 * 买手店列表JS
 *
 * @author cx
 */
var $List_Grid;
var BS2101101 = {
    formId: "bs2101101FormId",
    saveButtonId: "BS2101101_NEW",
    init: function () {
        $List_Grid = $('#bs2101101_list_grid').grid({
            actionHandler: BS2101101.actionHandler
        });
        this.changeSelect();
        this.queryData();
        this.bindSearchButton();
    },
    // 绑定按钮
    bindSearchButton: function () {
        $("#" + BS2101101.saveButtonId).click(function () {
            BS2101101.newData();
        });
    },
    newData: function () {
        formData = getFormData($("#" + BS2101101.formId));
        $.pdialog.open("新增买手", Main.contextPath + "/BS2101105/init/", {
            resizable: false,
            width: 1000,
            height: 600
        }, {flagNum: 1})
        //$('#main-content').postUrl(Main.contextPath + "/BS2101101/init/",{slCode:formData.slCode,epId:formData.epId});
    },
    actionHandler: function (rowdata, coltype, row, col) {
        /** 操作按钮 */
        if (col == 10) {
            $('#main-content').postUrl(Main.contextPath + "/BS2101102/init/", {
                slContact:rowdata.slContact,
                slCode:rowdata.slCode,
                slCodeDis:rowdata.slCodeDis,
                provinceCode:$("#province").val(),
                cityCode:$("#city").val(),
                districtCode:$("#district").val()
            });
        }
        if (col == 11) {
            $.pdialog.open("编辑买手", Main.contextPath + "/BS2101105/init", {
                resizable: false,
                width: 1000,
                height: 600
            }, rowdata);
        }
        if (coltype == 'audit') {
            $('#main-content').postUrl(Main.contextPath + "/BS2101108/init", rowdata);
        }
        if (coltype == 'return') {
            $('#buyerother').val(rowdata.slContact);
            $.pdialog.close();
        }
    },
    changeSelect: function () {
        var citySelect = $('#city');
        var districtSelect = $('#district');
        $("#province").change(function () {
            $("#city").find("option").not(":first").remove();
            $("#district").find("option").not(":first").remove();
            var provinceCode = $('#province').val();
            if (provinceCode != 0) {
                $('#main-content').postUrl(Main.contextPath + '/BS2101105/findCity', {provinceCode: provinceCode},
                    function (data) {
                        $.each(data, function (i, item) {
                            citySelect.append("<option value='" + item.cityCode + "'>" + item.cityName + "</option>");
                        });
                    }, {refreshHtml: false});
            }
        });
        $('#city').change(function () {
            $("#district").find("option").not(":first").remove();
            var cityCode = $("#city").val();
            if (cityCode != 0) {
                $('#main-content').postUrl(Main.contextPath + '/BS2101105/findDistrict', {cityCode: cityCode}, function (data2) {
                    $.each(data2, function (i, item) {
                        districtSelect.append("<option value='" + item.districtCode + "'>" + item.districtName + "</option>");
                    });
                }, {refreshHtml: false})
            }
        });
    },
    queryData: function () {
        $("#" + BS2101101.searchData).click(function () {
            formData = getFormData($("#" + BS2101101.formId));
            $('#main-content').postUrl(
                $("#" + BS2101101.formId).attr("action"), formData, function () {
                    $List_Grid.fnDraw();
                }, {refreshHtml: false});
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BS2101101.init();
});
