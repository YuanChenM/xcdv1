var SL2411030081 = {

    formId: "SL2411030081Form",
    saveButtonId: "SL2411030081_SAVE",
    backButtonId: "SL2411030081_BACK",

    init: function () {
        this.bindSavebutton();
        this.bindBackbutton();
    },
    bindSavebutton: function () {
        $("#" + SL2411030081.saveButtonId).click(function () {
            SL2411030081.uploadData();
        });
    },
    bindBackbutton: function () {
        $("#" + SL2411030081.backButtonId).click(function () {
            $.pdialog.close();
        });
    },
    uploadData : function(){
        var $uploadFile = $("#SL2411030081Form");
        $.core.uploadForm($uploadFile, true);
    }
}

$(document).ready(function () {
    SL2411030081.init();
});

