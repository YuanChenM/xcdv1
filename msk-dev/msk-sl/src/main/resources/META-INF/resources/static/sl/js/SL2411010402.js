/**
 * Created by fjm on 2016/1/27.
 */
var SL2411010402 = {
    formId : "SL2411010402Form",
    updateButtonId : "SL2411010402_UPDATE",

    init : function(){
        this.bindUpdatebutton();
    },
    bindUpdatebutton : function() {
        $("#" + SL2411010402.updateButtonId).click(function() {
            SL2411010402.updateData();
        });
    },
    updateData : function() {
        var validator = mainValidation($("#" + SL2411010402.formId));
        var isValid = validator.form();
        if (isValid) {
            var $uploadFile = $("#SL2411010402Form");
            $.core.uploadForm($uploadFile,true);
        };
    }
}

$(document).ready(function() {
    SL2411010402.init();
});
