/**
 * Created by fjm on 2016/1/27.
 */
var SL24110300402 = {

    formId : "SL24110300402Form",
    saveButtonId : "SL24110300402_SAVE",
    backButtonId : "SL24110300402_BACK",

    init : function(){
        this.bindSavebutton();
        this.bindBackbutton();
    },

    bindSavebutton : function() {
        $("#" + SL24110300402.saveButtonId).click(function() {
            SL24110300402.saveData();
        });
    },
    bindBackbutton : function() {
        $("#" + SL24110300402.backButtonId).click(function() {
            $.pdialog.close();
        });
    },
    saveData : function() {
        var $uploadFile = $("#SL24110300402Form");
        $.core.uploadForm($uploadFile,true);
    }
}

$(document).ready(function() {
    SL24110300402.init();
});
