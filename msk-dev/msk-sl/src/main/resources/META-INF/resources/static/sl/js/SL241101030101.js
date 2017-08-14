/**
 * Created by fjm on 2016/1/27.
 */
var SL241101030101 = {
    saveButtonId : "SL241101030101_SAVE",
    backButtonId : "SL241101030101_BACK",
    init: function () {
        this.bindSavebutton();
        this.bindBackbutton();
    },
    bindSavebutton : function() {
        $("#" + SL241101030101.saveButtonId).click(function() {
            SL241101030101.saveData();
        });
    },
    bindBackbutton : function() {
        $("#" + SL241101030101.backButtonId).click(function() {
            $.pdialog.close();
        });
    },
    saveData : function() {
        var $uploadFile = $("#SL241101030101Form");
        $.core.uploadForm($uploadFile,true);
    }
}
$(document).ready(function() {
    SL241101030101.init();
});


