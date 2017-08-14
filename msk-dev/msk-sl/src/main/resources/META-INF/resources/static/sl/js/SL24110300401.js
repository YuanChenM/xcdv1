/**
 * Created by fjm on 2016/1/27.
 */
var SL24110300401 = {

    formId : "SL24110300401Form",
    saveButtonId : "SL24110300401_SAVE",
    addButtonId : "SL24110300401_ADD",

    init : function(){
        this.bindSavebutton();
        //this.bindAddbutton();
        this.bindDatePicber('#certDate');
    },
    bindDatePicber : function(orderTimeId){
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
        });
    },

    bindSavebutton : function() {
        $("#" + SL24110300401.saveButtonId).click(function() {
            SL24110300401.saveData();
        });
    },
    saveData : function() {
        var validator = mainValidation($("#" + SL24110300401.formId));
        var isValid = validator.form();
        if (isValid) {
            var certDate = $("#certDate").val();
            if(certDate=="" || certDate==null){
                $("input[name='certDate']").remove();
                //$("#certDate").val($("#certDate").val() + "0000-00-00 00:00:00");
            }else {
                $("#certDate").val($("#certDate").val() + " 00:00:00");
            }
            formData = getFormData($("#" + SL24110300401.formId));
            var $uploadFile = $("#SL24110300401Form");
            $.core.uploadForm($uploadFile, true);
        };
    }
}

$(document).ready(function() {
    SL24110300401.init();
});
