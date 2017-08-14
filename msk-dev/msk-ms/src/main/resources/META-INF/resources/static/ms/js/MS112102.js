/**
 * Created by jiang_nan on 16/1/8.
 */
var MS112102 = {
    uploadButton : "uploadButton",
    init : function(){
        MS112102.bindUploadButton();
    },
    bindUploadButton : function(){
        $("#"+MS112102.uploadButton).click(function(){
            var $uploadFile = $("#MS112102_FORM_SUBMIT");
            var path=$("#importFile").val();
            var pos = path.lastIndexOf('.');
            var result = path.substring(pos+1,path.length);
            if(result!='xls'){
                alert("上传文件无效!请上传模板样式文件!");
            }else{
            	$.core.uploadForm($uploadFile, true);
            }
        });
    }
}
$(document).ready(function() {
    MS112102.init();
});

