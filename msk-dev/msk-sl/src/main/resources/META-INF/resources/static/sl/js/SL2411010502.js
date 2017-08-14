/**
 * Created by fjm on 2016/1/27.
 */
var SL2411010502 = {

    formId : "SL2411010502Form",
    updateButtonId : "SL2411010502_UPDATE",
    init : function(){
        this.bindUpdatebutton();
    },
    bindUpdatebutton : function() {
        $("#" + SL2411010502.updateButtonId).click(function() {
            SL2411010502.updateData();
        });
    },
    updateData : function() {
        var $uploadFile = $("#SL2411010502Form");
        $.core.uploadForm($uploadFile,true);
    }
}

$(document).ready(function() {
    SL2411010502.init();
});
