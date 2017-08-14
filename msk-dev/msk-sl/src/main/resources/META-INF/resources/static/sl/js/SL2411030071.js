/**
 * Created by fjm on 2016/1/26.
 */
var SL2411030071 = {

    formId : "SL2411030071Form",
    formId2 : "SL24110300711Form",
    saveButtonId : "SL2411030071_SAVE",
    saveButtonId2:"SL24110300711_SAVE",
    init : function(){
        this.bindSavebutton();
        this.bindDatePicber('#certDate71');
        this.bindDatePicber('#termBegin71');
        this.bindDatePicber('#termEnd71');
        this.bindDatePicber('#authTermBegin711');
        this.bindDatePicber('#authTermEnd711');
        this.changeSelect();

    },
    changeSelect:function(){
        var pdClasses=$('#prolist');
        var pdBreed=$('#brandlist');
        pdClasses.change(function(){
            var pdClassesVal=pdClasses.val();
            var pdBreedVal=pdBreed.val();
            $('#main-content').postUrl(Main.contextPath + "/SL241103000/findBrand",{'filterMap[producerEpId]':pdClassesVal},function(data){
                $('#classesName').val(pdClasses.find("option:selected").text());
                pdBreed.html('');
                pdBreed.append("<option value=''>请选择</option>");
                $.each(data, function(i, item) {
                    if (item.brandId === pdBreedVal) {
                        pdBreed.append("<option selected='selected' value='" + item.brandName + "'>"+ item.brandName+ "</option>");
                    } else {
                        pdBreed.append("<option value='" + item.brandName + "'>"+ item.brandName+ "</option>");
                    }
                });
            },{refreshHtml:false});
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
        $("#" + SL2411030071.saveButtonId).click(function() {
            SL2411030071.uploadData();
        });
        $("#" + SL2411030071.saveButtonId2).click(function() {
            SL2411030071.saveData2();
        });
    },
    saveData2 : function(){
        var validator = mainValidation($("#" + SL2411030071.formId2));
        var isValid = validator.form();
        var authTermBegin711=$("#authTermBegin711").val();
        var authTermEnd711=$("#authTermEnd711").val();
        if (isValid) {
            if(authTermBegin711==null || authTermBegin711==""){
                $("input[name='authTermBegin']").remove();
                //$("#authTermBegin711").val($("#authTermBegin711").val()+"0000-00-00 00:00:00");
            }else{
                $("#authTermBegin711").val($("#authTermBegin711").val()+" 00:00:00");
            }

            if(authTermEnd711==null || authTermEnd711==""){
                $("input[name='authTermEnd']").remove();
               // $("#authTermEnd711").val($("#authTermEnd711").val()+"0000-00-00 00:00:00");
            }else{
                $("#authTermEnd711").val($("#authTermEnd711").val()+" 00:00:00");
            }
            formData = getFormData($("#" + SL2411030071.formId2));
            $('#main-content').postUrl(
                $("#" + SL2411030071.formId2).attr("action"),
                formData,
                //function() {
                //    $('#main-content').postUrl(Main.contextPath + "/SL24110100/init");
                //}
                {refreshHtml:false});
        };
    },
    uploadData : function(){
        var $uploadFile = $("#SL2411030071Form");
        var certDate71 =$("#certDate71").val();
        var termBegin71 =$("#termBegin71").val();
        var termEnd71 =$("#termEnd71").val();
        if(certDate71==null || certDate71==""){
            $("input[name='certDate']").remove();
            //$("#certDate71").val($("#certDate71").val()+"0000-00-00 00:00:00");
        }else{
            $("#certDate71").val($("#certDate71").val()+" 00:00:00");
        }
        if(termBegin71==null || termBegin71==""){
            $("input[name='termBegin']").remove();
            //$("#termBegin71").val($("#termBegin71").val()+"0000-00-00 00:00:00");
        }else{
            $("#termBegin71").val($("#termBegin71").val()+" 00:00:00");
        }
        if(termEnd71==null || termEnd71==""){
            $("input[name='termEnd']").remove();
            //$("#termEnd71").val($("#termEnd71").val()+"0000-00-00 00:00:00");
        }else{
            $("#termEnd71").val($("#termEnd71").val()+" 00:00:00");
        }
        if($("#brandNo2").val()==null || $("#brandNo2").val()==""){
            $.alertMessage.info("商标注册证编码不能为空!");
            return;
        }
        $.core.uploadForm($uploadFile, true);
    }
}

$(document).ready(function() {
    SL2411030071.init();
});
