/**
 * Created by fjm on 2016/1/28.
 */

var SL24110102 = {

    formId : "SL24110102Form",
    saveButtonId : "SL24110102_SAVE",

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
    bindDatePicber: function (orderTimeId) {
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat: 'yy-mm-dd',
            changeMonth: true,
            changeYear: true,
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
    bindSavebutton : function() {
        $("#" + SL24110102.saveButtonId).click(function() {
            SL24110102.saveData();
        });
    },
    saveData : function() {
        var licCrtDate=$("#licCrtDate").val();
        var licBegin=$("#licTermBegin").val();
        var licEnd=$("#licTermEnd").val();
        var orgTermBegin=$("#orgTermBegin").val();
        var orgTermEnd =$("#orgTermEnd").val();
        var fdlTermBegin=$("#fdlTermBegin").val();
        var fdlTermEnd=$("#fdlTermEnd").val();

        var validator = mainValidation($("#" + SL24110102.formId));
        var isValid = validator.form();

        if (isValid) {
            if(licCrtDate==null || licCrtDate==""){
                $("input[name='licCrtDate']").remove();
                //$("#licCrtDate").val($("#licCrtDate").val()+"0000-00-00 00:00:00");
            }else{
                $("#licCrtDate").val($("#licCrtDate").val()+" 00:00:00");
            }

            if(licBegin==null || licBegin==""){
                $("input[name='licTermBegin']").remove();
               // $("#licTermBegin").val($("#licTermBegin").val()+"0000-00-00 00:00:00");
            }else{
                $("#licTermBegin").val($("#licTermBegin").val()+" 00:00:00");
            }

            if(licEnd==null || licEnd==""){
                $("input[name='licTermEnd']").remove();
               // $("#licTermEnd").val($("#licTermEnd").val()+"0000-00-00 00:00:00");
            }else{
                $("#licTermEnd").val($("#licTermEnd").val()+" 00:00:00");
            }

            if(orgTermBegin==null || orgTermBegin==""){
                $("input[name='orgTermBegin']").remove();
                //$("#orgTermBegin").val($("#orgTermBegin").val()+"0000-00-00 00:00:00");
            }else{
                $("#orgTermBegin").val($("#orgTermBegin").val()+" 00:00:00");
            }

            if(orgTermEnd==null || orgTermEnd==""){
                $("input[name='orgTermEnd']").remove();
                //$("#orgTermEnd").val($("#orgTermEnd").val()+"0000-00-00 00:00:00");
            }else{
                $("#orgTermEnd").val($("#orgTermEnd").val()+" 00:00:00");
            }

            if(fdlTermBegin==null || fdlTermBegin==""){
                $("input[name='fdlTermBegin']").remove();
               // $("#fdlTermBegin").val($("#fdlTermBegin").val()+"0000-00-00 00:00:00");
            }else{
                $("#fdlTermBegin").val($("#fdlTermBegin").val()+" 00:00:00");
            }

            if(fdlTermEnd==null || fdlTermEnd==""){
                $("input[name='fdlTermEnd']").remove();
               // $("#fdlTermEnd").val($("#fdlTermEnd").val()+"0000-00-00 00:00:00");
            }else{
                $("#fdlTermEnd").val($("#fdlTermEnd").val()+" 00:00:00");
            }
            formData = getFormData($("#" + SL24110102.formId));
            var $uploadFile = $("#SL24110102Form");
            $.core.uploadForm($uploadFile, true);
        };
    }
}

$(document).ready(function() {
    SL24110102.init();
});


