/**
 * Created by fjm on 2016/1/26.
 */
var SL241103001 = {

    formId : "SL241103001Form",
    saveButtonId : "SL241103001_SAVE",
    backButtonId : "SL241103001_BACK",

    init : function(){
        this.bindSavebutton();
        this.bindDatePicber('#licCrtDate');
        this.bindDatePicber('#licTermBegin');
        this.bindDatePicber('#licTermEnd');
        this.bindDatePicber('#orgTermBegin');
        this.bindDatePicber('#orgTermEnd');
        this.bindDatePicber('#fdlTermBegin');
        this.bindDatePicber('#fdlTermEnd');
        this.changeSelect();
        this.checkRadio();

    },
    changeSelect:function(){
        var citySelect=$('#city_select');
        var districtSelect=$('#district_select');
        $('#province_select').change(function () {
            $("#city_select").find("option").not(":first").remove();
            $("#district_select").find("option").not(":first").remove();
            var provinceCode = $('#province_select').val();
            if(provinceCode!=0){
                $('#main-content').postUrl(Main.contextPath + '/SL241103000/findCity',{provinceCode:provinceCode},
                    function(data){
                        $.each(data, function(i, item) {
                            citySelect.append("<option value='" + item.cityCode+ "'>"+ item.cityName+ "</option>");
                        });
                    },{refreshHtml:false});
            }
        });
        $('#city_select').change(function(){
            $("#district_select").find("option").not(":first").remove();
            var cityCode=$("#city_select").val();
            if(cityCode!=0){
                $('#main-content').postUrl(Main.contextPath + '/SL241103000/findDistrict',{cityCode:cityCode},function(data2){
                    $.each(data2, function(i, item) {
                        districtSelect.append("<option value='" + item.districtCode+ "'>"+ item.districtName+ "</option>");
                    });
                },{refreshHtml:false})
            }
        });
    },
    bindDatePicber : function(orderTimeId){
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
        });
    },

    bindSavebutton : function() {
        $("#" + SL241103001.saveButtonId).click(function() {
            SL241103001.uploadData();
        });
    },
    checkRadio : function() {
        $("input[name='slMainClass']").click(function(){
            $(this).attr("checked","checked");
            var dataValue=$(this).attr("value");
            if(dataValue==0){
                $("input[name='slSecondaryClass'][value='1']").prop("checked",true);
                $("input[name='slSecondaryClass'][value='2']").prop("checked",false);
                $("input[name='slSecondaryClass'][value='3']").prop("checked",false);
            }
            if(dataValue==1){
                $("input[name='slSecondaryClass'][value='1']").prop("checked",true);
                $("input[name='slSecondaryClass'][value='2']").prop("checked",false);
                $("input[name='slSecondaryClass'][value='3']").prop("checked",false);
            }
            if(dataValue==2){
                $("input[name='slSecondaryClass'][value='2']").prop("checked",true);
                $("input[name='slSecondaryClass'][value='1']").prop("checked",false);
                $("input[name='slSecondaryClass'][value='3']").prop("checked",false);
            }
            if(dataValue==3){
                $("input[name='slSecondaryClass'][value='3']").prop("checked",true);
                $("input[name='slSecondaryClass'][value='2']").prop("checked",false);
                $("input[name='slSecondaryClass'][value='1']").prop("checked",false);
            }
        });

        $("input[name='licType']").click(function(){
            if($(this).val()==1){
                $("#epthrfileId").attr("disabled",false);
                $("#licfileId").attr("disabled",true);
                $("#taxfileId").attr("disabled",true);
                $("#orgfileId").attr("disabled",true);
            }else if($(this).val()==0){
                $("#epthrfileId").attr("disabled",true);
                $("#licfileId").attr("disabled",false);
                $("#taxfileId").attr("disabled",false);
                $("#orgfileId").attr("disabled",false);
            }
        });
    },
    uploadData : function(){
        var licDate = $('#licCrtDate').val();
        var licBegin = $('#licTermBegin').val();
        var licEnd = $('#licTermEnd').val();
        var orgTermBegin = $('#orgTermBegin').val();
        var orgTermEnd = $('#orgTermEnd').val();
        var fdlTermBegin = $('#fdlTermBegin').val();
        var fdlTermEnd = $('#fdlTermEnd').val();

        var validator = mainValidation($("#" + SL241103001.formId));
        var isValid = validator.form();

        var y=$('#accountPsd').val();
        var x=$('#slAccount').val();
        if(x==null || x==""){
            alert("账号不能为空！");
            $('#account_sp').html('<font style="color:red">账号不能为空！</font>');
            isValid=false;
        }
        if(y==null || y==""){
            alert("密码不能为空！");
            $('#pwd_sp').html('<font style="color:red">密码不能为空！</font>');
            isValid=false;
        }
        formData = getFormData($("#" + SL241103001.formId));
        if (isValid) {
            var $uploadFile = $("#SL241103001Form");
            if(licDate==null || licDate==""){
                $("input[name='licCrtDate']").remove();
                //$("#licCrtDate").val("2015-12-12 22:22:22");
            }else{
                $("#licCrtDate").val($("#licCrtDate").val()+" 00:00:00");
            }

            if(licBegin==null || licBegin==""){
                $("input[name='licTermBegin']").remove();
                //$("#licTermBegin").val("0000-00-00 00:00:00");
            }else{
                $("#licTermBegin").val($("#licTermBegin").val()+" 00:00:00");
            }

            if(licEnd==null || licEnd==""){
                $("input[name='licTermEnd']").remove();
               // $("#licTermEnd").val("0000-00-00 00:00:00");
            }else{
                $("#licTermEnd").val($("#licTermEnd").val()+" 00:00:00");
            }

            if(orgTermBegin==null || orgTermBegin==""){
                $("input[name='orgTermBegin']").remove();
                //$("#orgTermBegin").val("0000-00-00 00:00:00");
            }else{
                $("#orgTermBegin").val($("#orgTermBegin").val()+" 00:00:00");
            }

            if(orgTermEnd==null || orgTermEnd==""){
                $("input[name='orgTermEnd']").remove();
               // $("#orgTermEnd").val("0000-00-00 00:00:00");
            }else{
                $("#orgTermEnd").val($("#orgTermEnd").val()+" 00:00:00");
            }

            if(fdlTermBegin==null || fdlTermBegin==""){
                $("input[name='fdlTermBegin']").remove();
                //$("#fdlTermBegin").val("0000-00-00 00:00:00");
            }else{
                $("#fdlTermBegin").val($("#fdlTermBegin").val()+" 00:00:00");
            }

            if(fdlTermEnd==null || fdlTermEnd==""){
                $("input[name='fdlTermEnd']").remove();
               // $("#fdlTermEnd").val("0000-00-00 00:00:00");
            }else{
                $("#fdlTermEnd").val($("#fdlTermEnd").val()+" 00:00:00");
            }
            $.core.uploadForm($uploadFile, true);
        }
    }
}

$(document).ready(function() {
    SL241103001.init();
});

function pwdTest(){
    var pwd=document.getElementById('accountPsd').value;
    if(pwd==null || pwd==""){
        $('#pwd_sp').html('<font style="color:red">密码不能为空！</font>');
        return false;
    }
    $('#pwd_sp').html('');
    return true;
}
function accountTest(){
    var pwd=document.getElementById('slAccount').value;
    if(pwd==null || pwd==""){
       // document.getElementById('account_sp').innerHTML="<font style='color:red'>账号不能为空！</font>";
        $('#account_sp').html('<font style="color:red">账号不能为空！</font>');
        return false;
    }
   // document.getElementById('account_sp').innerHTML="";
    $('#account_sp').html('');
    return true;
}
