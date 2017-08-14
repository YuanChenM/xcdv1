/**
 * 买家详细信 息
 * Created by marshall on 16/3/9.
 */
var BY121307 = {
    BY121307Grid: null,
    buyerId: $("#buyerId").val(),
    addButton: "BY121307_ADD",
    saveButton: "BY121307_SAVE",
    formId: "BY121307Form",
    initDataGrid: function () {
        BY121307.BY121307Grid = $('#BY121307_Grid').grid({
            actionHandler: BY121307.actionHandler
        });
        this.bindSelectChange();
        this.bindAddButton();
        this.bindSaveButton();
        this.keyDownEvent();
    },
    bindSelectChange: function () {
        $("#lgcsAreaCode").change(function () {
            var lgcsAreaCode = $("#lgcsAreaCode option:selected").val();
            if (lgcsAreaCode == "") {
                return false;
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
            if (cityCode == "") {
                return false;
            }
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/cityChange/" + cityCode, null,
                function (data) {
                    $("#districtCode").html("");
                    $("#districtCode").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#districtCode").append("<option value='" + item.districtCode + "'>" + item.districtName + "</option>");
                    });
                }, {refreshHtml: false});
        });
        $("#districtCode").change(function () {
            var superiorType = $("#superiorType option:selected").val();
            var lgcsAreaCode = $("#lgcsAreaCode option:selected").val();
            var cityCode = $("#cityCode option:selected").val();
            var districtCode = $("#districtCode option:selected").val();
            if (districtCode == "") {
                return false;
            }
            $("#superiorQua").val("");
            BY121307.findMarket(superiorType, lgcsAreaCode, cityCode, districtCode);
        });
        $("#superiorType").change(function () {
            var superiorType = $("#superiorType option:selected").val();
            var lgcsAreaCode = $("#lgcsAreaCode option:selected").val();
            var cityCode = $("#cityCode option:selected").val();
            var districtCode = $("#districtCode option:selected").val();
            BY121307.findMarket(superiorType, lgcsAreaCode, cityCode, districtCode);
        });
        $("#superiorId").change(function () {
            var superiorType = $("#superiorType option:selected").val();
            var superiorId = $("#superiorId option:selected").val();
            $("#superiorQua").val("");
            if (superiorId == "") {
                return false;
            }
            if (superiorType == "1") {
                $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketTermial/" + superiorId, null,
                    function (data) {
                        if (data != null) {
                            $("#superiorQua").val(data.marketLevelName);
                        }
                    }, {refreshHtml: false});
            } else if (superiorType == "2") {
                $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketFood/" + superiorId, null,
                    function (data) {
                        if (data != null) {
                            $("#superiorQua").val(data.sizeTypeName);
                        }
                    }, {refreshHtml: false});
            }
        });
        $("#buyerTypeId").change(function () {
            var superiorType = $("#superiorType option:selected").val();
            var buyerType = $("#buyerTypeId option:selected").val();
            $("#superiorSubName").val($("#buyerTypeId option:selected").text());
            if (superiorType == "8" && buyerType == "1") {
                $('#isFoodMarket').show();
            }else{
                $('#isFoodMarket').hide();
            }
        });
    },
    findMarket: function (superiorType, lgcsAreaCode, cityCode, districtCode) {
        $("#superiorDec").css("display", "block");
        $("#superiorId").css("display", "block");
        $("#superiorQuaDec").css("display", "block");
        $("#superiorQua").css("display", "block");
        $("#superiorSubName").val();
        if (superiorType == "1") {
            $("#superiorDec").text("批发市场:");
            $("#superiorQuaDec").text("批发市场等级:");
            $("#superiorQua").val("");
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketTermialList/", {
                    "lgcsAreaCode": lgcsAreaCode,
                    "cityCode": cityCode,
                    "districtCode": districtCode
                },
                function (data) {
                    $("#superiorId").html("");
                    $("#superiorId").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#superiorId").append("<option value='" + item.terMarketId + "'>" + item.marketName + "</option>");
                    });
                }, {refreshHtml: false});
        } else if (superiorType == "2") {
            $("#superiorDec").text("菜场:");
            $("#superiorQuaDec").text("菜场等级:");
            $("#superiorQua").val("");
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketFoodList/", {
                    "lgcsAreaCode": lgcsAreaCode,
                    "cityCode": cityCode,
                    "districtCode": districtCode
                },
                function (data) {
                    $("#superiorId").html("");
                    $("#superiorId").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#superiorId").append("<option value='" + item.fodMarketId + "'>" + item.marketName + "</option>");
                    });
                }, {refreshHtml: false});
        } else {
            $("#superiorDec").text("");
            $("#superiorId").html("");
            $("#superiorQuaDec").text("");
            $("#superiorQua").val("");
            $("#superiorDec").css("display", "none");
            $("#superiorId").css("display", "none");
            $("#superiorQuaDec").css("display", "none");
            $("#superiorQua").css("display", "none");
        }
        //二级分类
        if (superiorType == "5") {
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findBuyerList/chinesFoodType", null,
                function (data) {
                    $("#buyerTypeId").html("");
                    $("#buyerTypeId").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#buyerTypeId").append("<option value='" + item.constantValue + "'>" + item.constantName + "</option>");
                    });
                }, {refreshHtml: false});
        } else if (superiorType == "8") {
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findBuyerList/machiningType", null,
                function (data) {
                    $("#buyerTypeId").html("");
                    $("#buyerTypeId").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#buyerTypeId").append("<option value='" + item.constantValue + "'>" + item.constantName + "</option>");
                    });
                }, {refreshHtml: false});
        }else{
            $("#buyerTypeId").html("");
            $("#buyerTypeId").append("<option value=''>请选择</option>");
        }
        var buyerType = $("#buyerTypeId option:selected").val();
        if (superiorType == "8" && buyerType == "1") {
            $('#isFoodMarket').show();
        }else{
            $('#isFoodMarket').hide();
        }
    },
    bindAddButton: function () {
        $("#" + BY121307.addButton).click(function () {
            var editType = "BY121307Add";
            $.pdialog.open("买家雇员信息新增画面", Main.contextPath + "/BY12130401/init/" + editType, {
                    width: 450,
                    height: 500
                },
                {"buyerId": BY121307.buyerId}
            )
        });
    },
    bindSaveButton: function () {
        $("#" + BY121307.saveButton).click(function () {
            var storeArea = $("#storeArea").val();
            var employeesNum = $("#employeesNum").val();
            if (isNaN(storeArea)) {
                $.alertMessage.confirm("请输入正确的店铺面积", function () {
                    $.alertMessage.close();
                });
                return false;
            }
            var $uploadFile = $("#" + BY121307.formId);
            $.core.uploadForm($uploadFile, true);
        });
    },
    keyDownEvent: function () {
        $("#employeesNum").keydown(function () {
            var keyCode = event.keyCode;
            if ((keyCode >= 48 && keyCode <= 57)) {
                event.returnValue = true;
            } else {
                event.returnValue = false;
            }
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    BY121307.initDataGrid();
});