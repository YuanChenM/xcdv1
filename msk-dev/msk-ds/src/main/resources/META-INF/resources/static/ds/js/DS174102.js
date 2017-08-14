/**
 * 卖家产品批次生成JS
 * Created by yuan_chen on 16/1/13.
 */
var DS174102 = {
    saveButtonId: "DS174102_SAVE",
    backButtonId: "DS174102_BACK",
    formId: "DS174102Form",
    DS174102Grid: null,
    init: function () {
        this.bindSaveButton();
        this.bindBackButton();
    },
    initDataGrid: function () {
        DS174102.DS174102Grid = $('#DS174102_Grid').grid({
            actionHandler: DS174102.actionHandler
        });
    },
    bindSaveButton: function () {
        $("#" + DS174102.saveButtonId).click(function () {
            var validator = mainValidation($("#" + DS174102.formId));
            var isValid = validator.form();
            if (isValid) {
                $.alertMessage.confirm("你确定要保存当前数据吗？", function () {
                    $.alertMessage.close();
                    formData = getFormData($("#" + DS174102.formId));
                    $('#main-content').postUrl($("#" + DS174102.formId).attr("action"), formData);
                });
            }
        });
    },
    bindBackButton: function () {
        $("#" + DS174102.backButtonId).click(function () {
            $('#main-content').postUrl(Main.contextPath + "/DS174101/init");
        });
    }
}
$(document).ready(function () {
    //初始化调用
    DS174102.init();
    DS174102.initDataGrid();
});
