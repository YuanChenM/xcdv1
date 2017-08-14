/**
 * Created by fjm on 2016/1/26.
 */
var SL241103007 = {

    formId : "SL241103007Form",
    formId2 : "SL2411030073Form",
    saveButtonId : "SL241103007_SAVE",
    saveButtonId2:"SL2411030073_SAVE",
    addButtonId : "SL241103007_ADD",
    init : function(){
        this.bindSavebutton();
        this.bindAddbutton();
        this.bindDatePicber('#certDate2');
        this.bindDatePicber('#termBegin');
        this.bindDatePicber('#termEnd');
        this.bindDatePicber('#authTermBegin');
        this.bindDatePicber('#authTermEnd');
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
    bindAddbutton : function () {
        $("#" + SL241103007.addButtonId).click(function(){
            $.pdialog.open("品牌添加",Main.contextPath + "/SL2411030071/init");
        });
    },
    bindSavebutton : function() {
        $("#" + SL241103007.saveButtonId).click(function() {
            SL241103007.uploadData();
        });
        $("#" + SL241103007.saveButtonId2).click(function() {
            SL241103007.saveData2();
        });
    },
    saveData2 : function(){
        var validator = mainValidation($("#" + SL241103007.formId2));
        var isValid = validator.form();
        var authTermBegin = $('#authTermBegin').val();
        var authTermEnd = $('#authTermEnd').val();
        if (isValid) {
            if(authTermBegin==null || authTermBegin==""){
                $("input[name='authTermBegin']").remove();
                //$("#authTermBegin").val($("#authTermBegin").val()+"0000-00-00 00:00:00");
            }else{
                $("#authTermBegin").val($("#authTermBegin").val()+" 00:00:00");
            }
            if(authTermEnd==null || authTermEnd==""){
                $("input[name='authTermEnd']").remove();
                //$("#authTermEnd").val($("#authTermEnd").val()+"0000-00-00 00:00:00");
            }else{
                $("#authTermEnd").val($("#authTermEnd").val()+" 00:00:00");
            }
            formData = getFormData($("#" + SL241103007.formId2));
            $('#main-content').postUrl(
                $("#" + SL241103007.formId2).attr("action"),
                formData,
                //function() {
                //    $('#main-content').postUrl(Main.contextPath + "/SL241103000/init");
                //}
                {refreshHtml:false});
        };
    },
    uploadData : function(){
        var $uploadFile = $("#SL241103007Form");
        var certDate2 = $('#certDate2').val();
        var termBegin = $('#termBegin').val();
        var termEnd = $('#termEnd').val();
        if(certDate2==null || certDate2==""){
            $("input[name='certDate']").remove();
            //$("#certDate2").val($("#certDate2").val()+"0000-00-00 00:00:00");
        }else{
            $("#certDate2").val($("#certDate2").val()+" 00:00:00");
        }

        if(termBegin==null || termBegin==""){
            $("input[name='termBegin']").remove();
            //$("#termBegin").val($("#termBegin").val()+"0000-00-00 00:00:00");
        }else{
            $("#termBegin").val($("#termBegin").val()+" 00:00:00");
        }

        if(termEnd==null || termEnd==""){
            $("input[name='termEnd']").remove();
            //$("#termEnd").val($("#termEnd").val()+"0000-00-00 00:00:00");
        }else{
            $("#termEnd").val($("#termEnd").val()+" 00:00:00");
        }
        if($("#brandNo").val()==null || $("#brandNo").val()==""){
            $.alertMessage.info("商标注册证编码不能为空!");
            return;
        }
        $.core.uploadForm($uploadFile, true);
    }
}

$(document).ready(function() {
    SL241103007.init();
});
