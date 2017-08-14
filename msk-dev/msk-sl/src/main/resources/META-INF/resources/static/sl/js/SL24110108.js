/**
 * Created by fjm on 2016/1/30.
 */


/**
 * Created by fjm on 2016/1/27.
 */
var SL24110108 = {
    formId : "SL24110108Form",
    saveButtonId : "SL24110108_UPDATE",
    deleteButtonId : "SL24110108_DELETE",
    addButtonId : "SL24110108_ADD",

    init : function(){
        this.bindUpdatebutton();
        this.bindDeleteButton();
        this.bindAddbutton();
    },
    bindAddbutton : function () {
        $("#" + SL24110108.addButtonId).click(function(){
            $.pdialog.open("公司成员添加",Main.contextPath + "/SL2411030081/init");
        });
    },
    bindDeleteButton : function(){
        for(var i=0;i<maSize;i++){
            (function(i){
                $("#SL24110108_DELETE"+i).click(function() {
                    var validator = mainValidation($("#SL24110108Form"+i));
                    var isValid = validator.form();
                    if (isValid) {
                        formData = getFormData($("#SL24110108Form"+i));
                        $('#main-content').postUrl(Main.contextPath+ "/SL24110108/delete",formData,function() {
                            $('#main-content').postUrl(Main.contextPath + "/SL241101/init");
                        });
                    }
                });
            })(i);
        }
    },
    bindUpdatebutton : function() {
        for(var i=0;i<maSize;i++){
            (function(i){
                $("#SL24110108_UPDATE"+i).click(function() {
                    var validator = mainValidation($("#SL24110108Form"+i));
                    var isValid = validator.form();
                    if (isValid) {
                        formData = getFormData($("#SL24110108Form"+i));
                        var $uploadFile = $("#SL24110108Form"+i);
                        $.core.uploadForm($uploadFile, true);
                    }
                });
            })(i);
        }
    }
}

$(document).ready(function() {
    SL24110108.init();
});
