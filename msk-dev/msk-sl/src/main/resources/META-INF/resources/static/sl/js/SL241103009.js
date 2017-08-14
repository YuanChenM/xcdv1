/**
 * Created by fjm on 2016/1/30.
 */
var SL241103009 = {

    formId : "SL241103009Form",
    saveButtonId : "SL241103009_SAVE",
    addButtonId : "SL241103009_ADD",
    init : function(){
        this.bindSavebutton();
        this.bindAddbutton();
    },
    bindAddbutton : function(){

        $("#"+SL241103009.addButtonId).click(function(){
                $.pdialog.open("添加电商团队成员",Main.contextPath+"/SL2411030091/init");
            }
        )
    },
    bindSavebutton : function() {
        $("#" + SL241103009.saveButtonId).click(function() {
            SL241103009.uploadData();
        });
    },
    uploadData : function(){
        var $uploadFile = $("#SL241103009Form");
        $.core.uploadForm($uploadFile, true);
    }
}

$(document).ready(function() {
    SL241103009.init();
});

