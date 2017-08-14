/**
 * Created by fjm on 2016/1/27.
 */
var SL2411030050101 = {

    formId : "SL2411030050101Form",
    saveButtonId : "SL2411030050101_SAVE",
    backButtonId : "SL2411030050101_BACK",

    init : function(){
        this.bindSavebutton();
        this.bindBackbutton();
    },

    bindSavebutton : function() {
        $("#" + SL2411030050101.saveButtonId).click(function() {
            SL2411030050101.saveData();
        });
    },
    bindBackbutton : function() {
        $("#" + SL2411030050101.backButtonId).click(function() {
            $.pdialog.close();
        });
    },
    saveData : function() {
        var $uploadFile = $("#SL2411030050101Form");
        $.core.uploadForm($uploadFile,true);
    }
}

$(document).ready(function() {
    SL2411030050101.init();
});
