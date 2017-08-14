/**
 * 买手店列表JS
 *
 * @author cx
 */
var BS2101107 = {
    formId: "BS2101107FormInfo",
  /*  formId2: "BS21011072FormInfo",*/
    init: function () {
        $("#SL2101107accordion").accordion({heightStyle: "content"});
        this.checkData();
        this.changeSelect();
        this.saveData();
        /*this.saveData1();*/
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
        var citySelect2 = $('#vcity_select');
        var districtSelect2 = $('#vdistrict_select');
        $('#vprovince_select').change(function () {
            $("#vcity_select").find("option").not(":first").remove();
            $("#vdistrict_select").find("option").not(":first").remove();
            var provinceCode2 = $('#vprovince_select').val();
            if (provinceCode2 != 0) {
                $('#main-content').postUrl(Main.contextPath + '/BS2101107/findCity', {provinceCode: provinceCode2},
                    function (data3) {
                        $.each(data3, function (i, item) {
                            citySelect2.append("<option value='" + item.cityCode + "'>" + item.cityName + "</option>");
                        });
                    }, {refreshHtml: false});
            }
        });
        $('#vcity_select').change(function () {
            $("#vdistrict_select").find("option").not(":first").remove();
            var cityCode2 = $("#vcity_select").val();
            if (cityCode2 != 0) {
                $('#main-content').postUrl(Main.contextPath + '/BS2101107/findDistrict', {cityCode: cityCode2}, function (data3) {
                    $.each(data3, function (i, item) {
                        districtSelect2.append("<option value='" + item.districtCode + "'>" + item.districtName + "</option>");
                    });
                }, {refreshHtml: false})
            }
        });
    },
    saveData: function () {
        $("#SL2101107_SAVE").click(function () {
            formData = getFormData($("#" + BS2101107.formId));
            $('#main-content').postUrl(
                $("#" + BS2101107.formId).attr("action"), formData, function (data) {
                    if (data == "1") {
                        $.alertMessage.info("保存成功!");
                    } else {
                        $.alertMessage.info("保存失败!");
                    }
                }, {refreshHtml: false});
        });
    },
    /*  saveData1:function() {
     $("#SL21011072_SAVE").click(function () {
     formData = getFormData($("#" + BS21011072.formId));
     $('#main-content').postUrl(
     $("#" + BS21011072.formId).attr("action"), formData, function (data) {
     if(data=="1"){
     $.alertMessage.info("保存成功!");
     }else{
     $.alertMessage.info("保存失败!");
     }
     }, {refreshHtml: false});
     });
     },*/
    checkData: function () {
        $("#houseCategoryId").change(function () {
            var ss = $("#houseCategoryId").val();
            if (ss == 0) {
                $("#houseCategory0Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 1) {
                $("#houseCategory1Yes").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 2) {
                $("#houseCategory2Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 3) {
                $("#houseCategory3Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 4) {
                $("#houseCategory4Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 5) {
                $("#houseCategory5Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 6) {
                $("#houseCategory6Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 7) {
                $("#houseCategory7Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
                $("#houseCategory8No").prop("checked", true);
            }
            if (ss == 8) {
                $("#houseCategory8Yes").prop("checked", true);
                $("#houseCategory1No").prop("checked", true);
                $("#houseCategory2No").prop("checked", true);
                $("#houseCategory3No").prop("checked", true);
                $("#houseCategory4No").prop("checked", true);
                $("#houseCategory5No").prop("checked", true);
                $("#houseCategory6No").prop("checked", true);
                $("#houseCategory7No").prop("checked", true);
                $("#houseCategory0No").prop("checked", true);
            }
        });
    }
};

$(document).ready(function () {
    // 初始化调用
    BS2101107.init();
});
