/**
 * Created by fjm on 2016/1/30.
 */
var SL24110101001 = {
    formId:"SL24110101001Form",
    saveButton:"SL24110101001_SAVE",
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
        $("#"+SL24110101001.saveButton).click(function(){
            var authTermBeginThree = $("#authTermBeginThree").val();
            if(authTermBeginThree=="" || authTermBeginThree==null){
                $("input[name='authTermBegin']").remove();
                //$("#authTermBeginThree").val($("#authTermBeginThree").val() + "0000-00-00 00:00:00");
            }else {
                $("#authTermBeginThree").val($("#authTermBeginThree").val() + " 00:00:00");
            }
            var authTermEndTwo = $("#authTermEndTwo").val();
            $("input[name='authTermBegin']").remove();
            if(authTermEndTwo=="" || authTermEndTwo==null){
                $("input[name='authTermEnd']").remove();
                //$("#authTermEndTwo").val($("#authTermEndTwo").val() + "0000-00-00 00:00:00");
            }else {
                $("#authTermEndTwo").val($("#authTermEndTwo").val() + " 00:00:00");
            }
            formData = getFormData($("#" + SL24110101001.formId));
            $('#main-content').postUrl($("#" + SL24110101001.formId).attr("action"),
                formData,
                function (data) {
                    if(data=="1"){
                        $.alertMessage.info("添加成功!");
                        $.pdialog.close();
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
                },{flg:1},"showEp"
            );
        });
    }
}

$(document).ready(function() {
    SL24110101001.init();
});

