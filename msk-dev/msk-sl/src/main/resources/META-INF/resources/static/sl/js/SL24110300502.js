/**
 * Created by fjm on 2016/1/27.
 */
var SL24110300502 = {

    formId : "SL24110300502Form",
    saveButtonId : "SL24110300502_SAVE",
    backButtonId : "SL24110300502_BACK",

    init : function(){
        this.bindSavebutton();
        this.bindBackbutton();
    },

    bindSavebutton : function() {
        $("#" + SL24110300502.saveButtonId).click(function() {
            SL24110300502.saveData();
        });
    },
    bindBackbutton : function() {
        $("#" + SL24110300502.backButtonId).click(function() {
            $.pdialog.close();
        });
    },
    saveData : function() {
        var $uploadFile = $("#SL24110300502Form");
        $.core.uploadForm($uploadFile,true);
    }
}

$(document).ready(function() {
    SL24110300502.init();
});
