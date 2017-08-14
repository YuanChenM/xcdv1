/**
 * 买家详细信息
 * Created by marshall on 16/3/9.
 */
var BY12130401 = {
    BY12130401Grid: null,
    saveButtonId:"BY12130401_SAVE",
    picChooseButtonId:"busCardPic",
    formId:"BY12130401Form",
    initDataGrid: function () {
        this.bindSaveButton();
        this.picChooseButton();
    },
    bindSaveButton:function(){
        $("#" + BY12130401.saveButtonId).click(function(){
            var validator = mainValidation($("#" + BY12130401.formId));
            var isValid = validator.form();

            if (isValid) {
                var $uploadFile = $("#" + BY12130401.formId);
                $.core.uploadForm($uploadFile, true);
            };
        });
    },
    picChooseButton:function(){
        $("#" + BY12130401.picChooseButtonId).click(function(){
            if(!($("#busCardFlg").is(":checked"))){
                $("#errorMessage").text("请先勾选有无名片照");
                return false;
            }else{
                $("#errorMessage").text("");
            }
        })
    }
}
$(document).ready(function () {
    // 初始化调用
    BY12130401.initDataGrid();
});