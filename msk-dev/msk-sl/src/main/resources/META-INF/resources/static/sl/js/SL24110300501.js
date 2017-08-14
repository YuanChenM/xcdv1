/**
 * Created by fjm on 2016/1/27.
 */
var SL24110300501 = {

    formId : "SL24110300501Form",
    saveButtonId : "SL24110300501_SAVE",

    init : function(){
        this.bindSavebutton();
    },

    bindSavebutton : function() {
        $("#" + SL24110300501.saveButtonId).click(function() {
            SL24110300501.saveData();
        });
    },
    saveData : function() {
        var $uploadFile = $("#SL24110300501Form");
        $.core.uploadForm($uploadFile,true);
    }
}

$(document).ready(function() {
    SL24110300501.init();
});
