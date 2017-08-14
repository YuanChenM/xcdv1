/**
 * 菜场详细信息编辑
 * Created by zhouling on 16/04/13.
 */
var BY121306 = {
    saveButtonId: "BY121306_Save",
    formId: "by121306Form",
    initDataGrid: function () {
        this.bindSaveButton();
        this.bindSelectChange();
    },
    bindSaveButton: function () {
        $("#" + BY121306.saveButtonId).click(function () {
            var validator = mainValidation($("#" + BY121306.formId));
            var marketCode = $("#marketCode").val();
            var marketName = $("#marketName").val();
            var marketAddr = $("#marketAddr").val();
            var marketType = $("#marketType").val();
            var sectionType = $("#sectionType").val();
            var sizeType = $("#sizeType").val();
            var lgcsAreaCode = $("#lgcsAreaCode").val();
            var cityCode = $("#cityCode").val();
            var districtCode = $("#districtCode").val();
            if (marketCode == "") {
                $.alertMessage.confirm("请输入菜场编码", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (marketName == "") {
                $.alertMessage.confirm("请输入菜场名称", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (marketAddr == "") {
                $.alertMessage.confirm("请输入菜场地址", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (marketType == "") {
                $.alertMessage.confirm("请选择菜场类型", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (sectionType == "") {
                $.alertMessage.confirm("请选择地段类型", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (sizeType == "") {
                $.alertMessage.confirm("请选择规模类型", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (lgcsAreaCode == "") {
                $.alertMessage.confirm("请选择物流区", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (cityCode == "") {
                $.alertMessage.confirm("请选择地区(城市)", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (districtCode == "") {
                $.alertMessage.confirm("请选择区(县)", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            var formData = getFormData($("#" + BY121306.formId));
            $('#main-content').postUrl($("#" + BY121306.formId).attr("action"), formData, {refreshHtml: false});
        });
    },

    bindSelectChange: function () {
        // 设置菜场类型名称
        $("#marketType").change(function () {
            var marketTypeName = $("#marketType option:selected").text();
            $("#marketTypeName").val(marketTypeName);
        });

        // 设置地段类型名称
        $("#sectionType").change(function () {
            var sectionTypeName = $("#sectionType option:selected").text();
            $("#sectionTypeName").val(sectionTypeName);
        });

        // 设置规模类型名称
        $("#sizeType").change(function () {
            var sizeTypeName = $("#sizeType option:selected").text();
            $("#sizeTypeName").val(sizeTypeName);
        });

        // 物流区变更
        $("#lgcsAreaCode").change(function () {
            var lgcsAreaCode = $("#lgcsAreaCode option:selected").val();
            if (lgcsAreaCode == "") {
                return;
            }
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/lgcsAreaChange/" + lgcsAreaCode, null,
                function (data) {
                    $("#cityCode").html("");
                    $("#cityCode").append("<option value=''>请选择</option>");
                    $("#districtCode").html("");
                    $("#districtCode").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#cityCode").append("<option value='" + item.cityCode + "'>" + item.cityName + "</option>");
                    });
                }, {refreshHtml: false});
        });

        // 城市变更
        $("#cityCode").change(function () {
            var cityCode = $("#cityCode option:selected").val();
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/cityChange/" + cityCode, null,
                function (data) {
                    $("#districtCode").html("");
                    $("#districtCode").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#districtCode").append("<option value='" + item.districtCode + "'>" + item.districtName + "</option>");
                    });
                }, {refreshHtml: false});
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BY121306.initDataGrid();
});