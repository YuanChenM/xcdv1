/**
 * Created by fjm on 2016/1/30.
 */
var SL241103012 = {
    formId:"SL241103012Form",
    saveButton:"SL241103012_SAVE",
    init : function(){
        this.saveData();
    },
    saveData:function(){
        $("#"+SL241103012.saveButton).click(function() {
            var $uploadFile = $("#SL241103012Form");
            $.core.uploadForm($uploadFile, true);
        });
       /* $("#"+SL241103012.saveButton).click(function(){
            var ddNameId = $("#ddNameId").val();
            if(null==ddNameId || ''==ddNameId){
                $.alertMessage.info("设备名称不能为空!");
                return;
            }
            formData = getFormData($("#" + SL241103012.formId));
            $('#main-content').postUrl($("#" + SL241103012.formId).attr("action"),
                formData,
                function (data) {
                    if(data=="1"){
                        $.alertMessage.info("添加成功!");
                    }else{
                        $.alertMessage.info("添加失败!");
                    }
                },{refreshHtml:false});
        });*/
    }
}

$(document).ready(function() {
    SL241103012.init();
});

