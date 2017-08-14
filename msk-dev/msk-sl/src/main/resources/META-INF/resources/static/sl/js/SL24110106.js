/**
 * Created by fjm on 2016/1/27.
 */
var SL24110106 = {
    updateButtonId : "SL24110106_UPDATE",
    init : function(){
        this.bindUpdatebutton();
    },

    bindUpdatebutton : function() {
        $("#" + SL24110106.updateButtonId).click(function() {
            SL24110106.updateData();
        });
    },
    updateData : function() {
        var $uploadFile = $("#SL24110106Form");
        $.core.uploadForm($uploadFile,true);
    }
}

$(document).ready(function() {
    SL24110106.init();
});
