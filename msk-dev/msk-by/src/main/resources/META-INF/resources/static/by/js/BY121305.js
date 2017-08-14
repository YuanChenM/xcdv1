/**
 * 批发市场详细信息
 * Created by zhouling on 16/04/12.
 */
var BY121305 = {
    saveButtonId: "BY121305_Save",
    formId: "by121305Form",
    initDataGrid: function () {
        this.bindSaveButton();
        this.bindSelectChange();
    },
    bindSaveButton: function () {
        $("#" + BY121305.saveButtonId).click(function () {
            var marketCode = $("#marketCode").val();
            var marketName = $("#marketName").val();
            var marketAddr = $("#marketAddr").val();
            var marketLevel = $("#marketLevel").val();
            var lgcsAreaCode = $("#lgcsAreaCode").val();
            var cityCode = $("#cityCode").val();
            var districtCode = $("#districtCode").val();
            if (marketCode == "") {
                $.alertMessage.confirm("请输入批发市场编码", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (marketName == "") {
                $.alertMessage.confirm("请输入批发市场名称", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (marketAddr == "") {
                $.alertMessage.confirm("请输入批发市场地址", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            if (marketLevel == "") {
                $.alertMessage.confirm("请选择批发市场级别", function () {
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
            var formData = getFormData($("#" + BY121305.formId));
            $('#main-content').postUrl($("#" + BY121305.formId).attr("action"), formData, {refreshHtml: false});
        });
    },

    bindSelectChange: function () {
        // 设置批发市场级别名称
        $("#marketLevel").change(function () {
            var marketLevelName = $("#marketLevel option:selected").text();
            $("#marketLevelName").val(marketLevelName);
        });

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
    BY121305.initDataGrid();
});