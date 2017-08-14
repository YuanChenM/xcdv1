var ResetAccountPwd = {
    ResetAccountPwdGrid: null,
    accountResetButtonId:"Account_Reset",
    CancelButtonId:"Account_Cancel",
    formId:"resetAccountFrom",
    initDataGrid: function () {
        this.bindCancelButton();
        this.bindAccountResetButton();
    },
    bindCancelButton:function(){
        $("#"+ResetAccountPwd.CancelButtonId).click(function(){
            $.pdialog.close();
        });
    },
    bindAccountResetButton:function(){
        $("#" + ResetAccountPwd.accountResetButtonId).click(function(){
            var formData = getFormData($("#" + ResetAccountPwd.formId));
            var url = Main.contextPath+"/by/baseBuyerBasicInfo/reset/accountPwd/";
            $('#main-content').postUrl(url, formData, function(data){
                if(data =="0"){
                    $.alertMessage.warn("该账号已存在");
                }else{
                    $("#accountName").val($("#accountNewName").val());
                    $("#accountPass").val($("#accountNewPass").val());
                    $("#telNo").val($("#telNewNo").val());
                    $.pdialog.close();
                }
            }, {refreshHtml:false});
        });
    },
    changePassWord:function(){
        var accountVal= $("#accountNewName").val();
        var passWord = accountVal.substring(accountVal.length-8,accountVal.length);
        $("#accountNewPass").val(passWord);
    }
}
$(document).ready(function () {
    // 初始化调用
    ResetAccountPwd.initDataGrid();
});