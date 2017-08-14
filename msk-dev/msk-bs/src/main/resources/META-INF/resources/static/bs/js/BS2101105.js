/**
 * 买手店修改JS
 *
 * @author cx
 */
var BS2101105 = {
    formId: "BS2101105Form",
    updateButtonId: "BS2101105_UPDATE",

    init: function () {
        $("#slSellerPage").postUrl(Main.contextPath + "/BS2101106/init", {
            slIdcard:slIdcard,
            slAccount:slAccount,
            slCode:slCode,
            slCodeDis:slCodeDis,
            slConFlg:slConFlg,
            flag1:flag1,
            shopQua:shopQua,
            memo1:memo1,
            memo2:memo2,
            memo3:memo3,
            memo4:memo4,
            memo5:memo5,
            memo6:memo6,
            slAddress:slAddress,
            lat:lat,
            lon:lon,
            provinceCode:provinceCode,
            cityCode:cityCode,
            districtCode:districtCode,
            flagNum:flagNum,
            memo8:memo8
        });
        
        $("#slShopInfo").postUrl(Main.contextPath + "/BS2101110/init", {
            slCode:slCode,
            shopId:shopId,
            shopName: shopName,
            shopLogo: shopLogo,
            managingCharact1: managingCharact1,
            managingCharact2: managingCharact2,
            managingCharact3: managingCharact3,
            flagNum:flagNum
        });
        this.bindSavebutton();
    },

    bindSavebutton : function() {
        $("#" + BS2101105.updateButtonId).click(function() {
            BS2101105.saveData();
        });
    },
    saveData : function() {
        var validator = mainValidation($("#" + BS2101105.formId));
        var isValid = validator.form();
        if (isValid) {
            formData = getFormData($("#" + BS2101105.formId));
            var $uploadFile = $("#BS2101105Form");
            $.core.uploadForm($uploadFile, true);
        };
    }
}
$(document).ready(function () {
    // 初始化调用
    BS2101105.init();
});

function accountTest(){
    var name = $('#slAccount1').val();
    console.log(name)
    if(name==null || name==""){
        $('#account_sp').html('<font style="color:red">账号不能为空！</font>');
        return false;
    }
    $('#account_sp').html('');
    return true;
}

function pwdTest(){

    var pwd = $('#accountPsd').val();
    if(pwd==null || pwd==""){
        $('#pwd_sp').html('<font style="color:red">密码不能为空！</font>');
        return false;
    }
    $('#pwd_sp').html('');
    return true;
}