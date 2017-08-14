/**
 * 买家详细信 息
 * Created by marshall on 16/3/9.
 */
var baseBuyerBasic = {
    basicEditButtonId:"Basic_Edit",
    basicSaveButtonId:"Basic_Save",
    buyerTypeEditButtonId:"BuyerType_Edit",
    buyerTypeSaveButtonId:"BuyerType_Save",
    accountSeeButtonId:"Basic_SeeAccount",
    formId:"basicEditForm",
    buyerTypeFormId:"buyerTypeForm",
    initDataGrid: function () {
        this.bindEditButton();
        this.bindAccountSeeButton();
        this.bindSaveButton();
        this.bindSelectChange();
    },
    bindEditButton:function(){
        $("#"+baseBuyerBasic.basicEditButtonId).click(function(){
            $("#showTable").css("display","none");
            $("#editTable").css("display","");
        });
        $("#"+baseBuyerBasic.buyerTypeEditButtonId).click(function(){
            $("#buyerTypeShow").css("display","none");
            $("#buyerTypeEdit").css("display","");
        });
    },
  /*  bindAccountSeeButton:function(){
        $("#" + baseBuyerBasic.accountSeeButtonId).click(function(){
            var telNo = $("#telNo").val();
            var accountName = $("#accountName").val();
            var accountPass = $("#accountPass").val();
            var str = "手机号："+telNo+"<br/>"+"账号："+accountName+"<br/>"+"密码："+accountPass;
            $.alertMessage.prompt(str, function() {
                $.alertMessage.close();
            });

        });
    },*/

    bindAccountSeeButton:function(){
        $("#" + baseBuyerBasic.accountSeeButtonId).click(function(){
            $.pdialog.open("重置账号密码", Main.contextPath + "/by/baseBuyerBasicInfo/initAccountPwd", {
                    resizable: false,
                    width: 500,
                    height: 300},
                {
                    buyerId:$("#buyerId").val(),
                    telNo : $("#telNo").val(),
                     accountName :$("#accountName").val(),
                    accountPass : $("#accountPass").val()
                });
        });
    },
    bindSaveButton:function(){
        $("#"+baseBuyerBasic.basicSaveButtonId).click(function(){
            $($("#" + baseBuyerBasic.formId)).attr("action",Main.contextPath+"/by/baseBuyerBasicInfo/update/");
            var validator = mainValidation($("#" + baseBuyerBasic.formId));
            var isValid = validator.form();

            if (isValid) {
                var formData = getFormData($("#" + baseBuyerBasic.formId));
                $('#main-content').postUrl($("#" + baseBuyerBasic.formId).attr("action"),formData,{refreshHtml:false});
            };
        });

        $("#"+baseBuyerBasic.buyerTypeSaveButtonId).click(function(){
            $($("#" + baseBuyerBasic.buyerTypeFormId)).attr("action",Main.contextPath+"/by/baseBuyerBasicInfo/update/");
            var validator = mainValidation($("#" + baseBuyerBasic.buyerTypeFormId));
            var isValid = validator.form();

            if (isValid) {
                var formData = getFormData($("#" + baseBuyerBasic.buyerTypeFormId));
                $('#main-content').postUrl($("#" + baseBuyerBasic.buyerTypeFormId).attr("action"),formData,{refreshHtml:false});
            };
        });
    },
    bindSelectChange:function(){
        $("#lgcsAreaCode").change(function(){
            var lgcsAreaCode = $("#lgcsAreaCode option:selected").val();
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/lgcsAreaChange/" + lgcsAreaCode,null,
                function(data){
                    $("#cityCode").html("");
                    $("#cityCode").append("<option value=''>请选择</option>");
                    $("#districtCode").html("");
                    $("#districtCode").append("<option value=''>请选择</option>");
                    $.each(data,function(i,item){
                        $("#cityCode").append("<option value='" + item.cityCode + "'>"+ item.cityName+ "</option>");
                    });
            },{refreshHtml:false});
        });

        $("#cityCode").change(function(){
            var cityCode = $("#cityCode option:selected").val();
            if(cityCode == ""){
                return false;
            }
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/cityChange/" + cityCode,null,
                function(data){
                    $("#districtCode").html("");
                    $("#districtCode").append("<option value=''>请选择</option>");
                    $.each(data,function(i,item){
                        $("#districtCode").append("<option value='" + item.districtCode + "'>"+ item.districtName+ "</option>");
                    });
                },{refreshHtml:false});
        });

        $("#districtCode").change(function(){
            var superiorType = $("#superiorType option:selected").val();
            var lgcsAreaCode = $("#lgcsAreaCode option:selected").val();
            var cityCode = $("#cityCode option:selected").val();
            var districtCode = $("#districtCode option:selected").val();
            if(districtCode == ""){
                return false;
            }
            $("#superiorQua").val("");
            baseBuyerBasic.findMarket(superiorType,lgcsAreaCode,cityCode,districtCode);
        });
        $("#superiorType").change(function(){
            var superiorType = $("#superiorType option:selected").val();
            var lgcsAreaCode = $("#lgcsAreaCode option:selected").val();
            var cityCode = $("#cityCode option:selected").val();
            var districtCode = $("#districtCode option:selected").val();
            $("#superiorDec").css("display","block");
            $("#superiorId").css("display","block");
            $("#superiorQuaDec").css("display","block");
            $("#superiorQua").css("display","block");
            baseBuyerBasic.findMarket(superiorType,lgcsAreaCode,cityCode,districtCode);
        });

        $("#superiorId").change(function(){
            var superiorType = $("#superiorType option:selected").val();
            var superiorId = $("#superiorId option:selected").val();
            $("#superiorQua").val("");
            if(superiorId == ""){
                return false;
            }
            if(superiorType == "1"){
                $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketTermial/" + superiorId,null,
                    function(data){
                        if(data != null){
                            $("#superiorQua").val(data.marketLevelName);
                        }
                    },{refreshHtml:false});
            }else if(superiorType == "2"){
                $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketFood/" + superiorId,null,
                    function(data){
                        if(data != null){
                            $("#superiorQua").val(data.sizeTypeName);
                        }
                    },{refreshHtml:false});
            }
        });
        $("#buyerTypeId").change(function () {
            var superiorType = $("#superiorType option:selected").val();
            var buyerType = $("#buyerTypeId option:selected").val();
            $("#superiorSubName").val($("#buyerTypeId option:selected").text());
            if (superiorType == "8" && buyerType == "1") {
                $('#isFoodMarket').show();
            }else{
                $('#isFoodMarket').hide();
            }
        });
    },
    findMarket:function(superiorType,lgcsAreaCode,cityCode,districtCode){
        if(superiorType == "1"){
            $("#superiorDec").text("批发市场:");
            $("#superiorQuaDec").text("批发市场等级:");
            $("#superiorQua").val("");
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketTermialList/",{
                    "lgcsAreaCode":lgcsAreaCode,
                    "cityCode":cityCode,
                    "districtCode":districtCode
                },
                function(data){
                    $("#superiorId").html("");
                    $("#superiorId").append("<option value=''>请选择</option>");
                    $.each(data,function(i,item){
                        $("#superiorId").append("<option value='" + item.terMarketId + "'>"+ item.marketName+ "</option>");
                    });
                },{refreshHtml:false});
        }else if(superiorType == "2"){
            $("#superiorDec").text("菜场:");
            $("#superiorQuaDec").text("菜场等级:");
            $("#superiorQua").val("");
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findMarketFoodList/",{
                    "lgcsAreaCode":lgcsAreaCode,
                    "cityCode":cityCode,
                    "districtCode":districtCode
                },
                function(data){
                    $("#superiorId").html("");
                    $("#superiorId").append("<option value=''>请选择</option>");
                    $.each(data,function(i,item){
                        $("#superiorId").append("<option value='" + item.fodMarketId + "'>"+ item.marketName+ "</option>");
                    });
                },{refreshHtml:false});
        }else{
            $("#superiorDec").text("");
            $("#superiorId").html("");
            $("#superiorQuaDec").text("");
            $("#superiorQua").val("");
            $("#superiorDec").css("display","none");
            $("#superiorId").css("display","none");
            $("#superiorQuaDec").css("display","none");
            $("#superiorQua").css("display","none");
        }
       debugger;
        $("#superiorSubName").val();
        //二级分类
        if (superiorType == "5") {
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findBuyerList/chinesFoodType", null,
                function (data) {
                    $("#buyerTypeId").html("");
                    $("#buyerTypeId").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#buyerTypeId").append("<option value='" + item.constantValue + "'>" + item.constantName + "</option>");
                    });
                }, {refreshHtml: false});
        } else if (superiorType == "8") {
            $('#main-content').postUrl(Main.contextPath + "/by/baseBuyerBasicInfo/findBuyerList/machiningType", null,
                function (data) {
                    $("#buyerTypeId").html("");
                    $("#buyerTypeId").append("<option value=''>请选择</option>");
                    $.each(data, function (i, item) {
                        $("#buyerTypeId").append("<option value='" + item.constantValue + "'>" + item.constantName + "</option>");
                    });
                }, {refreshHtml: false});
        }else{
            $("#buyerTypeId").html("");
            $("#buyerTypeId").append("<option value=''>请选择</option>");
        }
        var buyerType = $("#buyerTypeId option:selected").val();
        if (superiorType == "8" && buyerType == "1") {
            $('#isFoodMarket').show();
        }else{
            $('#isFoodMarket').hide();
        }
    }
}
$(document).ready(function () {
    // 初始化调用
    baseBuyerBasic.initDataGrid();
});