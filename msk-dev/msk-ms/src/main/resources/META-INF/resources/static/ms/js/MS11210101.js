/**
 * @author fjm
 @MS11210101.js_会员卡信息修改页面js
 */
var MS11210101 = {

    formId: "MS11210101Form",
    saveButtonId: "MS11210101_SAVE",
    backButtonId: "MS11210101_BACK",

    init: function () {
        this.bindSavebutton();
        this.bindBackbutton();
        this.bindDatePicber('#provideDate');

    },
    bindDatePicber: function (orderTimeId) {
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
        });
    },
    bindSavebutton: function () {
        $("#" + MS11210101.saveButtonId).click(function () {
            MS11210101.saveData();
        });
    },
    bindBackbutton: function () {
        $("#" + MS11210101.backButtonId).click(function () {
            $.pdialog.close();
        });
    },
    saveData: function () {
        var validator = mainValidation($("#" + MS11210101.formId));
        var isValid = validator.form();
        if (isValid) {
            $.alertMessage.confirm("你确定要保存当前数据吗？", function () {
                $.alertMessage.close();
                var data = $("#provideDate").val();
                if (null != data && "" != data) {
                    $("#provideDate").val($("#provideDate").val() + " 00:00:00");
                    formData = getFormData($("#" + MS11210101.formId));
                    $('#main-content').postUrl(
                        $("#" + MS11210101.formId).attr("action"),
                        formData,
                        function () {
                            $('#main-content').postUrl(Main.contextPath + "/MS112101/init");
                            $.pdialog.close();
                        });
                } else {
                    $("#proDate").html("日期不能为空").css("color", "red");
                }
            });
        }
    },
}

$(document).ready(function () {
    MS11210101.init();
});
