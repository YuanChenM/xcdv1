/**
 * Created by fjm on 2016/1/27.
 */
var SL2411030040101 = {

    formId : "SL2411030040101Form",
    saveButtonId : "SL2411030040101_SAVE",
    backButtonId : "SL2411030040101_BACK",

    init : function(){
        this.bindSavebutton();
        this.bindBackbutton();
        this.bindDatePicber('#addcertDate');
    },
    bindDatePicber : function(orderTimeId){
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true
        });
    },

    bindSavebutton : function() {
        $("#" + SL2411030040101.saveButtonId).click(function() {
            SL2411030040101.saveData();
        });
    },
    bindBackbutton : function() {
        $("#" + SL2411030040101.backButtonId).click(function() {
            $.pdialog.close();
        });
    },
    saveData : function() {
        var validator = mainValidation($("#" + SL2411030040101.formId));
        var isValid = validator.form();
        if (isValid) {
            var addcertDate = $("#addcertDate").val();
            if(addcertDate=="" || addcertDate==null){
                $("input[name='certDate']").remove();
                //$("#addcertDate").val($("#addcertDate").val() + "0000-00-00 00:00:00");
            }else {
                $("#addcertDate").val($("#addcertDate").val() + " 00:00:00");
            }
            formData = getFormData($("#" + SL2411030040101.formId));
            var $uploadFile = $("#SL2411030040101Form");
            $.core.uploadForm($uploadFile, true);
        };
    }
}

$(document).ready(function() {
    SL2411030040101.init();
});
