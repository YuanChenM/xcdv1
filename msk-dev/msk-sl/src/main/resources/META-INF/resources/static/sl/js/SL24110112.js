/**
 * Created by fjm on 2016/1/27.
 */
var SL24110112 = {
    updateButtonId : "SL24110112_UPDATE",
    addButtonId : "SL24110112_ADD",
    init : function(){
        this.bindDeletebutton();
        this.bindUpdatebutton();
        this.bindAddbutton();
    },
    bindAddbutton : function () {
        $("#" + SL24110112.addButtonId).click(function(){
            $.pdialog.open("检测设备添加",Main.contextPath + "/SL24110301201/init",{
                width: 600,
                height: 350
            });
        });
    },
    bindDeletebutton : function() {
        for(var i=0;i<maSize;i++){
            (function(i){
                $("#SL24110112_DELETE"+i).click(function() {
                    var validator = mainValidation($("#SL24110112Form"+i));
                    var isValid = validator.form();
                    if (isValid) {
                        formData = getFormData($("#SL24110112Form"+i));
                        $('#main-content').postUrl(Main.contextPath+ "/SL24110112/delete",formData,function() {
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
                $("#" + SL24110112.updateButtonId+i).click(function() {
                    var validator = mainValidation($("#SL24110112Form"+i));
                    var isValid = validator.form();
                    if (isValid) {
                        formData = getFormData($("#SL24110112Form"+i));
                        var $uploadFile = $("#SL24110112Form"+i);
                        $.core.uploadForm($uploadFile, true);
                    }
                });
            })(i);
        }
    }
}
$(document).ready(function() {
    SL24110112.init();
});