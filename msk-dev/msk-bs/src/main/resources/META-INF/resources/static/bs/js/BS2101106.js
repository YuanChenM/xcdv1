
var BS2101106 = {
    formId: "BS2101106Form",
    saveButtonId: "BS2101106_SAVE",
    init: function () {
        this.changeSelect();
        this.bindSavebutton();
    },
    /*changeSelect: function () {
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
    },*/
    changeSelect : function () {
        var citySelect = $('#city1');
        var districtSelect = $('#district1');
        $("#province1").change(function () {
            $("#city1").find("option").not(":first").remove();
            $("#district1").find("option").not(":first").remove();
            var provinceCode = $('#province1').val();
            if (provinceCode != 0) {
                $('#main-content').postUrl(Main.contextPath + '/BS2101105/findCity', {provinceCode: provinceCode},
                    function (data) {
                        $.each(data, function (i, item) {
                            citySelect.append("<option value='" + item.cityCode + "'>" + item.cityName + "</option>");
                        });
                    }, {refreshHtml: false});
            }
        });
        $('#city1').change(function () {
            $("#district").find("option").not(":first").remove();
            var cityCode = $("#city1").val();
            if (cityCode != 0) {
                $('#main-content').postUrl(Main.contextPath + '/BS2101105/findDistrict', {cityCode: cityCode}, function (data2) {
                    $.each(data2, function (i, item) {
                        districtSelect.append("<option value='" + item.districtCode + "'>" + item.districtName + "</option>");
                    });
                }, {refreshHtml: false})
            }
        });
    },
    bindSavebutton : function() {
        $("#" + BS2101106.saveButtonId).click(function() {
            BS2101106.saveData();
        });
    },
    saveData : function() {
        var validator = mainValidation($("#" + BS2101106.formId));
        var isValid = validator.form();

        if (isValid) {
            formData = getFormData($("#" + BS2101106.formId));
            var $uploadFile = $("#BS2101106Form");
            $.core.uploadForm($uploadFile, true);
        };
    }
}

$(document).ready(function() {
    BS2101106.init();
});


