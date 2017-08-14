var PD144108 = {
    formId:"PD144108Form",
    addButtion:"PD144108_SAVE",
    closeButtion:"PD144108_CLOSE",
    imagePath:"",
    init: function () {
        this.bindAddButton();
    },
    bindAddButton: function () {
        $("#" + PD144108.addButtion).click(function () {
                var $uploadFile = $("#" + PD144108.formId);
                $.core.uploadForm($uploadFile, true);
        });
    }
};
$(document).ready(function () {
    // 初始化调用
    PD144108.init();
});