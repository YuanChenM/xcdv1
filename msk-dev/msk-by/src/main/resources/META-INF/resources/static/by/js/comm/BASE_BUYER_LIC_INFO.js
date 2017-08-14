/**
 * 买家详细信息
 * Created by marshall on 16/3/9.
 */
var baseBuyerLic = {
    licEditButtonId:"BuyerLic_Edit",
    licSaveButtonId:"BuyerLic_Save",
    formId:"licEditForm",
    initDataGrid: function () {
        this.bindEditButton();
        this.bindSaveButton();
    },
    bindEditButton:function(){
        $("#"+baseBuyerLic.licEditButtonId).click(function(){
            $("#licShowTable").css("display","none");
            $("#licEditTable").css("display","");
        });
    },
    bindSaveButton:function(){
        $("#"+baseBuyerLic.licSaveButtonId).click(function(){
            $($("#" + baseBuyerLic.formId)).attr("action",Main.contextPath+"/by/baseBuyerLicInfo/update/");
            var $uploadFile = $("#" + baseBuyerLic.formId);
            $.core.uploadForm($uploadFile, true);
        });
    }
}
$(document).ready(function () {
    // 初始化调用
    baseBuyerLic.initDataGrid();
});