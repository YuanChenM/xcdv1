/**
 * Created by fjm on 2016/1/26.
 */
var SL241103008 = {

    formId : "SL241103008Form",
    saveButtonId : "SL241103008_SAVE",
    addButtonId : "SL241103008_ADD",
    init : function(){
        this.bindSavebutton();
        this.bindAddbutton();
        $('#SL241103008accordion').on( "accordionactivate", function( event, ui ) {
            if(ui.newHeader.length==1){
                $("#initSL241103008").postUrl(Main.contextPath+"/SL241103008/init",null,function(data){
                    if(null!=data){
                        var selectData='';
                        $(data).each(function(i,val){
                            selectData+="<option value='"+val.constantValue+"'>"+val.constantName+"</option>";
                        });
                        $("#memberDuties").find("option").not(":first").remove();
                        $("#memberDuties").append(selectData);
                    }
                },{refreshHtml:false });
            }
        } );
    },
    bindAddbutton : function () {
        $("#" + SL241103008.addButtonId).click(function(){
            $.pdialog.open("团队成员添加",Main.contextPath + "/SL2411030081/init");
        });
    },
    bindSavebutton : function() {
        $("#" + SL241103008.saveButtonId).click(function() {
            SL241103008.uploadData();
        });
    },
    uploadData : function(){
        var $uploadFile = $("#SL241103008Form");
        $.core.uploadForm($uploadFile, true);
    }
}

$(document).ready(function() {
    SL241103008.init();
});
