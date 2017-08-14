// 图片保存路劲
var picLicensePath = "";
var picOrgStructurePath = "";
var picTaxRegistrationPath = "";
var picFoodCirculationPath = "";
var picCertPath = "";

$(function(){

    if(localStorage.enterFlg == "edit" || localStorage.enterFlg == "view"){
        $("#titleDiv").text("买家信息编辑 - 证照信息");
        $("#saveButtonDiv").text("保存");
    }else{
        $("#titleDiv").text("新买家注册 - 证照信息");
        $("#saveButtonDiv").text("下一步 2/4");
    }

    // 获取企业证照类型下拉框
    var LicType=[];
    var flickerAPI = url+'api/v1/by/common/master';
    var paramData = {"client": "abcd","auth": "xxxx","loginid": "a124","param": {"constantType": "LicType"}};
    $.ajax({
        type : "POST",
        async:false,
        url:flickerAPI,
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(paramData),
        success:function(data){
            LicType = data.result;
        },
        error:function(){
            alert("error");
        }
    });

    // 获取个人证照类型下拉框
    var LegalLicType=[];
    var flickerAPI = url+'api/v1/by/common/master';
    var paramData = {"client": "abcd","auth": "xxxx","loginid": "a124","param": {"constantType": "LegalLicType"}};
    $.ajax({
        type : "POST",
        async:false,
        url:flickerAPI,
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(paramData),
        success:function(data){
            LegalLicType = data.result;
        },
        error:function(){
            alert("error");
        }
    });

    // 初期显示
    var flickerAPI = url+'api/v1/by/licence/find';
    var paramData = {"client": "abcd","auth": "xxxx","loginid": "a124","param": {"buyerId": localStorage.buyerId}};
    $.ajax({
        type : "POST",
        async:false,
        url:flickerAPI,
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(paramData),
        success:function(data){
            if(data.status == "F"){
                return;
            }
            var licenseInfo = data.result;
            //生成营业执照下拉框
            var licTypeSelect = $("#licType");
            licTypeSelect.html("");
            for(var i = 0; i< LicType.length; i++){
                if(LicType[i].constantValue == licenseInfo.licName){
                    licTypeSelect.append("<option selected value="+LicType[i].constantValue+">"+LicType[i].constantName + "</option>")
                } else {
                    licTypeSelect.append("<option value="+LicType[i].constantValue+">"+LicType[i].constantName + "</option>")
                }
            }
            licTypeSelect.selectmenu("refresh");

            $("#licNumber").val(licenseInfo.licNumber);

            //生成法定代表人下拉框
            var legalLicTypeSelect = $("#legalLicType");
            legalLicTypeSelect.html("");
            for(var i = 0; i< LegalLicType.length; i++){
                if(LegalLicType[i].constantValue == licenseInfo.legalLicType){
                    legalLicTypeSelect.append("<option selected value="+LegalLicType[i].constantValue+">"+LegalLicType[i].constantName + "</option>")
                } else {
                    legalLicTypeSelect.append("<option value="+LegalLicType[i].constantValue+">"+LegalLicType[i].constantName + "</option>")
                }
            }
            legalLicTypeSelect.selectmenu("refresh");

            $("#legalName").val(licenseInfo.legalName);
            $("#legalLicNumber").val(licenseInfo.legalLicNumber);
        },
        error:function(){
            alert("error");
        }
    });

    // 图片的地址获取
    var flickerAPI = url+'api/v1/by/pictures/find';
    var paramData = {"client": "abcd","auth": "xxxx","loginid": "a124","param": {"buyerId": localStorage.buyerId}};
    $.ajax({
        type : "POST",
        async:false,
        url:flickerAPI,
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(paramData),
        success:function(data){
            if(data.status == "F"){
                return;
            }
            var picturePath = data.result;
            if(picturePath.picLicensePath){
                $("#picLicense").html("<img src='"+picturePath.picLicensePath+"' style='width: 270;height: 200px;'>");
            }
            if(picturePath.picOrgStructurePath){
                $("#picOrgStructure").html("<img src='"+picturePath.picOrgStructurePath+"' style='width: 270;height: 200px;'>");
            }
            if(picturePath.picTaxRegistrationPath){
                $("#picTaxRegistration").html("<img src='"+picturePath.picTaxRegistrationPath+"' style='width: 270;height: 200px;'>");
            }
            if(picturePath.picFoodCirculationPath){
                $("#picFoodCirculation").html("<img src='"+picturePath.picFoodCirculationPath+"' style='width: 270;height: 200px;'>");
            }
            if(picturePath.picCertPath){
                $("#picCert").html("<img src='"+picturePath.picCertPath+"' style='width: 270;height: 200px;'>");
            }
        },
        error:function(){
            alert("error");
        }
    });
});

/*
 * 证件照片上传
 */
function upload(obj) {
    //获取上传照片的名称
    var path = "";
    var pos = "";
    var result = "";
    if(obj.id == "picLicenseForm"){
        $("#message").css("display","none");
        path = $("#picLicenseFile").val();
        pos = path.lastIndexOf('\\');
        result = path.substring(pos + 1, path.length);
        var name = result.split(".");
        if(name[1].toLowerCase() != "jpg" && name[1].toLowerCase() != "png" && name[1].toLowerCase() != "bmp" && name[1].toLowerCase() != "jpeg"){
            setMessageDivStyle("请上传正确的图片格式。", "message");
            return;
        }
        picLicensePath = pictureUrl + localStorage.buyerId + "/" + result;
    }else if(obj.id == "picOrgStructureForm"){
        $("#message0").css("display","none");
        path = $("#picOrgStructureFile").val();
        pos = path.lastIndexOf('\\');
        result = path.substring(pos + 1, path.length);
        var name0 = result.split(".");
        if(name0[1].toLowerCase() != "jpg" && name0[1].toLowerCase() != "png" && name0[1].toLowerCase() != "bmp" && name0[1].toLowerCase() != "jpeg"){
            setMessageDivStyle("请上传正确的图片格式。", "message0");
            return;
        }
        picOrgStructurePath = pictureUrl + localStorage.buyerId + "/" + result;
    }else if(obj.id == "picTaxRegistrationForm"){
        $("#message1").css("display","none");
        path = $("#picTaxRegistrationFile").val();
        pos = path.lastIndexOf('\\');
        result = path.substring(pos + 1, path.length);
        var name1 = result.split(".");
        if(name1[1].toLowerCase() != "jpg" && name1[1].toLowerCase() != "png" && name1[1].toLowerCase() != "bmp" && name1[1].toLowerCase() != "jpeg"){
            setMessageDivStyle("请上传正确的图片格式。", "message1");
            return;
        }
        picTaxRegistrationPath = pictureUrl + localStorage.buyerId + "/" + result;
    }else if(obj.id == "picFoodCirculationForm"){
        $("#message2").css("display","none");
        path = $("#picFoodCirculationFile").val();
        pos = path.lastIndexOf('\\');
        result = path.substring(pos + 1, path.length);
        var name2 = result.split(".");
        if(name2[1].toLowerCase() != "jpg" && name2[1].toLowerCase() != "png" && name2[1].toLowerCase() != "bmp" && name2[1].toLowerCase() != "jpeg"){
            setMessageDivStyle("请上传正确的图片格式。", "message2");
            return;
        }
        picFoodCirculationPath = pictureUrl + localStorage.buyerId + "/" + result;
    }else if(obj.id == "picCertForm"){
        $("#message3").css("display","none");
        path = $("#picCertFile").val();
        pos = path.lastIndexOf('\\');
        result = path.substring(pos + 1, path.length);
        var name3 = result.split(".");
        if(name3[1].toLowerCase() != "jpg" && name3[1].toLowerCase() != "png" && name3[1].toLowerCase() != "bmp" && name3[1].toLowerCase() != "jpeg"){
            setMessageDivStyle("请上传正确的图片格式。", "message3");
            return;
        }
        picCertPath = pictureUrl + localStorage.buyerId + "/" + result;
    }
    $("#" + obj.id).attr("action",uploadPath);
    $("#" + obj.id).attr("target", "hidden_frame");
    var actionTypeHid = "<input type='hidden' id='actionType' name='actionType' value='uploadCommon'/>";
    $("#" + obj.id).append(actionTypeHid);
    // 买家ID
    var buyerIdHid = $("#buyerId"+obj.id).val();
    if (!buyerIdHid) {
        var buyerId = "<input type='hidden' id='buyerId"+obj.id+"' name='buyerId' value='" + localStorage.buyerId + "'/>";
        $("#" + obj.id).append(buyerId);
    }
}
function fileUpload(obj){
    var formId = "";
    var picDivId = "";
    if(obj.id == "picLicensePath"){
        formId = "picLicenseForm";
        picDivId = "picLicense";
    }else if(obj.id == "picOrgStructurePath"){
        formId = "picOrgStructureForm";
        picDivId = "picOrgStructure";
    }else if(obj.id == "picTaxRegistrationPath"){
        formId = "picTaxRegistrationForm";
        picDivId = "picTaxRegistration";
    }else if(obj.id == "picFoodCirculationPath"){
        formId = "picFoodCirculationForm";
        picDivId = "picFoodCirculation";
    }else if(obj.id == "picCertPath"){
        formId = "picCertForm";
        picDivId = "picCert";
    }
    $("#" + formId).ajaxSubmit(function(message) {
        // 对于表单提交成功后处理，message为提交页面saveReport.htm的返回内容
        setTimeout(function(){
            if(obj.id == "picLicensePath"){
                $("#" + picDivId).html("<img src='"+picLicensePath+"' style='width: 270;height: 200px;'>");
            }else if(obj.id == "picOrgStructurePath"){
                $("#" + picDivId).html("<img src='"+picOrgStructurePath+"' style='width: 270;height: 200px;'>");
            }else if(obj.id == "picTaxRegistrationPath"){
                $("#" + picDivId).html("<img src='"+picTaxRegistrationPath+"' style='width: 270;height: 200px;'>");
            }else if(obj.id == "picFoodCirculationPath"){
                $("#" + picDivId).html("<img src='"+picFoodCirculationPath+"' style='width: 270;height: 200px;'>");
            }else if(obj.id == "picCertPath"){
                $("#" + picDivId).html("<img src='"+picCertPath+"' style='width: 270;height: 200px;'>");
            }
        },0);
    });
    return false;
}

/**
 * 保存数据
 */
function buyerLicenseInfo(){
    var flickerAPI = url+'api/v1/by/licence/update';
    var buyerId = localStorage.buyerId;
    var licType = $("#licType option:selected").val();
    var licNumber = $("#licNumber").val();
    if(licNumber == ""){
        var message = "请输入营业执照号码";
        setMessageDivStyle(message,"errorMessage");
        return false;
    }
    var legalLicType = $("#legalLicType option:selected").val();
    var legalName = $("#legalName").val();
    if(legalName == ""){
        var message = "请输入法定代表人姓名";
        setMessageDivStyle(message,"errorMessage");
        return false;
    }
    var legalLicNumber = $("#legalLicNumber").val();
    if(legalLicNumber == ""){
        var message = "请输入法定代表人证件号码";
        setMessageDivStyle(message,"errorMessage");
        return false;
    }
    var paramData = {"client": "abcd","auth": "xxxx","loginid": "a124","param": {"buyerId": buyerId, "licName":licType,"licNumber":licNumber, "legalLicType":legalLicType, "legalName":legalName, "legalLicNumber":legalLicNumber}};
    $.ajax({
        type : "POST",
        async:false,
        url:flickerAPI,
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(paramData),
        success:function(data){

        },
        error:function(){

        }
    });

    var flickerAPI = url+'api/v1/by/pictures/update';
    var paramData = {"client": "abcd","auth": "xxxx","loginid": "a124","param": {"buyerId": buyerId, "picLicensePath":picLicensePath,"picOrgStructurePath":picOrgStructurePath, "picTaxRegistrationPath":picTaxRegistrationPath, "picFoodCirculationPath":picFoodCirculationPath, "picCertPath":picCertPath}};
    $.ajax({
        type : "POST",
        async:false,
        url:flickerAPI,
        timeout:60,
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(paramData),
        success:function(data){
            setTimeout(function(){
                if(data.status == "S"){
                    if(localStorage.enterFlg == "edit"){
                        window.location = "BY121211.html";
                    }else{
                        window.location = "BY121208.html";
                    }
                }else{
                    alert(data.message);
                }
            },0);
        },
        error:function(){

        }
    });
}
//返回前一个画面
function returnPage(){
    if(localStorage.enterFlg == "edit"){
        window.location = "BY121211.html";
    }else{
        window.location = "BY121206.html";
    }
}

//设置messageDiv样式
function setMessageDivStyle(message, id){
    $("#"+id).css("border","1px #FF0000 solid");
    $("#"+id).css("color","#FF0000");
    $("#"+id).css("display","block");
    $("#"+id).text(message);
}