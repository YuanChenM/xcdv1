var SL2411030091 = {

    formId: "SL2411030091Form",
    saveButtonId: "SL2411030091_SAVE",
    backButtonId: "SL2411030091_BACK",

    init: function () {
        this.bindSavebutton();
        this.bindBackbutton();
    },
    bindSavebutton: function () {
        $("#" + SL2411030091.saveButtonId).click(function () {
            SL2411030091.uploadData();
        });
    },
    bindBackbutton: function () {
        $("#" + SL2411030091.backButtonId).click(function () {
            $.pdialog.close();
        });
    },
    uploadData : function(){
        var $uploadFile = $("#SL2411030091Form");
        $.core.uploadForm($uploadFile, true);
    }
}

$(document).ready(function () {
    SL2411030091.init();
});

