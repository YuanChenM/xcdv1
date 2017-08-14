/**
 * Created by fjm on 2016/1/27.
 */
var SL241103002 = {

    formId : "SL241103002Form",
    saveButtonId : "SL241103002_SAVE",
    backButtonId : "SL241103002_BACK",

    init : function(){
        this.bindSavebutton();
        this.bindBackbutton();
        this.bindDatePicber('#licCrtDate');
        this.bindDatePicber('#licTermBegin');
        this.bindDatePicber('#licTermEnd');
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
        $("#" + SL241103002.saveButtonId).click(function() {
            SL241103002.saveData();
        });
    },
    bindBackbutton : function() {
        $("#" + SL241103002.backButtonId).click(function() {
            $.pdialog.close();
        });
    },
    saveData : function() {
        var validator = mainValidation($("#" + SL241103002.formId));
        var isValid = validator.form();
        var licCrtDate=$("#licCrtDate").val();
        var licTermBegin=$("#licTermBegin").val();
        var licTermEnd=$("#licTermEnd").val();
        if (isValid) {
            if(licCrtDate==null || licCrtDate==""){
                $("input[name='licCrtDate']").remove();
                //$("#licCrtDate").val($("#licCrtDate").val()+"0000-00-00 00:00:00");
            }else{
                $("#licCrtDate").val($("#licCrtDate").val()+" 00:00:00");
            }
            if(licTermBegin==null || licTermBegin==""){
                $("input[name='licTermBegin']").remove();
                //$("#licTermBegin").val($("#licTermBegin").val()+"0000-00-00 00:00:00");
            }else{
                $("#licTermBegin").val($("#licTermBegin").val()+" 00:00:00");
            }
            if(licTermEnd==null || licTermEnd==""){
                $("input[name='licTermEnd']").remove();
                //$("#licTermEnd").val($("#licTermEnd").val()+"0000-00-00 00:00:00");
            }else{
                $("#licTermEnd").val($("#licTermEnd").val()+" 00:00:00");
            }
            formData = getFormData($("#" + SL241103002.formId));
            $('#main-content').postUrl(
                $("#" + SL241103002.formId).attr("action"),
                formData,
                function() {
                    $('#main-content').postUrl(Main.contextPath + "/SL241101/init");
                });
        };
    }
}

$(document).ready(function() {
    SL241103002.init();
});
