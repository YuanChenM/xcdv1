/**
 * Created by fjm on 2016/1/30.
 */
var SL241103010 = {
    formId:"SL241103010Form",
    saveButton:"SL241103010_SAVE",
    init : function(){
        this.bindDatePicber("#authTermBeginThree");
        this.bindDatePicber("#authTermEndTwo");
        this.saveData();
        this.agentCheck();
    },
    bindDatePicber : function(orderTimeId){
        $(orderTimeId).datepicker({
            showButtonPanel: true,
            dateFormat:'yy-mm-dd',
            changeMonth: true,
            changeYear: true
        });
    },
    saveData:function(){
        $("#"+SL241103010.saveButton).click(function(){
            var authTermBeginThree = $("#authTermBeginThree").val();
            if(authTermBeginThree=="" || authTermBeginThree==null){
                $("input[name='authTermBegin']").remove();
                //$("#authTermBeginThree").val($("#authTermBeginThree").val() + "0000-00-00 00:00:00");
            }else {
                $("#authTermBeginThree").val($("#authTermBeginThree").val() + " 00:00:00");
            }
            var authTermEndTwo = $("#authTermEndTwo").val();
            if(authTermEndTwo=="" || authTermEndTwo==null){
                $("input[name='authTermEnd']").remove();
               // $("#authTermEndTwo").val($("#authTermEndTwo").val() + "0000-00-00 00:00:00");
            }else {
                $("#authTermEndTwo").val($("#authTermEndTwo").val() + " 00:00:00");
            }
            formData = getFormData($("#" + SL241103010.formId));
            $('#main-content').postUrl($("#" + SL241103010.formId).attr("action"),
                formData,
                function (data) {
                    if(data=="1"){
                        $.alertMessage.info("添加成功!");
                    }else{
                        $.alertMessage.info("添加失败!");
                    }
                },{refreshHtml:false});
        });
    },
    agentCheck:function(){
        $("#agentCheck").click(function(){
            $.pdialog.open("查询生产商", Main.contextPath + "/SL24110301001/init", {
                    width: 1000,
                    height: 450
                }
            );
        });
    }
}

$(document).ready(function() {
    SL241103010.init();
});

