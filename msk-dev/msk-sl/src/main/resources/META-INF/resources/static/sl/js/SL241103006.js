/**
 * Created by fjm on 2016/1/27.
 */
var SL241103006 = {

    formId : "SL241103006Form",
    saveButtonId : "SL241103006_SAVE",
    backButtonId : "SL241103006_BACK",

    init : function(){
        this.bindSavebutton();
        this.bindBackbutton();
    },

    bindSavebutton : function() {
        $("#" + SL241103006.saveButtonId).click(function() {
            SL241103006.saveData();
        });
    },
    bindBackbutton : function() {
        $("#" + SL241103006.backButtonId).click(function() {
            $.pdialog.close();
        });
    },
    saveData : function() {
        var $uploadFile = $("#SL241103006Form");
        $.core.uploadForm($uploadFile,true);
    }
}

$(document).ready(function() {
    SL241103006.init();
});
